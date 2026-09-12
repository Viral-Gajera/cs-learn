# Generics

- Generics are used to pass "type" argument to classes, functions etc...

# Generic Function

- Example without generics:
- Let's see why we need Generics using the following example.
```typescript
function getArray(items : any[] ) : any[] {
    return new Array().concat(items);
}

let myNumArr = getArray([100, 200, 300]);
let myStrArr = getArray(["Hello", "World"]);

myNumArr.push(400);                // OK
myStrArr.push("Hello TypeScript"); // OK

myNumArr.push("Hi"); // OK
myStrArr.push(500);  // OK

console.log(myNumArr); // [100, 200, 300, 400, "Hi"]
console.log(myStrArr); // ["Hello", "World", "Hello TypeScript", 500]
```

- Since we have used type `any` for our arguments, we can pass any type of array to the function. However, this may not be the desired behavior.
- We may want to add the numbers to number array or the strings to the string array but not numbers to the string array or vice-versa.

- Example with generics:
```typescript
function getArray<T>(items : T[] ) : T[] {
    return new Array<T>().concat(items);
}

let myNumArr = getArray<number>([100, 200, 300]);
let myStrArr = getArray<string>(["Hello", "World"]);

myNumArr.push(400);                // OK
myStrArr.push("Hello TypeScript"); // OK

myNumArr.push("Hi"); // Compiler Error
myStrArr.push(500);  // Compiler Error
```


- The type variable `T` is also used to specify the type of the arguments and the return value.

- It is not recommended but we can also call a generic function without specifying the type variable. 
- The compiler will use type inference to set the value of `T` on the function based on the data type of argument values.


## Multiple Type Variables

- We can specify multiple type variables with different names as shown below.
- Example:
```typescript
function displayType<T, U>(id:T, name:U): void { 
  console.log(typeof(id) + ", " + typeof(name));  
}

displayType<number, string>(1, "Steve"); // number, string
```

- Generic type can also be used with other non-generic types.

```typescript
function displayType<T>(id:T, name:string): void { 
  console.log(typeof(id) + ", " + typeof(name));  
}

displayType<number>(1, "Steve"); // number, string
```


## Methods and Properties of Generic Type

- When using type variables to create generic components, TypeScript forces us to use only general methods which are available for every type.

```typescript
function displayType<T, U>(id:T, name:U): void { 
    
    id.toString();   // OK
    name.toString(); // OK
    
    id.toFixed();       // Compiler Error: 'toFixed' does not exists on type 'T'
    name.toUpperCase(); // Compiler Error: 'toUpperCase' does not exists on type 'U'
    
    console.log(typeof(id) + ", " + typeof(name));  
}
```

- In the above example, `id.toString()` and `name.toString()` method calls are correct because the `toString()` method is available for all types. 
- However, type specific methods such as `toFixed()` for number type or `toUpperCase()` for string type cannot be called. The compiler will give an error.

- You can use array methods for the generic array.

```typescript
function displayNames<T>(names:T[]): void { 
    console.log(names.join(", "));  
}

displayNames<string>(["Steve", "Bill"]); // Steve, Bill
```


## Generic Constraints

- We can restrict it to certain types using constraints.
- Consider the following example:

```typescript
class Person {
    firstName: string;
    lastName: string;
    
    constructor(fname:string,  lname:string) { 
        this.firstName = fname;
        this.lastName = lname;
    }
}

function display<T extends Person>(per: T): void {
    console.log(`${per.firstName} ${per.lastName}` );
}
var per = new Person("Bill", "Gates");
display(per);           //Output: Bill Gates

display("Bill Gates");  //Compiler Error
```


- In the above example, the `display` function is a generic function with constraints.
- The constraint `<T extends Person>` specifies that the generic type T must extend the class `Person`. 
- So, the `Person` class or any other class that extends the `Person` class can be set as generic type while calling the `display` function, otherwise the compiler will give an error.


# Generic Interface

- The generic type can also be used with the interface. 
- The following is a generic interface.

```typescript
interface IProcessor<T> 
{ 
    result:T;
    process(a: T, b: T) => T;
}
```

