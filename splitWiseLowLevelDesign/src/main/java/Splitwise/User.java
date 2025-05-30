package Splitwise;

import Splitwise.balanceSheet.BalanceSheet;
import Splitwise.balanceSheet.IndividualBalanceSheet;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {

    UUID uuid;
    String name;
    String phoneNo;
    String emailId;
    BalanceSheet balanceSheet;

    public User(String name, String phoneNo, String emailId){
        this.uuid = UUID.randomUUID() ;
        this.name = name ;
        this.phoneNo = phoneNo ;
        this.emailId = emailId ;
        this.balanceSheet = new IndividualBalanceSheet() ;
    }

}
