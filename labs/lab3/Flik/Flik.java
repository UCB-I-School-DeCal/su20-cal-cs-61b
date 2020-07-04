/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {

        System.out.println("i is " + a);
        System.out.println("j is " + b);
        boolean ans = a == b; // this is false when 128
        System.out.println("Equal? " + ans);

//        boolean ans2 = a == 128;
//        boolean ans3 = b == 128;
        // int can't hold more than 127.
        return a == b;
    }
}
