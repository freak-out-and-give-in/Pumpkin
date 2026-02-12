// Global variables
const title = document.title;


// Create the classes
const logoClass = createHTMLClass(`
    <div class="logo">
        <img src="/static/base/logo/pumpkin.png" alt="pumpkin's logo">
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
            <img src="/static/base/navigation/dashboard.svg" alt="home icon">
            <a href="../dashboard/dashboard.html" class="button">Dashboard</a>
        </div>
        <div class="item">
            <img src="/static/base/navigation/inventory.svg" alt="inventory icon">
            <a href="../inventory/inventory.html" class="button">Inventory</a>
        </div>
        <div class="item">
            <img src="/static/base/navigation/purchases.svg" alt="purchases icon">
            <a href="../purchases/purchases.html" class="button">Purchases</a>
        </div>
        <div class="item">
            <img src="/static/base/navigation/sales.svg" alt="sales icon">
            <a href="../sales/sales.html" class="button">Sales</a>
        </div>
        <div class="item">
            <img src="/static/base/navigation/customers.svg" alt="customers icon">
            <a href="../customers/customers.html" class="button">Customers</a>
        </div>
        <div class="item">
            <img src="/static/base/navigation/suppliers.svg" alt="suppliers icon">
            <a href="../suppliers/suppliers.html" class="button">Suppliers</a>
        </div>
        <div class="item">
            <img src="/static/base/navigation/reports.svg" alt="reports icon">
            <a href="../reports/reports.html" class="button">Reports</a>
        </div>
        <div class="item">
            <img src="/static/base/navigation/settings.svg" alt="settings icon">
            <a href="../settings/settings.html" class="button">Settings</a>
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