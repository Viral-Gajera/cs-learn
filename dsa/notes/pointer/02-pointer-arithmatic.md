# Operation on Pointer

- Increment and decrement of a pointer
- Addition of integer to a pointer
- Addition of two pointers of the same type
- Subtraction of integer to a pointer
- Subtracting two pointers of the same type
- Comparison of pointers of the same type

### Increment and Decrement of a Pointer

- When a pointer is incremented, it actually increments by the `size of data type for which it is a pointer`.
- When a pointer is decremented, it actually decrements by `size of data type for which it is a pointer`.
    
    Example:
    
    ```Plain
    int x = 10;
    int * ptr = &x;
    
    printf( "size   : %d\\n", sizeof(ptr));  // 4
    printf( "ptr    : %d\\n", ptr);          // 1096
    printf( "-- ptr : %d\\n", --ptr);        // 1092
    printf( "++ ptr : %d\\n", ++ptr);        // 1096
    printf( "++ ptr : %d\\n", ++ptr);        // 1100
    printf( "-- ptr : %d\\n", --ptr);        // 1096
    
    int arr[5];
    ptr = arr;
    
    printf( "size   : %d\\n", sizeof(ptr));  //4
    printf( "ptr    : %d\\n", ptr);          //2096
    printf( "-- ptr : %d\\n", --ptr);        //2092
    printf( "++ ptr : %d\\n", ++ptr);        //2096
    printf( "++ ptr : %d\\n", ++ptr);        //2100
    printf( "-- ptr : %d\\n", --ptr);        //2096
    ```
    

### Addition of integer to a pointer

- When you add an integer to a pointer, it actually adds that integer multiplied by the `size` of the data type the pointer is pointing to. So the formula would be:
    
    ```Plain
    ptr + integer
    = ptr + (integer * sizeof(data-type))
    ```
    

### Addition of two pointers of the same type

- **Adding two pointers is illegal in c program** but pointer and integer addition is legal.

### Subtraction of integer to a pointer

- When you subtract an integer from a pointer, it actually subtracts that integer multiplied by the size of the data type the pointer is pointing to. So the formula would be:
    
    ```Plain
    ptr - integer
    = ptr - (integer * sizeof(data type))
    ```
    

### Subtracting two pointers of the same type

- When you subtract two pointers of the same type, it actually gives you the number of elements of the data type between the two pointers. So the formula would be:
    
    ```Plain
    ptr1 - ptr2
    (ptr1 - ptr2) / sizeof(data type)
    ```
    

### Comparison of pointers of the same type.

- when you compare two pointers of the same type, you can use the standard comparison operators (>, <, >=, <=, ==, !=) to compare the memory addresses they are pointing to.
- It's important to note that the comparison of two pointers gives you the relation between the memory addresses they are pointing to, not the relation of the values stored in those memory addresses.
- Also, this operation is only allowed for pointers of the same type and the result is always a Boolean value.
- For example, if you have two pointers to int, p1 and p2, you can compare them as follows:
    
    ```Plain
    p1 > p2
    p1 < p2
    p1 >= p2
    p1 <= p2
    p1 == p2
    p1 != p2
    ```