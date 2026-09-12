# Introduction

- Next.js is React framework for production.
- Features :
    - Full Stack application
    - File based routing
    - Server Side Rendering.
    - Pre Rendering (SEO Efficiency)
    - Typescript Support.
    - Support for CSS modules (CSS for each pages).

# Installation

- Use following command to install next.js

```Shell
npx create-next-app@latest

# Running Project
npm run dev

# Build Project & start production server
npm run build
npm start 
```    

  
# App Router vs Pages Router

- Next.js has two different routers: the `App Router` and the `Pages Router`.
- The App Router is a newer router that allows you to use React's latest features, such as Server Components and Streaming.
- The Pages Router is the original Next.js router, which allowed you to build server-rendered React applications and continues to be supported for older Next.js applications.

  
# Folder Structure

### Top-level folders

```Plain
app      : App Router
pages    : Pages Router
public   : Static assets to be served
src		 : Optional application source folder
```

### App Routing convention

Routing `Files` :

```Plain
page			    : Define page content
layout		     	: Define wrapper arount page
loading		    	: Loading UI
error			    : Error UI
not-found	    	: Not found UI
global-error    	: Global error UI
route			    : API endpoint
template    	  	: Re-rendered layout
default		    	: Parallel route fallback page
```

Nested Routes :

```Plain
folder			    : Route segment
folder/folder   	: Nested route segment
```

Dynamic Routes :

```Plain
[folder]	    	: Dynamic route segment
[...folder]	    	: Catch-all route segment
[[...folder]]   	: Optional catch-all route segment
```

### Page Routing convention

Special `Files` :

```Plain
_app        : custom app
_document	: custom document
_error		: custom error page
404		   	: 404 error page
500		  	: 500 error page
```

Routes :

```Plain
# Folder convention
index			    : Home page
folder/index    	: Nested page

# File convention
index		     	: Home page
file	    		: Nested page
```

Dynamic Routes :

```Plain
# Folder convention
[folder]/index   		: Dynamic route segment
[...folder]/index    	: Catch-all route segment
[[...folder]]/index  	: Optional catch-all route segment

# File convention
[file]		  		: Dynamic route segment
[...file]		  	: Catch-all route segment
[[...file]]			: Optional catch-all route segment
```

# Notes :

- `@/component/mycomp.js` here `@` refers to root of the folder.
- We can also use node.js package like, `import fs from 'node:fs';`.

# Environment Variable

- Next.js comes with built-in support for environment variables.
- It allows you to do the following :
    - Use `.env.local` to load environment variables
    - Bundle environment variables for the browser by prefixing with `NEXT_PUBLIC_`.
- Example : `.env.local`

```Python
-> For Api :

DB_HOST=localhost
DB_USER=myuser
DB_PASS=mypassword

# process.env.DB_HOST
# process.env.DB_USER
# process.env.DB_PASS

-> For Brower :

NEXT_PUBLIC_URL=abcdefghijk
NEXT_PUBLIC_ANALYTICS_ID=abcdefghijk

# process.env.NEXT_PUBLIC_URL
# process.env.NEXT_PUBLIC_ANALYTICS_ID
```

# Import Image

```JavaScript
import myLogo from '@/assets/logo.png'

export default function(){
    return (
        <header>
        	<img src={myLogo.src} alt=""/>		    // Unlike react src={myLogo}, 
										        	// have use src={myLogo.src}
            <img src="path" alt=""/>
            
            <Image src={myLogo} alt="" />		    // like react src={myLogo}
                          							// width="" height="" auto calculated
                          							
            <Image src="path" alt="" width="" height="" priority/>
            	               						// width="" height="" props required
            	               						
            <Image src="path" alt="" fill priority/>
            								        // alternative `fill`
        </header>
    );
}
```

