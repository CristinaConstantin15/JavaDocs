package exercise0;

import java.lang.*;
import java.util.*;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 *          print all its elements.
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughMap(){

        // Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        // Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map
        Map<Integer, String> myMap = new HashMap<Integer, String>();
        myMap.put(1, "unu");
        myMap.put(2, "doi");
        myMap.put(3, "trei");
        myMap.put(4, "patru");
        myMap.put(5, "cinci");

        // Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        // Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]
        Set<Integer> keySet = myMap.keySet();
        System.out.println(myMap);

        System.out.println("------------------------");

        System.out.print("[");
        for(Integer s : keySet){
            System.out.print(s + "=" + myMap.get(s));
            System.out.print(", ");
        }

        System.out.print("]");

        
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
