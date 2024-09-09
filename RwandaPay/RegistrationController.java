@RestController
@RequestMapping("/api/v1")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            userService.registerUser(userDTO);
            return ResponseEntity.ok("Registration successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Registration failed");
        }
    }
     catch (error) {
    console.error('Registration Error:', error); // Log the error to the console
    document.getElementById('registration-error').textContent = 'Error: Unable to register.';
}

}
