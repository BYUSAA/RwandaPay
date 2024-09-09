@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(UserDTO userDTO) throws InvalidDataException {
        // Validate and save user data
        if (userRepository.existsByPhone(userDTO.getPhone())) {
            throw new InvalidDataException("Phone number already registered");
        }
        User user = new User();
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setPin(userDTO.getPin());
        userRepository.save(user);
    }
}
