package main.java.oca;

public class Initalization {

    static {
        System.out.println("static");
    }
    private int i;
    private int i2;
    private final int i3 = 0;
    private final int i4;
    private String name;
    {
        System.out.println("instance");
        i2 = 1;
        //i3 = 2;
        i4 = 2;
    }

    private static int is1;
    private static int is2;
    static {
        System.out.println("static2");
        is1 = 1;
    }

    int var2;
    //int var1 = var2;

    public Initalization (){
        System.out.println("constructor");
    }

    public static void main(String [] args) {
        System.out.println("main");
        Initalization init = new Initalization();
        int local_i = 0;
        final int local_i2 = 0;
        String local_name;
        int result = local_i + local_i2;
        int intance_result = init.i2 + init.i3;
        int static_result = is1 + is2;
        System.out.println(result);
        System.out.println(intance_result);
        System.out.println(static_result);
        System.out.println("done");

        {
            System.out.println("normal scope only ?");
        }
        //static {
        //    System.out.println("not working here");
        //}

        localMeth();

        //int var3 = var4;
        int var4 = 0;
        int var3 = var4;
    }
        {
            System.out.println("instance initializer");
        }

    public static   void localMeth() {
        int y = 3/5;
        int x = 0;
        x += 2;
        //int z += 2;
        //static {
        //    System.out.println("static2");
        //}

        int v1 = 2, v2 = 3;
        int test = v1 + v2;

        float f = 1;
        float f2 = 1.0f;
        float f3 = 1f;
        //float f4 = 1d;

        double d = 1;
        double d2 = 1.0;
        double doubleres = d + d2;

        long l = 1;
        long l2 = 1L;
        long longres = l + l2;

        System.out.println(1+2+"3"+4+5);

        float val = 1;
        float val2 = (int) 1.2;
        float val3 = 1 * 0.0f;
        float val4 = 1 * (short)0.0;
        //float val5 = 1 * (boolean)0.0;
    }


}
