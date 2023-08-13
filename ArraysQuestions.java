public class ArraysQuestions {

static int me=0;

static int a(){
    return 2;
}
  
//me = 20;

{
    me = a();
}

    public static void main(String[] args) {
         int p=20;
        p=30;

        System.out.println(p);
        me = 30;
          System.out.println(me);

         ArraysQuestions.me=20;
    }



int[] rotateArray1(int[] arr, int k) 
{ 
    int[] temp = new int[arr.length];
     for (int i = 0; i < arr.length; i++) { 
        temp[(i + k) % arr.length] = arr[i]; 
    } return temp; 
}

void reverse(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

public static void reverseArray(int[] arr) {
    int temp;
    for (int i = 0; i < arr.length / 2; i++) {
      temp = arr[i];
      arr[i] = arr[arr.length - 1 - i];
      arr[arr.length - 1 - i] = temp;
    }
  }
  
void rotateArray(int[] arr, int k) {
    k = k % arr.length;
    reverse(arr, 0, arr.length - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, arr.length - 1);
}

}

    