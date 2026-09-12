# fs Module:

- fs module provides mainly three type of API:
    - promises API `fs/promises`
    - callback API `fs`
    - Synchronous API `fs`
    - Common Object:
    - Notes
- every method in the fs module has synchronous, asynchronous as well as promise form.
- To include the File System module, use the `require()` method:
  
    ```Plain
    var fs = require('fs');
    ```
    

## (1) Synchronous & Asynchronous api

- Every asynchronous methods have synchronous version of it, which can be access by append `Sync` to end of the method name.
- Asynchronous methods take the last parameter as the callback function which automatically called on complition of task.
- Callback function has first parameter as `error` value.
- These asynchronous methods returns undefined by default.

### Methods :

### Read

```Plain
fs.readFileSync("path", [option])
// returns the content of file. (option : 'utf-8')

fs.readFile("path", [options], (err, data)=>{})
// second argument of callback is "data", which is content of the file.
```

### Write

```Plain
fs.writeFileSync("path", data, [options]);
// returns undefined.
// data is string/buffer, which needs to be write on file.
// it creates new file if does not exists, replace the content if it already exists.

fs.writeFile("path", data, [options], (err)=>{});
// it creates new file if does not exists, replace the content if it already exists.
```

### Append

```Plain
fs.appendFileSync("path", data, [options]);
// returns undefined.
// append the data to end of file content.

fs.appendFile("path", data, [options], (err)=>{});
// append the data to end of file content.
```

### Copy

```Plain
fs.copyFileSync("src", "dest", [mode]);
// Returns undefined By default, dest is overwritten if it already exists.

fs.copyFile("src", "dest", [mode], (err)=>{})
// Asynchronously copies "src" to "dest".
// By default, dest is overwritten if it already exists.
```

### Rename

```Plain
fs.renameSync("oldPath", "newPath");
// Renames the file from "oldPath" to "newPath" and returns undefined.

fs.rename("oldPath", "newPath", (err)=>{})
// Asynchronously rename file at "oldPath" to the pathname provided as "newPath".
```

### Exists

```Plain
fs.existsSync("path");
// returns true of file exist.

fs.exists(path, (bool)=>{})
// bool is true of file exist.
```

### Remove

```Plain
fs.rmSync("path", [options]);
// Synchronously removes files and directories, and return undefined.

fs.rm("path", [options], (err)=>{})
// Asynchronously removes files and directories
```

### Create-directory

```Plain
fs.mkdirSync("path", [options]);
// creates a directory and Returns undefined.

fs.mkdir("path", [options], (err)=>{})
// Asynchronously creates a directory.
```

### Remove-directory

```Plain
fs.rmdirSync("path", [options]);
// Returns undefined. delete a directory

fs.rmdir("path", [options], (err)=>{})
// Asynchronous delete a directory.
```

## (2) common objects:

Classes :

```Plain
fs.Dir
fs.Dirent
fs.FSWatcher
fs.StartWatcher
fs.ReadStream
fs.States
fs.WriteStream
fs.constants
```

## (3) Notes:

- Ordering of callback and promise-based operations
- File paths
- File descriptors
- Threadpool usage
- File system flags