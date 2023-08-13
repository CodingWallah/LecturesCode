import java.util.Arrays;

public class SortingLecture {

    public static class Merge2SortedArrays {
        static int[] merge2SortedArrays(int a1[], int a2[]){
            int mA[] = new int[a1.length+a2.length];   
            int i=0,j=0,k=0;
            while(i<a1.length && j<a2.length){
               if(a1[i]<a2[j]) mA[k++] = a1[i++];
               else mA[k++] = a2[j++];    
            }

            //left valus in 1st array
            while(i<a1.length)  mA[k++] = a1[i++];

            //left valus in 2nd array
            while(j<a2.length)  mA[k++] = a2[j++];

            return mA;
        }
   // Print the merged array
        public static void main(String[] args) {
         int[] arr1 = {1, 3,4, 5, 7, 9, 10};
        int[] arr2 = {2, 4, 6, 8, 10};

        int[] mergedArray = merge2SortedArrays(arr1, arr2);

        System.out.println("Sorted array: " + Arrays.toString(mergedArray));
    
    }
}

public static class MergeSort {
      private static void mergeSort(int[] arr, int left, int right) {
         if(left<right){
            int mid = (left + right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
          }
        }
      
        static void merge(int arr[], int start, int mid, int end){
            int mA[] = new int[end-start+1];   
            int i=start,j=mid+1,k=0;
            while(i<=mid && j<=end){
               if(arr[i]<arr[j]) mA[k++] = arr[i++];
               else mA[k++] = arr[j++];    
            }

            //left valus in 1st array
            while(i<=mid)  mA[k++] = arr[i++];

            //left valus in 2nd array
            while(j<=end)  mA[k++] = arr[j++];

            //dump all sorted values into same array
            for(int e : mA) arr[start++] =e;
       }

       public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10,27};
        
        System.out.println("Original array: " + Arrays.toString(arr));

        //mergeSort(arr,0,arr.length-1);
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
       }

    }
}