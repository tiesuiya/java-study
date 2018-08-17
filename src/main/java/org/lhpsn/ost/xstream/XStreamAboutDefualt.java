package org.lhpsn.ost.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * XStream基本操作
 *
 * @Author: lihong
 * @Date: 2018/8/17
 * @Description 教程来自：https://www.yiibai.com/xstream
 */
public class XStreamAboutDefualt {

    public static void main(String[] args) {
        XStream xstream = new XStream(new StaxDriver());
        // 类混叠
        xstream.alias("student", Student.class);
        xstream.alias("note", Note.class);
        // 字段混叠（注意：字段混叠后，XML to Object默认转换肯定会失败了，因为字段对应不上了，解决办法是再“反向操作一下”）
        xstream.aliasField("name", Student.class, "studentName");

        // Object to XML Conversion
        String xml = xstream.toXML(XStreamAboutDefualt.getStudentDetails());
        System.out.println(XSteamUtil.formatXml(xml));

        // XML to Object Conversion
        // 字段混叠“反向操作”
        xstream.aliasField("studentName", Student.class, "name");
        System.out.println(xstream.fromXML(xml));

        // 其他操作

        // 隐式集合混叠（隐藏集合根节点）
        // xstream.addImplicitCollection(Student4.class, "notes");

        // 属性混叠（让成员变量作为XML属性序列化<student name="Mahesh">）
        // xstream.useAttributeFor(Student4.class, "studentName");

        // 包混叠
        // xstream.aliasPackage("my.diy.xstream", "org.lhpsn.ost.xstream");
    }

    /**
     * 构造对象
     *
     * @return 学生对象
     */
    private static Student getStudentDetails() {
        Student student = new Student("Mahesh");
        student.addNote(new Note("first", "My first assignment."));
        student.addNote(new Note("second", "My Second assignment."));
        return student;
    }

}

@Data
class Student {
    private String studentName;
    private List<Note> notes = new ArrayList<>();

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public void addNote(Note note) {
        notes.add(note);
    }
}

@Data
class Note {
    private String title;
    private String description;

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }
}