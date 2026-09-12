## Moduel : joi

- `joi` is a popular npm module for data validation in Node.js. It provides an easy way to validate data, such as user inputs, payloads, and responses.
- Example :
    
    ```Plain
    const Joi = require("joi");
    
    const schema = Joi.object({
      name: Joi.string().min(3).required(),
      email: Joi.string().email().required(),
      password: Joi.string().pattern(new RegExp("^[a-zA-Z0-9]{3,30}$")).required(),
    });
    
    const validateUser = (user) => {
      const validationResult = schema.validate(user);
      return validationResult;
    };
    
    const user = {
      name: "John",
      email: "john@example.com",
      password: "abc123",
    };
    
    const result = validateUser(user);
    if (result.error) {
      console.error(result.error.message);
    } else {
      console.log("Validation successful");
    }
    ```
    
- Here are some of the common methods and functions provided by Joi:
    
    1. `Joi.object()`: Validates that the input is an object.
    
    - Syntax: `Joi.object({ key: value, ... })`
    - Arguments:
        - `keys(schema)`: Specifies the validation schema for the keys of the object.
        - `required()`: Specifies that the object is required.
    - Return value: A Joi object that can be further modified or used in a validation schema.
        1. `schema.validate(value)`: Validates the input against the validation schema.
    - Syntax: `schema.validate(value)`
    - Arguments:
        - `value`: The input value to be validated.
    - Return value: An object with two properties: `value` and `error`. The `value` property is the input value if the validation is successful. The `error` property is an error object if the validation fails, with information about what went wrong.
        1. `Joi.string()`: Validates that the input is a string.
    - Syntax: `Joi.string()`
    - Arguments:
        - `min(limit)`: Specifies the minimum length of the string.
        - `max(limit)`: Specifies the maximum length of the string.
        - `email()`: Specifies that the string must be a valid email address.
        - `required()`: Specifies that the string is required.
        - `alphanum()`: Specifies that the string must only contain letters and numbers.
        - `lowercase()`: Specifies that the string must be in lowercase.
        - `uppercase()`: Specifies that the string must be in uppercase.
    - Return value: A Joi string object that can be further modified or used in a validation schema.
        1. `Joi.number()`: Validates that the input is a number.
    - Syntax: `Joi.number()`
    - Arguments:
        - `min(limit)`: Specifies the minimum value of the number.
        - `max(limit)`: Specifies the maximum value of the number.
        - `required()`: Specifies that the number is required.
        - `precision(limit)`: Specifies the number of decimal places allowed.
    - Return value: A Joi number object that can be further modified or used in a validation schema.
        1. `Joi.array()`: Validates that the input is an array.
    - Syntax: `Joi.array().items(schema)`
    - Arguments:
        - `items(schema)`: Specifies the validation schema for the items of the array.
        - `required()`: Specifies that the array is required.
    - Return value: A Joi array object that can be further modified or used in a validation schema.