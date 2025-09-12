package BasicConcepts;

public class StringBuilderBufferDemo {

    public static void main(String[] args) {
        String s = "Dhruba";            // String pool memory
        String s1 = new String("Dhruba");    // new obj

        System.out.println(s.equals(s1));     // equals () - > checks value -> True
        System.out.println(s == s1);            // == -> checks memory -> false

        s1.concat("Chat");
        System.out.println(s1);   // s is not modified as string immutable same for s1

        // to solve this use String builder - mutable  - not thread safe

        StringBuilder s2 = new StringBuilder("Dhruba");
        s2.append("Chat");
        System.out.println(s2);

        //   to solve thread safety use string buffer
        StringBuffer s3 = new StringBuffer("Dhruba");
        s3.append("Chat");
        System.out.println(s3);
    }
}
