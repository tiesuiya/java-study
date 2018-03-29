package org.lhpsn.javabase.typeofdata.common;

/**
 * @author lh
 * @since 1.0.0
 */
public class TreeNode {
    private final char value;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(char value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public char getValue() {
        return value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    /**
     * 创建简单树节点
     *
     * @return 简单树节点
     */
    public static TreeNode createSimpleTreeNode() {
        //       a
        //    b     c
        //  d  e      f
        //       g
        TreeNode root = new TreeNode('A');
        TreeNode rootB = new TreeNode('B');
        TreeNode rootC = new TreeNode('C');
        TreeNode rootD = new TreeNode('D');
        TreeNode rootE = new TreeNode('E');
        TreeNode rootF = new TreeNode('F');
        TreeNode rootG = new TreeNode('G');
        rootE.setRightNode(rootG);
        rootB.setRightNode(rootE);
        rootB.setLeftNode(rootD);
        rootC.setRightNode(rootF);
        root.setRightNode(rootC);
        root.setLeftNode(rootB);
        return root;
    }
}
