
import java.util.*;

public class Main {
    static int n;
    static int[] queen;

    static boolean safe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queen[i] == col ||
                Math.abs(queen[i] - col) == Math.abs(i - row))
                return false;
        }
        return true;
    }

    static boolean solve(int row) {
        if (row == n) return true;

        for (int col = 0; col < n; col++) {
            if (safe(row, col)) {
                queen[row] = col;

                if (solve(row + 1))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        n = sc.nextInt();
        queen = new int[n];

        if (n > 0 && solve(0)) {
            System.out.println("Solution:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(queen[i] == j ? "Q " : ". ");
                System.out.println();
            }
        } else {
            System.out.println("No solution exists");
        }

        sc.close();
    }
}
