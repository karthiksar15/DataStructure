package dp;

import java.util.Scanner;

public class UniquePaths {

    public int uniquePath(int m, int n) {
        int[] dp = new int[n];
        int mod = 1000000007;
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {

                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();
        int result = new UniquePaths().uniquePath(m, n);
        System.out.println(result);
    }
}
