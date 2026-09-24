import java.util.Scanner;

public class LCS {

    // Function to compute LCS length and dp table
    public static int[][] lcsLength(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }

    // Function to build actual LCS string
    public static String buildLCS(String X, String Y, int[][] dp) {
        int i = X.length();
        int j = Y.length();

        StringBuilder result = new StringBuilder();

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                result.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return result.reverse().toString(); // reverse because we built it backwards
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String X = sc.nextLine();

        System.out.print("Enter second string: ");
        String Y = sc.nextLine();

        int[][] dp = lcsLength(X, Y);

        String lcs = buildLCS(X, Y, dp);

        System.out.println("Length of LCS: " + dp[X.length()][Y.length()]);
        System.out.println("LCS: " + lcs);
    }
}