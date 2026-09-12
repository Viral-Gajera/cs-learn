# HashSet

- Implements [Set Interface](https://www.geeksforgeeks.org/set-in-java/).
- The underlying data structure for HashSet is [Hashtable](https://www.geeksforgeeks.org/hashtable-in-java/).
- Objects that you insert in HashSet are not guaranteed to be inserted in the same order.
- NULL elements are allowed in HashSet.
- Element of HashSet is `unique`.

```Java
Insert	- O(1)
Search	- O(1)
Deleted	- O(1)
```

- HashSet uses HashMap for storing its object internally.
- You must be wondering that to enter a value in `HashMap` we need a key-value pair, but in `HashSet`, we are passing only one value.
- Syntax:

```Java
// Contructor
HashSet()
HashSet(Collection c)
HashSet(int capacity)
HashSet(int capacity, float fillratio)

// Instance Method
hs.size()
hs.add(Object o)
hs.contains(Object o)				boolean
hs.remove(Object o)					Object
```

- Iterate Through HashSet:

```Java
import java.util.HashSet;
import java.util.Iterator;

class Main74 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(4);

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
```

  

# TreeSet

- `TreeSet` is an implementation of the `Set` interface that uses a Red-Black tree data structure internally.
- It ensures uniqueness of elements, meaning it won't allow `duplicates`.
- It maintains the elements in `sorted order` according to their natural ordering or a specified comparator.
- Syntax:

```Java
// Constructor
TreeSet()
TreeSet(Collection c)
TreeSet(Comparator comp)
TreeSet(Sorted s)

// Instance Method
ts.size()
ts.add(Object o)
ts.get(int index)
ts.remove(Object o)					Object
```