package BasicConcepts;

import java.util.Arrays;

public class VarArgs {


    public static void main(String[] args) {
        getName(5,6,7,8);
    }

    static void getName(int ...x){
        // ...x we use when we kow how many argument to pass hence it takes
        // array
        System.out.println(Arrays.toString(x));
    }
}
