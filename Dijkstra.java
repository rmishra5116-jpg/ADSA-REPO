
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

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < n; count++) {
            int u = -1;

            for (int i = 0; i < n; i++)
                if (!visited[i] &&
                    (u == -1 || dist[i] < dist[u]))
                    u = i;

            if (u == -1 || dist[u] == Integer.MAX_VALUE)
                break;

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] > 0 &&
                    dist[u] <= Integer.MAX_VALUE - graph[u][v] &&
                    dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Vertex \t Shortest Distance");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t " +
                (dist[i] == Integer.MAX_VALUE ? "Unreachable" : dist[i]));
        }

        sc.close();
    }
}
