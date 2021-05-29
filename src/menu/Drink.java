package menu;

import pay.Payment;

abstract public class Drink extends Menu {
    @Override
    public abstract int order(Payment payment);
}
