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
      
        static void merge(int[] ch, int start, int mid, int end){
            int mA[] = new int[end-start+1];   
            int i=start,j=mid+1,k=0;
            while(i<=mid && j<=end){
               if(ch[i]<ch[j]) mA[k++] = ch[i++];
               else mA[k++] = ch[j++];    
            }

            //left valus in 1st array
            while(i<=mid)  mA[k++] = ch[i++];

            //left valus in 2nd array
            while(j<=end)  mA[k++] = ch[j++];

            //dump all sorted values into same array
            for(int e : mA) ch[start++] = e;
       }

       public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10,27};
        char[]ch = {'A','E','D','C','B'};
        System.out.println("Original array: " + Arrays.toString(arr));

       mergeSort(arr,0,arr.length-1);
       // Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
       }

    }

    public static class QuickSort{
        public static void main(String[] args){
                int arr[] = {50,5,40,60,30,20,10,50};
                System.out.println("Unsorted = "+Arrays.toString(arr));
                QuickSort(arr, 0, arr.length-1);
                System.out.println("Sorted = "+Arrays.toString(arr));
        }
     
        public static int partion(int arr[],int end){
            int p = arr[end];
            System.out.println("Pivot = "+p);
            int i=-1;
            for(int j=0;j<=end;j++){
                if(arr[j]<=p){
                    i++;
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
                System.out.println("Stage 1 = "+Arrays.toString(arr));
                //    int temp = arr[i+1];
                //    arr[i+1]=arr[end];
                //    arr[end]=temp;
                // System.out.println("After Pivot = "+Arrays.toString(arr));
            return i;
        }  
        static void printArrays(int arr[],int start,int end){
            int temp[] = new int[end-start+1];
            int i=0;
            while(start<=end) temp[i++] =arr[start++];
            System.out.println("Partion = "+Arrays.toString(temp));
        }
        
        public static void QuickSort(int[] arr, int start, int end){
            if(start<end){
                int p = partion(arr,end);
                //printArrays(arr,start, p-1);
                QuickSort(arr, start, p-1);
                //printArrays(arr,start, p-1);
                QuickSort(arr, p+1, end);
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void bubbleSort(int arr[]){
      for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]) swap(arr,j,j+1);
            }
      }
    }
     public static void selectionSort(int arr[]){
     }
     
    public static void swap(int arr[],int a,int b){
        int temp =arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String[] args) {
        int arr[] = {50,3,20,10,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                if(i==j) System.out.print(i);
    }
}
