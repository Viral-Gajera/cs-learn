Server Action

useFormStatus

useFormState

revalidatePath

Storing File into local System

# Server Action

- Server Actions are **asynchronous functions** that are executed on the server.
- They can be used in Server Components to handle form submissions and data mutations in Next.js applications.
- A Server Action can be defined with the React `"use server"` directive.
- You can place the directive at the top of an `async` function to mark the function as a Server Action, or at the top of a separate file to mark all exports of that file as Server Actions.
- React extends the HTML [`form`](https://developer.mozilla.org/docs/Web/HTML/Element/form) element to allow Server Actions to be invoked with the `action` prop.
- When invoked in a form, the action automatically receives the [`FormData`](https://developer.mozilla.org/docs/Web/API/FormData/FormData) object.
- You don't need to use React `useState` to manage fields, instead, you can extract the data using the native [`FormData`](https://developer.mozilla.org/en-US/docs/Web/API/FormData#instance_methods) [methods](https://developer.mozilla.org/en-US/docs/Web/API/FormData#instance_methods)
- Example:
    
    ```JavaScript
    export default function Page() {
    
        async function shareMeal(formData) {
        	'use server';
    
            const rawFormData = {
                name: formData.get('name'),
                email: formData.get('email'),
                title: formData.get('title'),
                summary: formData.get('summary'),
                instruction: formData.get('instruction'),
                image: formData.get('image'),
            }
    	}
    
        return(
            <form action={shareMeal}>
                <input type="text" id="name" name="name" required >
    	       		<input type="email" id="email" name="email" required />
    			      <input type="text" id="title" name="title" required />
                <input type="text" id="summary" name="summary" required />
                <textarea id="instructions" name="instructions" rows="10" required ></textarea>
                <imput type="file" accept="image/png" name="image" >
    		       	<button type="submit">Share Meal</button>
            </form>
        )
    }
    ```
    

  

Storing server action in separate File :

- Server action not allowed in client component.
- If we use `"use server";` in top of the file, all the function defined in that file treated as server action.
- Example :- action.js
    
    ```JavaScript
    'use server';
    
    export async function shareMeal(formData) {
        const rawFormData = {
            name: formData.get('name'),
            email: formData.get('email'),
            title: formData.get('title'),
            summary: formData.get('summary'),
            instruction: formData.get('instruction'),
            image: formData.get('image'),
        }
    }
    ```
    
    ```JavaScript
    import { shareMeal } from "./action.js"
    
    export default function Page() {
    
        return(
            <form action={shareMeal}>
                <input type="text" id="name" name="name" required >
    			      <input type="email" id="email" name="email" required />
    			      <input type="text" id="title" name="title" required />
                <input type="text" id="summary" name="summary" required />
                <textarea id="instructions" name="instructions" rows="10" required ></textarea>
                <imput type="file" accept="image/png" name="image" >
    			<button type="submit">Share Meal</button>
            </form>
        )
    }
    ```
    

# useFormStatus

- `useFormStatus` is a Hook that gives you status information of the last form submission.
- `useFormStatus` returns the status for a specific `<form>`, so it **must be defined as a child of the** `**<form>**` **element**.
- Example :
    
    SubmitButton.jsx
    
    ```JavaScript
    "use client";
    
    import { useFormStatus } from "react-dom";
    
    export function SubmitButton() {
      const { pending } = useFormStatus();
    
      return (
        <button type="submit" aria-disabled={pending}>
          {pending ? "Submitting..." : "Add"}
        </button>
      );
    }
    ```
    
    Form.jsx
    
    ```JavaScript
    import { SubmitButton } from "@/app/submit-button";
    import { createItem } from "@/app/actions";
    
    // Server Component
    export default async function Home() {
      return (
        <form action={createItem}>
          <input type="text" name="field-name" />
          <SubmitButton />
        </form>
      );
    }
    ```
    

# useFormState

- Server action can also return object as response.
- Returned object should be serializable object (it should not contain any methods).
- Example:
    
    ```JavaScript
    'use server';
    
    async function shareMeal(formData) {
    
         const rawFormData = {
                name: formData.get('name'),
                email: formData.get('email'),
                title: formData.get('title'),
                summary: formData.get('summary'),
                instruction: formData.get('instruction'),
                image: formData.get('image'),
         }
    
         return {
             message: "Data received successfully"
         }
    }
    
    
    ```
    
- `useFormState` used to access that returned object.
- By passing the action to `useFormState`, the action's function signature changes to receive a new `prevState` or `initialState` parameter as its first argument.
- `useFormState` is a React hook and therefore must be used in a Client Component.
- Example:
    
    ```JavaScript
    'use server'
    
    export async function createUser(prevState, formData) {
      // ...
      return {
        message: 'Please enter a valid email',
      }
    }
    ```
    
- Then, you can pass your action to the `useFormState` hook and use the returned `state`.
    
    ```JavaScript
    'use client'
    
    import { useFormState } from 'react-dom'
    import { createUser } from '@/app/actions'
    
    const initialState = {
      message: '',
    }
    
    export function Signup() {
      const [state, formAction] = useFormState(createUser, initialState)
    
      return (
        <form action={formAction}>
          <label htmlFor="email">Email</label>
          <input type="text" id="email" name="email" required />
          {/* ... */}
          <p aria-live="polite" className="sr-only">
            {state?.message}
          </p>
          <button>Sign up</button>
        </form>
      )
    }
    ```
    

# revalidatePath

- `revalidatePath` allows you to purge [cached data](https://nextjs.org/docs/app/building-your-application/caching) on-demand for a specific path.
- Syntax:
    
    ```Plain
    revalidatePath(path: string, type?: 'page' | 'layout'): void;
    ```
    
- `revalidatePath` does not return any value.
- Example:
    
    ```JavaScript
    import { revalidatePath } from 'next/cache'
    revalidatePath('/blog/post-1')	    			// only that path revalidated
    revalidatePath('/blog/post-1', 'layout')	// nested route also validated
    ```
    

  

# Storing File into local System

```TypeScript
import fs from 'node:fs';

import sql from 'better-sqlite3';
import slugify from 'slugify';
import xss from 'xss';

const db = sql('meals.db');

export async function getMeals() {
  await new Promise((resolve) => setTimeout(resolve, 5000));
  return db.prepare('SELECT * FROM meals').all();
}

export function getMeal(slug) {
  return db.prepare('SELECT * FROM meals WHERE slug = ?').get(slug);
}

// Save file to local
export async function saveMeal(meal) {
  meal.slug = slugify(meal.title, { lower: true });
  meal.instructions = xss(meal.instructions);

  const extension = meal.image.name.split('.').pop();
  const fileName = `${meal.slug}.${extension}`;

  const stream = fs.createWriteStream(`public/images/${fileName}`);
  const bufferedImage = await meal.image.arrayBuffer();

  stream.write(Buffer.from(bufferedImage), (error) => {
    if (error) {
      throw new Error('Saving image failed!');
    }
  });

  meal.image = `/images/${fileName}`;

  db.prepare(`
    INSERT INTO meals
      (title, summary, instructions, creator, creator_email, image, slug)
    VALUES (
      @title,
      @summary,
      @instructions,
      @creator,
      @creator_email,
      @image,
      @slug
    )
  `).run(meal);
}
```