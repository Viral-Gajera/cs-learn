# Document Object Model

- The Document Object Model (DOM) is an application programming interface (API) for manipulating HTML documents.
- The DOM is not part of the JavaScript language, but is instead, it is a Web API used to build websites.
- The DOM represents the HTML document as **tree**. 
- The DOM provides functions that allow you to add, remove, and modify parts of the document effectively.



# Hierarchy of nodes

- The DOM represents an HTML document as a hierarchy of nodes. Consider the following HTML document:

```HTML
<html>
    <head>
        <title> My title </title>
	</head>
    <body>
        <h1>My header</h1>
        <script type=”text/javascript”>
        	alert(‘hello’)
		</script>
    </body>
</html>
```

- The following tree represents the above HTML document:

<img src="Document as Hierarchy of Nodes.png">

- The `document` is the root node.
- The `<html>` element is called the `documentElement` (:root).
- Each document can have only one document element.



# Node Types

- Each node in the DOM tree is identified by a `nodeType`. JavaScript uses integer numbers to determine the node types. The following table illustrates the node type constants

|Node|Number|
|---|---|
|Node.ELEMENT_NODE|1|
|Node.TEXT_NODE|3|
|Node.CDATA_SECTION_NODE|4|
|Node.PROCESSING_INSTRUCTION_NODE|7|
|Node.COMMENT_NODE|8|
|Node.DOCUMENT_NODE|9|
|Node.DOCUMENT_TYPE_NODE|10|
|Node.DOCUMENT_FRAGMENT_NODE|11|

- To get the type of node, you use the `nodeType` property.
  
- For Example
  

```js
let li = document.querySelectorAll('li');
//li[0] - is the first <li> element
//li[1] - is the second <li> element

console.log(li[0].nodeName);  // LI
console.log(li[0].nodeType);  // 1
```

- `querySelectorAll()` method in this code snippet returns list of all the `<li>` elements in the document.
- You can compare the `nodeType` property with the above **constants** to determine the node type.
- If the node type is the **element node**, the nodeName is always the same as the element’s tag name (UPPER CASED). 
- For example:

```js
if (node.nodeType == Node.ELEMENT_NODE) {
    // node is the element node
}
```



# Node vs Element

- Sometimes it’s easy to confuse between the Node and the Element.
- A node is a generic name of any object in the DOM tree. 
- It can be any built-in DOM element such as the document, or it can be any HTML tag specified in the HTML document like `<div>` or `<p>`.
- An `element` is a node with a specific node type `Node.ELEMENT_NODE`, which is equal to 1.





# Node Relationships

- Any node has relationships to other nodes in the DOM tree. The relationships are the same as the ones described in a traditional family tree.
- For example, `<body>` is a child node of the `<html>` node, and `<html>` is the parent of the `<body>` node.
- The following picture illustrates the relationships between nodes:

<img src="Node Relationships.png">
