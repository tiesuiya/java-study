package org.lhpsn.util;

import java.io.*;

/**
 * 对象克隆帮助类
 *
 * @author lh
 * @since 1.0.0
 */
public class CloneUtil {

    /**
     * 通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆
     *
     * @param obj 待克隆对象
     * @param <T> Serializable泛型限定，需要特别注意的是T所包含的对象也需要实现Serializable接口，这一点在编译时无法检查到！
     * @return 克隆对象
     * @throws Exception 克隆异常
     */
    public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
    }
}
