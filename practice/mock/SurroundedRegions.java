package practice.mock;


import java.util.Scanner;

class SurroundedRegions {

    public void surroundedRegions(char[][] board) {

        char up = 0;
        char down = 0;
        char right = 0;
        char left = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (i > 0 && j > 0 && i < board.length - 1 && j < board.length - 1 && board[i][j] == 'O') {
                    down = board[i - 1][j];
                    left = board[i][j - 1];
                    up = board[i + 1][j];
                    right = board[i][j + 1];
                    int count = 0;
                    if (down == 'X')
                        count++;
                    if (left == 'X')
                        count++;
                    if (up == 'X')
                        count++;
                    if (right == 'X')
                        count++;
                    if (count > 2)
                        board[i][j] = 'X';
                }

            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        char[][] board = new char[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                board[i][j] = scanner.next().charAt(0);
            }
        }
        scanner.close();

        new SurroundedRegions().surroundedRegions(board);

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println();
        }
    }
}
