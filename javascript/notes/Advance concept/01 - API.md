## APIs

- API stands for application programming interface.
- API : a piece of software that can be used by another piece of software, in order to allow applications to talk to each other.

### REST APIs

- **R**epresentational **S**tate **T**ransfer (REST).
- REST technology is generally preferred to the more robust **Simple Object Access Protocol (SOAP)**.
- *REST API should be Stateless **: All state is handled on the client. This means that each request must contain all the information necessary to process a certain request. The server should not have to remember previous requests.
    
    ![[1 7.png|1 7.png]]
    
- **Working:**
    - It should use following HTTP method for CRUD operation.
        
        `GET` - for reading data
        
        `POST` - for create
        
        `PUT|PATCH` - for updating data
        
        `DELETE` - for deleting data
        
    - After that, a response comes back from the server in the form of a resource which can be anything like HTML, XML, Image, or JSON. But now JSON is the most popular format being used in Web Services.