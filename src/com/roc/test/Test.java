package com.roc.test;

import java.time.ZoneId;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        // String s = "abc";
        // StringBuilder sb = new StringBuilder("abc");

        // System.out.println(s.equals(sb));
        // System.out.println(sb.equals(s));

        // int[] a = { 1, 2, 3, 4, 5 };
        // int[] b = { 1, 2, 3, 4, 5 };

        // System.out.println(Arrays.equals(a, b));
        // System.out.println("abc".matches("[^a-z][a-z][a-z]"));
        // System.out.println("n".matches("[a-z&&m-p]"));
        // System.out.println("a".matches("\\d"));
        // System.out.println("\n");
        // String regex =
        // "[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}[\\dxX]";

//        System.out.println(ZoneId.getAvailableZoneIds());
        String s = "username=soar&password=5678";
        String[] ss = s.split("[=&]");
        System.out.println(Arrays.toString(ss));
    }
}
