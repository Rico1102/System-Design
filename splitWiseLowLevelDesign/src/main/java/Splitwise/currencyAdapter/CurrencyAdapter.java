package Splitwise.currencyAdapter;

import Splitwise.currencyAdapter.conversionStrategy.ConversionStrategy;

public abstract class CurrencyAdapter {

    ConversionStrategy conversionStrategy ;

    public CurrencyAdapter(ConversionStrategy strategy){
        this.conversionStrategy = strategy ;
    }

    double conversionRate(String sourceCurrency, String targetCurrency){
        double rate = this.conversionStrategy.getConversionRate(sourceCurrency, targetCurrency) ;
        return rate ;
    }

    abstract public double convert(double amount) ;

}
