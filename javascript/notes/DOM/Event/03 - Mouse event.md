# Mouse event :

- When you click an element, there are three mouse events fire in the following sequence:
    - The `mousedown` fires when you press the mouse button on the element.
    - The `mouseup` fires when you release the mouse button on the element.
    - The `click` fires when one mousedown and one mouseup detected on the element.

## `dblclick` Events :

- It takes two `click` events to cause a dblclick event to fire.

## `mousemove` Events :

- The mousemove event fires repeatedly when you move the mouse cursor around an element. 
- Even when you move the mouse one pixel, the mousemove event still fires
- Position of the mouse pointer :

```Plain
event.clientX        relative to canvase
event.clientY

event.offsetX        relative to canvase
event.offsetY

event.screenX        relative to screen
event.screenY
```

## `mouseover / mouseout` Events :

- The mouseover fires when the mouse cursor is outside of the element and then move to inside the boundaries of the element.
- The mouseout fires when the mouse cursor is over an element and then move another element.

## `mouseenter / mouseleave` Events :

- The mouseenter fires when the mouse cursor is outside of an element and then moves to inside the boundaries of the element.
- The mouseleave fires when the mouse cursor is over an element and then moves to the outside of the element’s boundaries.
- Both mouseenter and mouseleave does not bubble and does not fire when the mouse cursor moves over descendant elements.

## Detecting mouse buttons :

- The `event` object passed to the mouse event handler has a property called `button` that indicates which mouse button was pressed on the mouse to trigger the event.
- The mouse button is represented by a number :

```Plain
0: the main mouse button pressed, usually the left button.
1: the auxiliary button pressed, usually the middle button or the wheel button.
2: the secondary button pressed, usually the right button.
3: the fourth button pressed, usually the Browser Back button.
4: the fifth button pressed, usually the Browser Forward button
```