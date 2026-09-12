# Forms

- Angular has two different approaches in dealing with forms: 
	- _reactive forms_ 
	- _template-driven forms_.
	
- Both reactive forms and template-driven forms:
	- Can capture user-provided data,
	- Can capture user input events,
	- Can validate the user input, etc.
	- Have their own approaches of processing and managing the form data:

In <u>template-driven</u> forms, you will create the form completely in the template and need to rely on directives to create and manipulate the underlying form object model. Since the template-driven forms do not scale that well, they are more suitable only when you want to add a simple small form to the application. For example: a signup form.

In <u>reactive forms</u>, you can control the form completely from the component class and hence you will get direct, explicit access to the underlying forms object model. Hence, reactive forms are also known as _'model-driven forms'_. As reactive forms are more robust and scalable, they are more suitable for creating all kind of forms in an application, irrespective of the size of form.


- Angular automatically tracks the changes happening to the form and form controls as and when user provides input and thereby controls the state and the validity of the form/form controls.
- Angular does this by associating respective keywords automatically for the forms/form controls depending on the context. The below table describes the details:

| **State detected for the form control** | **Context**                        | **Keyword associated by Angular**                                      |
| --------------------------------------- | ---------------------------------- | ---------------------------------------------------------------------- |
| valid                                   | Element value is valid             | valid. <br><br>The keyword becomes true if element is valid.           |
| invalid                                 | Element value is invalid           | invalid.  <br>  <br>The keyword becomes true if element is invalid     |
| dirty                                   | Element value is changed           | dirty.  <br>  <br>The keyword becomes true if element is dirty         |
| pristine                                | Element value is unchanged         | pristine.  <br>  <br>The keyword becomes true if element is pristine   |
| touched                                 | Element gets focus                 | touched.  <br>  <br>The keyword becomes true if element is touched     |
| untouched                               | Element doesn't have a focus in it | untouched.  <br>  <br>The keyword becomes true if element is untouched |

- Angular also has the following built-in CSS classes which get auto-applied depending on the state.
- Code can be written inside these CSS classes which can change the appearance of the control suitably as per context.

| **CSS Class** | **Purpose**                                         |
| ------------- | --------------------------------------------------- |
| ng-valid      | Applied if control's value is valid                 |
| ng-invalid    | Applied if control's value is invalid               |
| ng-dirty      | Applied if control's value is changed               |
| ng-pristine   | Applied if control's value is not changed           |
| ng-touched    | Applied if control is touched/gets focus            |
| ng-untouched  | Applied if control is not touched/doesn't get focus |


# **Reactive Forms**

**Following are the advantages of Reactive Forms/Model Driven Forms:**

- Unit testing(using the Jasmine framework) on the validation logic can be performed, as it is written inside the component class.
- Form changes or events can be heard easily using reactive forms. Each FormGroup or FormControl has few events like valueChanges, statusChanges, etc., which can be subscribed to.
- Reactive forms are used in creating medium to large scale applications

Step 1:

- To create a reactive form in Angular, **FormBuilder** class must be used.
- To make the FormBuilder class available, **ReactiveFormsModule** has to be imported in the root module.
- Register the ReactiveFormsModule during bootstrapping, in the **app.module.ts**

```TypeScript
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
@NgModule({
	declarations: [
		AppComponent,
		RegistrationFormComponent
	],
	imports: [
		BrowserModule,
		ReactiveFormsModule
	],
	providers: [],
	bootstrap: [AppComponent]
})
export class AppModule { }
```

Step 2:

- Create a component called **RegistrationForm** using the following CLI command

```Plain
ng generate component RegistrationForm
```

Step 3:

- Add the below to **app.component.html**

```Plain
<app-registration-form></app-registration-form>
```

Step 4:

- Bootstrap CSS framework (v3) is commonly used for adding basic structural layout and style for web applications. For structuring the RegistrationForm in this example, CSS classes from the Bootstrap CSS framework can be used.
- To add Bootstrap CSS library to the application, install **bootstrap** as shown below:

