package crio_assignments.src.assessments;

import java.util.ArrayList;

public class RetainingRepetitions {

    public ArrayList<Integer> retainingRepetitions(int arr[], int k) {

        int count = 0, sp = 0, fp = 1, nextCount = 1;
        boolean flag = false;
        ArrayList<Integer> list = new ArrayList<>();

        while (fp < arr.length && sp < arr.length) {
            if (arr[sp] == arr[fp]) {
                count++;
                fp++;
            } else {
                if (count > 0) {
                    if (!flag && count != nextCount - 1) {
                        for (int i = 0; i < nextCount; i++) {
                            list.add(arr[sp]);
                        }
                        nextCount = nextCount + 1;
                        if (nextCount >= k)
                            flag = true;

                    } else {
                        if (count < k)
                            nextCount = count + 1;
                        else
                            nextCount = k;
                        for (int i = 0; i < nextCount; i++) {
                            list.add(arr[sp]);
                        }
                    }
                    count = 0;

                    sp = fp;
                } else {
                    list.add(arr[sp]);
                    sp++;
                }
                fp++;

            }
        }
        if (count > 0) {
            if (count < k)
                nextCount = count;
            else
                nextCount = k;
            for (int i = 0; i < nextCount; i++) {
                list.add(arr[sp]);
            }
        }
        return list;

    }

    public static void main(String[] args) {
        RetainingRepetitions rr = new RetainingRepetitions();
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