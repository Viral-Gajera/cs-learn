# Array

- Array is collection of similar type of element stored in contiguous memory location.

**Limitations of Arrays**

- Fixed size
- Data elements are stored in contiguous memory locations which may not be available always.
- Adding and removing of elements is tough because of shifting the elements from their positions.

### Syntax

```Java
type [] arr;					// declaration
type arr [];					// declaration

arr = new type[size];			// creating array
arr[index] = value;				// initializing

type [] arr = new type[size];	// declaration & creation
type [] arr = {e1, e2, ... };	// declaration & initalizing
```

Example:

```Java
int [] num = new int[10];

for (int i=0; i<10; i++){
	System.out.println(num[i]);
}
```

```Java
int [] num = {35, 40, 20, 57, 19};

for (int i=0; i<num.length; i++){
	System.out.println(num[i]);
}
```

### Passing Arrays to Functions

- To pass an array argument to a function, specify the name of the array without any brackets, like `sumArray(arr)`.
- To recieve array as argument use following syntax, `sumArray(int [] arr)`.
- Arrays are passed as **call by reference**.

```Java
public class Main8 {

    public static int sumArray(int [] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int sum = sumArray(arr);
        System.out.println("sum = " + sum);
    }
}
```

```Java
// Determine array passed as call by value or call by reference

public class Main9 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println("Before: " + arr[0]);
        change(arr);
        System.out.println("After: " + arr[0]);
    }

    public static void change(int[] arr) {
        arr[0] = 10;
    }
}

// Output:
Before: 1
After: 10
```

### Operations on Arrays

- Traversal
- Searching
- Insertion (* shifting required)
- Deletion (* shifting required)
- Merging (* comparing required)

### Two Dimentional Array

- They are used to store information that we normally represent in table form.
- Syntax:

```Java
type [][] arr;							// declaration
type arr [][];							// declaration

arr = new type[size][];					// creating array
arr[i][j] = value;						// initializing

type [][] arr = new type[size][];		// declaration & creation
type [][] arr = {					 	// declaration & initalizing
    				{e1, e2, ...},
                 	{e1, e2, ...}
				};
```

### Operations on 2D Array

- Transpose
- Sum
- Diﬀerence
- Product


### Sparse matrix

- Sparse matrix is a matrix which has many elements with a value zero or null.
- It is beneﬁcial to use specialized algorithms and data structures that take advantage of the sparse structure of the matrix. – Utilize memory.

  

**Lower-triangular Sparse matrix:**

- All elements **above** the main diagonal have a value zero.
- To store this, we can use 1D array which stores only non-zero elements.
- The mapping between 1D array and 2D matrix can be done as:
  
    1. Row-wise mapping: The content of the array A[] will be `{1, 5, 3, 2, 7, 1, 3, 1, 4, 2, 9, 2, 8, 1, 7}`.
    2. Column-wise mapping: The content of the array A[] will be `{1, 5, 2, 3, 9, 3, 7, 1, 2, 1, 4, 8, 2, 1, 7}`.
    
    <img src="Lower Triangular Sparse Matrix.jpg">

  

**Upper-triangular Sparse matrix:**

- All elements **below** the main diagonal have a value zero.
- The mapping between 1D array and 2D matrix can be done as Row wise or Column wise as above.

<img src="Upper Triangular Sparse Matrix.jpg">

  

**Tridiagonal Sparse matrix:**

- All elements other than main diagonal and two diagonal besides, have a value zero.
- The mapping between 1D array and Tridiagonal matrix can be done as:
  
    Diagonal-wise mapping: The content of the array A[] will be `{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 4, 5, 6 }`

<img src="Tridiagonal Sparse Matrix.jpg">

  

  

# Linked List

- linked list is a linear collection of data elements whose order is not given by their physical placement in memory. Instead, each element points to the next.
- A linked list is a linear data structure, in which the elements are not stored at contiguous memory locations. The elements in a linked list are linked using pointers as shown in the below image.
  

<img src="Linked List.jpg">



- This structure allows efficient insertion or removal of elements from any position in the sequence.
- A linked list whose nodes contain two fields: an integer value and a link to the next node is called singly link list.
- The last node is linked to a terminator (NULL pointer) used to signify the end of the list.
- Advantage: Provides quick insert and delete operations.
- Disadvantage: Slow search operations and requires more memory space.

  

