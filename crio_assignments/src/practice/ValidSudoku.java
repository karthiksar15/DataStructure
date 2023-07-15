package practice;

import java.io.*;
import java.util.*;

class ValidSudoku {
    public boolean validSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // If current row or current column or
                // current 3x3 box is not valid, return
                // false
                if (!isValid(board, i, j))
                    return false;
            }
        }
        return true;
    }

    public static boolean isValid(char arr[][], int row,
                                  int col) {
        return notInRow(arr, row) && notInCol(arr, col) &&
                notInBox(arr, row - row % 3, col - col % 3);
    }

    public static boolean notInBox(char arr[][],
                                   int startRow,
                                   int startCol) {
        HashSet<Character> st = new HashSet<>();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char curr = arr[row + startRow][col + startCol];

                // If already encountered before, return
                // false
                if (st.contains(curr))
                    return false;

                // If it is not an empty cell,
                // insert value at current cell in set
                if (curr != '.')
                    st.add(curr);
            }
        }
        return true;
    }

    public static boolean notInRow(char arr[][], int row) {

        // Set to store characters seen so far.
        HashSet<Character> st = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            // If already encountered before,
            // return false
            if (st.contains(arr[row][i]))
                return false;

            // If it is not an empty cell, insert value
            // at the current cell in the set
            if (arr[row][i] != '.')
                st.add(arr[row][i]);
        }
        return true;
    }

    // Checks whether there is any duplicate
// in current column or not.
    public static boolean notInCol(char arr[][], int col) {
        HashSet<Character> st = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            // If already encountered before,
            // return false
            if (st.contains(arr[i][col]))
                return false;

            // If it is not an empty cell,
            // insert value at the current
            // cell in the set
            if (arr[i][col] != '.')
                st.add(arr[i][col]);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        char board[][] = new char[9][9];
//        for(int i = 0 ; i < 9 ; i++) {
//            for(int j = 0 ; j < 9 ; j++) {
//                board[i][j] = scanner.next().charAt(0);
//            }
//        }
        char board[][] = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}

                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}

                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}

                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}

                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}

                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}

                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'},

                {'.', '.', '.', '4', '1', '9', '.', '.', '5'}

                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        scanner.close();
        boolean result = new ValidSudoku().validSudoku(board);
        System.out.println(result);
    }
}
/*
Crio Methodology

Milestone 1: Understand the problem clearly
1. Ask questions & clarify the problem statement clearly.
2. Take an example or two to confirm your understanding of the input/output & extend it to test cases
Milestone 2: Finalize approach & execution plan
1. Understand what type of problem you are solving.
     a. Obvious logic, tests ability to convert logic to code
     b. Figuring out logic
     c. Knowledge of specific domain or concepts
     d. Knowledge of specific algorithm
     e. Mapping real world into abstract concepts/data structures
2. Brainstorm multiple ways to solve the problem and pick one
3. Get to a point where you can explain your approach to a 10 year old
4. Take a stab at the high-level logic & write it down.
5. Try to offload processing to functions & keeping your main code small.
Milestone 3: Code by expanding your pseudocode
1. Make sure you name the variables, functions clearly.
2. Avoid constants in your code unless necessary; go for generic functions, you can use examples for your thinking though.
3. Use libraries as much as possible
Milestone 4: Prove to the interviewer that your code works with unit tests
1. Make sure you check boundary conditions
2. Time & storage complexity
3. Suggest optimizations if applicable
*/
