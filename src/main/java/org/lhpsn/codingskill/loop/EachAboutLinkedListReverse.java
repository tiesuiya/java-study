package org.lhpsn.codingskill.loop;

import org.lhpsn.codingskill.common.Node;
import org.lhpsn.codingskill.recursion.RecursiveAboutLinkedList;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 关于单向链表反转的循环实现
 *
 * @author lh
 * @since 1.0.0
 */
public class EachAboutLinkedListReverse {

    public static void main(String[] args) {

        RecursiveAboutLinkedList recursiveCreator = new RecursiveAboutLinkedList();
        EachAboutLinkedListReverse eachReverse = new EachAboutLinkedListReverse();

        Node.printNode(eachReverse.reverseLinkedList(recursiveCreator.createLinkedList(new ArrayList<Integer>())));
        Node.printNode(eachReverse.reverseLinkedList(recursiveCreator.createLinkedList(Arrays.asList(1))));
        Node.printNode(eachReverse.reverseLinkedList(recursiveCreator.createLinkedList(Arrays.asList(1, 2, 3, 5, 6, 7))));
    }

    /**
     * 循环实现反转LinkedList
     * 循环书写方法
     * - 1.定义循环不变式，并在每次循环体结束后保持循环不变式
     * - 2.先一般，后特殊
     * - 3.每次必须向前推进循环不变式中涉及的变量值
     * - 4.每次缩小规模必须为1
     *
     * @param head 原链表头
     * @return 反转后的链表头
     */
    public Node reverseLinkedList(Node head) {
        // neaHead指向已经反转的链表
        Node newHead = null;
        // curHead指向还未反转的链表
        Node curHead = head;

        // 需要维持循环不变量
        while (curHead != null) {
            // 需要维持循环不变量
            Node next = curHead.getNext();
            curHead.setNext(newHead);
            newHead = curHead;
            curHead = next;
            // 需要维持循环不变量
        }
        // 需要维持循环不变量
        return newHead;
    }

}