## Linked List vs Arrays

Array:

- The size of the arrays is fixed: So we must know the upper limit on the number of elements in advance.
- Inserting a new element in an array of elements is expensive, because room has to be created for the new elements and to create room existing elements have to be shifted.

Linked List:

- Random access is not allowed. We have to access elements sequentially starting from the first node. So we cannot do binary search with linked lists.
- Extra memory space for a pointer is required with each element of the list.

  

# Singly Linked List

- Simplest type of linked list in which every node contains data and pointer.
- A singly linked list allows traversal of data only in one direction.

<img src="Singly Linked List.jpg">

## Operations on linked list

- Traversing `O(n)`
- Display linked list `O(n)`
- Count Number of node in linked list `O(n)`
- Search `O(n)`
- Insert/Delete First `O(1)`
- Insert/Delete Last `O(n)`
- Insert/Delete At Position `O(n)`
- Insert/Delete Before `O(n)`
- Insert/Delete After `O(n)`
- Insert/Delete Sorted `O(n)`
- Delete All Occurrence `O(n)`

## Implementation

```Java
class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {
    Node<T> head;

    LinkedList() {
        this.head = null;
    }

    void display() {
        Node<T> traverseNode = head;

        while (traverseNode != null) {
            System.out.print(traverseNode.data + " ");
            traverseNode = traverseNode.next;
        }
        System.out.println();
    }

    int size() {
        Node<T> traverseNode = head;
        int count = 0;

        while (traverseNode != null) {
            count++;
            traverseNode = traverseNode.next;
        }
        return count;
    }

    void insertLast(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> traverseNode = head;

            while (traverseNode.next != null) {
                traverseNode = traverseNode.next;
            }
            traverseNode.next = newNode;
        }
    }

    void insertFirst(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void insertAt(int index, T data) {
        if (index < 0) {
            System.out.println("Index should be greater then zero");
            return;
        }
        if (index > size()) {
            System.out.println("Index should be less then or equals to " + size());
            return;
        }

        if (index == 0) {
            insertFirst(data);
            return;
        } else {
            Node<T> traverseNode = head;
            int count = 0;

            while (count < index - 1) {
                traverseNode = traverseNode.next;
                count++;
            }

            Node<T> newNode = new Node<T>(data);
            newNode.next = traverseNode.next;
            traverseNode.next = newNode;
        }

    }

    void deleteLast() {
        if (head == null) {
            System.out.println("deleteLast: Linkded List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node<T> traverseNode = head;
            while (traverseNode.next.next != null) {
                traverseNode = traverseNode.next;
            }
            traverseNode.next = null;
        }

    }

    void deleteFirst() {
        if (head == null) {
            System.out.println("deleteFirst: Linkded List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
        }
    }

    void deleteAt(int index) {
        if (index < 0) {
            System.out.println("Index should be greater then zero");
            return;
        }
        if (index > size() - 1) {
            System.out.println("Index should be less then or equals to " + (size() - 1));
            return;
        }

        if (index == 0) {
            deleteFirst();
        } else {
            Node<T> traverseNode = head;
            int count = 0;

            while (count < index - 1) {
                traverseNode = traverseNode.next;
                count++;
            }

            traverseNode.next = traverseNode.next.next;
        }
    }
    int search(T element) {
        int index = -1;

        if (head == null) {
            System.out.println("Linkded List is empty");
        } else {
            int count = 0;
            Node<T> traverseNode = head;

            while (traverseNode != null) {
                if (traverseNode.data == element) {
                    return count;
                }
                traverseNode = traverseNode.next;
                count++;
            }
        }
        return index;
    }
}
```

# Circular Linked List

- Circular linked lists are typically implemented using a singly linked list data structure. This means that each node in the list is connected to the next node via a pointer.
- The last node in the list is then connected back to the first node, creating the ring-like structure.

<img src="Circular Linked List.jpg">

## Advantages:

- In linear linked list it is not possible to go to previous node but within Circular LL possible.
- It saves time when we have to go to the first node from the last node. It can be done in single step because there is no need to traverse the in between nodes. But in double linked list, we will have to go through in between nodes.

## Disadvantages

- If proper care is not taken, then the problem of infinite loop can occur.
- If we at a node and go back to the previous node, then we can not do it in single step. Instead we have to complete the entire circle by going through the in between nodes and then we will reach the required node.

