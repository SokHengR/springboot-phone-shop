// Get authToken from cookies
function getCookie2(name) {
    const cookieName = `${name}=`;
    const cookies = document.cookie.split(';');
    
    for (let i = 0; i < cookies.length; i++) {
        let cookie = cookies[i].trim();
        
        if (cookie.startsWith(cookieName)) {
            return decodeURIComponent(cookie.substring(cookieName.length));
        }
    }
    
    return null;
}

// Init default data as an array
const userData = [];
let userAuthToken = getCookie2("authToken");

// Request data
async function loadUserData() {
    const formData = new URLSearchParams();
    formData.append("auth_token", userAuthToken);

    try {
        const response = await fetch("/user", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: formData.toString()
        });

        if (response.ok) {
            const data = await response.json();
            userData.splice(0, userData.length, ...data); // Update userData array
            renderUserInfo(userData[0]); // Render only the first user
        } else {
            try {
                const errorData = await response.json();
                alert("Failed to load user data: " + JSON.stringify(errorData));
            } catch {
                alert("Failed to load user data: Unexpected error.");
            }
        }
    } catch (error) {
        console.error("Error:", error);
        alert("An error occurred while loading user data. Please try again later.");
    }
}

// Function to create and render user info
function renderUserInfo(user) {
    const profileContent = document.getElementById('profileContent');

    if (!profileContent) {
        console.error("Profile content element not found");
        return;
    }

    if (!user) {
        profileContent.innerHTML = "<p>No user data available.</p>";
        return;
    }

    // Create profile info HTML
    const infoHTML = `
        <div class="profile-info">
            <div class="info-item">
                <div class="info-label">Name</div>
                <div class="info-value">${user.name || "N/A"}</div>
            </div>
            <div class="info-item">
                <div class="info-label">Address</div>
                <div class="info-value">${user.address || "N/A"}</div>
            </div>
            <div class="info-item">
                <div class="info-label">Phone Number</div>
                <div class="info-value">${user.phone_number || "N/A"}</div>
            </div>
        </div>
    `;

    profileContent.innerHTML = infoHTML;
}

// Button handler functions
function handleEditProfile() {
    window.location.href = "/user/edit";
}

function handleChangePassword() {
    window.location.href = "/user/password";
}

function handleLogout() {
    window.location.href = "/logout";
}

// Call the function to load user data
loadUserData();
