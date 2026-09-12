# Templates

- Templates in Angular represents a view and its role is to display data and change the data whenever an event occurs
- Each Angular template in your application is a section of HTML to include as a part of the page that the browser displays.
- In Angular, a template is a blueprint for a fragment of a user interface (UI)
- Almost all HTML syntax is valid template syntax.

- However, because an Angular template is only a fragment of the UI, it does not include elements such as `<html>`, `<body>`, or `<base>`.
- To eliminate the risk of script injection attacks, Angular does not support the `<script>` element in templates.
- Angular ignores the `<script>` tag and outputs a warning to the browser console.
- `app.component.html` file is the default template containing placeholder HTML.

- Template can be defined in two ways:
    - Inline Template (`template`)
    - External Template (`templateUrl`) (default)
 
The path mentioned in the templateUrl property should be always relative.

- Example:

```TypeScript
// app.component.ts:
import { Component } from '@angular/core';
@Component({
  selector: 'app-root',    
  templateUrl:'./app.component.html',  
  template: `Welcome to {{course}}`
})
export class AppComponent {
  salutation = "Hello";
  course = "Angular";
}
 

// app.component.html:
{{salutation}} {{course}}
```
- Output: Hello Angular
- **External template** will take precedence over the component inline template.

  

# Elements of Template

- The basic elements of template syntax:
    - HTML
    - Interpolation (`{{}}`)
    - Template Expressions (`{{ isLoggedIn ? 'Welcome back!' : 'Please log in.' }}`)
    - Template Statements 

  
### Interpolation

- Interpolation refers to embedding expressions into marked up text.
- Interpolation is one of the forms of data binding where component’s data can be accessed in a template. 
- For interpolation, double curly braces `{{ }}` is used.
- By default, interpolation uses the double curly braces `{{` and `}}` as delimiters.
- Example:

> component file

```TypeScript
export class AppComponent {
	title = 'Viral Gajera';
}
```

corresponding component template file

```HTML
<h3>Current customer: {{ currentCustomer }}</h3>
```


### Template expressions

- Angular first evaluates the expression and returns the result as a string.
- The scope of a template expression is a component instance.

You can't use JavaScript expressions that have or promote side effects, including:

- Assignments (`=`, `+=`, `=`, `...`)
- Operators such as `new`, `typeof`, or `instanceof`
- Chaining expressions with `;` or `,`
- The increment and decrement operators `++` and `-`
- Some of the ES2015+ operators

Other notable differences from JavaScript syntax include:

- No support for the bitwise operators such as `|` and `&`
- New [template expression operators](https://angular.io/guide/template-expression-operators), such as `|`, `?.` and `!`

  
### Template Statement

- Template Statements are the statements that respond to a user event.

```TypeScript
(event) = statement
```

- For example `(click) = "changeName()"`
- This is called event binding. In Angular, all events should be placed in ( ).

  

# Templere reference variable

- A template reference variable is a name that you can assign to a DOM element in an Angular template.
- This allows you to access the element in your component code.
- Template variables help you use data from one part of a template in another part of the template.
- Use template variables to perform tasks such as respond to user input or finely tune your application's forms.
- A template variable can refer to the following:
    - a DOM element within a template
    - a directive or component
    - a [TemplateRef](https://angular.io/api/core/TemplateRef) from an [ng-template](https://angular.io/api/core/ng-template)
    - a [web component](https://developer.mozilla.org/en-US/docs/Web/Web_Components)
- To create a template reference variable, you add the hash symbol (#) followed by the name of the variable to the element.

- Example:

```HTML
<input #phone placeholder="phone number" />

<!-- lots of other elements -->

<!-- phone refers to the input element; pass its `value` to an event handler -->
<button type="button" (click)="callPhone(phone.value)">Call</button>
```

- Example:
   
```TypeScript
import { Component, ViewChild } from '@angular/core';

@Component({
	selector: 'my-app',
	template: `
		<input #myInput>
		<button (click)="onClick()">Click me</button>
	`,
})
export class AppComponent {
  @ViewChild('myInput') myInput: HTMLInputElement;

  onClick() {
	console.log(this.myInput.value);
  }
}
```

- Template expressions cannot refer to anything in the global namespace, except `undefined`. They can't refer to `window` or `document`.
- Additionally, they can't call `console.log()` or `Math.max()` and they are restricted to referencing members of the expression context.

### Variable specifying a name

- If the variable specifies a name on the right-hand side, such as `#var="ngModel"`, the variable refers to the directive or component on the element with a matching `exportAs` name.

  
# Change Detection

**How does Angular detect the changes and update the application at the respective places?**
- Angular uses its change detection mechanism to detect the changes and update the application at the respective places.  

**What is the change detection mechanism, and how it helps to run Angular applications so fast?**
- Change Detection is a process in Angular that keeps views in sync with the models.
- In Angular, the flow is unidirectional from top to bottom in a component tree. 
- A change in a web application can be caused by events, Ajax calls, and timers which are all asynchronous.

**Who informs Angular about the changes?**
- **Zones** inform Angular about the changes in the application.
- It automatically detects all asynchronous actions at run time in the application.  

**What does Angular do when a change is detected?**
- Angular runs a change detector algorithm on each component from top to bottom in the component tree.
- This change detector algorithm is automatically generated at run time which will check and update the changes at appropriate places in the component tree.
- Angular is very fast though it goes through all components from top to bottom for every single event as it generates VM-friendly code.
- Due to this, Angular can perform hundreds of thousands of checks in a few milliseconds.