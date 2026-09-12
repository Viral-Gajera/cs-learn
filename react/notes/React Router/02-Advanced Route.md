# Advanced Route :

- There is a lot of cool stuff you can do with routing to make more complex routes, easier to read, and overall much more functional. This can be done through five main techniques.
    1. Dynamic Routing
    2. Routing Priority
    3. Nested Routes
    4. Multiple Routes
    5. `useRoutes` Hook

### Dynamic Routing :

- Dynamic routing in React Router DOM refers to the ability to define routes that can accept a `variable or dynamic portion in the URL`, allowing for more flexibility and dynamic rendering of components based on the URL.
- This can be achieved by using the `:param` syntax in the path definition and then using the `useParams` hook to access the dynamic value in the component.
- In our example, let's assume that we want to render out a component for individual books in our application. We could hardcode each of those routes, but if we have hundreds of books or the ability for users to create books then it is impossible to hardcode all these routes. Instead we need a dynamic route.

```jsx
<Routes>
  <Route path="/" element={<Home />} />
  <Route path="/books" element={<BookList />} />
  <Route path="/books/:id" element={<Book />} />
</Routes>
```

- In our case our dynamic route will match any URL that starts with `/book` and ends with some value. For example, `/books/1`, `/books/bookName`, and `/books/literally-anything` will all match our dynamic route.
- To access the dynamic value in your custom component which is where the `useParams` hook comes in.
- The `useParams` hook takes no parameters and will return an object with keys that match the dynamic parameters in your route.

```jsx
import { useParams } from "react-router-dom";

export function Book() {
  const { id } = useParams()

  return (
	<h1>Book {id}</h1>
  )
}
```

- In our case our dynamic parameter is `:id` so the `useParams` hook will return an object that has a key of `id` and the value of that key will be the actual id in our URL.

### Routing Priority :

- Example :
  
    ```jsx
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/books" element={<BookList />} />
      <Route path="/books/:id" element={<Book />} />
      <Route path="/books/new" element={<NewBook />} />
      <Route path="*" element={<NotFound />} />
    </Routes>
    ```
    
- If we have the URL `/books/new` which route would this match? Technically, we have two routes that match. Both `/books/:id` and `/books/new` will match since the dynamic route will just assume that `new` is the `:id` portion of the URL so React Router needs another way to determine which route to render.
- In older versions of React Router. whichever route was defined first would be the one that is rendered. Luckily, version 6 of React. Router changed this so now React Router will use an algorithm to determine which route is most likely the one you want.
- It tries to determine which route that matches our URL is the most specific (has the least amount of dynamic elements) (like css specificity) and it will select that route. In our case we obviously want to render the `/books/new` route so React Router will choose that route for us.
- A route that contains a will also be less specific than anything else.

### Nested Routes :

- In the above example we have three routes that start with `/books` so we can nest those routes inside of each other to clean up our routes.
  
    ```jsx
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/books">
        <Route index element={<BookList />} />
        <Route path=":id" element={<Book />} />
        <Route path="new" element={<NewBook />} />
      </Route>
      <Route path="*" element={<NotFound />} />
    </Routes>
    ```
    
- For nesting, Make a parent `Route` that has the `path` prop set to the shared path for all your child `Route` components. Then inside the parent `Route` you can put all the child `Route` components.
- The only difference is that the `path` prop of the child `Route` components no longer includes the shared `/books` route. Also, the route for `/books` is replaced with a `Route` component that has no `path` prop, but instead has an `index` prop. All this is saying is that the path of the index `Route` is the same as the parent `Route`.
- Now if this is all you could do with nested routes it would be only marginally useful, but the true power of nested routes comes in how it handles shared layouts.

### Shared layout :

- If you pass an `element` prop to a parent route, it will render that component for every single child `Route` which means you can put a shared nav or other shared components on every child page with ease.
  
    ```jsx
    <Routes>
     <Route path="/" element={<Home />} />
     <Route path="/books" element={<BooksLayout />}>
       <Route index element={<BookList />} />
       <Route path=":id" element={<Book />} />
       <Route path="new" element={<NewBook />} />
     </Route>
     <Route path="*" element={<NotFound />} />
    </Routes>
    ```
    
    > BookLayout.jsx
    
    ```jsx
    import { Link, Outlet } from "react-router-dom"
    
    export function BooksLayout() {
     return (
       <>
         <nav>
           <ul>
             <li><Link to="/books/1">Book 1</Link></li>
             <li><Link to="/books/2">Book 2</Link></li>
             <li><Link to="/books/new">New Book</Link></li>
           </ul>
         </nav>
         <Outlet />
       </>
     )
    }
    ```
    
- The way our new code will work is whenever we match a route inside the `/books` parent `Route` it will render the `BooksLayout` component which contains our shared navigation.
- Then whichever child `Route` is matched will be rendered wherever the `Outlet` component is placed inside our layout component.
- The `Outlet` component is essentially a placeholder component that will render whatever our current page's content is.
- Now the final way you can share layouts with React Router is by wrapping child `Route` components in a parent `Route` that only defines an `element` prop and no `path` prop.
  
    ```jsx
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/books" element={<BooksLayout />}>
        <Route index element={<BookList />} />
        <Route path=":id" element={<Book />} />
        <Route path="new" element={<NewBook />} />
      </Route>
      <Route element={<OtherLayout />}>
        <Route path="/contact" element={<Contact />} />
        <Route path="/about" element={<About />} />
      </Route>
      <Route path="*" element={<NotFound />} />
    </Routes>
    ```
    
    - This bit of code will create two routes, `/contact` and `/about`, which both are rendered inside the `OtherLayout` component. This technique of wrapping multiple `Route` components in a parent `Route` component with no `path` prop is useful if you want those routes to share a single layout even if they don't have a similar path.

