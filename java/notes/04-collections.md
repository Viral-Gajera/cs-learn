# Collections

## Tricks to Remember Colleaction

```
- ArrayList, Vector, Stack, LinkedList
- ArrayDeque, PriorityQueue, LinkedList
- HashSet, TreeSet, LinkedHashSet
- HashMap, TreeMap, LinkedHashMap
```

## Tricks to Remember Method

```
Methods Order Convension:

Select operations
Insert operations
Update operations
Delete operations
Other operations
```

## Short Note

### Linear Data Structures

#### List Implementations (4)

##### ArrayList - Resizable array implementation

```java
// Select operations
al.size()
al.get(int index)
al.contains(Object o)
al.indexOf(Object o)

// Insert operations
al.add(Object o)
al.add(int index, Object o)

// Update operations
al.set(int index, Object o)

// Delete operations
al.remove(Object o)
al.remove(int index)

// Other operations
al.sort((a, b)->{return (int) (b - a);});

Integer[] arr = new Integer[al.size()];
arr = al.toArray(arr);				// ArrayList to Array conversion
```

##### Vector - Synchronized resizable array (legacy)

```java
// Select operations
v.size()
v.get(int index)
v.contains(Object o)
v.indexOf(Object o)

// Insert operations
v.add(Object o)
v.add(int index, Object o)

// Update operations
v.set(int index, Object o)

// Delete operations
v.remove(Object o)				// Object
v.remove(int index)				// Object
```

##### Stack - LIFO stack extending Vector (legacy)

```java
// Select operations
s.size()
s.empty()					// boolean
s.peek()
s.search(Object o)

// Insert operations
s.push(Object o)

// Update operations
// (N/A)

// Delete operations
s.pop()
```

##### LinkedList - Doubly-linked list implementation

```java
// Select operations
ll.size()
ll.get(int index)
ll.getFirst()
ll.getLast()
ll.contains(Object o)
ll.indexOf(Object o)

// Insert operations
ll.add(Object o)
ll.add(int index, E element)   // end of this list
ll.addFirst(Object o)
ll.addLast(Object o)

// Update operations
ll.set(index, element)

// Delete operations
ll.remove()					           // first element
ll.remove(Object o)				     // first occurrence
ll.remove(int index)
ll.removeFirst()
ll.removeLast()
ll.clear()
```

#### Queue/Deque Implementations

##### ArrayDeque - Resizable array implementation of Deque

```java
// Select operations
ad.size()
ad.isEmpty()					    // boolean

ad.getFirst()					// throws exception if empty
ad.getLast()					// throws exception if empty
ad.peek()					    // first element, null if empty
ad.peekFirst()				// first element, null if empty
ad.peekLast()					// last element, null if empty

ad.contains(Object o)				// boolean

// Insert operations
ad.add(Object o)				  // end (same as addLast)
ad.addFirst(Object o)
ad.addLast(Object o)
ad.offer(Object o)				// end (same as offerLast)
ad.offerFirst(Object o)
ad.offerLast(Object o)
ad.push(Object o)			// same as addFirst

// Update operations
// (N/A)

// Delete operations
ad.remove()					  // first element, throws exception if empty
ad.removeFirst()			// throws exception if empty
ad.removeLast()				// throws exception if empty
ad.poll()					    // first element, null if empty
ad.pollFirst()				// first element, null if empty
ad.pollLast()					// last element, null if empty
ad.remove(Object o)		// first occurrence, boolean
ad.pop()					    // same as removeFirst
ad.clear()

// Stack-like operations (LIFO)
ad.push(Object o)			// same as addFirst
ad.pop()					    // same as removeFirst

// Queue-like operations (FIFO)
// add() -> addLast(), poll() -> pollFirst()

// Iteration
Iterator<Integer> it = ad.iterator();		          // forward iterator
Iterator<Integer> dit = ad.descendingIterator();	// reverse iterator

while (it.hasNext()) {
    System.out.println(it.next());
}

// Convert to Array
Object[] arr = ad.toArray();
Integer[] arr2 = new Integer[ad.size()];
arr2 = ad.toArray(arr2);

// Enhanced for loop
for (Integer element : ad) {
    System.out.println(element);
}
```

