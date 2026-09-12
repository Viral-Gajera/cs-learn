# Events

- An event is an action that occurs in the web browser.
- Each event may have an `event Listener` which is a block of code that will execute when the event occurs.

# Event Flow

- Event flow explains the order in which events are received on the page from the element where the event occurs and propagated through the DOM tree.
- There are two main event models :
  
    `event bubbling`
    
    `event capturing`

## Event bubbing :

- In the event bubbling model, an event starts at the `most specific element` and then flows upward toward the `least specific element` (the document or even window).

## Evnet capturing :

- In the event capturing model, an event starts at the `least specific element` (probably root element) and flows downward toward the `most specific element`.

## Level 2 event model :

- DOM level 2 events specify that event flow has three phases :

    1. First, `event capturing occurs`, which provides the opportunity to intercept the event.

    2. Then, the `actual target` receives the event.

    3. Finally, `event bubbling occurs`, which allows a final response to the event.

- `eventLister` only gives responce to bubbling phase ( phase 3 ) by default.

  ​    

    <img src="Bubbling & Capturing.png">

# Event object

- When the event occurs, the web browser `passes an event object to the event handler as parameter`.
- Note that the event object is only accessible inside the event handler. Once all the event handlers have been executed, the event object is automatically destroyed.
- The following table shows the most commonly-used properties and methods of the event object.
  
    ```JavaScript
    e.type
    
    e.target
    // returns element on which event occured
    
    e.currentTarget
    // retuens element on which evetHandler function atteched to.
    // same as value of 'this' keyword
    
    e.detail
    e.bubbles
    e.eventPhase
    
    e.cancelable				// true if the default behavior of the event can be canceled.
    e.defaultPrevented			// return true if the preventDefault() has been called.
    e.preventDefault()			// cancel the default behavior for the event.
    e.stopPropagation()			// cancel any further event capturing or bubbling.
    
    e.key
    e.code
    e.event.clientX
    e.event.clientY
    e.event.offsetX
    e.event.offsetY
    e.event.screenX
    e.event.screenY
    ```
    

# Handling event

- When an event occurs, you can create an event handler which is a piece of code that will execute to respond to that event.
- An event can be handled by one or multiple event handlers. If an event has multiple event handlers, all the event handlers will be executed when the event is fired.
- There are three ways to assign event handlers.

## 1. HTML event handler attributes:

- Event handlers attributes typically have names as event-na that begin with `on`.
- For example, the event handler attribute for the `click` event, is `onclick`.
- To assign an event handler function to an event associated with an HTML element, you can use an HTML attribute, and as value, make `function called with argument`.
  
    Example :
    
    ```HTML
    <input type="button" value="Save" onclick="alert('Clicked!')">
    ```
    

## 2. DOM level 0 event handlers

- Each element has event handler properties. For example. `onclick`.
- To assign an event handler, you set the property to a function as shown in the example :

```js
let btn = document.querySelector('\#btn');

btn.onclick = function() {
    alert('Clicked!');
};
```

## 3. Dom level 2 event handlers:

- By default `addEventListener()` listen event in **bubbling phase** (not in capturing phase).
- DOM Level 2 Event Handlers provide two main methods for dealing with the registering / deregistering event listeners. 

```js
addEventListener() 		– register an event handler.  
removeEventListener() 	– remove an event handler.
```

- This eventLister only gives responce to bubbling phase ( phase 3 ) by default.

```js
EventTarget.addEventListener('event name', callback, useCapture) 	
return undefined
```

callback function has one parameter as `event object`.

useCapture :

- false - The handler is executed in the bubbling phase. (default)
- true - The handler is executed in the capturing phase.



**removeEventListener()**

- Removes an event listener that was added via the addEventListener().
- However, you need to pass the same arguments as were passed to the `addEventListener()`.
- Using an anonymous event listener function will not work.

# Event Delegation :

- The idea is that if we have a lot of elements handled in a similar way, then instead of assigning a handler to each of them, we put a single handler on their common ancestor (parent).
- `Event capturing and bubbling` allow us to implement one of the most powerful event handling patterns called _event delegation_.
- Steps to implement event delegation
  
    1. Add event listener to common parent element.
    2. Determine which element originated event
    
    Example :
    
    ```HTML
    <div>
        <tr>
            <td> 1,1 </td>
            <td> 1,2 </td>
            <td> 1,3 </td>
        </tr>
        <tr>
            <td> 2,1 </td>
            <td> 2,2 </td>
            <td> 2,3 </td>
        </tr>
        <tr>
            <td> 3,1 </td>
            <td> 3,2 </td>
            <td> 3,3 </td>
        </tr>
    </div>
    ```
    
    ```HTML
    <script>
        let selectedTd;
        let table = document.getElementByTagName('div');
    
        table[0].addEventListener( 'click', function(event) {
              let target = event.target; // returns child element in which click event occurred
    
            if (target.tagName != 'TD') return; // not on TD? Then we're not interested
              highlight(target); // highlight it
        });
    
        function highlight(td) {
              if (selectedTd) { // remove the existing highlight if any
                selectedTd.classList.remove('highlight');
              }
              selectedTd = td;
              selectedTd.classList.add('highlight'); // highlight the new td
            }
    </script>
    ```