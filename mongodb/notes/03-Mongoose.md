## Mongoose

- Mongoose is an Object Data Modeling (ODM) library for MongoDB and Node.js.
- install mongoose.
```Plain
npm i mongoose
```

- Establish connection. `Mongoose.prototype.connect("connection-string", [option])` method used to create connection with database, which return new promise object.

Example :
```js
let mongoose = require('mongoose');  //

// DATABASE CONNECTION
let DB = "mongodb+srv://Viral-Gajera:<ASSWARD>@cluster0.ifvozh8.mongodb.net/<DBName>?retryWrites=true&w=majority";

mongoose.connect(DB)
	.then(con => {
		console.log(con.connections);
	.catch(err => {
		console.log(err);
	});

// SCHEMA : defines the shape of the documents within that collection.
const mySchema = new mongoose.Schema({
	colName : DataType
});

// Model
const model = mongoose.model('myCollection', mySchema);
// collection name should be lowercase, plural.
```

- Example :    
```js
let mongoose = require('mongoose');

console.log(mongoose instanceof mongoose.Mongoose);
// true

console.log(mongoose.__proto__ === mongoose.Mongoose.prototype);                    // true
console.log(mongoose.__proto__ === mongoose.Mongoose.prototype.Mongoose.prototype);// true
console.log(mongoose.Mongoose.prototype.constructor === mongoose.Mongoose );        // true

console.log(mongoose.Mongoose);                        // [Function: Mongoose]
console.log(mongoose.Mongoose.prototype.Mongoose );    // [Function: Mongoose]
console.log(mongoose.Mongoose === mongoose.Mongoose.prototype.Mongoose);    // true

console.log( mongoose.Mongoose.prototype.__proto__ ); // null

/*  INTERNALLY...
	function Mongoose() {
	}
	Mongoose.prototype.Mongoose = Mongoose;
	module.exports = new Mongoose();
*/
```


### Properties :

```js
Mongoose.prototype.ConnectionStates
Mongoose.prototype.Date
Mongoose.prototype.Decimal128
Mongoose.prototype.Mixed
Mongoose.prototype.Number
Mongoose.prototype.ObjectId
Mongoose.prototype.Promise
Mongoose.prototype.STATES
Mongoose.prototype.SchemaTypes
Mongoose.prototype.Types
Mongoose.prototype.connection
Mongoose.prototype.connections
Mongoose.prototype.driver
Mongoose.prototype.mongo
Mongoose.prototype.mquery
Mongoose.prototype.version
```

### Methods :

```js
Mongoose.prototype.connect(URI, [option-object])        //
Mongoose.prototype.Schema([definition], [options])        // The Mongoose 'Schema' constructor
Mongoose.prototype.Model(doc, [fields], [skipId=false])    // The Mongoose Model constructor.

Mongoose([options])
Mongoose.prototype.Mongoose([options])
Mongoose.prototype.Aggregate()
Mongoose.prototype.CastError()
Mongoose.prototype.Collection()
Mongoose.prototype.Connection()
Mongoose.prototype.Document()
Mongoose.prototype.DocumentProvider()
Mongoose.prototype.Error()
Mongoose.prototype.PromiseProvider()
Mongoose.prototype.Query()
Mongoose.prototype.SchemaType()
Mongoose.prototype.SchemaTypeOptions()
Mongoose.prototype.VirtualType()
Mongoose.prototype.createConnection()
Mongoose.prototype.deleteModel()
Mongoose.prototype.disconnect()
Mongoose.prototype.get()
Mongoose.prototype.isObjectIdOrHexString()
Mongoose.prototype.isValidObjectId()
Mongoose.prototype.model()
Mongoose.prototype.modelNames()
Mongoose.prototype.now()
Mongoose.prototype.overwriteMiddlewareResult()
Mongoose.prototype.plugin()
Mongoose.prototype.pluralize()
Mongoose.prototype.sanitizeFilter()
Mongoose.prototype.set()
Mongoose.prototype.setDriver()
Mongoose.prototype.skipMiddlewareFunction()
Mongoose.prototype.startSession()
Mongoose.prototype.syncIndexes()
Mongoose.prototype.trusted()
```