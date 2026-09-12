## React Router

- It is used to link the pages without refreshing the page.

```Plain
npm i react-router-dom
```

- If you are using React Native you will need to install `react-router-native` instead.

## React Router Basics

- Once you have this library there are three things you need to do in order to use React Router.
    1. Configuring The Router
    2. Defining Routes
    3. Handle navigation

### Configuring router

- Import the specific router (`BrowserRouter` for the web and `NativeRouter` for mobile) and wrap your entire application in that router.
- Generally you will import your router in the `index.js` page of your application and it will wrap your `App` component.

```jsx
import React from "react"
import ReactDOMClient from "react-dom/client"
import { BrowserRouter } from "react-router-dom"
import App from "./App"

const root = ReactDOMClient.createRoot(document.getElementById("root"))

root.render(
	<BrowserRouter>
	  <App />
	</BrowserRouter>
)
```


### Defining Routes

- This is generally done at the top level of your application, such as in the `App` component, but can be done anywhere you want.
- First we wrap our content with `<BrowserRouter>`.
- Then we define our `<Routes>`. 
- An application can have multiple `<Routes>`.
- `<Routes>` can have multiple `<Route>` within it. also`<Route>` can be nested.
- Whenever your URL changes React Router will look at the routes defined in your `Routes` component and it will render the content in the `element` prop of the `Route` that has a `path` that matches the URL.

```jsx
import { Home } from "./Home";
import { BookList } from "./BookList";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
	<Routes>
	  <Route path="/" element={<Home />} />
	  <Route path="/books" element={<BookList />} />
	</Routes>
  )
}

export default App;
```

- In the above example if our URL was `/books` then the `BookList` component would be rendered.
- The nice thing about React Router is that when you navigate between pages it will only refresh the content inside your `Routes` component. All the rest of the content on your page will stay the same which helps with performance and user experience.

### Handling Navigation

- React Router uses its own custom `Link` and `NavLink` component to handle navigation.

```jsx
import { Route, Routes, Link } from "react-router-dom"
import { Home } from "./Home"
import { BookList } from "./BookList"

function App() {
  return (
	<section>
	  <nav>
		<ul>
		  <li><Link to="/">Home</Link></li>
		  <li><Link to="/books">Books</Link></li>
		</ul>
	  </nav>

	  <Routes>
		<Route path="/" element={<Home />} />
		<Route path="/books" element={<BookList />} />
	  </Routes>
	</section>
  )
}

export default App;
```

- Setting the `path="*"` to will act as a catch-all for any undefined URLs. This is great for a 404 error page.