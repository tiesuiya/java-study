package org.lhpsn.base.designpattern;

/**
 * 简单工厂模式
 *
 * @author lh
 * @since 1.0.0
 */
public class SimpleFactoryPattern {
    public static void main(String[] args) {
        Calc calc = CalcFactory.createCalc("/");
        calc.setValueA(1);
        calc.setValueB(10);
        System.out.println(calc.getResult());
    }
}

/**
 * 简单工厂类
 */
class CalcFactory {
    public static Calc createCalc(String operate) {
        Calc calc = null;
        switch (operate) {
            case "+":
                calc = new CalcAdd();
                break;
            case "-":
                calc = new CalcSub();
                break;
            case "*":
                calc = new CalcMul();
                break;
            case "/":
                calc = new CalcDiv();
                break;
        }
        return calc;
    }
}

/**
 * 计算类
 */
class Calc {

    private double valueA;
    private double valueB;

    public double getResult() {
        double valueDefault = 0;
        return valueDefault;
    }

    public double getValueA() {
        return valueA;
    }

    public void setValueA(double valueA) {
        this.valueA = valueA;
    }

    public double getValueB() {
        return valueB;
    }

    public void setValueB(double valueB) {
        this.valueB = valueB;
    }

}

/**
 * 计算类实现1
 */
class CalcAdd extends Calc {
    @Override
    public double getResult() {
        return getValueA() + getValueB();
    }
}

/**
 * 计算类实现2
 */
class CalcSub extends Calc {
    @Override
    public double getResult() {
        return getValueA() - getValueB();
    }
}

/**
 * 计算类实现3
 */
class CalcMul extends Calc {
    @Override
    public double getResult() {
        return getValueA() * getValueB();
    }
}

/**
 * 计算类实现4
 */
class CalcDiv extends Calc {
    @Override
    public double getResult() {
        if (getValueB() == 0) {
            throw new IllegalArgumentException("除数不能为零！");
        }
        return getValueA() / getValueB();
    }
}
