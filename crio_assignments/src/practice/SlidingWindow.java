package practice;

import java.util.*;

public class SlidingWindow {
    public static long maxSlidingWindow(List<Integer> A, int B) {

        int n = A.size();
        int k = n - B;
        if (n < k) {
            System.out.println("Invalid");
            return -1;
        }
        long total = 0;
        for (int i = 0; i < n; i++)
            total += A.get(i);
        long window_sum = 0;
        for (int i = 0; i < k; i++)
            window_sum += A.get(i);
        long max_sum = window_sum;
        for (int i = k; i < A.size(); i++) {
            window_sum += (A.get(i) - A.get(i - k));
            max_sum = Math.min(window_sum, max_sum);
        }

        return total - max_sum;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
//        int[] A = new int[N];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }
        long result = maxSlidingWindow(list, B);
//        for (int num : result)
        System.out.println(result);
        sc.close();
    }
}
