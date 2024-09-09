@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/profile")
    public ResponseEntity<Customer> getProfile(@RequestParam String phone, @RequestParam String pin) {
        return ResponseEntity.ok(customerService.getProfile(phone, pin));
    }

    @GetMapping("/balance")
    public ResponseEntity<Double> getBalance(@RequestParam String phone, @RequestParam String pin) {
        return ResponseEntity.ok(customerService.getBalance(phone, pin));
    }

    @PostMapping("/send-money")
    public ResponseEntity<String> sendMoney(
            @RequestParam String senderPhone, 
            @RequestParam String receiverPhone, 
            @RequestParam double amount, 
            @RequestParam String pin) {
        customerService.sendMoney(senderPhone, receiverPhone, amount, pin);
        return ResponseEntity.ok("Money sent successfully");
    }
}
