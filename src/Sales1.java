
import java.time.LocalDate;

import components.map.Map;
import components.map.Map1L;

/**
 * Sales sheet represented as a map with implementations of primary methods.
 *
 * @convention <pre>
 *
 * for all i, j: String
 *             where ( 0 < i )
 *          this.rep.key(i) = $this.rep.value(i).name
 *     and $this.rep.key(i) != $this.rep.key(j)
 *
 *
 *
 *</pre>
 * @correspondence <pre>
 *  this.key = $this.key
 * this.value = $this.value
 *
 * </pre>
 *
 * @author Xzavier Owens
 */
public class Sales1 extends SalesSecondary {

    /**
     * Map representation of the sales data.
     */
    private Map<String, SalesData> rep;

    /**
     * Creates a new rep.
     */
    private void createNewRep() {

        this.rep = new Map1L<String, SalesData>();
    }


    /*
     * Constructors---------------------------------------------------
     */

    /**
     * Default constructor.
     */

    public Sales1() {

        this.createNewRep();
    }

    /*
     * Standard methods---------------------------------------------------
     */


    @Override
    public final Sales newInstance() {

        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {

        this.createNewRep();

    }

    @Override
    public final void transferFrom(Sales source) {

        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof Sales1 : ""
                + "Violation of: source is of dynamic type Sales1<?, ?>";

        Sales1 localSource = (Sales1) source;

        this.rep = localSource.rep;

        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------
     */

    @Override
    public final void addTransactionSale(String name, LocalDate sDate,
            double sPrice) {

        assert this.rep.hasKey(
                name) : "Violation of: item has not already been Purchased";

        this.rep.value(name).setSaleDate(sDate);
        this.rep.value(name).setSalePrice(sPrice);

    }

    @Override
    public final void addTransactionFull(SalesData data) {

        this.rep.add(data.getName(), data);

    }


    @Override
    public final void addTransactionPurchase(String name, LocalDate pDate,
            double pPrice) {

        SalesData data = new SalesData(name, pDate, pPrice);

        this.rep.add(data.getName(), data);

    }



    @Override
    public final SalesData removeTransaction(String itemName) {

        return this.rep.remove(itemName).value();
    }

    @Override
    public final int size() {

        return this.rep.size();
    }

    @Override
    public final SalesData removeAnyTransaction() {

        return this.rep.removeAny().value();
    }

    @Override
    public final double getSoldPrice(String itemName) {

        return this.rep.value(itemName).getSalePrice();
    }

    @Override
    public final double getPurchasePrice(String itemName) {

        return this.rep.value(itemName).getPurchasePrice();
    }

    @Override
    public final LocalDate getPurchaseDate(String itemName) {

        return this.rep.value(itemName).getPurchaseDate();
    }

    @Override
    public final LocalDate getSoldDate(String itemName) {

        return this.rep.value(itemName).getSaleDate();
    }

    @Override
    public final boolean isSold(String itemName) {

        boolean sold = true;

        if (this.rep.value(itemName).getSaleDate() == null
                && this.rep.value(itemName).getSalePrice() == 0) {
            sold = false;
        }

        return sold;
    }
}
