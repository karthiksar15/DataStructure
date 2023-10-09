package backtracking;

import java.util.HashSet;
import java.util.Set;

public class Nqueens {

    private int size;
    public int totalQueens(int n)
    {
        size=n;
        return backtrack(0,new HashSet<>(),new HashSet<>(),new HashSet<>());
    }

    public int backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols)
    {
        if (row == size) {
            return 1;
        }

        int solutions = 0;
        for (int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            // If the queen is not placeable
            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
                continue;
            }

            // "Add" the queen to the board
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);

            // Move on to the next row with the updated board state
            solutions += backtrack(row + 1, diagonals, antiDiagonals, cols);

            // "Remove" the queen from the board since we have already
            // explored all valid paths using the above function call
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
        }

        return solutions;
    }

    public static void main(String[] args) {
        Nqueens n=new Nqueens();
        System.out.println(n.totalQueens(4));


    }
}
