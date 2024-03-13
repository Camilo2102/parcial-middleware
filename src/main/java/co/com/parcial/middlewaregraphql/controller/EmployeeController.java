package co.com.parcial.middlewaregraphql.controller;

import co.com.parcial.middlewaregraphql.records.Department;
import co.com.parcial.middlewaregraphql.records.DepartmentData;
import co.com.parcial.middlewaregraphql.records.Employee;
import co.com.parcial.middlewaregraphql.records.EmployeeData;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    @QueryMapping
    public EmployeeData findEmployeeById(@Argument String id) throws JsonProcessingException {
        return Employee.findByEmployeeId(id);
    }

    @QueryMapping
    public EmployeeData[] findEmployees() throws JsonProcessingException {
        return Employee.findEmployees();
    }
}
