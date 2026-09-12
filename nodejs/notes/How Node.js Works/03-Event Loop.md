## Event loop

- All the code that is inside callback function are executed in event loop.  
    (code which is not top level code is executed in event loop)  
    
- Most of the built-in higher order function which take callback function as argument, emits the event, as soon as they done their work.
- Event loop then picks-up one of the event, and execute callback function associated with that event.

![[3 5.png|3 5.png]]

## Event loop phases

- Event loop has multiple phases, and each phases its own callback queue.
- A callback queue is a data structure that contains all the callback functions that are ready to execute.
- Event loop looks for each queue one after another.
    
    - Q1 : for expired timer callbacks
    - Q2 : for I/O callbacks
    - Q3 : for setImmediate callbacks
    - Q4 : for close callbacks
    
    Beside this, event loop also has a other queues.
    
    - process.nextTick queue
    - microtask queue (for promises)
        
        Event-loop look for this queue, after each of Q1, Q2, Q3 and Q4 queue lookUp
        

![[4 4.png|4 4.png]]

  

Example :

```Plain
let fs = require('fs');

setImmediate( function(){
    console.log("This will outputs 4th");
});

fs.readFile('text.txt', function(err, data){
    console.log("This will outputs 3rd");
});

setTimeout( function(){
    console.log("This will outputs 2st");
},0);

console.log("This will outputs 1nd");
```

Output :

```Plain
This will outputs 1nd
This will outputs 2st
This will outputs 4th
This will outputs 3rd	// because file reading takes time
```

### Polling phase :

- This is the phase in which we run all of the JavaScript code we've written, starting at the top and working our way down.
- When the event loop enters the **poll** phase, it has an empty queue (`fs.readFile()` has not completed), so it will wait for the number of ms remaining until the soonest timer's threshold is reached.

Example :

```JavaScript
fs.readFile('text.txt', function(err, data){
    setTimeout(function(){
        console.log('printed 2nd');
    }, 0);
    setImmediate(function(){
        console.log('printed 1st');
    });
});
```

Output :

```Plain
printed 1st
printed 2nd
```