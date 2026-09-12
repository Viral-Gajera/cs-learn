# Multer

- In server side, the `multer` library is used to handle the file received from the client.
- It Provides various Middleware function to deal with FormData.
- Multer adds a `body` object and a `file` or `files` object to the `request` object.
- The `body` object contains the values of the text fields of the form, the `file` or `files` object contains the files uploaded via the form.

## Create Instance of Multer

- It returns instance of `multer`.
- Example :
    
    ```Plain
    const multer = require("multer");
    const upload = multer(optionObject);
    
    optionObject {
        dest : 'string-path',    // Where to store the files
        storage : storage,       // Where to store the files
        fileFilter : fileFilter  // Function to control which files are accepted
        limits : limits,         // Limits of the uploaded data
        preservePath : boolean   // Keep the full path of files instead of just the base name
    }
    ```
    

### Storage :

`1. Disk storage`

- The disk storage engine gives you full control on storing files to disk.
- There are two options available, `destination` and `filename`. They are both functions that determine where the file should be stored.
- `destination` is used to determine within which folder the uploaded files should be stored.
- `filename` is used to determine what the file should be named inside the folder.
- Each function gets passed both the request (`req`) and some information about the file (`file`) to aid with the decision and callback function`cb`.
- Example :
    
    ```Plain
    const storage = multer.diskStorage({
      destination: function (req, file, cb) {
        cb(null, '/tmp/my-uploads')
      },
      filename: function (req, file, cb) {
        const uniqueSuffix = Date.now() + '-' + Math.round(Math.random() * 1E9)
        cb(null, file.fieldname + '-' + uniqueSuffix)
      }
    })
    
    const upload = multer({ storage: storage })
    ```
    

`2. Memory storage`

- The memory storage engine stores the files in memory(ram) as `Buffer` objects. It doesn't have any options.
- Example :
    
    ```Plain
    const storage = multer.memoryStorage()
    const upload = multer({ storage: storage })
    ```
    

### fileFilter :

- Set this to a function to control which files should be uploaded and which should be skipped. The function should look like this
    
    ```Plain
    function fileFilter (req, file, cb) {
    
      // The function should call `cb` with a boolean
      // to indicate if the file should be accepted
    
      // To reject this file pass `false`, like so:
      cb(null, false)
    
      // To accept the file pass `true`, like so:
      cb(null, true)
    
      // You can always pass an error if something goes wrong:
      cb(new Error('I don\\'t have a clue!'))
    
    }
    ```
    
- Example :
    
    ```Plain
    // Define file filter
    // This filter apply to each file in form data.
    const fileFilter = (req, file, cb) => {
        if (file.fieldname === "image1" &&
            file.mimetype.startsWith("image/")
        ) {
            cb(null, true);
        } else if (
            file.fieldname === "audio1" &&
            file.mimetype.startsWith("audio/")
        ) {
            cb(null, true);
        } else if (
            file.fieldname === "string1" ||
            file.fieldname === "string2"
        ) {
            cb(null, false);
        } else {
            cb(new Error("Invalid file type."));
        }
    };
    const storage = multer.memoryStorage();
    
    // Create Multer instance
    const upload = multer({ storage: storage, fileFilter: fileFilter });
    
    
    
    ```
    

### limits :

