package org.lhpsn.codingskill.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 关于组合的递归实现
 *
 * @author lh
 * @since 1.0.0
 */
public class RecursionAboutCombination {

    public static void main(String[] args) {

        RecursionAboutCombination combinationCreator = new RecursionAboutCombination();

        // 边界测试
        print(combinationCreator.combination(new ArrayList<Integer>(), 0));
        print(combinationCreator.combination(new ArrayList<Integer>(), 10));
        print(combinationCreator.combination(Arrays.asList(1), 0));
        print(combinationCreator.combination(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 5));
    }

    /**
     * 排列结果
     */
    private List<List<Integer>> results;

    /**
     * 排列组合拼装函数
     *
     * @param data 需要进行排列的集合
     * @param n    需要选取用于排列的个数
     * @return 组合集合
     */
    public List<List<Integer>> combination(List<Integer> data, int n) {
        results = new ArrayList<>();
        combination(new ArrayList<Integer>(), data, n);
        return results;
    }

    /**
     * 排列组合执行函数
     * <p>
     * 递归要素：
     * - 1.严格定义递归函数作用，包括参数，返回值,side-effect
     * - 2.先一般，后特殊（先写一般情况，再写特殊情况）
     * - 3.每次调用必须缩小问题规模
     * - 4.每次缩小规模必须为1
     *
     * @param selected 所选的值
     * @param data     需要进行排列的集合
     * @param n        需要选取用于排列的个数
     */
    private void combination(List<Integer> selected, List<Integer> data, int n) {
        // n==0说明已经处理完了一位
        if (n == 0) {
            // new ArrayList<>()创建新对象
            results.add(new ArrayList<>(selected));
            return;
        }

        if (data.isEmpty()) {
            return;
        }

        // 选取第一位数
        selected.add(data.get(0));
        combination(selected, data.subList(1, data.size()), n - 1);

        // 不选取第一位数
        selected.remove(selected.size() - 1);
        combination(selected, data.subList(1, data.size()), n);
    }

    /**
     * print
     *
     * @param results 排列结果
     */
    private static void print(List<List<Integer>> results) {
        for (List<Integer> r : results) {
            for (Integer num : r) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println("- - - - - - -");
    }
}
