import components.standard.Standard;

import java.time.LocalDate;


/**
 * Sales Kernel compoenent with primary methods.
 *
 */
public interface SalesKernel extends Standard<Sales> {




    /**
     * @return the size of the map
     */
    int size();
/**
 * Adds a full transaction to the map including purchase and sale.
 *
 * @param data
 */
    void addTransactionFull(SalesData data);
   /**
    * Adds a sale transaction to the map.
    * @param name
    * @param sDate
    * @param sPrice
    */
    void addTransactionSale(String name, LocalDate sDate, double sPrice);

    /**
     * Adds a purchase transaction to the map.
     * @param name
     * @param pDate
     * @param pPrice
     */
    void addTransactionPurchase(String name, LocalDate pDate, double pPrice);

    /**
     *
     * @param itemName
     *            name of the item to be removed from this
     *
     *
     * @return the removed transaction
     */
    SalesData removeTransaction(String itemName);

    /**
     * Removes a random transaction from the map.
     *
     * @return Sales Data of random transaction
     */
    SalesData removeAnyTransaction();

    /**
     *
     * @param itemName
     *            name of the item to get
     *
     * @return item sold Price
     */
    double getSoldPrice(String itemName);

    /**
     *
     * @param itemName
     *            name of the item to get
     *
     * @return item sold Price
     */
    double getPurchasePrice(String itemName);

    /**
     *
     * @param itemName
     *            name of the item to get
     *
     * @return item sold Price
     */
    LocalDate getSoldDate(String itemName);

    /**
     *
     * @param itemName
     *            name of the item to get
     *
     * @return item sold Price
     */
    LocalDate getPurchaseDate(String itemName);

    /**
     * Checks to see if a purchased item is sold.
     *
     * @param itemName
     *
     * @return true if the item is sold, false otherwise
     */
    boolean isSold(String itemName);

}
