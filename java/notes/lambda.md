# Lambda Expression

- A lambda expression is a short block of code which takes in parameters and returns a value.
- Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
- Syntax:

```Java
parameter -> expression
(parameter1, parameter2) -> expression
(parameter1, parameter2) -> { code block }
```

- Expressions are limited. They have to immediately return a value, and they cannot contain variables, assignments or statements such as `if` or `for`.
- In order to do more complex operations, a code block can be used with curly braces. If the lambda expression needs to return a value, then the code block should have a `return` statement.



**Functional Interfaces :**

- Lambda expressions are commonly used with functional interfaces, which are interfaces that contain only a single abstract method.
- These interfaces can be used with lambda expressions, allowing concise representation of the method implementations.
- For Instance,

```Java
interface MyInterface {
	void myMethod(int a);
}

// This interface MyInterface has a single method myMethod.
// A lambda expression implementing this interface could be written as:

MyInterface ref = (int a) -> {
	// code implementing myMethod
	// using parameter 'a'
};
```

- Here, the lambda expression `(int a) -> { /* code */ }` acts as an implementation of the `myMethod` defined in `MyInterface`.
- Lambda expressions can be stored in variables if the variable's type is an interface which has only one method.
- The lambda expression should have the same number of parameters and the same return type as that method.
- Java has many of these kinds of interfaces built in, such as the `Consumer` interface (found in the `java.util` package) used by lists.

- Example :

```Java
// Defining a functional interface with a method for adding two numbers
interface AddInterface {
	int add(int a, int b);
}

public class Main {
	public static void main(String[] args) {
		// Lambda expression to add two numbers
		AddInterface addFunction = (int x, int y) -> x + y;

		// Using the lambda expression to add two numbers
		int result = addFunction.add(5, 3);
		System.out.println("Sum: " + result); // Output: Sum: 8
	}
}
```

- Example :

```Java
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
	ArrayList<Integer> numbers = new ArrayList<Integer>();
	numbers.add(5);
	numbers.add(9);
	numbers.add(8);
	numbers.add(1);
	numbers.forEach( (n) -> { System.out.println(n); } );
  }
}
```





