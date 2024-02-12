package method;

import java.util.Scanner;

public class Required {

    static Scanner  sc =  new Scanner(System.in);
    public static int requiredNumber(String text){
        System.out.println(text);
        return sc.nextInt();
    }

    public static String requiredText(String text){
        System.out.println(text);
        return sc.next();
    }
}
