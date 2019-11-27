package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * P29. 括号的合法排列 https://algocasts.io/series/algo-problems-1-50/episodes/KApAjW6R 这个题目说的是，给你 n
 * 对括号，你要返回这 n 对括号的所有合法排列方式。
 *
 * <pre>
 * 比如说，n 等于 3 时，合法的排列有 5 个：
 *
 *  ((()))
 *  (()())
 *  (())()
 *  ()(())
 *  ()()()
 * </pre>
 */
public class P029AlgoCasts {

  private void generate(List<String> result, String str, int left, int right) {
    if (left == 0 && right == 0) {
      result.add(str);
    } else {
      if (left > 0) generate(result, str + '(', left - 1, right);
      if (right > left) generate(result, str + ')', left, right - 1);
    }
  }

  // Time: O(4^n / sqrt(n)), Space: O(n)
  public List<String> generateParentheses(int n) {
    if (n <= 0) return new ArrayList<>();
    List<String> result = new ArrayList<>();
    generate(result, "", n, n);
    return result;
  }

  // Time: O(4^n / n*sqrt(n)), Space: O(4^n / n*sqrt(n))
  public List<String> generateParenthesesDP(int n) {
    if (n <= 0) return new ArrayList<>();
    List<List<String>> d = new ArrayList<>(n + 1);
    for (int i = 0; i < n + 1; ++i) {
      d.add(new ArrayList<>());
    }
    d.get(0).add("");
    for (int i = 1; i < n + 1; ++i) {
      for (int j = 0; j < i; ++j) {
        for (String left : d.get(j)) {
          for (String right : d.get(i - j - 1)) {
            d.get(i).add('(' + left + ')' + right);
          }
        }
      }
    }
    return d.get(n);
  }
}
