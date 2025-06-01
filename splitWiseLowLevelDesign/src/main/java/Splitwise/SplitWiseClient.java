package Splitwise;

import Splitwise.currencyAdapter.CurrencyAdapter;
import Splitwise.currencyAdapter.CurrencyAdapterFactory;

import java.util.UUID;

public class SplitWiseClient {

    SplitWiseClientService splitWiseClientService = new SplitWiseClientService() ;

    public void addIndividualExpense(UUID payerId, UUID payeeId, String strategy, double amount, String description, String currency){
        this.splitWiseClientService.addIndividualExpense(payerId, payeeId, strategy, amount, description, currency);
    }

}
