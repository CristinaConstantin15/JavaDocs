package exercise4;

import exercise6.MyResizableHashMap;

import java.util.*;
import java.lang.*;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 *
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 * The hash function that you will use in order to store a pair in a specific bucket will be
 * the one presented earlier: (hashcode value) modulo (bucket array size)
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    private int size = 0;

    public MyHashMap() {

        //Initialize buckets list
        buckets = new ArrayList<LinkedList<MyEntry>>(BUCKET_ARRAY_SIZE);
        for(int i=0; i<16; ++i){
            buckets.add(new LinkedList<MyEntry>());
        }
    }

    public String get(String key) {
        for(LinkedList<MyEntry> list : buckets){
            for(MyEntry entry : list){
                if(entry.getKey().equals(key))
                    return entry.getValue();
            }
        }
        return  null;
    }

    public ArrayList<LinkedList<MyEntry>> resize(ArrayList<LinkedList<MyEntry>> array){
        int size = array.size();
        ArrayList<LinkedList<MyEntry>> temp = new ArrayList<LinkedList<MyEntry>>();
        for(int i=0; i<temp.size(); ++i){
            temp.set(i, array.get(i));
        }

        array = new ArrayList<LinkedList<MyEntry>>(2 * size);
        for(int i=0; i<temp.size(); ++i){
            array.set(i, temp.get(i));
        }

        return array;
    }

    public void put(String key, String value) {
        /*int nrBuckets = 0;

        for(LinkedList<MyEntry> list : buckets){
            if(list != null){
                nrBuckets++;
            }
        }

        if(nrBuckets < buckets.size() && (double)nrBuckets/buckets.size() < 0.75 * BUCKET_ARRAY_SIZE){
            buckets.get(key.hashCode()%16).add(entry);
        }*/
        if(key != null){
            if(!containsKey(key)){
                MyEntry entry = new MyEntry(key,value);
                buckets.get(Math.abs(key.hashCode()%16)).add(entry);
            }
        }else{
            if(!containsKey(key))
                buckets.get(0).add(new MyEntry(key, value));
        }


    }

    public Set<String> keySet() {
        Set<String> keySet = new HashSet<String>();
        for(LinkedList<MyEntry> list : buckets) {
            for (MyEntry entry : list) {
                keySet.add(entry.getKey());
            }
        }
        return keySet;
    }

    public Collection<String> values() {
        Collection<String> values = new LinkedList<String>();
        for(LinkedList<MyEntry> list : buckets) {
            for (MyEntry entry : list) {
                values.add(entry.getValue());
            }
        }
        return values;
    }

    public String remove(String key) {
        // Returns the value associated with the key removed from the map or null if the key wasn't found
        String value ="";
        for(LinkedList<MyEntry> list : buckets) {
            for (MyEntry entry : list) {
                if(entry.getKey().equals(key)) {
                    value = entry.getValue();
                    list.remove(entry);
                    return value;
                }
            }
        }
        return null;
    }

    public boolean containsKey(String key) {
        for(LinkedList<MyEntry> list : buckets) {
            for (MyEntry entry : list) {
                if(entry.getKey().equals(key))
                    return true;
            }
        }
        return false;
    }

    public boolean containsValue(String value) {
        for(LinkedList<MyEntry> list : buckets) {
            for (MyEntry entry : list) {
                if(entry.getValue().equals(value))
                    return true;
            }
        }
        return false;
    }

    public int size() {
        for(LinkedList<MyEntry> list : buckets) {
            for (MyEntry entry : list) {
                    size++;
            }
        }
        return size;
    }

    public void clear() {
        // Remove all the Entry objects from the bucket list
        for(LinkedList<MyEntry> list : buckets) {
            for (MyEntry entry : list) {
                remove(entry.getKey());
            }
        }

    }

    public Set<MyEntry> entrySet() {
        // Return a Set containing all the Entry objects
        Set<MyEntry> entrySet = null;
        for(LinkedList<MyEntry> list : buckets) {
            for (MyEntry entry : list) {
                entrySet.add(entry);
            }
        }

        return entrySet;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
