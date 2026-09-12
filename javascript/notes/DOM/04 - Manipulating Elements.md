# Manipulating elements

Properties :

|Properties|Description|
|---|---|
|element.innerHTML = new html content|As it is html content|
|element.innerText = new html content|Text content with css|
|element.textContent = new html content|Only text content|



Methods :

|Method|Description|
|---|---|
|document.createElement( "html tag" )|Creates new node and return it.|
|document.createTextNode( "string content" )|Creates new text node and return it.|
|document.createComment( "string content" )|Creates new comment node and return it.|
|document.createDocumentFragment()|Create DocFrag object and return it.|
|||
|ParentNode.appendChild( element )|This menthod retuens appended child node.|
|ParentNode.insertBefore( newNode, existingNode )|Inserts newNode before the existingNode and return inserted child node.|
|ParentNode.replaceChild( newChild, oldChild )|This method returns replaced node (oldChild).|
|ParentNode.removeChild(childNode);|This method returns removed node|
|||
|Element.append( node1, node2, .... )|This method inserts a set of Node, after the last child of `Element`. and rerurns undefined.|
|Element.prepend( node1, node2,... )|This method inserts a set of Node, before the first child of `Element`. and rerurns undefined|
|Element.after(element, element...)|This method inserts a set of Node or string, after the last child of `Element`. and rerurns undefined.|
|Element.before(element, element,. . . )|This method inserts a set of Node or string, before the first child of `Element`. and rerurns undefined.|
|Element.remove()|This method return undefined.|
|||
|Element.insertAdjacentHTML( postionName , text )|undefined|
|||
|OriginalNode.cloneNode( [true \| false] )|This method returns new cloned node|



## Properties

### 1. elelment.innerHTML

- The innerHTML is a property of the Element that allows you to get or set the HTML markup contained within the element.

### 2. node.innerText;

- The innerText takes the CSS style into account and returns only human-readable text.
- Since the innerText property uses the up-to-date CSS to compute the text, accessing it will trigger a reflow, which is computationally expensive.

### 3. node.textContent

- To get the text content of a <u>node and its descendants</u>, you use the textContent property.
- Besides reading textContent, you can also use the textContent property to set the text for a node.



Example :

```HTML
<div id="note">
    JavaScript textContent Demo!
    <span style="display:none">Hidden Text!</span>
    <!-- my comment -->
</div>
<script>
	let note = document.getElementById('note');
	console.log(note.innerHTML);
    console.log(note.innerText);
	console.log(note.textContent);
</script>
```

Output :

```Plain
[for innerHTML] : As it is html content
JavaScript textContent Demo!
<span style="display:none">Hidden Text!</span>
<!-- my comment -->

[for innerText] : Text content with css applied
JavaScript textContent Demo!

[for textContent] : Only text content
JavaScript textContent Demo!
Hidden Text!
```



## Methods

### document.createElement('htmlTag');

- The document.createElement() accepts an HTML tag name and returns a new Node with the Element type.

Example :

```HTML
<body>

</body>

<script>
	let div = document.createElement('div');
	div.innerHTML = "<p>My name is viral</p>";
	document.body.appendChild(div);
</script>
```

Output :

```html
<body>
    <div>
        <p>My name is viral</p>
    </div>
</body>
```

Example :

- Create a new helper function that loads a JavaScript file from an URL:

```js
function loadJS(url) {
    let script = document.createElement('script');
    script.src = url;
    document.body.appendChild(script);
}
```



### document.createDocumentFragment();

- DocumentFragment Interface is like `virtual invisible html element`.
- The DocumentFragment used to compose DOM nodes and append or insert it to the active DOM tree. (used to increase the performance)
- To create a new document fragment, you use the DocumentFragment `constructor` like this :

```js
let fragment = new DocumentFragment();
```

- Or you can use the `createDocumentFragment()` method of the "Document object" :

```js
let fragment = document.createDocumentFragment();
```

Example :

```HTML
<ul id="language"></ul>

<script>
	let languages = ['JS', 'TypeScript', 'Elm', 'Dart','Scala'];
	let langElement = document.querySelector('#language');

	let fragment = new DocumentFragment();
	languages.forEach((el, i, arr) => {
    	let li = document.createElement('li');
    	li.innerHTML = el;
    	fragment.appendChild(li);
	})

	langElement.appendChild(fragment);
</script>
```



### parentNode.appendChild(element);

- To attach the element to the document, you can use the `appendChild()` method.

Example :

