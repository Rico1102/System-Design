package Splitwise.currencyAdapter.conversionStrategy;

public class FixedRateConversionStrategy implements ConversionStrategy{
    @Override
    public double getConversionRate(String sourceCurrency, String targetCurrency) {
        //Fetch from a predefined conversion rates
        return 0;
    }
}
