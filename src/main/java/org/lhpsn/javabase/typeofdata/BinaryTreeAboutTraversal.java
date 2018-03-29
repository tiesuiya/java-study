package org.lhpsn.javabase.typeofdata;

import org.lhpsn.javabase.typeofdata.common.TreeNode;

/**
 * 关于二叉树的遍历方式
 *
 * @author lh
 * @since 1.0.0
 */
public class BinaryTreeAboutTraversal {

    public static void main(String[] args) {
        BinaryTreeAboutTraversal traversal = new BinaryTreeAboutTraversal();

        TreeNode treeNode = TreeNode.createSimpleTreeNode();
        traversal.preOrder(treeNode);
        System.out.println();

        traversal.inOrder(treeNode);
        System.out.println();

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
