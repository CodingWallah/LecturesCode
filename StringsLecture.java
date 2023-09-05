import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StringsLecture {
    public static void main(String[] args) {
       char[] myString  = {'m','a','n','a','n'};
       System.out.println(myString);

       int myInt[] = {1,2,3,4,5,6,7,8};
       System.out.println(myInt);

       String str = Arrays.toString(myString);
       //String st = myString;
       String st1 = myInt.toString(); //address dega
       System.out.println(str); 
      
       System.out.println(st1);
       
        // System.out.println(str);
        String s1 = "Shivam Sharma";
        String s2 = "Shivam Sharma";
        System.out.println(s1);
        s1 = s1+"-Mahi"; // + -> rep to concat btw the strings
        System.out.println(s1);
    //     //3rd way to create a string
        // String s3 = new String("Shivam Sharma");
    //     String s4 = new String("Shivam Sharma");

    //    System.out.println(s1==s2); //t
    //     System.out.println(s3==s4); //f
    //     System.out.println(s1==s4); //f

        StringBuffer sbf = new StringBuffer("Shiv");
         StringBuilder sbl = new StringBuilder("Shiv");
         sbl.setCharAt(0, 'X');
    //    // System.out.println(sbf==sbl);

    //Methods of the string
    System.out.println(s1.equals(s2));
    System.out.println(s1.indexOf('h'));
    System.out.println(s1.indexOf('h',2));
    s1 = "Shivam Sharma Shivam";
    System.out.println(s1.indexOf("Shivam",1));
    System.out.println(s1.indexOf("Sharma"));

    System.out.println(s1.substring(0, 16));
    System.out.println(s1.substring(16));

    //contains check the seqenuce only 
    System.out.println(s1.contains("Shivam"));
    System.out.println(s1.contains("mavhis"));
    
     s1 = "Uhaajs";
     s2 = "Shivam";
     
    //compare methods
    //s1>s2 = pstv
    //s1==s2 (character bhi same h )= 0
    //s1 == s2 (if length is equal but CHARACTERS are different then compare only first character) => uske according pstv negative
    //s1<s2 = negative
    System.out.println("Compare "+s1.compareTo(s2));
    System.out.println(97-65);

    //Java Strores char in UTF 16 format
    System.out.println((int)'A');
    System.out.println((int)'a');


    //String concatenation => .concat() or + (plus)
    System.out.println("String"+1);
    System.out.println("String"+'C');
    System.out.println(1+"String");
    System.out.println("String"+new ArrayList<>());
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    System.out.println("String"+list);
    System.out.println('A'+'A');
    System.out.println("A"+'A');

    //Oprations in StringBuffer & StringBuilder are :
    StringBuffer sb = new StringBuffer("b");
    String sb1 = "fdfdgdgs";
      //  System.out.println(sb.insert(2, "k"));
        System.out.println(sb.append('c'));
        System.out.println(sb.append(new ArrayList<>()));
      //  System.out.println(sb.replace(1,3,sb1)); //end-1 take repalce hoga
      //  System.out.println(sb.delete(0,5)); //end-1 take delete hoga
        System.out.println(sb.capacity());
        System.out.println(sb.length());
        //auto grow feature like arraylist

        String str1 = "Hello";
String str2 = new String("Hello");
str2 = str2.intern();
System.out.println(str1 == str2);


    }

  
}
