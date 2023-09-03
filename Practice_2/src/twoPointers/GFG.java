package twoPointers;

import java.util.ArrayList;
import java.util.Collections;

class GFG {
    // Function to return the minimum
    // number of halls required
    static int minHalls(int lectures[][], int n) {

        // Initialize a vector of pair, Time, first value
        // indicates the time of entry or exit of a lecture
        // second value denotes whether the lecture starts
        // or ends
        ArrayList<pair> Time = new ArrayList<>();

        // Store the lecture times
        for (int i = 0; i < n; i++) {
            Time.add(new pair(lectures[i][0], 1));
            Time.add(new pair(lectures[i][1], -1));
        }

        // Sort the vector
        Collections.sort(Time, (pair A, pair B) -> {
            return A.first - B.first;
        });

        int answer = 0, sum = 0;

        // Traverse the Time vector and Update sum and
        // answer variables
        for (int i = 0; i < Time.size(); i++) {
            sum += Time.get(i).second;
            answer = Math.max(answer, sum);
        }

        // Return the answer
        return answer;
    }

    static class pair {
        int first, second;

        pair(int x, int y) {
            first = x;
            second = y;
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int lectures[][]
                = {{0, 20}, {5, 10}, {10, 15}};
        int n = lectures.length;

        System.out.println(minHalls(lectures, n));
    }
}