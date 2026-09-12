# Installation

```Shell
npm i typescript -g

tcs filename.ts
-> to compile a single file to .js file

tsc --init
-> to create tsconfig.json
-> uncomment rootDir and outDir in tsconfig.json
-> "rootDir": "./src",
-> "outDir": "./dist",

tsc
-> to compile all .ts files to .js files

tsc -w
-> to watch for changes in .ts files and compile them to .js files

tsc -p tsconfig.json
-> to compile all .ts files to .js files using tsconfig.json

tsc -p tsconfig.json -w
-> to watch for changes in .ts files and compile them to .js files using tsconfig.json

```

- Compile the code on the fly and run it through node

```Shell
npm install -g ts-node typescript '@types/node'
ts-node file.ts

npx tsx ./script.ts
```


# Datatype

```typescript
number
string
boolean
null
undefined
BigInt     - es2020 or higher
Symbol     - es2020 or higher

any
void       - similar undefine
never      - indicates the values that will never occur, return type of func with Infinite loop
unknown    - 
```

```TypeScript
object
{}
{key1:T, key2:T}

Array<T>
T[]         
[T]         - tuple, push(T)
[T,T]       - tuple, push(T,T)
[T,T,T]     - tuple, push(T,T,T)

Array<T|T>  - Multi Type Array
(T|T)[]     - Multi Type Array

// Nested Array 
Array<Array<T>>
T[][]

// Nested tuple
[[T,T]]
[[T,T],[T,T]]

// Tuple Array
[T,T][]

// Array Tuple
[ T[], T[] ]
```

- You can add new elements to a tuple using the `push()` method.
- Example:

```TypeScript
let a: object = {
    name: "Jack",
    age: 32,
};

let b: object = {};

let c: {} = {
    name: "Jack",
    age: 32,
};

let d: { name: string; age: number } = {
    name: "Jack",
    age: 32,
};

let e: Array<number> = [1, 2, 3];
let f: number[] = [1, 2, 3];
let g: [string] = ["Jack"];               // error - ["Jack", "Ma"]
let h: [string, number] = ["Jack", 32];   // error - ["Jack", 32, "Ma", 51]
let i: [string, number, boolean] = ["Jack", 32, true];

let j: Array<number | string> = [1, 2, 3, "4"];
let k: (number | string)[] = [1, 2, 3, "4"];

let l: Array<Array<number>> = [
    [1, 2, 3],
    [4, 5],
];
let m: number[][] = [
    [1, 2, 3],
    [4, 5],
];

let n: [[number, string], [boolean, number]] = [
    [1, "Jack"],
    [true, 32],
];
let o: [number[], string[]] = [
    [1, 2, 3],
    ["Jack", "Ma"],
];
```

  

# Enum

- Enums allow us to declare a set of named constants i.e. a collection of related values that can be numeric or string values.
- enum values start from zero and increment by 1 for each member.

- When the enum includes computed and constant members, then uninitiated enum members either must come first or must come after other initialized members with numeric constants.

- String enums are similar to numeric enums, except that the enum values are initialized with string values rather than numeric values.
- Heterogeneous enums are enums that contain both string and numeric values.

```TypeScript
// Numeric enum
enum EnumName {
	keyword1,
	keyword2,
	keyword3,
}

keyword1 = 0
keyword2 = 1
keyword3 = 2

console.log(EnumName);    // { '0': 'keyword1', '1': 'keyword2', '2': 'keyword3', keyword1: 0, keyword2: 1, keyword3: 2 }

enum EnumName {
	keyword1 = 5,
	keyword2,
	keyword3,
}

keyword1 = 5
keyword2 = 6
keyword3 = 7

enum EnumName {
	keyword1 = 5,
	keyword2 = 13,
	keyword3 = 17,
}

keyword1 = 5
keyword2 = 13
keyword3 = 17

enum EnumName {
	keyword1,
	keyword2,
	keyword3 = fn(),
}

enum EnumName {
	keyword1 = fn(),
	keyword2 = 13,
	keyword3,
}

// String enum

enum EnumName {
	keyword1 = "value1",
	keyword2 = "value2",
	keyword3 = "value3",
}

console.log(EnumName);  // { keyword1:"value1", keyword2:"value2", keyword3:"value3" }

// Heterogeneous enum

enum EnumName {
	keyword1 = "value1",
	keyword2 = 10,
	keyword3 = "value3",
}

console.log(EnumName);  // { keyword1:"value1", keyword2:10, 10:"keyword2" keyword3:"value3" }
```

