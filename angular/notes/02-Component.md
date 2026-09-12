# Component
  

- Components are the main building blocks for Angular applications.
- Each component consists of:
	- CSS selector that defines how the component is used in a template
    - A TypeScript class that defines behaviour
    - An HTML template that declares what renders on the page
    - Optionally, CSS styles applied to the template

  
app.component.ts

```TypeScript
import { Component } from '@angular/core';

@Component({
	// Choose a CSS selector for the component.
	selector: 'app-root',
	templateUrl: './component-overview.component.html',
	styleUrls: ['./component-overview.component.css']
})
export class AppComponent{ };
```

  

# Specifying a component's CSS selector

- Every component requires a CSS _selector_.
- A selector instructs Angular to instantiate this component wherever it finds the corresponding tag in template HTML.
- For example, consider a component `hello-world.component.ts` inside `/app/hello-world` that defines its selector as `app-hello-world`.
- This selector instructs Angular to instantiate this component any time the tag `<app-hello-world>` appears in a template.
- `app-` prefix specifies that, it is inside `app` component.

  

# Defining a component's template

- To define a <u>template as an external file</u>, add a `templateUrl` property to the `@Component` decorator.

```TypeScript
@Component({
	selector: 'app-component-overview',
	templateUrl: './component-overview.component.html',
})
```

- To define a <u>template within the component</u>, add a `template` property to the `@Component` decorator that contains the HTML you want to use.

```JavaScript
@Component({
	selector: 'app-component-overview',
	template: '<h1>Hello World!</h1>',
	styles: ['h1 { font-weight: normal; }']
})
```

- If you want your template to span multiple lines, use backticks `(``)`. For example:

```tsx
@Component({
	selector: 'app-component-overview',
	template: `
		<h1>Hello World!</h1>
        <p>This template definition spans multiple lines.</p>
	`,
	styles: ['h1 { font-weight: normal; }']
})
```

- An Angular component requires a template defined using `template` or `templateUrl`. 
- You can have both properties in a component. (`templeteUrl` take the priority)

  

# Creating a standalone component

- Our recommendation is to make components standalone using the `standalone: true` flag in the `@Component` decorator.


# Component Life Cycle

- A component has a life cycle that is managed by Angular.
- It includes creating a component, rendering it, creating and rendering its child components, checks when its data-bound properties change, and destroy it before removing it from the DOM.
- Angular has some methods/hooks which provide visibility into these key life moments of a component and the ability to act when they occur.
- Following are the lifecycle hooks of a component. The methods are invoked in the same order as mentioned in the table below:

| **Interface**       | **Hook**              | **Support**          |
| ------------------- | --------------------- | -------------------- |
| OnChanges           | ngOnChanges           | Directive, Component |
| OnInit              | ngOnInit              | Directive, Component |
| DoCheck             | ngDoCheck             | Directive, Component |
| AfterContentInit    | ngAfterContentInit    | Component            |
| AfterContentChecked | ngAfterContentChecked | Component            |
| AfterViewInit       | ngAfterViewInit       | Component            |
| AfterViewChecked    | ngAfterViewChecked    | Component            |
| OnDestroy           | ngOnDestroy           | Directive, Component |

  

![[227ced90-7b43-11eb-9fdb-fd18d97d9012.png]]

  

- **Syntax**:

```TypeScript
import { 
		Component, OnInit,  DoCheck, 
		AfterContentInit, AfterContentChecked,
	AfterViewInit, AfterViewChecked, OnDestroy 
} from '@angular/core';

...

export class AppComponent implements 
		OnInit,  DoCheck,  AfterContentInit, 
		AfterContentChecked, AfterViewInit, 
		AfterViewChecked,  OnDestroy 
{
		
	ngOnInit() {  }
	
	ngDoCheck() {  }
	
	ngAfterContentInit() { }
	
	ngAfterContentChecked() { }
	
	ngAfterViewInit() {  }
	
	ngAfterViewChecked() {   }
	
	ngOnDestroy() {  }
}
```

  

**Lifecycle Hooks :**

