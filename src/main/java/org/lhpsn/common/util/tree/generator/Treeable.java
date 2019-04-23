/**
 * merchant-boss
 * <p>
 * Copyright 2014 Acooly.cn, Inc. All rights reserved.
 *
 * @author RQ021
 * @date 2019-04-23 11:55
 */
package org.lhpsn.common.util.tree.generator;

/**
 * @author tsy
 * @date 2019-04-23 11:55
 */
public interface Treeable extends Comparable {

    Object getTreeId();

    Object getTreePid();
}