## Operations on Circular linked list

- Insert/Delete First
- Insert/Delete Last

Other operations are similar to SLL.

# Doubly Linked List

- In Doubly-linked list each node has two links: one points to previous node and other points to next node.
- The previous link of first node in the list points to a Null and the next link of last node points to Null.

<img src="Doubly Linked List.jpg">



## Advantages

- Traversal in either direction becomes convenient.
- Reduces time requirement for the program execution.
- The doubly linked lists can be used to represent other data-structure.
- The hierarchical structure of the tree can be easily represented using a doubly linked list.
- Graphs can be represented using doubly linked list.

## Disadvantages

- Each node requires extra space for storing the additional pointer.
- While manipulating the lists, extra care should be taken to manipulate both links.

## Operations on Circular linked list

- Traversing
- Display linked list
- Count Number of node in linked list
- Search
- Insert/Delete First
- Insert/Delete Last
- Insert/Delete At Position
- Insert/Delete Before
- Insert/Delete After
- Insert/Delete Sorted
- Delete All Occurrence

## Implementation

```Java
class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;

    Node(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

class LinkedList<T> {
    Node<T> head;

    LinkedList() {
        this.head = null;
    }

    void display() {
        Node<T> traverNode = head;

        while (traverNode != null) {
            System.out.print(traverNode.data + " ");
            traverNode = traverNode.next;
        }
        System.out.println();
    }

    int size() {
        Node<T> traverNode = head;
        int count = 0;

        while (traverNode != null) {
            count++;
            traverNode = traverNode.next;
        }

        return count;
    }

    void insertLast(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> traverseNode = head;

            while (traverseNode.next != null) {
                traverseNode = traverseNode.next;
            }

            traverseNode.next = newNode;
            newNode.previous = traverseNode;
        }
    }

    void insertFirst(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void insertAt(int index, T data) {
        if (index < 0) {
            System.out.println("Index should be greater then zero");
            return;
        }
        if (index > size()) {
            System.out.println("Index should be less then or equals to " + size());
            return;
        }

        if (index == 0) {
            insertFirst(data);
        } else {
            Node<T> newNode = new Node<T>(data);
            Node<T> traverNode = head;
            int count = 0;

            while (count < index - 1) {
                traverNode = traverNode.next;
                count++;
            }

            newNode.next = traverNode.next;
            newNode.previous = traverNode;
            if (traverNode.next != null) {
                traverNode.next.previous = newNode;
            }
            traverNode.next = newNode;
        }
    }

    void deleteLast() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        } else {
            Node<T> traversNode = head;

            while (traversNode.next.next != null) {
                traversNode = traversNode.next;
            }

            traversNode.next.previous = null;
            traversNode.next = null;
        }
    }

    void deleteFirst() {
        if (head == null) {
            System.out.println("Linked List is empty");
        }
        if (head.next == null) {
            head = null;
        } else {
            head.next.previous = null;
            head = head.next;
        }
    }

    void deleteAt(int index) {
        if (index < 0) {
            System.out.println("Index should be greater then zero");
            return;
        }
        if (index > size() - 1) {
            System.out.println("Index should be less then or equals to " + (size() - 1));
            return;
        }

        if (index == 0) {
            deleteFirst();
        } else {
            Node<T> traverseNode = head;
            int count = 0;

            while (count < index - 1) {
                count++;
                traverseNode = traverseNode.next;
            }

            if (traverseNode.next.next == null) {
                traverseNode.next.previous = null;
                traverseNode.next = null;

            } else {
                traverseNode.next.previous = null;
                traverseNode.next = traverseNode.next.next;
                traverseNode.next.previous.next = null;
                traverseNode.next.previous = traverseNode;
            }
        }
    }
}
```

# Circular Doubly Linked List

- A doubly linked list is where each element has pointers to both the next element and the prior element.
- A doubly circular linked list is where the last element next points back to the first element, and first element prev points to the last.

<img src="Circular Doubly Linked List.jpg">

## Advantages

- It saves time when we have to go to the first node from the last node. It can be done in single step because there is no need to traverse the in between nodes. But in double linked list, we will have to go through in between nodes.

## Disadvantages

- If proper care is not taken, then the problem of infinite loop can occur.

## Operations on Circular linked list

- Insert/Delete First
- Insert/Delete Last

Other operations are similar to SLL.