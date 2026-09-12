# Dependency Injection

- Dependency Injection (DI) is a mechanism where the required resources will be injected into the code automatically.

**Why Dependency Injection?**

- It is because DI:
- allows developers to reuse the code across applications.
- makes the code loosely coupled.
- makes application development and testing much easier.
- allows the developer to ask for the dependencies from Angular. There is no need for the developer to explicitly create/instantiate them.

# Service

- A service in Angular is a class that contains some functionality that can be reused across the application.
- A service is a singleton object. Angular services are a mechanism of abstracting shared code and functionality throughout the application.
- Angular Services come as objects which are wired together using dependency injection.
- Angular provides a few inbuilt services also can create custom services.


**Why Services?**

Services can be used to:
- share the code across components of an application.
- make HTTP requests.  

**Creating a Service**

To create a service class, use the following command:

```Plain
ng generate service book
```

The above command will create a service class as shown below:

```TypeScript
import { Injectable } from '@angular/core';

@Injectable({
providedIn: "root" 
})
export class BookService {}
```

- @Injectable() decorator makes the class injectable into application components.


**Providing a Service**

- Following are the ways to provide services in an Angular application:

1. The first way to register service is to specify providedIn property using @Injectable decorator. This property is added by default when you generate a service using Angular CLI.

```TypeScript
import { Injectable } from "@angular/core";
@Injectable({ providedIn: "root" })
export class BookService {}
```

- providedIn property registers BookService at the root level (app module).
- When the BookService is provided at the root level, Angular creates a singleton instance of the service class and injects the same instance into any class that uses this service class.
- In addition, Angular also optimizes the application if registered through providedIn property by removing the service class if none of the components use it.

2. Services can also be provided across the application by registering it using the providers property in the @Ngmodule decorator of any module.

```TypeScript
@NgModule({
   imports: [BrowserModule],
   declarations: [AppComponent, BookComponent],
   providers: [BookService],
   bootstrap: [AppComponent]
})
```

- Line 4: When the service class is added in the providers property of the root module, all the directives and components will have access to the same instance of the service.

3. There is also a way to limit the scope of the service class by registering it in the providers' property inside the @Component decorator.

- Providers in component decorator and module decorator are independent.
- Providing a service class inside a component creates a separate instance for that component and its nested components.

```TypeScript
import { BookService } from './book/book.service';
@Component({
   selector: 'app-root',
   styleUrls: ['./app.component.css'],
   templateUrl: './app.component.html',
   providers:[BookService]
})
```

**Injecting a Service**

- The only way to inject a service into a component/directive or any other class is through a constructor.
- Add a constructor in a component class with service class as an argument as shown below:

```TypeScript
constructor(private bookService: BookService){ }
```

- BookService will then be injected into the component through constructor injection by the framework.

Example:

**Problem Statement**: Create a Book Component which fetches book details like id, name and displays them on the page in a list format. Store the book details in an array and fetch the data using a custom service.

- Create **BookComponent** by using the following CLI command.
- Create a service called **BookService** under the book folder using the following CLI command

```Shell
ng generate component book
ng generate service book
```

![[day5_03.png]]


**book.service.ts**

```Shell
import { Injectable } from '@angular/core';
import { Book } from './book';
import { BOOKS } from './books-data';

var BOOKS: [{
	id: number;
	name: string;
}] = [
{ "id": 1, "name": "HTML 5" },
{ "id": 2, "name": "CSS 3" },
{ "id": 3, "name": "Java Script" },
{ "id": 4, "name": "Ajax Programming" },
{ "id": 5, "name": "jQuery" },
{ "id": 6, "name": "Mastering Node.js" },
{ "id": 7, "name": "Angular JS 1.x" },
{ "id": 8, "name": "ng-book 2" },
{ "id": 9, "name": "Backbone JS" },
{ "id": 10, "name": "Yeoman" }
]

@Injectable({
	providedIn:'root'
})
export class BookService {
	getBooks() {
		return BOOKS;
	}
}
```

