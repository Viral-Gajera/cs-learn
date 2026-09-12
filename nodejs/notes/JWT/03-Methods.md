## Installation

- Type following command to terminal to install JWT
    
    ```Plain
    npm install jsonwebtoken
    ```
    
- Include the module:
    
    ```Plain
    const jwt = require("jsonwebtoken");
    ```
    

## Methods :

- Here are some commonly used functions in JWTs:
    1. `jwt.sign()`:
        - This function is used to create a JWT. It takes a payload and a secret, and returns a signed JWT.
        - The signature for the `jwt.sign()` function is as follows:
            
            ```Plain
            jwt.sign(payload, secretOrPrivateKey, [options], [callback])
            ```
            
        - Example :
            
            ```Plain
            const jwt = require('jsonwebtoken');
            const payload = {
              sub: '1234567890',
              name: 'John Doe',
              iat: 1516239022
            };
            const secret = 'mysecretkey';
            
            const token = jwt.sign(payload, secret);
            console.log(token);
            ```
            
    2. `jwt.verify()`:
        - This function is used to verify a JWT. It takes a token and a secret.
        - The return value of the `jwt.verify()` function is the decoded payload if the JWT is valid. If the JWT is invalid, the function will throw an error. If a callback is provided, the function will return `undefined`.
        - The signature for the `jwt.verify()` function is as follows:
            
            ```Plain
            jwt.verify(token, secretOrPublicKey, [options], [(err, decoded_payload)=>{}] )
            ```
            
        - Example:
            
            ```JavaScript
            const jwt = require('jsonwebtoken');
            const secret = 'mysecretkey';
            
            try {
              const decoded = jwt.verify(token, secret);
              console.log(decoded);
            } catch (err) {
              console.error(err.message);
            }
            ```
            
    3. `jwt.decode()`: This function is used to decode a JWT without verifying its signature. It takes a token and returns the header and payload as separate objects.