```Shell
npm install bootstrap@3.3.7 --save
```

- Then, include boostrap.min.css file in angular.json file as shown below:

```Shell
...
"styles": [
			  "src/styles.css",
			  "node_modules/bootstrap/dist/css/bootstrap.min.css"
],

"scripts": [
			  "node_modules/jquery/dist/jquery.min.js",
			  "node_modules/bootstrap/dist/js/bootstrap.min.js"
]
...
```

**Note:** When angular.json is modified, restart the server to see the changes reflected.

Step 5:

- Include the below code to **registration-form.component.css**

```CSS
.ng-valid[required]  {  
		border-left: 5px solid\#42A948; /* green */
}

.ng-invalid:not(form)  {  
		border-left: 5px solid\#a94442; /* red */
}
```

**Building Reactive Forms (Angular v13)**

- Add the following code in the **registration-form.component.ts** file

```TypeScript
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
	selector: 'app-registration-form',
	templateUrl: './registration-form.component.html',
	styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {
	registerForm!: FormGroup;
	submitted!:boolean;
	
	constructor(private formBuilder: FormBuilder) { }
	ngOnInit() {
	this.registerForm = this.formBuilder.group({
		firstName: ['', Validators.required],
		lastName: ['', [Validators.required, Validators.maxlength(10)]],
		address: this.formBuilder.group({
			street: [],
			zip: [],
			city: []
		})
	});
}
```

- Inject a FormBuilder instance using constructor.
- formBuilder.group() method creates a FormGroup. It takes an object whose keys are FormControl names and values are their definitions
- Create form controls such as firstName, lastName, and address as a subgroup with fields street, zip, and city. These fields are form controls.

- For each form control:

- you can mention the default value as the first argument and
- the list of validators as the second argument:
- Validations can be added to the form controls using the built-in validators supplied by the Validators class.
- For example: Configure built-in required validator for each control using [' ', Validators.required] syntax.
- If multiple validators are to be applied, then use the syntax [' ', [Validators.required, Validators.maxlength(10)]].

**registration-form.component.html**

```HTML
<div class="container">
<h1>Registration Form</h1>
<form [formGroup]="registerForm">
	<div class="form-group">
		<label>First Name</label>
		<input
			type="text"
			class="form-control"
			formControlName="firstName"
		/>
		<div
			*ngIf="registerForm.controls['firstName'].errors"
			class="alert alert-danger"
>
			Firstname field is invalid.
			<p
				*ngIf="registerForm.controls['firstName'].errors?.['required']"
>
				This field is required!
			</p>
		</div>
	</div>
	<div class="form-group">
		<label>Last Name</label>
		<input
			type="text"
			class="form-control"
			formControlName="lastName"
		/>
		<div
			*ngIf="registerForm.controls['lastName'].errors"
			class="alert alert-danger"
>
			Lastname field is invalid.
			<p
				*ngIf="registerForm.controls['lastName'].errors?.['required']"
>
				This field is required!
			</p>
		</div>
	</div>
	<div class="form-group">
		<fieldset formGroupName="address">
			<legend>Address:</legend>
			<label>Street</label>
			<input
				type="text"
				class="form-control"
				formControlName="street"
			/>
			<label>Zip</label>
			<input 
									type="text" 
									class="form-control" 
									formControlName="zip" 
							/>
			<label>City</label>
			<input
				type="text"
				class="form-control"
				formControlName="city"
			/>
		</fieldset>
	</div>
	<button type="submit" class="btn btn-primary" (click)="submitted=true">
		Submit
	</button>
</form>
<br />
<div [hidden]="!submitted">
	<h3>Employee Details</h3>
	<p>First Name: {{ registerForm.get('firstName')?.value }}</p>
	<p>Last Name: {{ registerForm.get('lastName')?.value }}</p>
	<p>Street: {{ registerForm.get('address.street')?.value }}</p>
	<p>Zip: {{ registerForm.get('address.zip')?.value }}</p>
	<p>City: {{ registerForm.get('address.city')?.value }}</p>
</div>
</div>
```