##### PriorityQueue - Heap-based priority queue

```java
// Select operations
pq.size()
pq.isEmpty()					    // boolean

pq.peek()					        // head element (min/max), null if empty
pq.element()					    // head element (min/max), throws exception if empty

pq.contains(Object o)			// boolean

// Insert operations
pq.add(Object o)				  // boolean, throws exception on failure
pq.offer(Object o)				// boolean, returns false on failure (same as add for PriorityQueue)

// Bulk operations
Collection<Integer> col = Arrays.asList(5, 2, 8, 1, 9);
pq.addAll(col);					// boolean

// Update operations
// (N/A)

// Delete operations
pq.poll()					        // removes and returns head, null if empty
pq.remove()					      // removes and returns head, throws exception if empty
pq.remove(Object o)				// removes first occurrence, boolean
pq.clear()

// Other operations

// Convert to Array
Object[] arr = pq.toArray();
Integer[] arr2 = new Integer[pq.size()];
arr2 = pq.toArray(arr2);

// Constructors with Comparator
PriorityQueue<Integer> minHeap = new PriorityQueue<>();				                    // natural order (min heap)
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());	// max heap
PriorityQueue<Integer> customHeap = new PriorityQueue<>((a, b) -> b - a);		      // custom comparator (max heap)

// Custom objects with Comparator
PriorityQueue<String> pqStr = new PriorityQueue<>((a, b) -> a.length() - b.length());	// by string length

// Iteration (NOT in priority order - use poll() for ordered access)
Iterator<Integer> it = pq.iterator();
while (it.hasNext()) {
    System.out.println(it.next());		// unordered iteration
}

// Enhanced for loop (NOT in priority order)
for (Integer element : pq) {
    System.out.println(element);		  // unordered iteration
}

// To get elements in priority order
while (!pq.isEmpty()) {
    System.out.println(pq.poll());		// ordered by priority
}
```

##### LinkedList - Also implements Deque interface

### Non-Linear Data Structures

#### Set Implementations

##### HashSet - Hashtable implementation

```java
// Select operations
hs.size()
hs.contains(Object o)				// boolean

// Insert operations
hs.add(Object o)

// Update operations
// (N/A)

// Delete operations
hs.remove(Object o)			   	// Object

// Other operations
Iterator<Integer> it = set.iterator();

while (it.hasNext()) {
    System.out.println(it.next());
}
```

##### TreeSet - Red-black tree implementation (NavigableSet + SortedSet)

```java
// Select operations
ts.size()
ts.first()
ts.last()
ts.contains(Object o)

// Insert operations
ts.add(E e)

// Update operations
// (N/A)

// Delete operations
ts.remove(Object o)
ts.pollFirst()
ts.pollLast()
```

##### LinkedHashSet - Hash table with linked list (maintains insertion order)

```java
// Select operations
lhs.size()
lhs.isEmpty()					        // boolean
lhs.contains(Object o)				// boolean
lhs.containsAll(col);			 	// boolean

// Insert operations
lhs.add(Object o)				      // boolean, returns false if already exists
lhs.addAll(col);				    // boolean

// Update operations
// (N/A)

// Delete operations
lhs.remove(Object o)				  // boolean, returns true if element was present
lhs.removeAll(col);				  // boolean
lhs.retainAll(col);				  // boolean, keeps only elements in col
lhs.clear()

// Other operations

// Iteration (maintains insertion order)
Iterator<Integer> it = lhs.iterator();
while (it.hasNext()) {
    System.out.println(it.next());		// in insertion order
}

// Enhanced for loop (maintains insertion order)
for (Integer element : lhs) {
    System.out.println(element);		  // in insertion order
}

// Convert to Array
Object[] arr = lhs.toArray();
Integer[] arr2 = new Integer[lhs.size()];
arr2 = lhs.toArray(arr2);

// Bulk operations
Collection<Integer> col = Arrays.asList(1, 2, 3, 4, 5);

// Set operations
LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
LinkedHashSet<Integer> set2 = new LinkedHashSet<>();

// Union
LinkedHashSet<Integer> union = new LinkedHashSet<>(set1);
union.addAll(set2);

// Intersection
LinkedHashSet<Integer> intersection = new LinkedHashSet<>(set1);
intersection.retainAll(set2);

// Difference
LinkedHashSet<Integer> difference = new LinkedHashSet<>(set1);
difference.removeAll(set2);

// Convert from Array/List
Integer[] array = {1, 2, 3, 2, 4, 1};		// duplicates will be removed
LinkedHashSet<Integer> fromArray = new LinkedHashSet<>(Arrays.asList(array));

List<Integer> list = Arrays.asList(5, 6, 7, 5, 8, 6);
LinkedHashSet<Integer> fromList = new LinkedHashSet<>(list);
```

