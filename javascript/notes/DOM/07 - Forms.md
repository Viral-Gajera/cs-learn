# Forms 

# Form validation using HTML

- Making fields required using `required`.
- Constraining the length of data.
    - "minlength", "maxlength" for `text data`.
    - "min" and "max" for `num type`.

- Restricting the type of data using `type`.

```html
<input type="email" name="multiple>
```

- Specifying data patterns using `pattern` attribute.
- Specifies a regex pattern that the entered form data needs to match.

Note: When the input value matches the above validation, it gets assigned a psuedo-class `:valid`, and `:invalid` if it doesn't.

# Form validation using JavaScript :

## Input field :

- properties :

```
value								- used to get or set the value in input field
```

## Radio button :

- properties :

```
checked								- retruns true if radio button is checked.
value								- used to know the value of radio button.
```



## Checkbox :

- properties :

```
checked								- retruns true if radio button is checked.
value								- used to know the value of radio button.
```

## Select & option :

### 1. select

- properties :

```
select.selectedIndex				- returns the `index | -1` of the selected option.
select.value  						- 	
select.multiple						- returns true if the <select> element allows multiple selections
select.options						- retruns the HTMLOptionsCollection of all options inside <select>
```

- The value property of the  `<select>` element depends on the `<option>` element.
  - If an 'option' is selected and has a 'value' attribute, the 'value' property of the 'select box' is the value of the selected option.
  - If an 'option' is selected and has 'no value attribute', the value property of the select box is the 'text of the selected option'.
  - If no option is selected, the value property of the select box is an empty string.


- methods :

```
select.add(option,existingOption)	- adds new option element to the <select> before an existing option
select.remove(index)				- removes an option specified by the index from a <select>
```

### 2. option

- properties :

```
index		- the index of the option inside the collection of options.  
selected	- returns true when the option is selected. You set this property to true to select option.
text		- returns the option’s text.  
value		- returns the HTML value attribute.  
```



## Submitting forms :

- To create a form in HTML, you use the `<form>` element:
- The `<form>` element has two important attributes : action and method.
- JavaScript uses the HTMLFormElement object to represent a form object which has following properties and methods :

```Plain
form.action
form.method
form.elements
form.submit()
form.reset()
```

`document.form:`

- The "document.forms" property returns a collection of forms on the document (HTMLFormControlsCollection)
- To reference a form, you use an index. i.e. document.forms[index]

## Submit

- When you submit the form, the `submit` event is fired before the request is sent to the server.
- This gives you a chance to validate the form data. 
- To stop the form from being submitted, you call the `preventDefault()` method of the event object inside the submit event handler.