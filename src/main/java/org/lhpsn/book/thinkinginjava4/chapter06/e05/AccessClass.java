package org.lhpsn.book.thinkinginjava4.chapter06.e05;

/**
 * @author tsy
 * @date 2019-04-11 16:39
 */
public class AccessClass {

    private String fieldPrivate = "fieldPrivate";

    protected String fieldProtectd = "fieldProtectd";

    public String fieldPublic = "fieldPublic";


    private String methodPrivate() {
        return "methodPrivate";
    }

    protected String fieldProtectd() {
        return "fieldProtectd";
    }

    public String fieldPublic() {
        return "fieldPublic";
    }
}
