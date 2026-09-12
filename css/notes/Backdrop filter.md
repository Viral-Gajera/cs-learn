# Backdrop filter

- The backdrop-filter property is used to apply a graphical effect to the area behind an element.
- To see the effect, the element or its background must be at least partially transparent.
- CSS Syntax :
    
    `backdrop-filter: none|filter|initial|inherit;`
    
    - none : Default value. No filter is applied to the backdrop
    - initial : Sets this property to its default value.
    - inherit : Inherits this property from its parent element.
    - filter : A space-separated list of filter-functions like...
        
        ```Plain
        drop-shadow()
        invert()
        blur()
        opacity()
        brightness()
        hue-rotate()
        grayscale()
        contrast()
        saturate()
        sepia()
        or an url to an SVG filter that will be applied to the backdrop
        ```