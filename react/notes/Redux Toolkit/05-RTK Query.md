# RTK Query

- **RTK Query** is a powerful data fetching and caching tool.
- The data fetching and caching logic is built on top of Redux Toolkit's `createSlice` and `createAsyncThunk` APIs.
- RTK Query is included within the installation of the core Redux Toolkit package. It is available via either of the two entry points below:

```JavaScript
import { createApi } from '@reduxjs/toolkit/query'

/* React-specific entry point that automatically generates
   hooks corresponding to the defined endpoints */
import { createApi } from '@reduxjs/toolkit/query/react'
```

RTK Query primarily consists of two APIs:

- `createApi()`:
    - The core of RTK Query's functionality.
    - It allows you to define a set of endpoints describe how to retrieve data from a series of endpoints, including configuration of how to fetch and transform that data.
    - In most cases, you should use this once per app, with "one API slice per base URL" as a rule of thumb.
- `fetchBaseQuery()`:
    - A small wrapper around [`fetch`](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API) that aims to simplify requests.
    - Intended as the recommended `baseQuery` to be used in `createApi` for the majority of users.

  

# **Defining an API Slice**

- Previously, we've defined separate "slices" for each of our different data types like Posts, Users, and Notifications.
- With RTK Query, **the logic for managing cached data is centralized into a single "API slice" per application**.  
      
    

> apiSlice.js

```JavaScript
import { createApi, ApiProvider } from '@reduxjs/toolkit/query/react'

const api = createApi({
  baseQuery: () => {},
  endpoints: (build) => ({
	  // end point - 1
    pokemonList: build.query({
      async queryFn() {
        const result = await fetch("https://pokeapi.co/api/v2/pokemon?limit=9");
        if (result.ok) {
          const data = await result.json();
          return { data };
        } else {
          return { error: "something went wrong" };
        }
      },
    }),
    // end point - 2
    pokemonDetail: build.query({
      async queryFn({ name }) {
        const result = await fetch(
          `https://pokeapi.co/api/v2/pokemon/${name}/`
        );
        if (result.ok) {
          const data = await result.json();
          return { data };
        } else {
          return { error: "something went wrong" };
        }
      },
    }),
    // end endpoint
  }),
});

// Exporting
// The hooks are automatically named based on a standard convention:
// use, the normal prefix for any React hook
// The name of the endpoint, capitalized
// The type of the endpoint, Query or Mutation
const { usePokemonListQuery, usePokemonDetailQuery } = api;

// Rendoring
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <ApiProvider api={api}>
      <App />
    </ApiProvider>
  </React.StrictMode>
);

// Using hooks
const { isLoading, isError, isSuccess, data } = usePokemonListQuery();
const { isLoading, isError, isSuccess, data } = usePokemonDetailQuery({name: "abc"});

// Another way of using hook
const { pokemon } = usePokemonListQuery(undefined, {
  selectFromResult: ({ data }) => ({
    post: data?.find((pokemon) => pokemon.id === id),
  }),
})
```

- Query hooks return a `data` value, plus loading status flags.
- It's also important to note that **the query parameter must be a** _**single**_ **value!** If you need to pass through multiple parameters, you must pass an object containing multiple fields
- `selectFromResult` allows you to get a specific segment from a query result in a performant manner.
- When using this feature, the component will not rerender unless the underlying data of the selected item has changed.  
      
    
- Rewrite code with `baseQuery`.

```JavaScript
const api = createApi({
  baseQuery: async (url) => {
    const result = await fetch(url);
    if (result.ok) {
      const data = await result.json();
      return { data };
    } else {
      return { error: "something went wrong" };
    }
  },
  endpoints: (build) => ({
    pokemonList: build.query({
      query() {
        return "https://pokeapi.co/api/v2/pokemon?limit=9";
      },
    }),
    pokemonDetail: build.query({
      query({ name }) {
        return `https://pokeapi.co/api/v2/pokemon/${name}/`;
      },
    }),
  }),
});
```

- Rewriting code with `fetchBaseQuery`.

```JavaScript
const api = createApi({
  baseQuery: fetchBaseQuery({
    baseUrl: "https://pokeapi.co/api/v2/",
  }),
  endpoints: (build) => ({
    pokemonList: build.query({
      query() {
        return {
          // these are specific to `fetchBaseQuery`
          url: "pokemon",
          params: { limit: 9 },
          // all the different arguments that you could also pass into the `fetch` "init" option
          // see https://developer.mozilla.org/en-US/docs/Web/API/fetch\#parameters
          method: "GET", // GET is the default, this could be skipped
        };
      },
    }),
    pokemonDetail: build.query({
      query: ({ name }) => `pokemon/${name}/`,
    }),
  }),
});
```

- Rewriting code with normal `configureStore` and typescript.

```TypeScript
import React from "react";
import ReactDOM from "react-dom/client";
import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

