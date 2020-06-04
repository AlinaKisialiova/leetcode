package medium;

/* #73
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
Example 1:
[                   [
  [1,1,1],            [1,0,1],
  [1,0,1],    =>      [0,0,0],
  [1,1,1]             [1,0,1]
]                   ]

Example 2:
[                   [
  [0,1,2,0],          [0,0,0,0],
  [3,4,5,2],  =>      [0,4,5,0],
  [1,3,1,5]           [0,3,1,0]
]                   ]

Follow up:
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes zeroSetter = new SetMatrixZeroes();
        zeroSetter.setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        System.out.println();
        zeroSetter.setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }

    // Time Complexity : O(M×N)
    // Space Complexity : O(1)
    //
    // 1st row and column are markers.
    // Before using 1st row/col as markers, define does 1st row/col contain 0 itself and save result to firstRowHasZero, firstColumnHasZero.
    // Traverse matrix. If an element is 0, mark its [i] and [j] indexes in 1st row, col as 0.
    // Traverse the matrix again. If 1st row or col is 0, set 0 for whole row and col.
    // If firstRowHasZero or firstColumnHasZero is true, fill out 1st row/col by 0.
    public void setZeroes(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        boolean firstRowHasZero = isFirstRowHasZero(matrix);
        boolean firstColumnHasZero = isFirstColumnHasZero(matrix);
        //set 0 in 1st row and col, in an element is 0
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //fill out whole row/col by 0 if there is 0 in 1st row or col
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstColumnHasZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstRowHasZero) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        print(matrix);
    }

    private boolean isFirstColumnHasZero(int[][] matrix) {
        final int n = matrix.length;
        boolean firstColumnHasZero = false;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }
        return firstColumnHasZero;
    }

    private boolean isFirstRowHasZero(int[][] matrix) {
        final int m = matrix[0].length;
        boolean firstRowHasZero = false;
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        return firstRowHasZero;
    }

    private void print(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
