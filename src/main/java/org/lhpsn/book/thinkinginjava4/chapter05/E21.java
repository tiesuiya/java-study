package org.lhpsn.book.thinkinginjava4.chapter05;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author tsy
 * @date 2019-04-10 12:02
 */
public enum E21 {

    DENOMINATION_1(new BigDecimal("0.1")),
    DENOMINATION_2(new BigDecimal("0.5")),
    DENOMINATION_3(new BigDecimal("1")),
    DENOMINATION_4(new BigDecimal("5")),
    DENOMINATION_5(new BigDecimal("10")),
    DENOMINATION_6(new BigDecimal("20")),
    ;

    private BigDecimal denominationValue;

    E21(BigDecimal denominationValue) {
        this.denominationValue = denominationValue;
    }

    public BigDecimal getDenominationValue() {
        return denominationValue;
    }

    // 打印枚举的序列和值
    public static void main(String[] args) {
        Arrays.stream(E21.values()).forEach(e -> System.out.println(e.ordinal() + "：" + e.getDenominationValue()));
    }
}
