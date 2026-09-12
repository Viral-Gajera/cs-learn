# ArrayList

- Using ArrayList class, we can use dynamic array in java.
- The dynamic Array is an array in which the array size is not fixed in advance, Therefore we can change the size of an array at run time.

```Java
// Constructor
ArrayList()
ArrayList(Collection c)
ArrayList(int capacity)

// Instance Methods
al.size()
al.add(Object o)
al.add(int index, Object o)
al.get(int index)
al.set(int index, Object o)
al.indexOf(Object o)
al.remove(Object o)				Object
al.remove(int index)			Object
```

Example:

```Java
import java.util.*;

public class Main10 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list);

        list.remove("C");
        list.remove(0);
        System.out.println(list);

        System.out.println(list.size());
    }
}
```

  

# LinkedList

- LinkedList implemenets List interface.

```Java
// Constructor
LinkedList()
LinkedList(Collection c)

// Instance Methods

ll.size()
ll.clear()

ll.add(Object o)					// end of this list
ll.add(int index, E element)
ll.addFirst(Object o)
ll.addLast(Object o)

ll.get(int index)
ll.getFirst()
ll.getLast()

ll.contains(Object o)
ll.indexOf(Object o)

ll.remove()							// first element
ll.remove(Object o)					// first occurrence
ll.remove(int index)
ll.removeFirst()
ll.removeLast()
```

  

# Vector

- The Vector class implements a growable array of objects.

```Java
// Constructor
Vector()
Vector(Collection c)
Vector(int capacity)

// Instance Method
v.size()
v.add(Object o)
v.add(int index, Object o)
v.get(int index)
v.set(int index, Object o)
v.indexOf(Object o)
v.remove(Object o)					Object
v.remove(int index)					Object
```

Example:

```Java
import java.util.*;

public class Main12 {
    public static void main(String[] args) {
        Vector<String> list = new Vector<String>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list);

        list.remove(1);
        list.remove("D");
        System.out.println(list);
    }
}
```

  

# Stack

- Stack Extends vector class.

```Java
// Constructor
Stack()

// Instance Method
s.empty()			// boolean
s.peek()
s.pop()
s.push(Object o)
s.search(Object o)
```