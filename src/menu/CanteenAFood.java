package menu;

import pay.Payment;

public class CanteenAFood extends Food {
    @Override
    public int order(Payment payment) {
        discount();
        System.out.println("支付方式:"+payment.print()+" "+"食堂A食物盈利5-1=4元");
        return 5-discountNum;
    }
}