### Outlet Context :

- The final important thing to know about `Outlet` components is they can take in a `context` props which will work just like React context.
  
    ```jsx
    import { Link, Outlet } from "react-router-dom";
    
    export function BooksLayout() {
      return (
        <>
          <nav>
            <ul>
              <li><Link to="/books/1">Book 1</Link></li>
              <li><Link to="/books/2">Book 2</Link></li>
              <li><Link to="/books/new">New Book</Link></li>
            </ul>
          </nav>
    
          <Outlet context={{ hello: "world" }} />
        </>
      )
    }
    ```
    
    ```jsx
    import { useParams, useOutletContext } from "react-router-dom"
    
    export function Book() {
      const { id } = useParams()
      const context = useOutletContext()
    
      return (
        <h1>Book {id} {context.hello}</h1>
      )
    }
    ```
    
    - As you can see from this example, we are passing down a context value of `{ hello: "world" }` and then in our child component we are using the `useOutletContext` hook to access the value for our context.
    - This is a pretty common pattern to use since often you will have shared data between all your child components which is the ideal use case for this context.

### Multiple Routes :

- Another incredibly powerful thing you can do with React Router is use multiple `Routes` components at the same time. This can be done as either two separate `Routes` components or as nested `Routes`.

### Separate routes :

- If you want to render two different sections of content that both depend on the URL of the application then you need multiple `Routes` components.
- This is very common if for example you have a sidebar you want to render certain content in for certain URLs and also a main page that should show specific content based on the URL.
  
    ```jsx
    import { Route, Routes, Link } from "react-router-dom"
    import { Home } from "./Home"
    import { BookList } from "./BookList"
    import { BookSidebar } from "./BookSidebar"
    
    export function App() {
      return (
        <>
          <nav>
            <ul>
              <li><Link to="/">Home</Link></li>
              <li><Link to="/books">Books</Link></li>
            </ul>
          </nav>
    
          <aside>
            <Routes>
              <Route path="/books" element={<BookSidebar />}>
            </Routes>
          </aside>
    
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/books" element={<BookList />} />
          </Routes>
        </>
      )
    }
    ```
    
- In the above example we have two `Routes`.
- The main `Routes` defines all the main components for our page and then we have a secondary `Routes` inside the `aside` that will render the sidebar for our books page when we are at `/books`. This means if our URL is `/books` both of our `Routes` components will render out content since they both have a unique match for `/books` in their `Routes`.
- Another thing that you can do with multiple `Routes` components is hardcode the `location` prop.
  
    ```jsx
    <Routes location="/books">
      <Route path="/books" element={<BookSidebar />}>
    </Routes>
    ```
    
- By hardcoding a `location` prop like this we are overriding the default behavior or React Router so no matter what the URL of our page is this `Routes` component will match its `Route` as if the URL was `/books`.

### Nested routing

- The other way to use multiple `Routes` components is to nest them inside one another. This is pretty common if you have lots of routes and want to clean up your code by moving similar routes into their own files.
  
    ```JavaScript
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/books/*" element={<BookRoutes />} />
      <Route path="*" element={<NotFound />} />
    </Routes>
    ```
    
    ```jsx
    import { Routes, Route } from "react-router-dom"
    import { BookList } from "./pages/BookList"
    import { Book } from "./pages/Book"
    import { NewBook } from "./pages/NewBook"
    import { BookLayout } from "./BookLayout"
    
    export function BookRoutes() {
      return (
        <Routes>
          <Route element={<BookLayout />}>
            <Route index element={<BookList />} />
            <Route path=":id" element={<Book />} />
            <Route path="new" element={<NewBook />} />
            <Route path="*" element={<NotFound />} />
          </Route>
        </Routes>
      )
    }
    ```
    
    - In our case we are moving all our `/books` routes into this `BookRoute` component.
    - Then in the parent `Routes` you need to define a `Route` that has a path equal to the path all your nested `Routes` share. In our case that would be `/books`. The important thing, though, is you need to end your parent `Route` `path` with a otherwise it will not properly match the child routes.

### useRoutes Hook :

- The final thing you need to know about defining routes in React Router is that you can use a JavaScript object to define your routes instead of JSX if you prefer.
- These two components both hae the exact same routes the only difference is how they were defined.
- If you do decide you want to use the `useRoutes` hook all the props that you would normally pass to your `Route` components are instead just passed as key/value pairs of an object.
  
    ```jsx
    import { Route, Routes } from "react-router-dom"
    import { Home } from "./Home"
    import { BookList } from "./BookList"
    import { Book } from "./Book"
    
    export function App() {
      return (
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/books">
            <Route index element={<BookList />} />
            <Route path=":id" element={<Book />} />
          </Route>
        </Routes>
      )
    }
    ```
    
    ```jsx
    import { Route, Routes } from "react-router-dom"
    import { Home } from "./Home"
    import { BookList } from "./BookList"
    import { Book } from "./Book"
    
    export function App() {
      const element = useRoutes([
        {
          path: "/",
          element: <Home />
        },
        {
          path: "/books",
          children: [
            { index: true, element: <BookList /> },
            { path: ":id", element: <Book /> }
          ]
        }
      ])
    
      return element
    }
    ```