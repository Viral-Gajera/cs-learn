## Request

- The `req` object represents the HTTP request and has properties for the request query string, parameters, body, HTTP headers, and so on.

### Properties :

```Plain
req.body          //
req.params        //
req.query		  // 
req.method        //
req.headers       // object containing header fields and values


req.app
req.baseUrl
req.cookies
req.fresh
req.fresh
req.ip
req.ips
req.originalUrl
req.path
req.protocol
req.res
req.route
req.secure
req.signedCookies
req.stale
req.subdomains
req.xhr
```

### req.params

- If you have the route `/user/:name`, then the “name” property is available as `req.params.name`. This object defaults to `{}`.

### Methods :

```Plain
req.accepts(types)
req.acceptsCharsets(charset [, ...])
req.acceptsEncodings(encoding [, ...])
req.acceptsLanguages(lang [, ...])
req.get(field)
req.is(type)
req.param(name [, defaultValue])
req.range(size[, options])
```