@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        customerService.registerCustomer(customer);
        return ResponseEntity.ok("Customer registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestParam String phoneNumber, @RequestParam int pin) {
        customerService.login(phoneNumber, pin);
        return ResponseEntity.ok("Login successful.");
    }

    @GetMapping("/balance")
    public ResponseEntity<Double> getBalance(@RequestParam String phoneNumber) {
        double balance = customerService.getBalance(phoneNumber);
        return ResponseEntity.ok(balance);
    }

    @GetMapping("/profile")
    public ResponseEntity<Customer> getProfile(@RequestParam String phoneNumber) {
        Customer customer = customerService.getProfile(phoneNumber);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/send-money")
    public ResponseEntity<String> sendMoney(@RequestParam String senderPhone, @RequestParam int senderPin,
                                            @RequestParam double amount) {
        String response = customerService.sendMoney(senderPhone, senderPin, amount);
        return ResponseEntity.ok(response);
    }
}
