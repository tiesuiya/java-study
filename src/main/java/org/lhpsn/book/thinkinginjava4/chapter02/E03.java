package org.lhpsn.book.thinkinginjava4.chapter02;

/**
 * @author tsy
 */
public class E03 {

    public static void main(String[] args) {
        // :)
        ATypeName aTypeName = new ATypeName();
        aTypeName.fild = "abc";
        System.out.println(aTypeName.fild);
    }

    static class ATypeName {
        String fild;
    }
}
