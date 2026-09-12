# Node Architecture

Node.js employs a “Single Threaded Event Loop” design, to manage several concurrent clients.

Node.js contains following components:

- V8 engine
- libuv library  
    libuv gives node.js access to underlying computer system, file system, networking and more. it also implements two extremely importent node.js features.  
    - event loop
    - thread pool
- other library
    - http-parser, c-ares, openSSL, zlib

  

![[1 9.png|1 9.png]]