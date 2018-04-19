package org.lhpsn.base.typeofdata;

import org.lhpsn.base.typeofdata.common.TreeNode;

/**
 * 关于二叉树的推导
 *
 * @author lh
 * @since 1.0.0
 */
public class BinaryTreeAboutDerivation {

    public static void main(String[] args) {

        // 前序遍历和中序遍历推导树节点
        BinaryTreeAboutDerivation derivation = new BinaryTreeAboutDerivation();
        BinaryTreeAboutTraversal traversal = new BinaryTreeAboutTraversal();
        derivation.createTreeNodeByPreValueAndInValue("ABDEGCF", "DBEGACF");
//        traversal.preOrder(derivation.createTreeNodeByPreValueAndInValue("ABDEGCF", "DBEGACF"));
//        System.out.println();
//        traversal.inOrder(derivation.createTreeNodeByPreValueAndInValue("ABDEGCF", "DBEGACF"));
//        System.out.println();
//        traversal.postOrder(derivation.createTreeNodeByPreValueAndInValue("ABDEGCF", "DBEGACF"));
    }

    /**
     * 由前序遍历和中序遍历推导
     *
     * @param preOrder 前序遍历值
     * @param inOrder  中序遍历值
     * @return 树节点
     */
    public TreeNode createTreeNodeByPreValueAndInValue(String preOrder, String inOrder) {
        if (preOrder.isEmpty()) {
            return null;
        }

        // 根节点值
        char rootValue = preOrder.charAt(0);
        // 创建根节点
        TreeNode root = new TreeNode(rootValue);
        // 通过根节点和中序排序内容，计算左子树长度
        int leftLength = inOrder.indexOf(rootValue);

        root.setRightNode(
                createTreeNodeByPreValueAndInValue(
                        preOrder.substring(1 + leftLength),
                        inOrder.substring(1 + leftLength)
                )
        );
        root.setLeftNode(
                createTreeNodeByPreValueAndInValue(
                        preOrder.substring(1, 1 + leftLength),
                        inOrder.substring(0, leftLength)
                )
        );

        return root;
    }

    /**
     * TODO 前序遍历和后序遍历推导中序遍历 这个结果会有多个
     */
    public void todo() {
    }

}
