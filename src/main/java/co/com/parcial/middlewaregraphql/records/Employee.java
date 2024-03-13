package co.com.parcial.middlewaregraphql.records;

import co.com.parcial.middlewaregraphql.services.DepartmentService;
import co.com.parcial.middlewaregraphql.services.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.reactive.function.client.WebClient;

public record Employee(String id, String name, String lastName, String role) {
    static private EmployeeService employeeService = new EmployeeService(WebClient.builder());
    public Employee() {
        this(null, null, null, null);
    }

    public Employee(String id) {
        this(id,null, null, null);
    }

    public Employee(String id, String name, String lastName, String role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.role = role;
    }

    public Employee(String name, String lastName, String role) {
        this(null, name, lastName, role);
    }

    static public EmployeeData findByEmployeeId(String id) throws JsonProcessingException {
        return employeeService.getById(id);
    }

    static public EmployeeData[] findEmployees() throws JsonProcessingException {
        return employeeService.getAll();
    }

    public static EmployeeData saveEmployee(Employee employee) throws JsonProcessingException {
        return employeeService.save(employee);
    }
}
