package Splitwise.currencyAdapter;

import Splitwise.currencyAdapter.conversionStrategy.ConversionStrategy;

public class INRAdapter extends CurrencyAdapter{
    String sourceCurrency = "INR" ;
    String targetCurrency = "USD" ;

    public INRAdapter(ConversionStrategy strategy) {
        super(strategy);
    }

    @Override
    public double convert(double amount) {
        return amount * conversionRate(sourceCurrency, targetCurrency);
    }
}