```TypeScript
// Enum
enum e1 {
    Red,
    Green,
    Blue,
}
console.log(e1.Red, e1.Green, e1.Blue); // 0 1 2
console.log(e1[0], e1[1], e1[2]);       // Red Green Blue

let x: e1 = e1.Red;
let y: e1 = e1.Green;
let z: e1 = e1.Blue;


// String Enum
enum e4 {
    Red = "Black",
    Green = "White",
    Blue = "Yellow",
}

console.log(e4);            // { Red: 'Black', Green: 'White', Blue: 'Yellow' }


// Heterogeneous Enum
enum e5 {
    Red = 1,
    Green = "Green",
    Blue = 2,
}

console.log(e5);           // { '1': 'Red', '2': 'Blue', Red: 1, Green: 'Green', Blue: 2 }
```

  

# Union

```TypeScript
(type1 | type2 | type3 | ... | typeN)
```

  

# Type Inference

Automatically determine the type of a variable, parameter, or expression based on the context and the value assigned to it.

TypeScript infers types of variables when there is no explicit information available in the form of type annotations.

Types are inferred by TypeScript compiler when:

- Variables are initialized
- Default values are set for parameters
- Function return types are determined

```TypeScript
var a = "some text";
var b = 123;
a = b; // Compiler Error: Type 'number' is not assignable to type 'string'
```

  

# Type Assertion

- Manually specify the type of a value, overriding the compiler's inferred type.
- Type assertion is a mechanism in TypeScript that allows you to override the compiler's type inference.

```TypeScript
let code: any = 123; 
let employeeCode = <number> code; 
console.log(typeof(employeeCode)); //Output: number
```

- Type Assertion with Object

```TypeScript
let employee = { };
employee.name = "John"; //Compiler Error: Property 'name' does not exist on type '{}'
employee.code = 123;    //Compiler Error: Property 'code' does not exist on type '{}'

// Solution

interface Employee { 
    name: string; 
    code: number; 
} 

let employee = <Employee> { }; 
employee.name = "John"; // OK
employee.code = 123; // OK
```

There are two ways to do type assertion in TypeScript:

- Using the angular bracket <> syntax. (above)
- Using the 'as' syntax.

```TypeScript
let code: any = 123;
let employeeCode = code as number;
```

- While dealing with JSX in TypeScript, only the `as` syntax is allowed, because JSX is embeddable in XML like a syntax.



# Non-null assertion operator 

- It is used to tell the compiler that you are sure that a value is not null or undefined, even though the compiler might think it could be.

Here's a breakdown of its usage and some common use cases:

**1. Accessing Properties of Possibly Null or Undefined Values**:

Example:

```typescript
let myString: string | null = null;
console.log(myString.length);  // Error: Object is possibly 'null'.
console.log(myString!.length); // No error, using non-null assertion.
```

- In this example, `myString` is declared as a string or null. 
- Without the non-null assertion operator, TypeScript would raise an error because it considers the possibility of `myString` being `null`. 
- By using `myString!`, you're telling TypeScript to trust you that `myString` will not be null at runtime.

**2. When Using Type Assertion**:

Example:

```typescript
let myObject: {
    name: string;
    age?: number;
} = {
    name: "John"
};

console.log(myObject.age!.toFixed(2)); // No error, using non-null assertion.

```

- In this case, `age` is optional, so it could be `undefined`. 
- By using `myObject.age!`, you're asserting that `age` is not `undefined`, thus avoiding TypeScript errors.

**3. When Dealing with DOM Elements**:

Example: 

```typescript
const myElement = document.getElementById("myElement");
myElement!.innerHTML = "Hello, TypeScript!"; 
// No error, using non-null assertion.
```


**4. When You Are Absolutely Certain a Value Won't Be Null or Undefined**:

Example:

```typescript
let myValue!: string;
// ... code that definitely assigns a value to myValue ...
console.log(myValue.toUpperCase()); 
// No error, you're confident myValue won't be null or undefined.
```