import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static HashMap<Integer,String> map;
    
    public static String[] getRest(int[] a, int f) {
    
        List<String> list = new ArrayList<String>();
        
        if (f == a.length - 1) {
            String first = map.get(a[f]);
            for (int i = 0 ; i < first.length(); i++) {
                list.add( first.charAt(i) + "" );
            }
            return list.toArray(new String[first.length()]);
        }
        
        String first = map.get(a[f]);
        String[] rest = getRest(a,f+1);
        for (int i = 0 ; i < first.length(); i++) {
            for (String s : getRest(a,f+1)) {
                list.add( first.charAt(i) + s );
            }
        }
        
        return list.toArray(new String[0]);
        
    }
    
	public static void main (String[] args) {
	    
	    map  = new HashMap<Integer,String>();
	    map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
		Scanner sc = new Scanner(System.in);
		int numTest = sc.nextInt();
		for (int i = 0; i < numTest; ++i) {
		    int n = sc.nextInt();
    		int[] digits = new int[n];
    		for (int j = 0 ; j < n; ++j) {
    		    digits[j] = sc.nextInt();
    		}
    		for (String s : getRest(digits,0)) {
    		    System.out.print(s + " ");
    		}
		}
		
		
	}
}

//Welcome to EditPad.org - your online plain text editor. Enter or paste your text here. To download and save it, click on the button below.
