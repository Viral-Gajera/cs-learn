# Css Variables
  

A good way to use css variables is when it comes to the color of your design, Instead of copy and paste the same color over and over again, you can place them in variable.

# var() Function

- The `var()` function is used to insert the value of a CSS variable.
- The syntax of the `var()` function is as follows:
    
    ```CSS
    var(--name, value)
    ```
    

  

- **Note:** The variable name must begin with two dashes (--) and it is case sensitive!

# Creating variable

- First of all: CSS variables can have a global or local scope.
- Global variables can be accessed/used through the entire document, while local variables can be used only inside the selector where it is declared.

## 1. Global Variable

- To create a variable with global scope, declare it inside the `:root` selector. The `:root` selector matches the document's root element.
- Example:
    
    ```CSS
    :root {
      --blue: \#1e90ff;
      --white: \#ffffff;
    }
    
    body { background-color: var(--blue); }
    ```
    

## 2. Local Variable

- To create a variable with global scope, declare it inside the the selector that is going to use it.
- Example:
    
    ```Plain
    body{
    	--color : rgb(55, 205, 255);
    	background-color : var(--color);
    }
    ```