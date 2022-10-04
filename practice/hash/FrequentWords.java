package practice.hash;

import java.util.*;

public class FrequentWords {
    public static Vector<String> frequentWords(Vector<String> vec, int k) {
        Iterator<String> itr = vec.iterator();
        Vector<String> str = new Vector<String>();
        int max = 0;
        Map<String, Integer> mp = new HashMap<String, Integer>();
        while (itr.hasNext()) {
            String temp = itr.next();
            Integer val = mp.getOrDefault(temp, 0) + 1;
            // if(val<=k)
            mp.put(temp, val);
        }
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        mp.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        for (String key : reverseSortedMap.keySet()) {
            // if(reverseSortedMap.get(key)<=k)
            str.add(key);
        }
        return str;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vector<String> vec = new Vector<String>();
        for (int i = 0; i < n; i++)
            vec.add(sc.next());
        int k = sc.nextInt();
        Vector<String> ans = frequentWords(vec, k);
        for (int i = 0; i < k; i++)
            System.out.println(ans.get(i));
    }
}


//    Problem Description
//    You are given a list of words present in a book. Your younger brother is really curious to know the K most frequent words in the book, you have to find them.
//
//
//        Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order should come first.
//
//        Input format
//        There are three lines of input
//
//        The first line contains N, which is the number of input strings.
//
//        The second line contains N space separated input strings (S).
//
//        The third line contains the value of K.
//
//        Output format
//        Print the K most frequent words present inside the book, each in a new line. If two words have the same frequency, then the word with the lower alphabetical order should come first.
//
//        Constraints
//        1 <= N <= 1000
//
//        1 <= Length(S) <= 100000
//
//        'a' <= S[i] <= 'z'
//
//        1 <= K <= Number of Unique Strings
//
//        Sample Input 1
//        1
//
//        bus
//
//        1
//
//        Sample Output 1
//        bus
//
//        Explanation 1
//        In the given input, the frequency of "bus" is 1 and it is the 1st most frequent word.
//
//        Sample Input 2
//        3
//
//        car bus car
//
//        2
//
//        Sample Output 2
//        car
//
//        bus
//
//        Explanation 2
//        In the given input, the frequency of "car" is 2, frequency of “bus” is 1.
//
//        Since K = 2, both words are printed, with "car" being the most frequent, gets printed first.
//
//        Resource
//        Top K Frequent Words - Priority Queue Approach
//
//        Find the k most frequent words from a file