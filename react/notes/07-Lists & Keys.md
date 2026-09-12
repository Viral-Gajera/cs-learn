## List and Key

- Lists are used to display data in an ordered format or to render multiple elements.
- The `map()` function is used for traversing the lists.
  
    ```jsx
    import React from 'react';
    import ReactDOM from 'react-dom';
    
    function App(){
        const myList = ['Peter', 'Sachin', 'Kevin', 'Dhoni', 'Alisa'];
    
        const listItems = myList.map( (item, index, array)=>{
            return <li key={index}> {item} </li>;
        });
    
        return (
        	<ul> {listItems} </ul>
    	)
    }
    
    export default App;
    ```
    
- While rendoring list, each list item should have unique property called `key`.
- A key is a unique identifier.
- In React, it is used to identify which items have changed, updated, or deleted from the Lists. It is useful when we dynamically created components or when the users alter the lists. It also helps to determine which components in a collection needs to be re-rendered instead of re-rendering the entire set of components every time.