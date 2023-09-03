package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Spiral {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int row = 0, col = 0;
        int newStart = 0, newEnd = n - 1,newRowEnd=m-1;
        for (int i = 0; i < (m * n); i++) {

            if (row == newStart && col != newEnd) {
                result.add(matrix[row][col]);
                col++;
            } else if (row == newRowEnd && col != newStart) {
                result.add(matrix[row][col]);
                col--;
            } else if (col == newEnd) {
                result.add(matrix[row][col]);
                row++;
            } else if (col == newStart) {
                result.add(matrix[row][col]);
                row--;
                if (row == newStart) {
                    newStart += 1;
                    newEnd -= 1;
                    newRowEnd-=1;
                    col++;
                    row = newStart;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {

        Spiral sp = new Spiral();
        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(sp.spiralOrder(mat));


    }
}
