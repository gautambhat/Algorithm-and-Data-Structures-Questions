package src;

import java.util.*;

public class Driver {

    public static void main (String[] args) {
        
        int Capacity = 5; //EXAMPLE
        LRUCache obj = new LRUCache(Capacity);
        
        int key = 1;
        
        for (int i = 0; i < Capacity; i++) {
            obj.put(key, (int)(key*2.75));
            key++;
        }

        System.out.println(obj.get(2));
    } 
}
