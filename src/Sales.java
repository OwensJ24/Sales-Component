import java.time.LocalDate;

/**
 * Sales interface with primary methods.
 *
 */
public interface Sales extends SalesKernel {


    /**
     * Displays all sales from the Start Date to end Date, their name and sold price.
     * @param startDate
     * @param endDate
     *
     * @return String of all sales in the given time frame.
     */
    String salesReport(LocalDate startDate, LocalDate endDate);

    /**
     * Dispalys all purchases fromt he start to end date.
     * @param startDate
     * @param endDate
     *
     * @return String of all purchases in the given time frame.
     */
    String purchaseReport(LocalDate startDate, LocalDate endDate);


    /**
     * Gives the amount of profit made across all items in the given time frame.
     * @param startDate
     * @param endDate
     * @return Amount of profit for the time frame
     */
    int profitReport(LocalDate startDate, LocalDate endDate);

    /**
     * Displays all items that have not sold withing the specified time frame.
     *
     *
     * @param currentDate
     * @param tooLong
     *
     * @return String of all items that have not sold within the given time frame.
     */
    String slowMovingItems(LocalDate currentDate, int tooLong);


    /**
     * Takes an item that got returned, and removes the sold information of the item
     * keeping the purchase information.
     *
     * @param itemName
     */
    void returnedItem(String itemName);

 }
