# Elements

- Elements are the smallest building blocks of React apps.
- React elements are `plain objects`, and are cheap to create. ReactDOM takes care of updating the DOM to match the React elements.

### Rendering elements :

- To render a React element, first pass the DOM element to `ReactDomClient.createRoot(container, [options])`, then pass the React element to `root.render(element)`:
  
    Example :
    
    ```jsx
    const element = <h1>Hello, world</h1>;
    
    const root = ReactDomClient.createRoot(document.getElementById('root'));
    root.render(element);
    ```
    

### Updating Rendered element :

- React elements are [immutable](https://en.wikipedia.org/wiki/Immutable_object). Once you create an element, you can’t change its children or attributes.
- The only way to update the UI is to create a new element, and pass it to `root.render()`.
  
    Example :
    
    ```jsx
    const root = ReactDomClient.createRoot(document.getElementById('root'));
    
    function tick() {
     const element = (
       <div>
         <h1>Hello, world!</h1>
         <h2>It is {new Date().toLocaleTimeString()}</h2>
       </div>
     );
     root.render(element);
    }
    
    setInterval(tick, 1000);
    ```
    

  

# Components :

- Conceptually, components are like JavaScript `functions`. They accept arbitrary inputs (called `props`) and return `a` `React elements` describing what should appear on the screen.
- Always start component names with a capital letter. and React treats components starting with lowercase letters as DOM tags.
- Components can also have `attribute` like JSX DOM element. unlike JSX DOM element's attributes which passed as argument to `React.createElement(type, [props-obj], [...children])`, Component's attributes are passed to `Component Function` and strored into `props` object.

### Function and Class Components :

- This following function is a valid React component because it accepts a single `props` object argument with data and returns `a` `React element`.
- We call such components “function components” because they are literally JavaScript functions.
  
    ```JavaScript
    function Welcome(props) {
      return <h1>Hello, {props.name}</h1>;
    }
    ```
    
- You can also use an `ES6 class` to define a component :
  
    ```JavaScript
    class Welcome extends React.Component {
      render() {
        return <h1>Hello, {this.props.name}</h1>;
      }
    }
    
    // can access props through "this.props".
    ```
    

### Converting a Function to a Class :

1. Create an [ES6 class](https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Classes), with the same name, that extends `React.Component`.
2. Add a single empty method to it called `render()`.
3. Move the body of the function into the `render()` method.
4. Replace `props` with `this.props` in the `render()` body.
5. Delete the remaining empty function declaration.

### Rendering a components :

- Previously, we only encountered **React elements** that represent `DOM tags`, However, elements can also represent `user-defined components`.
  
    ```JavaScript
    const element = <div></div>;
    const element = <Welcome name="Sara" />;
    ```
    
- You may also use `curly braces` to embed a JavaScript expression in an `attribute of components` :
  
    ```JavaScript
    let myAge = 19;
    const element = <Welcome age={myAge} />
    ```
    
- On encountering `<Welcome name="Sara" />`, React calls the `Welcome` component with `{name: 'Sara'}` as the props. Our `Welcome` component returns a `<h1>Hello, Sara</h1>` element as the result.
- `props` are Read-Only, **All React components must act like pure functions with respect to their props.**

### Composing Components :

- Components can refer to other components in `their output`.
  
    ```JavaScript
    function Welcome(props) {
      return <h1>Hello, {props.name}</h1>;
    }
    
    function App() {
      return (
        <div>
          <Welcome name="Sara" />
          <Welcome name="Cahal" />
          <Welcome name="Edite" />
        </div>
      );
    }
    ```
    

### Containment or Composition

- Our custom component can also wrap the content and act as parent component of other element/component.
  
    For example :
    
    ```JavaScript
    function WelcomeDialog() {
      return (
        <FancyBorder color="blue">
          <h1 className="Dialog-title">
            Welcome
          </h1>
          <p className="Dialog-message">
            Thank you for visiting our spacecraft!
          </p>
        </FancyBorder>
    );
    ```
    
- And to access this children element from `Parent component function body` use `props.children` property.
  
    For example :
    
    ```JavaScript
    function FancyBorder(props) {
      return (
        <div>
          {props.children}
        </div>
      );
    }
    ```
    

  

# React Fragment :

- A React fragment is a component that can be used to group together multiple elements without adding an extra DOM node.
- Act as wrapper for the multiple elements/components.
  
    Syntax :
    
    ```JavaScript
    function Component (){
        return (
            <React.Fragment>
                <div></div>
                <div></div>
                .
                .
            </React.Fragment>
        )
    }
    ```
    
    ```JavaScript
    function Component (){
        return (
            <>
                <div></div>
                <div></div>
                .
                .
            </>
        )
    }
    ```