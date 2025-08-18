package BasicConcepts;

public class Shadowing {

    // use same variable name in different scopes

    static int x = 50;        // class scope

    public static void main(String[] args) {
        System.out.println(x);
        int x = 40;   // shadows the previous declaration
        System.out.println(x);
        fun();   // print 50 as this is outside method scope
    }

    static void fun(){
        System.out.println(x);
    }




}
