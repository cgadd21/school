import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Example9 {
    public static void main(String[] args) {
        //Create hashmap - String is the key
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
        //No order is maintained
        System.out.println(hashMap);

        System.out.println(hashMap.get("Lewis"));  //returns 29
        hashMap.remove("Lewis");

        System.out.println("Display keys of HashMap all at once");
        System.out.println(hashMap.keySet());

        System.out.println("Display keys of HashMap one at a time in loop");
        for(String key: hashMap.keySet()){
            System.out.println(key);
        }
        System.out.println("Display values of HashMap all at once");
        System.out.println(hashMap.values());

        System.out.println("Display values of HashMap one at a time in loop");
        for(Integer value: hashMap.values()){
            System.out.println(value + "  ");
        }
        System.out.println();

        System.out.println("Display key/value pairs of HashMap");
        for(Map.Entry<String, Integer> pairs : hashMap.entrySet()){
            String key = pairs.getKey();
            Integer value = pairs.getValue();
            System.out.println("Key: " + key + " Value: " + value);

        }
        System.out.println();

        System.out.println("Search by key and value and get both");
        for(Map.Entry<String, Integer> pairs : hashMap.entrySet()){
            String key = pairs.getKey();
            Integer value = pairs.getValue();
            if(key.charAt(0)=='C' && value==29) {
                System.out.println("Key: " + key + " Value: " + value);
            }
        }
        System.out.println();

        //A LinkedHashMap can be set up just as shown above
        LinkedHashMap<String, Integer> linkMap = new LinkedHashMap<>();
        linkMap.put("Davis", 50);
        linkMap.put("Bubbles", 45);
        linkMap.put("Cartman", 40);
        linkMap.put("Adams", 52);
        linkMap.put("Adams", 53);
        System.out.println("LinkedHashMap Example: prints in insertion order");
        System.out.println(linkMap);
        System.out.println("The age for Bubbles is " + linkMap.get("Bubbles"));

        //A TreeMap can be set up just as shown above
        //To save time, let's just use the hashMap to create a new TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Tree Map example - generic print");
        System.out.println("Will display in ascending order of key");
        System.out.println(treeMap);

    }
}