import { configureStore } from "@reduxjs/toolkit";
import { Provider } from "react-redux";

interface PokemonListing {
  count: number;
  results: Array<{name: string; url: string;}>;
}

interface PokemonDetailData {
  id: number;
  name: string;
  height: number;
  weight: number;
  types: Array<{
	  slot: number;
    type: {
      name: string;
      url: string;
    };
  }>;
  sprites: {
    front_default: string;
  };
}

const api = createApi({
  baseQuery: fetchBaseQuery({
    baseUrl: "https://pokeapi.co/api/v2/",
  }),
  endpoints: (build) => ({
    pokemonList: build.query<PokemonListing, void>({
      query : () => {url: "pokemon", params: { limit: 9 }, method: "GET"},
    }),
    pokemonDetail: build.query<PokemonDetailData, { name: string }>({
      query: ({ name }) => `pokemon/${name}/`,
    }),
  }),
});

const { usePokemonListQuery, usePokemonDetailQuery } = api;

const store = configureStore({
  reducer: {
    [api.reducerPath]: api.reducer,                                  // 1
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(api.middleware),                   // 2
});

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <Provider store={store}>
      <App />
    </Provider>
  </React.StrictMode>
);

function App() {
  const [selectedPokemon, selectPokemon] = React.useState<string | undefined>(undefined);

  return (
    <>
      <header>
        <h1>My Pokedex</h1>
      </header>
      <main>
        {selectedPokemon ? (
          <>
            <PokemonDetails pokemonName={selectedPokemon} />
            <button onClick={() => selectPokemon(undefined)}>back</button>
          </>
        ) : (
          <PokemonList onPokemonSelected={selectPokemon} />
        )}
      </main>
    </>
  );
}

function PokemonList({onPokemonSelected} : {onPokemonSelected: (pokemonName: string) => void}) 
{
  const { isUninitialized, isLoading, isError, isSuccess, data } = usePokemonListQuery();

  if (isLoading || isUninitialized) {
    return <p>loading, please wait</p>;
  }

  if (isError) {
    return <p>something went wrong</p>;
  }

  return (
    <article>
      <h2>Overview</h2>
      <ol start={1}>
        {data.results.map((pokemon) => (
          <li key={pokemon.name}>
            <button onClick={() => onPokemonSelected(pokemon.name)}>
              {pokemon.name}
            </button>
          </li>
        ))}
      </ol>
    </article>
  );
}

const listFormatter = new Intl.ListFormat("en-GB", {
  style: "short",
  type: "conjunction",
});

