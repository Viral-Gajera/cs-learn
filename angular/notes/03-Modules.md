# Modules

- A module groups related components, directives, services, and other code into cohesive units.
- A module in Angular is a class with the `@NgModule` decorator added to it.
- @NgModule metadata will contain the declarations of components, pipes, directives, services that are to be used across the application.


- Every Angular application should have one root module which is loaded first to launch the application.
- Submodules should be configured in the root module.
- To register Submodules, import it to `app.module.ts` (root module) or corresponding parents and append it to `imports` array.
- Example:

> app.module.ts

```JavaScript 
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.compoent';
import { MyModule } from './my/my.module';

@NgModule({
	declarations: [
		AppComponent
	],
	imports: [
		BrowserModule,
		MyModule
	],
	providers: [],
	bootstrap: [AppComponent]
})
export class AppModule { }
```
   
- <u>Declarations</u> property should contain all user-defined components, directives, pipes classes to be used across the application. We have added our AppComponent class here.
- <u>Imports</u> property should contain all module classes to be used across the application.
- <u>Providers</u> property should contain all service classes.
- <u>Bootstrap</u> declaration should contain the root component to load. In this example, AppComponent is the root component that will be loaded in the HTML page.

> MyModule.module.ts

```JavaScript
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent }'./login/login.component';

@NgModule({
  declarations: [
	  LoginComponent
  ],
  imports: [
	CommonModule
  ],
  exports : [
	  LoginComponent
  ]
})
export class MyModuleModule { }
```
  

- In the provided Angular module code, the `exports` array within the `@NgModule` decorator is specifying which components, directives, or modules from the current module should be accessible for use in other modules when they import `MyModuleModule`.  


# **main.ts**

- In the **main.ts** file placed under the src folder, observe the following code.

```TypeScript
import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';
import { environment } from './environments/environment';
if (environment.production) {
  enableProdMode();
}
platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
```

- import <u>platformBrowserDynamic</u> class which is used to compile the application based on the browser platform
- import <u>AppModule</u> which is the root module to bootstrap.
- imports <u>environment</u> which is used to check whether the type of environment is production or development.
- <u>enableProdMode()</u> will enable production mode which will run the application faster.
- <u>bootstrapModule()</u> method accepts root module name as a parameter which will load the given module i.e., AppModule after compilation

  
# **index.html**

- index.html under the src folder.

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>MyApp</title>
  <base href="/">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
</head>
<body>
  <app-root></app-root>
</body>
</html>
```

- Line 11: loads the root component in the HTML page. 
- `app-root` is the selector name given to the component. This will execute the component and renders the template inside the browser.