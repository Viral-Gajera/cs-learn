## Custom Method:

- In Mongoose, you can define custom methods on your schema that can be called on instances of your models.
- Custom methods are defined on the schema by using the `.methods` property of the schema object.
- The value of the `.methods` property should be an object where each key represents the name of the method and the value is a function that implements the logic of the method.
- Here's an example of how you might define a custom method on a Mongoose schema :
    
    ```Plain
    const schema = new mongoose.Schema({
      name: {
        type: String,
        required: true
      },
      age: {
        type: Number,
        required: true
      }
    });
    
    // Define a custom method on the schema
    schema.methods.greet = function() {
      return `Hello, my name is ${this.name} and I am ${this.age} years old.`;
    };
    
    const Model = mongoose.model('Model', schema);
    const instance = new Model({ name: 'John', age: 30 });
    
    console.log(instance.greet());
    // Output: Hello, my name is John and I am 30 years old.
    ```
    
- In this example, the `greet` method is defined on the schema and can be called on instances of the `Model` class.
- The `this` keyword in the method refers to the instance on which the method was called, so in this case `this.name` refers to the `name` property of the instance and `this.age` refers to the `age` property of the instance.