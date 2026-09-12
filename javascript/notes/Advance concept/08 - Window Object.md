# Window object

- It is global object.

### Page redirection

- Following properties and methods are used to redirect the page.
    
    ```Plain
    window.location.href = "url"
    window.location.replace("url");
    
    window.location = "url";
    window.open("url");
    ```
    
    Example :
    
    ```JavaScript
    // Simulate a mouse click:
    window.location.href = "<http://www.w3schools.com>";
    
    // Simulate an HTTP redirect:
    window.location.replace("<http://www.w3schools.com>");
    ```
    

### Height and Weight

- The read-only [`Window`](https://developer.mozilla.org/en-US/docs/Web/API/Window) property `**innerWidth**` returns the interior width of the window in pixels.
- The read-only `**innerHeight**` property of the [`Window`](https://developer.mozilla.org/en-US/docs/Web/API/Window) interface returns the interior height of the window in pixels, including the height of the horizontal scroll bar, if present.
    
    Example :
    

```JavaScript
console.log(window.innerHeight); // or

console.log(self.innerHeight);
// will log the height of the frame viewport within the frameset

console.log(parent.innerHeight);
// will log the height of the viewport of the closest frameset

console.log(top.innerHeight);
// will log the height of the viewport of the outermost frameset
```

Example :

```JavaScript
// This will log the width of the viewport
console.log(window.innerWidth);

// This will log the width of the frame viewport within a frameset
console.log(self.innerWidth);

// This will log the width of the viewport of the closest frameset
console.log(parent.innerWidth);

// This will log the width of the viewport of the outermost frameset
console.log(top.innerWidth);
```

### Window Screen

- The `window.screen` object contains information about the user's screen.
- The `window.screen` object can be written without the window prefix.
    
    Properties:
    
    - `screen.width`
    - `screen.height`
    - `screen.availWidth`
    - `screen.availHeight`
    - `screen.colorDepth`
    - `screen.pixelDepth`