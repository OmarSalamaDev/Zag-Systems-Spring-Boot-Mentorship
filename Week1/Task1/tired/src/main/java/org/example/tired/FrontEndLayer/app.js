const apiUrl = 'http://localhost:8080/api/employees';

async function fetchEmployees() {
    const response = await fetch(apiUrl);
    const employees = await response.json();
    displayEmployees(employees);
    console.log(employees);
}

function displayEmployees(employees) {
    const employeeList = document.getElementById('employee-list');
    employeeList.innerHTML = "";

    employees.forEach(emp => {
        const item = `
            <div class="item-container" id="${emp.id}">
                <span class="item">${emp.name}</span>
                <span class="item">${emp.department}</span>
                <span class="item">${emp.salary}</span>
                <span>
                    <span class="material-symbols-outlined delete-icon" onclick="deleteEmployee(${emp.id})">delete</span>
                </span>
            </div>
        `;
        employeeList.innerHTML += item;
    });
}

async function addEmployee() {
    const name = document.getElementById('name').value;
    const department = document.getElementById('department').value;
    const salary = document.getElementById('salary').value;

    const employee = { name, department, salary };

    await fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(employee)
    });

    await fetchEmployees();
}
async function deleteEmployee(id) {

    await fetch(`${apiUrl}/${id}`, {
        method: 'DELETE'
    });

    await fetchEmployees();
}

// Fetch employees on page load
fetchEmployees().then(r => console.log('Employees fetched'));
