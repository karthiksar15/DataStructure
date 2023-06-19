package practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SegmentTreeInv {
    int start;
    int end;
    int value;
    SegmentTreeInv left, right;

    SegmentTreeInv(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int query(int l, int r) {
        if (this.start > r || this.end < l) return 0;
        if (this.start >= l && this.end <= r) {
            return this.value;
        }
        int leftAns = 0, rightAns = 0;
        if (this.left != null) {
            leftAns = this.left.query(l, r);
        }
        if (this.right != null) {
            rightAns = this.right.query(l, r);
        }
        return leftAns + rightAns;
    }

    public void update(int index, int val) {
        if (this.start == this.end) {
            this.value += val;
            return;
        }
        int mid = (this.start + this.end) / 2;
        if (this.start + 1 == this.end)
            mid = start;
        if (index <= mid) {
            if (this.left == null)
                this.left = new SegmentTreeInv(this.start, mid, 0);
            this.left.update(index, val);
        } else {
            if (this.right == null)
                this.right = new SegmentTreeInv(mid + 1, this.end, 0);
            this.right.update(index, val);
        }
        this.value = 0;
        if (this.left != null)
            this.value += this.left.value;
        if (this.right != null)
            this.value += this.right.value;
    }
}

class InversionUsingSegmentTree {


    public ArrayList<Integer> countSmaller(int[] nums) {
        int min = -100009;
        SegmentTreeInv inv = new SegmentTreeInv(min, -min, 0);
        Integer[] list = new Integer[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int check = inv.query(min, nums[i] - 1);
//            list.add(check);
            list[i]=check;
            inv.update(nums[i], 1);
        }
        ArrayList<Integer> finalList = new ArrayList<>();
        finalList.addAll(Arrays.asList(list));

//        for(int i=list.size())
        return finalList;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {3, 1, 3, 1, 4};
        int n = arr.length;

        InversionUsingSegmentTree ist = new InversionUsingSegmentTree();


        System.out.println(ist.countSmaller(arr));

//        constructLowerArray(arr,);

        System.out.print("Following is the constructed smaller count array");
//        printArray(countSmaller, n);

    }

}