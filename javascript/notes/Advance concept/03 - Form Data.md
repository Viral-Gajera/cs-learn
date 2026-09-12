# FormData

- `FormData` is an object in JavaScript that allows you to send data from the client to the server as key-value pairs, similar to the way data is sent from an HTML form.
- It's commonly used in applications that need to send data from a form, along with file attachments such as images or audio files, to a server-side API.
- content-type : `multipart/form-data`
    
    enctype : `multipart/form-data`
    
- Here's how you can use FormData in a simple example:
    
    ```Plain
    // Create a new FormData object
    const formData = new FormData();
    
    
    // Add data to the form
    formData.append("key1", "value1");
    formData.append("key2", "value2");
    
    // Add a file to the form
    const file = document.querySelector("input[type=file]").files[0];
    formData.append("file", file);
    
    // Send the form data to the server
    fetch("/api/upload", {
        method: "POST",
        body: formData
    })
    .then(function(response){
         return response.json()              // In case of json responce from server
         // return responce.formData();      // In case of formData responce from server
    })
    .then(data => {
            console.log("Server response:", data);
     });
    ```
    
    ```Plain
    const multer = require('multer');
    
    // Define storage for files
    const storage = multer.diskStorage({
      destination: (req, file, cb) => {
        if (file.fieldname === 'image') {
          cb(null, './uploads/images/');
        } else if (file.fieldname === 'audio') {
          cb(null, './uploads/audios/');
        } else {
          cb(null, './uploads/');
        }
      },
      filename: (req, file, cb) => {
        cb(null, Date.now() + '-' + file.originalname);
      }
    });
    
    // Define file filter
    const fileFilter = (req, file, cb) => {
      if (file.fieldname === 'image' && file.mimetype.startsWith('image/')) {
        cb(null, true);
      } else if (file.fieldname === 'audio' && file.mimetype.startsWith('audio/')) {
        cb(null, true);
      } else if (file.fieldname === 'string1' || file.fieldname === 'string2') {
        cb(null, true);
      } else {
        cb(new Error('Invalid file type.'));
      }
    };
    
    // Create Multer instance
    const upload = multer({ storage: storage, fileFilter: fileFilter });
    ```