# Read the current URL

- `usePathname` is a Client Component hook that lets you read the current URL's **pathname**.
- Example :

```jsx
'use client';

import { usePathname } from 'next/navigation';

export default function () {
  const pathname = usePathname()
  return <p>Current pathname: {pathname}</p>
}
```

# Read a route's dynamic params

- `useParams` is a Client Component hook that lets you read a route's [dynamic params](https://nextjs.org/docs/app/building-your-application/routing/dynamic-routes) filled in by the current URL.
- Example:

```JavaScript
'use client';

import { useParams } from 'next/navigation'

export default function () {
  const params = useParams()

  // Route    -> /shop/[tag]/[item]
  // URL      -> /shop/shoes/nike-air-max-97
  // `params` -> { tag: 'shoes', item: 'nike-air-max-97' }
  console.log(params)

  return <></>
}
```


  

- Another Method:
    
    ```JavaScript
    export default function Page({ params }) {
      return <div>My Post: {params.slug}</div>
    }
    ```
    

# Redirect

```JavaScript
import { redirect } from 'next/navigation'

export default function () {
	redirect("/shop")
    return (<div>
	    This is My Component!
		 </div>
		);
}
```

# Note :

- `not-fount.js` can manually be trigger my function `notFound()`, provided by next.js.