# Traversing elements:

### Properties

1. `Node.parentNode;`

   - The node.parentNode returns the read-only parent node of a specified node or null if it does not exist.

   

2. `Element.parentElement;`

   - This method returns parent element node of element node.

3. `Element.closest("selector")`

   - The `closest()` method searches **up** the DOM tree for elements which matches a specified CSS selector.

   

4. `parentElement.firstChild;`

   - The firstChild return the first child of a node, which can be any node type including text node, comment node, and element node.

5. `parentElement.firstElementChild;`

   - The firstElementChild return the first Element node.

6. `parentElement.lastChild;`

   - The lastChild return the last child of a node, which can be any node type including text node, comment node, and element node.

7. `parentElement.lastElementChild;`

   - The lastElementChild return the last Element node.

8. `parentElement.childNodes;`

   - The childNodes returns a live NodeList of all child nodes of any node type of a specified node.

9. `parentElement.children;`

   - The children return all ditect children nodes of a specified node.

   

10. `currentNode.nextElementSibling;`

    - The nextElementSibling returns the next sibling of an element or null if the element is the last one in the list.

11. `currentNode.previousElementSibling:`

    - The previousElementSibling returns the previous sibling of an element or null if the element is the first one in the list.

### Other Properties

```js
document.documentElement

document.head
document.body
```