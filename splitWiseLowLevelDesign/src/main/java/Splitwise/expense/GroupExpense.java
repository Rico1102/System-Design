package Splitwise.expense;

import Splitwise.User;
import Splitwise.expense.split.Split;

import java.util.List;

public class GroupExpense extends Expense{

    List<User> userList ;
    List<Split> splits ;

    Boolean isGroup ;

    public GroupExpense(String description, User payer, double amount, String strategy, List<User> userList) {
        super(description, payer, amount, strategy);
        this.userList = userList;
        this.isGroup = true ;
    }

    @Override
    public void validateAndGenerateSplit(){
        strategy.validateSplit(this) ;
        this.splits = strategy.splitExpense(this) ;
    }

    @Override
    public void updateBalanceSheet() {
        //update payer balance sheet
        //update all the payee balance sheet by iterating over the userList
    }

    @Override
    public void printUserShare(User user) {

    }
}
