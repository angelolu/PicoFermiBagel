
/**
 *
 * @author Assignment 5: CISC 124 Winter 2017.
 * This class handles the checkout for 
 * item purchased on a farmers market.
 * Please note that there are changes in this class compared
 * to the Checkout class in assignment 3. 
 */
public class Checkout {
    private MarketItem[] items;   // list with food items
    private int nrItems;           // nr of items
    
    /** constructor */
    public Checkout() {
        items = new MarketItem[20];    // initalize with 20, grow if necessary
        nrItems = 0;                    // nr of items 
    }
    
    /* Method to add market items to the list 
    */
    public void addItem(MarketItem it) {
        if (nrItems == items.length) {
            // have to make my list longer
            MarketItem[] newList = new MarketItem[items.length + 20];
            for (int i = 0; i < nrItems; i++) {
                newList[i] = items[i];
            }
            items = newList;
        }
        
        // add new item to list
        items[nrItems] = it;
        nrItems++;
    }
    
    /** returns the total price for all items
     * excluding tax 
     */
    public double getTotalPrice() {
        double p = 0.0;
        for (int i=0; i < nrItems; i++ )
            p = p + items[i].getPrice();
        
        p = Money.roundMoney(p);
        return p;
    }
    
    /* returns String containing the total price - formated for Money
    */
    public String getTotalPriceString() {
        return Money.format(getTotalPrice());
    }
    
    
    /** returns the total tax for all items
     */
    public double getTotalTax() {
        double f = 0.0;
        for (int i=0; i < nrItems; i++ )
            f = f + items[i].getTax();
        
        return f;
    }
    
    /* returns String containing the total tax - formated for Money
    */
    public String getTotalTaxString() {
        return Money.format(getTotalTax());
    }
    
    /** returns the total purchase amount for all items
     * including tax
     */
    public double getTotalAmount() {
        return this.getTotalPrice() + this.getTotalTax();
    }
    
    /* returns String containing the total amount - formated for Money
    */
    public String getTotalAmountString() {
        return Money.format(getTotalAmount());
    }
    
    /* override the toString method
    */
    public String toString() {
        String s = "Total Price: " + this.getTotalPriceString() + "\n";
        s = s + "Total Tax: " + this.getTotalTaxString() + "\n";
        s = s + "Total Amount: " + this.getTotalAmountString();
        return s;
    }
}
