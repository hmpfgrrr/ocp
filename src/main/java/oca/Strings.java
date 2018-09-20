package main.java.oca;

public class Strings {
    public static void main(String[] args) {
        String s = "Hello";
        String t = new String(s);

        if (t == s) System.out.println("one");
        if (t.equals(s)) System.out.println("two");
        if ("Hello" == s) System.out.println("four");
        if ("Hello" == t) System.out.println("five");

        StringBuilder s1 = new StringBuilder("eins");
        StringBuilder s2 = new StringBuilder("eins");

        if (s1 == s2) System.out.println("same");
        if (s1.equals(s2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
        //if (s1 == "eins") System.out.println("same");
        if (s1.toString() == "eins") System.out.println("same");


        StringBuilder sb = new StringBuilder("01234");
        sb = sb.append("a").delete(0,1).insert(2, "i");
        System.out.println(sb);
        StringBuilder rev = sb.reverse();
        String sub = rev.substring(1, 5);
        System.out.println(sb);

        sub.concat("x");
        sub.isEmpty();
        //sb.isEmpty();

    }
}
