package org.lhpsn.base.designpattern.template.method;

/**
 * 简历实体
 *
 * @Author: lihong
 * @Date: 2018/8/17
 * @Description
 */
public class ResumeWang extends AbstractResumeTemplate {
    @Override
    public String getName() {
        return "小王";
    }

    @Override
    public String getPosition() {
        return "JAVA主程";
    }

    @Override
    public String getExperience() {
        return "T赞实验室2017-2018";
    }

    @Override
    public String getSalary() {
        return "24k";
    }

    @Override
    public String getTellPhone() {
        return "13666666666";
    }
}
