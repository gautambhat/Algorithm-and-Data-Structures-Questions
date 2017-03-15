public class Solution {
        
        public static void printArray(boolean[][] subs, String s) {
                    
                    for (int i = 0; i < s.length(); i++) {
                                    System.out.print("\t"+ i+":"+s.charAt(i));
                                            }
                            System.out.println();
                                    
                                    for (int i = 0; i < s.length(); i++) {
                                                    System.out.print(" " + i+":"+s.charAt(i));
                                                                for (int j = 0; j < s.length(); j++) {
                                                                                    System.out.print("\t" + subs[i][j]);
                                                                                                }
                                                                            System.out.println();
                                                                                        System.out.println();
                                                                                                }
                                        }

            public static String longestPalindrome(String s) {
                        
                        if (s.length() < 3) return s;
                                
                                boolean[][] subs = new boolean[s.length()][s.length()];
                                        
                                        for (int i = 0; i < s.length(); i++) {
                                                        subs[i][i] = true;
                                                                }
                                                String longest = s.substring(0,1);
                                                        
                                                        System.out.println("Finding all palindromic substrings of length 2");
                                                                for (int i = 0; i < s.length() - 1; i++) {
                                                                                if (s.charAt(i) == s.charAt(i+1)) {
                                                                                                    subs[i][i+1] = true;
                                                                                                                    subs[i+1][i] = true;
                                                                                                                                    longest = s.substring(i,i+2);
                                                                                                                                                }
                                                                                        }
                                                                        
                                                                        for (int l = 3; l <= s.length(); l++) {
                                                                                        System.out.println("Finding all palindromic substrings of length " + l);
                                                                                                    for (int i = 0; i < s.length() - l + 1; i++) {
                                                                                                                        int start = i;
                                                                                                                                        int end = i+l-1;
                                                                                                                                                        if (s.charAt(start) == s.charAt(end)) {
                                                                                                                                                                                if (subs[start+1][end-1] == true) {
                                                                                                                                                                                                            subs[start][end] = true;
                                                                                                                                                                                                                                    longest = s.substring(start, end+1);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                }
                                                                                                                                                                    }
                                                                                                                
                                                                                                            }
                                                                                
                                                                                printArray(subs,s);
                                                                                        return longest;
                                                                                            }
                
                public static void main (String[] args) {
                            System.out.println("Longest palindromic substring in " + args[0] + " is :  " + longestPalindrome(args[0]));
                                }
}
