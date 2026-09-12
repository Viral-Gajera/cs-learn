# Pipes

- Use [pipes](https://angular.io/guide/glossary#pipe) to transform strings, currency amounts, dates, and other data for display.
- Pipes are simple functions to use in [template expressions](https://angular.io/guide/glossary#template-expression) to accept an input value and return a transformed value.
- Pipes are useful because you can use them throughout your application, while only declaring each pipe once.
- Syntax:

```TypeScript
{{ expression | pipe }}
{{ expression | pipe : param }}
{{ expression | pipe : param : param }}
```

- Example:

```TypeScript
{{ "Angular" | uppercase }}
```

- Angular provides built-in pipes for typical data transformations, including transformations for internationalization

```HTML
DatePipe      : Formats a date value according to locale rules.
UpperCasePipe : Transforms text to all upper case.
LowerCasePipe : Transforms text to all lower case.
TitleCasePipe : 
CurrencyPipe  : Transforms a number to a currency string, formatted according to locale rules.
DecimalPipe   : Transforms a number into a string with a decimal point, formatted according to locale rule
PercentPipe   : Transforms a number to a percentage string, formatted according to locale rules.
AsyncPipe     : Subscribe and unsubscribe to an asynchronous source such as an observable.
JsonPipe      : Display a component object property to the screen as JSON for debugging.
SlicePipe
```

- Below are the built-in pipes present in Angular, which accept optional parameters using which the pipe's output can be fine-tuned.

```TypeScript
{{ expression | currency :currencyCode:symbol:digitInfo:locale }}
{{ expression | date :format:timezone:locale }}
{{ expression | percent :digitInfo:locale }}
{{ expression | slice :start:end }}
{{ expression | number :digitInfo }}
```

- Example:

```HTML
<p>The hero's birthday is {{ birthday | date }} </p>
<p>The hero's birthday is {{ birthday | uppercase }} </p>

<p>The hero's birthday is {{ birthday | date : 'fulldate' }} </p>
<p>The chained hero's uppercase birthday is {{ birthday | date | uppercase}}</p>
<p>The chained hero's uppercase birthday in "fullDate" format is {{ birthday | date:'fullDate' | uppercase}} </p>

<p>{{'Viral Gajera' | slice : 1 : 3}}</p>
<p>{{2000.3000 | number : '2.2-3' }}</p>

condition ? a : b | pipe
condition ? a : (b | pipe)
(condition ? a : b) | pipe
```

```TypeScript
import { Component } from '@angular/core';
import { DatePipe } from '@angular/common';

@Component({
  standalone: true,
  selector: 'app-birthday',
  templateUrl: './birthday.component.html',
  imports: [DatePipe],
})
export class BirthdayComponent {
  birthday = new Date(1988, 3, 15); 
	// April 15, 1988 -- since month parameter is zero-based
}
```


# Custom pipe

- Command

```Plain
ng generate pipe <pipe-name>
ng g p <pipe-name>

Example:
ng generate pipe pipes/upperCase
```

- This will create a new file called `upper-case.pipe.ts` in the `src/app/pipes` directory.

- To create your own custom pipe, inherit the PipeTransform interface.
- PipeTransform interface has a `transform method` where custom pipe functionality needs to be written.
- Open the `upper-case.pipe.ts` file and add the following code:

```TypeScript
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'upperCase'
})
export class UpperCasePipe implements PipeTransform {
	transform(value: any, ...args:any[]): any {
		return value.toUpperCase();
	}
}
```

- transform method has two arguments, the first one is the value of the expression passed to the pipe which needs to be tranformed and the second is the variable arguments.
- The pipe can have multiple arguments based on the number of parameters passed to the pipe. The transform method should return the final value.
- You can also create custom pipes that accept parameters.

```TypeScript
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
	name: 'upperCaseWithPrefix'
})
export class UpperCaseWithPrefixPipe implements PipeTransform {
	transform(value: any, prefix: string): any {
		return prefix + value.toUpperCase();
	}
}

/*
{{ value | upperCaseWithPrefix: 'Mr.' }}
*/
```