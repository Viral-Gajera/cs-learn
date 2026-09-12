# Hooks

- With hook, we can use class component features in `functional component` such as state, life cycle methods, pure components etc.
- Because of this, class components are generally no longer needed.

### Hook Rules

- There are 3 rules for hooks:
    - Hooks can only be called inside React function components.
    - Hooks can only be called at the top level of a component.
    - Hooks cannot be conditional.

Note, Hooks will not work in React class components.

- You must `import` Hooks from `react`.
- Hook name starts with `use` prefix.

List of hooks :

```
State Hooks 
- useState
- useReducer

Context Hooks
- useContext

Ref Hooks
- useRef

Effect Hooks 
- useEffect

Performance Hooks
- useMemo
- useCallback

```



## useState hook :

- The React `useState` Hook allows us to track state in a function component.
- The state is a built-in React `object` that is used to contain data or information about the component.
- A component's state can change over time; whenever it changes, the component `re-renders`.

### Initialize useState

- We initialize our state by calling `useState` in our function component.
- `useState` accepts an **initial state** and returns two values:
  
    - The current state.
    - A function that updates the state.
    
    Example :
    
    ```JavaScript
    import { useState } from "react";
    
    function FavoriteColor() {
    
        // Initialize state at the top of the function component
        // let [initialState, updateStateFunc] = useState( initialStateValue )
    
        let [color, setColor] = useState("red");
    
        return (
            <div>
                <h1>My favorite color is {color}!</h1>
                <button type="button" onClick={()=>setColor("blue")} >
                    Blue
                </button>
            </div>
        )
    }
    ```
    
- Notice that again, we are destructuring the returned values from `useState`.
  
    The first value, `color`, is our current state, The second value, `setColor`, is the function that is used to update our state.
    

### Update State

- To update our state, we use our `state updater function`.
- We should never directly update state. Ex: `color = "red"` is not allowed.
- Example of state updater is as above.

### What Can State Hold

- The `useState` Hook can be used to keep track of strings, numbers, booleans, arrays, objects, and any combination of these!
- We could create multiple state Hooks to track individual values.
- Or, we can just use one state and include an object instead!

### Updating Objects and Arrays in State

- When state is updated, the entire state gets overwritten. what if we only want to update the color of our car?
- If we only called `setCar({color: "blue"})`, this would remove the brand, model, and year from our state.
- We can use the JavaScript spread operator to help us.
  
    ```JavaScript
    const updateColor = () => {
        setCar(previousState => {
            return { ...previousState, color: "blue" }
        });
    }
    ```
    

### Accessing previous state

```JavaScript
import React, { useState } from 'react';

function App(){
    const [ count , setCount ] = useState(0);

    function updateCounter(){
        let random = Math.floor(Math.random()*10);

        setCount( function (previousState){
            console.log("This is previous state " + previousState);
            return random;
        } )
    }
    return (
        <button onClick={ updateCounter } >
        	ClickMe
        </button>
    )
}
```

## useEffect hook :

- It is an alternative hook for component life cycle method.
- `useEffect` accepts two arguments. The second argument is optional.
  
    ```Plain
    useEffect( function , [dependency] )
    ```
    
    1. No dependency passed.
       
        ```JavaScript
        useEffect(() => {
          // Runs after every render
        });
        ```
        
    2. An emply array
       
        ```JavaScript
        useEffect(() => {
          // Runs only after the first render
        }, []);
        ```
        
    3. Props or state values
       
        ```JavaScript
        useEffect(() => {
          // Runs after the first render
          // And runs after any time, any dependency value changes
        }, [prop, state]);
        ```
        
    
    Example :
    
    ```JavaScript
    function Section1(){
    
        const [count1, setCount1] = useState(0);
        const [count2, setCount2] = useState(0);
    
        useEffect(() => {
            console.log("Count 1 Incremented");
        }, [count1]);
        // invoked ones even, it is not incremented (after rendered)
    
        useEffect(() => {
            console.log("Count 2 Incremented");
        }, [count2]);
        // invoked ones even, it is not incremented (after rendered)
    
        return (
          <div>
            <h1>The value of count 1 : {count1} </h1>
            <h1>The value of count 2 : {count2} </h1>
            <button onClick={()=>setCount1(count1+1)} >Increment count 1</button>
            <button onClick={()=>setCount2(count2+1)} >Increment count 2</button>
          </div>
        );
    }
    ```
    

## useRef hook :

- The `useRef` Hook allows you to persist values between subsequent renders.
- It can be used to store a mutable value that does not cause a re-render when updated.
- It can be used to access a DOM element directly.

### Does Not Cause Re-renders :

