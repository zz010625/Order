package canteen;

import menu.CanteenADrink;
import menu.CanteenAFood;
import menu.Menu;

public class CanteenA extends Canteen {
    @Override
    public Menu orderFood() {
        return new CanteenAFood();
    }

    @Override
    public Menu orderDrink() {
        return new CanteenADrink();
    }
}
