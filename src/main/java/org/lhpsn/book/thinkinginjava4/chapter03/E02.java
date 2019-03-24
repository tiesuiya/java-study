package org.lhpsn.book.thinkinginjava4.chapter03;

/**
 * @author tsy
 */
public class E02 {

    public static void main(String[] args) {
        // 展示"别名机制"：一个'对象'被多个'引用'所指向
        Bullet a = new Bullet();
        Bullet b = new Bullet();
        a.caliber = 7.62F;
        b.caliber = 5.56F;
        System.out.println("A型子弹口径：" + a.caliber + "; B型子弹口径：" + b.caliber);

        a = b;
        System.out.println("A型子弹口径：" + a.caliber + "; B型子弹口径：" + b.caliber);

        b.caliber = 9.00F;
        System.out.println("A型子弹口径：" + a.caliber + "; B型子弹口径：" + b.caliber);

    }

    static class Bullet {
        float caliber;
    }
}
