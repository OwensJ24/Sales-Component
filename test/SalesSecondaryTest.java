import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.time.LocalDate;

/**
 * JUnit test fixture for {@code SalesSecondary}'s secondary methods.
 *
 */
public class SalesSecondaryTest {



    @Test
    public void testSalesReport() {



        Sales sales = new Sales1();

        SalesData t1 = new SalesData("Item1", LocalDate.of(2022, 1, 2),
                LocalDate.of(2021, 1, 1), 100, 50);

        SalesData t2 = new SalesData("Item2", LocalDate.of(2020, 1, 2),
                LocalDate.of(2019, 1, 1), 100, 50);

        sales.addTransactionFull(t1);
        sales.addTransactionFull(t2);

        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 31);
        String report = sales.salesReport(startDate, endDate);
        // Add assertions to verify the correctness of the sales report
        assertEquals("Item Name: Item1 Sale Date: 2022-01-02 Sale Price: 100.0",
                report);

    }

    @Test
    public void testPurchaseReport() {

        Sales sales = new Sales1();

        SalesData t1 = new SalesData("Item1", LocalDate.of(2022, 1, 2),
                LocalDate.of(2022, 1, 2), 100, 50);

        SalesData t2 = new SalesData("Item2", LocalDate.of(2022, 1, 2),
                LocalDate.of(2021, 1, 1), 100, 50);

        sales.addTransactionFull(t1);
        sales.addTransactionFull(t2);

        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 31);
        String report = sales.purchaseReport(startDate, endDate);
        // Add assertions to verify the correctness of the purchase report
        assertEquals(
                "Item Name: Item1 Purchase Date: 2022-01-02 Purchase Price: 50.0",
                report);
    }

    @Test
    public void testProfitReport() {
        Sales sales = new Sales1();

        SalesData t1 = new SalesData("Item1", LocalDate.of(2022, 1, 3),
                LocalDate.of(2022, 1, 2), 100, 50);

        SalesData t2 = new SalesData("Item2", LocalDate.of(2022, 3, 2),
                LocalDate.of(2022, 2, 1), 100, 50);

        sales.addTransactionFull(t1);
        sales.addTransactionFull(t2);

        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 31);

        int profit = sales.profitReport(startDate, endDate);

        assertEquals(100, profit);

    }

    @Test
    public void testSlowMovingItems() {
        Sales sales = new Sales1();
        LocalDate currentDate = LocalDate.now();
        int tooLong = 30;

        LocalDate pDate = LocalDate.of(2020, 1, 2);

        SalesData t1 = new SalesData("Item1", null, pDate, 100, 50);

        sales.addTransactionFull(t1);

        String report = sales.slowMovingItems(currentDate, tooLong);

        assertEquals(
                "Item Name: Item1 Purchase Date: 2020-01-02 Purchase Price: 50.0",
                report);
    }

    @Test
    public void testReturnedItem() {
        Sales sales = new Sales1();
        Sales salesCopy = new Sales1();

        LocalDate sDate = LocalDate.of(2022, 1, 3);
        LocalDate pDate = LocalDate.of(2020, 1, 2);

        SalesData t1 = new SalesData("Item1", sDate, pDate, 100, 50);


        LocalDate pDate2 = LocalDate.of(2020, 1, 2);

        SalesData t2 = new SalesData("Item1", pDate2, 50);


        sales.addTransactionFull(t1);
        salesCopy.addTransactionFull(t2);

        //Ensure Item is Sold before call to returned Item
        assertTrue(sales.isSold("Item1"));

        sales.returnedItem("Item1");

        assertFalse(sales.isSold("Item1"));


        assertEquals(0.0, sales.getSoldPrice("Item1"), 0);
        assertEquals(null, sales.getSoldDate("Item1"));
        assertEquals(salesCopy, sales);

    }

}
