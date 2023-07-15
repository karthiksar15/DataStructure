package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Doughnut_v2 {
    static long donuts(int N, int B, List<Integer> A) {
        int num = N - B, j = 0, sum = 0, index = 0;
        long total = 0, min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            total = total + A.get(i);
        }

        for (int i = 0; i <= N - num; i++) {
            sum = 0;
            j = i;
            index = 0;
            while (index < num) {
                sum = sum + A.get(j);
                j++;
                index++;

            }
            min = Long.min(min, sum);
        }

        return total - min;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        List<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            A.add(sc.nextInt());
        }
        long result = donuts(N, B, A);
        System.out.println(result);
        sc.close();


    }
}
