import java.util.*;

class fizzbuzz {

    public static void main (String[] args) {
        
        for (int i = 1; i <= 100; ++i) {
        
            if( i%3 == 0 && i%5 == 0)
                System.out.println(i + "\t\tFizzBuzz");    
            
            else if ( i%3 == 0)
                System.out.println(i + "\t\tFizz");

            else if ( i%5 == 0)
                System.out.println(i + "\t\tBuzz");
            
            else System.out.println(i);
            

        }
    
    }

}
