/**
 * 
 * This class holds onto the Account of each customer in the bank, and handles methods
 * related
 *
 * @author HunterLai
 *
 */
public class Account
{
    private int accountNumber;
    private double balance;
    private CashCard cashCard;
    private String password;
    
    /**
     * 
     * Constructor that sets up an Account object
     * 
     * @param newPassword
     * @param newCashCard
     * @param newBalance
     * @param newAccountNumber
     */
    Account(String newPassword, CashCard newCashCard, double newBalance, int newAccountNumber)
    {
        password = newPassword;
        cashCard = newCashCard;
        balance = newBalance;
        accountNumber = newAccountNumber;
    }
    
    /**
     * 
     * Checks to see if the password for an Account matches the password passed
     * in
     * 
     * @param enteredPassword
     * @return true or false, if the password is the same or not
     */
    public boolean correctPassword(String enteredPassword)
    {
        return password.equals(enteredPassword);
    }
    
    /**
     * 
     * Withdraws the money requested from the balance and returns the new balance
     * 
     * precondition: amount is nonnegative and is not greater than the balance
     * @param amount
     * @return balance after money has been taken out
     */
    public double withdraw(double amount)
    {
        if(amount >= 0 && balance >= amount)
        {
            balance = balance - amount;
            return balance;
        }
        return -1;
    }
    
    /**
     * 
     * Checks to see if the CashCard passed in is the same as the proposed CashCard
     * 
     * @param bankID
     * @param proposedCardName
     * @return true if they are the same, false if not
     */
    public boolean matchingCashCard(String bankID, String proposedCardName)
    {
        if(proposedCardName.equals(bankID + " " + accountNumber) || 
                proposedCardName.equals(bankID + accountNumber))
            return true;
        return false;
    }
    
    /**
     * 
     * Checks if the CashCard is valid, by calling the CashCard method isValid()
     * 
     * @return true or false
     */
    public boolean cashCardValid()
    {
        return cashCard.isValid();
    }
    
    /**
     * 
     * Puts all the account information into a String
     * 
     * @return String with all account information properly formatted.
     * 
     */
    public String toString()
    {
        String output = "account number #: " + 
                accountNumber + ", expires on " + cashCard.expirationDateToString() + ", password: " 
                + password + ", balance: " + balance;
        
        return output;
    }
}
