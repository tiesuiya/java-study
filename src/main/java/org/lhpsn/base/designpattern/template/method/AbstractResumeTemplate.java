package org.lhpsn.base.designpattern.template.method;

/**
 * 简历模板
 *
 * @Author: lihong
 * @Date: 2018/8/17
 * @Description
 */
public abstract class AbstractResumeTemplate {

    public void showResume() {
        System.out.println("--------------简 历--------------");
        System.out.println("-- 姓名：\t" + getName());
        System.out.println("-- 职位：\t" + getPosition());
        System.out.println("-- 履历：\t" + getExperience());
        System.out.println("-- 薪资：\t" + getSalary());
        System.out.println("-- 电话：\t" + getTellPhone());
        System.out.println("---------------------------------");
        System.out.println();
    }

    public abstract String getName();

    public abstract String getPosition();

    public abstract String getExperience();

    public abstract String getSalary();

    public abstract String getTellPhone();

}
