# Class

A class can include the following:

- Constructor
- Properties
- Methods

```TypeScript
class Employee {
    empCode: number;
    empName: string;
    
    constructor(code: number, name: string) {
        this.empName = name;
        this.empCode = code;
    }
    
    getSalary(): number {
        return 10000;
    }
}

let x = new Employee(1, "Steve");
console.log(x.getSalary());

let emp = new Employee();            // Error - Expected 2 arguments, but got 0. 
```

- The TypeScript compiler will convert the above class to the following JavaScript code using [closure](https://www.tutorialsteacher.com/javascript/closure-in-javascript):

```TypeScript
let Employee = /** @class */ (function () {
    function Employee(name, code) {
        this.empName = name;
        this.empCode = code;
    }
    Employee.prototype.getSalary = function () {
        return 10000;
    };
        return Employee;
}());
```

  

### **Constructor**

- the constructor method is always defined with the name "constructor”
- In the constructor, members of the class can be accessed using `this` keyword e.g. `this.empCode` or `this.name`.
- Constructor can be used in dependency injection.

  

### **Inheritance**

```TypeScript
class Person {
    name: string;
    
    constructor(name: string) {
        this.name = name;
    }
}

class Employee extends Person {
    empCode: number;
    
    constructor(empcode: number, name:string) {
        super(name);
        this.empCode = empcode;
    }
    
    displayName():void {
        console.log("Name = " + this.name +  ", Employee Code = " + this.empCode);
    }
}

let emp = new Employee(100, "Bill");
emp.displayName(); // Name = Bill, Employee Code = 100
```

> [!important]  
> We must call super() method first before assigning values to properties in the constructor of the derived class.  

  

### **Class Implements Interface**

- A class can implement single or multiple interfaces.

```TypeScript
interface I {
    x: number;
    y: number;

    fn(): void;
}

class C implements I {
    x: number;
    y: number;
    z: number;

    fn(): void {
        this.z = this.x + this.y;
    }
}
```

  

### **Interface extends Class**

```TypeScript
class A {
    x: number;
    y: number;
    fn(): void {
        console.log(this.x, this.y);
    }
}

interface I extends A {
    z: number;
    fn(): void;
}

class D implements I {
    x: number;
    y: number;
    z: number;

    fn(): void {
        console.log(this.x, this.y, this.z);
    }
}
```

  

### **Method Overriding**

```TypeScript
class X {
    fn(): void {
        console.log("A.fn");
    }
}

class Y extends X {
    fn(): void {
        console.log("B.fn");
    }
}

let x: X = new X();
x.fn(); // A.fn
let y: X = new Y();
y.fn(); // B.fn
```

  

### **Super keyword**

```TypeScript
class M {
    fn(): void {
        console.log("A.fn");
    }
}

class N extends M {
    fn(): void {
        super.fn();
        console.log("B.fn");
    }
}

let m: M = new M();
m.fn(); // A.fn
let n: M = new N();
n.fn(); // A.fn B.fn
```

  

  

# Abstract class

## Defining abstract class

- We cannot create an instance of an abstract class.
- Contains one or more abstract methods
- However, an abstract class can also contain concrete methods (methods with implementation).
- The class which extends the abstract class must define all the abstract methods.

```TypeScript
abstract class Animal {
    abstract makeSound(): void;
    move(): void {
        console.log("roaming the earth...");
    }
}

class Dog extends Animal {
    makeSound() {
        console.log("Bark bark");
    }
}

let dog: Dog = new Dog();
dog.makeSound();
dog.move();
```

> [!important]  
> The class which implements an abstract class must call super() in the constructor.  

  

## Abstract property

- The abstract class can also include an abstract property, as shown below.

```TypeScript
abstract class Person {
    abstract name: string;

    display(): void{
        console.log(this.name);
    }
}

class Employee extends Person { 
    name: string;
    empCode: number;
    
    constructor(name: string, code: number) { 
        super(); // must call super(), otherwise error
        
        this.empCode = code;
        this.name = name;
    }
}

let emp: Person = new Employee("James", 100);
emp.display(); //James
```