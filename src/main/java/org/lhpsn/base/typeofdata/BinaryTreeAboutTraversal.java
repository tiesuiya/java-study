package org.lhpsn.base.typeofdata;

import org.lhpsn.base.typeofdata.common.TreeNode;

/**
 * 关于二叉树的遍历方式
 *
 * @author lh
 * @since 1.0.0
 */
public class BinaryTreeAboutTraversal {

    public static void main(String[] args) {

        BinaryTreeAboutTraversal traversal = new BinaryTreeAboutTraversal();

        //       a
        //    b     c
        //  d  e      f
        //       g
        TreeNode treeNode = TreeNode.createSimpleTreeNode();
        System.out.print("前序遍历：");
        traversal.preOrder(treeNode);
        System.out.println();

        System.out.print("中序遍历：");
        traversal.inOrder(treeNode);
        System.out.println();

        System.out.print("后序遍历：");
        traversal.postOrder(treeNode);
    }

    /**
     * 前序遍历
     *
     * @param root 当前遍历根节点
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue());
        preOrder(root.getLeftNode());
        preOrder(root.getRightNode());
    }

    /**
     * 中序遍历
     *
     * @param root 当前遍历根节点
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeftNode());
        System.out.print(root.getValue());
        inOrder(root.getRightNode());
    }

    /**
     * 后序遍历
     *
     * @param root 当前遍历根节点
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeftNode());
        postOrder(root.getRightNode());
        System.out.print(root.getValue());
    }

}
