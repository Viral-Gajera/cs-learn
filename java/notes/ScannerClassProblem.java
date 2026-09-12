// sc.nextLine not working case

// Problem is because - Scanner.nextAny method does not read the newline
// character (\n) in your input created by hitting "Enter" and so the call to
// Scanner.nextLine returns after reading that newline.

// You will encounter the similar behaviour when you use Scanner.nextLine after
// Scanner.next() or any Scanner.nextFoo method (except nextLine itself).

// Workaround: Either put a Scanner.nextLine call after each Scanner.nextInt or
// Scanner.nextFoo to consume the rest of that line including newline:

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
        // System.out.print("x : ");
        // float x = sc.nextFloat();
        // System.out.print("str : ");
        // String str = sc.nextLine();
        // System.out.format("\noutput x : %f, str : %s", x, str);

        // Case : nextDouble() + nextLine()
        // System.out.print("x : ");
        // double x = sc.nextDouble();
        // System.out.print("str : ");
        // String str = sc.nextLine();
        // System.out.format("\noutput x : %f, str : %s", x, str);

        // Case : nextBoolean() + nextLine()
        // System.out.print("x : ");
        // boolean x = sc.nextBoolean();
        // System.out.print("str : ");
        // String str = sc.nextLine();
        // System.out.format("\noutput x : %b, str : %s", x, str);

        // Case : nextLong() + nextLine()
        // System.out.print("x : ");
        // long x = sc.nextLong();
        // System.out.print("str : ");
        // String str = sc.nextLine();
        // System.out.format("\noutput x : %d, str : %s", x, str);

        // Case : nextShort() + nextLine()
        // System.out.print("x : ");
        // short x = sc.nextShort();
        // System.out.print("str : ");
        // String str = sc.nextLine();
        // System.out.format("\noutput x : %d, str : %s", x, str);

        // Case : next() + nextLine()
        // System.out.print("str 1 : ");
        // String str1 = sc.next();
        // System.out.print("str 2 : ");
        // String str2 = sc.nextLine();
        // System.out.format("\noutput str 1 : %s, str 2 : %s", str1, str2);

        // Case : next() + next() with first input multiword
        // e.g "str1 : viral gajera" -> str1 = "viral", str2 = "gajera"
        // System.out.print("str 1 : ");
        // String str1 = sc.next();
        // System.out.print("str 2 : ");
        // String str2 = sc.next();
        // System.out.format("\noutput str 1 : %s, str 2 : %s", str1, str2);

        // Case : nextLine() + nextLine() works fine
        // System.out.print("str 1 : ");
        // String str1 = sc.nextLine();
        // System.out.print("str 2 : ");
        // String str2 = sc.nextLine();
        // System.out.format("\noutput str 1 : %s, str 2 : %s", str1, str2);

        sc.close();
    }
}