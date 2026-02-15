export { setDeleteRowCell };


function setDeleteRowCell(row, id, url) {
    // The delete cell is the last cell in the row
    const deleteCell = row.querySelector('td:last-child');

    const deleteInput = createDeleteInput(id, url);
    deleteCell.appendChild(deleteInput);

    row.appendChild(deleteCell);
}

function createDeleteInput(id, url) {
    const input = document.createElement('input');
    input.type = 'button';
    input.value = 'Delete';

    // This submits the request to the backend
    input.addEventListener('click', (event) => {
        deleteRow(id, url);
    });

    return input;
}


// Delete data
async function deleteRow(id, url) {
    const formData = new FormData();
    formData.append('id', id);

    try {
        const response = await fetch(url, {
            method: 'DELETE',
            body: formData,
        });
    } catch (e) {
        console.error(e);
    }
}