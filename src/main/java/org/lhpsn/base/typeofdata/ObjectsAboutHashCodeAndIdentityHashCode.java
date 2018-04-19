package org.lhpsn.base.typeofdata;


/**
 * 关于对象的HashCode和IdentityHashCode
 * <p>
 * 1.identityHashCode()是根据对象的'内存地址'来产生hash值的，相当于==判断
 * 2.hashCode()是根据对象的'内容'来产生hash值的，其中：
 * (1)如果两个对象相同（equals方法返回true），那么它们的hashCode值一定要相同；
 * (2)如果两个对象的hashCode相同，它们并不一定相同。
 *
 * @author lh
 * @since 1.0.0
 */
public class ObjectsAboutHashCodeAndIdentityHashCode {

    public static void main(String[] args) {

        String s1 = "Programming";
        String s2 = new String("Programming");

        // a b
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));

        // a a
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        // false
        System.out.println(s1 == s2);
    }

}
