package org.lhpsn.codingskill;

import org.lhpsn.codingskill.common.Node;
import org.lhpsn.codingskill.loop.EachAboutLinkedList;
import org.lhpsn.codingskill.loop.EachAboutLinkedListReverse;
import org.lhpsn.codingskill.recursion.RecursiveAboutLinkedList;
import org.lhpsn.codingskill.recursion.RecursiveAboutLinkedListReverse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 关于链表的性能测试
 *
 * @author lh
 * @since 1.0.0
 */
public class SpeadTestAboutLinkedList {

    public static void main(String[] args) {

        int size = 7000;
        List<Integer> integerArray = createIntegerArray(size);

        long timestamp = System.currentTimeMillis();

        // 递归实现
        RecursiveAboutLinkedList recursiveCreator = new RecursiveAboutLinkedList();
        RecursiveAboutLinkedListReverse recursiveReverse = new RecursiveAboutLinkedListReverse();
        // create
        Node nodeRecusive = recursiveCreator.createLinkedList(integerArray);
        System.out.println("递归创建" + size + "条数据耗时（ms）：" + (System.currentTimeMillis() - timestamp));
        timestamp = System.currentTimeMillis();
        // reverse
        recursiveReverse.reverseLinkedList(nodeRecusive);
        System.out.println("递归反转" + size + "条数据耗时（ms）：" + (System.currentTimeMillis() - timestamp));


        // 递归直接StackOverflow了，这里重新给值
        size = 10000000;
        integerArray = createIntegerArray(size);
        // 重新计时
        timestamp = System.currentTimeMillis();

        // 循环实现
        EachAboutLinkedList eachCreator = new EachAboutLinkedList();
        EachAboutLinkedListReverse eachReverse = new EachAboutLinkedListReverse();
        // create
        Node nodeEach = eachCreator.createLargeLinkedList(integerArray);
        System.out.println("循环创建" + size + "条数据耗时（ms）：" + (System.currentTimeMillis() - timestamp));
        timestamp = System.currentTimeMillis();
        // reverse
        eachReverse.reverseLinkedList(nodeEach);
        System.out.println("循环反转" + size + "条数据耗时（ms）：" + (System.currentTimeMillis() - timestamp));

        System.out.println("done");

        /*
         * 本机测试发现：
         * 递归创建极限7000
         * 递归反转极限1000
         * 然后就StackOverflowError了
         *
         * 循环创建10000000条数据耗时（ms）：2701
         * 循环反转10000000条数据耗时（ms）：47
         * 当然，用一亿条数据就OutOfMemoryError了
         *
         * 结论：某些时候循环是爸爸
         */
    }

    /**
     * 创建Integer数组
     *
     * @param size 数组大小
     * @return 数组对象
     */
    private static List<Integer> createIntegerArray(int size) {
        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            integers.add(new Random().nextInt(10000));
        }
        return integers;
    }
}
