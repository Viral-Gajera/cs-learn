# Scanner Class Problem

```java
// Problem is because - sc.nextInt(), sc.nextFloat() etc. methods does not read 
// the newline character (\n) and so the call to sc.nextLine() 
// returns remaining newline character.

// You will encounter the similar behaviour when you use sc.nextLine() after
// sc.next() or any Scanner.nextFoo method (except nextLine itself).

// Workaround: Either put a sc.nextLine() call after each sc.nextInt() or sc.nextFoo()
// to consume the rest of that line including newlines.

import java.util.Scanner;

public class ScannerClassProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Case : nextInt() + nextLine()
        System.out.print("x : ");
        int x = sc.nextInt();
        System.out.print("str : ");
        String str = sc.nextLine();
        System.out.format("\noutput x : %d, str : %s", x, str);

        // Case : nextFloat() + nextLine()
        System.out.print("x : ");
        float x = sc.nextFloat();
        System.out.print("str : ");
        String str = sc.nextLine();
        System.out.format("\noutput x : %f, str : %s", x, str);

        // Case : nextDouble() + nextLine()
        System.out.print("x : ");
        double x = sc.nextDouble();
        System.out.print("str : ");
        String str = sc.nextLine();
        System.out.format("\noutput x : %f, str : %s", x, str);

        // Case : nextBoolean() + nextLine()
        System.out.print("x : ");
        boolean x = sc.nextBoolean();
        System.out.print("str : ");
        String str = sc.nextLine();
        System.out.format("\noutput x : %b, str : %s", x, str);

        // Case : nextLong() + nextLine()
        System.out.print("x : ");
        long x = sc.nextLong();
        System.out.print("str : ");
        String str = sc.nextLine();
        System.out.format("\noutput x : %d, str : %s", x, str);

        // Case : nextShort() + nextLine()
        System.out.print("x : ");
        short x = sc.nextShort();
        System.out.print("str : ");
        String str = sc.nextLine();
        System.out.format("\noutput x : %d, str : %s", x, str);

        // Case : next() + nextLine()
        System.out.print("str 1 : ");
        String str1 = sc.next();
        System.out.print("str 2 : ");
        String str2 = sc.nextLine();
        System.out.format("\noutput str 1 : %s, str 2 : %s", str1, str2);

        // Case : next() + nextLine() with first input multiword - WORKS FINE
        // e.g "str1 : viral gajera" -> str1 = "viral", str2 = "gajera"
        System.out.print("str 1 : ");
        String str1 = sc.next();
        System.out.print("str 2 : ");
        String str2 = sc.nextLine();
        System.out.format("\noutput str 1 : %s, str 2 : %s", str1, str2);

        // Case : next() + next() with first input multiword - WORKS FINE
        // e.g "str1 : viral gajera" -> str1 = "viral", str2 = "gajera"
        System.out.print("str 1 : ");
        String str1 = sc.next();
        System.out.print("str 2 : ");
        String str2 = sc.next();
        System.out.format("\noutput str 1 : %s, str 2 : %s", str1, str2);

        // Case : nextLine() + nextLine() WORKS FINE
        System.out.print("str 1 : ");
        String str1 = sc.nextLine();
        System.out.print("str 2 : ");
        String str2 = sc.nextLine();
        System.out.format("\noutput str 1 : %s, str 2 : %s", str1, str2);

        // Case : nextInt() + nextInt() WORKS FINE
        System.out.print("x : ");
        int x = sc.nextInt();
        System.out.print("y : ");
        int y = sc.nextInt();
        System.out.format("\noutput x : %d, y : %d", x, y);

        sc.close();
    }
}
```

