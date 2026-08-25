public class LC1832 {
    public static boolean checkIfPangram(String sentence) {
        boolean[] present = new boolean[26];
        int count = 0;
        for (char ch : sentence.toCharArray()) {
            int index = ch - 'a';
            if (!present[index]) {
                present[index] = true;
                count++;
            }
        }
        return count == 26;
    }
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }
}