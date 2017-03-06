import java.util.*;

class puzzle_1 {

    public static void main(String[] args) {
    
        char[] data = args[0].toCharArray();
        //System.out.println(data.length);
        //System.out.println(data.length / 2);
        System.out.println("This algorithm works assuming THERE IS A MAJORITY ELEMENT in the input. In this case, " + ((data.length/2)+1) + " counts as majority.");
        char curr = '?';
        int count = 0;

        for (char i : data) {
            System.out.println(curr + "-->" + count);
            if (count == 0 ) {
                curr = i;
                count++;
            } else if (curr != i) {
                if (count == 1) {
                    count--;
                    curr = '?';
                }
                else {
                    count--;
                }
            } else {
                count++;
            }
        }
        System.out.println(curr + "-->" + count);
        System.out.println("\n\nMajority Element:" + curr + "\tMajority by a count of: "+count);
    }
}
