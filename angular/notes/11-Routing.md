# Routing

- Angular routing is a mechanism that helps you navigate between different views of an Angular application.
- Angular routing uses the browser's URL to determine which view to display.

**Configuring Router**

- Angular uses Component Router to implement routing
- A `<base>` tag must be added to the head tag in the HTML page to tell the router where to start with.

```HTML
<base href="/">
```

- Angular component router belongs to `@angular/router` module. To make use of routing, Routes, `RouterModule` classes must be imported.
- Routes is an array that contains all the route configurations. Then, this array should be passed to the RouterModule.forRoot() function in the application bootstrapping function
- Example:

```TypeScript
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookComponent } from './book/book.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const appRoutes: Routes = [
	{ path: 'dashboard', component: DashboardComponent },
	{ path: '', redirectTo: '/dashboard', pathMatch: 'full' },
	{ path: 'books', component: BookComponent },
	{ path: 'detail/:id', component: BookDetailComponent },
	{ path: '**', component: PageNotFoundComponent },
];

@NgModule({
	imports: [
		RouterModule.forRoot(appRoutes)
	],
	exports: [
		RouterModule
	]
})

export class AppRoutingModule { }
```

- Imports Routes and RouterModule classes
- Configure the routes where each route should contain the path to navigate and the component class has to be invoked for a specific path.
- A route configuration must be provided for the default path i.e., path:'' and redirect it to the specific route using redirectTo option.
- pathMatch is required if redirectTo option is used which specifies how the given path should match. Here pathMatch: 'full' tells Router to match the given path completely. pathMatch has another value called 'prefix' where it checks if the path begins with the given prefix.
- The `path 'detail/:id'` has the route parameter id which will receive different values for the paramter 'id' based on the book selected, as part of the route itself.
- A route configuration must be provided for the wildcard route `'**'`. When users attempt to navigate to a route which may not be existing in your application, the application should be in a position to handle this gravefully. This can be done by configuring a wildcard route. The Angular router will automatically select this route when the requested URL doesn't match any of the other router paths.
- Pass the appRoutes array to forRoot method of RouterModule class to configure with the Router and add it to the imports property.

- Now configure the Router module with `NgModule` that `imports` in **app.module.ts** to make it available to the entire application.

```TypeScript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { AppRoutingModule } from './app-routing.module';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
@NgModule({
  imports: [BrowserModule, HttpClientModule, FormsModule, AppRoutingModule],
  declarations: [AppComponent, BookComponent, DashboardComponent, BookDetailComponent, PageNotFoundComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

- Add AppRoutingModule class to the imports property

- Once you have defined your routes, you need to add the `RouterOutlet` directive to your application's template. The `RouterOutlet` directive is a placeholder where the router will display the current view.
- Example:

```HTML
<router-outlet></router-outlet>
or
<router-outlet />
```

- After configuring the routes, the next step is to decide how to navigate. Navigation will happen based on user actions like clicking a hyperlink, clicking on a button, etc. Hence, there is hyperlink based navigation and programmatical navigation.

Hyperlink based navigation

- RouterLink directive can be used with the anchor tag for using hyperlink based navigation in Angular. Have a look at code shown below:

**app.component.html**

```HTML
<h1>{{title}}</h1>
<nav>
	<a [routerLink]='["/dashboard"]' routerLinkActive="active">Dashboard</a>
	<a [routerLink]='["/books"]' routerLinkActive="active">Books</a>
</nav>
<router-outlet></router-outlet>
```

```HTML
<a [routerLink]="['/path']">Link Text</a>
or
<a routerLink="['/path']">Link Text</a>
or
<a routerLink="path">Link Text</a>
```

- Create hyperlinks and a routerLink directive and specify the paths to navigate. Here, if a user clicks on the Dashboard, it will navigate to /dashboard.
- routerLinkActive applies the given CSS class to the link when it is clicked to make it look like an active link(active is a CSS class defined in app.component.css which changes the link color to blue in this case)
- `<router-outlet>` is the place where the output of the component associated with the given path will be displayed.
- For example, if the user click on Books, it will navigate to `/books` which will execute BooksComponent class as mentioned in the configuration details and the output will be displayed in the router-outlet class

Programmatical navigation

- To navigate programmatically, use the `navigate()` method of the Router class. Inject the router class into the component and invoke the navigate method as shown below.

```TypeScript
this.router.navigate([url, parameters])

Ex.
this.router.navigate(['/about']);
```

# Dynamic Routing

- Dynamic routing in Angular is a technique that allows developers to configure routes at runtime, rather than at compile time.
- To implement dynamic routing in Angular, you can use the Router service.
- The Router service provides a number of methods for configuring routes, including:
- `config()`: This method allows you to add or remove routes from the router configuration.
- `navigate()`: This method allows you to navigate to a specific route.
- `resetConfig()`: This method allows you to reset the router configuration to its initial state.
- Example:

```TypeScript
import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { CareerComponent } from './career/career.component';
import { UserComponent } from './user/user.component';

