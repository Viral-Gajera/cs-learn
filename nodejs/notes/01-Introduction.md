# Introduction

- Node.js is javascript runtime environment, built on google chrome's V8 engine.
- Node.js uses event-driven, non-blocking i/o model that makes it perfect for data-intensive(i/o intensive) web application.
- Node.js used in data-intensive real-time application. not in cpu intensive web application.

# Features of Node.js

- Asynchronous
- Event-driven [all the task are perform based on event]
- Fast
- Single threaded
- Non buffering [ JavaScript never buffers any data ]

  

## Asynchronous vs synchronous :

- In synchronous operation, we need to wait for a completion of one task before executing next task.
- All the task perform in particular order.
- In asynchronous operation, we can start executing next task before finishing the previous task.
- Task are not perform in particular order.
- one event not depend on other event.

## Non-blocking I/O :

- Non-blocking i/o refers to code that doesn’t block execution of program while performing i/o operation.
- Non-blocking i/o operations allow a single process/thread to serve multiple requests at the same time.
- Ex. node.js program can perform other operation while fetching data from the disk.

  

# Node.js Basic commands:

|   |   |
|---|---|
|command|description|
|Node --version|checking version|
|Node -v|checking version|
|Node fileName.js|executing js file|
|Node|start REPL|

  

# REPL :

- REPL stands for read eval print loop.
- REPT can be started by running `node` command to terminal.

|REPT Command|description|
|---|---|
|underscore|to get the last result.|
|ctrl + c|terminates the current command.|
|ctrl + c twice|terminates the node REPL.|
|up/down key|previous command.|
|tab twice|list of all current command|
|.help|list of all command.|
|.break|exit from muliline command.|
|.clear|exit from muliline command.|
|.save fileName|save the current node REPL session to a file.|
|.load fileName|load file content in current REPL session.|

Example:

```Plain
node let x = 10;
> undefined
```

- Multiple Expression: Node REPL also supports multiline expression, ( ... ) comes automatically when you press enter after opering bracket ( { ).

Example:

```Plain
function f(){
    ... return 10;
    ... }
```

  

# NPM

- npm stands for node package manager.
- npm comes with Node.js installable.

### Functionalities of NPM:

- Command line utility to install node.js package.
- Version/dependency management.

### Global vs Local installation:

- By default, npm installs dependency in the local mode(c.w.d.), locally deployed package accessible via require() method.
- globally installed package are stored in system directory. and cannot be imported using require() method.

### Development dependency:

- devDependencies are the packages, a developer needs during development. but our project does not really depends of these modules.

  

### NPM Basic command:

|command|description|
|---|---|
|npm --version||
|npm -v||
|||
|npm ls [-g]|list of all installed module|
|npm list [-g]|list of all installed module|
|||
|npm init [-y]|create package.json|
|npm install|to retrive node_module folder from package.json|
|||
|npm install <module> [-g]|installing modules|
|npm install <module> <module> [-g]|installing multiple modules (just seperate module name by space)|
|npm install <module>[@x.y.z]|installing specific version of modules|
|npm uninstall <module> [-g]|uninstalling modules.|
|||
|npm outdated [-g]|list of all outdated package|
|npm update <module> [-g]|updating modules|
|||
|npm install <module> [--save-dev]|installing modules in development dependency.|

### NPX :

- npx stands for **Node Package Execute**, it comes with the npm (Node.js).
- It is used to extecute locally installed node package easily.
- Syntax :
  
    ```Plain
    npx your-package-name [command-args]
    ```
    
- npx will check whether or `<package-package-name>` package, exists in `$PATH`, or in the local project binaries, and if so it will execute it.
- Another major advantage is the ability to execute a package that wasn’t previously installed.
  
    Example :
    
    ```Plain
    npx cowsay wow
    ```
    
      
    
    ![[3 4.png|3 4.png]]