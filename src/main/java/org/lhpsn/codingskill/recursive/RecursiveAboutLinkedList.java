package org.lhpsn.codingskill.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 关于单向链表的递归实现
 *
 * @author lh
 * @since 1.0.0
 */
public class RecursiveAboutLinkedList {

    public static void main(String[] args) {
        RecursiveAboutLinkedList recursiveAboutLinkedList = new RecursiveAboutLinkedList();

        Node.printNode(recursiveAboutLinkedList.createLinkedList(new ArrayList<Integer>()));
        Node.printNode(recursiveAboutLinkedList.createLinkedList(Arrays.asList(1)));
        Node.printNode(recursiveAboutLinkedList.createLinkedList(Arrays.asList(1, 2, 3, 5, 6, 7)));
    }

    /**
     * 创建链表
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

/**
 * 链表节点
 */
class Node {
    private final int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.getValue() + "\t");
            node = node.getNext();
        }
        System.out.println();
    }
}
