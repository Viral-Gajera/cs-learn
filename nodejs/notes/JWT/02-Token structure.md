## JSON Web Token structure

- In its compact form, JSON Web Tokens consist of three parts separated by dots (`.`), which are:
    - Header
    - Payload
    - Signature
- Therefore, a JWT typically looks like the following.
    
    ```Plain
    xxxxx.yyyyy.zzzzz
    ```
    

  

![[3 6.png|3 6.png]]

## How do JSON Web Tokens work?

- In authentication, when the user successfully logs in using their credentials, a JSON Web Token will be returned.
- Since tokens are credentials, great care must be taken to prevent security issues.
- Whenever the user wants to access a protected route or resource, the user agent should send the JWT, typically in the **Authorization** header using the **Bearer** schema.
- The content of the `header`should look like the following:
    
    ```Plain
    Authorization: "Bearer <token>"
    ```
    
- The server's protected routes will check for a valid JWT in the `Authorization` header, and if it's present, the user will be allowed to access protected resources.