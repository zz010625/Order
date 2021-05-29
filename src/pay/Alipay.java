package pay;

public class Alipay extends Payment{
    private String payMethod="支付宝";
    @Override
    public String print() {
        return payMethod;
    }
}
