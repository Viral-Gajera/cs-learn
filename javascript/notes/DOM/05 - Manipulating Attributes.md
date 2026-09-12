# Working with Attributes

## Attributes

- When the web browser loads an HTML page, it generates the corresponding DOM objects based on the DOM nodes of the document.
- Example :

```HTML
<input type="text" id="username">
```

- The web browser will generate an `HTMLInputElement object`
- The input element has two attributes :
    - The `type` attribute with the value 'text'. (like. input.type = "text")  
    - The `id` attribute with the value 'username'. (like [input.id](http://input.id/) = "usename")
- However, the web browser only converts the standard attributes to the DOM object’s properties. The standard attributes of an element are listed on the element’s specification.
- non-standerd attributes are not converted to property.
- Example :

```HTML
<input type="text" id="username" secured="true">

<script>
	let input = document.querySelector('#username');
	console.log(input.secured); 	// undefined
	console.log(input.id);      	// username
</script>

```

In this example, the secured is a non-standard attribute :



## Custom attrributes ( data-* ) :

- If you want to add a custom attribute to an element, you should prefix it with the `data-` e.g., **data-secured** because all attributes start with data- are reserved for the developer’s uses.
- To access data-* attributes, you can use the `dataset` property and `camelCase` notation.

Example :

```HTML
<img href="#" data-version-number="5">

<script>
	let img = document.getElementByTagName('img');
	img.dataset.versionNumber							// using data set
	img.getAttribute('data-version-number')				// using getAttributes
</script>
```



## DOM properties are typed :

- The value of an attribute is always a string.
- However, when the attribute is converted to the property of a DOM object, the property value can be a string, a boolean, an object, etc.
- Example:

```HTML
<input type="checkbox" id="chkAccept" checked> Accept

<script>
    let checkbox = document.querySelector('\#chkAccept');
	console.log(checkbox.checked); // true
</script>
```



## element.attributes :

- The `element.attributes` property provides a live collection(NamedNodeMap) of attributes(standard and custom attributes) available on a specific element.
- Example :

```HTML
<input type="text" id="username" secured="true">

<script>
	let input = document.querySelector('input[type="text"]')
	console.log(input.attributes);
</script>
```

```js
NamedNodeMap {
	0: type, 1: id, 2: secured,
	type: type, id: id, secured: secured,
    length: 3
}
```

## Attribute methods :

To access/manipulate both standard and non-standard attributes, you use the following methods :

|Methods|Description|
|---|---|
|element.getAttribute('name')|get the attribute value ( string \| null )|
|element.setAttribute('name', 'value')|set the value for the attribute ( undefined )|
|element.hasAttribute(name)|check for the existence of an attribute ( Boolean )|
|element.removeAttribute(name)|remove the attribute ( undefined )|