# Priority Queue

- A priority queue is a data structure that maintains the order of its elements based on their natural order or according to a specified comparator.
- The elements in a priority queue are ordered by their priority, and the element with the highest priority is served before others.

```Java
// Constructors
PriorityQueue()
PriorityQueue(Collection<? extends E> c)
PriorityQueue(int initialCapacity)
PriorityQueue(int initialCapacity, Comparator<? super E> comparator)

// Instance Methods
pq.size()
pq.clear()
pq.isEmpty()
    
pq.add(E element)
pq.offer(E element)

pq.peek()
pq.contains(Object o)
    
pq.remove()
pq.poll()

pq.toArray()
```

- Example:

```Java
import java.util.*;

public class Main11 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(3);
        pq.offer(1);
        pq.offer(2);

        System.out.println(pq.peek()); // Output: 1 - do not delete
        System.out.println(pq.poll()); // Output: 1 - delete min
        System.out.println(pq.size()); // Output: 2
    }
}
```

- Example:

```Java
import java.util.*;

public class DescendingPriorityQueueExample {
    public static void main(String[] args) {
        // Creating a descending priority queue with a custom comparator
        PriorityQueue<Integer> descendingPQ = new PriorityQueue<>(Collections.reverseOrder());

        // Adding elements to the descending priority queue
        descendingPQ.offer(3);
        descendingPQ.offer(1);
        descendingPQ.offer(2);

        // Polling elements from the descending priority queue
        while (!descendingPQ.isEmpty()) {
            System.out.println(descendingPQ.poll());
        }
    }
}

// Output:
3
2
1
```