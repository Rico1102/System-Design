package Splitwise.expense;

import Splitwise.Split;
import Splitwise.User;
import Splitwise.splitStrategy.SplitStrategy;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expense {

    private UUID id;
    private String description;
    private double amount;
    private List<Split> splits ;
    private SplitStrategy splitStrategy;

    private void markTheSplits(){
        for(Split split : this.splits){
            split.setExpenseUUID(this.id);
        }
    }
    public boolean validateExpense(){
        markTheSplits();
        return this.splitStrategy.validate(this.splits, this.amount) ;
    }

    public void updateUsers(){
        Set<User> users = new HashSet<>();
        users.add(splits.get(0).getPayer()) ;
        for(Split split : splits){
            users.add(split.getPayee()) ;
        }
        for(User user : users){
            user.getExpenses().add(this) ;
        }
    }

}
