package org.lhpsn.base.designpattern.template.method;

/**
 * 模板方法模式
 *
 * @Author: lihong
 * @Date: 2018/8/17
 * @Description
 */
public class Application {

    public static void main(String[] args) {

        new ResumeMing().showResume();

        new ResumeWang().showResume();

    }
}
