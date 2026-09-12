# Nested Component

- Nested component is a component that is loaded into another component.
- The root component is loaded in the index.html page <u>using its selector name</u>.
- Similarly, to load one component into a parent component, <u>use the selector name of the component in the template</u> i.e., the HTML page of the container component.

- Create a component called the coursesList inside app using the following CLI command.
- Syntax:

```Shell
ng generate component coursesList
```

- This command will also add the CoursesList component to the root module.

```typescript
...
import { CoursesListComponent } from './courses-list/courses-list.component';
@NgModule({
	declarations: [
		AppComponent,
		CoursesListComponent
	],
})
export class AppModule { }
```

- CoursesListComponent is added to the declarations property of module to make it available to all other components in the module.

```HTML
<h2>Popular Courses</h2>
<button (click)="show=true">View Courses list</button><br /><br />
<div *ngIf="show">
	<!-- courses-list.component.ts -->
	<!-- selector: 'app-courses-list' -->
	<app-courses-list></app-courses-list>
</div>
```

# exportAs

- It is possible to access child component properties and methods in a container component by exporting child components using exportAs property.
- As discussed in the directives concept, exportAs property can be applied to components and directives.

Example:   

> courses-list.component.ts (child component)

```TypeScript
import { Component, OnInit } from '@angular/core';
@Component({
	selector: 'app-courses-list',
	templateUrl: './courses-list.component.html',
	styleUrls: ['./courses-list.component.css'],
	exportAs: 'courselist'
})
export class CoursesListComponent {
	courses = [
		{ courseId: 1, courseName: 'Node JS' },
		{ courseId: 2, courseName: 'Typescript' },
		{ courseId: 3, courseName: 'Angular' },
		{ courseId: 4, courseName: 'React JS' }
	];
	
	course!: any;
	
	changeCourse(name: string) {
		this.course = {};
		for (let i = 0; i < this.courses.length; i++) {
			if (this.courses[i].courseName === name) {
				this.course = this.courses[i];
			}
		}
	}
}
```

- changeCourse() method will take course name as an input, fetches the course details, and assigns it to the course array.

> app.component.html (parent component)

```HTML
<h2> Popular Courses </h2>
Select a course to view
<select #course (change)="cl.changeCourse(course.value)">
	<option value="Node JS">Node JS</option>
	<option value="Typescript">Typescript</option>
	<option value="Angular">Angular</option>
	<option value="React JS">React JS</option>
</select>
<br/>
<app-courses-list #cl="courselist"></app-courses-list>
```

- A drop down will be displayed with course names. 
- When a course is selected, it invokes changeCourse() method of child component using the template variable 'cl'.
- It loads child component i.e., CoursesListComponent where the exported name courselist is bound to template variable called cl. 
- Now using cl, the properties and methods of child component i.e., CoursesListComponent can be accessed in the parent component template.


# Passing Data from parent to child component

- There are two ways to pass data from parent to child component in Angular.

1. Using @Input() decorator
    - In the child component, import the @Input() decorator from @angular/core.
    - Define a property in the child component with the @Input() decorator.
    - In the parent component, bind the value of the property to the child component's input property using property binding.

```HTML
<!-- app.component.html -->
<app-child [item1]="data"></app-child>
```

```TypeScript
// child.component.ts
import { Input } from '@angular/core';

export class ChildComponent {
  @Input() item1: string;
}
```

2. Using a shared service

# Passing Data from child to parent component

1. Using @Output() decorator
    - The only method for the child component to pass data to its parent component is through events. The property must be of type EventEmitter
    - In the child component, import the @Output() decorator from @angular/core.
    - Define a property in the child component with the @Output() decorator.
    - In the parent component, bind the function to the child component's input property.

```TypeScript
// child.component.ts
import { Output, EventEmitter } from '@angular/core';

export class ChildComponent {
  @Output() childFunction = new EventEmitter<string>();
}
```

```HTML
// child.component.html
<input type="text" #box>
<button (click)="childFunction.emit(box.value)"
```

```HTML
<!-- app.component.html -->
<app-child (childFunction)="parentFunction($data)"></app-child>
```

```TypeScript
<!-- app.component.ts -->
import { Component } from '@angular/core';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrl: './app.component.css',
})
export class AppComponent {
	parentFunction(data:string) {
		console.log(data);
	}
}
```


# @ViewChild Decorator

- ViewChild decorator helps in accessing properties/methods of a child component, directive, or DOM element.
- ViewChild decorator returns the first element or directive matching the selector from the DOM.
- ViewChild decorator creates an instance of a component/directive class in the parent component to access the properties or methods of that component/directive.

