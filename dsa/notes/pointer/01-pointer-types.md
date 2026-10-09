# Type of Pointer

- NULL Pointer.
- void Pointer (generic pointer).
- Wild Pointer.
- Dangling Pointer.
- Constant Pointer
- Function Pointers:

### NULL Pointer

- null pointer does not point to any memory address.
- null pointer is assigned to a `NULL` when it is declared.
- NULL is macro, which is defined as `((void*)0))` in header files like <stdio.h>, <stdlib.h>...
- a NULL pointer should not be dereferenced.
    
    Example:
    
    ```C
    int * ptr = NULL;
    printf( "ptr : %d\\n", ptr); // 0
    
    if(ptr == NULL)
    {
        printf( "ptr is NULL\\n");
    }
    else
    {
        printf( "ptr is not NULL\\n");
    }
    ```
    

### void Pointer (generic pointer)

- A void pointer (also known as a generic pointer) in C is a pointer that does not have a specific data type. It can be used to point to any type of data. The syntax for declaring a void pointer is as follows:
    
    ```C
    void * pointer_name;
    ```
    
- For example, you can declare a void pointer as follows:
    
    ```C
    void * p;
    ```
    
- A void pointer can be used to store the address of any type of data, but it cannot be dereferenced without a type cast. To dereference a void pointer, you must first cast it to a pointer of the appropriate data type.
- For example, you can use a void pointer to store the address of an int and then cast it to an int pointer before dereferencing it.
    
    ```C
    int x = 5;
    void *p = &x;
    int *int_p = (int*)p;
    printf("%d", *int_p); // prints 5
    ```
    
- Void pointers are useful when a function needs to accept a pointer to data of any type, or when a pointer's type needs to change dynamically during program execution. They are also used when working with memory allocation functions such as malloc and realloc, which return void pointers.

### Wild Pointer

- A wild pointer in C is a pointer that does not point to a valid memory location, and has an undefined value.
- For example, if you define a pointer without initializing it or assign it to a non-existent memory address, it becomes a wild pointer.
    
    ```C
    int * p;                         // Wild pointer, not initialized
    int * q = (int*)0xDEADBEEF;     // Wild pointer, pointing to a non-existent memory address
    ```
    
- Dereferencing a wild pointer can lead to undefined behavior, such as a segmentation fault or a crash.

### Dangling Pointer

- A dangling pointer in C is a pointer that points to a memory location that has been deallocated, but the pointer still holds the address of the memory.
- For example, if you have a dynamically allocated memory using `malloc` or `calloc` and you free that memory using `free()` function, but there are still pointers pointing to the memory location, those pointers become dangling pointers.
    
    ```C
    int *p = (int *)malloc(sizeof(int));     // dynamically allocate memory
    free(p);                                  // free the memory
    int *q = p;                              // p is now a dangling pointer
    ```
    
- Dereferencing a dangling pointer can lead to undefined behavior, such as reading stale data or a crash.

### Constant pointer

- A constant pointer in C is a pointer that points to a constant value and cannot be used to modify the value it points to. The syntax for declaring a constant pointer is as follows:
    
    ```C
    data_type * const pointer_name = &variable;
    ```
    
- For example, you can declare a constant pointer to an int as follows:
    
    ```C
    int x = 5;
    int * const p = &x;
    ```
    
- Once a constant pointer is initialized, it cannot be made to point to a different memory location, but the data it points to can be modified.
    
    ```C
    p = &y;     // not allowed
    *p = 10;     // allowed
    ```
    
- Also, you can also define a `pointer to a constant value`, which means that you can change the pointer to point to a different memory location, but the data it points to cannot be modified. The syntax is:
    
    ```C
    const data_type *pointer_name = &variable;
    ```
    
    For example,
    
    ```Plain
    const int * p = &x;
    p = &y;     // allowed
    *p = 10;     // not allowed
    ```
    
- It's very important to keep in mind the difference between a constant pointer and a pointer to constant when you are using them, as it can lead to confusion and errors if you try to modify the data pointed to by a pointer to constant.

### Function pointer

- A function pointer in C is a pointer that points to the memory location of a function, and can be used to call that function. The syntax for declaring a function pointer is as follows:
    
    ```C
    return_type (*pointer_name)(parameter_list);
    ```
    
- For example, you can declare a function pointer that points to a function that takes an int and returns a float as follows:
    
    ```C
    float (*p)(int);
    ```
    
- To assign a function to a function pointer, you need to use the address of the function, which is represented by the function name followed by the ampersand (&) symbol.
    
    ```Plain
    p = &function_name;
    ```
    
- You can also call a function through a function pointer by dereferencing the pointer and passing the necessary arguments to the function.
    
    ```Plain
    float result = (*p)(5);
    ```