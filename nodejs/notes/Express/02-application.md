## Application

- The `app` object conventionally denotes the Express application. it is created by calling the top-level `express()` function exported by the Express module.
  
    ```Plain
    var express = require('express')
    var app = express()
    
    app.get('/', function (req, res) {
      res.send('hello world')
    })
    
    app.listen(3000)
    ```

### Properties :

```Plain
app.locals
app.mountpath
```

### Events :

```Plain
app.on('mount', callback(parent))
```

### Methods :

### Routing HTTP requests :

```Plain
app.all(path, callback [, callback ...])
app.get(path, callback [, callback ...])
app.post(path, callback [, callback ...])
app.put(path, callback [, callback ...])
app.delete(path, callback [, callback ...])
```

- path is a URL for which the middleware function is invoked.
- callback function is middleware function.

```Plain
app.param( [name], callback)
```

- name is `name` or `array` of parameters.
- `(req, res, next, value, name)=>{}`, is signature of callback function.
- middleware function called for each of the parameters if case of array is passed as agument.
- if url contains less parameter than of array, then middleware function not called for missing parameter.

### listening to port :

```Plain
app.listen(path, [callback])
app.listen( [port], [host], [backlog], [callback] )
```

### useful method :

- The `app.route(path)` method in Express.js allows for the creation of chainable route handlers for a specific route path. 

```Plain
app.route(path)
```

- It is used to handle multiple http request method on single path.

- Returns an instance of a single route.

```
app.route('/users')
  .get((req, res) => {
    res.send('Get all users');
  })
  .post((req, res) => {
    res.send('Create a new user');
  })
  .put((req, res) => {
    res.send('Update a user');
  })
  .delete((req, res) => {
    res.send('Delete a user');
  });
```



```Plain
app.use([path], callback, [callback...])
```

- executes middleware function for given path.

### other :

```Plain
app.path()
app.render(view, [locals], callback)

app.get(name)
app.set(name, value)

app.disable(name)
app.disabled(name)
app.enable(name)
app.enabled(name)

app.engine(ext, callback)2
```