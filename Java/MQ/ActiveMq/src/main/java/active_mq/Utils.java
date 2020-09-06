package active_mq;

import active_mq.model.BalanceRequest;

public class Utils {

    public static BalanceRequest generateTestBalanceRequest() {
        BalanceRequest balanceRequest = new BalanceRequest();
        balanceRequest.setAccountNumber("543987");
        balanceRequest.setMode("00");
        balanceRequest.setPriority("1000");
        return balanceRequest;
    }

}
