
/**
 *
 * @author Manuela Kunz, CISC 124 Winter 2017.
 * This abstract class contains the general implementation of
 * a market item. A item is defined by its name and the vendor selling
 * the item. 
 */
public abstract class  MarketItem {
    private String name;    // name of item
    private String vendor;  // name of vendor selling the item
    
    /** Constructor for initializing the item with name and vendor */
    public MarketItem(String name, String vendor) {
        this.name = name;
        this.vendor = vendor;
    }
    
    /** accessor method for item name */
    public String getName() {
        return name;
    }
    
    /** accessor method for vendor name */
    public String getVendor() {
        return vendor;
    }
    
    /** abstract method to return the price of the item
     * (excluding tax)
     *  
     */
    public abstract double getPrice();
    
    /** abstract method to return the tax for the item
     */
    public abstract double getTax();
    
    /** implementation of toString for market items
     * returns a string containing the name and vendor
     */
    @Override
    public String toString() {
        String s = name + " from " + vendor;
        return s;
    }

}
