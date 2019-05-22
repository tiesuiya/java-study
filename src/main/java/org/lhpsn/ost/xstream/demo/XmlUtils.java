package org.lhpsn.ost.xstream.demo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/**
 * @author tsy
 * @date 2019-05-21 17:44
 */
public final class XmlUtils {

    private static XStream xStream = new XStream(new StaxDriver());

    static {
        // 注解方式
        xStream.autodetectAnnotations(true);
        // 去掉 class 属性
        xStream.aliasSystemAttribute(null, "class");
    }

    public static <T> T fromXML(String xml, Class<T> clazz) {
        xStream.processAnnotations(clazz);
        return (T) xStream.fromXML(xml);
    }

    public static String toXML(Object o) {
        String declare = "<?xml version=\"1.0\" encoding=\"GBK\"?>";
        String xml = xStream.toXML(o);
        // 暂时找不到替换头的方法，手动替换
        xml = xml.replaceAll("<\\?xml version=\"1.0\" \\?>", "");
        xml = declare + xml;
        return xml;
    }
}
