package canteen;

import menu.CanteenBDrink;
import menu.CanteenBFood;
import menu.Menu;

public class CanteenB extends Canteen{
    @Override
    public Menu orderFood() {
        return new CanteenBFood();
    }

    @Override
    public Menu orderDrink() {
        return new CanteenBDrink();
    }
}
