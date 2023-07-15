package practice.recursion;

import java.util.ArrayList;
import java.util.List;

class Combinations {
    public List<List<Integer>> combine(int[] nums, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int k = 0; k <= nums.length; k++) {
            helper(result, temp, n, k, 0, nums);
        }

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> temp, int n, int k, int i, int[] num) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i; j < n; j++) {
            temp.add(num[j]);
            helper(result, temp, n, k, j + 1, num);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations cm = new Combinations();
        int num[] = {1, 2, 3};

        System.out.println(cm.combine(num, num.length));
    }
}

