public class Swap_Array {
    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};
        System.out.println("Before:");
        display(arr);
        swap(arr, 1, 3);
        System.out.println("After:");
        display(arr);
    }
}
