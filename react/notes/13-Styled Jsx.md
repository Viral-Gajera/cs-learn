## Step 1: Installation

To begin, install the `styled-jsx` library in your project. You can use npm or yarn:

```Plain
npm install styled-jsx
```

## Basic Usage

Let's start with a basic example. Create a new file, `MyComponent.js`, and add the following code:

```jsx
import React from 'react';

const MyComponent = () => {
  return (
    <div>
      <h1 className="title">Hello, Styled JSX!</h1>
      <p className="description">This is a basic example.</p>

      <style jsx>{`
        .title {
          color: red;
        }

        .description {
          font-size: 16px;
        }
      `}</style>
    </div>
  );
};

export default MyComponent;
```

In this example, we define a component called `MyComponent` that renders a heading and a paragraph. We apply styles using the `<style jsx>` tag, which contains CSS rules for the respective class names `.title` and `.description`.

## Dynamic Styles

`styled-jsx` also supports dynamic styles using template literals and JavaScript expressions. Modify `MyComponent.js` as follows:

```JavaScript
import React from 'react';

const MyComponent = () => {
  const color = 'blue';

  return (
    <div>
      <h1 className="title">Hello, Styled JSX!</h1>
      <p className="description">This is a basic example.</p>

      <style jsx>{`
        .title {
          color: ${color};
        }

        .description {
          font-size: ${16}px;
        }
      `}</style>
    </div>
  );
};

export default MyComponent;
```

Here, we introduce a `color` variable and interpolate it within the CSS rules using `${}` syntax. This allows for dynamic styles based on variables or expressions.

## Global Styles

While `styled-jsx` primarily focuses on local scoped styles, you can also define global styles using the `global` modifier. Modify `MyComponent.js` as follows:

```JavaScript
import React from 'react';

const MyComponent = () => {
  return (
    <div>
      <h1 className="title">Hello, Styled JSX!</h1>
      <p className="description">This is a basic example.</p>

      <style jsx global>{`
        body {
          background-color: lightgray;
        }
      `}</style>
    </div>
  );
};

export default MyComponent;
```

By adding the `global` modifier to the `<style jsx>` tag, the defined styles will be applied globally, affecting the entire page.

## Composing Styles

`styled-jsx` supports style composition using the `compose` attribute. This allows you to reuse existing styles and extend them with additional rules. Modify `MyComponent.js` as follows:

```JavaScript
import React from 'react';

const MyComponent = () => {
  return (
    <div>
      <h1 className="title">Hello, Styled JSX!</h1>
      <p className="description">This is a basic example.</p>

      <style jsx>{`
        .title {
          color: red;
        }

        .title-big {
          compose: title;
          font-size: 24px;
        }

        .description {
          font-size: 16px;
        }
      `}</style>
    </div>
  );
};

export default MyComponent;
```

In this example, we define a new class `.title-big` that composes the styles of the existing `.title` class and adds a larger font size.

## Media Queries

`styled-jsx` also supports media queries for responsive designs. Modify `MyComponent.js` as follows:

```JavaScript
jsxCopy codeimport React from 'react';

const MyComponent = () => {
  return (
    <div>
      <h1 className="title">Hello, Styled JSX!</h1>
      <p className="description">This is a basic example.</p>

      <style jsx>{`
        .title {
          color: red;
        }

        .description {
          font-size: 16px;
        }

        @media (max-width: 600px) {
          .description {
            font-size: 14px;
          }
        }
      `}</style>
    </div>
  );
};

export default MyComponent;
```

By including media query rules within the `<style jsx>` tag, you can define styles specific to certain screen sizes or devices.

## Working with pseudo element & class and other selector

To use pseudo-elements, classes, and other types of selectors with `styled-jsx`, you can apply them directly within the `<style jsx>` block using standard CSS syntax. Here's an example that demonstrates how to use different types of selectors:

```JavaScript
import React from 'react';

const MyComponent = () => {
  return (
    <div>
      <h1 className="title">Hello, Styled JSX!</h1>
      <p className="description">This is a basic example.</p>

      <style jsx>{`
        .title {
          color: red;
        }

        p.description {
          font-size: 16px;
        }

        h1.title::after {
          content: '!';
        }

        .special-class {
          background-color: yellow;
        }

        .title:hover {
          color: blue;
        }
      `}</style>
    </div>
  );
};

export default MyComponent;
```

## Advanced Usage

For more advanced usage, you can explore the `styled-jsx` documentation, which covers additional features and techniques, such as theming, keyframes, selectors, and more. Visit the official `styled-jsx` GitHub repository for comprehensive documentation and examples: [https://github.com/vercel/styled-jsx](https://github.com/vercel/styled-jsx)

By following these steps and experimenting with the `styled-jsx` library, you can harness its power to create local scoped styles in your React components with ease.