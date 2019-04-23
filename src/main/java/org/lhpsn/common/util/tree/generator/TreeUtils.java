package org.lhpsn.common.util.tree.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author tsy
 * @date 2019-04-23 11:56
 */
public class TreeUtils {

    public static <E extends Treeable> List<TreeNode<E>> generate(Collection<E> collection, Object pid) {
        List<E> sourceList = new ArrayList<>(collection);
        sourceList.sort(Treeable::compareTo);
        List<TreeNode<E>> list = new ArrayList<>();
        for (E e : sourceList) {
            generateRecursion(list, e, pid);
        }
        return list;
    }

    private static <E extends Treeable> void generateRecursion(List<TreeNode<E>> list, E e, Object pid) {
        if (e.getTreePid() == null || "".equals(e.getTreePid()) || Objects.equals(pid, e.getTreePid())) {
            list.add(new TreeNode<>(e));
        } else {
            for (TreeNode<E> node : list) {
                if (e.getTreePid() != null && e.getTreePid().equals(node.getValue().getTreeId())) {
                    node.getSubList().add(new TreeNode<>(e));
                }
                if (node.getSubList().size() > 0) {
                    generateRecursion(node.getSubList(), e, pid);
                }
            }
        }
    }

    public static <E extends Treeable> void printTree(List<TreeNode<E>> nodes) {
        for (TreeNode<E> node : nodes) {
            printRecursion(node, 0);
        }
    }

    private static <E extends Treeable> void printRecursion(TreeNode<E> treeNode, int level) {
        level++;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < level; i++) {
            if (i == level - 1) {
                prefix.append("└");
            } else {
                prefix.append("  ");
            }
        }
        System.out.println(prefix.toString() + treeNode.getValue());

        if (treeNode.getSubList().size() > 0) {
            for (TreeNode<E> node : treeNode.getSubList()) {
                printRecursion(node, level);
            }
        }
    }
}
