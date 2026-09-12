## React

- `React` is the entry point to the React library.
- importing react : `import React from 'react'`.

### Properties :

```JavaScript
React.Component						// base class for React components
React.PureComponent

React.Children
React.Children.map
React.Children.forEach
React.Children.count
React.Children.only
React.Children.toArray

React.memo
React.Fragment						// rendering multiple elements without a wrapper
React.createRef
React.forwardRef
React.lazy
React.Suspense
React.startTransition
React.useTransition
```

### Methods :

```JavaScript
React.createElement(type, [props], [...children])
// internally used to create element from JSX.

React.createFactory(type)
React.cloneElement(element, [config], [...children])
React.isValidElement(object)
```