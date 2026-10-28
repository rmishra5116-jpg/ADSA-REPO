
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int[][] dist = new int[n][n];

        System.out.println("Enter adjacency matrix (-1 = no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                dist[i][j] = (i == j) ? 0 :
                             (x == -1 ? 999999 : x);
            }
        }

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] != 999999 &&
                        dist[k][j] != 999999)
                        dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]);

        System.out.println("Shortest distance matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(
                    (dist[i][j] == 999999 ? "INF" : dist[i][j])
                    + "\t");
            System.out.println();
        }

        sc.close();
    }
}
