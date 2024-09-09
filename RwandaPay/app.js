const BASE_URL = 'http://localhost:8080/api/v1'; // Adjust the base URL according to your backend configuration.

// Login Form Handler
document.getElementById('login-form')?.addEventListener('submit', async (event) => {
    event.preventDefault();
    const phone = document.getElementById('phone').value;
    const pin = document.getElementById('pin').value;
    // For now, simply redirect to dashboard; authentication checks can be added later
    localStorage.setItem('phone', phone);
    localStorage.setItem('pin', pin);
    window.location.href = 'dashboard.html';
});

// Send Money Form Handler
document.getElementById('send-money-form')?.addEventListener('submit', async (event) => {
    event.preventDefault();
    const senderPhone = document.getElementById('sender-phone').value;
    const receiverPhone = document.getElementById('receiver-phone').value;
    const amount = parseFloat(document.getElementById('amount').value);
    const pin = document.getElementById('pin').value;

    try {
        const response = await fetch(`${BASE_URL}/send-money`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ senderPhone, receiverPhone, amount, pin })
        });
        const result = await response.json();
        document.getElementById('send-money-success').textContent = result.message || 'Money sent successfully!';
    } catch (error) {
        document.getElementById('send-money-error').textContent = 'Error: Unable to send money.';
    }
});

// Balance Display Handler
window.onload = async function () {
    if (document.getElementById('balance-info')) {
        const phone = localStorage.getItem('phone');
        const pin = localStorage.getItem('pin');
        try {
            const response = await fetch(`${BASE_URL}/balance?phone=${phone}&pin=${pin}`);
            const balance = await response.json();
            document.getElementById('balance-info').textContent = `Your balance is: ${balance} RWF`;
        } catch (error) {
            document.getElementById('balance-info').textContent = 'Error: Unable
