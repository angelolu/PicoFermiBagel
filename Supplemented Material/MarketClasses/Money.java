
/**
 *
 * @author Assignment 5, CISC 124 Winter 2017.
 * The class contains two static method to
 * round and format double values money style. 
 */
public class Money {
    
    /* private constructor should never be invoked - only static methods
    */
    private Money() {
        
    }
    
    /* Rounds a double value to two places after the decimal point
    */
    public static double roundMoney(double a) {
        a = a + 0.005;   // rounds the second digit after the decimal point
        a = a * 100;     // shifts the decimal point two places to the right
        int b = (int)a;  // cuts of all digits after the decimal point
        a = b/100.0;       // shift the decimal point back two places to the left
        return a;
    }
    
    /* returns a String which is in a money format
    */
    public static String format(double a) {
        String s = String.format("$%.2f", a);
        return s;
        
    }

}
