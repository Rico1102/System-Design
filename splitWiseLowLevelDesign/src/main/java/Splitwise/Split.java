package Splitwise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Split {

    UUID splitUUID;
    UUID expenseUUID;
    User payer;
    User payee;
    double amount;

    public void addTransaction(){
        payer.balanceSheet.addSplit(this);
        payee.balanceSheet.addSplit(this);
    }

    public void updateTransaction(){
        payer.balanceSheet.updateSplit(this);
        payee.balanceSheet.updateSplit(this);
    }

}
