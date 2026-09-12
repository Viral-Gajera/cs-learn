# Static

- The static members of a class are accessed using the class name and dot notation, without creating an object e.g. `<ClassName>.<StaticMember>` .

```TypeScript
class Circle {
    static pi: number = 3.14;
    
    static calculateArea(radius:number) {
        return this.pi * radius * radius;
    }
}
Circle.pi; // returns 3.14
Circle.calculateArea(5); // returns 78.5
```

- TypeScript will generate the following JavaScript code for the above `Circle` class.

```TypeScript
var Circle = /** @class */ (function () {
    function Circle() {
    }
    Circle.pi = 3.14;
    Circle.calculateArea = function (radius) {
        return this.pi * radius * radius;
    };
    return Circle;
}());
```

- Now, consider the following example with static and non-static members.
- As you can see, static and non-static fields with the same name can exists without any error.

```TypeScript
class Circle {
    static pi = 3.14;
    pi = 3;
}

Circle.pi; // returns 3.14

let circleObj = new Circle();
circleObj.pi; // returns 3
```

Note:
- The class or constructor cannot be static in TypeScript.