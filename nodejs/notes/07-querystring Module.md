# Query String module:

```Plain
require('querystring')
```

Methods :

- querystring.decode()
- querystring.encode()
- querystring.escape(str)
- querystring.parse(str, [sep], [eq], [options])
- querystring.stringify(obj, [sep], [eq], [options])
- querystring.unescape(str)

The querystring module provides utilities for parsing and formatting URL query strings.

general form of queryString

```Plain
?var=value&var=value
```

Ex.

```Plain
<http://127.0.0.1:3000/admin?username=viral&passward=123>
```

## Methods:

- `querystring.parse(str, [sep], [eq], [options])`
- This method parses a URL query string (str) into a collection of key and value pairs, and returns `object` which does not prototypically inherit from the JavaScript Object.