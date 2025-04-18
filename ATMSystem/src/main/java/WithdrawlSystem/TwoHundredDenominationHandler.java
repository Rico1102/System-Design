package WithdrawlSystem;

import java.util.HashMap;
import java.util.Map;

public class TwoHundredDenominationHandler extends CashWithdrawlHandler{

    int denomination = 200;
    int count;


    public TwoHundredDenominationHandler(CashWithdrawlHandler nextHandler, int count) {
        super(nextHandler);
        this.count = count;
    }

    @Override
    public Map<String , Integer> handleRequest(int amount){
        Map<String , Integer> notes = new HashMap<String, Integer>() ;
        int notesNeeded = amount/denomination;
        if(notesNeeded > count) {
            amount = amount - count * denomination;
            notes.put("200", count);
            count = 0;
        } else {
            amount = amount - notesNeeded * denomination;
            notes.put("200", notesNeeded);
            count = count - notesNeeded;
        }
        if(amount == 0) {
            return notes;
        } else {
            Map<String, Integer> nextNotes = nextHandler.handleRequest(amount);
            if(nextNotes == null) {
                return null;
            } else {
                notes.putAll(nextNotes);
                return notes;
            }
        }
    }

}
