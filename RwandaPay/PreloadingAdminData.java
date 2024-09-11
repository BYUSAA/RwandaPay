@Bean
CommandLineRunner initDatabase(CustomerRepository repository) {
    return args -> {
        repository.save(new Customer("Byussa", "+250780004298", 1234, 10000000.0));
    };
}
