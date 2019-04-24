package org.lhpsn.common.util.tree.generator2;

import org.lhpsn.common.util.tree.TreeNode;
import org.lhpsn.common.util.tree.Treeable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsy
 * @date 2019-04-24 19:24
 */
public class TreeUtil2 {

    public static <E extends Treeable> List<TreeNode<E>> getTree(String id, List<TreeNode<E>> rootTree) {
        List<TreeNode<E>> childList = new ArrayList<>();
        rootTree.forEach(item -> {
            if (item.getValue().getTreePid().equals(id)) {
                childList.add(item);
            }
        });
        childList.forEach(item -> item.setSubList(getTree(item.getValue().getTreeId(), rootTree)));
        return childList;
    }
}
