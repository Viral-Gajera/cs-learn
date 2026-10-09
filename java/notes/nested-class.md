# Nested Classes in Java

- In Java, it is possible to define a class within another class, such classes are known as **nested** classes.
- They enable you to logically group classes that are only used in one place, thus this increases the use of [encapsulation](https://www.geeksforgeeks.org/encapsulation-in-java/) and creates more readable and maintainable code.
  
    ```Java
    class OuterClass
    {
    ...
        class NestedClass
        {
            ...
        }
    }
    ```
    
- Some of the points to remember about nessted class.
    - The scope of a nested class is bounded by the scope of its enclosing class. Thus in the below example, the class **NestedClass** does not exist independently of the class **OuterClass**.
    - A nested class has access to the members, including private members, of the class in which it is nested. But the enclosing class does not have access to the member of the nested class.
    - A nested class is also a member of its enclosing class.
    - As a member of its enclosing class, a nested class can be declared **private**, **public**, **protected**, or **package-private**(default).
    - Nested classes are divided into two categories:
        1. **static nested class:** Nested classes that are declared **static** are called static nested classes.
        2. **inner class:** An inner class is a non-static nested class.

<img src="Nested Class.png">



## Static Nested Class

- In the case of normal or regular inner classes, without an outer class object existing, there cannot be an inner class object. i.e., an object of the inner class is always strongly associated with an outer class object.
- But in the case of static nested class, Without an outer class object existing, there may be a static nested class object. i.e., an object of a static nested class is not strongly associated with the outer class object.
- a static nested class cannot refer directly to instance variables or methods defined in its enclosing [class.it](http://class.it/) can use them only through an object reference. They are accessed using the enclosing class name.
  
    ```Java
    OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
    ```
    
- Example:
  
    ```Java
    class OuterClass {
        static int static_outer_x = 10;
     	private static int static_outer_private = 30;
    
        int outer_y = 20;
    
        static class StaticNestedClass {
            void display()
            {
                // can access static member of outer class
                System.out.println("static_outer_x = " + static_outer_x);
    
                // can access private static member of outer class
                System.out.println("static_outer_private = " + static_outer_private);
    
                // The following statement will give compilation error as static nested class cannot directly 				 access non-static members.
                // System.out.println("outer_y = " + outer_y);
    
                  // Therefore create object of the outer class to access the non-static member
                  OuterClass out = new OuterClass();
                  System.out.println("outer_y = " + out.outer_y);
            }
        }
    }
    
    // Driver class
    public class StaticNestedClassDemo {
        public static void main(String[] args)
        {
            // accessing a static nested class
            OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
            nestedObject.display();
        }
    }
    ```
    



## Inner classes

- To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within the outer object with this syntax:
- Syntax:
  
    ```Java
    OuterClass.InnerClass innerObject = outerObject.new InnerClass();
    ```
    
- There are two special kinds of inner classes:
    1. Local inner classes
    2. Anonymous inner classes
- Example:
  
    ```Java
    class OuterClass {
        static int static_outer_x = 10;
     	private int static_outer_private = 30;
    
        int outer_y = 20;
    
        class InnerClass {
            void display()
            {
                // can access static member of outer class
                System.out.println("static_outer_x = " + static_outer_x);
    
    			// can also access a private member of the outer class
                System.out.println("outer_private = " + static_outer_private);
    
                // can also access non-static member of outer class
                System.out.println("outer_y = " + outer_y);
            }
        }
    }
    
    public class InnerClassDemo {
        public static void main(String[] args)
        {
            // accessing an inner class
            OuterClass outerObject = new OuterClass();
    
            OuterClass.InnerClass innerObject = outerObject.new InnerClass();
    
            innerObject.display();
        }
    }
    ```