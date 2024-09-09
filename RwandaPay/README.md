RwandaPay - The Future of Digital Transactions in Rwanda 🌍💸
RwandaPay is a secure and user-friendly digital wallet system designed to simplify and streamline money transfers, balance checks, and profile management. Built with the powerful Java Spring Boot framework and backed by a robust PostgreSQL/MySQL database, RwandaPay offers seamless financial transactions with a focus on security and user experience.

Features 🚀
Send Money Instantly: Transfer funds quickly and securely between accounts.
Check Your Balance: Easily view your current balance in real time.
Manage Your Profile: Keep your personal information up-to-date.
PIN Authentication: Secure login and transactions with a validated PIN system.
Built for Scale: Designed with scalability and performance in mind using modern technologies.
Technology Stack 🛠️
Backend: Java Spring Boot
Database: PostgreSQL/MySQL
Frontend: HTML, CSS, JavaScript
Caching (Optional): Redis
Get Started 🏁
Clone the repository and follow the setup instructions to get RwandaPay running on your local machine. Whether you're a developer looking to contribute or a user seeking a simple financial solution, RwandaPay is built for you!

License 📄
RwandaPay is licensed under the MIT License, allowing you to freely use, modify, and distribute the software with proper attribution.




Project Overview
Endpoints to Implement:

Send Money: Transfer money between accounts.
My Balance: Display the current balance of the user.
My Profile: Display user profile information.
Authentication and Validation:

Use a fixed PIN (2465) for validation.
Validate user inputs, including the correct phone number and PIN.
Database Setup:

Use either PostgreSQL or MySQL to store customer data (phone number, name, balance).
Each user starts with an initial balance of 10,000,000 RWF.
Caching (Optional):

Redis can be used for caching frequently accessed data like user profiles or balances.
Step-by-Step Implementation
1. Project Setup
Start by setting up a Spring Boot project with dependencies for Spring Data JPA, the chosen database (PostgreSQL/MySQL), and Spring Web.

Maven Dependencies (pom.xml):