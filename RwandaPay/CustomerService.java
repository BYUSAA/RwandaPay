@Service
public class CustomerService {

    private static final String VALID_PIN = "2465";
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getProfile(String phoneNumber, String pin) {
        validatePin(pin);
        return customerRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public double getBalance(String phoneNumber, String pin) {
        validatePin(pin);
        Customer customer = customerRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customer.getBalance();
    }

    public void sendMoney(String senderPhone, String receiverPhone, double amount, String pin) {
        validatePin(pin);
        Customer sender = customerRepository.findByPhoneNumber(senderPhone)
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        Customer receiver = customerRepository.findByPhoneNumber(receiverPhone)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        if (sender.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        customerRepository.save(sender);
        customerRepository.save(receiver);
    }

    private void validatePin(String pin) {
        if (!VALID_PIN.equals(pin)) {
            throw new RuntimeException("Invalid PIN");
        }
    }
}
