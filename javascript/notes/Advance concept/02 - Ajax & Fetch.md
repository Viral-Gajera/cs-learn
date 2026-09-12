## AJAX:

- AJAX stands for Asynchronous JavaScript And XML.
- Ajax used to . . .
    - Update a web page without reloading the page
    - Request data from a server - after the page has loaded
    - Receive data from a server - after the page has loaded
    - Send data to a server - in the background

### XMLHttpRequest object:

XMLHttpRequest (XHR) objects are used to interact with servers.

Simple Eample :

```Plain
let xhr = new XMLHttpRequest();
xhr.open('GET', `https://restcountries.com/v3.1/name/${country}`);
xhr.send();

xhr.addEventListener('load', function(){
    let data = JSON.parse(xhr.responseText);
    console.log(data);
})
```

Constructor :

```Plain
XMLHttpRequest()
```

Instance Properties :

```Plain
XMLHttpRequest.responseText        // string that contains the response | null
XMLHttpRequest.readyState        // Returns a number representing the state of the request.

XMLHttpRequest.response
XMLHttpRequest.responseType
XMLHttpRequest.responseURL Read only
XMLHttpRequest.responseXML Read only
XMLHttpRequest.status Read only
XMLHttpRequest.statusText Read only
XMLHttpRequest.timeout
XMLHttpRequest.upload Read only
XMLHttpRequest.withCredentials
```

- number representing the state of the request
    
    |   |   |   |
    |---|---|---|
    |Value|State|Description|
    |`0`|`UNSENT`|Client has been created. `open()` not called yet.|
    |`1`|`OPENED`|`open()` has been called.|
    |`2`|`HEADERS_RECEIVED`|`send()` has been called, and headers and status are available.|
    |`3`|`LOADING`|Downloading; `responseText` holds partial data.|
    |`4`|`DONE`|The operation is complete.|
    

Instance Methods :

```Plain
XMLHttpRequest.open(method, url, [async], [user], [password])
XMLHttpRequest.setRequestHeader(header, value)
XMLHttpRequest.send([body])

XMLHttpRequest.getResponseHeader()
XMLHttpRequest.getAllResponseHeaders()

XMLHttpRequest.abort()
XMLHttpRequest.overrideMimeType()
```

Events :

`load`, `onload`, `readystatechange`

`loadstart`, `loadend`, `timeout`, `error`, `abort`, `progress`

### Creating Request for CRUD operation :

Example :

```Plain
function AJAXRequest(method, url, data={}){
    let xhr = new XMLHttpRequest();
    xhr.withCredentials = true;
    xhr.open(method, url);
    xhr.setRequestHeader("Content-Type", "application/json");    // must appear after open() method
    xhr.send(JSON.stringify(data));

    console.log(`${method} request sent...`)
    return xhr;
}


// GET REQUEST
AJAXRequest("GET","").addEventListener("readystatechange", function () {
    if (this.readyState === this.DONE) {
        console.log(JSON.parse(this.responseText));
    }
});


// POST REQUEST
let data1 =  {
    content : "This is data from client"
}
AJAXRequest("POST", "", data1 ).addEventListener("readystatechange", function(){
    if (this.readyState === this.DONE) {
        console.log(JSON.parse(this.responseText));
    }
})
```

## Fetch API

The global `fetch()` method in JavaScript is used to request for data to the server asynchronously.

It similar to XMLHttpRequest, it provides a more powerful and flexible feature set.

Syntax:

```Plain
fetch('url', [option])                   // api for the 'get' request
  .then(response => response.json())    // .json() again returns promise
  .then(data => console.log(data));
```

Resolve :

- The global `fetch()` method returns a promise which is fulfilled once the response is available.
- The promise resolves to the 'Response object' representing the response to your request.

Rejected :

- A `fetch()` promise only rejects when a network error is encountered.
- A `fetch()` promise does not reject on HTTP errors (404, etc.). Instead, a then() handler must check the Response.ok and/or Response.status properties.

### GET Request :

- To make a `GET` request using the `fetch()` API in JavaScript, you can use the following syntax:
- Example :
    
    ```Plain
    fetch(url)
      .then(response => response.json())
      .then(data => console.log(data))
      .catch(error => console.error(error));
    ```
    

### POST And Other Request :

- To make a `POST` request with `fetch()`, you need to pass a second argument to the function which is an object containing the request options, including the method, headers, and body of the request.
- Here's an Example :
    
    ```Plain
    fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
      .then(response => response.json())
      .then(data => console.log(data))
      .catch(error => console.error(error));
    ```