- Add the below code in **app.module.ts** for loading child and container components.
- Example:

```TypeScript
@NgModule({
	declarations: [
		AppComponent,
		TimerComponent
	],
	imports: [
		BrowserModule
	],
	  providers: [],
	  bootstrap: [AppComponent]
})

export class AppModule { }
```

- Add the following code to **timer.component.ts**

```TypeScript
import { Component } from '@angular/core';
@Component({
	selector: 'app-timer',
	templateUrl: './timer.component.html',
	styleUrls: ['./timer.component.css'],
})
export class TimerComponent {
	constructor() { }
	flag = false;
	count = 1;
	begin() {
		this.flag = true;
		const start = setInterval(() => {
			if (this.flag === false) {
				clearInterval(start);
			}
			this.count += 1;
		}, 1000);
	}
	end() {
		this.flag = false;
	}
}
```

- Now instantiate **timer.component.ts** in the parent component using ViewChild decorator.

```TypeScript
import { Component, ViewChild } from '@angular/core';
import { TimerComponent } from './timer/timer.component';
@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {
	@ViewChild(TimerComponent) timerComponent!: TimerComponent;
	startTimer() {
		this.timerComponent.begin();
	}
	stopTimer() {
		this.timerComponent.end();
	}
}
```

- @ViewChild decorator creates an instance of TimerComponent in AppComponent.
- AppComponent can now access the properties/methods of TimerComponent after loading the selector of TimerComponent in the template of AppComponent.
- Add the following code in **timer.component.html**

```TypeScript
<p>{{ count }}</p>
```

- Add the following code in **app.component.html**

```html
<h3>Accessing component using @ViewChild</h3>
<br />
<br />
Timer Example :
<button type="button" (click)="startTimer()">Begin</button>
<button type="button" (click)="stopTimer()">End</button>
<br />
<app-timer></app-timer>
```


**Accessing a directive using @ViewChild**

- @ViewChild creates an instance of a directive within a component and in this way the component can access the methods of the directive class.
- Add the following code in the **app.module.ts** file to load the root component and a custom directive.

```TypeScript

@NgModule({
	declarations: [
		AppComponent,ColorDirective
	],
	imports: [
		BrowserModule
	],
	providers: [],
	bootstrap: [AppComponent]
})
export class AppModule { }
```

- Add the below code in the **color.directive.ts** file.

```TypeScript
import { Directive, ElementRef, AfterViewInit } from '@angular/core';
@Directive({
	selector: '[appColor]'
})
export class ColorDirective implements AfterViewInit {
	constructor(private elementRef: ElementRef) { }
	ngAfterViewInit() {
		this.elementRef.nativeElement.style.color = 'green';
	}
	modify(color: string) {
		this.elementRef.nativeElement.style.color = color;
	}
}
```

- Line 10: AfterViewInit hook is used to execute statements after a component view is fully initialized.
- Now add the following code in the **app.component.ts** file and access the directive methods.

```TypeScript
import { Component, ViewChild } from '@angular/core';
import { ColorDirective } from './color.directive';
@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {
	@ViewChild(ColorDirective) colorDirective!: ColorDirective;
	modifyColor(color: string) {
		this.colorDirective.modify(color);
	}
}
```
    
- @ViewChild decorator creates an instance of a color directive in AppComponent.
- The methods of a color directive class can be now accessed from AppComponent.

**Accessing a native element using @ViewChild**

- A template reference variable can be accessed only in that template. If it's required to access it inside a component class, the @ViewChild decorator can be used.
- @ViewChild requires the template variable name to be passed as its argument and allows the component to change the appearance or behavior of a given template element.
- Observe the following code in **app.component.html**

```HTML
<h3>Accessing Template variable using @ViewChild</h3>
<div>
	Employee Name :
	<input type='text' \#empname>
	<br/> Employee Number :
	<input type='number' \#empnumber>
</div>
```

- There are two input boxes in the above template with 'empname' and 'empnumber' as their respective template reference variables.
- Add the below code to **app.component.ts** as shown below to access the native elements.
   
```TypeScript
import { Component, ViewChild, AfterViewInit, ElementRef } from '@angular/core';
...
export class AppComponent implements AfterViewInit {
  @ViewChild('empname') empName: ElementRef;
  @ViewChild('empnumber') empNumber: ElementRef;
  ngAfterViewInit() {
	this.empName.nativeElement.style.color = 'blue';
	this.empNumber.nativeElement.style.color = 'red';
  }
}
```

- The corresponding ElementRef needs to be instantiated using @ViewChild as shown above in the component to access the native element.
- AfterViewInit hook is used to execute statements after a component view is fully initialized.