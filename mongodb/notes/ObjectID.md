## ObjectID

- By default, Mongoose adds an `_id` property to your schemas.
- When you create a new document with the automatically added `_id` property, Mongoose creates a new [`_id`](https://masteringjs.io/tutorials/mongoose/objectid) [of type ObjectId](https://masteringjs.io/tutorials/mongoose/objectid) to your document.
    
    ```Plain
    const Model = mongoose.model('Test', schema);
    
    const doc = new Model();
    doc._id instanceof mongoose.Types.ObjectId; // true
    ```
    
- You can also overwrite Mongoose's default `_id` with your own `_id`.
    
    ```Plain
    const schema = new Schema({ _id: Number });
    const Model = mongoose.model('Test', schema);
    
    const doc = new Model();
    await doc.save(); // Throws "document must have an _id before saving"
    
    doc._id = 1;
    await doc.save(); // works
    ```
    
- To reference other schema's id properties in Mongoose, you can use the `ObjectId` type along with the `ref` property to specify the referenced `model`.
- Here's an example of a User schema that has an array of email addresses, each of which is a separate document in the Email schema:
    
    ```Plain
    const mongoose = require('mongoose');
    const Schema = mongoose.Schema;
    const ObjectId = mongoose.Types.ObjectId;
    
    const UserSchema = new Schema({
      name: {
        type: String,
        required: true
      },
      emailAddresses: [{
        type: ObjectId,
        ref: 'Email'
      }]
    });
    
    const EmailSchema = new Schema({
    	email: {
        	type: String,
        	required: true,
        	unique: true
    	},
      	user: {
        	type: ObjectId,
        	ref: 'User',
        	required: true
    	}
    });
    
    const User = mongoose.model('User', UserSchema);
    const Email = mongoose.model('Email', EmailSchema);
    ```