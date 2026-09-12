## JSON Web Token

- JWT is for authorization (Not for authentication).
- Authentication: make sure that usernames and passwords are correct (like login).
- Authorization: make sure that user that sends requests to your server is the same user that actually logged in during authentication (like session management).
- Generally session management done using cookies but JWT uses Json Web Tokens.

### Traditional session management :

![[1 11.png|1 11.png]]

  

### Session management with JWT:

![[2 9.png|2 9.png]]