package medium;

/* #48
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Given input matrix =
[                  [
  [1,2,3],           [7,4,1],
  [4,5,6],   =>      [8,5,2],
  [7,8,9]            [9,6,3]
],                 ]

Example 2:
Given input matrix =
[                       [
  [ 5, 1, 9,11],           [15,13, 2, 5],
  [ 2, 4, 8,10],    =>     [14, 3, 4, 1],
  [13, 3, 6, 7],           [12, 6, 8, 9],
  [15,14,12,16]            [16, 7,10,11]
],                      ]
*/
public class RotateImage {

    public static void main(String[] args) {
        new RotateImage().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println();
        new RotateImage().rotate(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
    }

    public void rotate(int[][] matrix) {
        final int n = matrix.length;
        if (n == 0) {
            return;
        }
        for (int topLayer = 0; topLayer < n / 2; topLayer++) {
            int bottomLayer = n - 1 - topLayer;
            //start from j=topLayer, because previous columns have been already processed on topLayer-1 iterations
            for (int j = topLayer; j < bottomLayer; j++) {
                int offset = j - topLayer;
                // save left top
                int top = matrix[topLayer][j];
                // left top = left bottom
                matrix[topLayer][j] = matrix[bottomLayer - offset][topLayer];
                //left bottom = right bottom
                matrix[bottomLayer - offset][topLayer] = matrix[bottomLayer][bottomLayer - offset];
                //right bottom = right top
                matrix[bottomLayer][bottomLayer - offset] = matrix[j][bottomLayer];
                //right top = left top
                matrix[j][bottomLayer] = top;
            }
        }
        //print(matrix);
    }

    private void print(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