#### Map Implementations

##### HashMap - Hash table implementation

```java
// Select operations
hm.size()
hm.get(Object o)
hm.getOrDefault(Object o, 0)
hm.containsKey(Object o)

hm.entrySet()
hm.keySet()
e.getKey()
e.getValue()

// Insert operations
hm.put(Object o, Object o)

// Update operations
// put can also update an existing key

// Delete operations
hm.remove(Object o)

for (Map.Entry <String,Integer> e : map.entrySet()) {
    System.out.println(e.getKey());
    System.out.println(e.getValue());
}
```

##### TreeMap - Red-black tree implementation (NavigableSet + SortedSet)

```java
// Select operations
tm.size()
tm.isEmpty()					                            // boolean
tm.get(Object key)				                        // Object (value or null)
tm.getOrDefault(Object key, Object defaultValue)	// Object
tm.containsKey(Object key)			                   // boolean
tm.containsValue(Object value)			               // boolean
tm.keySet()					        // Set<K>
tm.values()					        // Collection<V>
tm.entrySet()					      // Set<Map.Entry<K,V>>
tm.firstKey()					        // K (throws exception if empty)
tm.lastKey()					        // K (throws exception if empty)
tm.firstEntry()					      // Map.Entry<K,V> (null if empty)
tm.lastEntry()					      // Map.Entry<K,V> (null if empty)
tm.lowerKey(Object key)				        // K (greatest key < given key)
tm.higherKey(Object key)			        // K (smallest key > given key)
tm.floorKey(Object key)				        // K (greatest key <= given key)
tm.ceilingKey(Object key)			        // K (smallest key >= given key)
tm.lowerEntry(Object key)			        // Map.Entry<K,V>
tm.higherEntry(Object key)			      // Map.Entry<K,V>
tm.floorEntry(Object key)			        // Map.Entry<K,V>
tm.ceilingEntry(Object key)			      // Map.Entry<K,V>

// Insert operations
tm.put(Object key, Object value)		              // Object (previous value or null)
tm.putAll(Map m)				                          // void
tm.putIfAbsent(Object key, Object value)	        // Object (existing value or null)

// Update operations
tm.replace(Object key, Object value)		                  // Object (previous value or null)
tm.replace(Object key, Object oldValue, Object newValue)	// boolean
tm.compute(Object key, (k, v) -> v == null ? 1 : v + 1);		      // Object
tm.computeIfAbsent(Object key, k -> new ArrayList<>());		        // Object
tm.computeIfPresent(Object key, (k, v) -> v + "_updated");		    // Object
tm.merge(Object key, Object value, (oldVal, newVal) -> oldVal + newVal);	// Object
tm.replaceAll((key, value) -> value * 2);

// Delete operations
tm.remove(Object key)				                       // Object (removed value or null)
tm.remove(Object key, Object value)		             // boolean (removes only if key maps to value)
tm.pollFirstEntry()				        // Map.Entry<K,V> (removes and returns)
tm.pollLastEntry()				        // Map.Entry<K,V> (removes and returns)
tm.clear()

// Other operations

// SubMap operations
tm.subMap(Object fromKey, Object toKey)		                                          // SortedMap<K,V> (fromKey inclusive, toKey exclusive)
tm.subMap(Object fromKey, boolean fromInclusive, Object toKey, boolean toInclusive)	// NavigableMap<K,V>
tm.headMap(Object toKey)			                                                      // SortedMap<K,V> (keys < toKey)
tm.headMap(Object toKey, boolean inclusive)	                                        // NavigableMap<K,V>
tm.tailMap(Object fromKey)			                                                    // SortedMap<K,V> (keys >= fromKey)
tm.tailMap(Object fromKey, boolean inclusive)	                                      // NavigableMap<K,V>

// Descending views
tm.descendingMap()				          // NavigableMap<K,V>
tm.descendingKeySet()				        // NavigableSet<K>
tm.navigableKeySet()				        // NavigableSet<K>

// Comparator
tm.comparator()					            // Comparator<? super K> (null for natural ordering)

// Iteration - maintains sorted order
for (Map.Entry<String, Integer> entry : tm.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

// Key iteration (sorted order)
for (String key : tm.keySet()) {
    System.out.println(key + " = " + tm.get(key));
}

// Reverse iteration
for (Map.Entry<String, Integer> entry : tm.descendingMap().entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

// Constructor variants
TreeMap<String, Integer> naturalOrder = new TreeMap<>();			                            // natural ordering
TreeMap<String, Integer> reverseOrder = new TreeMap<>(Collections.reverseOrder());	      // reverse order
TreeMap<String, Integer> customOrder = new TreeMap<>((a, b) -> a.length() - b.length());	// custom comparator
TreeMap<String, Integer> fromMap = new TreeMap<>(existingMap);		                        // copy constructor

// Stream operations (Java 8+)
tm.forEach((key, value) -> System.out.println(key + " = " + value));

// Range operations example
TreeMap<Integer, String> numbers = new TreeMap<>();
numbers.put(1, "One"); numbers.put(5, "Five"); numbers.put(10, "Ten");

SortedMap<Integer, String> range = numbers.subMap(2, 8);		        // keys: 5
NavigableMap<Integer, String> rangeInclusive = numbers.subMap(1, true, 10, true);	// keys: 1, 5, 10
```

