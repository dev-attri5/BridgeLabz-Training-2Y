import java.util.Scanner;

public class Problem09 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String upper = "";

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
            }

            upper = upper + ch;
        }

        System.out.println("Uppercase Text: " + upper);

        sc.close();
    }
}