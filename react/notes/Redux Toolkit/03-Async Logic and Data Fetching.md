# Writing Async Logic with Thunks

- A **thunk** is a specific kind of Redux function that can contain asynchronous logic. 
- Thunks are written using two functions:
    - An inside thunk function, which gets `dispatch` and `getState` as arguments.
    - The outside creator function, which creates and returns the thunk function.
Example:

```JavaScript
export function incrementAsync() 
{
	return async function (dispatch, getState) 
	{
	    let data = await fetch('');
	    // Yay! Can invoke sync or async actions with `dispatch`
	    dispatch({
	        type: INCREMENT_COUNTER
	        payload : data
	    })
	}
}
```

- We can use them the same way we use a typical Redux action creator:

```JavaScript
store.dispatch(incrementAsync(5))
```

- However, using thunks requires that the `redux-thunk` _middleware_ (a type of plugin for Redux) be added to the Redux store when it's created.
- Fortunately, Redux Toolkit's `configureStore` function already sets that up for us automatically, so we can go ahead and use thunks here.

Example:

- When you need to make AJAX calls to fetch data from the server, you can put that call in a thunk. 
- Here's an example that's written a bit longer, so you can see how it's defined:

```JavaScript
function fetchUserById(userId) {                                 <- Action creator
    return async function thunk(dispatch, getState) {            <- Thunk function
        try {
            const user = await userAPI.fetchById(userId);
            dispatch(userLoaded(user));
        } catch (err) {
            // If something went wrong, handle it here
        }
    };
}
```

  
# Thunk Function

- A thunk function will always be called with `(dispatch, getState)` as its arguments, and you can use them inside the thunk as needed.
- Once the thunk middleware has been added to the Redux store, it allows you to pass _thunk functions_ directly to `store.dispatch`.
- Thunks typically dispatch plain actions using action creators, like `dispatch(increment())`:

Example:
Assume `counterSlice` slice has `increment()` reducer.

```JavaScript
const store = configureStore({ reducer: counterSlice.reducer })

const exampleThunkFunction = (dispatch, getState) => {
  const stateBefore = getState()
  console.log(`Counter before: ${stateBefore.counter}`)
  
  dispatch(increment())             
  
  const stateAfter = getState()
  console.log(`Counter after: ${stateAfter.counter}`)
}

store.dispatch(exampleThunkFunction)
```

- Note: We can directly pass thunk function to `store.dispatch()`.
- Note: Action creator not require always.
- Note: Action creator require if we want to pass data.
- Note: These action creator also called `thunk action creators`.

Example:

```JavaScript
function logAndAdd (amount) {                  <- action creator / thunk action creator
  return function (dispatch, getState) {       <- thunk function
    const stateBefore = getState()
    console.log(`Counter before: ${stateBefore.counter}`)
    dispatch(incrementByAmount(amount))
    const stateAfter = getState()
    console.log(`Counter after: ${stateAfter.counter}`)
  }
}

store.dispatch(logAndAdd(5))
```

Note:
- Thunks are typically written in "slice" files. 
- `createSlice` itself does not have any special support for defining thunks, so you should write them as separate functions in the same slice file.
- That way, they have access to the plain action creators for that slice, and it's easy to find where the thunk lives.

# createAsyncThunk

- If we were to write out the code for a typical async thunk by hand, it might look like this:

```JavaScript
const getRepoDetailsStarted = () => ({
  type: 'repoDetails/fetchStarted'
})
const getRepoDetailsSuccess = repoDetails => ({
  type: 'repoDetails/fetchSucceeded',
  payload: repoDetails
})
const getRepoDetailsFailed = error => ({
  type: 'repoDetails/fetchFailed',
  error
})

const fetchIssuesCount = function (org, repo) {
	return async function (dispatch) {
		dispatch(getRepoDetailsStarted())
		try {
			const repoDetails = await getRepoDetails(org, repo)
			dispatch(getRepoDetailsSuccess(repoDetails))
		} catch (err) {
		    dispatch(getRepoDetailsFailed(err.toString()))
		}
	}
}
```

- However, writing code using this approach is tedious.
- `createAsyncThunk` abstracts this pattern by generating the action types and action creators, and generating a thunk that dispatches those actions automatically.
- You provide a callback function that makes the async call and returns a Promise with the result.


**Important :**

- `createAsyncThunk` accepts a "payload creator" callback. 
- That should return a `Promise`, and generates `pending/fulfilled/rejected` action types automatically.
- What payload creator callback return (promise), that will be the input to action.payload inside `builder.addCase(actionCreator, (state,action)=>{} )` (automatically unwrap promise)
- We dont need to use `await` to extract the value.


