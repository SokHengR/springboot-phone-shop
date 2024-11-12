document.getElementById("loginForm").addEventListener("submit", async function (event) {
    event.preventDefault(); // Prevent the form from submitting the traditional way

    const phone_number = document.getElementById("phone_number").value;
    const password = document.getElementById("password").value;

    // Prepare the form data in URL-encoded format
    const formData = new URLSearchParams();
    formData.append("phone_number", phone_number);
    formData.append("password", password);

    try {
        const response = await fetch("/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: formData.toString() // Send as URL-encoded form data
        });

        if (response.ok) {
            // Handle successful login
            const data = await response.json();
            if (JSON.stringify(data.status) == "\"success\"") {
                saveAuthToken(JSON.stringify(data.message));
                window.location.href = "/home"
            } else {
                alert(JSON.stringify(data.message));
            }

        } else {
            // Handle failed login
            const errorData = await response.json();
            alert("Login failed: " + JSON.stringify(errorData)); // Display error message
        }
    } catch (error) {
        console.error("Error:", error);
        alert("An error occurred while logging in. Please try again later.");
    }
});

function saveAuthToken(token) {
    const cookieName = "authToken";
    const expires = new Date();
    expires.setTime(expires.getTime() + (30 * 24 * 60 * 60 * 1000)); // Cookie expires in 30 days
    document.cookie = `${cookieName}=${encodeURIComponent(token)};expires=${expires.toUTCString()};path=/`;
}
