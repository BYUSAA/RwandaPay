@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer registerCustomer(Customer customer) {
        customer.setBalance(10000000.0);  // Initial balance
        return customerRepository.save(customer);
    }

    public Customer login(String phoneNumber, int pin) {
        return customerRepository.findByPhoneNumber(phoneNumber)
                .filter(c -> c.getPin() == pin)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    public double getBalance(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Customer not found"))
                .getBalance();
    }

    public Customer getProfile(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public String sendMoney(String senderPhone, int senderPin, double amount) {
        Customer sender = login(senderPhone, senderPin);
        if (sender.getBalance() >= amount) {
            sender.setBalance(sender.getBalance() - amount);
            customerRepository.save(sender);
            return "Money sent successfully.";
        } else {
            throw new RuntimeException("Insufficient balance.");
        }
    }
}
