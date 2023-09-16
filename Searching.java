public class Searching {

      public static void main(String[] args) {
            int[] array = { 10, 25, 30, 15, 20 };
            int[] sarray = {10,20,30,55,65,87,98};//{ 15, 25, 35, 45, 55};
            int[] descarray = {98,58,48,32,22,20,10};
            int target = 22;
            
            int result = binarySearchReverse(descarray,target);//binarySearchR(sarray,target,0,sarray.length-1);//binarySearchI(sarray, target);
            if (result != -1) {
                System.out.println("Element found at index " + result);
            } else {
                System.out.println("Element not found in the array.");
            }
        }

    public static int linearSearchI(int[] arr, int target){
        for(int i=0 ; i<arr.length ; i++){
        // If the target is found at the current index, return the index
        if(arr[i]==target) return i;
        }
        // If the target is not found return -1
        return -1;
    }

    public static int linearSearchR(int[] arr, int target, int index) {
            // Base case: If the index is out of bounds, return -1 (element not found)
            if(index>=arr.length) return -1;
            // Base case: If the target is found at the current index, return the index
            if(arr[index]==target) return index;
            // Recursive case: Search the next element in the array
            return linearSearchR(arr, target, index+1);

        }
    
    public static int binarySearchI(int[] arr, int target) {
           int s=0,mid=0,e = arr.length-1;
           while(s<=e) {
            // Find Mid
               // mid = (s+e)/2;
               mid = s + (e-s)/2;
            // Element found at index mid
            if(arr[mid]==target) return mid;
            // Search in the right half
           else if(arr[mid]<target) s=mid+1;
            // Search in the left half
            else e = mid-1;
           }
            // Element not found in the array
            return -1;
    }

    public static int binarySearchReverse(int[] arr, int target) {
           int s=0,mid=0,e = arr.length-1;
           while(s<=e) {
            // Find Mid
               // mid = (s+e)/2;
               mid = s + (e-s)/2;
            // Element found at index mid
            if(arr[mid]==target) return mid;
            // Search in the right half
           else if(arr[mid]>target) s=mid+1;
            // Search in the left half
            else e = mid-1;
           }
            // Element not found in the array
            return -1;
    }

    
      public static int binarySearchR(int[] arr, int target, int start, int end) {
         if(start<=end)  {
         // Find Mid
            int mid = start+ (end-start)/2;
            // Element found at index mid
            if(arr[mid]==target) return mid;
            // Search in the right half
            else if(arr[mid]<target) return binarySearchR(arr,target,mid+1,end);
            // Search in the left half
            else  return binarySearchR(arr,target,start,mid-1);
        }
            // Element not found in the array
            return -1;
    }

    public static class FirstAndLastPositionInSortedArray {
        public static int[] searchRange(int[] nums, int target) {
            int[] result = {-1, -1};
    
            // Search for the first occurrence of the target
            result[0] = findFirstOccurrence(nums, target);
    
            // Search for the last occurrence of the target, but starting from the first occurrence found
            result[1] = findLastOccurrence(nums, target, result[0]);
    
            return result;
        }
    
        private static int findFirstOccurrence(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int firstOccurrence = -1;
    
            while (left <= right) {
                int mid = left + (right - left) / 2;
    
                if (nums[mid] == target) {
                    firstOccurrence = mid;
                    right = mid - 1; // Continue searching in the left half for the first occurrence
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
    
            return firstOccurrence;
        }
    
        private static int findLastOccurrence(int[] nums, int target, int startFrom) {
            int left = startFrom;
            int right = nums.length - 1;
            int lastOccurrence = -1;
    
            while (left <= right) {
                int mid = left + (right - left) / 2;
    
                if (nums[mid] == target) {
                    lastOccurrence = mid;
                    left = mid + 1; // Continue searching in the right half for the last occurrence
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
    
            return lastOccurrence;
        }
    
        public static void main(String[] args) {
            int[] nums = {5, 7, 7, 8, 8, 10}; // Example sorted array
            int target = 8;
    
            int[] result = searchRange(nums, target);
            System.out.println("First occurrence: " + result[0]);
            System.out.println("Last occurrence: " + result[1]);
        }

        public static class MotivationalCode {
          public static void main(String[] args) {
            boolean keepTrying = true; 
            String quote1 = "You try- You Fail,";
            String quote2 = "But the Real Failure is when you stop trying.";
            String quote3 = "Keep trying, and you'll succeed!";
            String quote4 = "You've decided to take a break.";
            String quote5 = "Remember, you can always come back and ";
            String quote6 = quote5.concat("try again later!");
                if (keepTrying) {
                    System.out.println(quote1 +quote1+ quote2);
                    System.out.println(quote3);
                } else {
                    System.out.println(quote4);
                    System.out.println(quote6);
                }
         }
        }


        
    }
    
}
