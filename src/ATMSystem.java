import java.util.Scanner;
import java.util.GregorianCalendar;

/**
 * 
 * This is the class that interacts with the user and organizes all of the classes
 * related
 * 
 * @author HunterLai
 *
 */
public class ATMSystem
{
    private final static double PRELOADED_BALANCE = 40;
    private static Bank[] banks;
    
    /**
     * 
     * Main that executes the methods that interact with the user and call all the other
     * classes
     * 
     * @param args
     */
    public static void main(String[] args) 
    {
        initialize();
        printInfo();
        Scanner scanner = new Scanner(System.in);
        ATM atm = retrieveATM(scanner);
        Account account = retrieveAccount(atm, scanner);
        passwordAuthentication(account, scanner);
        withdrawlAmount(atm, account, scanner);
        scanner.close();
    }
    
    /**
     * 
     * Initializes all the banks, ATMs, accounts, cashcards, etc.
     * 
     * 
     * postcondition: Banks, Accounts, ATMs, and CashCards all have data
     */
    public static void initialize()
    {
        Bank bankA = new Bank("A");
        bankA.addAccount(new Account("passwordA", new CashCard(new GregorianCalendar(2018, 11, 12)), PRELOADED_BALANCE, 100));
        bankA.addAccount(new Account("passwordB", new CashCard(new GregorianCalendar(2018, 11, 13)), PRELOADED_BALANCE, 101));
        bankA.addAccount(new Account("passwordC", new CashCard(new GregorianCalendar(2015, 11, 14)), PRELOADED_BALANCE, 102));

        Bank bankB = new Bank("B");
        bankB.addAccount(new Account("passwordD", new CashCard(new GregorianCalendar(2017, 11, 15)), PRELOADED_BALANCE, 103));
        bankB.addAccount(new Account("passwordE", new CashCard(new GregorianCalendar(2018, 1, 16)), PRELOADED_BALANCE, 104));
        
        banks = new Bank[] {bankA, bankB};
        
        bankA.addATM(new ATM("ATM_A1", bankA, 32));
        bankA.addATM(new ATM("ATM_A2", bankA, 50));
        bankB.addATM(new ATM("ATM_B1", bankB, 60));
        bankB.addATM(new ATM("ATM_B2", bankB, 1000));
    }
    
    /**
     * 
     * Prints information held by the banks, accounts, ATMs, and cashcards
     * 
     * precondition: information is in these objects
     * 
     */
    public static void printInfo()
    {
        System.out.print("States of two Banks\n");
        System.out.println("Assume all accounts have $" + PRELOADED_BALANCE + " preloaded.");
        
        for(int i = 0; i < banks.length; i++)
            System.out.println(banks[i].accountsToString());
        
        System.out.println("\nSates of all ATMs (2 for each bank)");
        for(int i = 0; i < banks.length; i++)
        {
            System.out.println(banks[i].atmsToString());
        }
        
        System.out.println("--------------------------------------------------"
                + "---------------------------");
    }
    
    /**
     * 
     * Checks to see if a ATM by the name the user inputed exists.
     * 
     * @param scanner
     * @return ATM found
     */
    private static ATM retrieveATM(Scanner scanner)
    {
        System.out.println("Enter your choice of ATM.");
        ATM atm = null;
        while(atm == null)
        {
            String atmName = scanner.nextLine();
            atm = findATM(atmName);
            if(atm == null)
                System.out.println(("Sorry not a valid ATM, please enter another."));
        }
        return atm;
    }
    
    /**
     * 
     * finds an ATM based on the string name, and returns that ATM
     * 
     * @param atmName
     * @return ATM that was found
     */
    public static ATM findATM(String atmName)
    {
        for(int i = 0; i < banks.length; i++)
        {
            ATM atm = banks[i].findATM(atmName);
            if(atm != null)
                return atm;
        }
        return null;
    }
    
    /**
     * 
     * Retrieves account from the CashCard name given from the user. If one is not found
     * or it is invalid, it prompts the user for another
     * 
     * @param atm
     * @param scanner
     * @return
     */
    private static Account retrieveAccount(ATM atm, Scanner scanner)
    {
        Account account = null;
        while(account == null)
        {
            System.out.println("Enter your card");
            String cardName = scanner.nextLine();
            account = atm.getBank().findAccount(cardName);
            if(account == null)
            {
                System.out.println("This card is not supported by this ATM.");
            }
            else
                if(!account.cashCardValid())
                {
                    System.out.println("This card is expired and returned to you.");
                    account = null;
                }
        }
        System.out.println("This card is accepted. Please enter your password.");
        return account;
    }
    
    /**
     * 
     * Gets user input for password and makes sure the password entered is the 
     * correct password for the account. Then grants access to the account and 
     * allows user to withdraw
     * 
     * @param account
     * @param scanner
     */
    private static void passwordAuthentication(Account account, Scanner scanner)
    {
        String password;
        boolean authorized = false;
        while(!authorized)
        {
            password = scanner.nextLine();
            authorized = account.correctPassword(password);
            if(!authorized)
                System.out.println("This is a wrong password. Please enter your password.");
        }
        System.out.println("Authorization is accepted. Start your transaction by "
                + "entering the amount to withdraw.");
    }
    
    /**
     * 
     * Gets the withdraw amount and checks to make sure the withdraw amount is 
     * acceptable. Additionally, it allows the user to quit
     * 
     * @param atm
     * @param account
     * @param scanner
     */
    private static void withdrawlAmount(ATM atm, Account account, Scanner scanner)
    {
        String input;
        double withdraw;
        double balance;
        while(!(input = scanner.nextLine()).equals("quit"))
        {
            withdraw = Double.parseDouble(input);
            if(!atm.isInRange(withdraw))
            {
                System.out.println("This amount is not in range of the amount you "
                        + "can withdraw per day. Please enter amount or quit.");
            }
            else
            {
                balance = account.withdraw(withdraw);
                if(balance == -1)
                {
                    System.out.println("The amount exceeds the current balance. "
                            + "Please enter another amount or quit.");
                }
                else 
                    System.out.println("$" + withdraw + " is withdrawn from  your account. "
                            + "The remaining balance of this account is $" + balance + ". "
                            + " If you have more transactions, enter the amount or quit.");
            }
        }
    }
}