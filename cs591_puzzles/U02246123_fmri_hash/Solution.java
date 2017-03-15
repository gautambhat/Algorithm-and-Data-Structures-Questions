import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

    static long startTime, startTime2, startTime3, startTime4, endTime, endTime2, endTime3, endTime4;
    public static boolean foundPattern(char[][] slice, char[][] pattern, int x, int y) {

      int r = pattern.length;

      for (int i = 0; i < r; i++) {
        for (int j = 0; j < r; j++) {
          //System.out.println(pattern.length + "\tx:" + x + "\ty:" + y + "\ti:" + i + "\tj:" + j);
          //System.out.println(slice[i].length);
          if (pattern[i][j] != slice[i+x][j+y])
          return false;
        }
      }

      return true;

    }

    public static int findPatternNaive(char[][] slice, char[][] pattern) {

      startTime2 = System.currentTimeMillis();

      int n = slice.length;
      int r = pattern.length;

      int numMatches = 0;

      for (int i = 0; i < n-r+1; ++i) {
        for (int j = 0; j <n-r+1; ++j) {
          //System.out.println(i + "\t" + j);
          if (foundPattern(slice,pattern,i,j)) {
            //System.out.println("Found a match at " + i + ", " + j + "!");
            numMatches++;
          }
        }
      }

      return numMatches;
    }

    static public int findPatternHash(char[][] slice, char[][] pattern) {

      startTime3 = System.currentTimeMillis();

      int numMatches = 0;

      int n = slice.length;
      int r = pattern.length; //we will assume it's 2.

      int patternHash = 10*10*((int)pattern[0][0]) + 10*((int)pattern[0][1]) + 10*((int)pattern[1][0]) + ((int)pattern[1][1]);
      int startHash = 10*10*((int)slice[0][0]) + 10*((int)slice[0][1]) + 10*((int)slice[1][0]) + ((int)slice[1][1]);
      int hash = startHash;

      endTime3 = System.currentTimeMillis();
      startTime4 = System.currentTimeMillis();

      for (int i = 0; i < n-r+1; ++i) {
        if (i > 0) {
          hash = ( startHash - 10*10*((int)slice[i-1][0]) - 10*((int)slice[i-1][1]) )*10 + 10*((int)slice[i+1][0]) + ((int)slice[i+1][1]);
        }
        startHash = hash;
        //System.out.println("PatternHash: " +patternHash + "\tSliceHash: " + hash);
        if (hash == patternHash /*&& foundPattern(slice,pattern,i,0)*/) {
          numMatches++;
          //System.out.println("Found a match at " + i + ", " + 0 + "!");
        }
        for (int j = 1; j < n-r+1; ++j) {
          hash = ( hash - 10*10*((int)slice[i][j-1]) - 10*((int)slice[i+1][j-1]) )*10 + 10*((int)slice[i][j+1]) + ((int)slice[i+1][j+1]);
          //System.out.println("PatternHash: " +patternHash + "\tSliceHash: " + hash);
          if (hash == patternHash /*&& foundPattern(slice,pattern,i,j)*/) {
            numMatches++;
            //System.out.println("Found a match at " + i + ", " + j + "!");
          }
        }
      }

      return numMatches;
    }

    public static void main(String[] args) {

      char[][] pattern = {{'H', 'H'},{'H', 'L'}};

      Scanner fileScanner;
      LinkedList<String> w = new LinkedList<String>();
      startTime = System.currentTimeMillis();
      try {
        fileScanner = new Scanner (new File ("fMRI_slice.txt"));
        while (fileScanner.hasNextLine()) {
          w.add(fileScanner.nextLine());
        }
        fileScanner.close();
      }
      catch (IOException e) {
        System.err.println("Unable to open dictionary file. "+e.getMessage());
        System.err.println("Currently in directory "+ System.getProperty("user.dir"));
        System.exit(0);
      }

      String [] words = w.toArray(new String[0]);

      char[][] letters = new char[words.length][];

      for (int i = 0; i < words.length; i++) {
        //System.out.println(words[i]);
        letters[i] = words[i].replace(" ","").toCharArray();
      }
      endTime = System.currentTimeMillis();

      int naiveMatches = findPatternNaive(letters,pattern);
      endTime2 = System.currentTimeMillis();

      int hashMatches = findPatternHash(letters, pattern);
      endTime4 = System.currentTimeMillis();
      System.out.println(startTime + "\t" + endTime + "\n" + startTime2 + "\t" + endTime2 + "\n" + startTime3 + "\t" + endTime3 + "\n" + startTime4 + "\t" + endTime4+ "\n");
      System.out.println("Naive Method:\nPreprocessing Time:\t" + (endTime - startTime) + "ms\nFound " + naiveMatches + " Matches in Slice.\nRun Time:\t" + (endTime2 - startTime2) + "ms\n\nRolling Hash Method:\nPreprocessing Time:\t" + ((endTime - startTime) + (endTime3 - startTime3)) + "ms\nFound " + hashMatches + " Matches in Slice.\nRun Time:\t" + (endTime4 - startTime4) + "ms");


    }

}
