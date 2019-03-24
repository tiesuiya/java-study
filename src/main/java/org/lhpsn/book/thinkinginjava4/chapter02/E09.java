package org.lhpsn.book.thinkinginjava4.chapter02;

/**
 * @author tsy
 */
public class E09 {

    public static void main(String[] args) {
        // 展示自动包装功能对所有基本类型和包装类型都起作用
        Boolean bl = true;
        Character character = 'c';
        Byte by = 1;
        Short st = 1;
        Integer integer = 1;
        Long lo = 1L;
        Float fl = 1f;
        Double db = 1d;

        boolean _bl = bl;
        char _character = character;
        byte _by = by;
        short _st = st;
        int _integer = integer;
        long _lo = lo;
        float _fl = fl;
        double _db = db;

        System.out.println(_bl);
        System.out.println(_character);
        System.out.println(_by);
        System.out.println(_st);
        System.out.println(_integer);
        System.out.println(_lo);
        System.out.println(_fl);
        System.out.println(_db);
    }
}
