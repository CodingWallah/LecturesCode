import java.util.Arrays;
import java.util.Stack;

public class StackQuestions {

    public static void main(String[] args) {
        int[] arr = {10,30,20,40,50}; //{4, 5, 2, 10, 8}; //
        int[] arr2 = {3,2,1,5};
        int[] result1 = nextGreatestToRight(arr);
        int[] result2 = nextGreatestToLeft(arr2);
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

        int[] prices = {100, 20, 50, 80, 100,20};
        int[] span = calculateSpan(prices);
        System.out.println("\n Stock-Span");
        System.out.println(Arrays.toString(prices));
        System.out.println(Arrays.toString(span));

        int[] heights = {3,2,1,2,4,2};//{2, 1, 5, 6, 2, 3};
        System.out.println("\n Maximum Area of Histogram: " + maxHistogramArea(heights));
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

    //Stock Span Problem Based on NGL
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); 
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }
            
            // Calculate the span for the current day.
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            
            // Push the index of the current day onto the stack.
            stack.push(i);
        }
        
        return span;
    }
    
    //MAH Based on NSL & NSR
     public static int maxHistogramArea(int[] heights) {
            //  int n = heights.length, maxArea = 0;
            //  Stack<Integer> stack = new Stack<>();

        //     while (i < n) {
        //         if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
        //             stack.push(i++);
        //         } else {
        //             int top = stack.pop();
        //             maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        //         }
        //     }

        //     while (!stack.isEmpty()) {
        //         int top = stack.pop();
        //         maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        //     }

         Stack<Integer> stack = new Stack<>();
         int n  = heights.length;
        int[] left = new int[heights.length];
        //     return maxArea;
        //NSL concept - jisme ( address store krenge either next of smaller or 0 (if not found))
         // next building add -> stack.peek() + 1;
        for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
            stack.pop();
        }
        left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
        stack.push(i);
    }

    // Clear the stack for re-use
    stack.clear();

     int[] right = new int[heights.length];
     //NGL concept - jisme ( address store krenge either addd of prvs smaller builiding or size(if not found))
     // prvs building add -> stack.peek() - 1;
    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
            stack.pop();
        }
        right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
        stack.push(i);
    }

    // Calculate the maximum area by iterating through the bars
    int maxArea = 0;
    System.out.println("right " + Arrays.toString(right));
    System.out.println("left" + Arrays.toString(left));
    for (int i = 0; i < n; i++) {
        int area = heights[i] * (right[i] - left[i] + 1);
        maxArea = Math.max(maxArea, area);
    }

    return maxArea;
        }

    //Rain Water Trapping = NGL
    public static class RainwaterTrappingBinarySearch {
    public static int trap1(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0; // Not enough elements to trap water
        }
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        // Calculate the maximum height to the left of each position
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        
        // Calculate the maximum height to the right of each position
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        int trappedWater = 0;
        
        for (int i = 1; i < n - 1; i++) {
            int minBoundary = Math.min(leftMax[i - 1], rightMax[i + 1]);
            if (minBoundary > height[i]) {
                trappedWater += minBoundary - height[i];
            }
        }
        
        return trappedWater;
    }

    //It is Based on NGL
     public static int trap2(int[] height) {
        if (height == null || height.length <= 2) {
            return 0; // Not enough elements to trap water
        }

        int n = height.length;
        int trappedWater = 0;
        Stack<Integer> stack = new Stack<>();

        for (int current = 0; current < n; current++) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();

                if (stack.isEmpty()) break;

                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                trappedWater += distance * boundedHeight;
            }
            
            stack.push(current);
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int array = trap1(height);
        System.out.println("Trapped water: " + array); 

        int stack = trap2(height);
        System.out.println("Trapped water: " + stack); 
    }

}

    
}