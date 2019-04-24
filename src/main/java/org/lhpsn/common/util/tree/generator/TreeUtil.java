package org.lhpsn.common.util.tree.generator;

import org.lhpsn.common.util.tree.TreeNode;
import org.lhpsn.common.util.tree.Treeable;

import java.util.*;

/**
 * @author tsy
 * @date 2019-04-23 11:56
 */
public class TreeUtil {

    private static Collection setTemp;

    public static <E extends Treeable> List<TreeNode<E>> generate(Collection<E> collection, String pid) {
        setTemp = collection;
        List<TreeNode<E>> list = new ArrayList<>();

        List<E> sortedList = new ArrayList<>(collection);
        sortedList.sort(Comparator.comparing(Treeable::getTreeId));

        int count = 0;
        while (sortedList.size() > 0 && count++ < 10) {
            sortedList.removeIf(e -> addToTreeB(list, e, pid));
        }
        System.out.println("有几条可能没找到:" + setTemp);
        return list;
    }

    private static <E extends Treeable> boolean addToTreeB(List<TreeNode<E>> list, E e, String pid) {
        addToTree(list, e, pid);
        return !setTemp.contains(e);
    }

    private static <E extends Treeable> void addToTree(List<TreeNode<E>> list, E e, String pid) {
        if (e.getTreePid() == null
                || "null".equals(e.getTreePid())
                || "".equals(e.getTreePid())
                || (pid != null && Objects.equals(pid, e.getTreePid()))) {
            list.add(new TreeNode<>(e));
            setTemp.remove(e);
        } else {
            for (TreeNode<E> node : list) {
                if (e.getTreePid() != null && e.getTreePid().equals(node.getValue().getTreeId())) {
                    node.getSubList().add(new TreeNode<>(e));
                    setTemp.remove(e);
                }
                if (node.getSubList().size() > 0) {
                    addToTree(node.getSubList(), e, pid);
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
