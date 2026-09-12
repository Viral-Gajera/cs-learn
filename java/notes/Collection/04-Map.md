# HashMap

- HashMap stores the data in `(key, value)` pairs.
- One object is used as a key (index) to another object (value).
- Keys in HashMap is `unique`. Value coresponding to key may be unique or not.
- If you try to insert the duplicate key in HashMap, it will replace the element of the corresponding key.
- The `HashMap` class does not preserve the order of insertion of entries into the map.
- Syntax:

```Java
// Constructor
HashMap()

// Instance Method
m.size()
m.put(Object o, Object o)
m.get(Object o)
m.getOrDefault(Object o, 0);
m.containsKey(Object o)
m.remove(Object o)

m.entrySet()
m.keySet()
```

- Iterate through HashMap

```Java
import java.util.*;

public class Main75 {
    public static void main(String args[]) {
        // Creation
        HashMap<String, Integer> map = new HashMap<>();

        // Insertion
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);

        // Iteration (1)
        for (Map.Entry <String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }
}
```

# Working of Hashmap

- HashMap internally implemented using Array of Linked List.
- HashMap has multiple buckets or bins that contain a head reference to a singly linked list.
- The default size of HashMap is 16 (0 to 15).

![[HashMapStructure-660x545.jpg]]

- `HashMap` is almost similar to Hashtable except that it’s `unsynchronized` and allows at max one null key and multiple null values.
- `HashMap` uses `hashCode()` and `equals()` methods on keys for the `get`and `put`operations.

## hashCode() and equals() Method:

- `equals()`:
    - It checks the equality of two objects. It compares the Key, whether they are equal or not.
- `hashCode()`:
    - This is a hash function, calculates the hash value.
    - The value received from the this method is used to calculate the bucket number.
    - The bucket number is the address of the element inside the map. Hash code of null Key is 0.

  

## Calculating Index

```Java
Index = hashcode(Key) % (N)  	// For example, not fixed

Where N is the size of the array.
```

  

## Reshashing

  

## Time Complexity

```Plain
lambda = n/N
n - total number of nodes
N - total number of buckets

put	-	  	O(lambda)
put - 		O(n) 	# worst case

rehashing -	O(n)
```

  

## Hash Collision

- This is the case when the calculated index value, is the same for two or more Keys.
- equals() method check that both Keys are equal or not.
- If Keys are same, replace the value with the current value. Otherwise, connect this node object to the existing node object through the LinkedList.

  

## Thread

- Java `HashMap` is not thread-safe and hence it should not be used in multithreaded application. For the multi-threaded application, we should use ConcurrentHashMap class.

  

# HashTable

|   |   |   |
|---|---|---|
|Feature|HashMap|Hashtable|
|Thread Safety|Not synchronized by default.|Synchronized, thread-safe by default.|
|Null Keys and Values|Allows one null key and multiple null values.|Does not allow null keys or values.|
|Performance|Generally faster due to non-synchronized nature.|Slower due to synchronization overhead.|
|Iterator|Iterator returned by HashMap is fail-fast.|Enumerator returned by Hashtable is not fail-fast.|
|Inheritance|Inherits from AbstractMap class.|Directly extends Dictionary class (legacy class).|
|Introduced|Introduced in Java 1.2.|Introduced in Java 1.0 (legacy class).|

# TreeMap

- The TreeMap is sorted according to the natural ordering of its keys, or by a [Comparator](https://www.geeksforgeeks.org/comparator-interface-java/) provided at map creation time, depending on which constructor is used.
- A TreeMap is implemented using a Red-Black tree, which is a type of self-balancing binary search tree.
- This provides efficient performance for common operations such as adding, removing, and retrieving elements, with an average time complexity of O(logn).

```Java
// Constructor
TreeMap()
TreeMap(Comparator<? super K> comparator)

// Instance Method
tm.clear()
tm.size()

tm.get(Object key)
tm.firstEntry()
tm.firstKey()
tm.higherEntry(Object key)
tm.higherKey(Object key)
tm.lastEntry()
tm.lastKey()

tm.put(K key, V value)

tm.containsKey(Object o)
tm.containsValue(Object o)

tm.remove(Object key)

tm.entrySet()
```