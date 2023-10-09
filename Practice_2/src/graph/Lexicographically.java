package graph;

import java.util.*;

public class Lexicographically {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Solution_7 s7 = new Solution_7(s.length());
        for (List<Integer> list : pairs) {
            s7.union(list.get(0), list.get(1));
        }
        Map<Integer, StringBuffer> mp = new HashMap<>();
        Map<Integer, ArrayList> mp1 = new HashMap<>();

        StringBuffer result = new StringBuffer();
        int pos = 0;
        for (int index : s7.getRoot()) {
            mp.putIfAbsent(index, new StringBuffer());
            mp1.putIfAbsent(index, new ArrayList());
            mp.get(index).append(s.charAt(pos));
            char[] ch = mp.get(index).toString().toCharArray();
            Arrays.sort(ch);
            result.append(s.charAt(pos));
            mp.put(index, new StringBuffer().append(ch));
            mp1.get(index).add(pos);
            pos++;
        }

        Map<Integer, Integer> mp2 = new HashMap<>();
        for (List<Integer> chk : pairs) {
            for (Map.Entry<Integer, ArrayList> entry : mp1.entrySet()) {

                if (entry.getValue().contains(chk.get(0))) {
                    StringBuffer temp = mp.get(entry.getKey());
                    mp2.putIfAbsent(entry.getKey(), 0);
                    if (temp.length() > 0) {
                        String temp1 = temp.substring(0, 1);
                        result.replace(mp2.get(entry.getKey()), mp2.get(entry.getKey()) + 1, temp1);
                        mp2.put(entry.getKey(),mp2.get(entry.getKey())+1);
                        temp.deleteCharAt(0);
                        if (temp.length() > 0) {
                            temp1 = temp.substring(0, 1);
                            result.replace(chk.get(1), chk.get(1) + 1, temp1);
                            temp.deleteCharAt(0);
                        }
                        break;
                    }

                }


            }
        }


        return result.toString();

    }

    public static void main(String[] args) {
        Lexicographically ll = new Lexicographically();
        String output = ll.smallestStringWithSwaps("karthik", List.of(List.of(0, 1), List.of(3, 6), List.of(1, 2), List.of(2, 4), List.of(4, 5)));
        System.out.println(output);
    }

    class Solution_7 {
        int[] root;
        int[] rank;

        public Solution_7(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        public int[] getRoot() {
            return this.root;
        }

        public int find(int x) {
            if (x == root[x])
                return x;
            return x = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootY] > rank[rootX]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                }
            }
        }

    }
}
