# Preparing Action Payload

Consider social media post which has id, title, content.

- We can create slice for the like this
- Example:

```JavaScript
const initialState = [
  { id: '0', name: 'Tianna Jenkins' },
  { id: '1', name: 'Kevin Grant' },
  { id: '2', name: 'Madison Price' }
]
const postsSlice = createSlice({
  name: 'posts',
  initialState,
  reducers: {
    postAdded(state, action) {
      state.push(action.payload)
    }
  }
})

export const { postAdded } = postsSlice.actions
export default postsSlice.reducer
```

- And if we want to dispatch action, we do

```JavaScript
dispatch(postAdded({
	id: nanoid(),
	title,
	content
}))
```

- Problem with this that we that to create object {id, title, content} each time we want to dispatch action.

  

Solution:

- Inside `postAdded` reduce add two function `reducer` and `prepare`.
- Example:

```JavaScript
const postsSlice = createSlice({
  name: 'posts',
  initialState,
  reducers: {
    postAdded: {
      reducer(state, action) {
        state.push(action.payload)
      },
      prepare(title, content) {
        return {
          payload: {
            id: nanoid(),
            title,
            content
          }        }
      }
    }
    // other reducers here
  }
})
```

- Now we can dispatch action like this

```JavaScript
dispatch(postAdded(title, content))
```

- Now our component doesn't have to worry about what the payload object looks like - the action creator will take care of putting it together the right way.
- So, we can update the component so that it passes in `title` and `content` as arguments when it dispatches `postAdded`: