import { updateTable } from "/table/update.js";
import { createForm, addLabelAndInput, addSubmitInput } from "/table/form.js";


// Loading the table from the database
updateTable('/inventory/getItems', '/inventory/deleteItem');


// Loading the form
createForm('/inventory/addItem');
addLabelAndInput('name', 'Name', 'Tomato Soup');
addLabelAndInput('wholesalePrice', 'Wholesale price (£)', 0.74);
addLabelAndInput('retailPrice', 'Retail price (£)', 1.49);
addLabelAndInput('amount', 'Amount (no. packs)', 48);
addLabelAndInput('quantity', 'Quantity (packs)', 12);
addLabelAndInput('weight', 'Weight (kg)', 0.43);
addSubmitInput();