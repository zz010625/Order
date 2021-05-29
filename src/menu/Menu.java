package menu;

import pay.Payment;

abstract public class Menu implements Promotion {
     public int discountNum=0;
     public abstract int order(Payment payment);

     @Override
     public void discount() {
          discountNum=1;//食堂活动 所有商品价格减1
     }
}
