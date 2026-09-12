# Redux Toolkit Reference

Reducer & Action setup

```jsx
createSlice({name, initialState, reducers, extraReducers, reducerPath, selectors})

createAsyncThunk(name, callback)                    
// Ex.
// export const fetchPosts = createAsyncThunk("posts/fetchPosts", async () => {
//     const response = await client.get("/fakeApi/posts");
//     return response.data;
// });

createSelector(inputSelectors, resultFunc)          
// Ex.
// export const selectAllPosts = (state) => state.posts.posts;
// export const selectPostById = (state, postId) => state.posts.posts.find((post) => post.id === postId);
//
// export const selectPostsByUser = createSelector(
//     [
//       selectAllPosts,
//       (state, userId) => userId
//     ],
//     (posts, userId) => posts.filter((post) => post.user === userId)
// );
//
// let userPost = useSelector((state) => selectPostsByUser(state, userId));

createEntityAdapter({sortComparer})                 
// { ids: [], entities: {} }
// Ex.
// const postsAdapter = createEntityAdapter({
//     sortComparer: (a, b) => b.date.localeCompare(a.date),
// });
// 
// const initialState = postsAdapter.getInitialState({
//     status: "idle",
//     error: null,
// });

createAction(type, prepareAction?)                  
// defining a Redux action type and creator
// Ex. 
// const increment = createAction('increment')
// const decrement = createAction('decrement')
			 
createReducer(initalstate, (builder)=>{})           
// to create reducer function
// Ex.
// createReducer(0, (builder) =>  
//   builder
//    .addCase(increment, (state, action) => {})  
//    .addCase(decrement, (state, action) => {}),  
// )

combineSlices(slices | reducer-map-objects)         
// returns a reducer function
// Ex. 
// const stringSlice = createSlice({})
// const numberSlice = createSlice({})
// const booleanReducer = createReducer(false, () => {})
// const api = createApi(/*  */)
// 
// const combinedReducer = combineSlices(
//   stringSlice,
//   {
//     num: numberSlice.reducer,
//     boolean: booleanReducer,
//   },
//   api,
// )

combineReducer({reducer1,reducer2,...})                         
// same as redux

```

Store setup

```tsx
configureStore({reducer, middleware, devTools, preloadedState, enhancers})
```


Other

```tsx
createListenerMiddleware

nanoid()
unwrap()                                            // used while dispatching async thunk from component
```

# RTK Query

```jsx
createApi({baseQuery, endpoints, reducerPath})
fetchBaseQuery({baseUrl})
<ApiProvider />

selectFromResult()
onQueryStarted()
```

Other

```jsx
setupListeners()               // A utility used to enable refetchOnMount and refetchOnReconnect behaviors.
```