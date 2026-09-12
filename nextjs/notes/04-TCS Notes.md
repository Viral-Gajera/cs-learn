Section 3: App routing

```jsx
Server and Client Component

folder
[folder]
(folder)

layout.js
page.js
error.js
loading.js

<Suspence fallback={} ></Suspence>

not-found.js 
notFound() function for manual trigger

Server action
"use server";
async keyword must
<form action="serverActionFn" ></form>
server action accepts 'formData' as argument
server action can not be created in client component

"use server";
When declared at top of file, all the function inside that file treated as server action.
When declared at top of function, the function treated as server action.
If we want to use server action it client component then we much create separate file.

slugify
xss
slugify(meal.title, {lower:true})
xss(meal.instruction)

useFormStatus() Hook  -> for accessing forms loading state
renamed useActionState()
status.pending = true|false;
only works in client component
must be inside <form></form> element

From validation in server action
throw Error() if it does not satisfies condition
return serializable object like { message: '' }
serializable object -> does't contain any methods

useFormState() hook
to access return value from server action
const [ responce, formAction ] = useFormState(serverActionFn, initialResponce)
serverActionFn(prevState, formData){}
only works in client component

Next.js caching
npm run build
npm run start
Revalidating caches
revalidatePath('/meals', 'layout');

Static metadata
meta data exported in root layout sets metadata for entire application
if we want to override this metadata then export it in corresponding page file

Dynamic metadata
export async function generateMetadata({params}){
	return {
		title: "",
		description: ""
	}
}
```

Section 4: Routing & Page Rendering

```jsx
Parallel routes
Create layout.js file and @pr1 and @pr2 folder
export default Layout({pr1, pr2}){
	return <div>
		{pr1}
		{pr2}
	</div>
}

default.js
Used when one parallel route has some nested path that other parallel route don't have

catch all route 
[...slug]

Optional catch all route
[[...slug]]

manually trigerring error.js 
error component should be client component

usePathname() hook

Interception route
Show different content while transition of route from specific route.
For same path different pages are shown depending on how you got there.
(.)route

Navigating programmatically
useRouter()

Route Groups: (foldername)

Creating api with route.js
middleware.js in root directory
export default middleware(request){}
export const config = {matcher:''}
```

Section 5: Data Fetching

```jsx
Client side data fetching 
Server side data fetching
```

Section 6: Mutating data

```jsx
- React feature
- Form action
- "use server";
- must be async

~~~~redirect
- Navigating programmatically
- import { redirect } from 'next/navigation';

useFormStatus() hook
- for showing loading state while submitting form
- const status = useFormStatus();
- status.pending = true|false;
- renamed to useActionState()

useFromState() hook
- capture the data returned by server action
- const [ responce, formAction ] = useFormState(serverActionFn, initialResponce)
- serverActionFn(prevState, formData){}
- only works in client component

revalidatePath()

Optimistic update
- useOptimistic()
- const [state, updateState] = useOptimistic(intialState, (previousStat, arg1, arg2)=>{})
- updateState(arg1, arg2)

Production caching
```

Section 7: Caching

```jsx
Caching types
1. Request memorization - stores and serves requests with same configuration
2. Data cache - store and reuse fetched data until it revalidated
3. Full route cache - stores the rendered HTML & RSC at build time
4. Route cache - stores the RSC payload in memory in browser

Request memorization
- Whenever we have two api call with exact same configuration, the request only sent once.
- Remember - the requests were sent express backend
- Not in next 15

Data cache
- If request sent again with same configuation then cached responce will be returned.
- Remember - the requests were sent express backend

fetch('url', { catch: 'no-store|force-cache' })    ----(1)
fetch('url', { next: { revalidate : 5 } })         ----(2)

export const dynamic = 'force-dynamic';            ----(same as 1)
export const revalidate = 5;                       ----(same as 2)

import { noStore } from 'next/cache';
noStore();

Full route cache
- Build time
- stores the rendered HTML & RSC at build time
- can be fixed with above 3 techniques
- also can be fixed with revalidatePath() (more efficient)
- revalidateTag() 

Custom data source (like directly fetching data form database in server side):
- dont have request memorization
- dont have data cache
- full route cache still there 

import { cache } from 'react';
- to implement request memorization

import { unstable_cache } from 'next/cache';
- to implement data cache
```

