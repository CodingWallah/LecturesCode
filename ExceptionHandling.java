public class ExceptionHandling {
  
    public static void main(String[] args) throws Exception {
                int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
                System.out.println(arr[1]);
                try {
                     System.out.println("Hi");
                     System.out.println(arr[-1]);
                     System.out.println("Hi");
                }finally{
                    System.out.println(arr[0]);
                }
                //catch(Exception e){

                // }
                System.out.println("Hi");    
                //myException();    
                
    }

    static void myException() throws Exception{
        throw new Exception("Something went wrong");

    }
}
