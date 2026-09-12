## URL parameters :

URL Syntax :

```Plain
<http://domain/api/:param>
<http://domain/api/:param/:param>....

<http://domain/api/:param?.>...    (optional param)
```

`:param` is variable, which can be change in URL pattern.

Example :

```Plain
// Suppose request is : <https://domain/api/v1/tours/13>

app.get('/api/v1/tours/:id', function(req, res)=>{
    console.log(req.param);
    console.log(req.param.id);
})
```

## Environment variables :

- Environment variable are global variable that are used to define the environment in which a node app is running.
- Different environment example : `development`, `production`.
    
    ```Plain
    app.get('env')        // set by express, value is 'development' by default
    process.env            // by node.js
    ```
    

### Setting environment

1. using command line
    
    - prepend `VARIABLE_NAME=VALUE` before the command
    
    ```Plain
    nodemon app.js
    NODE_ENV=development nodemon app.js
    NODE_ENV=development X=23 nodemon app.js
    ```
    
    - accessing value
    
    ```Plain
    console.log(process.env);
    console.log(process.env.NODE_ENV)
    ```
    
2. config.env file
    - create `config.env` file.
    - use third-party package
        
        ```Plain
        npm i dotenv
        ```
        
        ```Plain
        let dotenv = require("dovenv");
        
        dotenv.config({path: "./config.env"});
        
        if(process.env.NODE_ENV === 'development'){
            app.use(morgan('dev'));
        }
        ```
        
        `config()` method accepts object as argument, in which `path` property is set to location of `config.env` file