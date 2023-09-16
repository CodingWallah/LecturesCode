import java.util.Arrays;
import java.util.Stack;

public class StackQuestions {

    public static void main(String[] args) {
        int[] arr = {10,30,20,40,50}; //{4, 5, 2, 10, 8}; //
        int[] result1 = nextGreatestToRight(arr);
        int[] result2 = nextGreatestToLeft(arr);
        int[] result3 = nearestSmallerToRight(arr);
        int[] result4 = nearestSmallerToLeft(arr);
        
        // Print the result array.
        System.out.println("nextGreatestToRight");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result1));

        System.out.println("nextSmallerToRight");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result3));

        System.out.println("nextGreatestToLeft");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result2));

        System.out.println("nextSmallerToLeft");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result4));

        
    }

     public static int[] nextGreatestToRight(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        // Traverse the input array in reverse.
        for (int i = arr.length - 1; i >= 0; i--) {
            // While the stack is not empty and the current element is greater
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()])  stack.pop();
            result[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i);
        }
        return result;
    }

    public static int[] nearestSmallerToRight(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        // Traverse the input array.
        for (int i = arr.length - 1; i >= 0; i--) {
            // While the stack is not empty and the current element is less
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()])  stack.pop();
            result[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i);
        }
        return result;
    }

    public static int[] nextGreatestToLeft(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        // Traverse the input array.
        for (int i = 0; i < arr.length; i++) {
            // While the stack is not empty and the current element is greater
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()])  stack.pop();
            result[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i);
        }
        return result;
    }

    public static int[] nearestSmallerToLeft(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        // Traverse the input array.
        for (int i = 0; i < arr.length; i++) {
             // While the stack is not empty and the current element is less
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) stack.pop();
            result[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
             stack.push(i);
        }
        return result;
    }
}
