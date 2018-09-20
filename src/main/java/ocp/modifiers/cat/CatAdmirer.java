package main.java.ocp.modifiers.cat;

/**
 * Created by christianneuls on 23.08.18.
 */
public class CatAdmirer {

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name);
        //same package (package private) includes protected
        System.out.println(cat.hasFur);
        System.out.println(cat.hasPaws);
        //System.out.println(cat.id);
    }
}
