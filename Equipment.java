import java.util.Scanner;

public class Equipment {
    private String serialNum;
    private String warehouseId;
    private float weight;
    private float replacementCost;
    private float retailFee;
    private int rentalLimit = 0;
    private boolean stockStatus = true;
    private String description = "";

    public Equipment(String serialNum, String warehouseId, float weight, float replacementCost, float retailFee) {
        this.serialNum = serialNum;
        this.warehouseId = warehouseId;
        this.weight = weight;
        this.replacementCost = replacementCost;
        this.retailFee = retailFee;
    }

    public String getSerialNum() { return serialNum; }
    public String getWarehouseId() { return warehouseId; }
    public float getWeight() { return weight; }
    public float getReplacementCost() { return replacementCost; }
    public float getRetailFee() { return retailFee; }
    public int getRentalLimit() { return rentalLimit; }
    public boolean isStockStatus() { return stockStatus; }
    public String getDescription() { return description; }

    public void setWeight(float weight) { this.weight = weight; }
    public void setReplacementCost(float replacementCost) { this.replacementCost = replacementCost; }
    public void setRetailFee(float retailFee) { this.retailFee = retailFee; }
    public void setRentalLimit(int rentalLimit) { this.rentalLimit = rentalLimit; }
    public void setStockStatus(boolean stockStatus) { this.stockStatus = stockStatus; }

    // Simple interactive description input
    public void addDescription(Scanner in) {
        System.out.print("Enter description: ");
        this.description = in.nextLine();
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "serialNum='" + serialNum + '\'' +
                ", warehouseId='" + warehouseId + '\'' +
                ", weight=" + weight +
                ", replacementCost=" + replacementCost +
                ", retailFee=" + retailFee +
                ", rentalLimit=" + rentalLimit +
                ", stockStatus=" + stockStatus +
                ", description='" + description + '\'' +
                '}';
    }
}