export const routes: Routes = [
  {
	path: '',
	redirectTo: 'home',
	pathMatch: 'full',
  },
  {
	path: 'user/:id',
	component: UserComponent,
  },
];
```

```HTML
<a [routerLink]="['/user', user.id]">

this.router.navigate(['/user', user.id]);
```

```TypeScript
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css',
})
export class UserComponent {
	
	// Import Router class from @angular/router module.
	// Inject into the component class through a constructor.
  constructor(public router:Router) { }

  // or

  constructor(private route: ActivatedRoute) {
	this.route.params.subscribe((params) => {
	  console.log(params['id']);
	});
  }

  ngOnInit() {
	console.log(this.route.snapshot.params['id']);
	console.log(this.route.snapshot.params['get']('id'));
  }
}
```


# **Route Guards**

- In the Angular application, users can navigate to any URL directly. That's not the right thing to do always.

- Consider the following scenarios
- Users must login first to access a component
- The user is not authorized to access a component
- User should fetch data before displaying a component
- Pending changes should be saved before leaving a component

- These scenarios must be handled through route guards. A guard’s return value controls the behavior of the router.
- If it returns true, the navigation process continues
- If it returns false, the navigation process stops

- Angular has canActivate interface which can be used to check if a user is logged in to access a component
- canActivate() method must be overridden in the guard class as shown below:
- Example:

```TypeScript
Class GuardService implements CanActivate{
  canActivate( ): boolean {
  }
}
```

- Example:

```TypeScript
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { LoginService } from './login.service';
@Injectable({
	providedIn: 'root'
})
export class LoginGuardService implements CanActivate {
	constructor(private loginService: LoginService, private router: Router) { }
	canActivate(): boolean {
		if (this.loginService.isUserLoggedIn()) {
			return true;
		}
		this.router.navigate(['/login']);
		return false;
	}
}
```


# **Asynchronous Routing**

- When an Angular application has a lot of components, it will increase the size of the application. In such cases, the application takes a lot of time to load.
- To overcome this problem, asynchronous routing is preferred, i.e, modules must be loaded lazily only when they are required instead of loading them at the beginning of the execution
- Lazy Loading has the following benefits:
- Modules are loaded only when the user requests for it
- Load time can be speeded up for users who will be visiting only certain areas of the application

**Lazy Loading Route Configuration**:

- To apply lazy loading on modules, create a separate routing configuration file for that module and map an empty path to the component of that module.
- Considering an example in the previous concept, consider BookComponent. To load it lazily, create the **book-routing.module.ts** file inside book folder and map an empty path to BookComponent(Line 8-10)

```TypeScript
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookComponent } from './book.component';
import { LoginGuardService } from '../login/login-guard.service';
const bookRoutes: Routes = [
	{
		path: '',
		component: BookComponent,
		canActivate: [LoginGuardService]
	}
];
@NgModule({
	imports: [RouterModule.forChild(bookRoutes)],
	exports: [RouterModule]
})
export class BookRoutingModule { }
```

- The lazy loading and re-configuration will happen only once, i.e.,  when the route is first requested. Module and routes will be available immediately for subsequent requests.
- Create a **book.module.ts** file inside book folder and add the following code:

```TypeScript
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookComponent } from './book.component';
import { BookRoutingModule } from './book-routing.module';
@NgModule({
  imports: [CommonModule, BookRoutingModule],
  declarations: [BookComponent]
})
export class BookModule { }
```

- In the root routing configuration file **app-routing.module**, bind 'book' path to the BookModule using **loadChildren** property as shown below

```TypeScript
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { BookComponent } from './book/book.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginGuardService } from './login/login-guard.service';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
const appRoutes: Routes = [
	{ path: '', redirectTo: '/login', pathMatch: 'full' },
	{ path: 'login', component: LoginComponent },
	{ path: 'books', loadChildren: () => import('./book/book.module').then(m => m.BookModule) },
	{ path: 'dashboard', component: DashboardComponent },
	{ path: 'detail/:id', component: BookDetailComponent } ,  
	{ path: '**', component: PageNotFoundComponent }
];
@NgModule({
	imports: [
		RouterModule.forRoot(appRoutes)
	],
	exports: [
		RouterModule
	]
})
export class AppRoutingModule { }
```

- Binds books path to BookModule using **loadChildren** property. From v8, Angular started making use of dynamic imports in lazy loading modules.
- **Note:** Remove BookComponent class from app.module.ts file
- Finally, it loads the requested route to the destination book component.

- Add the following code to the **app.module.ts** file

```TypeScript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { AppRoutingModule } from './app-routing.module';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  imports: [BrowserModule, HttpClientModule, ReactiveFormsModule, FormsModule, AppRoutingModule],
  declarations: [AppComponent, LoginComponent, DashboardComponent, BookDetailComponent, PageNotFoundComponent],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
