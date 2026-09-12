# String Methods

```Java
String.join()
String.format()
```



## String.join() Method

- The join() method is used to join the elements of an array into a string.
- The elements of the string will be separated by a specified separator and its default value is a comma(, ).
- Example:

```Java
String[] names = {"John", "Mary", "Bob"};
String joinedNames = String.join(" - ", names);
System.out.println(joinedNames); // Output: John - Mary - Bob
```



## String.format() Method

- The java string format() method returns the formatted string by given locale, format and arguments.
- If you don't specify the locale in String.format() method, it uses default locale by calling _Locale.getDefault()_ method.
- Syntax:

```Java
public static String format(String format, Object... args)
public static String format(Locale locale, String format, Object... args)

/*
locale	: specifies the locale to be applied on the format() method.
format	: format of the string
args	: arguments for the format string. It may be zero or more.
*/
```


- Format Specifiers :

| Format Specifier | Data Type                                                    | Output                                                                                                                   |
| ---------------- | ------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| %a               | floating point (except _BigDecimal_)                         | Returns Hex output of floating point number.                                                                             |
| %b               | Any type                                                     | "true" if non-null, "false" if null                                                                                      |
| %c               | character                                                    | Unicode character                                                                                                        |
| %d               | integer (incl. byte, short, int, long, bigint)               | Decimal Integer                                                                                                          |
| %e               | floating point                                               | decimal number in scientific notation                                                                                    |
| %f               | floating point                                               | decimal number                                                                                                           |
| %g               | floating point                                               | decimal number, possibly in scientific notation depending on the precision and value.                                    |
| %h               | any type                                                     | Hex String of value from hashCode() method.                                                                              |
| %n               | none                                                         | Platform-specific line separator.                                                                                        |
| %o               | integer (incl. byte, short, int, long, bigint)               | Octal number                                                                                                             |
| %s               | any type                                                     | String value                                                                                                             |
| %t               | Date/Time (incl. long, Calendar, Date and Temporal Accessor) | %t is the prefix for Date/Time conversions. More formatting flags are needed after this. See Date/Time conversion below. |
| %x               | integer (incl. byte, short, int, long, bigint)               | Hex string.                                                                                                              |