- formGroup is a directive that binds HTML form with the FormGroup property created inside a component class.
- A FormGroup has been created in component with the name registerForm. Here form tag is bound with FormGroup name called registerForm

## **updateOn Option**

- Angular runs the control validation process whenever a form control value changes. For example, if you have an input bounded to a form control, Angular runs the control validation for every keystroke.
- A form with heavy validation requirements, updating on every keystroke can sometimes be too expensive.
- Angular provides a new option that improves performance by delaying form control updates until _blur_ or _submit_ event.
- The possible values for updateOn are:
	
	1) change: Default. The value updates on every change.
	2) blur: The value updates once the form lost its focus.
	3) submit: The value updates once the form is submitted.

- These validations can be used on both types of forms at the input level or at the form level using updateOn property.

In reactive form demo, modify **registration-form.component.ts** as shown below

```TypeScript
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
	selector: 'app-registration-form',
	templateUrl: './registration-form.component.html',
	styleUrls: ['./registration-form.component.css']
})

export class RegistrationFormComponent implements OnInit {
	registerForm!: FormGroup;
	submitted!:boolean;
	
	constructor(private formBuilder: FormBuilder) { }
	ngOnInit() {
	this.registerForm = this.formBuilder.group({
		firstName: ['', { updateOn: 'blur', validators: [Validators.required] }],
		lastName: ['', Validators.required],
		address: this.formBuilder.group({
			street: [],
			zip: [],
			city: []
		})
	});
	}
}
```


## **Custom Validators in Reactive Forms**

- While creating forms, there can be situations for which built-in validators are not available.
- Few such examples include validating a phone number, validating if the password and confirm password fields matches or not, etc..
- In such situations, custom validators can be created to implement the required validation functionality.

Custom validation in Reactive Forms of Angular:

- Custom validation can be applied to form controls of a Reactive Form in Angular.
- Custom validators are implemented as separate functions inside the component.ts file.
- these functions can be added to the list of other validators configured for a form control.

Implementing custom validation in Reactive Forms of Angular:

- Add one more field called email inside the example used for ReactiveForms previously. The below are the validations to be applied to the 'email' field:
- required,
- checks for standard email pattern, for example: abc@something.com, abc@something.co.in, etc.
- For implementing the for custom validation, add a separate function which checks for standard email pattern inside **registration-form.component.ts** as shown below:

```TypeScript
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
	selector: 'app-registration-form',
	templateUrl: './registration-form.component.html',
	styleUrls: ['./registration-form.component.css']
})

export class RegistrationFormComponent implements OnInit {
	registerForm!: FormGroup;
	submitted!:boolean;
	
	constructor(private formBuilder: FormBuilder) { }
	
	ngOnInit() {
	this.registerForm = this.formBuilder.group({
		firstName: ['', Validators.required],
		lastName: ['', Validators.required],
		address: this.formBuilder.group({
			street: [],
			zip: [],
			city: []
		}),
		email: ['', validateEmail]
	});
	}
}

function validateEmail(c: FormControl): any {
  let EMAIL_REGEXP = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
  return EMAIL_REGEXP.test(c.value) ? null : {
	emailInvalid: {
	  message: "Invalid Format!"
	}
  };
}
```

- In this function, a regular expression pattern is taken for email and the input value of the form control is tested against the mentioned pattern.
- If the pattern matches, it means the entered input is valid and hence, the validation function returns `null`. Otherwise, the function returns an object with name 'emailInvalid' with one property called 'message' set to appropriate string message.
- Binds the required validator and the custom validator named validateEmail to the email field.



# **Template Driven Forms**

