const apiUrl = 'http://localhost:8080/api/employees';

async function fetchEmployees() {
    const response = await fetch(apiUrl);
    const employees = await response.json();
    displayEmployees(employees);
    console.log(employees);
}

function displayEmployees(employees) {
    const employeeList = document.getElementById('employee-list');
    employeeList.innerHTML = '';
    employees.forEach(emp => {
        employeeList.innerHTML += `<p>${emp.name} - ${emp.department} - ${emp.salary}</p>`;
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

// Fetch employees on page load
fetchEmployees().then(r => console.log('Employees fetched'));
