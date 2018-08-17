package org.lhpsn.ost.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;
import lombok.Data;

import java.io.Writer;


/**
 * XStreamJSON操作
 *
 * @Author: lihong
 * @Date: 2018/8/17
 * @Description 教程来自：https://www.yiibai.com/xstream
 */
public class XStreamAboutJSON {

    public static void main(String[] args) {
        XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
            @Override
            public HierarchicalStreamWriter createWriter(Writer writer) {
                return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
            }
        });

        // Object to JSON
        String json = xstream.toXML(new Student4("Mahesh", "Parashar"));
        System.out.println(json);

        // JSON to Object
        // 待实现
    }
}

@Data
@XStreamAlias("student")
class Student4 {

    private String firstName;
    private String lastName;

    public Student4(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}