- @Injectable() decorator makes the class as a service which can be injected into components of an application
- getBooks() method returns Books data.

**book.component.ts**

```TypeScript
...
import { BookService } from './book.service';
import { Book } from './book';
...

export class BookComponent implements OnInit {
	books!: any;
	constructor(private bookService: BookService) { }
	getBooks() {
		this.books = this.bookService.getBooks();
	}
	ngOnInit() {
		this.getBooks();
	}
}
```

**book.component.html**

```HTML
<h2>My Books</h2>
<ul class="books">
	<li *ngFor="let book of books">
		<span class="badge">{{book.id}}</span> {{book.name}}
	</li>
</ul>
```


# RxJS

- Reactive Extensions for JavaScript (RxJS) is a third-party library used by the Angular team.
- RxJS is a reactive streams library used to work with asynchronous streams of data.
- Observables, in RxJS, are used to represent asynchronous streams of data.
- Observables are a more advanced version of Promises in JavaScript

**Why RxJS Observables?**

- Angular team has recommended Observables for asynchronous calls because of the following reasons:

1. Promises emit a single value whereas observables (streams) emit many values
2. Observables can be cancellable where Promises are not cancellable. If an HTTP response is not required, observables allow us to cancel the subscription whereas promises execute either success or failure callback even if the results are not required.
3. Observables support functional operators such as map, filter, reduce, etc.,

Create and use an observable in Angular

**Example**:

- **app.component.ts**

```TypeScript
import { Component } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
	selector: 'app-root',
	styleUrls: ['./app.component.css'],
	templateUrl: './app.component.html'
})
export class AppComponent {
	data!: Observable<number>;
	myArray: number[] = [];
	errors!: boolean;
	finished!: boolean;
	
	fetchData(): void {
		this.data = new Observable(observer => {
			setTimeout(() => { observer.next(11); }, 1000),
			setTimeout(() => { observer.next(22); }, 2000),
			setTimeout(() => { observer.complete(); }, 3000);
		});
		this.data.subscribe(
			(value) => this.myArray.push(value),
			(error) => this.errors = true,
			() => this.finished = true);
		}
	}
}
```

- Line 11: data is of type Observable which holds numeric values
- Line 16: fetchData() is invoked on click of a button
- Line 17: A new Observable is created and stored in the variable data
- Line 18-20: next() method of Observable sends the given data through the stream. With a delay of 1,2 and 3 seconds, a stream of numeric values will be sent. 
- Complete() method completes the Observable stream i.e., closes the stream.

- Line 22: Observable has another method called subscribe which listens to the data coming through the stream. 
- Subscribe() method has three parameters. 
	- The first parameter is a success callback which will be invoked upon receiving successful data from the stream. 
	- The second parameter is an error callback which will be invoked when Observable returns an error 
	- And the third parameter is a complete callback which will be invoked upon successful streaming of values from Observable i.e., once complete() is invoked.
	
- After which the successful response, the data is pushed to the local array called myArray, 
- If any error occurs, a Boolean value called true is stored in the errors variable 
- And upon complete() will assign a Boolean value true in a finished variable.

- **app.component.html**

```HTML
<b> Using Observables!</b>
<h6 style="margin-bottom: 0">VALUES:</h6>
<div *ngFor="let value of myArray">{{ value }}</div>
<div style="margin-bottom: 0">ERRORS: {{ errors }}</div>
<div style="margin-bottom: 0">FINISHED: {{ finished }}</div>
<button style="margin-top: 2rem" (click)="fetchData()">Fetch Data</button>
```

![[13.gif]]

  
# Server Communication using HttpClient

- **HttpClient** from @angular/common/http to communicate must be used with backend services.
- Additional benefits of HttpClient include testability features, typed request and response objects, request and response interception, Observable APIs, and streamlined error handling.
- **HttpClientModule** must be imported from @angular/common/http in the module class to make HTTP service available to the entire module.

- Import HttpClient service class into a component’s constructor. 
- HTTP methods like get, post, put, and delete are made used off.
- JSON is the default response type for  HttpClient.
## Marking GET request:

