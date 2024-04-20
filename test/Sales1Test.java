import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;






/**
 * JUnit test fixture for {@code Sales1}'s constructor and kernel methods.
 */
public class Sales1Test {

    /**
     * Ten.
     */
    public static final int TEN = 10;

    /**
     * Twenty.
     */
    public static final int TWENTY = 20;

    @Test
    public void testDefaultConstructor() {
        Sales sales = new Sales1();

        assertEquals(0, sales.size());
    }

    @Test
    public void testAddTransactionSale() {

        Sales sales = new Sales1();
        Sales salesExpected = new Sales1();

        SalesData data = new SalesData();
        data.setName("Item1");
        data.setSaleDate(LocalDate.now());
        data.setSalePrice(TEN);
        data.setPurchaseDate(LocalDate.now());
        data.setPurchasePrice(TEN);

        salesExpected.addTransactionFull(data);

        //Adding the purchase as you can only sell an item you purchased

        sales.addTransactionPurchase("Item1", LocalDate.now(), TEN);

        sales.addTransactionSale("Item1", LocalDate.now(), TEN);


        assertEquals(salesExpected, sales);
    }

    @Test
    public void testAddTransactionPurchase() {
        Sales sales = new Sales1();
        Sales salesExpected = new Sales1();

        SalesData data = new SalesData();
        data.setName("Item1");
        data.setPurchaseDate(LocalDate.now());
        data.setPurchasePrice(TEN);

        salesExpected.addTransactionFull(data);

        sales.addTransactionPurchase("Item1", LocalDate.now(), TEN);


        assertEquals(salesExpected, sales);
    }

    @Test
    public void testAddTransactionFull() {
        Sales sales = new Sales1();
        Sales salesExpected = new Sales1();

        SalesData data = new SalesData();
        data.setName("Item1");
        data.setPurchaseDate(LocalDate.now());
        data.setPurchasePrice(TEN);
        data.setSaleDate(LocalDate.now());
        data.setSalePrice(TWENTY);

        salesExpected.addTransactionFull(data);

        sales.addTransactionFull(data);

        assertEquals(salesExpected, sales);
    }

    @Test
    public void testRemoveTransaction() {
        Sales sales = new Sales1();
        Sales salesCopy = sales.newInstance();


        //Adding the purchase as you can only sell an item you purchased

        sales.addTransactionPurchase("Item1", LocalDate.now(), TEN);

        sales.addTransactionSale("Item1", LocalDate.now(), TEN);

        sales.removeTransaction("Item1");

        assertEquals(0, sales.size());
        assertEquals(salesCopy, sales);
    }

    @Test
    public void testGetSoldPrice() {
        Sales sales = new Sales1();
        Sales salesCopy = new Sales1();

         //Adding the purchase as you can only sell an item you purchased

         sales.addTransactionPurchase("Item1", LocalDate.now(), TEN);
         salesCopy.addTransactionPurchase("Item1", LocalDate.now(), TEN);

        sales.addTransactionSale("Item1", LocalDate.now(), TEN);
        salesCopy.addTransactionSale("Item1", LocalDate.now(), TEN);

        assertEquals(TEN, sales.getSoldPrice("Item1"), 0.01);
        assertEquals(salesCopy, sales);

    }

    @Test
    public void testGetPurchasePrice() {
        Sales sales = new Sales1();
        Sales salesCopy = new Sales1();
        sales.addTransactionPurchase("Item2", LocalDate.now(), TWENTY);
        salesCopy.addTransactionPurchase("Item2", LocalDate.now(), TWENTY);
        assertEquals(TWENTY, sales.getPurchasePrice("Item2"), 0.01);
        assertEquals(salesCopy, sales);

    }

    @Test
    public void testGetPurchaseDate() {
        Sales sales = new Sales1();
        Sales salesCopy = new Sales1();
        LocalDate purchaseDate = LocalDate.now();
        sales.addTransactionPurchase("Item2", purchaseDate, TWENTY);
        salesCopy.addTransactionPurchase("Item2", purchaseDate, TWENTY);
        assertEquals(purchaseDate, sales.getPurchaseDate("Item2"));
        assertEquals(salesCopy, sales);
    }

    @Test
    public void testGetSaleDate() {
        Sales sales = new Sales1();
        Sales salesCopy = new Sales1();
        LocalDate saleDate = LocalDate.now();

         //Adding the purchase as you can only sell an item you purchased

         sales.addTransactionPurchase("Item1", LocalDate.now(), TEN);
         salesCopy.addTransactionPurchase("Item1", LocalDate.now(), TEN);

        sales.addTransactionSale("Item1", saleDate, TEN);
        salesCopy.addTransactionSale("Item1", saleDate, TEN);
        assertEquals(saleDate, sales.getSoldDate("Item1"));
        assertEquals(salesCopy, sales);
    }

    @Test
    public void testIsSold() {
        Sales sales = new Sales1();
        Sales salesCopy = new Sales1();
        sales.addTransactionPurchase("Item1", LocalDate.now(), TEN);
        sales.addTransactionSale("Item1", LocalDate.now(), TWENTY);
        sales.addTransactionPurchase("Item2", LocalDate.now(), TEN);

        salesCopy.addTransactionPurchase("Item1", LocalDate.now(), TWENTY);
        salesCopy.addTransactionSale("Item1", LocalDate.now(), TEN);
        salesCopy.addTransactionPurchase("Item2", LocalDate.now(), TEN);

        assertTrue(sales.isSold("Item1"));
        assertFalse(sales.isSold("Item2"));
        assertEquals(salesCopy, sales);
    }

    @Test
    public void testSize() {
        Sales sales = new Sales1();
        Sales salesCopy = new Sales1();
//Adding the purchase as you can only sell an item you purchased

sales.addTransactionPurchase("Item1", LocalDate.now(), TEN);
salesCopy.addTransactionPurchase("Item1", LocalDate.now(), TEN);

        sales.addTransactionSale("Item1", LocalDate.now(), TEN);
        salesCopy.addTransactionSale("Item1", LocalDate.now(), TEN);

        assertEquals(1, sales.size());
        assertEquals(salesCopy, sales);
    }

    @Test
    public void testRemoveAnyTransaction() {
        Sales sales = new Sales1();
        Sales salesCopy = new Sales1();

//Adding the purchase as you can only sell an item you purchased

sales.addTransactionPurchase("Item1", LocalDate.now(), TEN);

        sales.addTransactionSale("Item1", LocalDate.now(), TEN);
        sales.removeAnyTransaction();

        assertEquals(0, sales.size());
        assertEquals(salesCopy, sales);
    }

}
