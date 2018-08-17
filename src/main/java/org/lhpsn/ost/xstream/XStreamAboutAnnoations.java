package org.lhpsn.ost.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static org.lhpsn.ost.xstream.XSteamUtil.formatXml;

/**
 * XStream注解操作
 *
 * @Author: lihong
 * @Date: 2018/8/17
 * @Description 教程来自：https://www.yiibai.com/xstream
 */
public class XStreamAboutAnnoations {

    public static void main(String[] args) {
        XStream xstream = new XStream(new StaxDriver());
        // 告诉框架以注解方式处理（也可以这样xstream.processAnnotations(Student2.class);）
        xstream.autodetectAnnotations(true);

        // Object to XML Conversion
        String xml = xstream.toXML(XStreamAboutAnnoations.getStudentDetails());
        System.out.println(formatXml(xml));
    }

    /**
     * 构造对象
     *
     * @return 学生对象
     */
    private static Student2 getStudentDetails() {
        Student2 student = new Student2("Mahesh");
        student.addNote(new Note2("first", "My first assignment."));
        student.addNote(new Note2("second", "My Second assignment."));
        student.setType(1);
        return student;
    }
}

/**
 * XStreamAlias 定义类级别别名
 */
@Data
@XStreamAlias("student")
class Student2 {

    /**
     * XStreamAlias 定义字段级别别名
     * XStreamAsAttribute 定义字段以属性方式显示
     */
    @XStreamAlias("name")
    @XStreamAsAttribute
    private String studentName;

    /**
     * 定义列表为隐式集合（隐藏根节点）
     */
    @XStreamImplicit
    private List<Note2> notes = new ArrayList<>();

    /**
     * 忽略字段
     */
    @XStreamOmitField
    private int type;

    public Student2(String studentName) {
        this.studentName = studentName;
    }

    public void addNote(Note2 note) {
        notes.add(note);
    }
}

@Data
@XStreamAlias("note")
class Note2 {
    private String title;
    private String description;

    public Note2(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
