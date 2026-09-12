
# Access Specifier

| Access Modifier | Description                                                                                                                                           |
| --------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- |
| public          | Members are accessible from outside the class, as well as from derived classes. This is the default access modifier if none is specified.             |
| protected       | Members are accessible within the class they are defined in and within any derived classes. They are not accessible from outside the class hierarchy. |
| private         | Members are accessible only within the class they are defined in. They are not accessible from derived classes or from outside the class.             |

Example:

- By default, all members of a class in TypeScript are public.

```jsx
class Animal {
    public name: string;
    protected color: string;
    private age: number;

    constructor(name: string, color: string, age: number) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public display(): void {
        console.log('Name: ${this.name}, Color: ${this.color}, Age: ${this.age}');
    }
}

class Dog extends Animal {
    bark(): void {
        // Accessible: public and protected members are accessible in derived classes
        console.log(`${this.name} barks!`);
        console.log(`${this.color} dog barks!`);
        // console.log(`${this.age}`); // Error: 'age' is private and not accessible here
    }
}

let animal = new Animal("Tommy", "Brown", 3);
animal.display(); // Outputs: Name: Tommy, Color: Brown, Age: 3

let dog = new Dog("Buddy", "Black", 2);
dog.display(); // Outputs: Name: Buddy, Color: Black, Age: undefined (age is private and not accessible)
dog.bark();    // Outputs: Buddy barks!, Black dog barks!

```

# ReadOnly

- Read-only members can be accessed outside the class, but their value cannot be changed.

```tsx
class Employee {
    readonly empCode: number;
    empName: string;
    
    constructor(code: number, name: string)     {
        this.empCode = code;
        this.empName = name;
    }
}
let emp = new Employee(10, "John");
emp.empCode = 20; //Compiler Error
emp.empName = 'Bill'; 
```

- An interface can also have readonly member properties.

```tsx
interface IEmployee {
    readonly empCode: number;
    empName: string;
}

let empObj:IEmployee = {
    empCode:1,
    empName:"Steve"
}

empObj.empCode = 100; // Compiler Error: Cannot change readonly 'empCode'
```

- In the same way you can use `Readonly<T>` to create a readonly type, as shown below.

```tsx
interface IEmployee {
    empCode: number;
    empName: string;
}

let emp1: Readonly<IEmployee> = {
    empCode:1,
    empName:"Steve"
}

emp1.empCode = 100; // Compiler Error: Cannot change readonly 'empCode'
emp1.empName = 'Bill'; // Compiler Error: Cannot change readonly 'empName'

let emp2: IEmployee = {
    empCode:1,
    empName:"Steve"
}

emp2.empCode = 100; // OK
emp2.empName = 'Bill'; // OK
```