## keyboard event:

- When you press a character key on the keyboard, the `keydown`, `keypress`, and `keyup` events are fired sequentially.
- However, if you press a non-character key, only the `keydown` and `keyup` events are fired.
- The keyboard event has two important properties:

```
key		- returns the character that has been pressed
code	- returns the physical key code.
```