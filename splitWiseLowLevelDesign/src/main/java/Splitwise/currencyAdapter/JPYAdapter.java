package Splitwise.currencyAdapter;

import Splitwise.currencyAdapter.conversionStrategy.ConversionStrategy;

public class JPYAdapter extends CurrencyAdapter{
    String sourceCurrency = "JPY" ;
    String targetCurrency = "USD" ;

    public JPYAdapter(ConversionStrategy strategy) {
        super(strategy);
    }

    @Override
    public double convert(double amount) {
        return amount * conversionRate(sourceCurrency, targetCurrency);
    }
}
