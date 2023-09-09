public class BinarySearchQuestions {
    //Brute force
public static int peakIndexInMountainArrayLinear(int[] arr) {
            int ans=0;
            int index=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i] > ans){
                    ans = arr[i];
                    index = i;
                }
            }
            return index;
        }

//optimised
public static int peakIndexInMountainArrayBinary(int[] arr) {
            int start=0, end=arr.length-1;
            while(start<end){
                int mid = start + (end-start)/2;
                if(arr[mid]>arr[mid+1]) end = mid;
                else start = mid+1;
              }
              return start;
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
    
    private static int findLastOccurrence(int[] nums, int target) {
            int left = 0;
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
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
                int n1 = nums1.length;
                int n2 = nums2.length;
        
                // If nums1 is larger than nums2, swap them to ensure n1 is smaller than n2.
                if (n1 > n2) {
                    return findMedianSortedArrays(nums2, nums1);
                }
        
                int l = 0;
                int r = n1;
                while (l <= r) {
                    int mid1 = (l + r) / 2;
                    int mid2 = (n1 + n2 + 1) / 2 - mid1;
        
                    int maxLeft1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
                    int minRight1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
        
                    int maxLeft2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
                    int minRight2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];
        
                    if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                        if ((n1 + n2) % 2 == 0) {
                            return (double) (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                        } else {
                            return (double) Math.max(maxLeft1, maxLeft2);
                        }
                    } else if (maxLeft1 > minRight2) {
                        r = mid1 - 1;
                    } else {
                        l = mid1 + 1;
                    }
                }
        
                return -1;
            }
     
    public class CountOccurrencesInSortedArray {

                public static int countOccurrences(int[] nums, int target) {
                    int firstOccurrence = findFirstOccurrence(nums, target);
                    int lastOccurrence = findLastOccurrence(nums, target);
            
                    if (firstOccurrence == -1 || lastOccurrence == -1) {
                        return 0; // Target element not found in the array
                    }
            
                    return lastOccurrence - firstOccurrence + 1;
                }
            
                private static int findFirstOccurrence(int[] nums, int target) {
                    int low = 0;
                    int high = nums.length - 1;
                    int firstOccurrence = -1;
            
                    while (low <= high) {
                        int mid = low + (high - low) / 2;
            
                        if (nums[mid] == target) {
                            firstOccurrence = mid;
                            high = mid - 1; // Continue searching on the left side to find the first occurrence
                        } else if (nums[mid] < target) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
            
                    return firstOccurrence;
                }
            
                private static int findLastOccurrence(int[] nums, int target) {
                    int low = 0;
                    int high = nums.length - 1;
                    int lastOccurrence = -1;
            
                    while (low <= high) {
                        int mid = low + (high - low) / 2;
            
                        if (nums[mid] == target) {
                            lastOccurrence = mid;
                            low = mid + 1; // Continue searching on the right side to find the last occurrence
                        } else if (nums[mid] < target) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
            
                    return lastOccurrence;
                }
            
                public static void main(String[] args) {
                    int[] nums = {1, 2, 2, 2, 3, 4, 4, 5};
                    int target = 2;
                    System.out.println("Occurrences of " + target + ": " + countOccurrences(nums, target)); // Output: 3
                }
            }
        
           
    public static int findMinInRotatedSorted(int[] nums) {
                    int start = 0, end = nums.length-1;
            
                    while(start < end){
            
                      int  mid = (start+end) / 2;
                        if(mid>0 && nums[mid] < nums[mid-1])
                         return nums[mid];
                        if(nums[start] <= nums[mid] && nums[mid] > nums[end])
                         start = mid + 1;
                        else
                         end = mid - 1;
                    }
                    return nums[start];
                }
            
    public int searchinRotatedArray(int[] nums, int target) {
                        int start = 0, end = nums.length - 1;
                        int mid = (start + end) / 2;
                        while (start <= end) {
                            mid = (start + end) / 2;
                            if (target == nums[mid]) {
                                return mid;
                            }
                            if (nums[start] <= nums[mid]) {
                                if (nums[start] <= target && nums[mid] >= target) {
                                    end = mid - 1;
                                } else {
                                    start = mid + 1;
                                }
                            } else {
                                if (nums[end] >= target && nums[mid] <= target) {
                                    start = mid + 1;
                                } else {
                                    end = mid - 1;
                                }
                            }
                        }
                        return -1;
                    }
                
    public class SearchInsertPosition {

    public static int searchInsertPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // If the target is not found, 'left' will be the insert position.
        return left;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 6};
        int targetValue = 4;
        int insertPosition = searchInsertPosition(sortedArray, targetValue);
        System.out.println("Insert position: " + insertPosition);
    }
}

    public class MedianSolution {
                public double findMedianSortedArrays(int[] nums1, int[] nums2) {
                    
                    //if the length of nums1 is greater than nums2, then call the algorithm...
                    if (nums1.length > nums2.length) {
                        return findMedianSortedArrays(nums2, nums1);
                    }
                    
                    // Pointers for binary search...
                    int beg = 0;
                    int end = nums1.length;
                    
                    // Binary search starts from here
                    while (beg <= end) {
                        
                        // Partitions of both the array
                        int part1 = (beg + end) / 2;
                        int part2 = (nums1.length + nums2.length + 1) / 2 - part1;
                        
                        // If there are no elements left on the left side after partition
                        int maxL1 = part1 == 0 ? Integer.MIN_VALUE : nums1[part1 - 1];
                        // If there are no elements left on the right side after partition
                        int minR1 = part1 == nums1.length ? Integer.MAX_VALUE : nums1[part1];
                        // Similarly for nums2
                        int maxL2 = part2 == 0 ? Integer.MIN_VALUE : nums2[part2 - 1];
                        int minR2 = part2 == nums2.length ? Integer.MAX_VALUE : nums2[part2];
                        
                        //when the following case is satisfied,
                        //we find the median based on array size is even or odd...
                        if (maxL1 <= minR2 && maxL2 <= minR1) {
                            // if array size is even, we add the max value from left side
                            //with min value from right side...
                            if ((nums1.length + nums2.length) % 2 == 0) {
                                return (Math.max(maxL1, maxL2) + Math.min(minR1, minR2)) / 2.0;
                            }
                            // if array size is odd we return the max of the two array's left hand-side value..
                            else {
                                return Math.max(maxL1, maxL2);
                            }
                        }
                        // If we are too far on the right, we need to go to left side...
                        else if (maxL1 > minR2) {
                            end = part1 - 1;
                        }
                        // If we are too far on the left, we need to go to right side...
                        else {
                            beg = part1 + 1;
                        }
                    }
                    return 1;
                }
            }
        
        public static void main(String[] args) {
            int[] nums = {5, 7, 7, 8, 8, 10}; // Example sorted array
            int target = 8;
            int arr[] = {4,5,6,7,8,3};
            System.out.print(findMinInRotatedSorted(arr));
           // int[] result = searchRange(nums, target);
            // System.out.println("First occurrence: " + findFirstOccurrence(nums,target));
            // System.out.println("Last occurrence: " + findLastOccurrence(nums,target));
        }
    

}
