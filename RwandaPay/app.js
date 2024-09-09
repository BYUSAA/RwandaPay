// Base URL of the backend API (adjust as per your server configuration)
const BASE_URL = 'http://localhost:8080/api/v1';

// Registration Form Handler
document.getElementById('registration-form')?.addEventListener('submit', async (event) => {
    event.preventDefault();
    const name = document.getElementById('name').value;
    const phone = document.getElementById('phone').value;
    const pin = document.getElementById('pin').value;

    try {
        const response = await fetch(`${BASE_URL}/register`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ name, phone, pin })
        });

        const result = await response.json();

        if (response.ok) {
            document.getElementById('registration-success').textContent = 'Registration successful! Please log in.';
            setTimeout(() => {
                window.location.href = 'login.html';
            }, 2000);
        } else {
            document.getElementById('registration-error').textContent = result.message || 'Error: Registration failed.';
        }
    } catch (error) {
        document.getElementById('registration-error').textContent = 'Error: Unable to register.';
    }
});

// Login Form Handler
document.getElementById('login-form')?.addEventListener('submit', async (event) => {
    event.preventDefault();
    const phone = document.getElementById('phone').value;
    const pin = document.getElementById('pin').value;

    try {
        const response = await fetch(`${BASE_URL}/login`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ phone, pin })
        });

        const result = await response.json();

        if (response.ok) {
            // Store user data in local storage for session management
            localStorage.setItem('user', JSON.stringify(result));
            window.location.href = 'dashboard.html'; // Redirect to the dashboard
        } else {
            document.getElementById('login-error').textContent = result.message || 'Invalid credentials.';
        }
    } catch (error) {
        document.getElementById('login-error').textContent = 'Error: Unable to log in.';
    }
});

// Check Balance Handler
document.getElementById('check-balance')?.addEventListener('click', async () => {
    const user = JSON.parse(localStorage.getItem('user'));
    if (!user) return alert('Please log in first.');

    try {
        const response = await fetch(`${BASE_URL}/balance?phone=${user.phone}`, {
            method: 'GET',
            headers: { 'Authorization': `Bearer ${user.token}` }
        });

        const result = await response.json();

        if (response.ok) {
            document.getElementById('balance-info').textContent = `Your balance is: ${result.balance} RWF`;
        } else {
            alert(result.message || 'Error: Unable to fetch balance.');
        }
    } catch (error) {
        alert('Error: Unable to fetch balance.');
    }
});

// Send Money Handler
document.getElementById('send-money-form')?.addEventListener('submit', async (event) => {
    event.preventDefault();
    const user = JSON.parse(localStorage.getItem('user'));
    if (!user) return alert('Please log in first.');

    const amount = document.getElementById('amount').value;
    const recipient = document.getElementById('recipient').value;
    const pin = document.getElementById('transaction-pin').value;

    try {
        const response = await fetch(`${BASE_URL}/send-money`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${user.token}`
            },
            body: JSON.stringify({ amount, recipient, pin })
        });

        const result = await response.json();

        if (response.ok) {
            alert('Money sent successfully!');
            document.getElementById('send-money-form').reset();
        } else {
            alert(result.message || 'Error: Transaction failed.');
        }
    } catch (error) {
        alert('Error: Unable to complete the transaction.');
    }
});

// Display Profile Info Handler
document.getElementById('view-profile')?.addEventListener('click', () => {
    const user = JSON.parse(localStorage.getItem('user'));
    if (user) {
        document.getElementById('profile-name').textContent = `Name: ${user.name}`;
        document.getElementById('profile-phone').textContent = `Phone: ${user.phone}`;
    } else {
        alert('Please log in to view your profile.');
    }
});
