## Mongoose

```js
let mongoose = require('mongoose');

mongoose.connection("connection-string",[option])
	.then()
	.catch();

let schema = new mongoose.schema({
	id: Number,
    name: String,
    age: Number
});

let myModel = mongoose.model('collectionName', schema);
// collectionName should be lowercase and plural
```

### Creating Documents

```js
//1.
(async ()={
    await myModel.create({
    	id:13,
    	name:"viral",
    	age:20
	})
})();

//2.
(async ()={
    await myModel.insertMany([{},{}])
})();

//3.
(new myModel({
    id:13,
    name:"viral",
	age:20 })
).sava();
```

### Finding document

```js

(async ()={
	//1.
    let result = await myModel.find( {name:"viral"} );

	//2.
	let result = await myModel.findOne( {name:"viral"} );

	//3.
	let result = await myModel.exits( {name:"viral"} );

	//4.
    let result = await myModel.findById("63e651199433c4eeafd5a807")
})();
```

### Update Document

```js
(async ()=>{

    //1.
	await myModel.updateOne({}, {});
    	// arguments:
    	// first object - filter object
    	// second object - new value object

    //2.
    await myModel.updateMany({}, {});
    	// arguments:
    	// first object - filter object
    	// second object - new value object
})();
```

### Deleting Document

```js
(async ()=>{
	//1.
	await myModel.deleteOne({});
    	// arguments:
    	// object - filter object

   	//2.
	await myModel.deleteMany({});
    	// arguments:
    	// object - filter object
})();
```