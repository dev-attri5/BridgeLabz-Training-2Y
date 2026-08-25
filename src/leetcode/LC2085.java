import java.util.HashMap;
public class LC2085 {
    public static int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String word : words1) map1.put(word, map1.getOrDefault(word, 0) + 1);
        for (String word : words2) map2.put(word, map2.getOrDefault(word, 0) + 1);
        int count = 0;
        for (String word : map1.keySet()) {
            if (map1.get(word) == 1 && map2.getOrDefault(word, 0) == 1) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        String[] words1 = {"leetcode", "is", "amazing", "as", "is"};
        String[] words2 = {"amazing", "leetcode", "is"};
        System.out.println(countWords(words1, words2));
    }
}