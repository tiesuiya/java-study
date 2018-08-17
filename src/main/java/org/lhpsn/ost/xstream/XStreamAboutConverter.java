package org.lhpsn.ost.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import lombok.Data;

/**
 * XStream转换操作
 *
 * @Author: lihong
 * @Date: 2018/8/17
 * @Description 教程来自：https://www.yiibai.com/xstream
 */
public class XStreamAboutConverter {

    public static void main(String[] args) {
        // 方式1
        XStream xstream = new XStream(new StaxDriver());
        xstream.autodetectAnnotations(true);
        // 注册转换器
        xstream.registerConverter(new NameConverter());

        // Object to XML Conversion
        String xml = xstream.toXML(XStreamAboutConverter.getStudentDetails());
        System.out.println(XSteamUtil.formatXml(xml));


        // 方式2
        xstream = new XStream(new StaxDriver());
        xstream.autodetectAnnotations(true);
        // 注册转换器
        xstream.registerConverter(new StudentConverter());

        // Object to XML Conversion
        xml = xstream.toXML(XStreamAboutConverter.getStudentDetails());
        System.out.println(XSteamUtil.formatXml(xml));
    }

    /**
     * 构造对象
     *
     * @return 学生对象
     */
    private static Student3 getStudentDetails() {
        Student3 student = new Student3("Mahesh", "Parashar");
        return student;
    }
}

@Data
@XStreamAlias("student")
class Student3 {

    @XStreamAlias("name")
    @XStreamAsAttribute
    private Name studentName;

    public Student3(String firstName, String lastName) {
        this.studentName = new Name(firstName, lastName);
    }
}

@Data
class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

/**
 * 转换器
 */
class NameConverter implements SingleValueConverter {

    private final String splitStr = ",";

    /**
     * String to Object方式
     *
     * @param name 要转换的字符串
     * @return 结果对象
     */
    @Override
    public Object fromString(String name) {
        String[] strings = name.split(splitStr);
        return new Name(strings[0], strings[1]);
    }

    /**
     * Object to String方式
     *
     * @param name 要转换的对象
     * @return 结果字符串
     */
    @Override
    public String toString(Object name) {
        return ((Name) name).getFirstName() + splitStr + ((Name) name).getLastName();
    }

    /**
     * 类型检查
     *
     * @param type 匹配的类型
     * @return 匹配结果
     */
    @Override
    public boolean canConvert(Class type) {
        return type.equals(Name.class);
    }
}


/**
 * 转换器
 */
class StudentConverter implements Converter {

    private final String splitStr = ",";

    /**
     * 对象转字符的方式
     *
     * @param value   对象
     * @param writer  写入器
     * @param context 上下文
     */
    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        Student3 student = (Student3) value;
        writer.startNode("name");
        writer.setValue(student.getStudentName().getFirstName() + splitStr + student.getStudentName().getLastName());
        writer.endNode();
    }

    /**
     * 字符转对象的方式
     *
     * @param reader  读取器
     * @param context 上下文
     * @return 结果对象
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        reader.moveDown();
        String[] strings = reader.getValue().split(splitStr);
        Student3 student = new Student3(strings[0], strings[1]);
        reader.moveUp();
        return student;
    }


    /**
     * 类型检查
     *
     * @param object 匹配的类型
     * @return 匹配结果
     */
    @Override
    public boolean canConvert(Class object) {
        return object.equals(Student3.class);
    }
}
