package stack;

public class StackOps2 {
    int arr[] = new int[5];
    int top = 0;

    public void push(int data) {
        if (top == arr.length) {
            System.out.println("Stack Overflow");
            return;
        }

        arr[top] = data;
        top++;
    }

    public void display() {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public int pop() {
        if (top == 0) {
            System.out.println("Stack Underflow");
            return -1;
        }

        top--;
        int data = arr[top];
        arr[top] = 0;

        return data;
    }
}