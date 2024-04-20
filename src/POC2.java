import java.time.LocalDate;
import java.util.Scanner;


/**
 * Proof of concept for Sales.
 */
public final class POC2 {


    /**
     * Utility Class.
     */
    private POC2() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated");
    }

    /**
     *
     * @param sc
     * @return if you should continue
     */
    private static boolean doContinue(Scanner sc) {
        System.out.println("Do you have another item that needs returned? y/n");
        String input = sc.nextLine();
        return input.toLowerCase().equals("y");
    }

    /**
     * Main class.
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String transcation = "";
        boolean loop = true;

        Sales salesSheet = new Sales1();

        //Example Sales sheet with items already in the system

        SalesData data1 = new SalesData("Zelda", LocalDate.now(),
                LocalDate.now(), 100, 40);
        SalesData data2 = new SalesData("Mario", LocalDate.now(),
                LocalDate.now(), 40, 20);
        SalesData data3 = new SalesData("Halo", LocalDate.now(),
                LocalDate.now(), 10, 2);
        SalesData data4 = new SalesData("Gta", LocalDate.now(), LocalDate.now(),
                30, 5);
        SalesData data5 = new SalesData("Kirby", LocalDate.now(),
                LocalDate.now(), 45, 15);

        salesSheet.addTransactionFull(data1);
        salesSheet.addTransactionFull(data2);
        salesSheet.addTransactionFull(data3);
        salesSheet.addTransactionFull(data4);
        salesSheet.addTransactionFull(data5);

        System.out
                .println("Hello! Welcome to your Sales Sheet Return Manager!");

        while (loop) {

            System.out.println("Enter the name of the item that got returned");
            transcation = in.nextLine();

            salesSheet.returnedItem(transcation);

            System.out.println("The Item " + transcation
                    + " has been marked as returned "
                    + "and had its sales information removed!");

            loop = doContinue(in);

        }

    }

}