- Template-driven forms are the forms that are created using Angular template syntax. In template-driven form, data binding, validation, etc., will be written in the template itself.
- Let us create a template-driven form as shown below:
- **Example**:

To begin with, we need to register the new forms module during bootstrapping

```TypeScript
...
import { FormsModule } from '@angular/forms';
@NgModule({
  ...
  imports: [
	BrowserModule,
	FormsModule
  ],
  ...
})
export class AppModule { }
```

- Import FormsModule from @angular/forms module
- Add FormsModule in the imports property to make it available to the entire module

- Now, create a component called CourseFormComponent using the following command

```TypeScript
ng generate component courseForm
```

  
- Create **course.ts** file under the course-form folder and add the following code

```TypeScript
export class Course {
  constructor(
	public courseId: number,
	public courseName: string,
	public duration: string
  ) { }
}
```

  
- Create a model class called Course with properties courseId, courseName, and duration
- Add the following code in the **course-form.component.ts** file

```TypeScript
import { Component } from '@angular/core';
import { Course } from './course';
@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.css']
})
export class CourseFormComponent {
  course = new Course(1, 'Angular', '5 days');
  submitted = false;
  onSubmit() { this.submitted = true; }
}
```


- Line 2: Imports Course Model class from course.ts file
- Line 11: Creates an instance of course model by giving some default values to its constructor
- Line 12: Creates a submitted property and initializes it as false. This property is used to show and hide the form based on the submission
- Line 14: onSubmit() method is invoked on submit button click which initializes submitted property to true
- Bootstrap classes such as container, form-group, form-control, etc., are used in this demo. For this, you have to install **bootstrap** as shown below:

```TypeScript
D:\MyApp>npm install bootstrap@3.3.7 --save
```

  
- Include boostrap.min.css file in **angular.json** file as shown below:

```TypeScript
...
"styles": [
		"styles.css",
		"./node_modules/bootstrap/dist/css/bootstrap.min.css"
	  ],
...
```


- **Note:** Whenever angular.json is modified, restart the server to reflect the changes.
- Terminate the server and start again to get Angular-CLI changes reflected on the page.
- **course-form.component.html** … (1)

```HTML
<div class="container">
  <div [hidden]="submitted">
	<h1>Course Form</h1>
	<form (ngSubmit)="onSubmit()" \#courseForm="ngForm">
	  <div class="form-group">
		<label for="id">Course Id</label>
		<input type="text" class="form-control" required [(ngModel)]="course.courseId" name="id" \#id="ngModel">
		<div [hidden]="id.valid || id.pristine" class="alert alert-danger">
		  Course Id is required
		</div>
	  </div>
...
```

  

- Line 3: Entire form will be shown or hidden based on the value of a submitted property. If the value is false, the form will be shown otherwise it is hidden.
- Line 5: The 'submit' event is bound with onSubmit() method which is invoked when a form is submitted. courseForm is a template variable of form bound with ngForm. The variable courseForm is now a reference to the ngForm directive.
- Line 9: A text box for Course ID with two-way data binding enabled using [(ngModel)]. [(ngModel)] binds the textbox with model class property courseId where any change happens will be reflected in the model as well as the view. \#id is the template reference variable for textbox bound to ngModel to link it with the model value.
- Line 10-12: A validation error message is displayed when the required validation fails.

Now let us understand ngForm class.

ngForm:

- is a built-in directive that will have an instance of each form element created in the application
- has its own features which will get added to the form element on the page
- must have the name attribute as it is mandatory when [(ngModel)] is used on form elements
- input element is an instance of FormControl class which gets registered with the name attribute value
- ngModel is used to track the state and validity of an element using the following keywords

| **Keyword** | **Purpose**                                    |
| ----------- | ---------------------------------------------- |
| valid       | true if element value is valid                 |
| invalid     | true if element value is invalid               |
| dirty       | true if element value is changed               |
| pristine    | true if element value is unchanged             |
| touched     | true if the element gets focus                 |
| untouched   | true if the element doesn't have a focus in it |

