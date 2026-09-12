## Schema

- Everything in Mongoose starts with a Schema.
- Defines the shape of the documents within that collection.
    
    Example :
    
    `mongoose.Schema() constructor` returns new Schema object.
    
    ```Plain
    let mongoose = require('mongoose');
    
    // CONNECTION
    mongoose.connect("connection string");
    
    // SCHEMA
    let mySchema = new mongoose.Schema({
    
        id: Number,
        name: String,            // String is shorthand for {type: String}
        varified: Boolean,
        age : {
            type : Number,
            default : 18,
            required : true,
            // required : [true, "Error Msg"],
            // unique : true | false,
            // immutable : true | false,
            // minLength : num,
            // maxLength : num,
            // min : num,
            // max : num
        },
    
        createdAt: {
            type: Date,
            default: Date.now    // Date.now function called is value id not specified.
        },
        updatedAt : Data,
    
        bestfriend : mongoose.Type.ObjectId,
    
        marks: [{
            Semister: Number,
            Subject1: Number,
            Subject1: Number,
            Subject1: Number  }],
                                // array of object having sem and sub property.
    
        hobbie : [String],        // array of Strings.
    
        address : {
            street: String,
            city: String,
            zipcode: Number
          }
    });
    ```
    
- If you want to add additional keys later, use the `Schema.prototype.add()` method.
- Each key in our code `Schema` defines a property in our documents which will be cast to its associated `SchemaType`.
- Keys may also be assigned nested objects containing further key/type definitions. This will happen whenever a key's value is a POJO that doesn't have a `type` property.
- The permitted SchemaTypes are :
    
    ```Plain
    String
    Number
    Boolean
    Array
    Date
    Map
    Buffer
    Decimal128
    Mixed
    ObjectId
    ```