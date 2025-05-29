package Splitwise.splitStrategy;

import Splitwise.Split;

import java.util.List;

public interface SplitStrategy {

    public boolean validate(List<Split> splits, double totalAmount) ;

}
