import java.util.ArrayList;

/**
 * 
 * Class that organizes the Accounts and ATMs.
 * 
 * @author HunterLai
 *
 */
public class Bank
{
    private String id;
    private ArrayList<Account> accounts;
    private ArrayList<ATM> atms;
    
    /**
     * 
     * Constructor that sets the id
     * 
     * @param bankID
     */
    Bank(String bankID)
    {
        id = bankID;
        accounts = new ArrayList<Account>();
        atms = new ArrayList<ATM>();
    }
    
    /**
     * 
     * Adds new ATM to the ArrayList
     * 
     * postcondition: ATM is added to the ArrayList
     * 
     * @param newATM
     * 
     */
    public void addATM(ATM newATM)
    {
        atms.add(newATM);
    }
    
    /**
     * 
     * Adds account to the ArrayList.
     * 
     * postcondition: ArrayList has new account element
     * 
     * @param newAccount
     * 
     */
    public void addAccount(Account newAccount)
    {
        accounts.add(newAccount);
    }
    
    /**
     * 
     * finds the account based on a cardName. It searches all accounts in the bank
     * 
     * @param cardName
     * @return Account if found, null if not found
     */
    public Account findAccount(String cardName)
    {
        for(int i = 0; i < accounts.size(); i++)
            if(accounts.get(i).matchingCashCard(id, cardName))
                return accounts.get(i);
        return null;
    }
    
    /**
     * 
     * Finds ATM based on an ATMName. Searches through ATMs in the bank
     * 
     * @param atmName
     * @return ATM, unless not found then null
     */
    public ATM findATM(String atmName)
    {
        for(int i = 0; i < atms.size(); i++)
            if(atms.get(i).equals(atmName))
                    return atms.get(i);
        return null;
    }
    
    /**
     * 
     * Formats all accounts information to a string and outputs it
     * 
     * @return String of acount information
     */
    public String accountsToString()
    {
        String output = "Bank of " + id + " (" + accounts.size() + " customers)";
        for(int i = 0; i < accounts.size(); i++)
            output += "\n" + "Customer - Card Card with bankid: " + id + " and " + accounts.get(i).toString();
        return "\n" + output;
    }
    
    /**
     * 
     * Formats all ATM information to a string and returns it
     * 
     * @return String of ATM information
     */
    public String atmsToString()
    {
        String output = "";
        for(int i = 0; i < atms.size(); i++)
        {
            output += atms.get(i).toString() + "\n";
        }
        return output;
    }
    
    public String getID()
    {
        return id;
    }
}