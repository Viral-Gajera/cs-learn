## Examples

```JavaScript
let dotenv = require("dotenv");

const express = require("express");
const app = express();
const jwt = require("jsonwebtoken");

app.use(express.json());
dotenv.config({ path: "./config.env" });

const posts = [
    {
        <email:"kyle@gmail.com>",
        username: "Kyle",
        title: "Post 1",
    },
    {
        <email:"jim@gmail.com>",
        username: "Jim",
        title: "Post 2",
    },
];

// SENDING RESPONCE
app.get("/posts", authenticateToken, (req, res) => {
    res.json(posts.filter((post) => post.email === req.decoded.userEmail));
});

// GENERATING TOKEN
app.post("/login", (req, res) => {
    // FIRST-STEP: Authenticate User

    const userEmail = req.body.email;
    const accessToken = jwt.sign( { userEmail }, process.env.ACCESS_TOKEN_SECRET);

    res.json({
        accessToken: accessToken,
    });
});

// VERIFY TOKEN
function authenticateToken(req, res, next) {
    const authHeader = req.headers["authorization"];
    const token = authHeader && authHeader.split(" ")[1]; // bearer + token
    if (token == null) return res.sendStatus(401);

    jwt.verify(token, process.env.ACCESS_TOKEN_SECRET, (err, decoded) => {
        if (err) return res.sendStatus(403);
        req.decoded = decoded;
        next();
    });
}

app.listen(8080);
```

## Example

- In this example, we create a user object and use the `generateJWT` function to generate a JWT for the user with an expiry time of 1 hour. We then use the `verifyJWT` function to verify the JWT and print the result. If the JWT is valid, we will see the decoded payload. If the JWT is invalid, we will see an error message.
    
    ```Plain
    const jwt = require('jsonwebtoken');
    
    const jwtSecret = 'myjwtsecretkey';
    
    const user = {
      id: 1,
      email: 'user@example.com',
      name: 'User Name'
    };
    
    function generateJWT(user) {
      const payload = {
        id: user.id,
        email: user.email,
        name: user.name
      };
      const options = { expiresIn: '1h' };
      const token = jwt.sign(payload, jwtSecret, options);
      return token;
    }
    
    function verifyJWT(token) {
      try {
        const decoded = jwt.verify(token, jwtSecret);
        return decoded;
      } catch (error) {
        return false;
      }
    }
    
    const jwtToken = generateJWT(user);
    console.log('JWT Token:', jwtToken);
    
    const decoded = verifyJWT(jwtToken);
    if (decoded) {
      console.log('JWT is valid:', decoded);
    } else {
      console.log('JWT is invalid');
    }
    ```
    

## Generate Access_Token_Secret

- Generate Access_Token_Secret for JWT rendomly...
- Start REPT terminal by typing following command
    
    ```Plain
    node
    ```
    
- Type following code to generate access tokens
    
    ```Plain
    require('crypto').randomBytes(64).toString('hex');
    ```