package hashmap;

import java.util.HashMap;
import java.util.Map;

    public class HashMapDemo {
        public static void main(String[] args) {

            HashMap<Integer, String> map = new HashMap<>();

            map.put(1, "Apple");
            map.put(2, "Banana");
            map.put(3, "Orange");

            System.out.println("Key 1: " + map.get(1));

            System.out.println("Key 4: " + map.getOrDefault(4, "Not Found"));

            System.out.println(map.containsKey(2));

            System.out.println(map.containsValue("Apple"));

            map.putIfAbsent(2, "Mango");
            map.putIfAbsent(4, "Mango");

            map.replace(1, "Grapes");

            map.remove(3);

            System.out.println("Size: " + map.size());

            System.out.println("Keys: " + map.keySet());

            System.out.println("Values: " + map.values());

            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }

            int[] nums = {1, 2, 1, 3, 2, 1};

            HashMap<Integer, Integer> freq = new HashMap<>();

            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            System.out.println("Frequency Map: " + freq);
        }
    }

