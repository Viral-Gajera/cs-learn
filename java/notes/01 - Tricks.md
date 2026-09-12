# Call By Value And Call By Reference

**Call By Value:**

- Values of actual parameters are copied to the function’s formal parameters.
- Any changes made inside functions are not reflected in the actual parameters of the caller.
- Java: primitive data type passed as call by value, (byte, short, int, long, float, double, char, boolean)

**Call By Reference:**

- The address of the actual parameters is passed to the function as the formal parameters.
- Any changes made inside the function are actually reflected in the actual parameters of the caller.
- Java: Object & Array passed by reference


- Even thought string passed by reference, any changes made will not be reflected to original string because, it is immutable data structure.
- Any assignment operation done, will not be reflexed to actual parameter, because it changes address (and original address remains as it is). 
# Type Conversion

1. Any Type to String type
```Java
String.valueOf(any type);
```

2. String type to any type    
```Java
Type.valueOf(String s);
```

Example:
```Java
public class Main {
	public static void main(String[] args) {
		// 1. Any type to string type
		String.valueOf(25)
		String.valueOf(25.5f)
		String.valueOf(25.5)
		String.valueOf(true)
		String.valueOf('v')
		
		// 2. String type to any type
		Integer.valueOf("12")
		Float.valueOf("12.5")
		Double.valueOf("12.5")

		Boolean.valueOf("true")
		Character.valueOf("s")		// String to Char conversion not possible
									// use
									// string.charAt(int index)
	}
}
```



# Casting boolean

- `Boolean.valueOf()` only supports `String` and `boolean` as argument

```java
Boolean.valueOf(String s)
Boolean.valueOf(boolean b)
```

- **Casting** an `int` or `double` directly into a `boolean` is not allowed, because Java's type system does not support converting numeric types directly into `boolean`.

```java
boolean b = (boolean) 25;		# error
boolean b = (boolean) 25.13;	# error
```

- However, there are workarounds that allow us to **interpret numbers as `boolean` values** by defining logical rules for the conversion.

```java
boolean b = (25 != 0);
boolean b = (25.13 != 0);
```



# Char to ASCII, and ASCII to Char

```Java
// Char to ASCII Conversion:
char character = 'A';
int asciiValue = (int) character;
System.out.println("The ASCII value of '" + character + "' is: " + asciiValue);

// ASCII to Char Conversion:

int asciiValue = 65;
char character = (char) asciiValue;
System.out.println("The character for ASCII value " + asciiValue + " is: " + character);
```

# Character Comparison

```java
// Problem to count number of lowercase char in string

public class Main {
    public static void main(String[] args) {

        int counter = 0;
        String str = "Hello World";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch > 'a' && ch < 'z') {
                counter++;
            }
        }

        System.out.format("Number of lower case characters : %d ", counter);
    }
}
```



# float Flows

```java
float x = 3.14;		# error
float x = 3.14f;	# 🙂
```



# Bitwise Operation Usage

- Bitwise operator may not apply to float or double.

1. XOR (^)
    - It compares bits of two operands and returns false or `0` if they are equal and returns true or `1` if they are not equal.
    - Eg.
        - Given a non-empty array of integers `nums`, every element appears _twice_ except for one. Find that single one.
        - Swap two numbers without using third variable.

2. And (&) 
   - `n & n-1 == n`



# Format Specifier

- In Java, format specifiers are used with methods like `System.out.printf()` `System.out.format()`, `String.format()`, and `Formatter` to format strings in a specific way.

## Basic Format

The general format of a format specifier is:

```java
%[argument_index$][flags][width][.precision]conversion_character
```

### 1. Argument Index (Optional)

- Specifies which argument should be used for the format specifier.
- Syntax: `n$` where `n` is the argument index (starting from 1).

Example:

```java
System.out.printf("%1$s %2$s", "Hello", "World"); // prints "Hello World"
```

### 2. Flags (Optional)

Flags modify the output format. Some common flags are:

- `-`: Left-justify the output within the specified width.
- `+`: Always include the sign (`+` or `-`) for numerical values.
- `0`: Pad numbers with leading zeros.
- `,`: Include grouping separators (e.g., for large numbers).
- `(`: Enclose negative numbers in parentheses.

Example:

```java
System.out.printf("%+05d", 42); // prints "+0042"
```

### 3. Width (Optional)

- Specifies the minimum number of characters to be output. If the argument's value is shorter than the width, it is padded with spaces (or zeros if the `0` flag is used).

Example:

```java
System.out.printf("%10s", "Java"); // prints "      Java"
```

### 4. Precision (Optional)

- For floating-point numbers, precision controls the number of digits after the decimal point.
- For strings, precision specifies the maximum number of characters to be printed.

Example:

```java
System.out.printf("%.2f", 3.14159); // prints "3.14"
System.out.printf("%.3s", "Hello"); // prints "Hel"
```

### 5. Conversion Characters

Each format specifier ends with a conversion character that specifies the type of data to be formatted.

| Conversion | Description                                             |
| ---------- | ------------------------------------------------------- |
| **`d`**    | Decimal integer (int, long, short, byte)                |
| **`f`**    | Floating-point number (float, double)                   |
| **`e`**    | Scientific notation (float, double)                     |
| **`g`**    | General floating-point (uses `f` or `e` based on value) |
| **`s`**    | String                                                  |
| **`c`**    | Character                                               |
| **`b`**    | Boolean                                                 |
| **`o`**    | Octal integer                                           |
| **`x`**    | Hexadecimal integer                                     |
| **`n`**    | Platform-specific line separator                        |
| **`t`**    | Date/Time (used with Date/Time formatting)              |
| **`%%`**   | Literal `%` symbol                                      |

## Common Examples

1. **Integer Formatting:**

   ```java
   System.out.printf("%d", 123); // prints "123"
   ```

2. **Floating-point Formatting:**

   ```java
   System.out.printf("%.2f", 12.34567); // prints "12.35"
   ```

3. **String Formatting:**

   ```java
   System.out.printf("%s", "Hello"); // prints "Hello"
   ```

4. **Hexadecimal:**

   ```java
   System.out.printf("%x", 255); // prints "ff"
   ```

5. **Boolean:**

   ```java
   System.out.printf("%b", true); // prints "true"
   ```

## Date and Time Conversion (t)

The `t` format is used to format date and time in specific patterns.

| Conversion | Description                  |
| ---------- | ---------------------------- |
| `tH`       | Hour (24-hour)               |
| `tI`       | Hour (12-hour)               |
| `tM`       | Minutes                      |
| `tS`       | Seconds                      |
| `tY`       | Year (4 digits)              |
| `tm`       | Month                        |
| `td`       | Day of the month             |
| `tA`       | Full day name (e.g., Sunday) |
| `tp`       | AM/PM designation            |

Example:

```java
Date date = new Date();
System.out.printf("%tF %tT", date, date); // prints date as "YYYY-MM-DD HH:MM:SS"
```

## Example Combining Specifiers

```java
System.out.printf("%1$s is %2$d years old.", "John", 25); // prints "John is 25 years old."
```
