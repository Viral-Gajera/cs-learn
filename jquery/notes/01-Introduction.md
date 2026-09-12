# JQuery

- jQuery is a lightweight, **write less, do more**, JavaScript library. jQuery greatly simplifies JavaScript programming and DOM manipulation.
- The jQuery library contains the following features:
    - HTML/DOM manipulation
    - CSS manipulation
    - HTML event methods
    - Effects and animations
    - AJAX
    - Utilities

# Adding jQuery to Your Web Pages

### 1. Downloading jQuery

- downloaded jQuery from [Here](http://jquery.com/download/).
- The jQuery library is a single JavaScript file, and you reference it with the HTML `<script>` tag (notice that the `<script>` tag should be inside the `<head>` section):
    
    ```HTML
    <head>
    	<script src="jquery-3.6.4.min.js"></script>
    </head>
    ```
    

### 2. jQuery CDN

- If you don't want to download and host jQuery yourself, you can include it from a CDN (Content Delivery Network).
- Google is an example of someone who host jQuery:
    
    ```HTML
    <head>
    	<script src="<https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js>"></script>
    </head>
    ```
    

# jQuery Syntax

- Basic syntax is
    
    ```Plain
    $(selector).action()
    ```
    
- A $ sign to define/access jQuery
- A (_selector_) to "query (or find)" HTML elements
- A jQuery _action_() to be performed on the element(s)

# keyword 'this'

- By default, the value of `this` inside a callback function will refer to the DOM element to which the callback function is bound.
    
    ```Plain
    $('button').click(function() {
      console.log('Button clicked!');
      console.log('Value of "this":', this);
    });
    ```
    
- However, if you define the callback function using an arrow function (`() => {}`), the value of `this` inside the callback function will not be the DOM element. Arrow functions do not have their own `this` binding and instead inherit `this` from the enclosing scope.

# Basic

### The Document Ready Event

- This is to prevent any jQuery code from running before the document is finished loading (is ready).
    
    ```Plain
    $(document).ready(function(){
      // jQuery methods go here...
    });
    ```
    
- The jQuery team has also created an even shorter method for the document ready event:
    
    ```Plain
    $(function(){
      // jQuery methods go here...
    });
    ```
    

### Each

- This method is used to iterate over a collection of elements or an array-like object and perform a function on each item individually.
- Example:
    
    ```Plain
    $(".demo").each(function() {                // parse each .demo element
    	document.write($(this).text() + "\\n");  // output their text
    });
    ```
    

### noConflict

- jQuery uses the `$` sign as a shortcut for jQuery.
- If two different frameworks are using the same shortcut, one of them might stop working.
- The `noConflict()` method releases the hold on the $ shortcut identifier, so that other scripts can use it.
- Example:
    
    ```Plain
    var jq = $.noConflict();            // avoid conflict with other frameworks also using the dollar sign
    jq(document).ready(function(){
    	jq("\#demo").text("Hello World!");
    });
    ```