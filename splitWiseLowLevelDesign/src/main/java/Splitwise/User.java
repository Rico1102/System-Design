package Splitwise;

import Splitwise.balanceSheet.Balance;
import Splitwise.balanceSheet.BalanceSheet;
import Splitwise.balanceSheet.MoneyFlow;
import Splitwise.expense.Expense;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class User {

    UUID uuid;
    String name;
    String email;
    BalanceSheet balanceSheet;

    List<Expense> expenses;

    Balance balance;

    public User(UUID uuid, String name, String email) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.balanceSheet = new BalanceSheet();
        this.balance = new Balance(0, MoneyFlow.CREDIT);
        this.expenses = new ArrayList<>() ;
    }

}
