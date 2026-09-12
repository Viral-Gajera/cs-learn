# url modules

```Plain
require('url')
```

Classes:

- URL
- URLSearchParams

Legacy URL API :

- urlObject
- url.parse( urlString, [parseQueryString], [slashesDenoteHost] )
- url.format( urlObject )
- url.resolve( from, to)

## Legacy URL API:

### urlObject

- The urlObject contains following properties
    
    ```Plain
      query: 		- fetch variable from url and returns object
      path: 		- gives entire path.
      pathname: 	- gives pathname.
    
      auth:
      hash:
      host:
      hostname:
      href:
      port:
      protocol:
      search:
      slashes:
    
    ```
    

### url.parse( urlString, [parseQueryString], [slashesDenoteHost])

```Plain
url.parse( urlString, [parseQueryString], [slashesDenoteHost])
```

- returns a `urlObject`.
- if parseQueryString is true, then "query" property of urlObject is set to object returned by `querystring.parse()`, otherwise it returns unparsed/undecoded string.
    
    Ex.
    
    ```Plain
    url.parse(request.url, true)
    ```