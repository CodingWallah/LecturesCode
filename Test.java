import java.util.Arrays;

public class Test {
    public static int peakIndexInMountainArrayLinear(int[] arr) {
        int ans=0;
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > ans){
                ans = arr[i];
                index = i;
            }
        }
        return ans;
    }
 
    public static void main(String[] args) {
        int[] arr= {0,1,2,8,10,20,15,12,10};
        System.out.println(Arrays.toString(arr));
        System.out.println(peakIndexInMountainArrayLinear(arr));
    }
}
