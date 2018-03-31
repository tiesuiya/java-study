package org.lhpsn.javabase.oop;

import org.lhpsn.codingskill.common.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 关于使用接口实现一个LinkedList
 *
 * @author lh
 * @since 1.0.0
 */
public class InterfaceAboutLinkedListImpl {

    public static void main(String[] args) {
        // init
        LinkedList linkedList = new LinkedList();
        int listSize = 100;
        for (int i = 0; i < listSize; i++) {
            linkedList.add(i);
        }

        // print
        for (Integer i : linkedList) {
            System.out.println(i);
        }
    }
}

/**
 * LinkedList手动实现，需要实现Iterable接口
 */
class LinkedList implements Iterable<Integer> {

    private Node head;
    private Node last;

    public void add(int value) {
        Node node = new Node(value);
        if (last == null) {
            head = node;
        } else {
            last.setNext(node);
        }
        last = node;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator(head);
    }

    class LinkedListIterator implements Iterator<Integer> {

        private Node currentNode;

        public LinkedListIterator(Node currentNode) {
            this.currentNode = currentNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Integer next() {
            if (currentNode == null) {
                throw new NoSuchElementException();
            }
            int value = currentNode.getValue();
            currentNode = currentNode.getNext();
            return value;
        }

        @Override
        public void remove() {

        }
    }
}