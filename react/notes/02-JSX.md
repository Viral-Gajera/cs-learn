# JSX

- JSX stands for **JavaScript XML**. JSX allows us to write HTML in React.
- JSX produces React `elements`.

Example :

```jsx
const element = <h1>Hello, world!</h1>;

const element = (
  <div>
    <h1>Hello!</h1>
    <h2>Good to see you here.</h2>
  </div>
);
```

- This tag syntax is neither a `string` nor `HTML`. It is called `JSX`, and it is a syntax extension to JavaScript.

  

# Embedding Expressions in JSX

- Expressions wrapped in curly braces `{}`.
  
    ```jsx
    const name = 'Josh Perez';
    const element = <h1>Hello, {name}</h1>;
    ```
    
- You can put any valid [JavaScript expression](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Expressions_and_Operators#Expressions) inside the curly braces in JSX. For example, `2 + 2`, `user.firstName`, or `formatName(user)` are all valid JavaScript expressions.
  
    Example :
    
    ```jsx
    const user = {
      firstName: 'Harper',
      lastName: 'Perez'
    };
    
    function formatName(user) {
      return user.firstName + ' ' + user.lastName;
    }
    
    const element = (
      <h1>
        Hello, {formatName(user)}!
      </h1>
    );
    ```
    
- You may also use curly braces to embed a JavaScript expression in an attribute :
  
    ```JavaScript
    const element = <img src={user.avatarUrl} ></img>;
    ```
    
- if you pass `Array` inside curly bracket `{}` then it automatically destructed by `React.createElement(type, [props-obj], [...children])` method.

  

# JSX Represents Objects :

- During compilation, JSX expressions become regular JavaScript function calls() and evaluate to JavaScript objects.
- Babel compiles JSX down to `React.createElement(type, [props-obj], [...children])` calls.
- Each JSX element is just syntactic sugar for calling `React.createElement()`.
  
    Example :
    
    - These two examples are identical :
    
    ```JavaScript
    // 1
    const element = (
      <h1 className="greeting">
        Hello, world!
      </h1>
    );
    
    // 2
    const element = React.createElement(
      'h1',
      {className: 'greeting'},
      'Hello, world!'
    );
    ```
    
    `React.createElement()` performs a few checks to help you write bug-free code but essentially it creates an `object` like this:
    
    ```JavaScript
    // Note: this structure is simplified
    const element = {
      type: 'h1',
      props: {
        className: 'greeting',
        children: 'Hello, world!'
      }
    };
    ```
    
- These objects are called `React elements`. You can think of them as descriptions of what you want to see on the screen. React reads these objects and uses them to construct the DOM and keep it up to date.
- We can use JSX inside of `if` statements and `for` loops, assign it to variables, accept it as arguments, and return it from functions:
  
    Example :
    
    ```JavaScript
    function getGreeting(user) {
      if (user) {
        return <h1>Hello, {formatName(user)}!</h1>;
      }
      return <h1>Hello, Stranger.</h1>;
    }
    ```
    

  

# HTML vs JSX

- Since JSX is closer to JavaScript than to HTML, React DOM uses `camelCase` property naming convention instead of HTML attribute names.
  
    |HTML|JSX|
    |---|---|
    |`class` attribute.|`className` attibute. [ because `class` is reserve keywork in js ]|
    |`for` attribute `<label for="">`|`htmlFor` attribute.|
    

  

# Styling React Using CSS

- There are many ways to style React with CSS.
    - Inline styling
    - CSS stylesheets
    - CSS Modules

  

### Inline Styling

- To style an element with the inline style attribute, the value must be a JavaScript object.
- Since the inline CSS is written in a JavaScript object, properties with hyphen separators, like `background-color`, must be written with `camel case` syntax.
  
    Example :
    
    ```jsx
    function Header(){
    
        const myStyle = {
            color: "white",
            backgroundColor: "DodgerBlue",
            padding: "10px",
            fontFamily: "Sans-Serif"
        };
    
      return (
        <div>
          <h1 style={ {color: "red"; backgroundColor : 'black'} }>Hello Style!</h1>
          <p style={ myStyle } >Add a little style!</p>
        </div>
      );
    }
    ```
    

  

### CSS Stylesheet

- You can write your CSS styling in a separate file, just save the file with the `.css` file extension, and import it in your application.
  
    Example :
    
    - App.css:
    - Create a new file called "App.css" and insert some CSS code in it:
    
    ```CSS
    body {
      background-color: \#282c34;
      color: white;
      padding: 40px;
      font-family: Sans-Serif;
      text-align: center;
    }
    
    .primary{
        color:'purple';
    }
    ```
    
    Import the stylesheet in your application.
    
    ```jsx
    import React from 'react';
    import ReactDOM from 'react-dom/client';
    
    // css file
    import './App.css';
    
    const Header = () => {
      return (
        <div>
          <h1 className="primary" >Hello Style!</h1>
          <p>Add a little style!.</p>
        </div>
      );
    }
    ```
    

  

### CSS Modules

- Create the CSS module with the `.module.css` extension, example: `my-style.module.css`.
- Create a new file called "my-style.module.css" and insert some CSS code in it:
  
    Example :
    
    my-style.module.css:
    
    ```CSS
    .bigblue {
      color: DodgerBlue;
      padding: 40px;
      font-family: Sans-Serif;
      text-align: center;
    }
    ```
    
- Import the stylesheet in your component:
  
    Car.js :
    
    ```jsx
    import styles from './my-style.module.css';
    
    const Car = () => {
      return <h1 className={styles.bigblue} >Hello Car!</h1>;
    }
    
    export default Car;
    ```