```HTML
<body>
</body>

<script>
	let div = document.createElement('div');
	div.innerHTML = "<p>My name is viral</p>";
	document.body.appendChild(div);
</script>
```



### parentNode.insertBefore();

- To insert a node before another node as a child node of a parent node, you use the parentNode.insertBefore(newNode, existingNode) method :

Example :

```HTML
<ul id="menu">
    <li>Services</li>
    <li>About</li>
    <li>Contact</li>
</ul>

<script>
let menu = document.getElementById('menu');
// create a new li node
let li = document.createElement('li');
li.textContent = 'Home';

// insert a new node before the first list item
menu.insertBefore(li, menu.firstElementChild);

console.log( document.body.innerHTML );
</script>
```

output:

```html
<ul id="menu">
    <li>Home</li>
    <li>Services</li>
    <li>About</li>
    <li>Contact</li>
</ul>
```



### Element.append();

- `Element.append()` can append several nodes and strings, whereas `parentNode.appendChild()` can only append one node.
- The `Element.append( [ ...nodes | ...DOMStrings ] )` method inserts a set of Node objects or DOMString objects as Text nodes, after the last child of a parent node :
- `Element.append()` allows you to also append string objects, whereas `parentNode.appendChild()` only accepts [`Node`](https://developer.mozilla.org/en-US/docs/Web/API/Node) objects.

Syntax :

```js
Element.append( node1, node2, .... )
Element.append(...nodes);			// Appent after destructuing nodes
Element.append(...DOMStrings);
```

Example :

```js
let div = document.createElement("div")
let p = document.createElement("p")
div.append("Some text", p)

console.log(div.childNodes) // NodeList [ \#text "Some text", <p> ]
```

Example :

```HTML
<ul id="app">
    <li>JavaScript</li>
</ul>

<script>
	let app = document.querySelector('\#app');

	let langs = ['TypeScript','HTML','CSS'];

	let nodes = langs.map( el => {
    	let li = document.createElement('li');
    	li.textContent = el;
    	return li;
	});

    app.append(...nodes);

</script>
```

Output :

```Plain
<ul id="app">
    <li>JavaScript</li>
    <li>TypeScript</li>
    <li>HTML</li>
    <li>CSS</li>
</ul>
```

append() vs appendChild()

|Differences|append()|appendChild()|
|---|---|---|
|Return value|undefined|The appended Node object|
|Input|Multiple Node Objects|A single Node object|
|Parameter Types|Accept Node and DOMString|Only Node|

### Element.prepend();

- The `prepend( [...nodes | ...DOMStrings] )` method **inserts a set of Node objects or DOMString objects as Text nodes, before the first child node of the parent node**:
- The prepend() method returns undefined.

Syntax :

```js
parentNode.prepend( node1, node2,... )
parentNode.prepend(...nodes);
parentNode.prepend(...DOMStrings);
```

Example :

```HTML
<ul id="app">
    <li>HTML</li>
</ul>

<script>
	let app = document.querySelector('\#app');

	let langs = ['CSS','JavaScript','TypeScript'];

	let nodes = langs.map(lang => {
    	let li = document.createElement('li');
    	li.textContent = lang;
	    return li;
	});
	app.prepend(...nodes);
</script>
```

Output :

```html
<ul id="app">
    <li>CSS</li>
    <li>JavaScript</li>
    <li>TypeScript</li>
    <li>HTML</li>
</ul>
```

### Element.insertAdjacentHTML();

- The insertAdjacentHTML( positionName, text ) method inserts `text (string) or Element Node` into the DOM tree at a specified position.
- This method retuen undefined.
- The insertAdjacentHTML() method has two parameters.
  - Position :
    - `beforebegin` : before the element  
    - `afterbegin` : before its first child of the element.  
    - `beforeend` : after the last child of the element  
    - `afterend` : after the element
  - text :
      - It can be string specifing HTML element or HTML Element Node.  
      - It cannot be Other Node objects.  

Example:

```HTML
<ul id="list">
    <li>CSS</li>
</ul>

<script>
         let list = document.querySelector('\#list');

         list.insertAdjacentHTML('beforebegin', '<h2>Web Technology</h2>');
         list.insertAdjacentHTML('afterbegin', '<li>HTML</li>');
         list.insertAdjacentHTML('beforeend', '<li>JavaScript</li>');
         list.insertAdjacentHTML('afterend', '<p>For frontend developers</p>');
</script>
```

Output:

```html
<h2>Web Technology</h2>
<ul id="list">
    <li>HTML</li>
    <li>CSS</li>
    <li>JavaScript</li>
</ul>
<p>For frontend developers</p>
```