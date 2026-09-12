# Function

### Function as type

```TypeScript
let myFunc: (arg1: number, arg2: string) => void = function (
    arg1: number,
    arg2: string
): void {
    console.log(arg1 + " " + arg2);
};
```

### Optional Parameters:

- In TypeScript, the compiler expects a function to receive the exact number and type of arguments as defined in the function signature.
- TypeScript has an optional parameter functionality.
- The parameters that may or may not receive a value can be appended with a '?' to mark them as optional.
- All optional parameters must follow required parameters and should be at the end.

```TypeScript
function Greet(greeting: string, name?: string ) : string {
    return greeting + ' ' + name + '!';
}
```

  

### Default Value to Parameters:

- If the user does not provide a value to an argument, TypeScript will initialize the parameter with the default value.
- The default parameter must follow the required parameters in the function signature.
- However, if a function signature has a default parameter before a required parameter, the function can still be called, provided the default parameter is passed a value of undefined.

```TypeScript
function fn(a = 2, b): never {
    while (true) {
        console.log("Hello");
    }
}

console.log(fn(1, 2));
console.log(fn(undefined , 2));
```

  

### Arrow function

```TypeScript
let sum : number = (x: number, y: number) : number => {
    return x + y;
}
```

  

### Rest Parameters

- When the number of parameters that a function will receive is not known or can vary, we can use rest parameters.

```TypeScript
function Greet(greeting: string, ...names: string[]) {
    return greeting + " " + names.join(", ") + "!";
}
```

- Remember, rest parameters must come last in the function definition, otherwise the TypeScript compiler will show an error.

  

### Function Overloading

- You can have multiple functions with the same name but different parameter types and return type.
- However, the number of parameters should be the same.

```TypeScript
function add(a:string, b:string):string;
function add(a:number, b:number): number;
function add(a: any, b:any): any {
    return a + b;
}

add("Hello ", "Steve"); // returns "Hello Steve" 
add(10, 20);            // returns 30 
```

- The last function should have the function implementation.
- Since the return type can be either string or number as per the first two function declarations, we must use compatible parameters and return type as `any` in the function definition.

```TypeScript
// Also allowed
function add(a: string, b: string): string;
function add(a: number, b: number): number;
function add(a: any, b: any): string | number {
    return a + b;
}
```

- Function implementation should have compatible types for all declarations.

```TypeScript
function sayHello(name: string): string;
function sayHello(name: string[]): string[];
function sayHello(name: unknown): unknown {
    if (typeof name === 'string') {
        return `Hello there, ${name}!`
    }else if (Array.isArray(name)) {
        return name.map(name => `Hello, ${name}!`);
    }
   throw new Error('Something went wrong');
};
```

- [_**arrow functions**_](https://blog.logrocket.com/definitive-guide-typing-functions-typescript/#typed-arrow-functions) _**do not support overloading.**_
- Implementation signature parameters must be generic
- Implementation signature parameters are not visible
- Only the overload signatures are callable, and they determine the valid argument combinations and return types for the function.

```TypeScript
function sayHello(name: string): string;
function sayHello(): any {
    // rest of the code
}
```

- You’ll notice that our implementation signature expects no argument to be passed to it.
- Watch what happens when we try to call our `sayHello()` function without any arguments:

![[Typescript-implementation-signature-example.avif]]

- Although our implementation signature has no declared arguments, it still expects an argument to be passed when invoked.
- This is because the implementation signature’s details are not visible from outside the function, so it relies on the declared overload signature, and in this case, it specifies the presence of an argument.


### Arrow functions and overloading

```TypeScript
function func(value?: string): boolean;
function func(value?: string[]): boolean;
function func(value: unknown): boolean {
	  return true;
}
```

- Well, actually, arrow functions can support overloading — as long as we change the syntax. Here’s how:

```TypeScript
type funcType = {
    (value?: string): boolean;
    (value?: string[]): boolean;
}

const func : funcType = (value: unknown) => {
 // rest of the code.
}
```