package Splitwise;

import Splitwise.expense.ExpenseController;

import java.util.UUID;

public class SplitWiseController {

    //All calculations will happen in dollars (USD)

    GroupController groupController ;
    UserController userController ;
    ExpenseController expenseController ;

    public SplitWiseController(){
        this.groupController = new GroupController() ;
        this.userController = new UserController() ;
        this.expenseController = new ExpenseController() ;
    }

    public void addIndividualExpense(UUID payerId, UUID payeeId, String strategy, double amount, String description){
        this.expenseController.createIndividualExpense(this.userController.getUserById(payerId), this.userController.getUserById(payeeId), strategy, amount, description);
    }

}
