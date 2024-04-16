import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static DataCollection dataDAO = new DataCollection();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Create new data");
            System.out.println("2. Display all data");
            System.out.println("3. Delete data");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createData();
                    break;
                case 2:
                    displayAllData();
                    break;
                case 3:
                    deleteData();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void createData() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter value: ");
        String value = scanner.nextLine();
        UserData data = new UserData(id, value);
        dataDAO.addData(data);
        System.out.println("Data created successfully.");
        displayMenu();
    }

    private static void displayAllData() {
        List<UserData> dataList = dataDAO.getAllData();
        for (UserData data : dataList) {
            System.out.println(data);
        }
        displayMenu();
    }

    private static void deleteData() {
        System.out.print("Enter ID of the data to delete: ");
        String idToDelete = scanner.nextLine();
        dataDAO.deleteData(idToDelete);
        System.out.println("Data deleted successfully.");
        displayMenu();
    }

    private static void displayMenu() {
        System.out.println("\nReturning to main menu...\n");
    }
}
