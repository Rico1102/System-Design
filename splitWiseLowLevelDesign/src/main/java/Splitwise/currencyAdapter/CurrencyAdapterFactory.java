package Splitwise.currencyAdapter;

import Splitwise.currencyAdapter.conversionStrategy.ApiBasedConversionStrategy;
import Splitwise.currencyAdapter.conversionStrategy.FixedRateConversionStrategy;

public class CurrencyAdapterFactory {

    public static CurrencyAdapter getCurrencyAdapter(String currency){
        switch (currency){
            case "INR":
                return new INRAdapter(new ApiBasedConversionStrategy()) ;
            case "JPY":
                return new JPYAdapter(new FixedRateConversionStrategy()) ;
            case "AUD":
                return new AUDAdapter(new FixedRateConversionStrategy()) ;
            default:
                throw new RuntimeException("Invalid Currency!!!") ;
        }
    }

}
