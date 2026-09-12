
# Memorizing Selector Functions

- Consider below selector function

```JavaScript
const counter = useSelector(state=>state.counter)
```

- This selector function executes each time, value inside the store changes, even in other slice.
- Which makes our component re-render, that might we dont want.
- `useSelector` **always returns a new reference, and so our component will re-render after every action even if the corresponding data hasn't changed!**.


### Problem:

- In a Redux application, as your state becomes more complex, you might end up with multiple reducers that compute derived data or perform calculations based on the state.
- However, recalculating this derived data every time an action is dispatched can be inefficient and lead to unnecessary recomputations.

### Solution:

- User `createSelector`, to efficiently compute derived data from the Redux state. 
- It's part of the `@reduxjs/toolkit` library.

### Method Signature:

```Typescript
createSelector(
  inputSelectors: Array<Function>,
  resultFunc: Function
)
```

### Explanation:

1. `inputSelectors` **(Array of Functions):**
    - These are the selectors that define the input data for your derived selector. 
    - Each function takes the Redux state as an argument and extracts a specific piece of data.
    - These input selectors can be either simple ones that extract a single field or complex ones that compute something more advanced.
2. `resultFunc` **(Function):**
    - This function takes the outputs of the input selectors as arguments and computes the final derived data.
    - It's called whenever any of the input selectors return a new value.

### Example:

- Let's say you have a Redux state that includes information about users and posts, and you want to create a selector that computes the total number of posts for a specific user.
- By using `**createSelector**`, you ensure that the computation of the total posts only happens when necessary (e.g., when the user ID or the list of posts changes), optimizing the performance of your application.

```JavaScript
import { createSelector } from '@reduxjs/toolkit';

// Input Selectors
const getUserId = (state) => state.user.id;
const getPosts = (state) => state.posts;

// Derived Selector
const getTotalPostsForUser = createSelector(
  [getUserId, getPosts],
  (userId, posts) => {
    const userPosts = posts.filter((post) => post.userId === userId);
    return userPosts.length;
  }
);
```

In this example:

- `getUserId` extracts the user ID from the state.
- `getPosts` extracts the posts from the state.
- `getTotalPostsForUser` is the derived selector that calculates the total number of posts for the specific user using the results of the input selectors.

Dispatching `getTotalPostsForUser` user useDispatch

```JavaScript
const totalPostsForUser = useSelector(getTotalPostsForUser);
```

- Yes, you can use `useSelector(getTotalPostsForUser)` directly without explicitly passing the state parameter.
- No need to write like this

```JavaScript
const totalPostsForUser = useSelector(state => getTotalPostsForUser(state));
```

Note:

- Avoid creating new object/array references inside of `useSelector` - those will cause unnecessary re-renders

  

## Passing arguments

- Let's make a new `selectPostsByUser` selector function.
- Example:

```JavaScript
import { createSlice, createAsyncThunk, createSelector } from '@reduxjs/toolkit'

// omit slice logic
// posts array of posts []
export const selectAllPosts = state => state.posts.posts

export const selectPostById = (state, postId) =>
  state.posts.posts.find(post => post.id === postId)

export const selectPostsByUser = createSelector(
  [selectAllPosts, (state, userId) => userId],
  (posts, userId) => posts.filter(post => post.user === userId)
)
```

```JavaScript
let userPost = useSelector(state => selectPostsByUser(state, userId))
```

- `createSelector` takes one or more "input selector" functions as argument, plus an "output selector" function.
- When we call `selectPostsByUser(state, userId)`, `createSelector` will pass all of the arguments into each of our input selectors.
- Whatever those input selectors return becomes the arguments for the output selector.

  

- In this case, we know that we need the array of all posts and the user ID as the two arguments for our output selector.
- We can reuse our existing `selectAllPosts` selector to extract the posts array.
- Since the user ID is the second argument we're passing into `selectPostsByUser`, we can write a small selector that just returns `userId`.

  

- Our output selector then takes `posts` and `userId`, and returns the filtered array of posts for just that user.
- If we try calling `selectPostsByUser` multiple times, it will only re-run the output selector if either `posts` or `userId` has changed:

```JavaScript
const state1 = getState()

// Output selector runs, because it's the first call
selectPostsByUser(state1, 'user1')
// Output selector does _not_ run, because the arguments haven't changed
selectPostsByUser(state1, 'user1')
// Output selector runs, because `userId` changed
selectPostsByUser(state1, 'user2')

dispatch(reactionAdded())
const state2 = getState()
// Output selector does not run, because `posts` and `userId` are the same
selectPostsByUser(state2, 'user2')

// Add some more posts
dispatch(addNewPost())
const state3 = getState()
// Output selector runs, because `posts` has changed
selectPostsByUser(state3, 'user2')
```

  

