# Page Load and UnloadEvent

- When you open a page, the following events occur in sequence:
    - DOMContentLoaded
    - load
- When you leave the page, the following events fire in sequence:
    - beforeunload
    - unload

## (i) DOMContentLoaded:

- The DOMContentLoaded event fired when, the browser fully loaded HTML and completed building the DOM tree.
- However, it hasn’t loaded external resources like stylesheets and images. 
- In this event, you can start selecting DOM nodes or initialize the interface.

## (ii) load:

- The load event is fired when the whole webpage (HTML) has loaded fully, including all dependent resources, including JavaScript files, CSS files, and images.
- The `<img>`, `<script>`... elements also support the load event.

## (iii) beforeunload:

- The beforeunload event fires before the page and resources are unloaded.
- You can use this event to show a confirmation dialog to confirm if you really want to leave the page.
- you need to call the preventDefault() method inside the beforeunload event handler in order to show the confirmation dialog.

```js
window.addEventListener('beforeunload',(e) => {
    e.returnValue = '' ;
    // e.preventDefault();
});
```

## (iv) unload :

- Fires when the page has completely unloaded. 
- You can use this event to send the analytic data or to clean up resources.





# Defer and Async load

<img src="Async & Defer.png">

<img src="Regular Vs Async Vs Defer.png">