function PokemonDetails({ pokemonName }: { pokemonName: string }) 
{
  const { isUninitialized, isLoading, isError, isSuccess, data } = usePokemonDetailQuery({name: pokemonName});

  if (isLoading || isUninitialized) {
    return <p>loading, please wait</p>;
  }

  if (isError) {
    return <p>something went wrong</p>;
  }

  return (
    <article>
      <h2>{data.name}</h2>
      <img src={data.sprites.front_default} alt={data.name} />
      <ul>
        <li>id: {data.id}</li>
        <li>height: {data.height}</li>
        <li>weight: {data.weight}</li>
        <li>
          types:
          {listFormatter.format(data.types.map((item) => item.type.name))}
        </li>
      </ul>
    </article>
  );
}
```

  

# createApi

- RTK Query's functionality is based on a single method, called `createApi`.
- **Your application is expected to have only one** `**createApi**` **call in it**.
- This one API slice should contain _all_ endpoint definitions that talk to the same base URL. 
- If your app does fetch data from multiple servers, you can either specify full URLs in each endpoint, or if necessary create separate API slices for each server.

### **Parameters**

```JavaScript
baseQuery                    // Used by each endpoint if no queryFn option is specified  
endpoints                    // There are two basic endpoint types: query and mutation
reducerPath                  // 
extractRehydrationInfo       // 
tagTypes                     // 
serializeQueryArgs           // 
keepUnusedDataFor            // how long RTK Query will keep your data cached (second)
refetchOnMountOrArgChange    // 
refetchOnFocus               // 
refetchOnReconnect           // 
```

- `reducerPath` field, which defines the expected top-level state slice field for the generated reducer.
- Here, `createApi` expects us to tell it where the cache state will exist when we add the cache reducer to the store.
- If you don't provide a `reducerPath` option, it defaults to `'api'`, so all your RTKQ cache data will be stored under `state.api`

### Anatomy of an endpoint

```TypeScript
query                         // required if no queryFn provided
queryFn                       // required if no query provided
transformResponse             // optional, not applicable with queryFn, manipulate the data returned by a query or mutation
transformErrorResponse        // optional, not applicable with queryFn, anipulate the data returned by a failed query or mutation.
extraOptions                  // Passed as the third argument to the supplied function baseQuery
providesTags                  // optional, only for query endpoints, 
invalidatesTags               // optional, only for mutation endpoints
keepUnusedDataFor             // optional, only for query endpoints, Overrides the api-wide definition of for this endpoint only
serializeQueryArgs            // optional, only for query endpoint, 
merge                         // optional, only for query endpoints, merge an incoming response value into the current cache data
forceRefetch                  // optional, only for query endpoints, useful for infinite scroll / pagination 
onQueryStarted                // optional, function that is called when you start each individual query or mutation
onCacheEntryAdded             // optional, function that is called when a new cache entry is added
```

- By default, **unused data is removed from the cache after 60 seconds**,
- But this can be configured in either the root API slice definition or overridden in the individual endpoint definitions using the `keepUnusedDataFor` flag, which specifies a cache lifetime in seconds.  
      
      
    

# fetchBaseQuery

- This is a very small wrapper around [`fetch`](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API) that aims to simplify HTTP requests. 
- It is not a full-blown replacement for `axios`, `superagent`, or any other more heavyweight library, but it will cover the vast majority of your HTTP request needs.
- `fetchBaseQuery` is a factory function that generates a data fetching method compatible with RTK Query's `baseQuery` configuration option.  
      
    

### **Parameters**

```TypeScript
baseUrl                  // required, 
prepareHeaders           // inject headers on every request
paramsSerializer         // apply custom transformations to the data passed into params. 
fetchFn                  // Can be useful in SSR environments
timeout                  // A number in milliseconds that represents the maximum time a request can take before timing out.
isJsonContentType        // default implementation inspects the content-type header, and will match values like "application/json" and "application/vnd.api+json".
jsonContentType          // automatically setting the content-type header for a request with a jsonifiable body that does not have an explicit content-type header
```

  

- By default, `fetchBaseQuery` assumes that every request you make will be `json`, so in those cases all you have to do is set the `url` and pass a `body` object when appropriate. For other implementations, you can manually set the `Headers` to specify the content type.  
      
    

  

# ApiProvider

- Can be used as a `Provider` if you **do not already have a Redux store**.

```JavaScript
import * as React from 'react';
import { ApiProvider } from '@reduxjs/toolkit/query/react';
import { Pokemon } from './features/Pokemon';

