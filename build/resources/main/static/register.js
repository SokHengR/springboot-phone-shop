document.getElementById("registerForm").addEventListener("submit", async function (event) {
    event.preventDefault(); // Prevent the form from submitting the traditional way

    const username = document.getElementById("name").value;
    const address = document.getElementById("address").value;
    const phone_number = document.getElementById("phone").value;
    const password = document.getElementById("password").value;

    // Prepare the form data in URL-encoded format
    const formData = new URLSearchParams();
    formData.append("username", username);
    formData.append("address", address);
    formData.append("phone_number", phone_number);
    formData.append("password", password);

    try {
        const response = await fetch("/register", {
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
                window.location.href = "/register/success"
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