Section 8: Next App Optimization

```
Image optimization
- If image is part of website then import the image file and set to image component using... 
- <Image src={logo} alt="" />
- If case of locally imported image no need to specify width and height
- However <Image src={logo.**src**} alt="" width="" height="" /> requires width and height
- loading="lazy", priority

- If image is part of user generated image then set url of image to image component... 
- <Image src={imageUrl} alt="" fill />
- here fill (or width & height) attribute required, but fill is recommandad
- fill attribute (position: absolute)

Note: whenever we are loading image from external resouce, we need to configure hostName in next.config,js

Cloudnairy
- File storage
- Images are generated for different sizes and cached

Adding page metadata
```

Section 9: User Authentication

```
Authentication
Authorization
Lucia library for session management
```

Q. How to create and navigate route in next.js?

- Next.js uses file-based routing.
- To create route e.g. `about`, create folder named about and create page.ts file in that folder.
- To navigate from route to another route we use the component `<Link href='' >Text</Link>` provided by `next/link`.

Q. What is the difference between `server component` and `client component`?

Server component:

- It is executed & build at server side and sends built html to client side (If we write console.log in server component then it won’t show in browser console)
- By default, all the components are server components in next.js.
- Server component can be `async`.

Client component:

- It is executed & build at client side, means html file is created at client side.
- Hooks like `useState`, `useEffect` etc. are only available in client components.
- Event handlers also only available in client components.
- To create client component use directive `"use client";` at top of the component file.
- A child component of a client component becomes:
  - a client component if imported.
  - remains the same (can still be server component) if passed as children.

Note: server component is also available in react.

Q. What are the `layout` files in next.js?

- It is used to create a new layout that wraps sibling and nested pages.
- Props `children` of layout.tsx file represents content of `page.tsx` component.
- Every next project requires one root layout file.
- Root layout file renders html and body section of webpage.
- Root layout also imports `./globals.css` that applies to every component.

Q. What is special constant variable `metadata` in layout.tsx file?

- It used to define your application metadata like title, description etc.
- `metadata` is a reserved name.

Q. How to set `favicon` in next.js?

- To set `favicon`, add `favicon.ico` file in app folder.

Q. Which are the reserved files in app folder.

```
page.js      => Create a new page
layout.js    => Create a new layout that wraps sibling and nested pages
loading.js   => Fallback page which is shown whilst sibling or nested pages (or layouts) are fetching data

not-found.js => Fallback page for "Not Found" errors (thrown by sibling or nested pages or layouts)
error.js     => Fallback page for other errors (thrown by sibling pages or nested pages or layouts)
route.js     => Allows you to create an API route (i.e., a page which does NOT return JSX code but instead data, e.g., in the JSON format)
```

Q. How to create dynamic route in next.js?

- Create folder with square bracket and dynamic slug name `[postId]`.
- Inside that folder create `page.tsx` file.
- Dynamic params will the accessible via `params` props.

```jsx
interface PageParams {
    params: {
        postId: string;
    };
}

export default function ({ params }: PageParams) {
    return <div className="container mx-auto p-2" >This is blog post {params.postId}</div>
}
```

Q. How to access navigation path?

```jsx
import { usePathname } from "next/navigation";

export default function () {
		const path = usePathname();
}
```

Q. Different ways of accessing images in `asset` folder?

Way 1:

```jsx
import logoImg from '@/assets/logo.png'

<img src={logoImg.src} alt="" />
```

Q. what are the built-in components provided by next.js?

```jsx
Image
Link
```

Q. What is the difference between normal `<img>` and `<Image>` component provided by next.js?

- <Image> component used to optimize the image by lazy loading it.

```jsx
<Image src="" width="" height="">
<Image src="" fill>
```

Q. What is `loading.tsx` file?

- It provides way to display content while next.js fetching server component.
- Note: it is not displayed when fetching data using `fetch`.
- It renders as children of layout file while page is being fetch by next.js.
- It is applied to sibling or nested pages