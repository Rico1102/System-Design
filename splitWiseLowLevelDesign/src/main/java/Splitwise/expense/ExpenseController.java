package Splitwise.expense;

import Splitwise.Split;
import Splitwise.User;
import Splitwise.splitStrategy.EqualSplitStrategy;
import Splitwise.splitStrategy.SplitStrategy;
import Splitwise.splitStrategy.SplitType;
import Splitwise.splitStrategy.UnequalSplitStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseController {

    List<Expense> expenses ;

    private SplitStrategy getStrategy(SplitType splitType){
        SplitStrategy strategy = null ;
        if(splitType == SplitType.EQUAL_SPLIT){
            strategy = new EqualSplitStrategy() ;
        }
        else if(splitType == SplitType.UNEQUAL_AMOUNT_SPLIT){
            strategy = new UnequalSplitStrategy() ;
        }
        return strategy;
    }

    public void createExpense(String description, List<Split> splits, double amount, User payer, SplitType splitType){

        Expense expense = Expense.builder().id(UUID.randomUUID()).description(description).splits(splits).splitStrategy(getStrategy(splitType)).build() ;
        if(!expense.validateExpense()) {
            throw new RuntimeException("Invalid split provided!!!");
        }
        expense.updateUsers();
        System.out.println("Expense Added!!!");
    }

    public void updateExpense(final UUID uuid, String description, List<Split> splits, double amount, User payer, SplitType splitType){
        Optional<Expense> expense = this.expenses.stream().filter((exp) -> exp.getId() == uuid).findFirst() ;
        if(expense.isEmpty()){
            throw new RuntimeException("Invalid expense id!!!") ;
        }
        expense.get().setAmount(amount);
        expense.get().setDescription(description);
        expense.get().setSplits(splits);
        expense.get().setSplitStrategy(getStrategy(splitType));
        if(!expense.get().validateExpense()){
            throw new RuntimeException("Invalid split provided!!!");
        }
        System.out.println("Expense updated!!!");
    }

}
