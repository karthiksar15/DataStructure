public class Histograms {

    public int max_area = 0;
    public int[] height;
    public int count = 0;
    public int prev_val = -1;

    public int largestRectangleArea(int[] heights) {
        this.height = heights;
        int pos = helper(-1, 0, 0, height[0]);
        while (count < height.length - 1) {
            pos = helper(-1, -1, pos, height[pos]);
        }
        max_area = Math.max(max_area, height[prev_val] * (pos - (-1)));
        return max_area;
    }

    public int helper(int left, int prev, int right, int val) {
        if (right == height.length-1)
            return right;
        if (prev > -1 && val < height[prev]) {
            return right;
        }

        int temp_right = helper(right, right, right + 1, height[right + 1]);
        count++;
        max_area = Math.max(max_area, (height[right] * ((temp_right - left) - 1)));
        prev_val = right;
        return temp_right;
    }

    public static void main(String[] args) {

        Histograms h = new Histograms();
        // int[] nums = { 6, 7, 5, 2, 4, 5, 9, 3 };
        int[] nums = { 2, 1, 5, 6, 2, 3 };
        System.out.println(h.largestRectangleArea(nums));

    }

}
