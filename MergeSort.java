public class MergeSort {

    // MergeSort function
    public static void mergeSort(int[] A, int lb, int ub) {
        if (lb < ub) {
            int mid = (lb + ub) / 2;

            // Recursively sort first half
            mergeSort(A, lb, mid);

            // Recursively sort second half
            mergeSort(A, mid + 1, ub);

            // Merge the two halves
            merge(A, lb, mid, ub);
        }
    }

    // Merge function
    public static void merge(int[] A, int lb, int mid, int ub) {
        int[] B = new int[A.length];

        int i = lb;
        int j = mid + 1;
        int k = lb;

        // Merge both subarrays
        while (i <= mid && j <= ub) {
            if (A[i] <= A[j]) {
                B[k] = A[i];
                i++;
            } else {
                B[k] = A[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left subarray
        while (i <= mid) {
            B[k] = A[i];
            i++;
            k++;
        }

        // Copy remaining elements of right subarray
        while (j <= ub) {
            B[k] = A[j];
            j++;
            k++;
        }

        // Copy back to original array
        for (k = lb; k <= ub; k++) {
            A[k] = B[k];
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] A = {38, 27, 43, 9, 82, 10};

        System.out.println("Before Sorting:");
        for (int num : A) {
            System.out.print(num + " ");
        }

        mergeSort(A, 0, A.length - 1);

        System.out.println("\nAfter Sorting:");
        for (int num : A) {
            System.out.print(num + " ");
        }
    }
}