- The following statement is used to fetch data from a server

```TypeScript
this.http.get(url)
```

- http.get by default returns an observable

- Add HttpClientModule to the **app.module.ts** to make use of HttpClient class

```TypeScript
...
import { HttpClientModule } from '@angular/common/http';
...
@NgModule({
	imports: [BrowserModule, HttpClientModule],
  ...
})
export class AppModule { }
```

- Add getBooks() method to BookService class in **book.service.ts** file as shown below

```TypeScript
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Book } from './book';
@Injectable({
	providedIn:'root'
})
export class BookService {
	constructor(private http: HttpClient) { }

	getBooks(): Observable<Book[]> {
		return this.http.get<Book[]>('http://localhost:3020/bookList')
					.pipe(
						tap((data: any) => console.log('Data Fetched:' + JSON.stringify(data))),
						catchError(this.handleError)
					);
	}
	
	private handleError(err: HttpErrorResponse): Observable<any> {
		let errMsg = '';
		if (err.error instanceof Error) {
			// A client-side or network error occurred. Handle it accordingly.
			console.log('An error occurred:', err.error.message);
			errMsg = err.error.message;
		} else {
			// The backend returned an unsuccessful response code.
			// The response body may contain clues as to what went wrong,
			console.log(`Backend returned code ${err.status}`);
			errMsg = err.error.status;
		}
		return throwError(()=>errMsg);
	}
}
```

- Makes an asynchronous call (ajax call) by using the get() method of HttpClient class.
- This method makes an asynchronous call to the server URL and fetches the data.
- HttpClient receives the JSON response as of type object. To know the actual structure of the response, an interface must be created and specified that interface name as a type parameter i.e., get<Book[]>.
- The **pipe** function defines a comma-separated sequence of operators. Here a sequence of observables is defined by listing operators as arguments to pipe function instead of dot operator chaining.
- The **tap** operator is to execute some statements once a response is ready which is mostly used for debugging purposes and **catchError** operator is used to handling the errors.
- handleError is an error-handling method that throws the error message back to the component

- Modify the code in the **book.component.ts** file as shown below

```TypeScript
...
export class BookComponent implements OnInit {
	books!: any;
	errorMessage!: string;
	constructor(private bookService: BookService) { }
	
	getBooks() {
		this.bookService.getBooks().subscribe({
			next:  books => this.books = books,
			error:error => this.errorMessage = <any>error
		})
	}
	ngOnInit() {
		this.getBooks();
	}
}
```

- Inject the  BookService class into the component class through the constructor
- Invokes the service class method getBooks() which makes an HTTP call to the books.json file. The getBooks() of the service class returns an Observable.
- An observable in Angular begins to publish values only when someone has subscribed to it. To retrieve the value contained in the Observable returned by getBooks() of service, subscribe to the observable by calling the `subscribe()` method and pass an observer object which can listen to the three types of notifications that an observable can send: next, error and complete.

| **Notification Type** | **Details**                                                                                                                                                                                          |
| --------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| next                  | Required.  <br>  <br>Handler for each delivered value. Gets called zero or more times once execution starts.                                                                                         |
| error                 | Optional.  <br>  <br>Handler for handling an error notification. If an error  occurs, it stops the execution of the observable instance.                                                             |
| complete              | Optional.  <br>  <br>Handler for handling the execution-completion notification. If any values have been delayed, those can be still delivered to the next handler even after execution is complete. |

- **book.component.html**

```HTML
...
<ul class="books">
	<li *ngFor="let book of books">
		<span class="badge">{{book.id}}</span> {{book.name}}
	</li>
</ul>
<div class="error" *ngIf="errorMessage">{{errorMessage}}</div>
```


## Making a POST request:

- HttpClient.post() method posts data to the server. It takes two parameters.
- Data - data to be sent to the server
- HttpOptions - to specify the required headers to be sent along with the request.

- Add addBook() method to BookService class in **book.service.ts** file as shown below

