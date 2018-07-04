package org.lhpsn.base.designpattern;

/**
 * 策略模式
 *
 * @author lh
 * @since 1.0.0
 */
public class StrategyPattern {
    public static void main(String[] args) {
        SaleContext saleContext;

        saleContext = new SaleContext(500, "打8折");
        System.out.println(saleContext.getResult());

        saleContext = new SaleContext(500, "满200减100");
        System.out.println(saleContext.getResult());
    }
}

/**
 * 策略、工厂模式结合
 */
class SaleContext {

    private CashSuper cashSuper = null;

    public SaleContext(double money, String type) {
        switch (type) {
            case "满200减100":
                cashSuper = new CashReturn(200, 100);
                break;
            case "打8折":
                cashSuper = new CashRebate(0.8);
                break;
            default:
                cashSuper = new CashNormal();
                break;
        }
        cashSuper.setTotal(money);
    }

    public double getResult() {
        return cashSuper.getResult();
    }
}

/**
 * 结算策略父类
 */
abstract class CashSuper {
    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    abstract double getResult();
}

/**
 * 结算默认策略
 */
class CashNormal extends CashSuper {

    @Override
    double getResult() {
        return getTotal();
    }
}

/**
 * 结算折扣策略
 */
class CashRebate extends CashSuper {

    private double rebate;

    public CashRebate(double rebate) {
        this.rebate = rebate;
    }

    @Override
    double getResult() {
        return getTotal() * rebate;
    }
}

/**
 * 结算满减策略
 */
class CashReturn extends CashSuper {
    private double full;
    private double sub;

    public CashReturn(double full, double sub) {
        if (sub > full) {
            throw new IllegalArgumentException("超出满减值！");
        }
        this.full = full;
        this.sub = sub;
    }

    @Override
    double getResult() {
        double result = 0;
        if (getTotal() >= full) {
            result = getTotal() - sub;
        }
        return result;
    }
}

