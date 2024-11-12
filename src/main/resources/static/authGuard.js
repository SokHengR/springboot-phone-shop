function getCookie(name) {
    const cookies = document.cookie.split("; ");
    for (let cookie of cookies) {
        let [key, value] = cookie.split("=");
        if (key === name) {
            return value;
        }
    }
    return null;
}

const authToken = getCookie("authToken");
const currentUrl = window.location.href;

if (authToken) {
    if (currentUrl.includes("/login")) {
        window.location.href = "/home";
    }
} else {
    if (currentUrl.includes("/login") == false) {
        window.location.href = "/login";
    }
}