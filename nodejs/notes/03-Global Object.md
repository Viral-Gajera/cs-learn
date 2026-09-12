# Global objects:

- Global Objects are built-in objects that are part of the JavaScript and can be used directly in the application without importing any particular module.
- A list of Node.js global objects or variables are given below.
  
    ```Plain
    __dirname
    __filename
    console
    require()
    exports
    module
    fetch
    
    global
    
    Response
    Request
    Event
    EventTarget
    Process            - instance of EventEmitter
    Buffer             - used to deal with binary data
    WebAssembly
    URL
    ```
    

### global :

- it provides namespace. any variable defined in global namespace makes it globally accessible.
  
    ```Plain
    setImmediate(callback[, arg][, ...])
    clearImmediate(immediateObject)
    
    setInterval(callback, delay[, arg][, ...])
    clearInterval(intervalObject)
    
    setTimeout(callback, delay[, arg][, ...])
    clearTimeout(timeoutObject)
    
    queueMicrotask()
    TextEncoder:
    ```