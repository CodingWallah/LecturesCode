 import java.util.*;
public class NewRuff {
public static class MergeSort{
    public static void mergeSort(int[]arr,int left,int right){
        if(left>=right) return;
            int mid=(left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
    }
    static void merge(int[]arr,int left,int mid,int right){
        int n1=mid-left-1;
        int n2=right-mid;
        int start[]=new int[n1];
        int end[]=new int[n2];
        int i,j,k;
        for(i=0;i<n1;i++){
            arr[i]=arr[i+1];
        }
        for(j=0;j<n2;j++){
            arr[j]=arr[mid+1+j];
        }
        i=0;j=0;k=0;
        while(i<n1 && j<n2){
            if(arr[i]<=arr[j])
            arr[k++]=arr[i++];
            else arr[k++]=arr[j++];
        }
        //left value in first array
        while(i<n1){
        arr[k++]=arr[i++];
        }
        //right value in first array
        while(j<n2){
        arr[k++]=arr[j++];
        }
    }
    public static void main(String[] args) {
        int []arr={50,10,40,30,20,5};
        int n=arr.length;
        System.out.println("original array:"+Arrays.toString(arr));
        mergeSort(arr,0,n-1);
        System.out.print("After sorting array is: " + Arrays.toString(arr));
    }
}
}
