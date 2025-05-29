package Splitwise.splitStrategy;

import Splitwise.Split;

import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{

    public boolean validate(List<Split> splits, double totalAmount) {
        double amount = -1 ;
        double currentTotalAmount = 0 ;
        for(Split split : splits){
            if(amount == -1) amount = split.getAmount() ;
            if(amount != split.getAmount()){
                return false ;
            }
            currentTotalAmount += split.getAmount();
        }
        return (totalAmount == currentTotalAmount) ;
    }

}
