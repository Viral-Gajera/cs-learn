# Css Nesting

1. Basic CSS Nesting

2. Advanced CSS Nesting

3. Pseudo-classes and Pseudo-elements

4. Media Queries

  

CSS nesting is a powerful feature that allows you to write nested selectors, similar to how it's done in Sass. It simplifies the code and makes it more maintainable. In this tutorial, we will explore CSS nesting using the new CSS Nesting feature, including media queries.

## 1. Basic CSS Nesting

CSS Nesting is achieved by enclosing nested selectors within the parent selector using the `&` character. For example:

```CSS
.parent-element {
  /* Parent styles */

  & .child-element {
    /* Nested child styles */
  }
}
```

In the above code, the `.child-element` is nested within the `.parent-element`. The `&` symbol represents the **parent selector** within the nested selector.

In some cases, you can optionally omit the use of `&` in child selectors when there is no ambiguity. For example:

```CSS
.parent-element {
  /* Parent styles */

  .child-element {
    /* Nested child styles */
  }
}
```

In the above code, the `.child-element` is nested within the `.parent-element` without explicitly using the `&` symbol. This shorthand notation is allowed when the nesting context is clear.

  

## 2. Advanced CSS Nesting

CSS nesting can be used with multiple levels of nesting. Here's an example:

```CSS
.container {
  /* Parent styles */

  & .row {
    /* Nested child styles */

    & .column {
      /* Nested grandchild styles */
    }
  }
}
```

In the above code, the `.row` element is nested within the `.container`, and the `.column` element is nested within the `.row`. Each level of nesting is indicated using the `&` symbol.

  

## 3. Pseudo-classes and Pseudo-elements

CSS nesting can also be combined with pseudo-classes and pseudo-elements. For example:

```CSS
.button {
  /* Parent styles */

  &:hover {
    /* Styles for the button on hover */
  }

  &::before {
    /* Styles for the content inserted before the button */
  }
}
```

In the above code, the `:hover` pseudo-class and the `::before` pseudo-element are nested within the `.button` selector using the `&` symbol.

  

## 4. Media Queries

CSS nesting can be used with media queries to apply specific styles based on the device's characteristics. Here's an example:

```CSS
.container {
  /* Parent styles */

  .element {
    /* Styles for the element within the container */

    @media (max-width: 768px) {
      /* Media query styles for smaller screens */
    }
  }
}
```

In the above code, the styles for the `.element` within the `.container` are defined. Inside the nested selector, a media query is used to specify different styles for screens with a maximum width of 768 pixels.