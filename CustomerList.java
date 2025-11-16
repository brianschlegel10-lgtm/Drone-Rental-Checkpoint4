import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CustomerList {
    // Use a single store (the one in Customer)
    private List<Customer> list() { return Customer.customerList; }

    public void addCustomer(Scanner in) {
        int u_id = readInt(in, "Enter id: ");

        // prevent duplicates
        if (findCustomer(u_id) != null) {
            System.out.println("Customer with id " + u_id + " already exists. Try again.");
            return;
        }

        System.out.print("Enter phone: ");
        String phone = in.nextLine().trim();

        System.out.print("Enter name: ");
        String name = in.nextLine().trim();

        System.out.print("Enter start date: ");
        String start_date = in.nextLine().trim();

        System.out.print("Enter billing address: ");
        String billing_address = in.nextLine().trim();

        System.out.print("Enter password: ");
        String password = in.nextLine().trim();

        System.out.print("Enter distance: ");
        String distance = in.nextLine().trim();

        System.out.print("Enter email: ");
        String email = in.nextLine().trim();

        Customer c = new Customer(u_id, phone, name, start_date, billing_address, password, distance, email);
        list().add(c);
        System.out.println("Customer " + u_id + " added.");
    }

    public boolean removeCustomerById(int u_id) {
        Iterator<Customer> it = list().iterator();
        while (it.hasNext()) {
            Customer c = it.next();
            if (c.getCustomerId() == u_id) {
                it.remove();
                System.out.println("Customer: " + u_id + " has been removed.");
                return true;
            }
        }
        System.out.println("Customer: " + u_id + " was not found. Try again.");
        return false;
    }

    public Customer findCustomer(int u_id) {
        for (Customer c : list()) {
            if (c.getCustomerId() == u_id) {
                return c;
            }
        }
        return null;
    }

    public void editCustomer(Scanner in, int u_id) {
        Customer target = findCustomer(u_id);
        if (target == null) {
            System.out.println("Customer: " + u_id + " was not found. Try again.");
            return;
        }

        boolean editing = true;
        while (editing) {
            System.out.println("\nCustomer Editing Menu");
            System.out.println("1. Phone");
            System.out.println("2. Name");
            System.out.println("3. Start Date");
            System.out.println("4. Billing Address");
            System.out.println("5. Password");
            System.out.println("6. Distance");
            System.out.println("7. Email");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String raw = in.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(raw);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> { System.out.print("New phone: "); target.setPhone(in.nextLine().trim()); }
                case 2 -> { System.out.print("New name: "); target.setName(in.nextLine().trim()); }
                case 3 -> { System.out.print("New start date: "); target.setStartDate(in.nextLine().trim()); }
                case 4 -> { System.out.print("New billing address: "); target.setBillingAddress(in.nextLine().trim()); }
                case 5 -> { System.out.print("New password: "); target.setPassword(in.nextLine().trim()); }
                case 6 -> { System.out.print("New distance: "); target.setDistance(in.nextLine().trim()); }
                case 7 -> { System.out.print("New email: "); target.setEmail(in.nextLine().trim()); }
                case 0 -> editing = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // helpers
    private int readInt(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try { return Integer.parseInt(s); }
            catch (NumberFormatException e) { System.out.println("Invalid integer. Try again."); }
        }
    }
}
