package org.lhpsn.common.util.tree.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsy
 * @date 2019-04-23 11:50
 */
public class TreeNode<T extends Treeable> {
    private T value;
    private List<TreeNode<T>> subList;

    public TreeNode(T value) {
        this.value = value;
        subList = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<TreeNode<T>> getSubList() {
        return subList;
    }

    public void setSubList(List<TreeNode<T>> subList) {
        this.subList = subList;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
