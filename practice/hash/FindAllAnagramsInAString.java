package practice.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = new String[2];
        input = scanner.nextLine().split(" ");
        String s = input[0];
        String p = input[1];
        scanner.close();

        List<Integer> result = new FindAllAnagramsInAString().findAnagrams(s, p);
        System.out.println(result.size());
        for (Integer i = 0; i < result.size(); ++i) {
            System.out.printf("%d ", result.get(i));
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        char[] sarray = new char[256];
        char[] parray = new char[256];
        int n = s.length();
        int m = p.length();
        if (m > n)
            return list;
        for (int i = 0; i < m; i++) {
            (sarray[s.charAt(i)])++;
            (parray[p.charAt(i)])++;
        }
        for (int i = m; i < n; i++) {
            if (compare(sarray, parray)) {
                list.add(i - m);
            }
            (sarray[s.charAt(i)])++;
            (sarray[s.charAt(i - m)])--;

        }
        if (compare(sarray, parray)) {
            list.add(n - m);
        }
        return list;
    }


    public boolean compare(char[] sArray, char[] pArray) {
        for (int i = 0; i < 256; i++) {
            if (sArray[i] != pArray[i])
                return false;
        }
        return true;
    }

}

//    Problem Description
//    You are given two strings, a main string S, and a pattern P. You have to find the starting indices of the anagrams of P in S.
//
//
//        Anagrams are permutations of a string. For P="abc”, its anagrams are abc,acb,bca,bac,cba,cab.
//
//
//        Note that indexing starts at 0.
//
//        Input format
//        There is one line of input, containing two space-separated strings S and P.
//
//        Output format
//        First-line should contain the number of such starting indices.
//
//        Next line should contain the indices in increasing order separated by a space.
//
//        Sample Input 1
//        aaba ab
//
//        Sample Output 1
//        2
//
//        1 2
//
//        Explanation 1
//        The anagrams of pattern "ab" are “ab” and “ba”. These are present at indices 1 and 2 of the input string “aaba”.
//
//        Sample Input 2
//        bacdgabcda abcd
//
//        Sample Output 2
//        3
//
//        0 5 6
//
//        Explanation 2
//        The anagrams of "abcd" can be seen as “bacd” at index 0, “abcd” at index 5 and “bcda” at index 6.
//
//        Constraints
//        1 <= length(S), length(P) <= 10^6
//
//        Pattern Introduction