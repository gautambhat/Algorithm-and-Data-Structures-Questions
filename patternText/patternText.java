import java.util.*;

public class patternText {

    public long rollHash (String s, char c, long h) {
        
        int r = s.length() - 1;
        int replace = (int) s.charAt(0);
        int substitute = (int) c;

        return (h - Math.pow(replace,))
    }

    public long newHash (String s) {
        double h = 0;
        for (int i = 0; i < s.length(); ++i) {
            h += Math.pow((int)s.charAt(i),i+1);    
        }
        return (long)h;
    }

    public static void main (String[] args) {
    
        String s = args[0];
        String p = args[1];
        
        System.out.println("Text : " + s + "\tPattern : " + p + "\n");
        int patternLength = p.length();

        for (int i = 0; i <= s.length()-patternLength; i++) {
            if (s.substring(i,patternLength+i).equals(p))
            {
                System.out.println("found, starting at index " + i);
            }
        }
    
    }
}
