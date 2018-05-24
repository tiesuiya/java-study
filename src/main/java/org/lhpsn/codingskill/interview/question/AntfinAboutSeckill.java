package org.lhpsn.codingskill.interview.question;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.*;
import java.util.concurrent.*;

/**
 * 蚂蚁金服面试题:商品秒杀
 *
 * @author lh
 * @since 1.0.0
 */
public class AntfinAboutSeckill {

    /**
     * 商品数量
     */
    private static final int M_GOODS_NUM = 5;

    /**
     * 买家数量
     */
    private static final int N_USER_NUM = 1000;

    /**
     * 参加秒杀的商品集合
     */
    private static List<Goods> goodsList;

    /**
     * 参加秒杀的买家集合
     */
    private static List<User> userList;

    // 初始化数据
    static {
        goodsList = new ArrayList<>(M_GOODS_NUM);
        userList = new ArrayList<>(N_USER_NUM);
        for (int i = 0; i < M_GOODS_NUM; i++) {
            goodsList.add(new Goods(String.valueOf(i + 1)));
        }
        for (int i = 0; i < N_USER_NUM; i++) {
            userList.add(new User(String.valueOf(i + 1)));
        }
    }

    public static void main(String[] args) throws InterruptedException {

        SeckillService seckillService = new SeckillServiceImpl();

        long beginTime = System.currentTimeMillis();
        System.out.println(String.format("秒杀开始，商品数量%d，买家数量%d\n", M_GOODS_NUM, N_USER_NUM));

        // 执行秒杀
        List<Goods> completeGoodsList = seckillService.doSeckill(goodsList, userList);

        System.out.println(String.format("\n秒杀结束，总耗时%d（ms），商品秒杀信息如下:", (System.currentTimeMillis() - beginTime)));
        for (Goods goods : completeGoodsList) {
            System.out.println(goods);
        }
    }
}

/**
 * 秒杀接口
 */
interface SeckillService {

    /**
     * 秒杀业务方法
     *
     * @param goodsList 待秒杀商品集合
     * @param users     参加秒杀买家集合
     * @return 买家信息更新后的商品集合
     */
    List<Goods> doSeckill(List<Goods> goodsList, List<User> users);
}

/**
 * 秒杀实现
 */
class SeckillServiceImpl implements SeckillService {

    /**
     * 参加秒杀的商品集合
     */
    private List<Goods> currentGoodsList;

    /**
     * 参加秒杀的买家集合
     */
    private List<User> currentUserList;

    /**
     * 秒杀运行标识
     */
    private boolean running;

    /**
     * 秒杀执行器线程池
     */
    private ExecutorService seckillActuatorPool;

    /**
     * 秒杀任务线程池
     */
    private ExecutorService seckillTaskPool;

    @Override
    public List<Goods> doSeckill(List<Goods> goodsList, List<User> userList) {

        this.currentGoodsList = goodsList;
        this.currentUserList = userList;
        this.running = true;

        seckillTaskPool = new ThreadPoolExecutor(100, 200, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                new ThreadFactoryBuilder().build(),
                new ThreadPoolExecutor.AbortPolicy());

        seckillActuatorPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                new ThreadFactoryBuilder().build(),
                new ThreadPoolExecutor.AbortPolicy());

        // 启动秒杀执行器
        seckillActuatorPool.submit(new SeckillActuator());

        // 在主线程中检查
        while (true) {
            int successGoodsCount = 0;
            int successUserCount = 0;
            for (Goods goods : currentGoodsList) {
                if (goods.getBuyerId() != null) {
                    successGoodsCount++;
                    successUserCount++;
                }
            }

            if (successGoodsCount == goodsList.size()) {
                System.out.println("商品售罄，退出秒杀！");
                destroySeckill();
                break;
            }
            if (successUserCount == userList.size()) {
                System.out.println("买家均已秒杀到商品，退出秒杀！");
                destroySeckill();
                break;
            }
        }
        return goodsList;

    }

    /**
     * 销毁秒杀
     */
    private void destroySeckill() {
        running = false;
        seckillTaskPool.shutdown();
        seckillActuatorPool.shutdown();
    }

    /**
     * 秒杀执行器
     */
    private class SeckillActuator implements Runnable {

        @Override
        public void run() {
            while (running) {
                // 随机抽取商品
                User user = currentUserList.get(new Random().nextInt(currentUserList.size()));
                // 随机抽取买家
                Goods goods = currentGoodsList.get(new Random().nextInt(currentGoodsList.size()));
                // 执行商品秒杀
                if (!seckillTaskPool.isShutdown()) {
                    seckillTaskPool.submit(new SeckillTask(goods, user));
                }
            }
        }
    }

    /**
     * 秒杀任务
     */
    private class SeckillTask implements Runnable {

        /**
         * 本次秒杀的商品
         */
        private final Goods goods;

        /**
         * 本次秒杀的用户
         */
        private User user;

        SeckillTask(Goods goods, User user) {
            this.goods = goods;
            this.user = user;
        }

        @Override
        public void run() {
            // 锁住商品，防止多个用户同时购买成功的情况
            synchronized (goods) {
                // 检查买家是否已购买过（可优化:这里可以使用缓存来保存成功购买的用户，进而减少遍历，降低资源和时间消耗）
                for (Goods goods : currentGoodsList) {
                    if (user.getBuyerId().equals(goods.getBuyerId())) {
                        System.out.println("Failed！买家（ID:" + user.getBuyerId() + "）已经购买过，不能重复购买！");
                        return;
                    }
                }

                // 检查商品是否被购买
                if (goods.getBuyerId() == null) {
                    goods.setBuyerId(user.getBuyerId());
                    System.out.println("Success！商品（ID:" + goods.getGoodsId() + "），买家（ID:" + user.getBuyerId() + "）");
                } else {
                    System.out.println("Failed！商品（ID:" + goods.getGoodsId() + "），买家（ID:" + user.getBuyerId() + "），商品已被秒杀！");
                }
            }
        }
    }
}

/**
 * 商品实体
 */
class Goods {

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 用户id
     */
    private String buyerId;

    public Goods(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId='" + goodsId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                '}';
    }
}

/**
 * 用户实体
 */
class User {

    /**
     * 用户id
     */
    private String buyerId;

    public User(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
}