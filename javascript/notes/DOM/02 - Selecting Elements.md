# Selecting elements

- Following methods used to select HTML element(s).

```js
document.getElementById('id')							Element object | null
document.getElementsByClassName('class class..')		HTMLCollection (live)
documnet.getElementsByName('name')						NodeList

document.getElementsByTagName('tagName')				HTMLCollection (live)

element.querySelector('selector')						Element object | null | SyntaxError
element.querySelectorAll('selector')					NodeList
```



## 1. getElementById()

Syntax :

```js
let element = document.getElementById('id');
```

- The `document.getElementById()` returns a "Element" object specified by an id or `null` if no matching element found.
- Available on the "document" object, not other elements.
- If the HTML document has multiple elements with the same id, the document.getElementById() method returns the `first element it encounters`.

Example:

```HTML
<body>
	<p id="message">A paragraph</p>
</body>

<script>
	let m = document.getElementById('message');
	console.log(m);
</script>
```

Output:

```HTML
<p id="message">A paragraph</p>
```



## 2. getElementsByClassName()

Syntax :

```js
let elements = document.getElementsByClassName('names');
```

- The `getElementsByClassName()` method returns an array like objects, with a specified class name. (HTMLCollection)
- The getElementsByClassName() method is available on the document element or any `other elements`.
- It returns the descendants of that specific element with the given class name:

Example :   

```html
<ul id="menu">
	<li class="item">HTML</li>
	<li class="item">CSS</li>
	<li class="item highlight">JavaScript</li>
	<li class="item">TypeScript</li>
</ul>

<script>
	let menu = document.getElementById('menu');
	let items = menu.getElementsByClassName('item');		
	let data = [].map.call(items, (el) => el.textContent);
	console.log(data);
</script>
```

Output :

```Plain
['HTML', 'CSS', 'JavaScript', 'TypeScript']
```

Example :

Calling JavaScript getElementsByClassName() on the document

```HTML
<article>
	<h2 class="secondary">Example 1</h2>
</article>

<article>
	<h2 class="secondary">Example 2</h2>
</article>

<script>
	let elements = document.getElementsByClassName('secondary');
	let data = [].map.call( elements, (el, i, arr) => el.textContent );
	console.log(data);
</script>
```

Output :

```Plain
["Example 1", "Example 2"]
```



## 3. getElementByName()

Syntax :

```js
let elements = document.getElementsByName('name');
```

- Every element on an HTML document may have a name attribute :

Example :

```HTML
<input type="radio" name="language" value="JavaScript">
<input type="radio" name="language" value="TypeScript">
```

- The `NodeList` is an array-like object, not an array object.



## 4. getElementsByTagName('tag')

Syntax :

```js
let elements = document.getElementsByTagName('tagName');
```

- the `getElementsByTagName()` is a method of the "document" or "element" object.
- The `getElementsByTagName()` method accepts a tag name and returns a live `HTMLCollection` of elements with the matching tag name in the order which they appear in the document.
- Note that the HTMLCollection is an array-like object, like arguments object of a function.
- The method returns the elements, which is a live HTMLCollection of the matches elements.



## 5. querySelector('selector')

Syntax :

```js
let element = document.querySelector(selector);
```

- The querySelector() method allows you to select the `first element` that matches CSS selectors.
- The querySelector() method is available on the document object or any Element object.
- If the selector is not valid CSS syntax, the method will raise a `SyntaxError` exception.
- If no element matches the CSS selectors, the querySelector() returns `null`.

Example :

```HTML
<body>
	<h1 class="heading">Hello World</h1>
</body>

<script>
	let h1 = document.querySelector('.heading');
	console.log(h1);
</script>
```



## 6. querySelectorAll('selector')

Syntax :

```js
let elementList = parentNode.querySelectorAll(selector);
```

- You can use the querySelectorAll() method to select all elements that match a CSS selector or a group of CSS selectors.
- The querySelectorAll() method returns a `static NodeList` of elements that match the CSS selector. 
- If no element matches, it returns an empty NodeList.

Example :

```HTML
<ul>
       <li class="list-item">Tesla</li>
       <li class="list-item">BMW</li>
       <li class="list-item">Venom</li>
</ul>

<script>
	let list = document.querySelectorAll('.list-item');
	console.log(list);
</script>
```