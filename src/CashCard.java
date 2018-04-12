import java.util.GregorianCalendar;

/**
 * 
 * CashCard object that holds an expiration date
 * 
 * @author HunterLai
 *
 */
public class CashCard
{
    private GregorianCalendar expirationDate;
    
    /**
     * 
     * Constructor, that sets the expiration date
     * 
     * @param newExpiration
     */
    CashCard(GregorianCalendar newExpiration)
    {
        expirationDate = newExpiration;
    }
    
    /**
     * 
     * Checks to see if the CashCard has expired
     * 
     * @return true or false, depending if it has expired or not
     */
    public boolean isValid()
    {
        GregorianCalendar localDate = new GregorianCalendar();
        return localDate.before(expirationDate);
    }
    
    /**
     * 
     * Formats CashCard information to a string and returns it
     * 
     * @return String of CashCard information, particularly the expiration date
     */
    public String expirationDateToString()
    {
        return expirationDate.get(GregorianCalendar.MONTH) + "/" + 
                expirationDate.get(GregorianCalendar.DAY_OF_MONTH) + "/"
                + expirationDate.get(GregorianCalendar.YEAR);
    }   
}