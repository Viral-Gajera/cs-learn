# Disable User Selection

```CSS
.app {
    /* DISABLE SELECTION */
    -webkit-user-select: none; /* Safari */
    -moz-user-select: none; /* Firefox */
    -ms-user-select: none; /* Internet Explorer/Edge */
    user-select: none; /* Standard */

    /* DISABLE BLUE HIGHLIGHT WHEN CLICK [FOR MOBILE CHROME] */
    -webkit-tap-highlight-color: transparent;
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -khtml-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

.app:focus {
    outline: none !important;
}
```


# Custom Scroll Bar

![[Computer/CSS/2.jpg]]
### Scrollbar Selector :

- For webkit browser you can use the following psuedo element to customize the browser scrollbar.
- `::-wbkit-scrollbar` :
    
    address the background of the bar itself. it is usually covered by the other element. (generally used to set width of scrollbar)
    
- `::-wbkit-scrollbar-button` :
    
    the button on scroll bar
    
- `::-wbkit-scrollbar-thumb` :
    
    the draggable scrolling handle
    
- `::-wbkit-scrollbar-thumb` :
    
    the track of scrollbar
    
- `::-wbkit-resize` :
    
    the draggable resizing handle that appers at the bottom corner of the some element.
    
- `::-wbkit-scrollbar-corner` :
    
    the bottom corner of scrollbar when both horizontal and vertical scrollbar meet
    
- `::-wbkit-scrollbar-track-piece` :
    
    The track not covered by the handle
    

### Example:

```CSS
/* Custom scroll bar */
::-webkit-scrollbar {
    width: 5px;
    height: 5px;
}
::-webkit-scrollbar-track {
    background: \#fff;
}
::-webkit-scrollbar-thumb {
    background: \#888;
}
```

### Example:

```CSS
/* Hide scroll bar but still scroll */
.hide-scrollbar {
    -ms-overflow-style: none; /* Internet Explorer 10+ */
    scrollbar-width: none; /* Firefox */
}
.hide-scrollbar::-webkit-scrollbar {
    display: none; /* Safari and Chrome */
}
```