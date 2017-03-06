import java.util.*;

public class ReverseInteger {
    
    public static void main (String[] args) {
    
        int n;

        if (args.length == 0) {
            System.out.println("No input provided...Enter input integer now... : ");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            sc.close();
        } else {
            try {
                n = Integer.parseInt(args[0]);
            } catch (Exception e) {
                System.out.println("Unable to parse input as integer.\t" + e);
                System.exit(1);
            } finally {
                n = Integer.parseInt(args[0]);
            }
        }

        int rev = 0;

        while ( n != 0 ) {
            
            rev = rev*10 + n%10;
            n = n/10;
        }

        System.out.println("Reverse is : " + rev);

    }
}
