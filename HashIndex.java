
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter hash table size: ");
        int size = sc.nextInt();

        int[] hash = new int[size];
        Arrays.fill(hash, -1);

        System.out.print("Enter number of keys: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter key: ");
            int key = sc.nextInt();

            int index = Math.floorMod(key, size);
            int start = index;

            while (hash[index] != -1) {
                index = (index + 1) % size;

                if (index == start) {
                    System.out.println("Hash table is full!");
                    break;
                }
            }

            if (hash[index] == -1) {
                hash[index] = key;
                System.out.println("Key " + key +
                                   " inserted at index " + index);
            }
        }

        System.out.println("\nHash Table:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + " -> " + hash[i]);
        }

        sc.close();
    }
}
