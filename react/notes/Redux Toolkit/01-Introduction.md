# Slices

- Slice is function which accepts object which contains, Slice name, Initial state, Object of reduce functions.
- And automatically generates action creators and action types that corresponds to the reducers and state.
- `createSlice` automatically generates action creators with the same names as the reducer functions we wrote. 
- We can check that by calling one of them and seeing what it returns:
- Example:

```JavaScript
import { createSlice } from '@reduxjs/toolkit';

const userSlice = createSlice({
    name : "user",
    initalState : [],
    reducers : {
        addUser: (state, action) => {
            state.push(action.payload);
        },
        removeUser: (state, action) => {
            return state.filter((user) => user.id !== action.payload);
        },
        clearAllUser: (state) => {
            return [];
        },
    }
})

console.log(userSlice.actions);
/*
	object of actions creators
	{
		addUser : f actionCreator(),
		removeUser : f actionCreator(),
		clearAllUser : f actionCreator()
	}
*/

console.log(userSlice.reducer);
/*
	ƒ reducer(state, action) {
      if (!_reducer)
        _reducer = buildReducer();
      return _reducer(state, action);
    }
*/

export { userSlice };
```

```JavaScript
/* export, best practice */
export const {addUser, removeUser, clearAllUser} = userSlice.actions
export default userSlice.reducer
```

**Calculating name of Action type:**

- The string from the `name` option is used as the first part of each action type, and the key name of each reducer function is used as the second part.
- So, the `user` name + the `addUser` reducer function generated an action type of `{type: "user/addUser"}`. 
- (After all, why write this by hand if the computer can do it for us!)  


It also generates the slice reducer function that knows how to respond to all these action types:

```JavaScript
const newState = counterSlice.reducer(
  { value: 10 },                                 <- state
  counterSlice.actions.increment()
)
console.log(newState)
// {value: 11}
```

  

# Folder Structure

```JavaScript
store
	-> index.js
	-> slices
			userSlice.js
			adminSlice.js
```

  

# Configure Store

- It uses the low-level Redux core `createStore` method internally.
- A standard Redux store setup typically requires multiple pieces of configuration:
    - Combining the slice reducers into the root reducer.
    - Creating the middleware enhancer, usually with the thunk middleware or other side effects middleware, as well as middleware that might be used for development checks
    - Adding the Redux DevTools enhancer, and composing the enhancers together
    - Calling `createStore`.
- Example:

```JavaScript
import { configureStore } from '@reduxjs/toolkit';
import { useSlice } from './slices/userSlice.js';

const store = configureStore({
    reducer:{
        users: userSlice.reducer,		// (not 'reducers')
        admins: adminSlice.reducer
        .
        .
        .
        /* Importent */
        /* state is created of this name 'users' inside global state object */
    }
})

export default store;
```

  

# Updating data to Store

- `useDispatch()` hook is used to upadate data to store.
- Example:

```JavaScript
import Chance from "chance";
import { useDispatch } from "react-redux";
import { userSlice } from "./store/slices/userSlice";

let chance = new Chance();
// for random name

function App() {
    const dispatch = useDispatch();

    return (
        <button
            className="px-3 py-1 font-semibold text-white rounded gradient-1"
            onClick={() => dispatch(userSlice.actions.addUser(chance.name()))}
        >
            Add new Users
        </button>
    );
}
```

# Accession Data

- `useSelector()` hook is used to access data from the redux store.
- Example:

```JavaScript
import Chance from "chance";
import { useDispatch, useSelector } from "react-redux";
import { userSlice } from "./store/slices/userSlice";

// for generating random name
let chance = new Chance();

function App() {
    const dispatch = useDispatch();
    const users = useSelector((state) => state.users);

    /*
    	const state = useSelector( state => state);
    	clg(state);
    */

    return (
        <button
            className="px-3 py-1 font-semibold text-white rounded gradient-1"
            onClick={() => dispatch(userSlice.actions.addUser(chance.name()))}
        >
            Add new Users
        </button>
    );
}
```

- Note: (state) => state.users this function called `selector function`.


Q. If we have multiple reduce function with same name in different slice,

```JavaScript
userSlice/reduces/addUser()
adminSlice/reduces/addUser()
```

and if with dispath action

```JavaScript
dispatch(userSlice.actions.addUser(chance.name()))
```

Then what will happens ? do both `addUser()` reduce called ?

Answer : No, only calls useSlice reducer called.