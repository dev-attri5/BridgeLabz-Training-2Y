public class Reverse_Array {
    static void reverse(int arr[]){
        int a=0;
        int b=arr.length-1;

        while (a < b){
            int temp=arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
            a++;
            b--;
        }
    }
    static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]={10, 20, 30, 40, 50};
        System.out.println("Original:");
        display(arr);
        reverse(arr);
        System.out.println("Reversed:");
        display(arr);
    }
}