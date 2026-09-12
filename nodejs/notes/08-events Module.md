## Events module

- node.js has a built-in module, called 'events'. where you can create, fire, and listen for your own events.
- In addition, all event properties and methods are an instance of an EventEmitter object.
- To be able to access these properties and methods, create an EventEmitter object :
  
    ```Plain
    let events = require('events');
    let eventEmitter = new events.EventEmitter();
    ```
    

### Steps :

1. register for the events to be fired inly one time using onece.
   
    ```Plain
    let events = require('events');
    let eventEmitter = new events.EventEmitter();
    
    eventEmitter.on('sayMyName', () => { console.log('your name is viral'); } )
    eventEmitter.emit('sayMyName')
    ```
    
2. create an events emmiter instance and register a couple of callbacks
   
    ```Plain
    let eventEmitter = new events.EventEmitter();
    eventEmitter.on('sayMyName', () => { console.log('your name is viral'); } )
    eventEmitter.on('sayMyName', () => { console.log('your name is gajera'); } )
    eventEmitter.emit('sayMyName');
    	// your name is viral
    	// your name is gajera
    ```
    
3. registering for the event each callback parameter.
   
    ```Plain
    let events = require('events');
    let eventEmitter = new events.EventEmitter();
    
    eventEmitter.on('checkPage', (sc, msg) => {
    		console.log(`status code is ${sc} and the page is ${msg}`);
    	})
    
    eventEmitter.emit('checkPage', 200, 'ok');
    ```