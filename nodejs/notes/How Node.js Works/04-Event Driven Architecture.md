## Event Driven Architecture

- EventEmitters object emits named event as some as something importent happens in the app (like reading file complete, timer expiring), then these events picked up by event listerers. which will fire off callback function that are atteched to each listener.

![[5 4.png|5 4.png]]

Example :

```JavaScript
const EventEmitter = require('events');

const myEmitter = new EventEmitter();

myEmitter.on('newSale', () => {
    console.log('There was a new sale!');
})

myEmitter.on('newSale', () => {
    console.log('Customer name: Jonas');
});

myEmitter.on('newSale', stock => {
    console.log(`There are now ${stock} items left in stock.`);
});

setTimeout(() => {
    myEmitter.emit('newSale',9);
}, 3000);
```

```JavaScript
const EventEmitter = require('events');

class Sales extends EventEmitter{
    constructor(){
        super();
    }
}

const myEmitter = new Sales();

myEmitter.on('newSale', () => {
    console.log('There was a new sale!');
})

myEmitter.on('newSale', () => {
    console.log('Customer name: Jonas');
});

myEmitter.on('newSale', stock => {
    console.log(`There are now ${stock} items left in stock.`);
});

setTimeout(() => {
    myEmitter.emit('newSale',9);
}, 3000);
```