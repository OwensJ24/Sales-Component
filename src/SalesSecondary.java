import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * Layered implementations of secondary methods for {@code Sales}.
 */
public abstract class SalesSecondary implements Sales {

    /**
     * Four.
     */
    private final int four = 4;
    /**
     * Seven.
     */
    private final int seven = 7;

    /*
     * Common methods ( from Object)
     */

    @Override
    public String toString() {

        String result = "";

        Sales temp = this.newInstance();


        while (this.size() > 0) {

            SalesData t = this.removeAnyTransaction();
            result += t.getName() + ",";

            temp.addTransactionFull(t);

        }

        this.transferFrom(temp);

        return result;
    }

    @Override
    public boolean equals(Object obj) {

        boolean result = true;

        if (!(obj instanceof Sales)) {
            result = false;
        }
        if (this == obj) {
            result = true;
        }
        if (obj == null) {
            return false;
        }

        Sales other = (Sales) obj;

        if (this.size() != other.size()) {
            return false;
        }

        return result;
    }

    @Override
    public int hashCode() {

        int result = 0;
        int rnd = four;
        int rnd2 = seven;
        int n = 0;

        Sales temp = this.newInstance();

        for (int i = 0; n < four && i < this.size(); i++) {



            SalesData d = this.removeAnyTransaction();



            result = rnd + result * rnd2 * d.hashCode();
            n++;

            temp.addTransactionFull(d);
        }

        this.transferFrom(temp);
        return result;
    }

    // Ehanced Methods ---------------------------------------------------

    /**
     *  Reports sales from start to end date.
     */
    @Override
    public String salesReport(LocalDate startDate, LocalDate endDate) {

        String report = "";
        Sales temps = this.newInstance();

        while (this.size() > 0) {

            SalesData t = this.removeAnyTransaction();

            if (t.getSaleDate() != null) {

                if (t.getSaleDate().compareTo(startDate) >= 0
                        && t.getSaleDate().compareTo(endDate) <= 0) {
                    report += "Item Name: " + t.getName() + " ";
                    report += "Sale Date: " + t.getSaleDate() + " ";
                    report += "Sale Price: " + t.getSalePrice();
                }

                temps.addTransactionFull(t);

            }

        }

        this.transferFrom(temps);

        return report;
    }

    /**
     * Reports purchase from start to end date.
     */
    @Override
    public String purchaseReport(LocalDate startDate, LocalDate endDate) {

        String report = "";

        Sales temps = this.newInstance();

        while (this.size() > 0) {

            SalesData t = this.removeAnyTransaction();

            if (t.getSaleDate() != null) {

                if (t.getPurchaseDate().compareTo(startDate) >= 0
                        && t.getPurchaseDate().compareTo(endDate) <= 0) {
                    report += "Item Name: " + t.getName() + " ";
                    report += "Purchase Date: " + t.getPurchaseDate() + " ";
                    report += "Purchase Price: " + t.getPurchasePrice();
                }

                temps.addTransactionFull(t);

            }

        }

        this.transferFrom(temps);

        return report;
    }
/**
 * Reports Profit From Start to End Date.
 */
    @Override
    public int profitReport(LocalDate startDate, LocalDate endDate) {

        int profit = 0;
        Sales temps = this.newInstance();

        while (this.size() > 0) {

            SalesData t = this.removeAnyTransaction();

            if (t.getSaleDate() != null) {

                if (t.getSaleDate().compareTo(startDate) >= 0
                        && t.getSaleDate().compareTo(endDate) <= 0) {
                    profit += t.getSalePrice() - t.getPurchasePrice();
                }

            }

            temps.addTransactionFull(t);
        }

        this.transferFrom(temps);

        return profit;

    }

    /**
     * Reports slow moving items that have not sold up to the current date.
     */
    @Override
    public String slowMovingItems(LocalDate currentDate, int tooLong) {

        String report = "";

        Sales temps = this.newInstance();

        while (this.size() > 0) {

            SalesData t = this.removeAnyTransaction();

            long diff = ChronoUnit.DAYS.between(t.getPurchaseDate(), currentDate);

            if (t.getSaleDate() == null && diff > tooLong) {

                report += "Item Name: " + t.getName() + " ";
                report += "Purchase Date: " + t.getPurchaseDate() + " ";
                report += "Purchase Price: " + t.getPurchasePrice();
            }

            temps.addTransactionFull(t);
        }

        this.transferFrom(temps);

        return report;

    }

    /**
     * Deletes the sold information of a returned item.
     */
    @Override
    public void returnedItem(String itemName) {

        Sales temps = this.newInstance();

        while (this.size() > 0) {

            SalesData t = this.removeAnyTransaction();

            if (t.getName().equals(itemName)) {
                t.setSaleDate(null);
                t.setSalePrice(0);
            }


            temps.addTransactionFull(t);
        }

        this.transferFrom(temps);

    }

}
