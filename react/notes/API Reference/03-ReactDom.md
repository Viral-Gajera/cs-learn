## ReactDom

- Importing react dom: `import ReactDom from 'react-dom'`

### Methods :

```JavaScript
ReactDom.render(element, container, [callback])		//R: reference to the component

ReactDom.createPortal(child, container)
ReactDom.fluchSync(callback)
ReactDom.hydrate(element, container, [callback])
ReactDom.findDOMNode()
ReactDom.unmountComponentAtNode(container)
```

The `react-dom` package also provides modules specific to client and server apps :

- [`react-dom/client`](https://reactjs.org/docs/react-dom-client.html)
- [`react-dom/server`](https://reactjs.org/docs/react-dom-server.html)