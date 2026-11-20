package stack;

import java.util.Stack;

public class MonotonicStack {
    public static void main (String[] args){
        int[] nums = {5,3,4,2,6,1};
        Stack<Integer> st = new Stack<>();

        for(int num : nums){
            while(!st.isEmpty() && st.peek() < num){
                st.pop();
            }
            st.push(num);
        }
        System.out.println("" + st);
        System.out.println("" + st.peek());
    }
}
