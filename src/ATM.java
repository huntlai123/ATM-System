/**
 * 
 * Handles ATM functions and checks to make sure that all withdraws are within range
 * of the ATM
 * 
 * @author HunterLai
 *
 */
public class ATM
{
    private final static double DEFAULT_MAXIMUM_WITHDRAWL = 50;
    private final static double MINIMUM_WITHDRAWL = 0;
    private String name;
    private Bank bank;
    private double maxWithdrawl;
    
    /**
     * 
     * ATM constructor and sets all values in the the ATM object.
     * 
     * @param newName
     * @param newBank
     * @param newMaxWithdrawl
     */
    ATM(String newName, Bank newBank, double newMaxWithdrawl)
    {
        name = newName;
        bank = newBank;
        if(newMaxWithdrawl > MINIMUM_WITHDRAWL)
            maxWithdrawl = newMaxWithdrawl;
        else
            maxWithdrawl = DEFAULT_MAXIMUM_WITHDRAWL;
    }
    
    /**
     * 
     * Checks to see if the ATM's name is the same as the proposed name
     * 
     * @param name
     * @return true is the names are the same, false if not
     */
    public boolean equals(String name)
    {return this.name.equals(name);}
    
    /**
     * 
     * Retrieves the bank
     * 
     * @return bank
     */
    public Bank getBank()
    {
        return bank;
    }
    
    /**
     * 
     * Retrieves the max amount someone can withdraw from the ATM in one day
     * 
     * @return maxWithdrawl
     */
    public double getMaxWithdrawl()
    {
        return maxWithdrawl;
    }
       
    /**
     * 
     * Checks to see if the proposed amount to withdraw is within the minimum and max
     * 
     * @param withdrawlAmount
     * @param amountWithdrawnAlready
     * @return true or false, depending on if it is in range or not
     */
    public boolean isInRange(double withdrawlAmount)
    {
        if((withdrawlAmount <= maxWithdrawl) & (withdrawlAmount > MINIMUM_WITHDRAWL))
            return true;
        return false;
    }
    
    /**
     * 
     * Puts ATM object into a string and formats it properly
     * 
     * @return String, ATM information in form of string
     * 
     */
    public String toString()
    {
        return name + " (from Bank of " + bank.getID() + ")\n\t"
                + "The maximum amount of cash a card can withdraw per transaction: $" + maxWithdrawl;
    }
}
