## Local Storage

- In JavaScript, you can access the browser's local storage through the `localStorage` object, which provides a `key-value` pair storage mechanism for web pages.

### Add Items

- To add a value to local storage, you can use the `setItem()` method.
- The `setItem()` method takes two parameters: a key name and a value.
- For example, to add a string value to local storage with the key name "myKey", you can use the following code:
    
    ```Plain
    localStorage.setItem("myKey", "myValue");
    ```
    

### Get Items

- To retrieve the value from local storage, you can use the `getItem()` method.
- The `getItem()` method takes a key name as a parameter and returns the corresponding value.
- For example, to retrieve the value of the "myKey" key, you can use the following code:
    
    ```Plain
    var myValue = localStorage.getItem("myKey");
    ```
    

### Remove Items

- To delete a value from local storage, you can use the `removeItem()` method.
- The `removeItem()` method takes a key name as a parameter and removes the corresponding key-value pair from local storage.
- For example, to delete the "myKey" key, you can use the following code:
    
    ```Plain
    localStorage.removeItem("myKey");
    ```
    

### Check Availability

- It's important to note that local storage is limited to the size and storage capacity of the user's browser. So, it's a good practice to check the availability of local storage before trying to use it. You can do this by checking the `localStorage` object's existence:
    
    ```Plain
    if (typeof(Storage) !== "undefined") {
      // Local storage is available
    } else {
      // Local storage is not available
    }
    ```