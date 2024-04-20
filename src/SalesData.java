import java.time.LocalDate;

/**
 * Sales data.
 */
public class SalesData {

    /**
     * Name of the item.
     */
    private String name;

    /**
     * Sale Date.
     */
    private LocalDate sDate;

    /**
     * Purchase Date.
     */
    private LocalDate pDate;

    /**
     * Sale Price.
     */
    private double sPrice;

    /**
     * Purchase Price.
     */
    private double pPrice;

    /**
     * SalesData Constructor.
     *
     * @param name
     * @param sDate
     * @param pDate
     * @param sPrice
     * @param pPrice
     */
    public SalesData(String name, LocalDate sDate, LocalDate pDate,
            double sPrice, double pPrice) {
        this.name = name;
        this.sDate = sDate;
        this.pDate = pDate;
        this.sPrice = sPrice;
        this.pPrice = pPrice;
    }

    /**
     * SalesData Constructor for a Sale.
     *
     * @param name
     * @param sDate
     * @param sPrice
     * @param type
     *            Specifies it is a sale
     */
    public SalesData(String name, LocalDate sDate, double sPrice, String type) {
        this.name = name;
        this.sDate = sDate;
        this.sPrice = sPrice;
    }

    /**
     * SalesData Constructor for purchase.
     *
     * @param name
     * @param pDate
     * @param pPrice
     */
    public SalesData(String name, LocalDate pDate, double pPrice) {
        this.name = name;
        this.pDate = pDate;
        this.pPrice = pPrice;
        this.sPrice = 0;
        this.sDate = null;
    }

    /**
     * Defualt Constructor.
     */
    public SalesData() {

        this.name = null;
        this.pDate = null;
        this.pPrice = 0;
        this.sPrice = 0;
        this.sDate = null;

    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param saleDate
     */
    public void setSaleDate(LocalDate saleDate) {
        this.sDate = saleDate;
    }

    /**
     *
     * @param purchaseDate
     */
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.pDate = purchaseDate;
    }

    /**
     *
     * @param salePrice
     */
    public void setSalePrice(double salePrice) {
        this.sPrice = salePrice;
    }

    /**
     *
     * @param purchasePrice
     */
    public void setPurchasePrice(double purchasePrice) {
        this.pPrice = purchasePrice;
    }

    /**
     * Get the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the sale date.
     *
     * @return The sale date.
     */
    public LocalDate getSaleDate() {
        return sDate;
    }

    /**
     * Get the purchase date.
     *
     * @return The purchase date.
     */
    public LocalDate getPurchaseDate() {
        return pDate;
    }

    /**
     * Get the sale price.
     *
     * @return The sale price.
     */
    public double getSalePrice() {
        return sPrice;
    }

    /**
     * Get the purchase price.
     *
     * @return The purchase price.
     */
    public double getPurchasePrice() {
        return pPrice;
    }

}