##### LinkedHashMap - Hash table with linked list (maintains insertion/access order)

```java
// Select operations
lhm.size()
lhm.isEmpty()					                    // boolean
lhm.get(Object key)				                        // Object (value or null)
lhm.getOrDefault(Object key, Object defaultValue)	// Object
lhm.containsKey(Object key)			    // boolean
lhm.containsValue(Object value)			// boolean
lhm.keySet()					// Set<K>
lhm.values()					// Collection<V>
lhm.entrySet()				// Set<Map.Entry<K,V>>

// Insert operations
lhm.put(Object key, Object value)		      // Object (previous value or null)
lhm.putAll(Map m)				                  // void
lhm.putIfAbsent(Object key, Object value)	// Object (existing value or null)

// Update operations
lhm.replace(Object key, Object value)		                  // Object (previous value or null)
lhm.replace(Object key, Object oldValue, Object newValue)	// boolean
lhm.compute(Object key, (k, v) -> v == null ? 1 : v + 1);	  	            // Object
lhm.computeIfAbsent(Object key, k -> new ArrayList<>());		              // Object
lhm.computeIfPresent(Object key, (k, v) -> v + "_updated");		            // Object
lhm.merge(Object key, Object value, (oldVal, newVal) -> oldVal + newVal);	// Object
lhm.replaceAll((key, value) -> value * 2);

// Delete operations
lhm.remove(Object key)				          // Object (removed value or null)
lhm.remove(Object key, Object value)		// boolean (removes only if key maps to value)
lhm.clear()

// Other operations

// Iteration - maintains insertion order (or access order if configured)
for (Map.Entry<String, Integer> entry : lhm.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

// Key iteration
for (String key : lhm.keySet()) {
    System.out.println(key + " = " + lhm.get(key));
}

// Value iteration
for (Integer value : lhm.values()) {
    System.out.println(value);
}

// Iterator approach
Iterator<Map.Entry<String, Integer>> it = lhm.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry<String, Integer> entry = it.next();
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

// Constructor variants
LinkedHashMap<String, Integer> insertionOrder = new LinkedHashMap<>();				// insertion order
LinkedHashMap<String, Integer> accessOrder = new LinkedHashMap<>(16, 0.75f, true);		// access order (LRU)

// LRU Cache implementation with access order
LinkedHashMap<String, Integer> lruCache = new LinkedHashMap<String, Integer>(16, 0.75f, true) {
    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return size() > 10;		// Remove eldest when size > 10
    }
};

// Bulk operations
Map<String, Integer> otherMap = new HashMap<>();
lhm.putAll(otherMap);

// Convert to other collections
Set<String> keys = new HashSet<>(lhm.keySet());
List<Integer> values = new ArrayList<>(lhm.values());

// Stream operations (Java 8+)
lhm.forEach((key, value) -> System.out.println(key + " = " + value));
```

