import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EquipmentList {
    public static final List<Equipment> equipmentList = new ArrayList<>();

    public void addEquipment(Scanner in) {
        while (true) {
            System.out.print("Enter serial number: ");
            String serialNum = in.nextLine().trim();

            if (findEquipment(serialNum) != null) {
                System.out.println("Equipment with serial number " + serialNum + " already exists. Try again.");
                continue;
            }

            System.out.print("Enter warehouse ID: ");
            String warehouseId = in.nextLine().trim();

            float weight = readFloat(in, "Enter weight: ");
            float replacementCost = readFloat(in, "Enter replacement cost: ");
            float retailFee = readFloat(in, "Enter retail fee: ");

            Equipment equipment = new Equipment(serialNum, warehouseId, weight, replacementCost, retailFee);
            equipment.addDescription(in);

            equipmentList.add(equipment);
            System.out.println("Equipment " + equipment.getSerialNum() + " has been added.");
            break;
        }
    }

    public boolean removeEquipment(String serialNum) {
        boolean removed = equipmentList.removeIf(e -> e.getSerialNum().equalsIgnoreCase(serialNum));
        if (removed) {
            System.out.println("Item: " + serialNum + " has been removed.");
            return true;
        } else {
            System.out.println("Equipment: " + serialNum + " was not found. Try again.");
            return false;
        }
    }

    public Equipment findEquipment(String serialNum) {
        for (Equipment e : equipmentList) {
            if (e.getSerialNum().equalsIgnoreCase(serialNum)) {
                return e;
            }
        }
        return null;
    }

    public void editEquipment(Scanner in, String serialNum) {
        Equipment target = findEquipment(serialNum);
        if (target == null) {
            System.out.println("Equipment: " + serialNum + " was not found. Try again.");
            return;
        }

        boolean editing = true;
        while (editing) {
            System.out.println("\nEquipment Editing Menu");
            System.out.println("1. Weight");
            System.out.println("2. Replacement Cost");
            System.out.println("3. Retail Fee");
            System.out.println("4. Rental Limit");
            System.out.println("5. Set Stock Status");
            System.out.println("6. Description");
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
                case 1 -> { target.setWeight(readFloat(in, "Enter new weight: ")); System.out.println("Weight edited."); }
                case 2 -> { target.setReplacementCost(readFloat(in, "Enter new cost: ")); System.out.println("Replacement cost edited."); }
                case 3 -> { target.setRetailFee(readFloat(in, "Enter new retail fee: ")); System.out.println("Retail fee edited."); }
                case 4 -> { target.setRentalLimit(readInt(in, "Enter new rental limit: ")); System.out.println("Rental limit edited."); }
                case 5 -> {
                    boolean status = readYesNo(in, "Enter new stock status (y/n): ");
                    target.setStockStatus(status);
                    System.out.println("Stock status edited.");
                }
                case 6 -> { target.addDescription(in); System.out.println("Description updated."); }
                case 0 -> editing = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // helpers
    private float readFloat(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try { return Float.parseFloat(s); }
            catch (NumberFormatException e) { System.out.println("Invalid number. Try again."); }
        }
    }

    private int readInt(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try { return Integer.parseInt(s); }
            catch (NumberFormatException e) { System.out.println("Invalid integer. Try again."); }
        }
    }

    private boolean readYesNo(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim().toLowerCase();
            if (s.equals("y") || s.equals("yes")) return true;
            if (s.equals("n") || s.equals("no")) return false;
            if (s.equals("true") || s.equals("false")) return Boolean.parseBoolean(s);
            System.out.println("Please enter y/n (or true/false).");
        }
    }
}
