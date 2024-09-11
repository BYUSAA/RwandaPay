@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private int pin;
    private double balance;

    public Customer() {}

    public Customer(String name, String phoneNumber, int pin, double balance) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.pin = pin;
        this.balance = balance;
    }

    // Getters and Setters
}
