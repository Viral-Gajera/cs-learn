# http module:

Classes :

- http.Agent
- http.Server
- http.IncomingMessage
- http.ServerResponse
- http.ClientRequest
- http.OutgoingMessage

Methods :

- http.createServer([option], [(req,res)=>{}])
- http.request()
- http.get()
- http.validateHeaderName(name, [value])

Properties :

- http.METHODS
- http.STATUS_CODES
- http.globalAgent
- http.maxHeaderSize

### Description

- It can be included using `const http = require('http');`
- Example :
    
    ```Plain
    let http = require('http');
    let fs = require('fs');
    
    let FileContent = fs.readFileSync('./index.html', 'utf-8');
    
    let server = http.createServer( function(request, responce){
    
        // request : http.IncomingMessage
        // responce : http.ServerResponse
    
        response.writeHead(200, {
            'Content-Type': 'text/html'
        })
        responce.write( FileContent );
        responce.end();
    } )
    
    server.listen( 8080, "127.0.0.1" , function(){
        console.log('server listing port 8080....');
    } )
    ```
    

## Classes :

- http.Agent
- http.Server
- http.IncomingMessage
- http.ServerResponse
- http.ClientRequest
- http.OutgoingMessage

### (i) http.Server

- returns net.Server Start a server listening for connections.
    
    ```Plain
    server.listen([port], [host], [backlog], [()=>{}])
    ```
    

### (ii) http.IncomingMessage

- message.url  
    it returns requested URL string.  
    

### (iii) http.ServerResponse

- `response.writeHead(statusCode, [statusMessage], [headers])`
- this method returns a reference to the ServerResponse, so that calls can be chained.
- statusMessage is string. and headers is object or array.
- `response.write( [chunk], [encoding], [()=>{}] );`
- returns true if the entire data was flushed successfully.
- This method sends a chunk of the response body.
- `response.end([data], [encoding], [()=>{}])`
- returns "this".
- This method called at the end of all responces.

## Methods:

- `http.createServer( [options], [(request,responce)=>{}] )`
    - Returns a new instance of "http.Server", requestListener executes every time the server gets a request.
    - Request is instance of `http.IncomingMessage`.
    - Responce is instance of `http.ServerResponse`.