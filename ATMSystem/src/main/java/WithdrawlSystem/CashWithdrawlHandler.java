package WithdrawlSystem;

import java.util.Map;

public class CashWithdrawlHandler {

    CashWithdrawlHandler nextHandler;

    public CashWithdrawlHandler(CashWithdrawlHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Map<String , Integer> handleRequest(int amount){
        if(nextHandler != null){
            return nextHandler.handleRequest(amount);
        }
        return null ;
    }

}
