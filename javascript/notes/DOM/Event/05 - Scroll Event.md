# Scroll events :

- When you scroll a document or an element, the `scroll` events fire.
- Typically, you handle the `scroll` events on the `window object` to handle the scroll of the whole webpage.

Example:

```Plain
window.addEventLister('scroll', function(){
	console.log(window.scrollX);
	console.log(window.scrollY);
})
```

## Scroll offsets :

- The `window.scrollX` and `window.scrollY` properties return the number of pixels that the document is currently scrolled horizontally and vertically.

## Page offsets :

- The `window.pageXOffset` and `window.pageYOffset` properties return the number of pixels that the document is currently scrolled horizontally and vertically.

## ViewPort width and height :

- `document.documentElement.clientHeight`
- `document.documentElement.clientWidth`
  
    are used to know the width and height of viewPort in px ( return maximum scrollble height / width )
    

## width and height of element :

- `element.getBoundingClientRect();`

- returns `DOMRect` object providing information about the size of an element and its position relative to the viewport.

## Scroll to perticular location :

### 1. Based on coordinates

```Plain
window.scrollTo( x-coord, y-coord);

window.scrollTo(
	{ left: x-coord,
	  top : y-coord,
	  bahavior : 'auto'|'smooth'} );
```

- Scrolls to a particular set of coordinates in the document.

### 2. Based on elements

```Plain
element.scrollIntoView( Boolean-[alignToTop] );

element.scrollIntoView(
	{ behavior : 'auto'|'smooth',
	  block : 'start'|'center'|'end'|'nearest',
	  inline : 'start'|'center'|'end'|'nearest'   } );
```

- Scrolls the element's parent container such that the element on which scrollIntoView() is called is visible to the user.

## Scrolling an element :

- Like the window object, you can attach a scroll event handler to any HTML element.
- However, to track the scroll offset, you use the `scrollTop` and `scrollLeft` instead of the `scrollX` and `scrollY`.



# Intersection observer :

- The Intersection Observer API provides a way to asynchronously observe changes in the intersection of a target element with an ancestor element or with a top-level document's [viewport](https://developer.mozilla.org/en-US/docs/Glossary/Viewport).
- Intersection information is needed for many reasons, such as:
    - Lazy-loading of images or other content as a page is scrolled.
    - Implementing "infinite scrolling" websites, where more and more content is loaded and rendered as you scroll, so that the user doesn't have to flip through pages.
    - Reporting of visibility of advertisements in order to calculate ad revenues.

## Creating an intersection observer

- The Intersection Observer API allows you to configure a callback that is called when either of these circumstances occur:
  
    - A **target** element intersects either the device's viewport or a specified element. That specified element is called the **root element** or **root** for the purposes of the Intersection Observer API.
    - The first time the observer is initially asked to watch a target element.
    
    ```Plain
    let options = {
      root: document.querySelector("\#scrollArea"),
      rootMargin: "0px",
      threshold: 1.0,
    };
    
    let observer = new IntersectionObserver(callback, options);
    ```
    

### Intersection observer options

- `root`
  
    The element that is used as the viewport for checking visibility of the target. Must be the ancestor of the target. Defaults to the browser viewport if not specified or if `null`.
    
- `rootMargin`
  
    Margin around the root. Can have values similar to the CSS [`margin`](https://developer.mozilla.org/en-US/docs/Web/CSS/margin) property, e.g. "`10px 20px 30px 40px"` (top, right, bottom, left). The values can be percentages. This set of values serves to grow or shrink each side of the root element's bounding box before computing intersections. Defaults to all zeros.
    
- `threshold`
  
    Either a single number or an array of numbers which indicate at what percentage of the target's visibility the observer's callback should be executed. If you only want to detect when visibility passes the 50% mark, you can use a value of 0.5.
    
    If you want the callback to run every time visibility passes another 25%, you would specify the array [0, 0.25, 0.5, 0.75, 1]. The default is 0 (meaning as soon as even one pixel is visible, the callback will be run). A value of 1.0 means that the threshold isn't considered passed until every pixel is visible.
    

### Targeting an element to be observed

- Once you have created the observer, you need to give it a target element to watch:
  
    ```Plain
    let target = document.querySelector("\#listItem");
    
    let observer = new IntersectionObserver(callback, options);
    observer.observe(target);
    ```
    
- Whenever the target meets a threshold specified for the `IntersectionObserver`, the callback is invoked. The callback receives a list of [`IntersectionObserverEntry`](https://developer.mozilla.org/en-US/docs/Web/API/IntersectionObserverEntry) objects and the observer:
  
    ```Plain
    let callback = (entries, observer) => {
      entries.forEach((entry) => {
        // Each entry describes an intersection change for one observed
        // target element:
        //   entry.boundingClientRect
        //   entry.intersectionRatio
        //   entry.intersectionRect
        //   entry.isIntersecting	(*)
        //   entry.rootBounds
        //   entry.target
        //   entry.time
      });
    };
    ```