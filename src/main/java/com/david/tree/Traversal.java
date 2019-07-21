package com.david.tree;

/**
 * @author: sun chao
 * Create at: 2019-07-21
 */
public class Traversal {

    public static void main(String[] args) {
        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");
        TreeNode g = new TreeNode("g");
        TreeNode h = new TreeNode("h");
        TreeNode i = new TreeNode("i");
        TreeNode j = new TreeNode("j");
        TreeNode k = new TreeNode("k");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        d.left = h;
        d.right = i;
        e.right = j;
        c.left = f;
        c.right = g;
        f.right = k;
    }

    /**
     * 递归最大深度--没验证
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    //最小深度，没验证
/*    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right == null) {
            re
        }
    }*/
}