- The above `IProcessor` is a generic interface because we used type variable `<T>`. 
- The `IProcessor` interface includes the generic field `result` and the generic method `process()` that accepts two generic type parameters and returns a generic type.


- Generic Interface as Type

```typescript
interface KeyPair<T, U> {
    key: T;
    value: U;
}

let kv1: KeyPair<number, string> = { key:1, value:"Steve" }; // OK
let kv2: KeyPair<number, number> = { key:1, value:12345 };   // OK
```

- As you can see in the above example, by using generic interface as type, we can specify the data type of key and value.

- Generic interface can also be used as the function type.

```typescript
interface KeyValueProcessor<T, U>
{
    (key: T, val: U): void;
};

function processNumKeyPairs(key:number, value:number):void { 
    console.log('processNumKeyPairs: key = ' + key + ', value = ' + value)
}

function processStringKeyPairs(key: number, value:string):void { 
    console.log('processStringKeyPairs: key = '+ key + ', value = ' + value)
}
    
let numKVProcessor: KeyValueProcessor<number, number> = processNumKeyPairs;
numKVProcessor(1, 12345); //Output: processNumKeyPairs: key = 1, value = 12345 

let strKVProcessor: KeyValueProcessor<number, string> = processStringKeyPairs;
strKVProcessor(1, "Bill"); //Output: processStringKeyPairs: key = 1, value = Bill 
```

- The above example can be re-written as below.

```typescript
interface KeyValueProcessor<T, U>
{
    (key: T, val: U): void;
};

function processKeyPairs<T, U>(key:T, value:U):void { 
    console.log(`processKeyPairs: key = ${key}, value = ${value}`)
}

let numKVProcessor: KeyValueProcessor<number, number> = processKeyPairs;
numKVProcessor(1, 12345); //Output: processKeyPairs: key = 1, value = 12345 

let strKVProcessor: KeyValueProcessor<number, string> = processKeyPairs;
strKVProcessor(1, "Bill"); //Output: processKeyPairs: key = 1, value = Bill 
```

- This will remove the need of defining separate functions for different data types.

- The generic interface can also be implemented in the class, same as the non-generic interface, as shown below.

```typescript
interface IKeyValueProcessor<T, U>
{
    process(key: T, val: U): void;
};

class kvProcessor implements IKeyValueProcessor<number, string>
{ 
    process(key:number, val:string):void { 
        console.log(`Key = ${key}, val = ${val}`);
    }
}

let proc: IKeyValueProcessor<number, string> = new kvProcessor();
proc.process(1, 'Bill'); //Output: processKeyPairs: key = 1, value = Bill
```

 - This will force us to implement the method `process()` with number and string parameters.



# Generic Class

- A generic class can have generic fields (member variables) or methods.
- Example

```typescript
class KeyValuePair<T,U>
{ 
    private key: T;
    private val: U; 
    
    setKeyValue(key: T, val: U): void { 
        this.key = key;
        this.val = val;
    }
    
    display():void { 
        console.log(`Key = ${this.key}, val = ${this.val}`);
    }
}

let kvp1 = new KeyValuePair<number, string>();
kvp1.setKeyValue(1, "Steve");
kvp1.display(); //Output: Key = 1, Val = Steve 

let kvp2 = new KayValuePair<string, string>();
kvp2.SetKeyValue("CEO", "Bill"); 
kvp2.display(); //Output: Key = CEO, Val = Bill
```


- The generic class can also implement a generic interface. 
- Consider the following example.

```typescript
interface IKeyValueProcessor<T, U>
{
    process(key: T, val: U): void;
};

class kvProcessor<T, U> implements IKeyValueProcessor<T, U>
{ 
    process(key:T, val:U):void { 
        console.log(`Key = ${key}, val = ${val}`);
    }
}

let proc: IKeyValueProcessor<number, string> = new kvProcessor();
proc.process(1, 'Bill'); //Output: key = 1, value = Bill
```


- In the above example, the generic class `kvProcessor` implements the generic interface `IKeyValueProcessor`.
- It does not specify the type parameters T and U, instead it allows users to set them themselves.
- Thus, `kvProcessor` class can be used with any type of key and value.
- A variable is defined as generic interface type with underlying types for T and U. So, you don't need to set the generic types for `kvProcessor`.