#### Specialized Collections

##### EnumSet

##### EnumMap

##### BitSet - Vector of bits that grows dynamically

##### Collections - Utility class that provides static methods and wrapper classes

```java
// Note: Collections is a utility class with static methods only

// Sorting operations
Collections.sort(List list)			                    // void (natural ordering)
Collections.sort(List list, Comparator c)	          // void (custom comparator)
Collections.reverse(List list)			                // void
Collections.shuffle(List list)			                // void (random order)
Collections.shuffle(List list, Random rnd)	        // void (with specific Random)

// Searching operations
Collections.binarySearch(List list, Object key)	              // int (index or negative insertion point)
Collections.binarySearch(List list, Object key, Comparator c)	// int
Collections.min(Collection coll)		                          // Object (natural ordering)
Collections.min(Collection coll, Comparator c)	              // Object (custom comparator)
Collections.max(Collection coll)		                          // Object (natural ordering)
Collections.max(Collection coll, Comparator c)	              // Object (custom comparator)

// Rotation and swapping
Collections.rotate(List list, int distance)	        // void (rotate elements)
Collections.swap(List list, int i, int j)	          // void (swap elements at indices)

// Filling and replacing
Collections.fill(List list, Object obj)	                        // void (replace all elements)
Collections.replaceAll(List list, Object oldVal, Object newVal)	// boolean
Collections.copy(List dest, List src)		                        // void (dest must be >= src size)

// Frequency and disjoint
Collections.frequency(Collection c, Object o)	         // int (count occurrences)
Collections.disjoint(Collection c1, Collection c2)     // boolean (no common elements)

// Add multiple elements
Collections.addAll(Collection c, Object... elements)   // boolean

// Comparators
Collections.reverseOrder()			                       // Comparator (reverse natural order)
Collections.reverseOrder(Comparator cmp)	             // Comparator (reverse given comparator)

// N-Copies (immutable list with n copies of element)
Collections.nCopies(int n, Object o)		        // List

// Enumeration to List conversion
Collections.list(Enumeration e)     		        // ArrayList

// Examples of common usage patterns

// Sorting with custom comparator
List<String> names = Arrays.asList("John", "Alice", "Bob");
Collections.sort(names, (a, b) -> a.length() - b.length());	// sort by length

// Binary search (list must be sorted first)
List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);
int index = Collections.binarySearch(numbers, 5);	          // returns 2

// Thread-safe list
List<String> syncList = Collections.synchronizedList(new ArrayList<>());
synchronized (syncList) {				                            // manual sync needed for iteration
    for (String item : syncList) {
        System.out.println(item);
    }
}

// Unmodifiable list
List<String> readOnlyList = Collections.unmodifiableList(Arrays.asList("A", "B", "C"));

// Type-safe collections
List<String> checkedList = Collections.checkedList(new ArrayList<>(), String.class);

// Utility operations
List<Integer> nums = Arrays.asList(1, 2, 3, 2, 4, 2);
int count = Collections.frequency(nums, 2);		          // returns 3
Collections.replaceAll(nums, 2, 99);			              // replace all 2s with 99

// Safe empty collections
List<String> empty = Collections.emptyList();		        // better than new ArrayList<>()
Map<String, Integer> emptyMap = Collections.emptyMap();	// for default returns

// Defensive copying
public List<String> getItems() {
    return Collections.unmodifiableList(new ArrayList<>(internalList));
}
```

#### Legacy Classes

##### Dictionary - Abstract class (legacy, use Map instead)

#### Wrapper Classes (from Collections utility)

These are created via Collections.xyz() methods:

- Collections.UnmodifiableCollection and variants
- Collections.SynchronizedCollection and variants
- Collections.CheckedCollection and variants
- Collections.EmptyList/Set/Map
- Collections.SingletonList/Set/Map
