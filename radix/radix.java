import java.util.*;

public class radix {

    public static String findRadix (int v, int r) {
    
        StringBuilder sol = new StringBuilder();
        int rem = 0;
        int div = 0;

        while (v != 0) {
            rem = v%r;
            if (rem > 9) {
                char c = (char)(87 + rem);
                System.out.println("c: " + c);
                sol.append(c);
            } else sol.append(""+rem);
            v = v/r;
            System.out.println("v:"+v+"\trem:"+rem+"\tsol:"+sol.toString());
        }

        return sol.reverse().toString();
    }

    public static void main(String[] args) {
    
        int V = Integer.parseInt(args[0]);
        int R = Integer.parseInt(args[1]);

        System.out.println("\n\n" + V + " represented in radix " + R + ": " + findRadix(V,R));
    }

}
