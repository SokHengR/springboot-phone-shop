// Product data array
var products = [];
let cart = [];
let filteredProducts = [];

// Fetch products on page load
async function fetchProducts() {
    try {
        const response = await fetch("/home", {
            method: "POST"
        });

        if (response.ok) {
            const data = await response.json();
            products = data;
            filteredProducts = [...products]; // Initialize filteredProducts with the fetched data
            renderProducts(); // Render products after data is loaded
        } else {
            const errorData = await response.json();
            alert("Home failed: " + JSON.stringify(errorData)); // Display error message
        }
    } catch (error) {
        console.error("Error:", error);
        alert("An error occurred while loading products. Please try again later.");
    }
}

// Function to generate star rating HTML
function generateStarRating(rating) {
    const fullStars = Math.floor(rating);
    const hasHalfStar = rating % 1 >= 0.5;
    let stars = '';

    for (let i = 0; i < fullStars; i++) {
        stars += '<i class="fas fa-star"></i>';
    }
    if (hasHalfStar) {
        stars += '<i class="fas fa-star-half-alt"></i>';
    }
    const emptyStars = 5 - Math.ceil(rating);
    for (let i = 0; i < emptyStars; i++) {
        stars += '<i class="far fa-star"></i>';
    }

    return stars;
}

// Function to render products
function renderProducts() {
    const productsGrid = document.getElementById('productsGrid');
    productsGrid.innerHTML = '';

    if (filteredProducts.length === 0) {
        productsGrid.innerHTML = '<div class="no-results">No products found</div>';
        return;
    }

    filteredProducts.forEach(product => {
        const productCard = `
            <div class="product-card">
                <img src="image/${product.id}.jpg" alt="${product.name}" class="product-image">
                <div class="product-info">
                    <div class="product-category">${product.brand_name}</div>
                    <h3 class="product-title">${product.name}</h3>
                    <p class="product-description">${product.detail}</p>
                    <div class="product-meta">
                        <p class="product-price">$${product.price.toFixed(2)}</p>
                        <div class="product-rating">
                            ${generateStarRating(product.star_count)}
                        </div>
                    </div>
                    <button class="add-to-cart" onclick="addToCart(${product.id})">
                        <i class="fas fa-shopping-cart"></i>
                        Add to Cart
                    </button>
                </div>
            </div>
        `;
        productsGrid.innerHTML += productCard;
    });
}

// Function to filter and sort products
function filterAndSortProducts() {
    const searchTerm = document.getElementById('searchInput').value.toLowerCase();
    const sortOption = document.getElementById('sortSelect').value;

    // Filter products
    filteredProducts = products.filter(product =>
        product.name.toLowerCase().includes(searchTerm) ||
        product.detail.toLowerCase().includes(searchTerm) ||
        product.brand_name.toLowerCase().includes(searchTerm)
    );

    // Sort products
    switch (sortOption) {
        case 'price-asc':
            filteredProducts.sort((a, b) => a.price - b.price);
            break;
        case 'price-desc':
            filteredProducts.sort((a, b) => b.price - a.price);
            break;
        case 'rating-desc':
            filteredProducts.sort((a, b) => b.star_count - a.star_count);
            break;
        case 'name-asc':
            filteredProducts.sort((a, b) => a.name.localeCompare(b.name));
            break;
        default:
            filteredProducts = [...products];
    }

    renderProducts();
}

// Function to add item to cart
function addToCart(productId) {
    const product = products.find(p => p.id === productId);
    if (product) {
        cart.push(product);
        updateCartCount();

        // Add animation to cart icon
        const cartIcon = document.querySelector('.cart-icon');
        cartIcon.style.transform = 'scale(1.2)';
        setTimeout(() => {
            cartIcon.style.transform = 'scale(1)';
        }, 200);
    }
}

// Function to update cart count
function updateCartCount() {
    const cartCount = document.querySelector('.cart-count');
    cartCount.textContent = cart.length;
}

// Event listeners
document.getElementById('searchInput').addEventListener('input', filterAndSortProducts);
document.getElementById('sortSelect').addEventListener('change', filterAndSortProducts);

// Initialize the page by fetching products
fetchProducts();
