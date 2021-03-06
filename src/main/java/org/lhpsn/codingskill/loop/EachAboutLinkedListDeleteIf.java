package org.lhpsn.codingskill.loop;

import org.lhpsn.codingskill.common.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 关于用循环实现链表删除所有特定节点
 *
 * @author lh
 * @since 1.0.0
 */
public class EachAboutLinkedListDeleteIf {

    public static void main(String[] args) {

        EachAboutLinkedList eachCreator = new EachAboutLinkedList();
        EachAboutLinkedListDeleteIf eachDelete = new EachAboutLinkedListDeleteIf();

        // 边界测试
        Node.printNode(eachDelete.deleteIfLinkedList(2, eachCreator.createLinkedList(new ArrayList<Integer>())));
        Node.printNode(eachDelete.deleteIfLinkedList(2, eachCreator.createLinkedList(Arrays.asList(1))));
        Node.printNode(eachDelete.deleteIfLinkedList(2, eachCreator.createLinkedList(Arrays.asList(2))));
        Node.printNode(eachDelete.deleteIfLinkedList(2, eachCreator.createLinkedList(Arrays.asList(2, 2))));
        Node.printNode(eachDelete.deleteIfLinkedList(2, eachCreator.createLinkedList(Arrays.asList(2, 1))));
        Node.printNode(eachDelete.deleteIfLinkedList(2, eachCreator.createLinkedList(Arrays.asList(1, 2))));
        Node.printNode(eachDelete.deleteIfLinkedList(2, eachCreator.createLinkedList(Arrays.asList(1, 2, 1))));
        Node.printNode(eachDelete.deleteIfLinkedList(2, eachCreator.createLinkedList(Arrays.asList(2, 1, 2))));
    }

    /**
     * 用循环实现链表删除特定节点
     *
     * @param deleteValue 需要删除的节点
     * @param head        头节点
     * @return 处理后的头节点
     */
    public Node deleteIfLinkedList(int deleteValue, Node head) {
        // 预处理
        while (head != null && head.getValue() == deleteValue) {
            head = head.getNext();
        }

        Node prev = head;
        while (prev != null && prev.getNext() != null) {
            Node next = prev.getNext();
            if (next.getValue() == deleteValue) {
                next = next.getNext();
                prev.setNext(next);
            } else {
                prev = next;
            }
        }

        return head;
    }
}