- Angular also has the following built-in CSS classes to change the appearance of the control based on its state

| **CSS Class** | **Purpose**                                         |
| ------------- | --------------------------------------------------- |
| ng-valid      | Applied if control's value is valid                 |
| ng-invalid    | Applied if control's value is invalid               |
| ng-dirty      | Applied if control's value is changed               |
| ng-pristine   | Applied if control's value is not changed           |
| ng-touched    | Applied if control is touched/gets focus            |
| ng-untouched  | Applied if control is not touched/doesn't get focus |

- Now add the following code in **course-form.component.html** … (2)

```HTML
<div class="container">
  <div [hidden]="submitted">
	<h1>Course Form</h1>
	<form (ngSubmit)="onSubmit()" \#courseForm="ngForm">
	  <div class="form-group">
		<label for="id">Course Id</label>
		<input type="text" class="form-control" required [(ngModel)]="course.courseId" name="id" \#id="ngModel">
		<div [hidden]="id.valid || id.pristine" class="alert alert-danger">
		  Course Id is required
		</div>
	  </div>
	  <div class="form-group">
		<label for="name">Course Name</label>
		<input type="text" class="form-control" required [(ngModel)]="course.courseName" name="name" \#name="ngModel">
		<div [hidden]="name.valid || name.pristine" class="alert alert-danger">
		  Course Name is required
		</div>
	  </div>
	  <div class="form-group">
		<label for="duration">Course Duration</label>
		<input type="text" class="form-control" required [(ngModel)]="course.duration" name="duration" \#duration="ngModel">
		<div [hidden]="duration.valid || duration.pristine" class="alert alert-danger">
		  Duration is required
		</div>
	  </div>
	  <button type="submit" class="btn btn-default" [disabled]="!courseForm.form.valid">Submit</button>
	  <button type="button" class="btn btn-default" (click)="courseForm.reset()">New Course</button>
	</form>
  </div>
  <div [hidden]="!submitted">
	<h2>You submitted the following:</h2>
	<div class="row">
	  <div class="col-xs-3">Course ID</div>
	  <div class="col-xs-9  pull-left">{{ course.courseId }}</div>
	</div>
	<div class="row">
	  <div class="col-xs-3">Course Name</div>
	  <div class="col-xs-9 pull-left">{{ course.courseName }}</div>
	</div>
	<div class="row">
	  <div class="col-xs-3">Duration</div>
	  <div class="col-xs-9 pull-left">{{ course.duration }}</div>
	</div>
	<br>
	<button class="btn btn-default" (click)="submitted=false">Edit</button>
  </div>
</div>
```


- Line 15-21: a Label and text box for the Course Name field and corresponding validation error message
- Line 23-29: A label and the text box for Course Duration and its corresponding validation error message
- Line 31: Form validity is bound with the disabled property which means that the button will be disabled if a form is not valid
- Line 32: reset() method of the form will reset the form to enter new values
- Line 36: div tag will be displayed when submitted property is set to false
- Line 40, 44,48: Displays the course properties
- Line 51: Edit button when clicked sets submitted property to false where the above code is hidden and form div is shown on the screen

**course-form.component.css**

```CSS
input.ng-valid[required]  {
border-left: 5px solid \#42A948; /* green */
}
input.ng-dirty.ng-invalid:not(form)  {
border-left: 5px solid \#a94442; /* red */
}
```

- Line 1-3: ng-valid CSS class changes left border of textboxes to green if each form control’s required validation is successful
- Line 5-7: ng-invalid CSS class changes left border of textboxes to red if each form control’s required validation fails

**app.component.html**

```CSS
<app-course-form></app-course-form>
```

- Loads CourseFormComponent in the root component

![[template_driven_form_demo1.png]]

![[template_driven_form_demooutput.png]]


