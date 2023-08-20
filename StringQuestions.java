import java.util.*;
public class StringQuestions {

    public static boolean arerotations(String s1, String s2) {
        if (s1.length() != s2.length())   return false;
        s1 = s1 + s1;
            return s1.indexOf(s2) != -1;
    }

    static boolean NaiveAnagramApproach(String s1, String s2) 
    {     
        if (s1.length() != s2.length()) 
            return false; 
  
        char a1[]=s1.toCharArray();
        Arrays.sort(a1);
        s1=new String(a1);
       // System.out.println(s1);
        
        char a2[]=s2.toCharArray();
        Arrays.sort(a2);  
        s2=new String(a2);
      //  System.out.println(s1);
        
        return s1.equals(s2);
    } 
       
    static boolean EfficientAnagram(String s1, String s2) 
    { 
       
        if (s1.length() != s2.length()) 
            return false; 
  
       final int CHAR=256;  
       int[] count=new int[CHAR];

       for(int i=0;i<s1.length();i++){
        //increase count from first string
        count[s1.charAt(i)]++;

        //decrease count from Second string
        count[s2.charAt(i)]--;
       }
    
        for(int i=0;i<CHAR;i++){
            if(count[i]!=0)return false;
        }
        return true;
    } 

    static String reverseWords(String s) {
            String[] words = s.trim().split("\\s+");
            StringBuilder reversed = new StringBuilder();
            
            for (int i = words.length - 1; i >= 0; i--) {
                  reversed.append(words[i]);
                 if (i > 0)  reversed.append(" ");
            }
            return reversed.toString();
        }
    
    //another approach using BS concept
    
        public static String toggleCaseWithMethod(String s) {
            char[] charArray = s.toCharArray();
    
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (c >= 'A' && c <= 'Z') {
                    charArray[i] = (char) (c + ('a' - 'A'));
                } else if (c >= 'a' && c <= 'z') {
                    charArray[i] = (char) (c - ('a' - 'A'));
                }
            }
    
            return new String(charArray);
        }
    
    public static String toggleCase(String s) {
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {
                charArray[i] = Character.toLowerCase(charArray[i]);
            } else if (Character.isLowerCase(charArray[i])) {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }

        return new String(charArray);
    }

    public static void main(String args[]) 
    { 
        //Rotation of String
        // String s1 = "ABCD";
        // String s2 = "CDAB";
        // System.out.println(arerotations(s1, s2));
       
        String str = "Nitin";
        printAllSubstring(str);
       // System.out.println(isPalindrome(str));
       System.out.println("==========");
        printAllPalSubstring(str);
        System.out.println(countPalSubstring(str));
        //Reverse Words
        //  String input = "  Shivam! Sharma  ";
        // String reversed = reverseWords(input);
        // System.out.println("Reversed words: \"" + reversed + "\""); // Output: "world! hello"
    

        // String Tinput = "Hello World";
        // String toggled = toggleCase(Tinput);
        // System.out.println("Toggled string: \"" + toggled + "\"");
       
        //Anagram of String
        // String str1 = "ShivAm "; 
        // String str2 = " vAmShi";  
        // if (NaiveAnagramApproach(str1, str2)) 
        //     System.out.println("Are anagram of each other"); 
        // else
        //     System.out.println("Are Not anagram of each other"); 

        //Ruff work
        //String s1 = "Aditya Joshi";
        //System.out.println(s1.indexOf("Joshi"));
        //System.out.println(s1.indexOf("po"));
    }

    private static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        
        int f=0, l = str.length()-1;
        while(f<l){
            if(str.charAt(f)!=str.charAt(l)) return false;
            f++;
            l--;
        }
        return true;
    }

    private static void printAllSubstring(String str) {
        for(int i = 0; i < str.length(); i++){
            for(int j = i+1; j <= str.length(); j++){
                    System.out.println(str.substring(i, j));
          }
        }
     } 

     private static void printAllPalSubstring(String str) {
        for(int i = 0; i < str.length(); i++){
            for(int j = i+1; j <= str.length(); j++){
                    if(isPalindrome(str.substring(i, j))) 
                        System.out.println(str.substring(i, j));
          }
        }
     } 

      private static int countPalSubstring(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            for(int j = i+1; j <= str.length(); j++){
                    if(isPalindrome(str.substring(i, j))) 
                        count++;
          }
        }
        return count;
     } 

    }
