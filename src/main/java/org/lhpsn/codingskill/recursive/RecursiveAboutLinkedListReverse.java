package org.lhpsn.codingskill.recursive;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 关于单向链表反转的递归实现
 *
 * @author lh
 * @since 1.0.0
 */
public class RecursiveAboutLinkedListReverse {

    public static void main(String[] args) {
        RecursiveAboutLinkedListReverse reverse = new RecursiveAboutLinkedListReverse();
        RecursiveAboutLinkedList creator = new RecursiveAboutLinkedList();

        Node.printNode(reverse.reverseLinkedList(creator.createLinkedList(new ArrayList<Integer>())));
        Node.printNode(reverse.reverseLinkedList(creator.createLinkedList(Arrays.asList(1))));
        Node.printNode(reverse.reverseLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 3, 5, 6, 7))));
    }

    /**
     * 反转linkedList
     *
     * @param head 第一个节点
     * @return 反转后的的第一个节点
     */
    public Node reverseLinkedList(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        // 1 2 3 4 5 null
        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }
}


