@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByPhoneNumber(String phoneNumber);
}
