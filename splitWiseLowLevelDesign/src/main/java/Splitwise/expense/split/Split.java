package Splitwise.expense.split;

import Splitwise.User;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Split {

    UUID expenseId ;
    User paidBy ;
    User paidFor ;
    double amount ;

}
