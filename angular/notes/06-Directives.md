# Directive
  
- Directives are used to change the behaviour of components or elements.
- It can be used **in the form of HTML attributes**.
- We can create directives using classes attached with @Directive decorator which adds metadata to the class.
- There are three types of directives available in Angular

![[dir21631710539595.png]]

**Components**
- Components are directives with a template or view.
- @Component decorator is actually @Directive with templates  

**Structural Directives**
- A Structural directive changes the DOM layout by adding and removing DOM elements.

```TypeScript
*directive-name = expression
```
   
- Angular has few built-in structural directives such as:
    - ngIf
    - ngFor
    - ngSwitch

# Structural directives

- Structural directives are directives which change the DOM layout by adding and removing DOM elements.
- Angular provides a set of built-in structural directives (such as `NgIf`, `NgForOf`, `NgSwitch` and others) which are commonly used in all Angular projects. 
- For more information see [Built-in directives](https://angular.io/guide/built-in-directives).
- When structural directives are applied they generally are prefixed by an asterisk, `*` Such as `*ngIf`.
- This convention is shorthand that Angular interprets and converts into a longer form.

```HTML
<div *ngIf="hero" class="name">{{hero.name}}</div>
```

- Angular creates an `<ng-template>` element and applies the `ngIf` directive onto it where it becomes a property binding in square brackets, `[ngIf]`.
- The rest of the `<div>`, including its class attribute, is then moved inside the `<ng-template>`:

```HTML
<ng-template [ngIf]="hero">
  <div class="name">{{hero.name}}</div>
</ng-template>
```

## ngIf

- ngIf directive renders components or elements conditionally based on whether or not an expression is true or false.

```TypeScript
*ngIf = "expression"
```
   
- If-Else Example:

```HTML
<div *ngIf="hero else else-block" class="name">If Block</div>

<ng-template #else-block>
  <div class="name">Else Block</div>
</ng-template>
```

```HTML
<div *ngIf="hero; then if-block else else-block" class="name"></div>

<ng-template #if-block>
  <div class="name">If Block</div>
</ng-template>
<ng-template #else-block>
  <div class="name">Else Block</div>
</ng-template>
```

```HTML
<div *ngIf="show=='yes'; then if-block else else-block" class="name"></div>

<ng-template #if-block>
  <div class="name">If Block</div>
</ng-template>
<ng-template #else-block>
  <div class="name">Else Block</div>
</ng-template>
```

```HTML
<ng-template [ngIf]="color==='red'">
  <div class="name">Red</div>
</ng-template>
<ng-template [ngIf]="color==='green'">
  <div class="name">Green</div>
</ng-template>
<ng-template [ngIf]="color==='blue'">
  <div class="name">Blue</div>
</ng-template>
```

## ngSwitch

- Its syntax is comprised of two directives, an attribute directive, and a structural directive.
- Switch Case Example:

```HTML
<div [ngSwitch]="color">
	<h1 *ngSwitchCase="'red'">Red</h1>
	<h1 *ngSwitchCase="'blue'">Blue</h1>
	<h1 *ngSwitchCase="'Green'">Green</h1>
	<h1 *ngSwitchDefault>Unknown</h1>
</div>
```

- ngSwitch takes the value and based upon the value inside the choice property, it executes *ngSwitchCase.

## ngFor

- ngFor directive is used to iterate over-collection of data i.e., arrays

```TypeScript
*ngFor = "expression"
```
 
- Loop Example:

```TypeScript
export class AppComponent {
  users = [
	"Rahul",
	"Ravi",
	"Raj",
	"Rohan",
	"Rajesh",
	"Ramesh",
	"Rajiv",
	"Rajnikant",
	"Rajendra",
  ];
}
```
    
```HTML
<h1 *ngFor="let i of users">{{i}}</h1>
```

```HTML
<ul>
	<li *ngFor="let user of users;  let i = index"> 
	   {{i}} - {{ user }} 
	</li>
</ul>
```



# Custom Structural Directive

- You can create custom structural directives when there is no built-in directive available for the required functionality.
- Command :

```Shell
ng generate directive <directive-name>
```

- The CLI will create a new file called `<directive-name>.directive.ts` in the src/app directory.
- It also adds directive to the root module i.e., app.module.ts to make it available to the entire module.

- Open the `<directive-name>.directive.ts` file and add the following code:

```TypeScript
import { Directive } from '@angular/core';

@Directive({
	selector: '[app<directive-name>]'
})
export class <directive-name>Directive {
  constructor() {
  }
}
```

- The `@Directive` decorator tells Angular that this class is a directive.
- The selector property tells Angular which HTML element to apply the directive to. In this case, the directive will be applied to any element with the attribute `app<directive-name>`.
- Save the file.
- Now, you can use the directive in your HTML templates. For example, the following code will apply the directive to a `<div>` element:

```HTML
<div app<directive-name> ></div>
```
 
- You can also add inputs and outputs to your directive. 
- Inputs allow you to pass data from the template to the directive. Outputs allow you to emit events from the directive to the template.
- For example, the following code adds an input property called `color` to the directive:

```TypeScript
@Directive({
	selector: '[app<directive-name>]'
})
export class <directive-name>Directive {
	@Input() color: string;
	constructor() {}
}
```

- Now, you can pass a value to the `color` input property in the template.
- For example, the following code will set the background color of the `<div>` element to red:

```HTML
<div app<directive-name> [color]="'red'"></div>
```
-
- You can also add outputs to your directive. Outputs allow you to emit events from the directive to the template.
- For example, the following code adds an output property called `clicked` to the directive:

```TypeScript
@Directive({
	selector: '[app<directive-name>]'
})
export class <directive-name>Directive {
	@Output() clicked = new EventEmitter<void>();
	
	constructor() {}
	
	onClick() {
		this.clicked.emit();
	}
}
```

- Now, you can listen for the `clicked` event in the template.
- For example, the following code will log a message to the console when the `<div>` element is clicked:

```HTML
<div app<directive-name> (clicked)="onClick()"></div>
```

- Changing style using directive

```TypeScript
import { Directive, ElementRef  } from '@angular/core';

@Directive({
	selector: '[appRedEl]'
})
export class RedElDirective {
	constructor(el.ElementRef) {
		el.nativeElement.style.color='red';
	}
}
```

```HTML
<div appRedEl">Hello World</div>
```

- Example:

Create a custom structural directive called 'repeat' which should repeat the element given a number of times. As there is no built-in directive available to implement this, a custom directive can be created.

```TypeScript
// app.module.ts
import { RepeatDirective } from './repeat.directive';
@NgModule({
	declarations: [
		AppComponent,
		RepeatDirective
	],
 ...
})
export class AppModule { }
```

```TypeScript
// repeat.directive.ts
import { Directive, TemplateRef, ViewContainerRef, Input } from '@angular/core';

@Directive({
	selector: '[appRepeat]'
})
export class RepeatDirective 
{
	constructor(private templateRef: TemplateRef<any>, 
							private viewContainer: ViewContainerRef) { 
	}

	@Input() set appRepeat(count: number) {
		for (let i = 0; i < count; i++) {
		  this.viewContainer.createEmbeddedView(this.templateRef);
		}
	}
}
```

- Create a constructor and inject two classes called `TemplateRef` which acquires `<ng-template>` content and another class called `ViewcontainerRef` which access the HTML container to add or remove elements from it.
- Create a setter method for an `appRepeat` directive by attaching `@Input()` decorator which specifies that this directive will receive value from the component. This method takes the number passed to the appRepeat directive as an argument.
- As we need to render the elements based on the number passed to the appRepeat directive, run a for loop in which pass the template reference to a `createEmbeddedView` method which renders the elements into the DOM. This structural directive creates an embedded view from the Angular generated `<ng-template>` and inserts that view in a view container.

```HTML
// app.component.html

<h3>Structural Directive</h3>
<p *appRepeat="5">I am being repeated...</p>
```

![[day2_p10.png]]


## exportAs Property

- **exportAs** property is used to define a name for a directive using which you can access directive class properties and methods in a component template.
- exportAs property can be applied to components and directives.

```TypeScript
import { 
	Directive, 
	TemplateRef, 
	ViewContainerRef, 
	Input } from '@angular/core';

@Directive({
	selector: '[appRepeat]',
	exportAs: 'repeat,changeText',
})
export class RepeatDirective {
	constructor(
		private templateRef: TemplateRef<any>,
		private viewContainer: ViewContainerRef
	) { }
	
	repeatElement(count: number) {
		for (let i = 0; i < count; i++) {
			this.viewContainer.createEmbeddedView(this.templateRef);
		}
	}
	
	changeElementText(count: number) {
		for (let i = 0; i < 5; i++) {
		  document.getElementsByTagName('p')[i].innerHTML = 'Text is changed...';
		}
	}
}
```

- appRepeat directive is exported with two names here i.e., repeat and changeText. You can use multiple names to export a directive.
- repeatElement() method will take a count value as input and creates and renders the elements on the page.
- changeElementText() method will take a count value as input and changes the rendered HTML elements text.
- Modify **app.component.html** file used in the custom structural directive as shown below:

```HTML
<h3>Structural Directive with exportAs property</h3>
<ng-template appRepeat #rd="repeat" #ct="changeText">
  <p>I am being repeated...</p>
</ng-template>
<button (click)="rd.repeatElement(5)">Repeat Element</button>
<button (click)="ct.changeElementText(5)">Change Text</button>
```

- Here the template section is bound with template variables 'rd' and 'ct'.
- Each template variable has been assigned with the exported names of a directive class.
- Now in a template, you can access directive class methods using these template variables called 'rd' and 'ct' where each is a reference to 'repeat' and 'changeText' names of a directive.
![[exportAs_Directive_Output1.png]]
  
- repeatElement() method of a directive class is accessed using the template variable rd. When this button is clicked, it invokes a method that will, in turn, renders five paragraphs on the page.

![[exportAs_Directive_Output2.png]]    
 
- changeElementText() method of a directive class is accessed using the template variable ct. When this button is clicked, it invokes the method which will, in turn, change the text of all the rendered paragraphs.

![[exportAs_Directive_Output3.png]]


# Attribute Directives

- Attribute directives change the appearance/behaviour of a component/element.
- Following are built-in attribute directives:
    - ngStyle
    - ngClass

## ngStyle

- This directive is used to modify a component/element’s style.
- You can use the following syntax to set a single CSS style to the element which is also known as style binding

```HTML
[style.<cssproperty>] = "value"
```
   
- Example:
   
```TypeScript
// app.component.ts

export class AppComponent {
  colorName = 'yellow';
  color = 'red';
}

// colorName and color properties are initialized to default values
```

```TypeScript
// app.component.html

<div [style.background-color]="colorName" [style.color]="color">
  Uses fixed yellow background
</div>
```

![[s_50_a.png]]


- If there are more than one CSS styles to apply, you can use **ngStyle** attribute.
- Example:

```TypeScript
export class AppComponent {
  colorName = 'red';
  fontWeight = 'bold';
  borderStyle = '1px solid black';
}
```

```HTML
<p [ngStyle]="{
				color:colorName,
				'font-weight':fontWeight,
				borderBottom: borderStyle
}">
	Demo for attribute directive ngStyle
</p>
```

![[ngStyle.png]]


## ngClass

- It allows you to dynamically set and change the CSS classes for a given DOM element.
- Use the following syntax to set a single CSS class to the element which is also known as class binding.

```HTML
[class.<css_class_name>] = "property/value"
```

- Example:

```TypeScript
// app.component.ts

export class AppComponent {
  isBordered = true;
}

// Create a Boolean property called isBordered and initialize it to true
```

```HTML
// app.component.html

<div [class.bordered]="isBordered">
  Border {{ isBordered ? "ON" : "OFF" }}
</div>

<!-- 
	Bind the isBordered property with the CSS class bordered.
	Bordered CSS class will be applied only if isBordered property evaluates to true.
 -->
```

```CSS
/* app.component.css */

.bordered {
	border: 1px dashed black;
	background-color: \#eee;
}
```

![[s_50_c.png]]
  
- If you have **more than one CSS classes to apply**, then you can go for ngClass syntax.
- Syntax:

```CSS
[ngClass] = "{
	css_class_name1 : Boolean expression, 
	css_class_name2: Boolean expression, ……
}"
```

- Example:

```TypeScript
// app.component.ts 

export class AppComponent  {
	isBordered = true;
	isColor = true;
}
```

```HTML
<div [ngClass]="{bordered: isBordered, color: isColor}">
	Border {{ isBordered ? "ON" : "OFF" }}
</div>
```

```CSS
.bordered {
	border: 1px dashed black;
	background-color: \#eee;
}
.color {
	color: blue;
}
```

![[class_demo.png]]

  

  


# Custom Attribute directive

- You can create custom attribute directives when there is no built-in directive available for the required functionality.
- Command :

```Shell
ng generate directive <directive-name>
```

- The CLI will create a new file called `<directive-name>.directive.ts` in the src/app directory.
- It also adds directive to the root module i.e., **app.module.ts** to make it available to the entire module as shown below.

- Example:

Create an attribute directive called 'showMessage' which should display the given message in a paragraph. when a user clicks on it and should change the text color to red. As there is no built-in directive available to implement this functionality, you need to go for a custom directive.

Open the **message.directive.ts** file and add the following code:

```CSS
import { Directive, ElementRef, Renderer2, HostListener, Input } from '@angular/core';
@Directive({
	selector: '[appMessage]',
})
export class MessageDirective {
	@Input('appMessage') message!: string;
	
	constructor(private el: ElementRef, private renderer: Renderer2) {
	    renderer.setStyle(el.nativeElement, 'cursor', 'pointer');
	}
	
	@HostListener('click') onClick() {
	    this.el.nativeElement.innerHTML = this.message;
	    this.renderer.setStyle(this.el.nativeElement, 'color', 'red');
	}
}
```

- Create a directive class with the selector name as appMessage
- @Input('appMessage') will inject the value passed to 'appMessage' directive into the 'message' property.
- Use constructor injection to inject ElementRef which holds the HTML element reference in which directive is used and Renderer2 which is used to set the CSS styles.
- Using Renderer2 reference, the cursor is being changed to pointer symbol.
- onClick method is invoked when the click event is triggered on the directive which will display the message received and changes the element color to red.

```TypeScript
// app.component.ts

import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  myMessage="Hello, I am from attribute directive"
}
```

```TypeScript
<h3>Attribute Directive</h3>
<p [appMessage]="myMessage">Click Here</p>
```

  
## exportAs

- You have seen the use of exportAs property in the custom structural directive concept.
- The same can be used on a custom attribute directive as well.

- Example:

In the custom attribute directive example, modify the code written in **message.directive.ts** so that onClick() method of the directive is callable from the component template directly.

For this, modify the **message.directive.ts** file as shown below:

```TypeScript
import { Directive, ElementRef, Renderer2, HostListener, Input } from '@angular/core';
@Directive({
  selector: '[appMessage]',
  exportAs: 'changeMessage'
})
export class MessageDirective {
	@Input('appMessage') message!: string;
	constructor(private el: ElementRef, private renderer: Renderer2) {
		renderer.setStyle(el.nativeElement, 'cursor', 'pointer');
	}
	onClick() {
		this.el.nativeElement.innerHTML = this.message;
		this.renderer.setStyle(this.el.nativeElement, 'color', 'red');
	}
}
```

- Directive class is exported with another name called 'changeMessage'.
- `onClick()` method will be directly called in a component template. Notice that the click event binding has been removed here.

```html
<h3>Attribute Directive with exportAs property</h3>
<div [appMessage]="myMessage" #msg="changeMessage">
	<p (click)="msg.onClick()">Click Here</p>
</div>
```

- 'changeMessage' name is assigned to the template variable called 'msg'. Now using the 'msg' variable, the directive class methods can be accessed.
- The onClick() method of a directive class is invoked using the 'msg' template variable. When this paragraph is clicked, it will change the paragraph text and its color.