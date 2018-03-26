package org.lhpsn.codingskill.loop;

import org.lhpsn.codingskill.common.Node;

import java.util.Arrays;
import java.util.List;

/**
 * 关于单向链表的循环实现
 *
 * @author lh
 * @since 1.0.0
 */
public class EachAboutLinkedList {

    public static void main(String[] args) {
        EachAboutLinkedList eachCreator = new EachAboutLinkedList();
        Node.printNode(eachCreator.createLargeLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    /**
     * 循环实现创建链表
     * 循环书写方法
     * - 1.定义循环不变式，并在每次循环体结束后保持循环不变式
     * - 2.先一般，后特殊
     * - 3.每次必须向前推进循环不变式中涉及的变量值
     * - 4.每次缩小规模必须为1
     *
     * @param integers Integer数组
     * @return 链表首个节点
     */
    public Node createLargeLinkedList(List<Integer> integers) {
        Node prev = null;
        Node head = null;
        for (int i = 0; i < integers.size(); i++) {
            Node node = new Node(integers.get(i));
            if (prev != null) {
                prev.setNext(node);
            } else {
                head = node;
            }
            prev = node;
        }
        return head;
    }
}
