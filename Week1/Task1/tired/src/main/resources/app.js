const apiUrl = 'http://localhost:8000/api/employees';
let selectedItemId = null;


//> fetch the api
async function fetchEmployees() {
    try {
        const response = await fetch(apiUrl);
        if (!response.ok) throw new Error('Failed to fetch employees');
        const employees = await response.json();
        displayEmployees(employees);
    } catch (error) {
        console.error('Error fetching employees:', error);
    }
}


//> display the items
function displayEmployees(employees) {
    const employeeList = document.getElementById('employee-list');
    employeeList.innerHTML = "";

    employees.forEach(emp => {
        const isEditable = selectedItemId === emp.id;
        const item = document.createElement('div');
        item.classList.add('item-container');
        item.id = emp.id;

        item.innerHTML = `
            <span class="item">
                <input
                    type="text"
                    id="${emp.id}-name"
                    value="${emp.name}"
                    class="editable ${isEditable ? 'enableEdit' : ''}"
                    ${isEditable ? '' : 'disabled'}
                />
            </span>
            <span class="item">
                <input
                    type="text"
                    id="${emp.id}-department"
                    value="${emp.department}"
                    class="editable ${isEditable ? 'enableEdit' : ''}"
                    ${isEditable ? '' : 'disabled'}
                />
            </span>
            <span class="item">
                <input
                    type="number"
                    id="${emp.id}-salary"
                    value="${emp.salary}"
                    class="editable hide-numbers-input-arrows ${isEditable ? 'enableEdit' : ''}"
                    ${isEditable ? '' : 'disabled'}
                />
            </span>
            <span class="item">
                ${isEditable ? `
                    <svg class="check-btn" onclick="submitEdit(${emp.id})" xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 24 24">
                        <path fill="currentColor" d="M10.6 16.6l7.05-7.05l-1.4-1.4l-5.65 5.65l-2.85-2.85l-1.4 1.4zM12 22q-2.075 0-3.9-.788t-3.175-2.137T2.788 15.9T2 12t.788-3.9t2.137-3.175T8.1 2.788T12 2t3.9.788t3.175 2.137T21.213 8.1T22 12t-.788 3.9t-2.137 3.175t-3.175 2.138T12 22"/>
                    </svg>
                    <svg class="cancel-btn" onclick="cancelEdit()" xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 24 24">
                        <path fill="currentColor" d="M8.4 17l3.6-3.6l3.6 3.6l1.4-1.4l-3.6-3.6L17 8.4L15.6 7L12 10.6L8.4 7L7 8.4l3.6 3.6L7 15.6zm3.6 5q-2.075 0-3.9-.788t-3.175-2.137T2.788 15.9T2 12t.788-3.9t2.137-3.175T8.1 2.788T12 2t3.9.788t3.175 2.137T21.213 8.1T22 12t-.788 3.9t-2.137 3.175t-3.175 2.138T12 22"/>
                    </svg>
                ` : `
                    <svg class="edit-icon" onclick="editEmployee(${emp.id})" xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 24 24">
                        <path fill="currentColor" d="M3 21v-4.25L16.2 3.575q.3-.275.663-.425t.762-.15t.775.15t.65.45L20.425 5q.3.275.438.65T21 6.4q0 .4-.137.763t-.438.662L7.25 21zM17.6 7.8L19 6.4L17.6 5l-1.4 1.4z"/>
                    </svg>
                    <svg class="delete-icon" onclick="deleteEmployee(${emp.id})" xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 24 24">
                        <path fill="currentColor" d="M7 21q-.825 0-1.412-.587T5 19V6q-.425 0-.712-.288T4 5t.288-.712T5 4h4q0-.425.288-.712T10 3h4q.425 0 .713.288T15 4h4q.425 0 .713.288T20 5t-.288.713T19 6v13q0 .825-.587 1.413T17 21zm3-4q.425 0 .713-.288T11 16V9q0-.425-.288-.712T10 8t-.712.288T9 9v7q0 .425.288.713T10 17m4 0q.425 0 .713-.288T15 16V9q0-.425-.288-.712T14 8t-.712.288T13 9v7q0 .425.288.713T14 17"/>
                    </svg>
                `}
            </span>
        `;

        employeeList.appendChild(item);
    });
}


//> add new item
async function addEmployee() {
    const name = document.getElementById('name').value;
    const department = document.getElementById('department').value;
    const salary = document.getElementById('salary').value;

    const employee = { name, department, salary };

    try {
        const response = await fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(employee)
        });
        if (!response.ok) throw new Error('Failed to add employee');
        await fetchEmployees();
    } catch (error) {
        console.error('Error adding employee:', error);
    }
}


//> delete item
async function deleteEmployee(id) {
    try {
        const response = await fetch(`${apiUrl}/${id}`, { method: 'DELETE' });
        if (!response.ok) throw new Error('Failed to delete employee');
        await fetchEmployees();
    } catch (error) {
        console.error('Error deleting employee:', error);
    }
}


//> edit item
async function editEmployee(id) {
    selectedItemId = id;
    await fetchEmployees(); // Updates UI to edit mode
}


//> cancel item edit
async function cancelEdit() {
    selectedItemId = null;
    await fetchEmployees(); // Reverts UI to view mode
}


//> submit the edit
async function submitEdit(id) {
    const name = document.getElementById(`${id}-name`).value;
    const department = document.getElementById(`${id}-department`).value;
    const salary = document.getElementById(`${id}-salary`).value;

    const updatedEmployee = { id, name, department, salary };

    console.log(updatedEmployee);
    try {
        const response = await fetch(`${apiUrl}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedEmployee)
        });
        if (!response.ok) throw new Error('Failed to update employee');
        selectedItemId = null;
        await fetchEmployees();
    } catch (error) {
        console.error('Error updating employee:', error);
    }

    selectedItemId = null;
    await fetchEmployees();
}


//> Fetch employees on page load
fetchEmployees()
