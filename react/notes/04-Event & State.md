## Event Handling

- Handling events with React elements is very similar to handling events on DOM elements.
- There are some syntax differences:
    - React events are named using `camelCase`, rather than lowercase.
    - With JSX you pass a function as the event handler, rather than a string.

For example, the HTML :

```html
<button onclick="myHandler()">
  Click
</button>
```

is slightly different in React :

```jsx
function Comp(){

    function myHandler(eventObj){
        // body
    }

    return (<button onClick={myHandler}>
        Click
    </button>);
}
```

- Here, `eventObj` is a synthetic event. React events do not work exactly the same as native events.

## State

### Why state required ?

- Let's take one example...
  
    ```jsx
    let counter = 0;
    
    function Comp(){
    
        let upHandler = function () {
            counter ++ ;
        }
        let downHandler = function () {
            counter -- ;
        }
    
        return (
            <div>
                <button onClick={upHandler} className="px-2 m-1 text-white border" >
                    Up
                </button>
                <button onClick={downHandler} className="px-2 m-1 text-white border" >
                    Down
                </button>
                <p className="text-white" >
                    {counter}
                </p>
            </div>
        );
    }
    ```
    
    By clicking `Up` or `Down` button the click handler changes the value of `counter` but it does not changes the value in DOM, because Component only renders once.
    

### What is state?

- The state is a built-in React `object` that is used to contain data or information about the component.
- A component's state can change over time; whenever it changes, the component `re-renders`.

### State with Functional Component

```jsx
import { useState } from 'react';

function Comp(){

    const [ counter, updateCounter ] = useState(0);

    let upHandler = function () {
        updateCounter(counter+1);
    }
    let downHandler = function () {
        updateCounter(counter-1);
    }

    return (
        <div>
            <button onClick={upHandler}>
                Up
            </button>
            <button onClick={downHandler}>
                Down
            </button>
            <p>
                Counter : {counter}
            </p>
        </div>
    );
}
```

### State with Class Component :

- The `state` object is initialized in the constructor.
- The `state` object can contain as many properties as you like.
- Refer to the `state` object anywhere in the component by using the `this.state.propertyname` syntax.
- To change a value in the state object, use the `this.setState( { property : newValue } )` method.
- When a value in the `state` object changes, the component will re-render, meaning that the output will change according to the new value(s).

```JavaScript
import React from 'react';

class Comp extends React.Component {
    constructor(props){
        super(props);    // passing props to base constructor.
        this.state = {
            counter: 0
        }
        this.upHandler = this.upHandler.bind(this);
        this.downHandler = this.downHandler.bind(this);
    }
    upHandler(){
        this.setState({ counter : (this.state.counter+1) })
        console.log(this.state.counter);
    }
    downHandler(){
        this.setState({ counter : (this.state.counter-1) })
        console.log(this.state.counter);
    }

    render(){
        return (
            <div className='text-2xl text-white'>
                {this.state.counter}
                <button onClick={this.upHandler} className="border" >Up</button>
                <button onClick={this.downHandler} className="border" >Down</button>
            </div>
        );
    }
}
```

### Lifting state up

- This concept used to send data child to parent components.

Parent conponents :

```jsx
function Parent()
{
    function getData(data){
        console.log(data);
    }
    return (
        <div>
            <Child getData={getData} >
        </div>
    )
}
```

Child components :

```jsx
function Child(props)
{
    return(
        <div>
            <button onClick={ ()=>props.getData("Viral Gajera") } >
                Click
            </button>
        </div>
    )
}
```