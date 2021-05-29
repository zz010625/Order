package menu;

import pay.Payment;

abstract public class Food extends Menu {
    @Override
    public abstract int order(Payment payment);
}
