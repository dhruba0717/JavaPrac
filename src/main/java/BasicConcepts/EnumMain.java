package BasicConcepts;

public class EnumMain {


    public static void main(String[] args) {
        // EnumPrac e = new EnumPrac();    // Enum cant be instantiated

        EnumPrac e = EnumPrac.FAILURE;
        System.out.println(e.getMessage());
        System.out.println(e.getStatus());
    }
}
