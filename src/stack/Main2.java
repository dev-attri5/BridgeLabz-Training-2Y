package stack;

public class Main2 {
    public static void main(String[] args) {

        StackOps2 s = new StackOps2();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        s.push(60);

        System.out.println("Stack elements:");
        s.display();
        System.out.println();
        System.out.println("Popped: " + s.pop());
        System.out.println("Popped: " + s.pop());
        System.out.println();
        System.out.println("Stack after popping:");
        s.display();

        s.pop();
        s.pop();
        s.pop();
        s.pop();
    }
}