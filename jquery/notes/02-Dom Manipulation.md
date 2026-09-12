## DOM Manipulation

- `text( [newvalue] )`
    
    Sets or returns the text content of selected elements
    
- `html( [newvalue] )`
    
    Sets or returns the content of selected elements (including HTML markup)
    
- `val( [newvalue] )`
    
    Sets or returns the value of form fields
    
- `attr(name, [value])`
    
    Sets or returns attribute values.
    
- `attr({name:value, name:value, ...})`
    
    Setting multiple attributes.
    
- `text( (index, oldValie)=>{} )`
- `html( (index, oldValie)=>{} )`
- `val( (index, oldValie)=>{} )`
- `attr( name, (index, oldValie)=>{} )`
    
    The callback function has two parameters: The index of the current element in the list of elements selected and the original (old) value.
    
    You then return the string you wish to use as the new value from the function.
    

## Add Element

- `append( element )`
    
    Inserts content at the end of the selected elements
    
- `prepend( element )`
    
    Inserts content at the beginning of the selected elements
    
- `after( element )`
    
    Inserts content after the selected elements
    
- `before( element )`
    
    Inserts content before the selected elements
    

## Remove Element

- `remove()`
    
    Removes the selected element (and its child elements)
    
- `remove( "selector selector..." )`
    
    Removes the selected element having selector specified by argument
    
- `empty()` - Removes the child elements from the selected element

Example :

- This example removes all `<p>` elements with `class="test"` and `class="demo"`:

```Plain
$("p").remove(".test, .demo");
```

## Manipulating CSS

- `addClass( "class-name" )`
    
    Adds one or more classes to the selected elements
    
- `removeClass( "class-name" )`
    
    Removes one or more classes from the selected elements
    
- `toggleClass( "class-name" )`
    
    Toggles between adding/removing classes from the selected elements
    
- `css( "property", ["value"], "property", ["value"] )`
    
    Sets or returns the style attribute
    

## Dimension Methods

- `width()`
- `height()`
- `innerWidth()`
- `innerHeight`
- `outerWidth()`
- `outerHeight()`

<img src="1.gif">