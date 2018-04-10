package org.lhpsn.codingskill.common;

/**
 * 链表节点
 *
 * @author lh
 * @since 1.0.0
 */
public class Node {

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