**Advantages of Template Driven Forms**

1. Simplicity: As the entire code is used for data binding and validation in a form template, it is simple to code and very useful to build small to medium-sized forms
2. Template-driven forms is preferred to create small to medium-sized forms


**Disadvantages of Template Driven Forms**

1. As the tags or complex validations increase in the template, the readability of the form decreases
2. We cannot perform unit testing on form validation logic. The only way to test is to run end to end test with a browser

## **updateOn Option**

- Angular runs the control validation process whenever a form control value changes. For example, if there is an input bounded to a form control, Angular runs the control validation for every keystroke.
- A form with heavy validation requirements, updating on every keystroke can sometimes be too expensive.
- Angular provides a new option that improves performance by delaying form control updates until _blur_ or _submit_ event.
- The possible values for updateOn are:
	
	1) change: Default. The value updates on every change.
	2) blur: The value updates once the form lost its focus.
	3) submit: The value updates once the form is submitted.

- These validations can be used on both types of forms at the input level or at the form level using updateOn property.

In template-driven form demo, modify the code in **course-form.component.html** as shown below

```HTML
<div class="container">
<div [hidden]="submitted">
<h1>Course Form</h1>
<form (ngSubmit)="onSubmit()" \#courseForm="ngForm">
  <div class="form-group">
	<label for="id">Course Id</label>
	<input type="text" class="form-control" required [(ngModel)]="course.courseId"
	   [ngModelOptions]="{ updateOn: 'blur' }" name="id" \#id="ngModel">
	<div [hidden]="id.valid || id.pristine" class="alert alert-danger">
	  Course Id is required
	</div>
  </div>
  <div class="form-group">
	<label for="name">Course Name</label>
	<input type="text" class="form-control" required [(ngModel)]="course.courseName"
	   [ngModelOptions]="{ updateOn: 'submit' }" name="name" \#name="ngModel">
	<div [hidden]="name.valid || name.pristine" class="alert alert-danger">
	  Course Name is required
	</div>
  </div>
  <div class="form-group">
	<label for="duration">Course Duration</label>
	<input type="text" class="form-control" required [(ngModel)]="course.duration" name="duration" \#duration="ngModel">
	<div [hidden]="duration.valid || duration.pristine" class="alert alert-danger">
	  Duration is required
	</div>
  </div>
  <button type="submit" class="btn btn-default" [disabled]="!courseForm.form.valid">Submit</button>
  <button type="button" class="btn btn-default" (click)="courseForm.reset()">New Course</button>
</form>
</div>
<div [hidden]="!submitted">
<h2>You submitted the following:</h2>
<div class="row">
  <div class="col-xs-3">Course ID</div>
  <div class="col-xs-9  pull-left">{{ course.courseId }}</div>
</div>
<div class="row">
  <div class="col-xs-3">Course Name</div>
  <div class="col-xs-9 pull-left">{{ course.courseName }}</div>
</div>
<div class="row">
  <div class="col-xs-3">Duration</div>
  <div class="col-xs-9 pull-left">{{ course.duration }}</div>
</div>
<br>
<button class="btn btn-default" (click)="submitted=false">Edit</button>
</div>
<br/>
<div>Course Id updates on blur: {{course.courseId}}</div>
<div>Course Name updates on submit: {{course.courseName}}</div>
</div>
```

- Line 9 & 18: `ngModelOptions` token in the input tag is used to update the form validation at the input level.

- The updateOn option can be applied at the form level.
- In template-driven form demo, modify **course-form.component.html** as shown below

