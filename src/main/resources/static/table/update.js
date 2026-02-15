import { setDeleteRowCell } from '/table/delete.js';

export { updateTable };


// Receive data
async function updateTable(getUrl, deleteRowUrl) {
    try {
        const response = await fetch(getUrl, {
            method: 'GET',
        })
        // Turn the response into json
        .then((response) => {
            return response.json();
        });

        writeToTable(response, deleteRowUrl);
        addFooterRow();
    } catch (e) {
        console.error(e);
    }
}


// Writing to the table
function writeToTable(items, deleteRowUrl) {
    const tBody = document.querySelector('tbody');

    // Goes through each item and adds their values to the row
    for (let i = 0; i < items.length; i++) {
        const item = items[i];
        const row = document.createElement('tr');

        const names = getTableColumnNames();
        for (let i = 0; i < names.length; i++) {
            // Make the first element a header cell
            let element = 'td';
            if (i === 0) {
                element = 'th';
            }

            const name = names[i];
            addElement(row, item[name], element);
        }

        setDeleteRowCell(row, item.id, deleteRowUrl);

        // Add the row to the table
        tBody.appendChild(row);
    }
}


// Helper functions
function addElement(row, text, elementName) {
    // th OR td
    const element = document.createElement(elementName);
    element.textContent = text;

    row.appendChild(element);

    return element;
}

function getTableColumnNames() {
    const columnNameCells = document.querySelectorAll('thead tr th');

    const columnNames = [];
    for (const cell of columnNameCells) {
        let columnName = cell.textContent;
        columnName = cleanName(columnName);

        columnNames.push(columnName);
    }

    return columnNames;
}

function cleanName(columnName) {
    // Removes brackets
    columnName = columnName.replace(/ *\([^)]*\) */g, "");

    // Turns string into camelCase
    columnName = columnName
        .toLowerCase()
        .replace(/[^a-zA-Z0-9]+(.)/g, (m, chr) => chr.toUpperCase());

    return columnName;
}

// This updates the footer span based on how many columns there are
// So if the columns ever change you don't also have to change the colspan
function addFooterRow() {
    const footRow = document.querySelector('table tfoot tr');
    const cell = document.createElement('td');

    const footerLength = getTableColumnNames().length;
    cell.setAttribute('colspan', footerLength);

    footRow.appendChild(cell);
}