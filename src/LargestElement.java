public class LargestElement {

    static int largestElement(int arr[]) {

        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }

    static int secondLargestElement(int arr[]) {

        int largest = largestElement(arr);
        int secondLargest = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    public static void main(String[] args) {

        int arr[] = {12, 45, 6, 89, 23, 67};

        System.out.println("Largest Element = " + largestElement(arr));
        System.out.println("Second Largest Element = " + secondLargestElement(arr));
    }
}