```HTML
<div class="container">
  <div [hidden]="submitted">
	<h1>Course Form</h1>
	<form (ngSubmit)="onSubmit()" \#courseForm="ngForm" 
					[ngFormOptions]="{ updateOn: 'submit' }"
>
	  <div class="form-group">
		<label for="id">Course Id</label>
		<input type="text" class="form-control" required [(ngModel)]="course.courseId" name="id" \#id="ngModel">
		<div [hidden]="id.valid || id.pristine" class="alert alert-danger">
		  Course Id is required
		</div>
	  </div>
	  <div class="form-group">
		<label for="name">Course Name</label>
		<input type="text" class="form-control" required [(ngModel)]="course.courseName" name="name" \#name="ngModel">
		<div [hidden]="name.valid || name.pristine" class="alert alert-danger">
		  Course Name is required
		</div>
	  </div>
	  <div class="form-group">
		<label for="duration">Course Duration</label>
		<input type="text" class="form-control" required [(ngModel)]="course.duration" name="duration" \#duration="ngModel">
		<div [hidden]="duration.valid || duration.pristine" class="alert alert-danger">
		  Duration is required
		</div>
	  </div>
	  <button type="submit" class="btn btn-default" [disabled]="!courseForm.form.valid">Submit</button>
	  <button type="button" class="btn btn-default" (click)="courseForm.reset()">New Course</button>
	</form>
  </div>
  <div [hidden]="!submitted">
	<h2>You submitted the following:</h2>
	<div class="row">
	  <div class="col-xs-3">Course ID</div>
	  <div class="col-xs-9  pull-left">{{ course.courseId }}</div>
	</div>
	<div class="row">
	  <div class="col-xs-3">Course Name</div>
	  <div class="col-xs-9 pull-left">{{ course.courseName }}</div>
	</div>
	<div class="row">
	  <div class="col-xs-3">Duration</div>
	  <div class="col-xs-9 pull-left">{{ course.duration }}</div>
	</div>
	<br>
	<button class="btn btn-default" (click)="submitted=false">Edit</button>
  </div>
</div>
```

- ngFormOptions token in the Form Tag Is used to update the form Validations at the form level

## **Custom Validators in Template Driven forms**

- While creating forms, there can be situations for validations for which built-in validators are not available.
- Few such examples include validating a phone number, validating if the password and confirm password fields matches or not, etc., In such situations, we can create custom validators to implement the required functionality.
- Let us see how to create a custom validator for template-driven forms.
- **Problem** **Statement**: To create a custom validator for checking email patterns. Though there is built-in validator available for an email in Angular, custom validator must be created as the built-in email validator will not check for the complete pattern needed.
- For template-driven forms, validation keyword must be added as an attribute to the control. Therefore, a directive for custom validation logic must be created. The same example will be used for template-driven forms.

- In **course.ts**, add another field for email as shown below at Line 6.

```TypeScript
export class Course {
  constructor(
	public courseId: number,
	public courseName: string,
	public duration: string,
	public email: string
  ) { }
}
```

- In the **course-form.component.ts** file, pass a default value to the email field as shown below at Line 11

```TypeScript
import { Component } from '@angular/core';
import { Course } from './course';
@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.css']
})
export class CourseFormComponent {
  course: Course = new Course(1, 'Angular', '5 days','james@gmail.com');
  submitted = false;
  onSubmit() { this.submitted = true; }
}
```

- Create a file with the name **email.validator.ts** under the course-form folder to implement custom validation functionality for the email field

```TypeScript
import { Directive } from '@angular/core';
import { NG_VALIDATORS, FormControl, Validator } from '@angular/forms';
@Directive({
  selector: '[validateEmail]',
  providers: [
	{ provide: NG_VALIDATORS, useExisting: EmailValidator, multi: true },
  ],
})
export class EmailValidator implements Validator {
  validate(control: FormControl): any {
	const emailRegexp =
	  /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
	if (!emailRegexp.test(control.value)) {
	  return { emailInvalid: 'Email is invalid' };
	}
	return null;
  }
}
```
  
