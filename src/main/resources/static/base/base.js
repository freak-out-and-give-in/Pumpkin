// Global variables
const title = document.title;


// Create the classes
const logoClass = createHTMLClass(`
    <div class="logo">
        <img src="/base/logo/pumpkin.png" alt="Pumpkin's logo">
    </div class="logo">
`);

const headerClass = createHTMLClass(`
    <header>
        <span>${title}</span>
    </header>
`);

const navigationClass = createHTMLClass(`
    <nav>
        <div class="item">
            <img src="/base/navigation/dashboard.svg" alt="Home icon">
            <a href="/dashboard" class="button">Dashboard</a>
        </div>
        <div class="item">
            <img src="/base/navigation/inventory.svg" alt="Inventory icon">
            <a href="/inventory" class="button">Inventory</a>
        </div>
        <div class="item">
            <img src="/base/navigation/purchases.svg" alt="Purchases icon">
            <a href="/purchases" class="button">Purchases</a>
        </div>
        <div class="item">
            <img src="/base/navigation/sales.svg" alt="Sales icon">
            <a href="/sales" class="button">Sales</a>
        </div>
        <div class="item">
            <img src="/base/navigation/customers.svg" alt="Customers icon">
            <a href="/customers" class="button">Customers</a>
        </div>
        <div class="item">
            <img src="/base/navigation/suppliers.svg" alt="Suppliers icon">
            <a href="/suppliers" class="button">Suppliers</a>
        </div>
        <div class="item">
            <img src="/base/navigation/reports.svg" alt="Reports icon">
            <a href="/reports" class="button">Reports</a>
        </div>
        <div class="item">
            <img src="/base/navigation/settings.svg" alt="Settings icon">
            <a href="/settings" class="button">Settings</a>
        </div>
    </nav>
`);


// Helper functions
function createHTMLClass(html) {
    return class lorem extends HTMLElement {
        connectedCallback() {
            this.innerHTML = html;
        }
    }
}

// Creates the custom elements that can be used
function defineCustomElements() {
    customElements.define('main-logo', logoClass);
    customElements.define('main-header', headerClass);
    customElements.define('main-nav', navigationClass);
}


//
defineCustomElements();