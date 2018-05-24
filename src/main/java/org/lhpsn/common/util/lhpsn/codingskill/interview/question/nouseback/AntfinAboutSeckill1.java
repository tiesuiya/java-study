//package org.lhpsn.common.util.lhpsn.codingskill.interview.question;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
///**
// * 蚂蚁金服面试题：商品秒杀
// *
// * @author lh
// * @since 1.0.0
// */
//public class AntfinAboutSeckill {
//
//    /**
//     * 感觉不符合题意，应该使用多线程的方式解题
//     */
//
//    public static final int N_USER_NUM = 1000;
//    public static final int M_GOODS_NUM = 10;
//    private static List<Goods> goodsList;
//    private static List<User> userList;
//
//    static {
//        goodsList = new ArrayList<>();
//        userList = new ArrayList<>();
//
//        for (int i = 0; i < M_GOODS_NUM; i++) {
//            goodsList.add(new Goods(String.valueOf(i + 1)));
//        }
//        for (int i = 0; i < N_USER_NUM; i++) {
//            userList.add(new User(String.valueOf(i + 1)));
//        }
//    }
//
//    public static void main(String[] args) {
//
//        SeckillService seckillService = new SeckillServiceImpl();
//
//        // 开始计时
//        long beginTime = System.currentTimeMillis();
//        System.out.println("----------------------------");
//        System.out.println("秒杀开始：");
//        System.out.println("本次秒杀商品数量为：" + M_GOODS_NUM);
//        System.out.println("本次秒杀用户数量为：" + N_USER_NUM);
//        System.out.println("----------------------------\n");
//
//        // 执行秒杀
//        List<Goods> completeGoodsList = seckillService.doSeckill(goodsList, userList);
//
//        System.out.println("\n----------------------------");
//        System.out.println("秒杀结束：");
//        System.out.println("本次秒杀商品，信息列表如下：");
//        for (Goods goods : completeGoodsList) {
//            System.out.println(goods);
//        }
//        System.out.println("本次秒杀总耗时（ms）：" + (System.currentTimeMillis() - beginTime));
//        System.out.println("----------------------------");
//    }
//}
//
//interface SeckillService {
//    List<Goods> doSeckill(List<Goods> goodsList, List<User> users);
//}
//
//class SeckillServiceImpl implements SeckillService {
//    @Override
//    public List<Goods> doSeckill(List<Goods> goodsList, List<User> userList) {
//
//        int killCount = 0;
//        List<String> buyerSuccessList = new ArrayList<>();
//        List<String> goodsSuccessList = new ArrayList<>();
//
//        System.out.println("秒杀过程：");
//        while (true) {
//            System.out.print("Round：" + ++killCount + "\t");
//            // 随机抽取用户购买
//            User user = userList.get(new Random().nextInt(AntfinAboutSeckill.N_USER_NUM));
//            if (buyerSuccessList.contains(user.getBuyerId())) {
//                System.out.println("用户（ID:" + user.getBuyerId() + "）已经购买过，拒绝重复购买！");
//                continue;
//            }
//
//            // 随机抽取用户购买
//            Goods goods = goodsList.get(new Random().nextInt(AntfinAboutSeckill.M_GOODS_NUM));
//            if (goodsSuccessList.contains(goods.getGoodsId())) {
//                System.out.println("商品（ID:" + goods.getGoodsId() + "）已被售出，拒绝用户（ID:" + user.getBuyerId() + "）购买！");
//                continue;
//            }
//            // 执行商品秒杀
//            goods.killCurrent(user);
//            System.out.println("用户（ID:" + user.getBuyerId() + "）购买商品（ID：" + goods.getGoodsId() + "）成功！");
//            // 更新成功秒杀信息
//            buyerSuccessList.add(user.getBuyerId());
//            goodsSuccessList.add(goods.getGoodsId());
//
//            if (buyerSuccessList.size() == AntfinAboutSeckill.N_USER_NUM) {
//                System.out.println("用户均已秒杀到商品，退出秒杀！");
//                break;
//            }
//            if (goodsSuccessList.size() == AntfinAboutSeckill.M_GOODS_NUM) {
//                System.out.println("商品售罄，退出秒杀！");
//                break;
//            }
//        }
//
//        return goodsList;
//    }
//}
//
//class Goods {
//
//    private String goodsId;
//    private String buyerId;
//
//    public Goods(String goodsId) {
//        this.goodsId = goodsId;
//    }
//
//    public String getGoodsId() {
//        return goodsId;
//    }
//
//    public void setGoodsId(String goodsId) {
//        this.goodsId = goodsId;
//    }
//
//    public String getBuyerId() {
//        return buyerId;
//    }
//
//    public void setBuyerId(String buyerId) {
//        this.buyerId = buyerId;
//    }
//
//    public String killCurrent(User user) {
//        String buyerId = user.getBuyerId();
//        this.buyerId = buyerId;
//        return buyerId;
//    }
//
//    @Override
//    public String toString() {
//        return "Goods{" +
//                "goodsId='" + goodsId + '\'' +
//                ", buyerId='" + buyerId + '\'' +
//                '}';
//    }
//}
//
//class User {
//
//    private String buyerId;
//
//    public User(String buyerId) {
//        this.buyerId = buyerId;
//    }
//
//    public String getBuyerId() {
//        return buyerId;
//    }
//
//    public void setBuyerId(String buyerId) {
//        this.buyerId = buyerId;
//    }
//}
