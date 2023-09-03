package dp;

import java.util.Scanner;

public class MaximumWealth {

    public static long thief(int n, int[] arr) {
        if (n == 0)
            return 0;

        long value1 = arr[0];
        if (n == 1)
            return 1;
        long value2 = Math.max(arr[1], value1);
        if (n == 2)
            return value2;
        long max_val = 0;
        for (int i = 2; i < n; i++) {
            max_val = Math.max(arr[i] + value1, value2);
            value1 = value2;
            value2 = max_val;
        }
        return max_val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long ans = thief(n, arr);
        System.out.println(ans);

    }
}