- An object specifying the size limits of the following optional properties. Multer passes this object into busboy directly, and the details of the properties can be found on [busboy's page](https://github.com/mscdex/busboy#busboy-methods).

## File information

- Each file contains the following information:
    
    |   |   |   |
    |---|---|---|
    |Key|Description|Note|
    |`fieldname`|Field name specified in the form||
    |`originalname`|Name of the file on the user's computer||
    |`encoding`|Encoding type of the file||
    |`mimetype`|Mime type of the file||
    |`size`|Size of the file in bytes||
    |`destination`|The folder to which the file has been saved|`DiskStorage`|
    |`filename`|The name of the file within the `destination`|`DiskStorage`|
    |`path`|The full path to the uploaded file|`DiskStorage`|
    |`buffer`|A `Buffer` of the entire file|`MemoryStorage`|
    

## Middleware functions

- Example :
    
    ```Plain
    const storage = multer.memoryStorage();
    const upload = multer({ storage: storage });
    
    app.post("/api/upload", upload.single("image"), (req, res) => {
     // Your code here to handle the uploaded file
    });
    
    // Other Middleware function :
    
    upload.single("image | audio | file")
    upload.array("images", 10)
    upload.fields([
         {name: "fieldName1", maxCount:1},
         {name: "fieldName2", maxCount:1},
         {name: "fieldName3", maxCount:1},
         {name: "fieldName4", maxCount:1},
    ])
    
    
    ```
    
    ### `.single(fieldname)`
    
    - Accept a single file with the name `fieldname`. The single file will be stored in `req.file`.
    
    ### `.array(fieldname[, maxCount])`
    
    - Accept an array of files, all with the name `fieldname`. Optionally error out if more than `maxCount` files are uploaded. The array of files will be stored in `req.files`.
    
    ### `.fields(fields)`
    
    - Accept a mix of files, specified by `fields`. An object with arrays of files will be stored in `req.files`.
    - `fields` should be an array of objects with `name` and optionally a `maxCount`.
    - Example:
        
        ```Plain
        [
          { name: 'avatar', maxCount: 1 },
          { name: 'gallery', maxCount: 8 }
        ]
        ```
        
    
    ### `.none()`
    
    - Accept only text fields. If any file upload is made, error with code "LIMIT_UNEXPECTED_FILE" will be issued.
    
    ### `.any()`
    
    - Accepts all files that comes over the wire. An array of files will be stored in `req.files`.
    - **WARNING:** Make sure that you always handle the files that a user uploads. Never add multer as a global middleware since a malicious user could upload files to a route that you didn't anticipate. Only use this function on routes where you are handling the uploaded files.

## Examples

### Handling Single File

- The `upload.single("file-name")` middleware is used to handle a single file upload with the name "file-name".
- You can access the uploaded file from the `req.file` property, and the remaining data from the FormData from the `req.body` property.
- Here's an example of how you can access the properties of the uploaded file:
    
    ```Plain
    // for hangling file
    app.post("/api/upload", upload.single("image"), (req, res) => {
      if (req.file.error) {
          return res.status(400).send({ message: req.file.error });
      }
    
      console.log("Original filename:", req.file.originalname);
      console.log("Encoding:", req.file.encoding);
      console.log("Mimetype:", req.file.mimetype);
      console.log("Buffer:", req.file.buffer);
    });
    
    // for handling audio file
    app.post('/upload', upload.single('audio'), (req, res) => {
      console.log(req.file);
      res.send('Audio uploaded successfully');
    });
    
    // for hangling string
    // string data can be accessed through req.body
    app.post('/api/upload', (req, res) => {
        console.log(req.body);
        res.send('String uploaded successfully');
    });
    ```
    

### Handling Multiple files

- Multer provides a `upload.array` function that allows you to handle the processing of multiple file uploads in a single request.
- The function takes two arguments: the name of the file input field in the HTML form, and the maximum number of files that should be processed.
- Here's an example:
    
    ```Plain
    app.post("/api/upload", upload.array("images", 10), (req, res) => {
      req.files.forEach(file => {
        if (file.error) {
          return res.status(400).send({ message: file.error });
        }
    
        console.log("Original filename:", file.originalname);
        console.log("Encoding:", file.encoding);
        console.log("Mimetype:", file.mimetype);
        console.log("Buffer:", file.buffer);
      });
    });
    ```
    

### Store Data into local file system

- `multer` also can store data on local file system.
    
    ```Plain
    const express = require("express");
    const multer = require("multer");
    const app = express();
    
    const storage = multer.diskStorage({
      destination: function (req, file, cb) {
        cb(null, "uploads/");
      },
      filename: function (req, file, cb) {
        cb(null, file.fieldname + "-" + Date.now());
      }
    });
    
    const upload = multer({storage: storage});
    
    app.use(express.json());
    
    app.post("/api/upload", upload.single("file"), (req, res) => {
      const file = req.file;
      const data = req.body;
    
      // Do something with the data and file
    
      res.send({ message: "Data and file received!" });
    });
    
    app.listen(3000)
    ```
    
- Here `cb` is callback function.
- Another Example :