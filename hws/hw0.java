// Creative Exercise 1a: Drawing a Triangle

public class Zeno {
    public static void main(String[] args) {
       String a = "*";
       while (a.length() <= 5) {
          System.out.println(a);
          a = a + "*";

       }


    }
}


// Creative Exercise 1b: DrawTriangle


public class TriangleDrawing {

   public static void drawTriangle(int N){
      String a = "*";
      while (a.length() <= N) {
         System.out.println(a);
         a = a + "*";

      }
   }

   public static void main(String[] args) {
      drawTriangle(10);
   }
}

// ex 2

public class FindMax {
   public static int max(int[] m) {
       int maxnum = 0 ;
       int i = 0;

       while (i < m.length){
         int currnum = m[i];
         if (currnum > maxnum){
           maxnum = currnum;
           }
         i = i+1;
         }
       return maxnum;
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
      System.out.println(max(numbers));
   }
}
// ex 3 for loop

public class FindMax {
   public static int max(int[] m) {
      int maxnum = 0;
      for (int i = 0; i < m.length; i = i + 1 ){
         int currnum = m[i];
         if (currnum > maxnum){
            maxnum = currnum;
         };
      }
      return maxnum;
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
      System.out.println(max(numbers));
   }
}
