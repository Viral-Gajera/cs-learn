## Handling Navigation

- Now that we know how to define our routes we need to talk about how to navigate between those routes. This section will be broken down into three sections.
    1. Link Navigation
    2. Manual Navigation
    3. Navigation Data

# Link Navigation :

1. Link
2. Navlink

### Link :

- First I want to talk about link navigation since it is the simplest and most common form of navigation you will encounter. We have already seen the most basic form of link navigation using the `Link` component
    
    ```JavaScript
    <Link to="/">Home</Link>
    <Link to="/books">Books</Link>
    ```
    
    ```JavaScript
    <Link to="/">Home</Link>
    <Link to="../">Back</Link>
    <Link to="edit">Edit</Link>
    ```
    
- For example imagine we are in the `/books/3` route with the above links.
- The first link will lead to the `/` route since it is an absolute route. Any route that starts with a `/` is an absolute route.
- The second link will lead to the route `/books` since it is a relative link that goes up one level from `/books/3` to `/books`.
- Finally, our third link will go to the `/books/3/edit` page since it will add the path in the `to` prop to the end of the current link since it is a relative link.
- Besides the `to` prop, there are also 3 other props that are important to the `Link` component.
    
    `replace`, `reloadDocument`, `state`
    
    ### `replace`
    
    The `replace` prop is a boolean that when set to `true` will cause this link to replace the current page in the browser history. Imagine you have the following browser history.
    
    ```Plain
    /
    /books
    /books/3
    ```
    
    If you click on a link that goes to the `/books/3/edit` page but it has the `replace` property set to `true` your new history will look like this.
    
    ```Plain
    /
    /books
    /books/3/edit
    ```
    

### NavLink :

- This component works exactly the same as the `Link` component, but it is specifically for showing active states on links, for example in nav bars.
- By default if the `to` property of a `NavLink` is the same as the URL of the current page the link will have an `active` class added to it which you can use for styling.
- If this is not enough you can instead pass a function with an `isActive` parameter to the `className`, or `style` props, or as the children of the `NavLink`.
    
    ```JavaScript
    <NavLink
      to="/"
      style={({ isActive }) => ({ color: isActive ? "red" : "black" })}
    >
      Home
    </NavLink>
    ```
    
- The `NavLink` also has one prop called `end` which is used to help with nested routing.

  

# Manual Navigation

- Now sometimes you want to manually navigate a user based on things like submitting a form or not having access to a specific page.
- For those use cases you will need to either use the `Navigate` component or the `useNavigation` hook.

### Navigate Component

- The `Navigate` component is a really simple component that when rendered will automatically redirect the user to the `to` prop of the `Navigate` component.
    
    ```JavaScript
    <Navigate to="/" />
    ```
    
- The `Navigate` component shares all the props of the `Link` component so you can pass it the `to`, `replace`, and `state` props.
- This component is not really something I use much as more often than not I want to redirect a user based on some form of interaction like a form submission.

### useNavigation Hook

- This hook is a really simple hook that takes no parameters and returns a single `navigate` function which you can use to redirect a user to specific pages.
- This `navigate` function takes two parameters. The first parameter is the `to` location you want to redirect the user to and the second parameter is an object that can have keys for `replace`, and `state`.
    
    ```JavaScript
    const navigate = useNavigate()
    
    function onSubmit() {
      // Submit form results
      navigate("/books", { replace: true, state: { bookName: "Fake Title" }})
    }
    ```
    
- The above code will redirect the user to the `/books` route. It will also replace the current route in history and pass along some state information as well.
- Another way you can use the `navigate` function is to pass it a number. This will allow you to simulate hitting the forward/back button.
    
    ```Plain
    navigate(-1) // Go back one page in history
    navigate(-3) // Go back three pages in history
    navigate(1) // Go forward one page in history
    ```
    

# Navigation Data :

- Finally it is time to talk about passing data between pages. There are 3 main ways you can pass data between pages.
    1. Dynamic Parameters
    2. Search Parameters
    3. State/Location Data

### Dynamic Parameters

- We have already talked about how to use dynamic parameters in URLs by using the `useParams` hook. This is the best way to handle passing information like ids.

### Search Parameters

- Search parameters are all of the parameters that come after the `?` in a URL (`?name=Kyle&age=27`). In order to work with search parameters you need to use the `useSearchParams` hook which works very similarly to the `useState` hook.
    
    ```JavaScript
    import { useSearchParams } from "react-router-dom"
    
    export function SearchExample() {
      const [searchParams, setSearchParams] = useSearchParams({ n: 3 })
      const number = searchParams.get("n")
    
      return (
        <>
          <h1>{number}</h1>
          <input
            type="number"
            value={number}
            onChange={e => setSearchParams({ n: e.target.value })}
          />
        </>
      )
    }
    ```
    
- In this example we have an input that as we type in will update the search portion of our URL.
- For example if our input has the value of 32 our URL will look like `http://localhost:3000?n=32`.
- The `useSearchParams` hook takes an initial value just like `useState` and in our case our initial value has `n` set to 3.
- This hook then returns two values. The first value is all our our search parameters and the second value is a function for updating our search parameters.
- The set function just takes a single argument that is the new value of your search parameters. The first value that contains the search parameters is a bit more confusing, though. This is because this value is of the type `URLSearchParams`. That is why we need to use the `.get` syntax on line 5 above.

### State/Location Data

- The final type of data you can store is state and location data. This information is all accessible via the `useLocation` hook. Using this hook is very simple as it returns one value and takes no parameters.
    
    ```JavaScript
    const location = useLocation()
    ```
    
- If we have the following URL `http://localhost/books?n=32\#id` then the return value of `useLocation` would look like this.
    
    ```Plain
    {
      pathname: "/books",
      search: "?n=32",
      hash: "\#id",
      key: "2JH3G3S",
      state: null
    }
    ```
    
- This location object contains all the information related to our URL. It also contains a unique key that you can use to do caching if you want to cache information for when a user clicks the back button to come back to a page.
- You also will notice that we have a state property being returned from `useLocation` as well. This state data can be anything and is passed between pages without being stored in the URL. For example if you click on a `Link` that looks like this:
    
    ```JavaScript
    <Link to="/books" state={{ name: "Kyle" }}>
    ```
    
- Then the state value in the location object will be set to `{ name: "Kyle" }`.
- This can be really useful if for example you wan to send across simple messages between pages that shouldn't be stored in the URL. A good example of this would be something like a success message that gets sent to the page you are redirected to after creating a new book.