function App() {
  return (
    <ApiProvider api={api}>
      <Pokemon />
    </ApiProvider>
  )
```

# Updating data

- **Mutation endpoints allow updating data on the server**
- Example:

```JavaScript
export const apiSlice = createApi({
  reducerPath: 'api',
  baseQuery: fetchBaseQuery({ baseUrl: '/fakeApi' }),
  endpoints: builder => ({
    getPosts: builder.query({
      query: () => '/posts'
    }),
    getPost: builder.query({
      query: postId => `/posts/${postId}`
    }),
    addNewPost: builder.mutation({
      query: initialPost => ({
        url: '/posts',
        method: 'POST',
        // Include the entire post object as the body of the request
        body: initialPost
      })
    })
  })
})

export const {
  useGetPostsQuery,
  useGetPostQuery,
  useAddNewPostMutation
} = apiSlice
```

- Mutation hooks return a "trigger" function that sends an update request, plus loading status
- The trigger function returns a Promise that can be "unwrapped" and awaited

```JavaScript
import React, { useState } from 'react'
import { useSelector } from 'react-redux'

import { Spinner } from '../../components/Spinner'
import { useAddNewPostMutation } from '../api/apiSlice'
import { selectAllUsers } from '../users/usersSlice'

export const AddPostForm = () => {
  const [title, setTitle] = useState('')
  const [content, setContent] = useState('')
  const [userId, setUserId] = useState('')

  const [addNewPost, { isLoading }] = useAddNewPostMutation()
  const users = useSelector(selectAllUsers)

  const onTitleChanged = e => setTitle(e.target.value)
  const onContentChanged = e => setContent(e.target.value)
  const onAuthorChanged = e => setUserId(e.target.value)

  const canSave = [title, content, userId].every(Boolean) && !isLoading

  const onSavePostClicked = async () => {
    if (canSave) {
      try {
        awaitaddNewPost({ title, content,user: userId }).unwrap()
        setTitle('')
        setContent('')
        setUserId('')
      } catch (err) {
        console.error('Failed to save the post: ', err)
      }
    }
  }

  // omit rendering logic
}
```

  

# Automatic Refreshing with Cache Invalidation

- RTK Query lets us define relationships between queries and mutations to enable automatic data refetching, using "tags".
- A "tag" is a string or small object that lets you name certain types of data, and invalidate portions of the cache.
- When a cache tag is invalidated, RTK Query will automatically refetch the endpoints that were marked with that tag.
- Basic tag usage requires adding three pieces of information to our API slice:
    - A root `tagTypes` field in the API slice object, declaring an array of string tag names for data types such as `'Post'`
    - A `providesTags` array in query endpoints, listing a set of tags describing the data in that query.
    - An `invalidatesTags` array in mutation endpoints, listing a set of tags that are invalidated every time that mutation runs

  

- We can add a single tag called `'Post'` to our API slice that will let us automatically refetch our `getPosts` endpoint any time we add a new post:
    
    ```JavaScript
    export const apiSlice = createApi({
      reducerPath: 'api',
      baseQuery: fetchBaseQuery({ baseUrl: '/fakeApi' }),
      tagTypes: ['Post'],
      endpoints: builder => ({
        getPosts: builder.query({
          query: () => '/posts',
          providesTags: ['Post']
        }),
        getPost: builder.query({
          query: postId => `/posts/${postId}`
        }),
        addNewPost: builder.mutation({
          query: initialPost => ({
            url: '/posts',
            method: 'POST',
            body: initialPost
          }),
          invalidatesTags: ['Post']
        })
      })
    })
    ```
    

  

- Note that there's nothing special about the literal string `'Post'` here.
- We could have called it `'Fred'`, `'qwerty'`, or anything else.
- It just needs to be the same string in each field, so that RTK Query knows "when this mutation happens, invalidate all endpoints that have that same tag string listed".

  

# **Injecting Endpoints**

- It's common for larger applications to "code-split" features into separate bundles, and then "lazy load" them on demand as the feature is used for the first time.
- We said that RTK Query normally has a single "API slice" per application, and so far we've defined all of our endpoints directly in `apiSlice.js`.
- What happens if we want to code-split some of our endpoint definitions, or move them into another file to keep the API slice file from getting too big?

  

- **RTK Query supports splitting out endpoint definitions with** `**apiSlice.injectEndpoints()**`.
- To illustrate this process, let's switch the `getUsers` endpoint to be injected in `usersSlice.js`, instead of defined in `apiSlice.js`.
- We're already importing `apiSlice` into `usersSlice.js` so that we can access the `getUsers` endpoint, so we can switch to calling `apiSlice.injectEndpoints()` here instead.

> **features/users/usersSlice.js**

```JavaScript
import { apiSlice } from '../api/apiSlice'

export const extendedApiSlice = apiSlice.injectEndpoints({
  endpoints: builder => ({
    getUsers: builder.query({
      query: () => '/users'
    })
  })
})

export const { useGetUsersQuery } = extendedApiSlice

export const selectUsersResult = extendedApiSlice.endpoints.getUsers.select()
```

- `injectEndpoints()` **mutates the original API slice object to add the additional endpoint definitions, and then returns it**.
- The actual caching reducer and middleware that we originally added to the store still work okay as-is.
- At this point, `apiSlice` and `extendedApiSlice` are the same object, but it can be helpful to refer to the `extendedApiSlice` object instead of `apiSlice` here as a reminder to ourselves. (This is more important if you're using TypeScript, because only the `extendedApiSlice` value has the added types for the new endpoints.)
- At the moment, the only file that references the `getUsers` endpoint is our index file, which is dispatching the `initiate` thunk. We need to update that to import the extended API slice instead:

```JavaScript
  // omit other imports
- import { apiSlice } from './features/api/apiSlice'
+ import { extendedApiSlice } from './features/users/usersSlice'


  async function main() {
    // Start our mock API server
    await worker.start({ onUnhandledRequest: 'bypass' })


-   store.dispatch(apiSlice.endpoints.getUsers.initiate())
+   store.dispatch(extendedApiSlice.endpoints.getUsers.initiate())


    ReactDOM.render(
      <React.StrictMode>
        <Provider store={store}>
          <App />
        </Provider>
      </React.StrictMode>,
      document.getElementById('root')
    )
  }
  main()
```