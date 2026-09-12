## Traversing Up the DOM Tree

- `parent()`
    
    Returns the direct parent element of the selected element.
    
- `parents()`
    
    returns all ancestor elements of the selected element, all the way up to the document's root element (`<html>`).
    
- `parentsUntil("selector")`
    
    returns all ancestor elements between two given arguments.
    

Example :

- The following example returns all ancestor elements between a `<span>` and a `<div>` element:

```Plain
$(document).ready(function(){
  $("span").parentsUntil("div");
});
```

## Traversing Down the DOM Tree

- `children()`
    
    Returns all direct children of the selected element. This method only traverses a single level down the DOM tree.
    
- `children( "selector" )`
    
    You can also use an optional parameter to filter the search for children.
    
- `find( "selector" )`
    
    Returns descendant elements of the selected element, all the way down to the last descendant.
    

## Traversing Sideways (Sibling) in The DOM Tree

- `siblings()`
    
    Returns all sibling elements of the selected element.
    
- `next()`
    
    Returns the next sibling element of the selected element.
    
- `nextAll()`
    
    Returns all next sibling elements of the selected element.
    
- `nextUntil( "selector" )`
    
    Returns all next sibling elements between two given arguments.
    
- `prev()`
- `prevAll()`
- `prevUntil()`

# Filtering

- `first()`
    
    Returns the first element of the specified elements.
    
- `last()`
    
    Returns the last element of the specified elements.
    
- `eq()`
    
    Returns an element with a specific index number of the selected elements.
    
- `filter()`
- `not()`
    
    Returns all elements that do not match the criteria
    

Example:

```Plain
$("div").first();
$("div").last();
$("p").eq(1);
$("p").filter(".intro");
$("p").not(".intro");
```