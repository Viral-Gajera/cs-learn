## Form Handling

- In react, there are two ways to handle form data in our components.
- The first way is by using the state ( `useState` ) within the component to handle the form data. This is called a `controlled component` method.
- The second way is to let the DOM handle the form data by itself in the component. This is known as an `uncontrolled component` method.
- In HTML, form elements such as `<input>`, `<textarea>`, and `<select>` typically maintain their own state and update it based on user input.
- Each form element contains a `value` property. The value may be typed (input, textarea) or selected (checkbox, select, radiobutton, etc) by the user or browser. When the element’s value is changed it state updated accordingly.

### Controlled Components

- Controlled components in React are those in which form/other data is handled by the `component’s state`.
- Now we can use state in our component to hold or manage the values of the elements in a form element.
  
    Here is an example :
    
    ```jsx
    function App() {
      const [name, setName] = useState("");
      const [email, setEmail] = useState("");
    
      function onSubmit() {
        console.log("Name value: " + name);
        console.log("Email value: " + email);
      }
      return (
        <form onSubmit={onSubmit}>
    
            <input type="text" name="name" value={name} required
                onChange={ (e) => setName(e.target.value)} />
    
            <input type="email" name="email" value={email} required
                onChange={ (e) => setEmail(e.target.value)} />
    
            <input type="submit" value="Submit" />
    
          </form>
      );
    }
    ```
    

  

### Uncontrolled Components

- Uncontrolled components are those for which the form / other data is handled by the `DOM itself` (Not handled by state).
- The values of the form elements are traditionally controlled by and stored on the DOM. We will have to refer to the instance of the form elements to retrieve their values from the DOM.
  
    Example :
    
    - Here we used these `id` attributes to get the value of the input element when the form is being submitted.
    
    ```jsx
    function App() {
      function onSubmit() {
        console.log("Name value: " + window.name.value);
        console.log("Email value: " + window.email.value);
      }
      return (
        <form onSubmit={onSubmit}>
          <input type="text" name="name" id="name" required />
          <input type="email" name="email" id="email" required />
          <input type="submit" value="Submit" />
        </form>
      );
    }
    ```
    
- The above component is an uncontrolled component because React has no control over the values of the form input elements.
- In this example, we used DOM APIs directly. Now let’s refactor the code to do it in a react way :

  

### React useRef hook

- In React, the `useRef` hook is like a little box that can hold a value — any value — and **keep it around between re-renders** without triggering a re-render when it changes.
- Unlike state (`useState`), updating a ref’s `.current` value **does not cause the component to re-render**.
- The `useRef` Hook allows you to persist values between renders.
- It can be used to access a DOM element directly.
- It can be used to store a mutable value that does not cause a re-render when updated.
  
    ```jsx
    function App() {
      const nameRef = useRef();
      const emailRef = useRef();
    
      function onSubmit() {
        console.log("Name value: " + nameRef.current.value);
        console.log("Email value: " + emailRef.current.value);
      }
      return (
        <form onSubmit={onSubmit}>
          <input type="text" name="name" ref={nameRef} required />
          <input type="email" name="email" ref={emailRef} required />
          <input type="submit" value="Submit" />
        </form>
      );
    }
    ```
    
- We created two React refs, `nameRef` and `emailRef`, and assigned them to the `ref` attributes of `name` and `email` inputs, respectively. This will cause the `refs` to hold the `HTMLElement` instances of the elements in their `.current` property. From `.current`, we can reference the `.value` property to get the values of the input elements.

For more information visit [documentation](https://reactjs.org/docs/forms.html).

`<textarea>`, `select & option`, `file input`, etc... discussed in documentation.