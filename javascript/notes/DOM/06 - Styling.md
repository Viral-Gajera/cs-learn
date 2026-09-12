# Manipulating Element’s Styles:

[ all css property converted in to camelcase notation while woking with javascript. ]

## Properties and Method

```js
element.style;
// returns CSSStyleDeclaration object (read-only)

element.style.property;
// returns "value" of corresponding inline css property (only works with inline css)

element.style.property = 'value';
// returns newly set "value".
// used to set the new value to 'inline property'.
```

```js
element.style.cssText;
// returns inline css attached to element.

element.style.cssText = 'property:value';
// returns newly set value
// To completely override the existing 'inline style'.

element.style.cssText += 'property:value';
// returns newly set value
// To append new style to the existing 'inline style'.
```

```js
element.style.setProperty('property','value')
// it is also capable of chaning or setting property of external or internal style sheet property.
```



```js
element.className
// returns a space-separated list of CSS classes of the element.

element.className = "class1 class2";
// returns a space-separated list new css classes of the element.
// To completely overwrite all the classes of an element.

element.className += newClassName;
// returns a space-separated list of all css classes of the element.
// To add the class to existing element class list.
```

```js
element.classList.add('class1', 'class2',...)
element.classList.contains('class')									// boolean
element.classList.replace('oldClass', 'newClass')
element.classList.remove(class1, class2,...)
element.classList.toggle(class, true|false)
```

Example:

```HTML
<script>
	document.documentElement.style.setProperty('--var','value');
    // change the style of :root {css}
</script>
```

## Element Width & Height

```js
element.offsetWidth | element.offsetHeight;
// To get the element’s width | height that include the padding and border.

element.clientWidth | element.clientHeight;
// To get the element’s width and height that include padding but without the border.
```

## Method

`window.getComputedStyle(element [,pseudoElement]);`

- returns an CSSStyleDeclaration object that contains the computed style of element.
- To get all styles applied to an element. ( inline | internal | external )



## Trick

```js
element.setAttribute('style','property:value;');

- undefined
- To completely override the existing 'inline style'
```

