package arrays;

import java.util.Random;

/**
 *
 * @author Colby
 */
public class Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        arrBuilder test = new arrBuilder(10);
        test.populate(1, 10);
        test.display();
        test.rotateK(2);
        test.display();
    }

    public static class arrBuilder {

        private final int a[];

        // Constructor
        public arrBuilder(int size) {
            a = new int[size];
        }

        // Method to populate an array with random integer values
        public void populate(int min, int max) {
            Random random = new Random();
            for (int i = 0; i < a.length; i++) {
                a[i] = random.nextInt(max - min + 1) + min; // gen random num in [min,max]
            }
        }

        // Rotate array to right by k steps
        public void rotateK(int k) {
            k = k % a.length; // Handle cases where k is greater than the length of the array

            if (k < 0) {
                k += a.length; // Handle negative k values if needed
            }

            // Reverse the entire array
            reverse(0, a.length - 1);

            // Reverse the first k elements
            reverse(0, k - 1);

            // Reverse the remaining elements
            reverse(k, a.length - 1);

            // Format
            System.out.println("");
        }

        // Helper method to reverse part of the array
        private void reverse(int start, int end) {
            while (start < end) {
                swap(start, end);
                start++;
                end--;
            }
        }

        // Helper method to swap two elements in the array
        private void swap(int idx1, int idx2) {
            int temp = a[idx1];
            a[idx1] = a[idx2];
            a[idx2] = temp;
        }

        public void display() {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
                System.out.print(" ");
            }
        }

    }
}