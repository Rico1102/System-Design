package Splitwise.currencyAdapter;

import Splitwise.currencyAdapter.conversionStrategy.ConversionStrategy;

public class AUDAdapter extends CurrencyAdapter{

    String sourceCurrency = "AUD" ;
    String targetCurrency = "USD" ;

    public AUDAdapter(ConversionStrategy strategy) {
        super(strategy);
    }

    @Override
    public double convert(double amount) {
        return amount * conversionRate(sourceCurrency, targetCurrency);
    }
}
