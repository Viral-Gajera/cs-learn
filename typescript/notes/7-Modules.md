# Modules

- The TypeScript code we write is in the global scope by default.
- If we have multiple files in a project, the variables, functions, etc. written in one file are accessible in all the other files.

> file1.ts

```JavaScript
var greeting : string = "Hello World!";
```

> file2.ts

```JavaScript
console.log(greeting); //Prints Hello World!

greeting = "Hello TypeScript"; // allowed
```

- The above variable greeting, declared in file1.ts is accessible in file2.ts as well.
- Not only it is accessible but also it is open to modifications.
- This is a dangerous space as it can lead to conflicts/errors in the code.

- TypeScript provides modules and namespaces in order to prevent the default global scope of the code and also to organize and maintain a large code base.
- Modules are a way to create a local scope in the file.
- A module can be created using the keyword `export` and a module can be used in another module using the keyword `import`.

```JavaScript
export let age : number = 20;
export class Employee {
    empCode: number;
    empName: string;
    constructor(name: string, code: number) {
        this.empName = name;
        this.empCode = code;
    }
    displayEmployee() {
        console.log ("Employee Code: " + this.empCode + ", Employee Name: " + this.empName );
    }
}
let companyName:string = "XYZ";
```

- Thus, `Employee.ts` is a module which exports the `age` variable and the `Employee` class to be used in other modules by importing the `Employee` module using the import keyword.
- The `companyName` variable cannot be accessed outside this `Employee` module, as it is not exported.  

> [!important]  
> Minimum one export required to create module. Once module created all the other variable becomes local to the file.  

```JavaScript
import { Employee } from "./Employee";
let empObj = new Employee("Steve Jobs", 1);
empObj.displayEmployee(); //Output: Employee Code: 1, Employee Name: Steve Jobs  
```

```JavaScript
// Importing Module into Variable
import * as Emp from "./Employee"

// Renaming Export Module
import { Employee as Associate } from "./Employee"
```

More details on module in javascript [[12.1-Modules]].

## Compiling module

- The TypeScript compiler generates the JavaScript code based on the module target option specified during compilation.
- Use the following command to compile a TypeScript module and generate the JavaScript code.

```Shell
tsc --module <target> <file path>
```

The following can be used as target with the above `--module` command option:

1. None
2. [CommonJS](http://www.commonjs.org/)
3. [AMD](https://github.com/amdjs/amdjs-api/wiki/AMD)
4. [UMD](https://github.com/umdjs/umd)
5. [System](https://github.com/systemjs/systemjs)
6. ES6, ES2015 or ESNext

For example, use CommonJS target option for server side Node.js applications where you are using [CommonJS](http://www.commonjs.org/) module loader; use AMD target option if you are using client side module loader [require.js](https://requirejs.org/) for the web application; use UMD target option for both client side and server side modules; use System for ES modules, use ES6 or ES2015 for ES5 modules or lower.  
  

Example:

```Shell
tsc --module amd Employee.ts
```

# Namespace

> [!warning] Important
> Do not use namespace