# Normalized State Structure

- Suppose we have users slice that stores data of user in array

```JavaScript
initialState = [
	{id1, firstName, lastName},
	{id2, firstName, lastName},
	{id3, firstName, lastName},
]

let usersSlice = createSlice({})
```

- Problem: if we want to find details of perticular user we need to traverse entire array.
- Solution:

```JavaScript
initialState = {
    ids: ["user1", "user2", "user3"],
    entities: {
      "user1": {id: "user1", firstName, lastName},
      "user2": {id: "user2", firstName, lastName},
      "user3": {id: "user3", firstName, lastName},
    }
}
```

- This makes it easy to find a particular `user` object by its ID, without having to loop through all the other user objects in an array:

```JavaScript
const userId = 'user2'
const userObject = state.users.entities[userId]
```

  
# **createEntityAdapter**

- Redux Toolkit's `createEntityAdapter` API provides a standardized way to store your data in a slice by taking a collection of items and putting them into the shape of `{ ids: [], entities: {} }`.
- Along with this predefined state shape, it generates a set of reducer functions and selectors that know how to work with that data.  
  
- This has several benefits:
    - We don't have to write the code to manage the normalization ourselves
    - `createEntityAdapter`'s pre-built reducer functions handle common cases like "add all these items", "update one item", or "remove multiple items"
    - `createEntityAdapter` can keep the ID array in a sorted order based on the contents of the items, and will only update that array if items are added / removed or the sorting order changes.

- `createEntityAdapter` accepts an options object that may include a `sortComparer` function, which will be used to keep the item IDs array in sorted order by comparing two items (and works the same way as `Array.sort()`).

- It returns an object that contains [a set of generated reducer functions for adding, updating, and removing items from an entity state object](https://redux-toolkit.js.org/api/createEntityAdapter#crud-functions).
- These reducer functions can either be used as a case reducer for a specific action type, or as a "mutating" utility function within another reducer in `createSlice`.
- The adapter object also has a `getSelectors` function. You can pass in a selector that returns this particular slice of state from the Redux root state, and it will generate selectors like `selectAll` and `selectById`.

- Finally, the adapter object has a `getInitialState` function that generates an empty `{ids: [], entities: {}}` object. 
- You can pass in more fields to `getInitialState`, and those will be merged in.        

Example:

```JavaScript
import { createEntityAdapter } from '@reduxjs/toolkit'

const postsAdapter = createEntityAdapter({
  sortComparer: (a, b) => b.date.localeCompare(a.date)
})

const initialState = postsAdapter.getInitialState({
  status: 'idle',
  error: null
})

const postsSlice = createSlice({
  name: 'posts',
  initialState,
  reducers: {
    reactionAdded(state, action) {
      const { postId, reaction } = action.payload
      const existingPost = state.entities[postId]
      if (existingPost) {
        existingPost.reactions[reaction]++
      }
    },
    postUpdated(state, action) {
      const { id, title, content } = action.payload
      const existingPost = state.entities[id]
      if (existingPost) {
        existingPost.title = title
        existingPost.content = content
      }
    }
  },
  extraReducers(builder) {
    builder
      .addCase(fetchPosts.fulfilled, (state, action) => {
        state.status = 'succeeded'
        // Add any fetched posts to the array
        // Use the `upsertMany` reducer as a mutating update utility
        postsAdapter.upsertMany(state, action.payload)
      })
      // Use the `addOne` reducer for the fulfilled case
      .addCase(addNewPost.fulfilled, postsAdapter.addOne)
  }
})

export const { postAdded, postUpdated, reactionAdded } = postsSlice.actions
export default postsSlice.reducer

// Export the customized selectors for this adapter using `getSelectors`
export const {
  selectAll: selectAllPosts,
  selectById: selectPostById,
  selectIds: selectPostIds
  // Pass in a selector that returns the posts slice of state
} = postsAdapter.getSelectors(state => state.posts)

export const selectPostsByUser = createSelector(
  [selectAllPosts, (state, userId) => userId],
  (posts, userId) => posts.filter(post => post.user === userId)
)
```


Summary:
- Redux Toolkit's `createEntityAdapter` API helps manage normalized data in a slice.
- Normalized state shape usually looks like `{ids: [], entities: {}}` , we can also add new fields by passing object to `adapter.getInitialState({})`.
- Item IDs can be kept in sorted order by passing in a `sortComparer` option
- The adapter object includes:
    - `adapter.getInitialState`, which can accept additional state fields like loading state.
    - Prebuilt reducers for common cases, like `setAll`, `addMany`, `upsertOne`, and `removeMany`.
    - `adapter.getSelectors`, which generates selectors like `selectAll`, `selectById` and `selectIds`.
