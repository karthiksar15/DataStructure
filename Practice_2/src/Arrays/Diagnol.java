package Arrays;

public class Diagnol {

    public static void main(String[] args) {
        Diagnol di = new Diagnol();
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(di.findDiagonalOrder(mat));

    }

    public int[] findDiagonalOrder(int[][] mat) {

        boolean topToDown = false;
        int row = mat.length;
        int cols = mat[0].length;
        int[] result = new int[row * cols];
        int i = 0, j = 0, index = 0, lastOccur = 0;
        boolean[][] visited=new boolean[row][cols];
        result[index] = mat[i][j];
        index++;
        while (i < row && j < cols) {
            if (topToDown) {
                i = i + 1;
                for (int k = j; k < cols; k++) {
                    if (i < row) {
                        result[index] = mat[i][k];
                        index++;
                        lastOccur = k;
                        visited[i][k]=true;
                        if (i == 0) {
                            break;
                        }
                    }
                    i--;
                }
                j = lastOccur;
                topToDown = false;
            } else {
                j = j + 1;
                for (int k = i; k < row; k++) {
                    if (j < cols && !visited[k][j]) {
                        result[index] = mat[k][j];
                        index++;
                        lastOccur = k;
                        visited[k][j]=true;
                        if (j == 0) {
                            break;
                        }
                    }
                    j--;
                }
                i = lastOccur;
                topToDown = true;
            }
        }
        return result;
    }

}
