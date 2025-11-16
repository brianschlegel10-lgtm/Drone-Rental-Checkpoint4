import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner IN = new Scanner(System.in); // do NOT close
        CustomerList cl = new CustomerList();
        EquipmentList el = new EquipmentList();

        boolean running = true;
        while (running) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Customers");
            System.out.println("2. Equipment");
            System.out.println("3. Rent (stub)");
            System.out.println("4. Return (stub)");
            System.out.println("5. Delivery (stub)");
            System.out.println("6. Pickup (stub)");
            System.out.println("7. Useful Reports (stub)");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            String raw = IN.nextLine().trim();
            switch (raw) {
                case "1" -> customersMenu(IN, cl);
                case "2" -> equipmentMenu(IN, el);
                case "3" -> { System.out.print("Member ID & Serial? "); System.out.println("Rented (stub)."); }
                case "4" -> { System.out.print("Serial? "); System.out.println("Returned (stub)."); }
                case "5" -> { System.out.print("Delivery details? "); System.out.println("Delivery scheduled (stub)."); }
                case "6" -> { System.out.print("Pickup details? "); System.out.println("Pickup scheduled (stub)."); }
                case "7" -> { System.out.println("Reports placeholder (stub)."); }
                case "0" -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
        // Intentionally not closing IN to avoid shutting System.in
    }

    private static void customersMenu(Scanner in, CustomerList cl) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Customers ---");
            System.out.println("1. Add");
            System.out.println("2. Edit");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            String c = in.nextLine().trim();
            switch (c) {
                case "1" -> cl.addCustomer(in);
                case "2" -> {
                    int id = readInt(in, "Enter id to edit: ");
                    cl.editCustomer(in, id);
                }
                case "3" -> {
                    int id = readInt(in, "Enter id to delete: ");
                    cl.removeCustomerById(id);
                }
                case "4" -> {
                    int id = readInt(in, "Enter id to search: ");
                    Customer found = cl.findCustomer(id);
                    if (found == null) System.out.println("Not found.");
                    else System.out.println(found);
                }
                case "0" -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void equipmentMenu(Scanner in, EquipmentList el) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Equipment ---");
            System.out.println("1. Add");
            System.out.println("2. Edit");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            String c = in.nextLine().trim();
            switch (c) {
                case "1" -> el.addEquipment(in);
                case "2" -> {
                    System.out.print("Enter serial to edit: ");
                    String s = in.nextLine().trim();
                    el.editEquipment(in, s);
                }
                case "3" -> {
                    System.out.print("Enter serial to delete: ");
                    String s = in.nextLine().trim();
                    el.removeEquipment(s);
                }
                case "4" -> {
                    System.out.print("Enter serial to search: ");
                    String s = in.nextLine().trim();
                    Equipment found = el.findEquipment(s);
                    if (found == null) System.out.println("Not found.");
                    else System.out.println(found);
                }
                case "0" -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static int readInt(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try { return Integer.parseInt(s); }
            catch (NumberFormatException e) { System.out.println("Invalid integer. Try again."); }
        }
    }
}
