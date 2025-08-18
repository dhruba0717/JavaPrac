package BasicConcepts;

public class Scope {

    public static void main(String[] args) {
   int a = 10;
   int b = 20;

        {
//            int a;     // cant initialize as already done outside block
            a = 30;     // outside declared thing can be changed in block
            int c = 99;

            // values in block will remain in block but can change existing values
        }
        System.out.println(a);   // - 30 as changed inside block
//        System.out.println(c);      outside block the thing cant be accesed
        int c = 99;    // as initialized in block can be again done outside

    }
}
