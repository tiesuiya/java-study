package org.lhpsn.book.thinkinginjava4.chapter02;

/**
 * @author tsy
 */
public class E11 {

    public static void main(String[] args) {
        // 展示方法和属性的赋值
        AllTheColorsOfTheRainbow allTheColorsOfTheRainbow = new AllTheColorsOfTheRainbow();
        allTheColorsOfTheRainbow.anIntegerRepresentingColors = 100;
        allTheColorsOfTheRainbow.changeTheHueOfTheColor(200);
        System.out.println(allTheColorsOfTheRainbow.anIntegerRepresentingColors);
    }

    static class AllTheColorsOfTheRainbow {
        int anIntegerRepresentingColors;

        void changeTheHueOfTheColor(int newHue) {
            anIntegerRepresentingColors = newHue;
        }
    }
}
