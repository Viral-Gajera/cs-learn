## Responce

- The `res` object represents the HTTP response that an Express app sends when it gets an HTTP request.

### Properties :

```Plain
res.app
res.headersSent            // true | false
res.locals
```

### Methods :

```Plain
res.status(code);
res.json( [object] );
res.send([Buffer|String|ohter-obj]);
res.download(path, [filename] , [options] , [fn]);
res.set(field, [value])			// Sets the response’s HTTP header field to value
res.cookie(name, value, { expires: expiryDate });
```