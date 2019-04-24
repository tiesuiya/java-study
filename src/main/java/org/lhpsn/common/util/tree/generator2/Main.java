package org.lhpsn.common.util.tree.generator2;

import org.lhpsn.common.util.tree.AreaDataUtil;
import org.lhpsn.common.util.tree.TreeNode;
import org.lhpsn.common.util.tree.generator.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsy
 * @date 2019-04-24 19:29
 */
public class Main {

    public static void main(String[] args) throws Exception {
        List<AreaDataUtil.Area> areaData = AreaDataUtil.getAreaData();
        List<TreeNode<AreaDataUtil.Area>> list = new ArrayList<>();
        areaData.forEach(e -> list.add(new TreeNode<>(e)));

        long start = System.currentTimeMillis();
        List<TreeNode<AreaDataUtil.Area>> treeNodes = TreeUtil2.getTree("0", list);
        long time = System.currentTimeMillis() - start;
        TreeUtil.printTree(treeNodes);
        System.out.println("方法二耗时：" + time);
    }
}