- If we tried to count how many times our application renders using the `useState` Hook, we would be caught in an infinite loop since this Hook itself causes a re-render.
- To avoid this, we can use the `useRef` Hook.
  
    ```JavaScript
    import { useState, useEffect, useRef } from "react";
    import ReactDOM from "react-dom/client";
    
    function App() {
      const [inputValue, setInputValue] = useState("");
      const count = useRef(0);
      // useRef returns object count
      // like, const count = {current: 0}
      // persist values between subsequent renders.
    
      useEffect(() => {
        count.current = count.current + 1;
        // store a mutable value that does not cause a re-render when updated
      });
    
      return (
        <div>
          <input
            type="text"
            value={inputValue}
            onChange={(e) => setInputValue(e.target.value)} />
    
          <h1>Render Count: {count.current}</h1>
        </div>
      );
    }
    ```
    

### Accessing DOM Elements :

- In React, we can add a `ref` attribute to an element to access it directly in the DOM.
  
    ```JavaScript
    import { useRef } from "react";
    import ReactDOM from "react-dom/client";
    
    function App() {
      const inputElement = useRef();
    
      const focusInput = () => {
        inputElement.current.focus();
          // inputElement.current.style.color = "red"
          // inputElement.current.style.display = "none"
      };
    
      return (
        <div>
          <input type="text" ref={inputElement} />
          <button onClick={focusInput}>Focus Input</button>
        </div>
      );
    }
    ```
    

### Tracking previous State Changes :

- The `useRef` Hook can also be used to keep track of previous state values.
- This is because we are able to persist `useRef` values between renders.
  
    ```JavaScript
    import { useState, useEffect, useRef } from "react";
    import ReactDOM from "react-dom/client";
    
    function App() {
      const [inputValue, setInputValue] = useState("");
      const previousInputValue = useRef("");
    
      useEffect(() => {
        previousInputValue.current = inputValue;
      }, [inputValue]);
    
      return (
        <div>
          <input
            type="text"
            value={inputValue}
            onChange={ (e)=>setInputValue(e.target.value) }
          />
          <h2>Current Value: {inputValue} </h2>
          <h2>Previous Value: {previousInputValue.current} </h2>
        </div>
      );
    }
    ```
    

## useMemo hook :

- The useMemo is a hook used in the functional component of react that returns a memorized value.
- Memorization is a concept used in general when we don’t need to recomputed the function with a given argument for the next time as it returns the cached result.
- The `useMemo` Hook only runs when one of its dependencies update.
  
    Example :
    
    - If there is a function to add two numbers, and we give the parameter as 1 and 2 for the first time the function will add these two numbers and return 3, but if the same inputs come again then we will return the cached value
    - i.e 3 and not compute with the add function again.
    
    Syntax :
    
    ```JavaScript
    const memoizedValue = useMemo(functionThatReturnsValue, arrayDepencies)l
    ```
    
    Example :
    
    ```jsx
    import React, { useState, useMemo } from "react";
    
    function App() {
        const [number, setNumber] = useState(0);
        const [counter, setCounter] = useState(0);
    
        // Using useMemo
        const squaredNum = useMemo( () => {
            console.log("Squaring will be done!");
            return ( Math.pow(number, 2) );
        }, [number]);
    
        return (
            <div>
                <input
                    type="number"
                    placeholder="Enter a number"
                    value={number}
                    onChange={ (e)=>{setNumber(e.target.value)} }
                ></input>
                <div>OUTPUT: {squaredNum}</div>
    
                <button onClick={ ()=>{setCounter(counter + 1)} }>
                    Counter ++
                </button>
                <div>Counter : {counter}</div>
            </div>
        );
    }
    ```
    
- Here, squareNum will run only when the number changes. If we increase the counter and the number remains the same in the input field the squareNum doesn’t run again.

## useCallback

- The React `useCallback` Hook returns a memoized callback function.
- The `useCallback` and `useMemo` Hooks are similar.
- The main difference is that `useMemo` returns a memoized _value_ and `useCallback` returns a memoized _function_.
- The `useCallback` Hook only runs when one of its dependencies update.
- This can be useful in scenarios where you need to pass a function as a prop to a child component, and you want to prevent unnecessary re-renders of that child component.
- Example :
  
    ```jsx
    import React, { useState, useCallback } from 'react';
    
    const ExampleComponent = () => {
      const [count, setCount] = useState(0);
    
      /*
      function handleClick() {
      	setCount(count + 1);
      }
      */
    
      // Define a function using useCallback to memoize it
      const handleClick = useCallback(() => {
        setCount(count + 1);
      }, [count]); // Dependency array: re-create the function only when `count` changes
    
      return (
        <div>
          <p>Count: {count}</p>
          {/* Pass the memoized function to a child component */}
          <ChildComponent handleClick={handleClick} />
        </div>
      );
    };
    
    const ChildComponent = ({ handleClick }) => {
      return (
        <button onClick={handleClick}>
          Click me
        </button>
      );
    };
    
    export default ExampleComponent;
    ```
    
