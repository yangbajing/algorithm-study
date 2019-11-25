package algo;

import java.util.Arrays;

public class P007AlgoCasts {
  // Time: O(m+n), Space: O(1)
  public static int[] searchIn2DArray(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
      return new int[] {-1, -1};

    int rowLength = matrix.length, columnLength = matrix[0].length;
    int rowIdx = 0, columnIdx = columnLength - 1;
    while (rowIdx < rowLength && columnIdx >= 0) {
      int v = matrix[rowIdx][columnIdx];
      if (target < v) --columnIdx;
      else if (target > v) ++rowIdx;
      else return new int[] {rowIdx, columnIdx};
    }

    return new int[] {-1, -1};
  }

  public static void main(String[] args) {
    int[][] matrix =
        new int[][] {
          {1, 3, 5},
          {2, 4, 6},
        };
    int[] a = searchIn2DArray(matrix, 9);
    int[] b = searchIn2DArray(matrix, 2);
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));
  }
}
