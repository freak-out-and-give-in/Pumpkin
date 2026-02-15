export { createForm, addLabelAndInput, addLabelAndSelectInput, addSubmitInput };


// Creating the form
function createForm(url) {
    const form = document.createElement('form');
    form.setAttribute('method', 'post');

    // This submits the form to the backend
    form.addEventListener('submit', (event) => {
        // preventDefault() "to prevent the browser's built-in form submission, so we can take over"
        event.preventDefault();
        sendData(url);

        removeDataFromForm();
    });

    const main = document.querySelector('.wrapper main');
    main.appendChild(form);
}


// Helper functions
function getForm() {
    return document.querySelector('form');
}

function addLabelAndInput(id, labelInp, placeholder) {
    const label = document.createElement('label');
    label.setAttribute('for', id);
    label.textContent = labelInp;

    const input = document.createElement('input');
    input.setAttribute('type', 'text');
    input.setAttribute('id', id);
    input.setAttribute('name', id);
    input.setAttribute('placeholder', placeholder);

    getForm().appendChild(label);
    getForm().appendChild(input);
}

function addLabelAndSelectInput(id, labelInp, ...optionNames) {
    const label = document.createElement('label');
    label.setAttribute('for', id);
    label.textContent = labelInp;

    const select = document.createElement('select');
    select.setAttribute('id', id);
    select.setAttribute('name', id);

    for (const optionName of optionNames) {
        const option = document.createElement('option');
        option.setAttribute('value', optionName);
        option.textContent = optionName;

        select.appendChild(option);
    }

    getForm().appendChild(label);
    getForm().appendChild(select);
}

function addSubmitInput() {
    const submitInput = document.createElement('input');
    submitInput.setAttribute('type', 'submit');
    submitInput.setAttribute('value', 'Add');

    getForm().appendChild(submitInput);
}

// This removes the data from the form after submitting,
// preventing double submits or having to manually remove the data
function removeDataFromForm() {
    // Loops through each of the form's inputs and sets their value to ''
    const inputs = getForm().querySelectorAll('input');

    for (const input of inputs) {
        const inputType = input.getAttribute('type');

        // Don't erase the text from the submit button
        if (inputType !== 'submit') {
            input.value = '';
        }
    }
}


// Sending data
async function sendData(url) {
    const formData = new FormData(getForm());

    try {
        const response = await fetch(url, {
            method: 'POST',
            body: formData,
        });
    } catch (e) {
        console.error(e);
    }
}