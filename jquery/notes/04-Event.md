# Event

- Here are some common DOM events :
    
    |   |   |   |   |
    |---|---|---|---|
    |Mouse Events|Keyboard Events|Form Events|Document/Window Events|
    |click()|keypress|submit|load|
    |dblclick()|keydown|change|resize|
    |mouseenter(), mouseleave()|keyup|focus|scroll|
    |mousedown(), mouseup()||blur|unload|
    |hover(), focus(), blur()||||
    |||||
    
- In jQuery, most DOM events have an equivalent jQuery method.

## The on() Method

- The `on()` method attaches one or more event handlers for the selected elements.
- Example :
    
    ```Plain
    $("p").on("click", function(){
      $(this).hide();
    });
    ```
    

## Trigger

- Triggers event on an element
- Example:
    
    ```Plain
    $("a\#mylink").trigger("click");
    ```