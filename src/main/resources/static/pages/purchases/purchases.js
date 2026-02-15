import { updateTable } from "/table/update.js";
import { createForm, addLabelAndInput, addLabelAndSelectInput, addSubmitInput } from "/table/form.js";


// Loading the table from the database
updateTable('/purchases/getPurchases', '/purchases/deletePurchase');


// Loading the form
createForm('/purchases/addPurchase');
addLabelAndSelectInput('supplier', 'Supplier', 'Rainbow Bird', 'Tagline', 'Modern');
addLabelAndInput('amountPurchased', 'Amount purchased (£)', 2304.98);
addLabelAndInput('time', 'Time (hh:mm:ss)', '14:49:04');
addLabelAndInput('date', 'Date (YYYY-MM-DD)', '2026-02-24');
addSubmitInput();