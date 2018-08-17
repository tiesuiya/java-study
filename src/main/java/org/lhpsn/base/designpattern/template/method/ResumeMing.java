package org.lhpsn.base.designpattern.template.method;

/**
 * 简历实体
 *
 * @Author: lihong
 * @Date: 2018/8/17
 * @Description
 */
public class ResumeMing extends AbstractResumeTemplate {
    @Override
    public String getName() {
        return "小明";
    }

    @Override
    public String getPosition() {
        return "C语言主程";
    }

    @Override
    public String getExperience() {
        return "Google上海研究中心2015-2018";
    }

    @Override
    public String getSalary() {
        return "50k";
    }

    @Override
    public String getTellPhone() {
        return "15655556666";
    }
}
