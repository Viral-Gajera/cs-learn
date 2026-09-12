# Interface

- It is used to define the structure of the object (also function, array, class).
- Classes that are derived from an interface must follow the structure provided by their interface.
- It can include properties and method declarations using a function or an [arrow function](https://www.tutorialsteacher.com/typescript/arrow-function).

```TypeScript
interface IEmployee {
    empCode: number;
    empName: string;
    getSalary: (number) => number; // arrow function
    getManagerName(number): string;
}
```

  

### Interface as Variable Type

- Interface in TypeScript can be used to define a type and also to implement it in the class.

```TypeScript
interface KeyPair {
    key: number;
    value: string;
}

let kv1: KeyPair = { key:1, value:"Steve" }; // OK
let kv2: KeyPair = { key:1, val:"Steve" };   // Compiler Error: 'val' doesn't exist in type 'KeyPair'
let kv3: KeyPair = { key:1, value:100 };     // Compiler Error:
```

  

### Interface as Function Type

```TypeScript
interface KeyValueProcessor {
    (key: number, value: string): void;
}

let addKeyValue: KeyValueProcessor = function (key: number, value: string): void {
    console.log("addKeyValue: key = " + key + ", value = " + value);
};

let x : (a: number, b: string) => void = addKeyValue;
```

  

### Interface for Array Type

```TypeScript
// Array type
interface NumList {
    [index: number]: number;
}

let numArr: NumList = [1, 2, 3];
numArr[0];
numArr[1];

// Object type
interface IStringList {
    [index: string]: string;
}

let strArr: IStringList = {};         // object
strArr["TS"] = "TypeScript";
strArr["JS"] = "JavaScript";
```

- An interface can also define the type of an array where you can define the type of index as well as values.


### Optional Property

```TypeScript
interface IEmployee {
    empCode: number;
    empName: string;
    empDept?:string;
}
```

  

### Read only Properties

```TypeScript
interface Citizen {
    name: string;
    readonly SSN: number;
}
```

- TypeScript provides a way to mark a property as read only. This means that once a property is assigned a value, it cannot be changed!

  

### Interface extending Interfaces

```TypeScript
interface Person {
    name: string;
    gender: string;
}

interface Employee extends Person {
    empCode: number;
}

let empObj: Employee = {
    empCode:1,
    name:"Bill",
    gender:"Male"
}
```

- Objects of `IEmployee` must include all the properties and methods of the `IPerson` interface otherwise, the compiler will show an error.

  

### Class implementing an Interface

- The Class implementing the interface needs to strictly conform to the structure of the interface.

```TypeScript
interface IEmployee {
    empCode: number;
    name: string;
    getSalary: (empCode: number) => number;
}

class Employee implements IEmployee {
    empCode: number;
    name: string;

    constructor(code: number, name: string) {
        this.empCode = code;
        this.name = name;
    }

    getSalary(empCode:number):number {
        return 20000;
    }
}

let emp = new Employee(1, "Steve");
```