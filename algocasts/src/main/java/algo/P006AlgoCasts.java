package algo;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashSet;
import java.util.Set;

/**
 * https://algocasts.io/series/algo-problems-1-50/episodes/nwp8Dp7j
 * 这个题目说的是，给你一个非空的整数数组，这个数组中有一个整数只出现了一次，其它的整数都出现两次，你要找出这个只出现一次的整数。
 */
public class P006AlgoCasts {
  // Time: O(n), Space: O(1)
  public static int singleNumberWithXOR(int[] nums) {
    int result = 0;
    for (int num : nums) result ^= num;
    return result;
  }

  // Time: O(n), Space: O(n)
  public static int singleNumberWithSet(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int sum = 0, uniqueSum = 0;
    for (int num : nums) {
      if (!set.contains(num)) {
        uniqueSum += num;
        set.add(num);
      }
      sum += num;
    }
    return 2 * uniqueSum - sum;
  }

  public static void main(String[] args) {
    int[] nums = {7, 7, 9, 9, 3, 3, 2, 11, 11};
    int a = singleNumberWithSet(nums);
    int b = singleNumberWithXOR(nums);
    System.out.println(a);
    System.out.println(b);
  }
}
