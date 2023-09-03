package crio_assignments.src.assessments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RetainingRepetitions_v2 {

    public ArrayList<Integer> retainingRepetitions(int arr[], int k) {

        int index = 0, nextCount = 2, count = 0;
        boolean flag = false;
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int elem : arr) {
            mp.put(elem, mp.getOrDefault(elem, 0) + 1);
        }
        while (index < arr.length) {
            int elemCount = mp.get(arr[index]);
            if (elemCount >= nextCount && (!flag)) {
                for (int i = 0; i < nextCount - 1; i++) {
                    list.add(arr[index]);
                }
                if (nextCount >= k)
                    flag = true;
                nextCount += 1;
            } else if (flag && elemCount > 1) {
                count = k;
                if (elemCount < k)
                    count = elemCount;
                for (int i = 0; i < count; i++) {
                    list.add(arr[index]);
                }
            } else {
                for (int i = 0; i < elemCount; i++) {
                    list.add(arr[index]);
                }
            }
            index += elemCount;
        }
        return list;

    }

    public static void main(String[] args) {
        RetainingRepetitions_v2 rr = new RetainingRepetitions_v2();
//        int[] arr = {1, 2, 3, 3, 4, 5, 5, 5, 5, 6, 6, 7, 7, 7, 7, 7};
//        int[] arr = {1, 2, 3, 3, 4, 5, 5, 5, 5, 6, 6, 7, 7, 7, 7, 7};
//        int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int k = 5;
        System.out.println(rr.retainingRepetitions(arr, k));
    }
}


//256 5
//        0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 2 2 2 2 2 2 2 2 2 2 2 2 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 7 7 7 7 7 7 7 8 8 8 8 8 8 8 8 8 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9

//output:
//37
//        0 1 1 2 2 3 3 3 4 4 4 4 5 5 5 5 5 6 6 6 6 6 7 7 7 7 7 8 8 8 8 8 9 9 9 9 9