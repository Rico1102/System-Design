package Splitwise.splitStrategy;

import Splitwise.Split;

import java.util.List;

public class UnequalSplitStrategy implements SplitStrategy{

    public boolean validate(List<Split> splits, double totalAmount) {
        double currentTotalAmount = 0 ;
        for(Split split : splits){
            currentTotalAmount += split.getAmount();
        }
        return (totalAmount == currentTotalAmount) ;
    }

}