- `ngOnChanges` – It gets invoked when Angular sets data-bound input property i.e, the property attached with @Input(). This will be invoked whenever input property changes its value.
- `ngOnInit` – It gets invoked when Angular initializes the directive or component.
- `ngDoCheck` – It will be invoked for every change detection in the application.
- `ngAfterContentInit` – It gets invoked after Angular projects content into its view.
- `ngAfterContentChecked` – It gets invoked after Angular checks the bindings of the content it projected into its view.
- `ngAfterViewInit` – It gets invoked after Angular creates component’s views.
- `ngAfterViewChecked` – It gets invoked after Angular checks the bindings of the component’s views.
- `ngOnDestroy` – It gets invoked before Angular destroys directive or component.

  

Example:

```TypeScript
/* app.component.ts */

import {
    Component, OnInit, DoCheck, 
	AfterContentInit, AfterContentChecked,
    AfterViewInit, AfterViewChecked, OnDestroy
} from '@angular/core';

@Component({
    selector: 'app-root',
    styleUrls: ['./app.component.css'],
    templateUrl: './app.component.html'
})

export class AppComponent implements 
		OnInit, DoCheck, AfterContentInit, 
		AfterContentChecked, AfterViewInit, 
		AfterViewChecked, OnDestroy 
{
    data = 'Angular';

    ngOnInit() {
        console.log('Init');
    }
    ngDoCheck(): void {
        console.log('Change detected');
    }
    ngAfterContentInit(): void {
        console.log('After content init');
    }
    ngAfterContentChecked(): void {
        console.log('After content checked');
    }
    ngAfterViewInit(): void {
        console.log('After view init');
    }
    ngAfterViewChecked(): void {
        console.log('After view checked');
    }
    ngOnDestroy(): void {
        console.log('Destroy');
    }
}
```

- ngOnInit() is the first method to be invoked for AppComponent.
- Whenever data property value changes it invokes the ngDoCheck() method.
- All Init methods gets invoked only once at the beginning, and from later whenever a change happens Angular invokes ngDoCheck, ngAfterContentChecked and ngAfterViewChecked methods.

```HTML
/* app.component.html */

<div>  
  <h1>I'm a container component</h1>
  <input type="text" [(ngModel)]='data'> 
  <app-child [title]='data'></app-child>
</div>
```

```TypeScript
/* child.component.ts */

export class ChildComponent implements OnChanges {
  @Input() title: string = 'I\'m a nested component';
  ngOnChanges(changes: any): void {
    console.log('changes in child:' + JSON.stringify(changes));
  }
}
```

- Override ngOnChanges method which gets invoked whenever input property changes its value.
- Whenever the input property called title changes its value, Angular invokes `ngOnChanges()` method which takes the changes as a JSON object.
- The 'changes' parameter will have the previous value and the current value of the input property

```HTML
/* child.component.html */

<h2>Child Component</h2>
<h2>{{title}}</h2>
```

  

![[day3_part2_17.png]]

  

![[angular05.png]]

  

  

# Component Styling

- Angular provides a mechanism for specifying component-specific styles which do not leak out into the rest of the page.
- The following are the different ways to add styles to a component:
    - By using styleUrls metadata
    - By using styles metadata
    - By using Internal style
    - Inline style into the template


**Using styleUrls  property**

- The CSS styles declared in external files can be loaded into a component by using the styleUrls property.
- styleUrls is an array property where multiple CSS files can be loaded into a component.

  
**Using styles property**

- CSS styles can be added to a component by adding styles property to the component metadata.
- Styles is an array property where multiple CSS classes for a component can be defined.

```TypeScript
import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styles: [`
  .highlight {
	  border: 2px solid red;
	  background-color:AliceBlue;
	  text-align: center;
	  margin-bottom: 20px;
  }
`],
})
export class AppComponent {
}
```



**Using Internal style**

- Another option to add CSS styles to the component is by using inline-style.
- The styles can be directly embedded in the HTML template using `<style>` tag.


```TypeScript
<style>
  .highlight {
	border: 2px solid green;
	background-color: aliceblue;
	text-align: center;
	margin-bottom: 20px;
  }
</style>
<div class="highlight">Container Component</div>
<app-child></app-child>
``` 

# Shadow DOM

- In an Angular application, n number of components will be created and each component will have its own set of data and CSS styles.
- When these are integrated, there is a chance that the data and styles may be applied to the entire application.
- Shadow DOM encapsulates data and styles for each component to not flow through the entire application.
- In the below example shown, each component is having its own styles defined and they are confined to themselves:

