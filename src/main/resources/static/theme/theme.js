export { updateTheme };


function updateTheme() {
    let currentTheme = window.localStorage.getItem('data-theme');

    // If the user hasn't changed the theme yet,
    // this sets the default theme so the screen isn't devoid of colour
    if (currentTheme == null) {
        currentTheme = 'light';
    }

    const navigationTextName = '--navigation-text-color';
    const headerNavigationName = '--header-navigation-color';
    const navigationHighlightedName = '--navigation-highlighted-color';
    const mainBackgroundName = '--main-background-color';

    switch (currentTheme) {
        case "light": {
            changeColor(navigationTextName, '#F4F3F2');
            changeColor(headerNavigationName, 'rgb(23, 43, 54)');
            changeColor(navigationHighlightedName, 'rgb(18, 34, 43)');
            changeColor(mainBackgroundName, '#F4F3F2');
            break;
        }

        case "gloom": {
            changeColor(navigationTextName, 'green');
            changeColor(headerNavigationName, 'black');
            changeColor(navigationHighlightedName, 'brown');
            changeColor(mainBackgroundName, 'red');
            break;
        }

        case "harvest": {
            changeColor(navigationTextName, 'yellow');
            changeColor(headerNavigationName, 'green');
            changeColor(navigationHighlightedName, 'pink');
            changeColor(mainBackgroundName, 'orange');
            break;
        }
    }

    highlightCurrentNavigation();
}


// Helper functions
function changeColor(cssVariableName, color) {
    document.documentElement.style.setProperty(cssVariableName, color);
}

function highlightCurrentNavigation() {
    // To highlight on the navigation bar what section we're on:
    // Go through all the items, if their text content is equal to the title, then change background color
    // This works because the title is the same as the section the user is currently on (e.g. Dashboard === Dashboard)
    const items = document.querySelectorAll('div.item');
    const item = [...items].find((item) => item.getElementsByTagName("a")[0].textContent === title);

    // Getting the color from a css variable
    const backgroundColor = window.getComputedStyle(document.body).getPropertyValue('--navigation-highlighted-color');
    item.style.background = backgroundColor;
    item.style.borderRadius = '5%';
}


//
updateTheme();