package practice.mock;

import java.util.Arrays;
import java.util.Scanner;

class Pair {
    int first;
    boolean second;

    Pair(int first, boolean second) {
        this.first = first;
        this.second = second;
    }
}

public class ParkingSpace {
    public int parkingSpace(int[][] times) {
        // Stores info about
        // entry and exit times
        int N = times.length;
        Pair a[] = new Pair[2 * N];

        // Convert given array to new array
        for (int i = 0; i < N; i++) {
            a[2 * i] = new Pair(times[i][0], true);
            a[2 * i + 1] = new Pair(times[i][1], false);
        }

        // Sort array in ascending
        // order of time
        Arrays.sort(a, (p1, p2) -> p1.first - p2.first);

        // Stores current maximum
        // at every iteration
        int curMax = 0;

        // Stores final maximum number
        // of cars parked at any time
        int maxFinal = 0;

        // Traverse the array
        for (int i = 0; i < 2 * N; ++i) {

            // When car entered
            if (a[i].second) {
                curMax++;
            }

            // When car exits
            else {
                if (curMax > maxFinal) {
                    maxFinal = curMax;
                }
                curMax--;
            }
        }

        // Print the answer
        System.out.println(maxFinal);

        return maxFinal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            times[i][0] = scanner.nextInt();
            times[i][1] = scanner.nextInt();
        }

        int result = new ParkingSpace().parkingSpace(times);

        System.out.printf("%d", result);
    }

}

//
//    Problem Description
//    You are the owner of a hotel at a hill station. There is a huge demand for guests but you have a limited car parking available. Given the arrival and departure time of all the cars, find the minimum number of car parking spaces needed.
//
//        Input format
//        First line contains integer N - Number of cars.
//
//        Next N lines contain 2 integers A, D - Arrival and departure time of ith car.
//
//        Output format
//        Print the minimum number of parking spaces required.
//
//        Sample Input 1
//        3
//
//        0 20
//
//        5 10
//
//        10 15
//
//        Sample Output 1
//        2
//
//        Explanation
//        One space will be occupied by 1st car (0-20) and the other will be occupied by 2nd car(5-10) and 3rd car(10-15). So only 2 spaces are required.
//
//        Constraints
//        N <= 10^5
//
//        0 <= A < D <= 10^9