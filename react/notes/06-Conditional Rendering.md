## Conditional Rendering

- Conditional rendering in React works the same way conditions work in JavaScript.
- Use JavaScript statement like [`if...else`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/if...else) or the [conditional operator](https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Operators/Conditional_Operator) (`?:`) used to create elements representing the current state, and let React update the UI to match them.

### If...else statement :

- The following Example shows coditional rendoring react component using `if...else` statement.
  
    Example :
    
    ```jsx
    import {useState} form 'react';
    
    function Comp(){
        let [state, changeState]  = useState("NotLogin");
        // 1.NotLogin  2.LogedIn
    
        if(state === "NotLogin"){
            return (
            	<h1>Hello Guest</h1>
            );
        }
        else if(state === "LogedIn"){
            return (
            	<h1>Hello User</h1>
            );
        }
    }
    ```
    

### Logical && Operator :

- You may [embed expressions in JSX](https://reactjs.org/docs/introducing-jsx.html#embedding-expressions-in-jsx) by wrapping them in curly braces. This includes the JavaScript logical `&&` operator. It can be handy for conditionally including an element:
- It works because in JavaScript, `true && expression` always evaluates to `expression`, and `false && expression` always evaluates to `false`.
  
    Example :
    
    ```jsx
    function Mailbox(props) {
      const unreadMessages = props.unreadMessages;
      return (
        <div>
          <h1>Hello!</h1>
          { unreadMessages.length > 0 &&							<-
            <h2>
              You have {unreadMessages.length} unread messages.
            </h2>
          }
        </div>
      );
    }
    
    const messages = ['React', 'Re: React', 'Re:Re: React'];
    
    const root = ReactDOM.createRoot(document.getElementById('root'));
    root.render(<Mailbox unreadMessages={messages} />);
    ```
    

### Conditional Operator

- Another method for conditionally rendering elements inline is to use the JavaScript conditional operator [`condition ? true : false`](https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Operators/Conditional_Operator).
  
    Example :
    
    ```jsx
    render() {
      const isLoggedIn = this.state.isLoggedIn;
      return (
        <div>
          The user is <b>{isLoggedIn ? 'currently' : 'not'}</b> logged in.
        </div>
      );
    }
    ```