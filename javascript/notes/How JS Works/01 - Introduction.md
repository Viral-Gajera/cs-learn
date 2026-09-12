## How does JavaScript work ?

### Javascript overview :

Javascript is a high-level, prototype-based object-oriented, multi-paradigm, interpreted or just-in-time compiled, dynamic, single-threaded, garbage-collected programming language with first-class functions and a non-blocking event loop concurrency model.

|   |   |
|---|---|
|Features|Description|
|high-level|we don’t have to worry about complex stuff like memory management and other resource management.|
|prototype-based object-oriented|Prototype-based programming is a style of object-oriented programming where classes are not present, and behavior inheritance is performed by cloning existing objects that serve as prototypes.|
|multi-paradigm|A multi-paradigm programming language is a programming language that supports more than one programming approach like procedure-oriented, Object-oriented, functional programming, meta-programming, etc.|
|interpreted or just-in-time compiled|A just-in-time (JIT) compiler converts a program into machine code and is directly sent to the processor (CPU) for execution.|
|single-threaded||
|Dynamically typed|Variable does not have a data type. The data type of variable is automatically changed|
|garbage-collected|Automatically clean up memory that is no longer required. Like an unreferenced object.|
|first-class function|In javascript, functions are just treated as other regular variables. We can pass them into other functions, and return them from functions.|
|non-blocking event loop concurrency model||

### Javascript Engine :

- Javascript engine is a computer program that executes javascript code.
- All modern engines use just-in-time compilation for improved performance.
- Ex. V8, Chakra, spider monkey, ...

### How engine works :

<img src="Ref-Image/Engine.png" style="zoom: 50%;" />

![[Engine.png]]

  

### Steps :

1. Parsing :  
    a piece of code converted into AST (Abstract Syntax tree) also checks the syntax error.  
    
2. compilation :  
    just in time compiler converts AST to machine code.  
    
3. Execution :  
    any javascript engine contains a call stack and a heap, the call stack is where our code is executed using execution context. Heap is an unstructured memory pool that stores all the objects.  
    
      
    
    ![[CS_(2).jpg]]
    
      
    
4. optimization :  
    Modern javascript engines actually have pretty clever optimization strategies. what they do is create an unoptimized version of machine code in the beginning. so that it can start executing as fast as possible.  
    
    Then in the background code is optimized and recompiled during the already running process. and this can be done most of the time, after each optimization, the unoptimized code is simply swept away for new optimized code without ever stopping the execution.
    

### Javascript runtime :

Javascript runtime refers to where your javascript code is executed when you run it. That said, javascript can be executed on google chrome, in which case your javascript runtime is v8, if on Mozilla - it is spider monkey, if IE - then it’s a chakra and if on node.js, again its v8.

### Brower :

![[CS.jpg]]

### Node.js :

![[CS_(2).png]]

  

javascript is `single-threaded` but we can use both `asynchronous` and `synchronous` versions of javascript.

callback queue :

- A callback queue is a data structure that contains all the callback functions that are ready to execute.

Microtask Queue:

- Microtask Queue is like the Callback Queue, but Microtask Queue has a higher priority.
- All the callback functions coming through Promises and Mutation Observer will go inside the Microtask Queue.

Event loop:

- All the code that is inside callback function are executed in event loop.  
    (code which is not top level code is executed in event loop)  
    
- Most of the built-in higher order function which take callback function as argument, emits the event, as soon as they done their work.
- event loop then picks-up one of the event, and execute callback function associated with that event.

### Execution Context :

- Execution context (EC) is defined as the environment in which the JavaScript code is executed.
- Execution context contained in call-stack.
- Execution context stores all the necessary information for some code to be executed.

Execution context in JavaScript is of three types:

1. Global execution context (GEC):
2. Functional execution context (FEC):
3. Eval:

### 1. Global execution context (GEC) :

- All of the global code i.e., code that is not inside any function or object is executed inside the global execution context.
- GEC cannot be more than one because only one global environment is possible for JS code execution, as the JS engine is single-threaded.

### 2. Functional execution context (FEC) :

- Functional execution context is defined as the context created by the JS engine whenever it finds any function call.
- Each function has its own execution context. It can be more than one.
- Functional execution context has access to all the code of the global execution context, though vice versa is not applicable.
- In function execution context, if the code is executing in strict mode value of 'this' is undefined, else it is a window object.

### 3. Eval :

- Execution context inside `eval` function.

JavaScript engine creates the execution context in the following two stages:

1. Creation phase ( memory component )
2. Execution phase ( thread of execution )

### 1. Creation phase :

- In the creation phase, the Javascript engine performs the following task:
    1. Creates the variable environment or activation object or the variable object.  
        An activation object is a special object in JS which contain...  
        
        - variable declaration [as name-value pair]
        - function declaration [as name-value pair]
        - argument object [not for arrow function]
        
        An activation object is a special object it does not have the dander proto property.
        
    2. Create the scope chain:
        
        Every scope has access to all the variables from its outer scopes, this is the scope chain.
        
    3. Determines the value of 'this':
        
        - ‘this’ keyword is a special variable that is created for every execution context.
        - takes the value of the 'owner' of the function in which the 'this' keyword is used.
        - the value of 'this' is not static. it depends on how the function is called, and its value is only assigned when the function is actually called.
        - After the scope chain, the JavaScript engine initializes the value of this. [‘this’ variable not created for arrow function].
        
        Value of ‘this’ in different situations:
        
        - In the method, ‘this’ refers to its owner object (same in ‘strict mode’;)
        - Alone ‘this’ refers to the global object (same in ‘strict mode’;)
        - In function, ‘this’ refers to the global object (same in ‘strict mode’;)
        - In an event, ‘this’ refers to the ‘element’ that received the event.
        - In the arrow function, ‘this’ refers to ‘lexical this’. An arrow function does not get its own ‘this’ variable.

### 2. Execution phase :

- In the execution phase, JS engines again scan the entire code to update the variable environment with the values of the variables and it executes the code.

Execution context looks like

![[EC_(3).png]]