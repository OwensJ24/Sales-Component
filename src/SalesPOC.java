import java.time.LocalDate;
import java.util.Scanner;

/**
 * Proof of concept for Sales.
 */
public final class SalesPOC {

    /**
     * Utility Class.
     */
    private SalesPOC() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated");
    }

    /**
     *
     * @param sc
     * @return if you should continue
     */
    private static boolean doContinue(Scanner sc) {
        System.out.println("Enter another transaction? y/n");
        String input = sc.nextLine();
        return input.toLowerCase().equals("y");
    }

    /**
     * Asks if the user wants to have a profit report, outputs the report.
     *
     * @param in
     * @param salesSheet
     */
    public static void askForProfitReport(Scanner in, Sales salesSheet) {

        System.out.println("Calc a profit report? y/n");
        String p = "y";

        if (p.equals("y")) {
            System.out.println("Enter a Start Day");
            int sday = in.nextInt();
            in.nextLine();

            System.out.println("Enter a Start Month");
            int smonth = in.nextInt();
            in.nextLine();

            System.out.println("Enter a Start Year");
            int syear = in.nextInt();
            in.nextLine();

            LocalDate sDate = LocalDate.of(syear, smonth, sday);

            System.out.println("Enter a End Day");
            int eday = in.nextInt();
            in.nextLine();

            System.out.println("Enter a End Month");
            int emonth = in.nextInt();
            in.nextLine();

            System.out.println("Enter a End Year");
            int eyear = in.nextInt();
            in.nextLine();

            LocalDate eDate = LocalDate.of(eyear, emonth, eday);

            int profit = salesSheet.profitReport(sDate, eDate);

            System.out.println("The profit from " + sDate + " to " + eDate
                    + " is " + profit);
            p = in.nextLine();
        }
    }

    /**
     * Main class.
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String type = "";
        String transcation = "";
        boolean loop = true;

        System.out.println("Hello! Welcome to your Sales Sheet");

        Sales salesSheet = new Sales1();

        while (loop) {

            System.out.println("Are you entering a sale or a purchase");
            type = in.nextLine();
            System.out.println("Enter the name of the item ");
            transcation = in.nextLine();

            if (type.equals("purchase")) {
                System.out.println("Enter purchase price");
                int purchasePrice = in.nextInt();
                in.nextLine();
                System.out.println("Enter a purchase Day");
                int day = in.nextInt();
                in.nextLine();

                System.out.println("Enter a purchase Month");
                int month = in.nextInt();
                in.nextLine();

                System.out.println("Enter a purchase Year");
                int year = in.nextInt();
                in.nextLine();

                LocalDate date = LocalDate.of(year, month, day);

                salesSheet.addTransactionPurchase(transcation, date,
                        purchasePrice);

            } else if (type.equals("sale")) {
                System.out.println("Enter sale Price");
                int salePrice = in.nextInt();
                in.nextLine();

                System.out.println("Enter a Sale Day");
                int day = in.nextInt();
                in.nextLine();

                System.out.println("Enter a Sale Month");
                int month = in.nextInt();
                in.nextLine();

                System.out.println("Enter a Sale Year");
                int year = in.nextInt();
                in.nextLine();

                LocalDate date = LocalDate.of(year, month, day);

                salesSheet.addTransactionSale(transcation, date, salePrice);

            } else {
                System.out.println("Not valid");
            }

            loop = doContinue(in);

        }

        askForProfitReport(in, salesSheet);

    }

}
