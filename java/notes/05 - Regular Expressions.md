# Regular Expressions  

- A regular expression is a sequence of characters that forms a search pattern.
- A regular expression can be a single character, or a more complicated pattern.
- Java does not have a built-in Regular Expression class, but we can import the `java.util.regex` package to work with regular expressions. The package includes the following classes:
    - `Pattern` Class - Defines a pattern (to be used in a search)
    - `Matcher` Class - Used to search for the pattern
    - `PatternSyntaxException` Class - Indicates syntax error in a regular expression pattern

  

Example:

```Java
import java.util.regex.*;

public class Main {
	public static void main(String[] args) {
    	Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
    	Matcher matcher = pattern.matcher("Visit W3Schools!");
    	boolean matchFound = matcher.find();
    	if(matchFound) {
      		System.out.println("Match found");
    	} else {
      		System.out.println("Match not found");
    	}
  	}
}
```

## Pattern Class

Static Variables:

```Java
Pattern.CASE_INSENSITIVE
```

Static Methods:

```Java
Pattern.compile(String regex, int flags)	pattern obj
```

Instance Methods:

```Java
pattern.matcher(String text)				      matcher obj
```

## Matcher Class

Instance Methods:

```Java
matcher.find()					             			boolean
```