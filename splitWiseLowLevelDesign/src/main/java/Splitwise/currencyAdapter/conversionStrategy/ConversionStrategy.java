package Splitwise.currencyAdapter.conversionStrategy;

public interface ConversionStrategy {

    public double getConversionRate(String sourceCurrency, String targetCurrency) ;

}