- Redux Toolkit's `createAsyncThunk` API generates thunks that automatically dispatch those "start/success/failure" actions for you.

Example:

```JavaScript
import { createSlice, nanoid, createAsyncThunk } from '@reduxjs/toolkit'
import { client } from '../../api/client'

const initialState = {
  posts: [],
  status: 'idle',
  error: null
}

export const fetchPosts = createAsyncThunk('posts/fetchPosts', async () => {
  const response = await client.get('/fakeApi/posts')
  return response.data
})
```

`createAsyncThunk` accepts two arguments:

- A string that will be used as the prefix for the generated action types
- A "payload creator" callback function that should return a `Promise` containing some data, or a rejected `Promise` with an error

- In this case, we pass in `'posts/fetchPosts'` as the action type prefix.
- Our payload creation callback waits for the API call to return a response. The response object looks like `{data: []}`, and we want our dispatched Redux action to have a payload that is _just_ the array of posts. So, we extract `response.data`, and return that from the callback.  

- If we try calling `dispatch(fetchPosts())`, the `fetchPosts` thunk will first dispatch an action type of `'posts/fetchPosts/pending'`
- Once the `Promise` resolves, the `fetchPosts` thunk takes the `response.data` array we returned from the callback, and dispatches a `'posts/fetchPosts/fulfilled'` action containing the posts array as `action.payload`:

### Dispatching Thunks from Components

- We'll import the `fetchPosts` thunk into the component.
- Like all of our other action creators, we have to dispatch it, so we'll also need to add the `useDispatch` hook.

```JavaScript
import React, { useEffect } from 'react'
import { useSelector, useDispatch } from 'react-redux'
// omit other imports
import { selectAllPosts, fetchPosts } from './postsSlice'

export const PostsList = () => {
  const dispatch = useDispatch()
  const posts = useSelector(selectAllPosts)

  const postStatus = useSelector(state => state.posts.status)

  useEffect(() => {
    if (postStatus === 'idle') {
      dispatch(fetchPosts())                        <- 
    }
  }, [postStatus, dispatch])

  // omit rendering logic
}
```

- It's important that we only try to fetch the list of posts once.
- If we do it every time the `<PostsList>` component renders, or is re-created because we've switched between views, we might end up fetching the posts several times.
- We can use the `posts.status` enum to help decide if we need to actually start fetching, by selecting that into the component and only starting the fetch if the status is `'idle'`.

  

### extraReducer

- We've already seen that `createSlice` will generate an action creator for every reducer function we define in the `reducers` field, and that the generated action types include the name of the slice, like:

```JavaScript
/*
 * postUpdated <- action creator
 */

console.log(
  postUpdated({ id: '123', title: 'First Post', content: 'Some text here' })
)
/*
{
  type: 'posts/postUpdated',
  payload: {
    id: '123',
    title: 'First Post',
    content: 'Some text here'
  }
}
*/
```

- However, there are times when a slice reducer needs to respond to _other_ actions that weren't defined as part of this slice's `reducers` field.
- We can do that using the slice `extraReducers` field instead.

  

- The `extraReducers` option should be a function that receives a parameter called `builder`. The `builder` object provides methods that let us define additional case reducers that will run in response to actions defined outside of the slice.
- We'll use `builder.addCase(actionCreator, reducer)` to handle each of the actions dispatched by our async thunks.
- In this case, we need to listen for the "pending" and "fulfilled" action types dispatched by our `fetchPosts` thunk.
- Those action creators are attached to our actual `fetchPost` function, and we can pass those to `extraReducers` to listen for those actions:

```JavaScript
export const fetchPosts = createAsyncThunk('posts/fetchPosts', async () => {
  const response = await client.get('/fakeApi/posts')
  return response.data
})

const postsSlice = createSlice({
  name: 'posts',
  initialState,
  reducers: {
    // omit existing reducers here
  },
  extraReducers(builder) {
    builder
      .addCase(fetchPosts.pending, (state, action) => {
        state.status = 'loading'
      })
      .addCase(fetchPosts.fulfilled, (state, action) => {
        state.status = 'succeeded'
        state.posts = state.posts.concat(action.payload)
        // action.payload <- value return by createAsyncThunk payload creator
        // payload creator will return promise
        // it is automatically unwarp
      })
      .addCase(fetchPosts.rejected, (state, action) => {
        state.status = 'failed'
        state.error = action.error.message
        // same here 
        // it is automatically unwarp
      })
  }
})
```

