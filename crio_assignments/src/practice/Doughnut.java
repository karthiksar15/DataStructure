package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Doughnut {
    static long donuts(int N, int B, List<Integer> A) {
        long count = 0;
        int mid = A.size() / 2;
        int low = 0, high = A.size() - 1;
        PriorityQueue<Integer> pqLow = new PriorityQueue<>();
        PriorityQueue<Integer> pqHg = new PriorityQueue<>();
        while (low < mid || high > mid) {
            if (low < mid && (!pqLow.contains(A.get(low))) && (!pqHg.contains(A.get(low)))) {
                pqLow.add(A.get(low));
                count+=A.get(low);
            }
            if(pqHg.size()+pqLow.size()>B)
            {
                int temp=pqLow.poll();
                count-=temp;
            }
            if (high > mid && (!pqHg.contains(A.get(high))) && (!pqLow.contains(A.get(high)))) {
                pqHg.add(A.get(high));
                count+=A.get(high);
            }
            if(pqHg.size()+pqLow.size()>B)
            {
                int temp=pqHg.poll();
                count-=temp;
            }


            low++;
            high--;
        }

        System.out.println("high-->"+pqHg);
        System.out.println("low-->"+pqLow);
        return count;
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
