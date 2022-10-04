package practice.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountDistinctElements {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        ArrayList<Integer> res = countDistinctElements(n, b, arr);
        for (int j : res)
            System.out.print(j + " ");
    }

    public static ArrayList<Integer> countDistinctElements(int n, int b, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        if (b > n)
            return list;
        for (int i = 0; i < b; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        list.add(mp.size());
        for (int i = b; i < n; i++) {
            if (mp.getOrDefault(arr[i - b], 0) == 1)
                mp.put(arr[i - b], 0);
            else if (mp.getOrDefault(arr[i - b], 0) > 1)
                mp.put(arr[i - b], mp.get(arr[i - b]) - 1);
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
            list.add(mp.size());
        }
        return list;
    }
}

//    Problem Description
//    Given an array of N elements and an integer B, you have to find the count of distinct numbers in all windows of size B.
//
//        You have to return an array of size N-B+1 where i'th element in the array is the number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1. If B > N, return an empty array.
//
//        Input format
//        There are 2 lines of input
//
//        First line contains two space separated integers N and B.
//
//        Second line contains N space separated integers representing the array A.
//
//        Output format
//        Return the array space separated in the first line.
//
//        Function definition
//        You have to implement the given function. It accepts three arguments - n, b and the input array. You have to return the new array as described.
//
//        Sample Input 1
//        6 3
//
//        1 2 1 3 4 3
//
//        Sample Output 1
//        2 3 3 2
//
//        Explanation
//        First range will be [1,2,1] , in which number of distinct elements are 2
//
//        Second range will be [2,1,3], in which number of distinct elements are 3
//
//        Third range will be [1,3,4], in which number of distinct elements are 3
//
//        Fourth range will be [3,4,3], in which number of distinct elements are 2
//
//        Constraints
//        1<=N<=100000
//
//        1<=B<=100000
//
//        1<=Ai<=10000
//
//        Resource
//        Video : Count Distinct Elements in Every Window of Size K
//
//        Count distinct elements in every window of size k