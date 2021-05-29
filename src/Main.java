import pay.Alipay;
import pay.MealCard;
import pay.WeChat;
import canteen.CanteenA;
import canteen.CanteenB;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        CopyOnWriteArrayList profitList = new CopyOnWriteArrayList();//存放每次订单的盈利
        CopyOnWriteArrayList orderNumList = new CopyOnWriteArrayList();//存放订单的个数
        CanteenA canteenA = new CanteenA();
        CanteenB canteenB = new CanteenB();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        /**
         * 假设12点到1点期间
         * 食堂A共有 100个Food订单 50个Drink订单
         * 食堂B共有 80个Food订单 60个Drink订单
         */
        for (int i = 0; i < 100; i++) {
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    profitList.add(canteenA.orderFood().order(new Alipay()));
                    orderNumList.add(1);
                    printProfit(orderNumList, profitList);
                }
            });
        }
        for (int i = 0; i < 50; i++) {
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    profitList.add(canteenA.orderDrink().order(new MealCard()));
                    orderNumList.add(1);
                    printProfit(orderNumList, profitList);
                }
            });
        }
        for (int i = 0; i < 80; i++) {
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    profitList.add(canteenB.orderFood().order(new WeChat()));
                    orderNumList.add(1);
                    printProfit(orderNumList, profitList);
                }
            });
        }
        for (int i = 0; i < 60; i++) {
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    profitList.add(canteenB.orderDrink().order(new Alipay()));
                    orderNumList.add(1);
                    printProfit(orderNumList, profitList);
                }
            });
        }
    }

    /**
     * 通过对orderNumList的size大小进行判断来实现所有订单处理完后的回调
     * @param orderNumList
     * @param profitList
     */
    private static void printProfit(CopyOnWriteArrayList orderNumList, CopyOnWriteArrayList profitList) {
        if (orderNumList.size() == 100 + 80 + 60 + 50) {
            int profit = 0;//总盈利
            for (int i = 0; i < profitList.size(); i++) {
                profit += (int) profitList.get(i);
            }
            System.out.println("此时所有食堂总盈利:" + profit + "元" + "  订单数:" + profitList.size());
        }
    }
}

