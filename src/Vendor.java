/**
 * This class implements a vendor that sells one kind
 * of items. A vendor carries out sales transactions.
 */
public class Vendor
{
    private int itemPrice;
    private int totalStock;
    private int money;
    private int change;
    static double totalSales;
          /**
           * Constructs a Vendor
           * @param price the price of a single item in cents (int)
           * @param stock number of items to place in stock (int)
           *
           * */
          public Vendor(int price, int stock) {
              itemPrice = price;
              setStock(stock);
          }

    /**
     * Sets the quantity of items in stock.
     * @param qty number of items to place in stock (int)
     */
    public void setStock(int qty)
    {
        totalStock = qty;
    }

    /**
     * Returns the number of items currently in stock.
     * @return number of items currently in stock (int)
     */
    public int getStock()
    {
        return totalStock;
    }

    /**
     * Adds a specified amount (in cents) to the
     * deposited amount.
     * @param number of cents to add to the deposit (int)
     */
    public void addMoney(int number)
    {
        money = number + getDeposit();
    }

    /**
     * Returns the currently deposited amount (in cents).
     * @return number of cents in the current deposit (int)
     */
    public int getDeposit()
    {
        return money;
    }

    /**
     * Implements a sale.  If there are items in stock and
     * the deposited amount is greater than or equal to
     * the single item price, then adjusts the stock
     * and calculates and sets change and returns true;
     * otherwise refunds the whole deposit (moves it into
     * change) and returns false.
     * @return true for a successful sale, false otherwise (boolean)
     */
    public boolean makeSale()
    {
        if(getStock() < 0){
            return false;
        }
        if(getDeposit() < itemPrice){
            return false;
        }
        else{
            totalStock -= 1;
            totalSales += itemPrice;
        }
        return true;
    }

    /**
     * Returns and zeroes out the amount of change (from
     * the last sale or refund).
     * @return number of cents in the current change (int)
     */
    public int getChange()
    {
        change = getDeposit() - itemPrice;
        money = 0;
        return change;
    }
    public static double getTotalSales(){
        totalSales = totalSales/100.00;
        double totalSales2 = totalSales;
        totalSales = 0.0;
        return totalSales2;
    }
}