![[1909_Image_06.png]]


# View Encapsulation

- Angular has built-in **view encapsulation** which enables you to use Shadow DOM.
- View Encapsulation defines how to encapsulate CSS styles into a component without flowing them to the rest of the page. 
- The following three modes of encapsulation provided by Angular helps in controlling how the encapsulation has to be applied:
    - ViewEncapsulation.Emulated (default)
    - ViewEncapsulation.ShadowDOM
    - ViewEncapsulation.None
    

**ViewEncapsulation.Emulated**

- When this encapsulation type is used, it re-writes the styles to the document head with some attributes selector.
- This is the default encapsulation type in Angular. It emulates style encapsulation even if shadow DOM is not available in the browsers.
- The usage of third-party components in the application might affect the application's look and feel as the third-party components usually comes with their own style. If such third-party component need to be safely added to the application, Emulated mode of ViewEncapsulation can be used.

![[day3_part2_12_v4.png]]

- Since there is no shadow DOM, Angular has to write the styles to the document head.
- In order to enable scoped styles, it extends the CSS selectors so that they don’t collide with other selectors defined in other components. That' why _ngcontent-* attributes are added.

  
**ViewEncapsulation.ShadowDOM**

- ViewEncapsulation.ShadowDOM enables Angular to use the browser's native Shadow DOM implementation.
- This mode is introduced in version 7.
- It is similar to `Emulated` but it is implemented in different way.
- Generate `first` and `second` component inside `app` .

```TypeScript
ng generate component first
ng generate component second
```
    
```CSS
/* app.component.css */ 
.cmp {
	padding: 6px;
	margin: 6px;
	border: blue 2px solid;
  }

/* first.component.css */
.cmp {
	padding: 6px;
	margin: 6px;
	border: blue 2px solid;
  }

/* second.component.css */
.cmp { 
  border: green 2px solid;
  padding: 6px;
  margin: 6px;
}
```

```HTML
/* app.component.html */
<h3>CSS Encapsulation with Angular</h3>
<div class="cmp">
	App Component
	<app-first></app-first>
	<app-second></app-second>
</div>


/* first.component.html*/
<div class="cmp">First Component</div>

/* second.component.html*/
<div class="cmp">Second Component</div>
```

```TypeScript
/* app.component.ts */

import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
}

/* first.component.ts */

import { Component } from '@angular/core';
@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent {
}

/* second.component.ts */

import { Component, ViewEncapsulation } from '@angular/core';
@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css'],
  encapsulation: ViewEncapsulation.ShadowDom
})
export class SecondComponent {
}
```

**Output:**

![[day3_part2_15.png]]

  

![[101646885999101.png]]

  

**ViewEncapsulation.None**

- Angular doesn’t use shadow DOM in **ViewEncapsulation.None**.
- All the styles defined in a component is applied to the entire document. i.e., a component can overwrite another component’s styles. This is an unscoped strategy.
- **Example**:

```TypeScript
/* app.component.ts */

import { Component, ViewEncapsulation } from '@angular/core';
@Component({
  selector: 'app-root',
  styleUrls: ['./app.component.css'],
  templateUrl: './app.component.html',
  encapsulation: ViewEncapsulation.None
})
export class AppComponent {
}

/* second.component.ts */

import { Component, ViewEncapsulation } from '@angular/core';
@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class SecondComponent {
}
```

  

Output:

![[day3_part2_16.png]]

![[111646886132065.png]]

  

| **Feature**                 | **ViewEncapsulation.Emulated**                       | **ViewEncapsulation.ShadowDOM**                   |
| --------------------------- | ---------------------------------------------------- | ------------------------------------------------- |
| **Encapsulation Mechanism** | Emulates encapsulation by adding unique attributes.  | Utilizes the native Shadow DOM for encapsulation. |
| **Style Isolation**         | Provides some level of style isolation.              | Provides stronger style encapsulation.            |
| **Global Styling**          | Styles are scoped to the component.                  | Styles are encapsulated using Shadow DOM.         |
| **Browser Support**         | Widely supported in all modern browsers.             | Requires browser support for Shadow DOM.          |
| **Component Styles Impact** | Styles defined in one component won't affect others. | Styles are scoped only to the specific component. |
| **Complexity**              | Simpler to implement and more widely supported.      | Requires browser support and may be more complex. |
