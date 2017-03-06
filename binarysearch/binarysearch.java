import java.util.*;

public class binarysearch {

    public static void main(String[] args) {
    
        int[] arr = {-1,0,5,6,8,10,12,13,18,20,25};
        int n = Integer.parseInt(args[0]);
        System.out.println("Array: " + Arrays.toString(arr) + "\t Looking for " + n +"...\n\n");
        int l = 0;
        int h = arr.length - 1;

        while (l <= h) {
            
            int mid = (l+h)/2;
            if (arr[mid] == n) {
                System.out.println("Found at index "+mid+"!");
                return;
            }
            else if (arr[mid] < n) {
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }
    }
}
