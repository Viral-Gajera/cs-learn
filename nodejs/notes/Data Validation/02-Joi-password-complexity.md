## Joi-password-complexity

- "joi-password-complexity" is a JOI plugin for password complexity validation.
- It allows you to set constraints for the password strength that users must meet when creating an account or changing their password.
- Example :
    
    ```Plain
    const Joi = require("joi");
    const passwordComplexity = require("joi-password-complexity");
    
    const schema = Joi.object({
      password: passwordComplexity({
        min: 8,
        max: 30,
        lowerCase: 1,
        upperCase: 1,
        numeric: 1,
        symbol: 1,
        requirementCount: 4,
      }),
    });
    
    const result = schema.validate({ password: "abcDefg123@" });
    
    console.log(result.error);
    ```
    
- Here are some of the common properties that can be used in the `passwordComplexity()` method of the "joi-password-complexity" plugin:
- The return value of the `passwordComplexity()` is a Joi string with password validation rules.
    - `max`: The maximum length of the password.
    - `lowerCase`: The number of lowercase letters required in the password.
    - `upperCase`: The number of uppercase letters required in the password.
    - `numeric`: The number of numeric characters required in the password.
    - `symbol`: The number of symbols required in the password.
    - `requirementCount`: The total number of constraints (lowercase letters, uppercase letters, numbers, symbols) that the password must meet.
    - `strict`: If set to `true`, the password must meet all the defined constraints. If set to `false`, the password only needs to meet the minimum number of constraints defined by `requirementCount`.
    - `message`: An error message that will be displayed if the password does not meet the defined constraints.