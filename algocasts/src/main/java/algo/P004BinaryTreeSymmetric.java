package algo;

import java.util.Stack;

public class P004BinaryTreeSymmetric {
  public static class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      value = x;
    }
  }

  static boolean isSymmetric(TreeNode l, TreeNode r) {
    if (l != null && r != null)
      return l.value == r.value && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    else return l == null && r == null;
  }

  // Time: O(n), Space: O(n)
  public static boolean isSymmetricTreeRecursive(TreeNode root) {
    if (root == null) return true;
    return isSymmetric(root.left, root.right);
  }

  public static boolean isSymmetricTreeIterative(TreeNode root) {
    if (root == null) return true;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root.left);
    stack.push(root.right);
    while (!stack.empty()) {
      TreeNode r = stack.pop(), l = stack.pop();
      if (r == null && l == null) continue;
      else if (r == null || l == null) return false;
      else if (r.value != l.value) return false;

      stack.push(r.left);
      stack.push(l.right);
      stack.push(r.right);
      stack.push(l.left);
    }
    return true;
  }

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(1);
    tree.left = new TreeNode(2);
    tree.right = new TreeNode(2);
    tree.left.left = new TreeNode(3);
    tree.left.right = new TreeNode(4);
    tree.right.left = new TreeNode(4);
    tree.right.right = new TreeNode(3);
    tree.left.left.left = new TreeNode(5);
    tree.left.left.right = new TreeNode(6);
    tree.left.right.left = new TreeNode(7);
    tree.left.right.right = new TreeNode(8);
    tree.right.left.left = new TreeNode(8);
    tree.right.left.right = new TreeNode(7);
    tree.right.right.left = new TreeNode(6);
    tree.right.right.right = new TreeNode(5);

    System.out.println(isSymmetricTreeIterative(tree));
    System.out.println(isSymmetricTreeRecursive(tree));
  }
}
