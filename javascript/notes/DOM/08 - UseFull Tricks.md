# Tricks

## Dimention & Position of element

- DOM's `element.getBoundingClientRect();` method is used to get the dimentions and position of an element as floating-point after CSS transformation.
- It returns `DOMRect` object, that contains several properies like, `x, y, width, height` etc.
- Example Output:

```js
DOMRect {
	x: 8,
	y: 21.4375,
	width: 802.4000244140625,
	height: 37.60000228881836,
	top: 21.4375,...
}
```



