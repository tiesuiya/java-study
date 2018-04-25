package org.lhpsn.codingskill.recursion;

/**
 * 关于高斯的递归算法
 *
 * @author lh
 * @since 1.0.0
 */
public class RecursiveAboutGuass {

    public static void main(String[] args) {

        System.out.println(sum(100));
    }

    /**
     * 递归求和
     *
     * @param max 需要统计sum的结尾数
     * @return 和值
     */
    private static int sum(int max) {
        if (max == 1) {
            return 1;
        }
        return sum(max - 1) + max;
    }
}
