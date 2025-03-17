package Core;

public class Card {

    int cvv;
    String cardNumber;
    String expiryDate;
    Account account;
    int pin = 1234;

    public Card(int cvv, String cardNumber, String expiryDate, Account account) {
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.account = account;
    }

    public int getBalance() {
        return account.getBalance();
    }

    public void setBalance(int balance) {
        account.setBalance(balance);
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
