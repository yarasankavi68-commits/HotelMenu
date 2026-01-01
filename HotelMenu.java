import java.io.*;
import java.util.Scanner;

public class HotelMenu {

    static final String MENU_FILE = "menu.txt";
    static final String ORDER_FILE = "orders.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== HOTEL MENU SYSTEM ======");
            System.out.println("1. Add Food Item");
            System.out.println("2. View Menu");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addFoodItem(sc);
                case 2 -> viewMenu();
                case 3 -> placeOrder(sc);
                case 4 -> viewOrders();
                case 5 -> System.out.println("Thank you! Visit Again.");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }

    
    static void addFoodItem(Scanner sc) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(MENU_FILE, true))) {
            System.out.print("Enter food name: ");
            String name = sc.nextLine();
            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            bw.write(name + " - Rs." + price);
            bw.newLine();
            System.out.println("Food item added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to menu file.");
        }
    }

    
    static void viewMenu() {
        try (BufferedReader br = new BufferedReader(new FileReader(MENU_FILE))) {
            String line;
            System.out.println("\n--- HOTEL MENU ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Menu file not found.");
        }
    }

    
    static void placeOrder(Scanner sc) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ORDER_FILE, true))) {
            System.out.print("Enter your name: ");
            String customer = sc.nextLine();
            System.out.print("Enter food item: ");
            String food = sc.nextLine();

            bw.write("Customer: " + customer + ", Order: " + food);
            bw.newLine();
            System.out.println("Order placed successfully.");
        } catch (IOException e) {
            System.out.println("Error writing order file.");
        }
    }

    
    static void viewOrders() {
        try (BufferedReader br = new BufferedReader(new FileReader(ORDER_FILE))) {
            String line;
            System.out.println("\n--- ORDERS LIST ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Order file not found.");
        }
    }
}

