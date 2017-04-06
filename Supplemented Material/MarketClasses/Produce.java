/**
 *
 * Assignment 5: CISC 124 Winter 2017.
 * Class for produce items.
 */
public class Produce extends MarketItem
{
    private double unitPrice;   // price
    private double amount;     // amount  from type double
    
    /* constructor: all attribute values are user defined
    */
    public Produce(String name, String vendor, double unitPrice, double amount)
    {
        super(name, vendor); // call super constructor
        this.setUnitPrice(unitPrice); // set and check unitPrice
        this.setAmount(amount);   // set and check amount

    }
    
    /* returns unit price
     */
    public double getUnitPrice() {
        return unitPrice;
    }
    
    /* set unit price
    */
    public void setUnitPrice(double price) {
        if (price < 0.0) {
            System.out.println("Only non-negative unit price accepted.");
            this.unitPrice = 0.0;
        }
        else
            this.unitPrice = price;
    }
    
    /*
    returns amount
    */
    public double getAmount() {
        return amount;
    }
    
    
    /* set amount value - check if non-negative
    */
    public void setAmount(double a) {
        if (a < 0.0) {
            System.out.println("Only non-negative amount values accepted.");
            this.amount = 0.0;
        }
        else
            this.amount = a;
        
    }
    /* override getPrice from MarketItem
    price = amount * unitPrice
    */
    @Override
    public double getPrice() {
        return Money.roundMoney(unitPrice * amount);
    }
    
    /* override getTax method from MarketItem
       calculated based on Ontario tax regulations
    */   
    @Override
    public double getTax()
    {
        return 0.0;   // no tax for produce
    }
    
    /*Override toString method
    */
    @Override
    public String toString() {
        String output = amount + " @ " + Money.format(unitPrice)+ " = " + Money.format(this.getPrice()) + " " + super.toString();
        return output;
    }
    
    /* Override equals method
    methods returns true, if name , vendor and unit Price are equal
    */
    @Override
    public boolean equals(Object o){
        if (o instanceof Produce) {
            Produce p = (Produce)o;
            return this.getName().equals(p.getName()) && this.getVendor().equals(p.getVendor()) &&
                   (this.getUnitPrice() == p.getUnitPrice());
            
        }
        return false;
    }
}