```TypeScript
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Book } from './book';
@Injectable({
	providedIn: 'root'
})
export class BookService {
	constructor(private http: HttpClient) { }
	...
	addBook(book: Book): Observable<any> {
		const options = new HttpHeaders({ 'Content-Type': 'application/json' });
		return this.http.post('http://localhost:3020/addBook', 
				book, 
				{ headers: options }
			).pipe(
				catchError(this.handleError)
			);
	}
...
}
```

- Makes an asynchronous call (ajax call) by using the post() method of HttpClient class.
- This method makes an asynchronous call to the server URL and sends the data along with the headers. HttpClient receives the JSON response as of type object. The Pipe function lets you define a comma-separated sequence of operators. Here, a sequence of observables is defined by listing operators as arguments to pipe function instead of dot operator chaining. catchError operator is used to handle the errors.
- handleError is an error-handling method that throws the error message back to the component.

- Modify the code in the **book.component.ts** file as shown below

```TypeScript
...
export class BookComponent implements OnInit {
	books!: any;
	errorMessage!: string;
	constructor(private bookService: BookService) { }
	
	getBooks() {
		this.bookService.getBooks().subscribe({
			next:  books => this.books = books,
			error:error => this.errorMessage = <any>error
		})
	}
	
	addBook(bookId: string, name: string): void {
		let id=parseInt(bookId)
		this.bookService.addBook({id, name})
		.subscribe({next:(book: any) => this.books.push(book)});
	}  
	
	ngOnInit(): void {
		this.getBooks();
	}
}
```

- Inject the BookService class into the component class through the constructor
- Invokes the service class method addBook() which makes an HTTP call to server URL and the Observable containing the response is returned. You can subscribe to the observable and use the 'next' callback to handle the successfully returned value, as needed.

## Making a PUT request

- HttpClient.put() method completely replaces the resource with the updated data. It is like POST requests except for updating an existing resource.
- Add updateBook() method to BookService class in **book.service.ts** file as shown below:

```TypeScript
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Book } from './book';
@Injectable({
	providedIn: 'root'
})
export class BookService {
	constructor(private http: HttpClient) { }
	...
	updateBook(book: Book): Observable<any> {
		const options = new HttpHeaders({ 'Content-Type': 'application/json' });
		return this.http.put<any>('http://localhost:3020/update', 
			book, 
			{ headers: options }
		).pipe(
			tap((_: any) => console.log(`updated hero id=${book.id}`)),
			catchError(this.handleError)
		);
	}
...
}
```

- Makes an asynchronous call (ajax call) by using the put() method of HttpClient class. This method makes an asynchronous call to the server URL and sends the data along with the headers as that of POST requests. HttpClient receives the JSON response as of type object.
- Pipe function defines a comma-separated sequence of operators. Here a sequence of observables is defined by listing operators as arguments to pipe function instead of dot operator chaining. **tap** operator is to execute some statements once a response is ready which is mostly used for debugging purposes and **catchError** operator is used to handle the errors.
- handleError is an error-handling method that throws the error message back to the component.

- Modify the code in the **book.component.ts** file as shown below

```TypeScript
...
export class BookComponent implements OnInit {
	books!: any;
	errorMessage!: string;
	constructor(private bookService: BookService) { }
	getBooks() {
		this.bookService.getBooks().subscribe({
			next:  books => this.books = books,
			error:error => this.errorMessage = <any>error
		})
	}
	
	addBook(bookId: string, name: string): void {
		let id=parseInt(bookId)
		this.bookService.addBook({id, name })
		.subscribe({next:(book: any) => this.books.push(book)});
	}
	updateBook(bookId: string, name: string): void {
		let id=parseInt(bookId)
		this.bookService.updateBook({ id, name })
		.subscribe({next:(book: any) => this.books = book});
	}
	ngOnInit(): void {
		this.getBooks();
	}
}
```

- Inject the BookService class into the component class through the constructor.
- Invokes the service class method updateBook() which makes an HTTP call to server URL and the Observable containing the response is returned. You can subscribe to the observable and use the 'next' callback to handle the successfully returned value, as needed.

