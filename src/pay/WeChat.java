package pay;

public class WeChat extends Payment{
    private String payMethod="微信";

    @Override
    public String print() {
        return payMethod;
    }
}
