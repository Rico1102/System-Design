package Splitwise.balanceSheet;

import Splitwise.Split;
import Splitwise.User;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BalanceSheet {

    User user;
    Map<User, List<Split>> transactionMap ;
    Map<User, Balance> balanceMap ;

    public void addSplit(Split split){
        if(split.getPayer() == user){
            transactionMap.get(split.getPayee()).add(split) ;
        }
        else{
            transactionMap.get(split.getPayer()).add(split) ;
        }
    }

    public void deleteSplit(Split split){
        if(split.getPayer() == user){
            transactionMap.get(split.getPayee()).add(split) ;
        }
        else{
            transactionMap.get(split.getPayer()).add(split) ;
        }
    }

    public void updateSplit(Split split){
        if(split.getPayer() == user){
            transactionMap.get(split.getPayee()).add(split) ;
        }
        else{
            transactionMap.get(split.getPayer()).add(split) ;
        }
    }

}
