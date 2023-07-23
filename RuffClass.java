public class RuffClass {
//     public static void main(String[] args) {
//       //  System.out.println("Coding Wallah Community");

//         // Long lg = 12395654998765655L;
//         // System.out.println(lg.SIZE);
//         // System.out.println(lg.MAX_VALUE);
//         // System.out.println(lg.MIN_VALUE);
//         String a= "coding wallah";
//         String b= "coding wallah";
//         System.out.println("a==b :");
//         System.out.println("a==b :" + a==b);

//     }

 public static int nestedSum(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + nestedSum(nestedSum(n - 1));
        }
    }
//Recursion
        //  static void recursion(int num){
            
        //      if(num>0)
        //          recursion(num-1);

        //      System.out.println(num);
        //  }

      //Recursion
          static void recursion(int num){
                if(num< 0) return; 

                recursion(num-1);
                System.out.println(num);
          }
    public static void main(String[] args) {
        //int result = nestedSum(2);
        //System.out.println(result);
       // recursion(6);
    }
       public static void main(String arr){
            
       }



 }

