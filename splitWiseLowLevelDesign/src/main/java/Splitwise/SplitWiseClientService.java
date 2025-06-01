package Splitwise;

import Splitwise.currencyAdapter.CurrencyAdapter;
import Splitwise.currencyAdapter.CurrencyAdapterFactory;

import java.util.UUID;

public class SplitWiseClientService {

    SplitWiseController splitWiseController = new SplitWiseController() ;

    public void addIndividualExpense(UUID payerId, UUID payeeId, String strategy, double amount, String description, String currency){
        CurrencyAdapter currencyAdapter = CurrencyAdapterFactory.getCurrencyAdapter(currency) ;
        splitWiseController.addIndividualExpense(payerId, payeeId, strategy, currencyAdapter.convert(amount), description);
    }

}
