package main.java.ocp.katas;

/**
 * Created by christianneuls on 30.07.18.
 * First try approx 36min, no tests
 */
public class KataWordWrap {

    public static void main(String[] args) {
        wrap("this is a text i want to wrap according to the specified column length", 15);
    }

    private static void wrap(String text, int maxColumnSize) {
        String word = "";
        int currentColumnSize = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            currentColumnSize++;

            if ((character == ' ')) {
                System.out.print(word + " ");
                word = "";
            } else {
                word += character;
            }

            if (currentColumnSize > maxColumnSize -1) {
                System.out.println();
                currentColumnSize = 0;
            }
        }
        System.out.println(word);
    }
}
