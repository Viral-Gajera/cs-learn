# Data Binding

- Data Binding is a mechanism where data in view and model are in sync.
- Users should be able to see the same data in a view which the model contains.
- There are two types of data bindings based on the direction in which data flows.
    
    - One-way Data Binding
    - Two-way Data Binding

| **Data Direction**           | **Syntax**                                          | **Binding Type**                                                                                       |
| ---------------------------- | --------------------------------------------------- | ------------------------------------------------------------------------------------------------------ |
| One-way (Class -> Template)  | {{ expression }}  <br>  <br>[target] = "expression" | • Interpolation  <br>• Property binding  <br>• Attribute binding<br>• Style binding<br>• Class binding |
| One-way (Template - > Class) | (target) = "statement"                              | • Event                                                                                                |
| Two-way                      | [(target)] = "expression"                           | • Two way                                                                                              |

- `target` in the above table refers to a property/event/attribute-name.

**One-way Data Binding**

The following are one-way data binding types:

1. Property Binding
2. Attribute Binding
3. Style Binding
4. Class Binding
5. Event Binding

# Property Binding

- Property binding moves a value in one direction, from a component's property into a target element property.
- Property binding also supports boolean value unlike interpolation.
- Angular internally converts string interpolation into property binding.
- To bind to an element's property, enclose it in square brackets, `[]` , which identifies the property as a target property.

```HTML
<button [disabled]="isDisabled">Button</button>

<input type="text" [value]="x">
<h1 [style.color]="color" >Heading</h1>
<img [src]='imageUrl' />
<img bind-src='imageUrl' />
```
   
- In this example, the disabled property of the button is bound to the `isDisabled` property of the component. If the isDisabled property is true, the button will be disabled.

![[2 2.png|2 2.png]]

- Interpolation can be used as an alternative to property binding. 
- Property binding is mostly used when it is required to set a non-string value.


# Attribute Binding

- Property binding will not work for a few elements/pure attributes like ARIA, SVG, and COLSPAN. In such cases, you need to go for attribute binding.
- Attribute binding can be used to **bind a component property to the attribute directly.**
- For example,

```HTML
<td colspan = "{{ 2+3 }}">Hello</td>
```

- The above example gives an error as colspan is not a property.
- Even if you use property binding/interpolation, it will not work as it is a pure attribute. For such cases, use attribute binding.
- Attribute binding syntax starts with prefix `attr`. followed by a dot sign and the name of an attribute. And then set the attribute value to an expression.
- Example:

```HTML
<td [attr.colspan]="2+3">Hello</td>
```
   

# Style Binding

- Style binding is used to set inline styles.
- Syntax starts with prefix style, followed by a dot and the name of a CSS style property.

```HTML
[style.styleproperty]
```

- Example:

```HTML
<button [style.color] = "isValid ? 'blue' : 'red' ">Hello</button>
```

- Some style bindings will have a unit extension.

```HTML
<button [style.font-size.px] = "isValid ? 3 : 6">Hello</button>
```

- Here text font size will be set to 3 px if the expression isValid is true, otherwise, it will be set to 6px.
- The `ngStyle` directive is preferred when it is required to set multiple inline styles at the same time.

# Class Binding
- Allows us to dynamically add or remove CSS classes from an HTML element.
- To use class binding, you need to use the `class` attribute in your HTML template. 
- The value of the `class` attribute should be an expression that evaluates to a string containing the names of the CSS classes that you want to add or remove from the element.

- Example
```tsx
<button class="btn btn-primary" [class.active]="isButtonActive">Click Me</button>
```

- For example, the above code would add the `active` CSS class to the `<button>` element when the `isButtonActive` property is true

# Event Binding

- User actions such as entering text in input boxes, picking items from lists, button clicks may result in a flow of data in the opposite direction: from an element to the component.
- Event binding syntax consists of a target event with `( )` on the left of an equal sign and a template statement on the right.
- Example:

```HTML
<button (click) ="onSubmit(username.value, password.value)">Login</button>
<button on-click = "onSubmit(username.value, password.value)">Login</button>
```    


# Two way data binding

- Two-way data binding in Angular is a mechanism that allows you to automatically keep the data in your application's model and view synchronized.
- When you use two-way data binding, any changes that you make to the data in the model are automatically reflected in the view, and any changes that you make to the data in the view are automatically reflected in the model.
- Syntax:

```HTML
[(ngModel)]
```

- Two-way data binding is implemented using the `ngModel` directive.
- Example:

```HTML
<input [(ngModel)]="course.courseName">
```

- Behind the scenes, this is equivalent to

```HTML
<input [ngModel]="course.courseName" (ngModelChange)="course.courseName=$event" >
```

- OR 

```HTML
<input bindon-ngModel="course.courseName">
```

- Example:

> app.component.ts

```TypeScript
export class AppComponent {
	name: string = "Angular";
}
```

- Create a property called name and initialize it to value 'Angular’.

> app.component.html

```HTML
<input type="text" [(ngModel)]="name"> <br/>
<div>Hello , {{ name }}</div>
```

- Bind name property with text box using ngModel placed in `[()]` which is a representation of two-way data binding.
- Here whatever is typed in the textbox at run time will be assigned to the property name and when there is a change for the name property value, it will be auto-reflected in the textbox.

- To make two-way data binding i.e., `[(ngModel)]` work, import FormsModule class to the root module as shown below.

> app.module.ts

```TypeScript
import { FormsModule } from '@angular/forms';
...
@NgModule({
	imports: [
		BrowserModule,
		FormsModule
	],
 ...
})
export class AppModule { }
```