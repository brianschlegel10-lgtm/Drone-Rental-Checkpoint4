import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int u_id;
    private String phone;
    private String name;
    private String start_date;
    private String billing_address;
    private String password;
    private String distance;
    private String email;

    // Single source of truth for customers
    public static final List<Customer> customerList = new ArrayList<>();

    public Customer(int u_id, String phone, String name, String start_date,
                    String billing_address, String password, String distance, String email) {
        this.u_id = u_id;
        this.phone = phone;
        this.name = name;
        this.start_date = start_date;
        this.billing_address = billing_address;
        this.password = password;
        this.distance = distance;
        this.email = email;
    }

    // Getters
    public int getCustomerId() { return u_id; }
    public String getPhone() { return phone; }
    public String getName() { return name; }
    public String getStartDate() { return start_date; }
    public String getBillingAddress() { return billing_address; }
    public String getPassword() { return password; }
    public String getDistance() { return distance; }
    public String getEmail() { return email; }

    // Setters
    public void setCustomerId(int u_id) { this.u_id = u_id; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setName(String name) { this.name = name; }
    public void setStartDate(String start_date) { this.start_date = start_date; }
    public void setBillingAddress(String billing_address) { this.billing_address = billing_address; }
    public void setPassword(String password) { this.password = password; }
    public void setDistance(String distance) { this.distance = distance; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Customer{" +
                "u_id=" + u_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", start_date='" + start_date + '\'' +
                ", billing_address='" + billing_address + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