- The reason for using `useCallback` with a dependency on `count` is to ensure that the `handleClick` function always has access to the latest `count` value.
- Without specifying `count` in the dependency array, the function `handleClick` would capture the initial value of `count` and would not update even when `count` changes. This could lead to bugs or unexpected behavior.
- If we write
  
    ```JavaScript
    function handleClick() {
      setCount(count + 1);
    }
    ```
    
- This is a simple function declaration without using `useCallback`.
- In this case, every time the `ExampleComponent` re-renders, a new `handleClick` function is created.
- This behavior could potentially lead to unnecessary re-renders of child components that receive this function as a prop.
- Creating a new `handleClick` function on each render in the context of passing it down as a prop to a child component might not necessarily cause the child component to re-render.
- React optimizes and checks for changes in props using a concept called "referential equality."
- When a functional component re-renders, it may recreate functions or objects inside the component body.
- However, React doesn't necessarily trigger a re-render of child components if the props they receive (even if these props are functions) remain the same in terms of referential equality.
- React checks if the reference of the function has changed, not its internal content.
- If the reference of the `handleClick` function remains the same across renders, React won't re-render the child component using that prop because it perceives the prop as unchanged, despite the creation of a new function instance.
- using `useCallback` helps to optimize this process by ensuring that the same function reference is maintained unless its dependencies change, explicitly preventing unnecessary recreations of the function on every render and avoiding potential issues with re-render optimizations in child components.

## useContext

- React Context is a way to manage state globally.
- It can be used together with the `useState` Hook to share state between deeply nested components more easily than with `useState` alone.
- Example :
  
    ```jsx
    import { useState, createContext } from "react";
    import ReactDOM from "react-dom/client";
    
    const UserContext = createContext()
    
    function Component1() {
      const [user, setUser] = useState("Jesse Hall");
    
      return (
        <UserContext.Provider value={user}>
          <h1>{`Hello ${user}!`}</h1>
          <Component2 user={user} />
        </UserContext.Provider>
      );
    }
    
    export { UserContext };
    ```
    
    ```jsx
    import { useState, createContext, useContext } from "react";
    import { UserContext } from "xyz";
    
    function Component5() {
      const user = useContext(UserContext);
    
      return (
        <>
          <h1>Component 5</h1>
          <h2>{`Hello ${user} again!`}</h2>
        </>
      );
    }
    ```
    

## useReducer Hook

- useReducer hook also used to magane state, more suited for managing state objects that contain multiple sub-values.
- It combines the functionalities of the `useState` and `useEffect` hooks by providing a way to update state and handle side effects in a single hook.
- Syntax :
  
    ```js
    function reducer (state, action){
      // Logic to update the state based on the action
      switch (action.type) {
        case 'ACTION_TYPE_1':
          return updatedState1;		// Return the updated state for action type 1
        case 'ACTION_TYPE_2':
          return updatedState2;		// Return the updated state for action type 2
        default:
          return state;				// Return the current state if the action type is not recognized
      }
    };
    
    const [state, dispatch] = useReducer(reducer, initialState);
    ```
    
- Advantage :
    - We can take custom action based on `action.type`.
    - managing state objects that contain multiple sub-values.
- Explanation:
    - The `reducer` function takes two arguments: `state` and `action`.
    - `state` represents the current state value that needs to be updated.
    - `action` is an **object** that describes the action to be performed, typically including a `type` property and additional payload data if needed.
    - Inside the reducer function, you use a `switch` statement to handle different action types and define the corresponding state updates.
    - Each `case` block corresponds to a specific action type, and you return the updated state for that particular action type.
    - If the action type is not recognized (i.e., no matching `case` is found), you can simply return the current state.
    - It's important to always return a new state object from the reducer to ensure proper immutability and avoid unintentional bugs.
- Example :
  
    ```JavaScript
    import React, { useReducer } from 'react';
    
    function reducer (state, action) {
      switch (action.type) {
        case 'increment':
          return { count: state.count + 1 };
        case 'decrement':
          return { count: state.count - 1 };
        case 'reset':
          return { count: 0 };
        default:
          throw new Error('Unsupported action type');
      }
    };
    
    function Counter (){
      const [state, dispatch] = useReducer(reducer, { count: 0 });
    
      return (
        <div>
          <p>Count: {state.count}</p>
          <button onClick={() => dispatch({ type: 'increment' })}>Increment</button>
          <button onClick={() => dispatch({ type: 'decrement' })}>Decrement</button>
          <button onClick={() => dispatch({ type: 'reset' })}>Reset</button>
        </div>
      );
    };
    
    export default Counter;
    ```
    

  

## Custom Hooks:

- A custom Hook is a JavaScript function whose name starts with ”`use`” and that may call other Hooks.

Example :

```Plain
function useHookName( argument ){
	return value;
}

export default useHookName;
```

```Plain
import useHookName form './useHookName.js'

function Comp(){
	let output = useHookName(input);

	return ( ... )
}
```