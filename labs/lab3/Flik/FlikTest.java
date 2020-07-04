import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void testSomething(){

        // My journey.  I started with trying isSameNumber with various inputs
//        boolean try1 = Flik.isSameNumber(3, 5);
//        boolean try2 = Flik.isSameNumber(3, 3);
//        boolean try3 = Flik.isSameNumber(128, 128);
//        boolean try4 = Flik.isSameNumber(300, 300);

//        assertFalse(try1);
//        assertTrue(try2);
//        assertEquals(128, 128);
//        assertTrue(try3);  // 128 128
//        assertTrue(try4);  // 300 300

        // Figured that when we get to 128 or greater, isSameNumber returns false

        // I put a stop at HorribleSteve and put a condition to stop when we get to i=127
        // then stepped through the methods to see what was happening.
        // Couldn't tell what was going on, but saw that a == b was failing in Flik

        // I then stepped through FLik and made it print the inputs
        // as well as a == b, which failed as soon as we hit 128
        // then I looked more closely and saw the type of inputs in Flik was different from
        // HS's stype. Integer vs. int.

        // So I did the following tests:

        Integer aInteger = 129;
        Integer bInteger = 129;
        System.out.println("Are two Integers equal?");
        System.out.println(aInteger == bInteger);
        assertEquals(aInteger, bInteger);
        //try5 false
        boolean try5 = Flik.isSameNumber(aInteger, bInteger);
        System.out.println("What does isSameNumber say?");
        System.out.println(try5);

        int aInt = 129;
        int bInt = 129;
        assertEquals(aInt, bInt);
        System.out.println("Are two Ints equal?");
        System.out.println(aInt == bInt);
        boolean try6 = Flik.isSameNumber(aInt, bInt);
        System.out.println("What does isSameNumber say?");
        System.out.println(try6);
        // Integer can't hold more than 127.
        // int can.
        // But when you feed int into Integer in Flik.isSameNumber
        // int converts to Integer so ... yeah

    }

    @Test
    public void testHS(){

    }
}
