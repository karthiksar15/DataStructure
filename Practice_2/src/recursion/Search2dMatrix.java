package recursion;

public class Search2dMatrix {

    private int[][] matrix;
    private int target;


    private boolean searchRec(int left, int up, int right, int down) {
        if (left > right || up > down) {
            return false;
        } else if (this.target < matrix[up][left] || this.target > matrix[down][right]) {
            return false;
        }
        int mid = left + (right - left) / 2;
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }
        return searchRec(left, row, mid - 1, down) || searchRec(mid + 1, up, right, row - 1);

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0)
            return false;
        this.matrix=matrix;
        return searchRec(0, 0, matrix[0].length - 1, matrix.length - 1);

    }

    public static void main(String args[]) {

        Search2dMatrix s2 = new Search2dMatrix();
        int[][] mat = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        s2.target = 20;
        System.out.println(s2.searchMatrix(mat, s2.target));


    }

}


//    public static boolean search2DMatrix(int[][] matrix, int target, int r, int c) {
//        if(c<0 || r==matrix.length)
//            return false;
//        if(matrix[r][c]==target)
//            return true;
//        else if(target<matrix[r][c])
//            return search2DMatrix(matrix,target,r,c-1);
//        return search2DMatrix(matrix,target,r+1,c);
//    }
//}