```

# **Nested Routes**

- In Angular, you can also create sub-routes or child routes for your components which means in an application there will be one root route just like a root component/root module and other routes will be configured for their respective components.
- Configuring routes module-wise is the best practice to make modular Angular applications.

**Steps to create child routes using Angular:**

- Add below code to routing module **book-routing.module.ts** to implement child routing in the book module.

```TypeScript
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookComponent } from './book.component';
import { LoginGuardService } from '../login/login-guard.service';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { BookDetailComponent } from '../book-detail/book-detail.component';
const bookRoutes: Routes = [
	{
	  path: '',
	  component: BookComponent,
	  children: [
		{ path: 'dashboard', component: DashboardComponent },
		{ path: 'detail/:id', component: BookDetailComponent }
	  ],
	  canActivate: [LoginGuardService]
	}];
@NgModule({
	imports: [RouterModule.forChild(bookRoutes)],
	exports: [RouterModule]
})
export class BookRoutingModule { }
```

- Line 7-16: Child routes can be defined using children property of a route along with path & component properties.
- DashboardComponent, BookDetailComponent can be accessed using books/dashboard and books/detail/: id paths respectively.
- imports array contains the imported modules to use in the book module. forChild() method adds routing configurations to the book submodule instead of the root module.
- exports array contains classes that are exported from the current module.

- Import BookRoutingModule in the submodule **book.module.ts** as shown below :

```TypeScript
import { NgModule } from '@angular/core';
import { BookComponent } from './book.component';
import { BookRoutingModule } from './book-routing.module';
import { FormsModule } from '@angular/forms';
import { BookDetailComponent } from '../book-detail/book-detail.component';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { CommonModule } from '@angular/common';
@NgModule({
  imports: [ CommonModule, BookRoutingModule, FormsModule], 
  declarations: [BookComponent, BookDetailComponent, DashboardComponent]
})
export class BookModule { }
```

- Open **book.component.html** and add nested router outlet as shown below.

```HTML
<br/>
	<h2>MyBooks</h2>
	<ul class="books">
	  <li *ngFor="let book of books " (click)="gotoDetail(book)">
		<span class="badge">{{book.id}}</span> {{book.name}}
	  </li>
	</ul>
	<div>
	  <router-outlet></router-outlet>
	</div>
	<div class="error" *ngIf="errorMessage">{{errorMessage}}</div>
```

- Line 10: The nested router-outlet is used to render components of this submodule.
- DashboardComponent and BookDetailComponent can now be rendered inside Book.component.html. If this nested router-outlet is not added, child routes will be added to the parent router outlet of the application.

- Add the below code in **app.component.html** to add a link for accessing books.

```HTML
<h1>{{title}}</h1>
<nav>
	<a [routerLink]='["/books"]' routerLinkActive="active">Books</a>
	<a [routerLink]='["/books/dashboard"]' routerLinkActive="active">Dashboard</a>
</nav>
<router-outlet></router-outlet>
```

- Update **app-routing.module.ts** with below code:

```TypeScript
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
const appRoutes: Routes = [
	{ path: '', redirectTo: '/login', pathMatch: 'full' },
	{ path: 'login', component: LoginComponent },
	{ path: 'books', loadChildren: () => import('./book/book.module').then(m => m.BookModule) },
	{ path: '**', component: PageNotFoundComponent }
];
@NgModule({
	imports: [
		RouterModule.forRoot(appRoutes)
	],
	exports: [
		RouterModule
	]
})
export class AppRoutingModule { }
```

- Update app.module.ts as below:

```TypeScript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
@NgModule({
  imports: [BrowserModule, HttpClientModule,  ReactiveFormsModule, AppRoutingModule],
  declarations: [AppComponent, LoginComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

- Add gotoDetail() method in **book.component.ts** as below:

```TypeScript
...
 gotoDetail(book: Book): void {
	this.router.navigate(['/books/detail', book.id]);
  }
...
```

- Update dashboard.component.html

```HTML
<h3>Top Books</h3>
<div class="grid grid-pad">
  <div *ngFor="let book of books" (click)="gotoDetail(book)" class="col-1-4">
	<div class="module book">
	  <h4>{{ book.name }}</h4>
	</div>
  </div>
</div>
```

- Update dashboard.component.ts

```TypeScript
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book/book';
import { BookService } from '../book/book.service';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  books: Book[] = [];
  constructor(
	private router: Router,
	private bookService: BookService) { }
  ngOnInit(): void {
	this.bookService.getBooks()
	  .subscribe(books => this.books = books.slice(1, 5));
  }
  gotoDetail(book: Book): void {
	this.router.navigate(['/books/detail', book.id]);
  }
}
```