## Making a DELETE request :

- HttpClient.delete() method deletes the resource by passing the bookId parameter in the request URL.
- Add deleteBook() method to BookService class in b**ook.service.ts** file as shown below

```TypeScript
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Book } from './book';
@Injectable({
	 providedIn: 'root'
})
export class BookService {
	constructor(private http: HttpClient) { }
	booksUrl = 'http://localhost:3020/bookList';
	...
	deleteBook(bookId: number): Observable<any> {
		const url = '${this.booksUrl}/${bookId}';
		return this.http.delete(url).pipe(
			catchError(this.handleError)
		);
		}
	...
}
```

- Makes an asynchronous call (ajax call) by using delete() method of HttpClient class. 
- HttpClient receives the JSON response as of type object. Pipe function defines a comma-separated sequence of operators. catchError operator is used to handle the errors.
- handleError is an error-handling method that throws the error message back to the component.
- Modify the code in the **book.component.ts** file as shown below

```TypeScript
...
export class BookComponent implements OnInit {
	books!: Book[];
	errorMessage!: string;
	constructor(private bookService: BookService) { }
	getBooks() {
		this.bookService.getBooks().subscribe({
			next:  books => this.books = books,
			error:error => this.errorMessage = <any>error
		})
	}
	addBook(bookId: string, name: string): void {
		let id=parseInt(bookId)
		this.bookService.addBook({id, name })
		.subscribe({next:(book: any) => this.books.push(book)});
	}
	updateBook(bookId: string, name: string): void {
		let id=parseInt(bookId)
		this.bookService.updateBook({ id, name })
		.subscribe({next:(book: any) => this.books = book});
	}
	deleteBook(bookId: string): void {
		let id=parseInt(bookId)
		this.bookService.deleteBook(id)
		.subscribe({next:(book: any) => this.books = book});
	} 
	ngOnInit(): void {
		this.getBooks();
	}
}
```

- Inject the BookService class into the component class through the constructor
- Invokes the service class method deleteBook() which makes an HTTP call to server URL and the Observable containing the response is returned.
- You can subscribe to the observable and use the 'next' callback to handle the successfully returned value, as needed.


# **Retrying HTTP Requests**

- Few errors can be momentary and are most unlikely to repeat. Such errors could be cleared upon making the same call a few seconds later.
- Most of these errors might occur when dealing with an external source like a database or web service which can have a network or other temporary issues.
- Such requests can be mitigated by using a retry function.

- Modify **book.service.ts** file used in HttpClient demo as shown below.
- The URL is changed to the wrong URL so that the retry function can try connecting to it the given number of times.

```TypeScript
...
import { catchError, tap, retry } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class BookService {
  constructor(private http: HttpClient) { }
  getBooks(): Observable<Book[]> {
	return this.http.get<Book[]>('http://localhost:3020/bookLis').pipe(
	  retry(3),
	  tap((data) => console.log('Data Fetched:' + JSON.stringify(data))),
	  catchError(this.handleError)
	);
  }
...
...
}
```

- Imports rxjs retry operator
- If the initial request to the server is not successful, retry() will try to connect to the URL for three more times.

![[retryoutput.png]]

  
# **HTTP Client Full Response**

- HTTP response body may not return all the data required. 
- Sometimes servers return special headers or status codes to indicate certain conditions that are important to the application workflow.
- The full response can be fetched using the observe option in HttpClient.
- Modify getBooks() method in **book.service.ts** file as shown below

```TypeScript
...
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Book } from './book';
@Injectable({
  providedIn: 'root'
})
export class BookService {
  booksUrl = 'http://localhost:3020/bookList';
  constructor(private http: HttpClient) { }
  getBooks(): Observable<any> {
	return this.http.get<any>(this.booksUrl, {observe:'response'}).pipe(      
	  tap((data: any) => console.log('Data Fetched:' + JSON.stringify(data))),
	  catchError(this.handleError));
  }
...
}
```

- {observe:'response'} parameter in the get method returns full response as type HttpResponse.
- Displays the full response at the console.
- Modify getBooks() method in **book.component.ts** file as shown below

