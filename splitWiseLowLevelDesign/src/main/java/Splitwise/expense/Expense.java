package Splitwise.expense;

import Splitwise.User;
import Splitwise.expense.split.EqualSplit;
import Splitwise.expense.split.PercentageSplit;
import Splitwise.expense.split.Split;
import Splitwise.expense.split.SplitStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public abstract class Expense {

    UUID uuid ;
    String description ;
    User paidBy ;
    double amount ;
    SplitStrategy strategy ;

    public Expense(String description, User payer, double amount, String strategy){
        this.description = description ;
        this.paidBy = payer;
        this.amount = amount;
        this.strategy = getStrategy(strategy) ;
    }

    private SplitStrategy getStrategy(String strategy){
        switch (strategy){
            case "EQUAL":
                return new EqualSplit() ;
            case "PERCENTAGE":
                return new PercentageSplit();
            default:
                throw new RuntimeException("Invalid Split!!!") ;
        }
    }

    abstract public void validateAndGenerateSplit() ;

    abstract public void updateBalanceSheet() ;

    abstract public void printUserShare(User user) ;

}
