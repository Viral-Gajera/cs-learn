# Array Method

```Java
import java.util.Arrays;

Arrays.sort(any [])
Arrays.equal(any [], any [])
Arrays.asList(any [])
```

## Arrays.sort()

- Syntax:

```java
Arrays.sort(type[] array)					// Sorting 1D Array
Arrays.sort(type[][] array)					// Sorting 1D Array
    
Arrays.sort(type[] array, comparator)		// Sorting 1D Array
Arrays.sort(type[][] array, comparator)		// Sorting 1D Array
```

- Example    

```Java
class Solution {
	public int myFunct(int[][] points) {
		Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
		return points;
	}
}
```

Note: The comparator function must resturn integer value. 

## Arrays.asList(any [])

- Example:

```Java
class Solution {
	public String mostCommonWord(String paragraph, String[] banned) {
		HashSet<String> bannedSet = new HashSet<>(Arrays.asList(banned));
	}
}
```





