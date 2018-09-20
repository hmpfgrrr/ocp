package main.java.ocp.modifiers.cat.species;

import main.java.ocp.modifiers.cat.BigCat;

/**
 * Created by christianneuls on 23.08.18.
 */
public class Lynx extends BigCat {
    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name);
        //System.out.println(cat.hasFur);
        //System.out.println(cat.hasPaws);
        //System.out.println(cat.id);

        Lynx cat3 = new Lynx();
        System.out.println(cat3.name);
        System.out.println(cat3.hasFur);
        //System.out.println(cat3.hasPaws);
        //System.out.println(cat3.id);
    }
}
