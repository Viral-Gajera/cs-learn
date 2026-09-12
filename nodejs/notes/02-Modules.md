#   Modules

- Module can be considered as a block of code that provide a simple or complex functionality, that can communicate with external application.
- Modules can be organized in a single file or a collection of multiple files/folders.
- Types of module:
    - build-in module
    - user defined module
    - third-party module

## 1. Build-in module :

- Built-in modules of node.js that are part of nodejs and come with the Node.js installation, which are known as core modules.
- To include a module, use the `require('module-name')` function with the name of the module.
- `require` is a global variable provided to all your Node.js scripts, so you can use it anywhere you like.
- The return type of `require()` function depends on what the particular module returns.

Example :

```JavaScript
let http = require('http');
let fs = require('fs');
```

  

## 2. User defined module:

- To include a user defined module, use the `require('./module-name.js')` function with the `./module-name` of the module.

### Create Your Own Modules :

- You can create your own modules, and easily include them in your applications.
- we can use `exports` object of `module` object to export the object/property/method from file ( which is used as molude file )
- `exports` keyword is used to make properties and methods available outside the file.
- Example :
  
    > MyModule.js
    
    ```JavaScript
    let ModuleObj = {
        add : function() {
                let result = 0;
                for( let arg of arguments )
                {
                    result += arg;
                }
            return result;
        },
        sub : function() { },
        mul : function() { },
        div : function() { }
    }
    module.exports = ModuleObj;
    ```
    
    > index1.js
    
    ```JavaScript
    let math = require('./MyModule.js');
    console.log(math.add(10,25)); // 35
    ```
    
- you can exclude `module` keyword and assign properties or methods directly to property of export object.
- Example :
  
    ```JavaScript
    exports.add = function()
    {
        let result = 0;
        for( let arg of arguments ){
            result += arg;
        }
        return result;
    };
    ```
    

### **Key Differences**

| Feature       | `module.exports`                                             | `exports`                                        |
| ------------- | ------------------------------------------------------------ | ------------------------------------------------ |
| Type          | It is an **actual object**                                   | It is just a **reference** to `module.exports`   |
| Default Value | `{}` (an empty object)                                       | `{}` (same as `module.exports` initially)        |
| Reassignment  | **Allowed** (you can replace it with a function, object, etc.) | **Not recommended** (as it breaks the reference) |



### Usage Examples

#### ✅ Correct usage of `module.exports`

```js
// myModule.js
function greet(name) {
    return `Hello, ${name}!`;
}
module.exports = greet; // Assign function directly

// index.js
const greet = require('./myModule');
console.log(greet("Viral")); // Output: Hello, Viral!
```

#### ✅ Correct usage of `exports`

```js
// myModule.js
exports.greet = function(name) {
    return `Hello, ${name}!`;
};

// index.js
const myModule = require('./myModule');
console.log(myModule.greet("Viral")); // Output: Hello, Viral!
```

#### ❌ Wrong usage of `exports` (Breaking Reference)

```js
// myModule.js
exports = function(name) { 
    return `Hello, ${name}!`; 
};

// index.js
const myModule = require('./myModule');
console.log(myModule.greet("Viral")); // ❌ TypeError: myModule.greet is not a function
```

**Why?**
Because `exports` was reassigned, breaking its connection to `module.exports`.

### Best Practices

1. Use `module.exports` when exporting a **single function, class, or object**.
2. Use `exports` when adding multiple properties to an object (`exports.greet = ...`).
3. **Do not reassign `exports` directly**, as it will lose the reference to `module.exports`.



## 3. Third Party Modules:

- Modules that are available online and are installed using the "npm" are called third party modules.
- Examples of third party modules are `express`, `mongoose`, etc...