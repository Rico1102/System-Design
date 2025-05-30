package Splitwise.currencyAdapter.conversionStrategy;

public class ApiBasedConversionStrategy implements ConversionStrategy{
    @Override
    public double getConversionRate(String sourceCurrency, String targetCurrency) {
        //hit an endpoint to find the conversion rate and return
        return 0;
    }
}
