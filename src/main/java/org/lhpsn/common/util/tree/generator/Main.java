package org.lhpsn.common.util.tree.generator;

import org.lhpsn.common.util.tree.AreaDataUtil;
import org.lhpsn.common.util.tree.TreeNode;

import java.util.List;

/**
 * @author tsy
 * @date 2019-04-23 11:27
 */
public class Main {

    /*
     *  失败案例！
     *
     *  玄学代码！
     *
     *  逻辑鬼才！
     *
     */

    public static void main(String[] args) throws Exception {
        List<AreaDataUtil.Area> areaData = AreaDataUtil.getAreaData();

        long start = System.currentTimeMillis();
        List<TreeNode<AreaDataUtil.Area>> tree = TreeUtil.generate(areaData, "0");
        long time = System.currentTimeMillis() - start;
        TreeUtil.printTree(tree);
        System.out.println("方法一耗时：" + time);
    }

}
