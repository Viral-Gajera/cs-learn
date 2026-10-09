# Method Reference Operation (::)

- Method reference operation refers method or constructor without invoking it
- Short form of lambda expressions

1. ClassName::staticMethod
2. object::instanceMethod
3. ClassName::instanceMethod
4. ClassName::new

Quick map to lambda expressions:

```
1. ClassName::staticMethod      | (a,b) -> ClassName.staticMethod(a,b)
2. object::instanceMethod       | (a,b) -> object.instanceMethod(a,b)
3. ClassName::instanceMethod    | (obj, a,b) -> obj.instanceMethod(a,b) <- special case
4. ClassName::new               | (a,b) -> new ClassName(a,b)
```

Javascript equivalent:

| Lambda Expression             | Functional Interface    |
| ----------------------------- | ----------------------- |
| () => value                   | Supplier<T>             |
| (x) => value                  | Function<T, R>          |
| (x, y) => value               | BiFunction<T, U, R>     |
| (x, y, z) => value            | TriFunction<T, U, V, R> |
| () => { No return value }     | Runnable                |
| (x) => { No return value }    | Consumer<T>             |
| (x, y) => { No return value } | BiConsumer<T, U>        |
| (x) => boolean                | Predicate<T>            |
