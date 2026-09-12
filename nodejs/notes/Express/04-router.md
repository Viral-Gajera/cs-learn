## Router()

- We can think `Router` as a “mini-application,” capable only of performing middleware and routing functions.
- A `Router behaves like middleware itself`, so you can use it as an argument to `app.use()`
- The top-level `express` object has a [Router()](https://expressjs.com/en/4x/api.html#express.router) method that creates a new `router` object.

### Methods

```Plain
// Routing HTTP requests
router.all(path, [callback, ...] callback)
router.METHOD(path, [callback, ...] callback)
router.param(name, callback)

// useful method
router.route(path)
router.use([path], [function, ...] function)
```

Example :

> app.js

```Plain
const express = require('express');
const app = express();
const routes = require('./routes.js');

app.use('/', routes);

app.listen(3000, () => {
  console.log('Server running on port 3000');
});
```

> routers.js

```Plain
const express = require('express');
const router = express.Router();

router.get('/', (req, res) => {
  res.send('Hello, World!');
});

router.get('/about', (req, res) => {
  res.send('About Page');
});

module.exports = router;
```