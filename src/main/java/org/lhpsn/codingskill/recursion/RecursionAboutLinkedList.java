package org.lhpsn.codingskill.recursion;

import org.lhpsn.codingskill.common.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 关于单向链表的递归实现
 *
 * @author lh
 * @since 1.0.0
 */
public class RecursionAboutLinkedList {

    public static void main(String[] args) {

        RecursionAboutLinkedList recursiveCreator = new RecursionAboutLinkedList();

        // 边界测试
        Node.printNode(recursiveCreator.createLinkedList(new ArrayList<Integer>()));
        Node.printNode(recursiveCreator.createLinkedList(Arrays.asList(1)));
        Node.printNode(recursiveCreator.createLinkedList(Arrays.asList(1, 2, 3, 5, 6, 7)));
    }

    /**
     * 递归创建链表
     *
     * @param list 参数集合
     * @return 返回首个节点，如果是最后一个节点，那么其subNode为null
     */
    public Node createLinkedList(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        Node firstNode = new Node(list.get(0));
        firstNode.setNext(createLinkedList(list.subList(1, list.size())));
        return firstNode;
    }
}
