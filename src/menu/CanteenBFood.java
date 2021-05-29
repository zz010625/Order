package menu;

import pay.Payment;

public class CanteenBFood extends Food{
    @Override
    public int order(Payment payment) {
        discount();
        System.out.println("支付方式:"+payment.print()+" "+"食堂B食物盈利6-1=5元");
        return 6-discountNum;
    }
}
