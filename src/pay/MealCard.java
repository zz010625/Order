package pay;

public class MealCard extends Payment{
    private String payMethod="饭卡";

    @Override
    public String print() {
        return payMethod;
    }
}