We'll handle all three action types that could be dispatched by the thunk, based on the `Promise` we returned:

- When the request starts, we'll set the `status` enum to `'loading'`
- If the request succeeds, we mark the `status` as `'succeeded'`, and add the fetched posts to `state.posts`
- If the request fails, we'll mark the `status` as `'failed'`, and save any error message into the state so we can display it

  

  

## Checking Thunk Results in Components

- `unwrap()` method
- Example:

```JavaScript
export const addNewPost = createAsyncThunk(
	'posts/addNewPost',
	// The payload creator receives the partial `{title, content, user}` object
	async initialPost => {
	    // We send the initial data to the fake API server
	    const response = await client.post('/fakeApi/posts', initialPost)
	    // The response includes the complete post object, including unique ID
	    return response.data
	}
)

const postsSlice = createSlice({
	name: 'posts',
	initialState,
	reducers: {
	    // The existing `postAdded` reducer and prepare callback were deleted
	    reactionAdded(state, action) {}, // omit logic
	    postUpdated(state, action) {} // omit logic
	},
	extraReducers(builder) {
	    // omit posts loading reducers
	    builder.addCase(addNewPost.fulfilled, (state, action) => {
		    // We can directly add the new post object to our posts array
		    state.posts.push(action.payload)
	    })
	}
})
```

```JavaScript
import React, { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'

import { addNewPost } from './postsSlice'

export const AddPostForm = () => {
	const [title, setTitle] = useState('')
	const [content, setContent] = useState('')
	const [userId, setUserId] = useState('')
	const [addRequestStatus, setAddRequestStatus] = useState('idle')
	
	// omit useSelectors and change handlers
	
	const canSave =
	    [title, content, userId].every(Boolean) && addRequestStatus === 'idle'
	    
	const onSavePostClicked = async () => {
	    if (canSave) {
			try {
		        setAddRequestStatus('pending')
		        await dispatch(addNewPost({ title, content, user: userId })).unwrap()
		        setTitle('')
		        setContent('')
		        setUserId('')
		    } catch (err) {
			    console.error('Failed to save the post: ', err)
		    } finally {
		        setAddRequestStatus('idle')
		    }
	    }
	}
	// omit rendering logic
}
```

- When we call `dispatch(addNewPost())`, the async thunk returns a `Promise` from `dispatch`. We can `await` that promise here to know when the thunk has finished its request. But, we don't yet know if that request succeeded or failed.
- `createAsyncThunk` handles any errors internally, so that we don't see any messages about "rejected Promises" in our logs. It then returns the final action it dispatched: either the `fulfilled` action if it succeeded, or the `rejected` action if it failed.
- However, it's common to want to write logic that looks at the success or failure of the actual request that was made. Redux Toolkit adds a `.unwrap()` function to the returned `Promise`, which will return a new `Promise` that either has the actual `action.payload` value from a `fulfilled` action, or throws an error if it's the `rejected` action. This lets us handle success and failure in the component using normal `try/catch` logic. So, we'll clear out the input fields to reset the form if the post was successfully created, and log the error to the console if it failed.  

Summary:
- Thunks can return promises. For createAsyncThunk specifically, you can `await dispatch(someThunk()).unwrap()` to handle the request success or failure at the component level.

## Thunk Argument

- For `createAsyncThunk` specifically, you can only pass in **one** argument, 
- And whatever we pass in becomes the first argument of the payload creation callback.
- The second argument to our payload creator is a `thunkAPI` object containing several useful functions and pieces of information:
	
	- `dispatch` and `getState`:
		The actual `dispatch` and `getState` methods from our Redux store. You can use these inside the thunk to dispatch more actions, or get the latest Redux store state (such as reading an updated value after another action is dispatched).
		
	- `extra`:
	    The "extra argument" that can be passed into the thunk middleware when creating the store. This is typically some kind of API wrapper, such as a set of functions that know how to make API calls to your application's server and return data, so that your thunks don't have to have all the URLs and query logic directly inside.
	    
	- `requestId`:    
	    A unique random ID value for this thunk call. Useful for tracking status of an individual request.
	    
	- `signal`:    
	    An `AbortController.signal` function that can be used to cancel an in-progress request.
	    
	- `rejectWithValue`:
	    a utility that helps customize the contents of a `rejected` action if the thunk receives an error. 

- If you're writing a thunk by hand instead of using `createAsyncThunk`, the thunk function will get`(dispatch, getState)` as separate arguments, instead of putting them together in one object.