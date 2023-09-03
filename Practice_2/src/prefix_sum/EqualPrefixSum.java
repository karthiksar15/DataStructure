package prefix_sum;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EqualPrefixSum {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        long res = equalPrefixSuffix(n, arr);

        System.out.println(res);
    }

    static long equalPrefixSuffix(int n, int arr[]) {
         int max = -1;
         if(arr.length>0)
         {
             Integer[] pps=new Integer[arr.length];
             Integer[] pss=new Integer[arr.length];
             pps[0]=arr[0];
             for(int i=1;i<arr.length-1;i++)
             {
                 pps[i]=pps[i-1]+arr[i];
             }
             List<Integer> list=Arrays.asList(pps);
             int index=0;
             pss[index]=arr[arr.length-1];
             if(list.contains(pss[index]))
             {
                 if(pss[index]>max)
                 max=pss[index];
             }
             index++;
             for(int i=arr.length-2;i>0;i--)
             {
                 pss[index]=pss[index-1]+arr[i];
                 if(list.contains(pss[index]))
                 {
                     if(pss[index]>max)
                     max=pss[index];
                 }
                 index++;
             }
         }
//        int max = -1;
//        Integer[] pps = new Integer[arr.length - 1];
//        Integer[] pss = new Integer[arr.length - 1];
//        pps[0] = arr[0];
//        for (int i = 1; i < arr.length - 1; i++) {
//            pps[i] = pps[i - 1] + arr[i];
//        }
//        System.out.println(Arrays.asList(pps));
//        int index = pss.length - 1;
//        pss[index] = arr[arr.length - 1];
//        for (int i = arr.length - 2; i > 0; i--) {
//            if (pss[index] >= pps[pps.length - 1])
//                max = search(pps, pss[index], max);
//            index--;
//            pss[index] = pss[index + 1] + arr[i];
//        }

//        List<Integer> list = Arrays.asList(pps);
//        System.out.println(list.stream().max((a,b)->a-b));
//        System.out.println(Arrays.asList(pss));
//        System.out.println(Arrays.asList(pps));

        return max;
    }

    public static int search(Integer[] pps, int target, int max) {
        int low = 0;
        int high = pps.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pps[mid] == target) {
                if (target > max)
                    return target;
            } else if (pps[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return max;
    }

}
