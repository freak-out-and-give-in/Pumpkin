import { updateTheme } from "/theme/theme.js";

// Global variables
const form = document.querySelector('form');
const radioButtons = document.querySelectorAll('.setting input');


function addFormEventChange() {
    form.addEventListener('change', (event) => {
        setTheme();
    });
}

function setTheme() {
    const checkedButton = [...radioButtons].find((button) => button.checked);

    const buttonTheme = checkedButton.id;
    window.localStorage.setItem('data-theme', buttonTheme);

    updateTheme();
}

// If you go to another page and then come back to the settings, no button is checked
// This function checks the button who's theme is currently in use
function checkCurrentlyUsedButton() {
    const currentTheme = window.localStorage.getItem('data-theme');

    const currentlyInUseButton = [...radioButtons].find((button) => button.id === currentTheme);
    currentlyInUseButton.checked = true;
}


//
addFormEventChange();
checkCurrentlyUsedButton();