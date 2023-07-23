package twoPointers;

import java.util.Arrays;
import java.util.Comparator;

class Intervals {
    int low;
    int high;

    public Intervals(int low, int high) {
        this.low = low;
        this.high = high;
    }
}

public class MergeIntervals {

    public int[][] mergeIntervals(int[][] intervals) {

        Intervals[] intervals1 = new Intervals[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            Intervals intervals2 = new Intervals(intervals[i][0], intervals[i][1]);
            intervals1[i] = intervals2;
        }
        Arrays.sort(intervals1, new Comparator<Intervals>() {
            @Override
            public int compare(Intervals o1, Intervals o2) {
                return o1.low - o2.low;
            }
        });
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals1[index].high >= intervals1[i].low) {
                intervals1[index].high = Math.max(intervals1[index].high, intervals1[i].high);

            } else {
                index++;
                intervals1[index] = intervals1[i];
            }
        }
        int[][] result = new int[index + 1][2];
        int i = 0;
        for (Intervals temp : intervals1) {
            result[i][0] = temp.low;
            result[i][1] = temp.high;
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] nums = {{1, 3},
                {8, 10},
                {2, 6},
                {15, 18}};
        MergeIntervals mi = new MergeIntervals();
        System.out.println(Arrays.asList(mi.mergeIntervals(nums)));


    }
}
