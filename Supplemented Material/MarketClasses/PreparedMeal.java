

/**
 *
 * Assignment 5: CISC 124 Winter 2017.
 * Class for prepared food items.
 */
public class PreparedMeal extends MarketItem {
    private double price;   // price
    private int amount;     // amount  from type int
    
    // 1. constructor. Amount set to 1.
    public PreparedMeal(String name, String vendor, double unitPrice) {
        this(name, vendor, unitPrice, 1);
        
    }
    
    // 2. constructor. Amount set by user
    public PreparedMeal(String name, String vendor, double unitPrice, int amount) {
        super(name, vendor);
        price = unitPrice;
        
        // amount should never be small than 1
        if (amount > 0)
            this.amount = amount;
        else
            this.amount = 1;
        
    }
    
    // set the amount
    public void setAmount(int a) {
        if (a > 0)
            this.amount = a;
        else
            this.amount = 1;
    }
    
    // get the amount value
    public int getAmount() {
        return amount;
    }
    
    // return price of item
    public double getPrice() {
        // check price
        return Money.roundMoney(price * amount);
    }
    
    /* return the tax for item accordint to Ontario tax regulation
       price < 4.0: taxed with 5 percent
       price >= 4.0: taxed with 13 percent
    */
    public double getTax() {
        double tax = 0.0;
        if (price < 4.0) {
            tax = (price * amount) * 5 / 100;
        }
        else
             tax = (price * amount) * 13 / 100;
        
        //return the rounded value
        return Money.roundMoney(tax);
    }
    
    @Override
    public String toString() {
        return "Prepared Food: " + super.toString() + " , Price: " + Money.format(getPrice()) + " (Tax: " + Money.format(getTax()) + ")";
    }
    
}

