# Process and Threads

- Process is a program under execution.
- Node.js contains single thread inside a process.
- This single thread executes sequence of instuctions like...
    
    1. initialize program
    2. execute 'top level' code
    3. import require module
    4. register event callbacks
    5. start event loop
    
    if the task is too heavy then it offload to thread-pool.
    

## Thread pool

- It is collection of 4 thread.
- It is provided by libuv.
- following heavy task are offload to thread-pool
    - file system api
    - crytography
    - compression
    - DNS lookUp

  

![[2 7.png|2 7.png]]