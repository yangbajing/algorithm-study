package algo;

/**
 * https://algocasts.io/series/algo-problems-1-50/episodes/XZWvBW7n 这个题目说的是，给你两个整数，在不使用 +/-
 * 这两个运算符的前提下，求它们的和。
 */
public class P005AlgoCasts {
  public int getSumRecursive(int a, int b) {
    return b == 0 ? a : getSumRecursive(a ^ b, (a & b) << 1);
  }

  // Time: O(m), Space: O(1)。m为二进制位数
  public int getSumIterative(int a, int b) {
    int n = 1;
    while (b != 0) {
      int sum = a ^ b;
      int carry = (a & b) << 1;
      a = sum;
      b = carry;
      System.out.println(String.format("第%d次, a = %d, b = %d", n, a, b));
      n++;
    }
    return a;
  }

  public static void main(String[] args) {
    P005AlgoCasts casts = new P005AlgoCasts();
    int a = casts.getSumIterative(9, 10);
    int b = casts.getSumRecursive(9, 10);
    System.out.println("19: " + (a == b));
  }
}
