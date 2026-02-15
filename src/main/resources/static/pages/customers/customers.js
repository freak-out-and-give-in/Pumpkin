import { updateTable } from "/table/update.js";
import { createForm, addLabelAndInput, addLabelAndSelectInput, addSubmitInput } from "/table/form.js";


// Loading the table from the database
updateTable('/customers/getCustomers', '/customers/deleteCustomer');


// Loading the form
createForm('/customers/addCustomer');
addLabelAndInput('name', 'Name', 'D\'arcy Wretzky');
addLabelAndSelectInput('membership', 'Membership', 'No', 'Yes');
addLabelAndInput('membershipDateBought', 'Membership date bought (YYYY-MM-DD)', '2021-06-21');
addLabelAndInput('totalAmountPurchased', 'Total amount purchased (£)', 238.32);
addLabelAndInput('totalAmountRefunded', 'Total amount refunded (£)', 0);
addLabelAndInput('complaints', 'Complaints', '');
addLabelAndInput('employeeComments', 'Employee comments', '');
addLabelAndSelectInput('ban', 'Ban', 'No', 'Yes');
addSubmitInput();