- Line 2: Import NG_VALIDATORS which is a provider with an extensive collection of validators
- Line 7: Register EmailValidator directive with NG_VALIDATORS so that Angular recognizes the role of the directive in the validation process. multi:true adds EmailValidator class to the existing list of validators available in NG_VALIDATORS
- Line 10: Inherit Validator interface
- Line 11: Override validate() method which takes FormControl as a parameter and returns an object
- Line 12-18: Defines email pattern and test whether the value entered matches with the given pattern or not. If it doesn't match it returns an object with key as 'emailInvalid' and value as some error message, otherwise returns null

- Add EmailValidator class in the root module i.e., **app.module.ts** as shown below at Line7 and 13

```TypeScript
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { CourseFormComponent } from './course-form/course-form.component';
import { EmailValidator } from './course-form/email.validator';
@NgModule({
  declarations: [
	AppComponent,
	CourseFormComponent,
	EmailValidator
  ],
  imports: [
	BrowserModule,
	FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```  

- Add the following code in the **course-form.component.html** file for the email field as shown below

```HTML
<div class="container">
  <div [hidden]="submitted">
	<h1>Course Form</h1>
	<form (ngSubmit)="onSubmit()" \#courseForm="ngForm">
	  <div class="form-group">
		<label for="id">Course Id</label>
		<input type="text" class="form-control" required [(ngModel)]="course.courseId" name="id" \#id="ngModel" />
		<div [hidden]="id.valid || id.pristine" class="alert alert-danger">
		  Course Id is required
		</div>
	  </div>
	  <div class="form-group">
		<label for="name">Course Name</label>
		<input type="text" class="form-control" required [(ngModel)]="course.courseName" minlength="4" name="name"
		  \#name="ngModel" />
		<div *ngIf="name.errors && (name.dirty || name.touched)" class="alert alert-danger">
		  <div [hidden]="!name.errors.required">Name is required</div>
		  <div [hidden]="!name.errors.minlength">
			Name must be at least 4 characters long.
		  </div>
		</div>
	  </div>
	  <div class="form-group">
		<label for="duration">Course Duration</label>
		<input type="text" class="form-control" required [(ngModel)]="course.duration" name="duration"
		  \#duration="ngModel" />
		<div [hidden]="duration.valid || duration.pristine" class="alert alert-danger">
		  Duration is required
		</div>
	  </div>
	  <div class="form-group">
		<label for="email">Author Email</label>
		<input type="text" class="form-control" required [(ngModel)]="course.eMail" name="email" \#email="ngModel"
		  validateEmail />
		<div *ngIf="email.errors && (email.dirty || email.touched)" class="alert alert-danger">
		  <div [hidden]="!email.errors.required">Email is required</div>
		  <div [hidden]="!email.errors.emailInvalid">
			{{ email.errors.emailInvalid }}
		  </div>
		</div>
	  </div>
	  <button type="submit" class="btn btn-primary" [disabled]="!courseForm.form.valid">
		Submit
	  </button>
	  <button type="button" class="btn btn-link" (click)="courseForm.reset()">
		Reset
	  </button>
	</form>
  </div>
  <div [hidden]="!submitted">
	<h2>You submitted the following:</h2>
	<div class="row">
	  <div class="col-3">Course ID</div>
	  <div class="col-9 pull-left">{{ course.courseId }}</div>
	</div>
	<div class="row">
	  <div class="col-3">Course Name</div>
	  <div class="col-9 pull-left">{{ course.courseName }}</div>
	</div>
	<div class="row">
	  <div class="col-3">Duration</div>
	  <div class="col-9 pull-left">{{ course.duration }}</div>
	</div>
	<div class="row">
	  <div class="col-3">Email</div>
	  <div class="col-9 pull-left">{{ course.eMail }}</div>
	</div>
	<br />
	<button class="btn btn-primary" (click)="submitted = false">Edit</button>
  </div>
</div>
```

- Line 34: Add `validateEmail` directive as an attribute in the email text field
- Line 37: Displays an error message for the email field if it is not valid. The key 'emailInvalid' is used in this case to check for the email errors.