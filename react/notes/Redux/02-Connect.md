
# connect() Function

- The `connect` function is an alternative way to connect Redux store to your components.
- React components need to be connected to Redux to access the state and dispatch actions (access with the help of props). React-Redux provides the `connect()` function for this purpose.
- To connect a component:
  
    1. Import the `connect()` function:
    
    ```Plain
    import { connect } from 'react-redux';
    ```
    
    1. Define a `mapStateToProps` function to specify which parts of the state the component needs:
    
    ```JavaScript
    function mapStateToProps(state) {
        return {
            state: state	// entire state
        };
    }
    
    
    function mapStateToProps(state) {
        return {
            state: state.counter
        };
    }
    ```
    
    1. Define a `mapDispatchToProps` object or function to specify the action creators the component needs:
    
    ```JavaScript
    function mapDispatchToProps(dispatch) {
        return {
            increment: (payload) => dispatch({type: "INCREMENT", payload: payload || 1}),
            decrement: (payload) => dispatch({type: "DECREMENT", payload: payload || 1}),
        };
    }
    ```
    
    ```JavaScript
    import { increment, decrement } from "./redux/actions/action.js";
    
    function mapDispatchToProps(dispatch) {
        return {
            increment: (payload) => dispatch(increment(payload)),
            decrement: (payload) => dispatch(decrement(payload)),
        };
    }
    ```
    
    ```JavaScript
    // action.js
    
    export function increment(payload) {
        return {
            type: "INCREMENT",
            payload: payload || 1,
        };
    }
    
    export function decrement(payload) {
        return {
            type: "DECREMENT",
            payload: payload || 1,
        };
    }
    ```
    
    - `increment(payload)` or `decrement(payload)` is an action creator function. It is a function that creates and returns an action object.
    
    1. Use the `connect()` function to connect the component:
    
    ```JavaScript
    export default connect(mapStateToProps, mapDispatchToProps)(MyComponent);
    ```
    

### Using Redux State in React Components

- Once a component is connected to Redux, it can access the state as props:
  
    ```jsx
    import { connect } from "react-redux";
    import { increment, decrement } from "./redux/actions/action";
    
    function App(props) {
        console.log(props);
        /*
        	{
        		state : {
        			counter : 0
        		}
        		decrement : (payload) => {…}
        		increment : (payload) => {…}
        	}
        */
    
        return (
            <div className="bg-blue-600 h-[100vh] text-white flex items-center justify-center">
                <div>
                    <div className="font-bold text-center text-9xl">
                        {props.state.counter}
                    </div>
                    <div className="flex gap-10 mt-10">
                        <button
                            className="py-1 text-gray-600 bg-white rounded px-7 active:scale-95"
                            onClick={() => props.increment(1)}
                        >
                            +
                        </button>
                        1
                        <button
                            className="py-1 text-gray-600 bg-white rounded px-7 active:scale-95"
                            onClick={() => props.decrement(1)}
                        >
                            -
                        </button>
                    </div>
                    <div className="flex gap-10 mt-10">
                        <button
                            className="py-1 text-gray-600 bg-white rounded px-7 active:scale-95"
                            onClick={() => props.increment(5)}
                        >
                            +
                        </button>
                        5
                        <button
                            className="py-1 text-gray-600 bg-white rounded px-7 active:scale-95"
                            onClick={() => props.decrement(5)}
                        >
                            -
                        </button>
                    </div>
                </div>
            </div>
        );
    }
    
    function mapStateToProps(state) {
        return {
            state: state,
        };
    }
    
    function mapDispatchToProps(dispatch) {
        return {
            increment: (payload) => dispatch(increment(payload)),
            decrement: (payload) => dispatch(decrement(payload)),
        };
    }
    
    export default connect(mapStateToProps, mapDispatchToProps)(App);
    ```
    
    ```JavaScript
    // action.js
    
    export function increment(payload) {
        return {
            type: "INCREMENT",
            payload: payload || 1,
        };
    }
    
    export function decrement(payload) {
        return {
            type: "DECREMENT",
            payload: payload || 1,
        };
    }
    ```
    
    ```JavaScript
    // store.js
    
    import { createStore, combineReducers } from "redux";
    
    const rootReducer = combineReducers({
        counter,
    });
    
    const store = createStore(rootReducer);
    
    export default store;
    
    function counter(state = 0, action) {
        switch (action.type) {
            case "INCREMENT":
                return state + action.payload;
            case "DECREMENT":
                return state - action.payload;
            default:
                return state;
        }
    }
    ```
    

### Dispatching Redux Actions

- To dispatch actions from a connected component, use the `dispatch()` function:
  
    ```JavaScript
    function MyComponent({ increment }) {
        const handleIncrement = () => {
            increment(1);
        };
    
        return (
            <div>
                <button onClick={handleIncrement}>Increment</button>
            </div>
        );
    }
    ```
    
- When the prop is used, such as `incrementCounter(1)`, it dispatches the action to increment the counter by the specified amount.