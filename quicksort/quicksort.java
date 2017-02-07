import java.util.*;
//import java.Arrays.*;

class quicksort {
    
    static boolean debug_on = false;

    static void debug(String s) {
        if (debug_on) {
            System.out.println(s);
        }    
    }

   static int[] sort(int[] arr, int l, int h) {
        
        debug("Array: " + Arrays.toString(arr) + "\tl = " + l + "\t h = " + h);
        if (h <= l) return arr;
        int p = h;
        int q = l;
        debug("\tpivot: arr[" + p + "] = " + arr[p] + "\tq =  arr[" + q + "] = " + arr[q]); 

        for (int i = l; i < p; i++) {
            if (arr[i] < arr[p]) {
                int temp = arr[i];
                arr[i] = arr[q];
                arr[q] = temp;
                ++q;
                debug("\t\t" + Arrays.toString(arr) + "\tq =  arr[" + q + "] = " + arr[q]);
            }
        }

        int temp = arr[q];
        arr[q] = arr[p];
        arr[p] = temp;
        debug("\nArray: " + Arrays.toString(arr) + "\n");
        arr = sort(arr, l, q-1);
        arr = sort(arr, q+1, h);
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {6,2,5,1,7,2,9,3,6,2,3};
        System.out.println(Arrays.toString(arr) + "\n\t\t...\n");
        

        if (args.length > 0 && args[0].equals("-debug")) {
           debug_on = true; 
        }

        System.out.println(Arrays.toString(sort(arr,0,arr.length - 1)));
    }
}
