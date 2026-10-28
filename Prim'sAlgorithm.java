
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int[][] graph = new int[n][n];

        System.out.println("Enter weight matrix (0 = no edge):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();

        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] mst = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0] = 0;

        for (int count = 0; count < n; count++) {
            int u = -1;

            for (int v = 0; v < n; v++)
                if (!mst[v] && (u == -1 || key[v] < key[u]))
                    u = v;

            if (u == -1 || key[u] == Integer.MAX_VALUE) {
                System.out.println("Graph is disconnected");
                sc.close();
                return;
            }

            mst[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] > 0 && !mst[v]
                        && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        int total = 0;
        System.out.println("Edge \t Weight");
        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i
                    + "\t " + graph[i][parent[i]]);
            total += graph[i][parent[i]];
        }

        System.out.println("Total MST weight: " + total);
        sc.close();
    }
}