```TypeScript
...
@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
 
 ...
 books!: any;
 ...
  constructor(private bookService: BookService) { }
	getBooks() {
	this.bookService.getBooks().subscribe({
	  next:response => this.books = response.body ?? this.books,
	  error:error => this.errorMessage = <any>error
	})
  }
  ngOnInit() {
	this.getBooks();
  }
}
```

- Accessing books data with the response.body property. Using the nullish operator to assign the content of response or null value present in this.books.

# Interceptors

- Interceptors are one of the major features of the @angular/common/http module. They are placed in between the client and backend.
- They are used for transforming the HTTP requests that are supposed to be sent to the backend and vice versa. In addition, they can also be used for sending headers.
- Interceptors use clone() property to duplicate the requests thereby making it mutable because requests are immutable in nature.
- They are used mostly for making minor changes to requests/responses for authentication, caching behavior, and XSRF protection.

- Open the HttpClient demo and modify the request header to use the interceptor by adding an authorization header to the request.
- For this, add the following code in the **app.module.ts** file

```TypeScript
...
import { HTTP_INTERCEPTORS } from '@angular/common/http';
...
import { Interceptor1 } from './book/book.interceptor';
@NgModule({
  imports: [BrowserModule, HttpClientModule],
  declarations: [AppComponent, BookComponent],
  providers: [{
	provide: HTTP_INTERCEPTORS,
	useClass: Interceptor1,
	multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

- Wires up Interceptor1 into the application by importing HTTP_INTERCEPTORS token in the app module.
- Create a new file called **book.interceptor.ts** and add the following code

```TypeScript
import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable()
export class Interceptor1 implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
	const authReq = req.clone({
	  headers: req.headers.set('Authorization', 'Password')
	});
	return next.handle(authReq);
  }
}
```

- The interceptor class should be injectable and define an intercept method to implement HttpInterceptor.
- The method takes two arguments, first req is the request object and should be of type HttpRequest and next is the handler that is of type HttpHandler, that uses the handle method to return HttpEvent observable type.
- As HTTP Requests are immutable, but requries to be cloned to modify and then return the modified response. This interceptor changes every occurrence of HTTP in the httpRequest to HTTPS and sends a header token along with the request.

![[interceptoroutput.png]]


# **Handling Non-JSON data in HttpClient**

- If the server is returning a non-JSON response, the HTTPClient must be informed to expect a textual response using response object as the default response type of HTTP client is of JSON type
- The observable returned will be of type string if the response is of type text
- Modify the code in the **book.service.ts** file as shown below

```TypeScript
...
@Injectable({
  providedIn:'root'
})
export class BookService {
  private txtUrl = './assets/sample.txt';
  constructor(private http: HttpClient) { }
  getBooks(): Observable<string> {
	return this.http.get(this.txtUrl, { responseType: 'text' })
	  .pipe(tap(data => console.log(data.length)),
	  catchError(this.handleError)
		);
  }
}
```

- responseType token changes the default JSON response to Textual response which returns an observable of type string.

- Create a **sample.txt** file under the assets folder and add the following content to it.

```TypeScript
Welcome to demo on fetching textual response. Book Id is 1 and book name is Angular.
```  

- Modify the code in the **book.component.ts** file as shown below

```TypeScript
import { Component, OnInit } from '@angular/core';
import { Book } from './book';
import { BookService } from './book.service';
@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  ...
  msg!:string;
  ...
  constructor(private bookService: BookService) { }
  getBooks() {
	this.bookService.getBooks().subscribe({
	  next:data=> this.msg = data ,
	  error:error => this.errorMessage = <any>error});
  }
  ngOnInit() {
	this.getBooks();
  }
}
```

- Response returned to the component is assigned to the local property called 'msg'
- Modify **book.component.html** file as shown below

```HTML
<h2>Data from text file:</h2>
{{msg}}
<div class="error" *ngIf="errorMessage">{{errorMessage}}</div>
```

- Displays the text response returned