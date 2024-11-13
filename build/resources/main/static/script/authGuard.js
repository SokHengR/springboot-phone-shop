function getCookie(name) {
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


const authToken = getCookie("authToken");
console.log(authToken);
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