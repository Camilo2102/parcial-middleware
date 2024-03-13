package co.com.parcial.middlewaregraphql.controller;

import co.com.parcial.middlewaregraphql.records.Department;
import co.com.parcial.middlewaregraphql.records.DepartmentData;
import co.com.parcial.middlewaregraphql.services.DepartmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
    @QueryMapping
    public DepartmentData findDepartmentById(@Argument String id) throws JsonProcessingException {
        return Department.findByDepartmentId(id);
    }

    @QueryMapping
    public DepartmentData[] findDepartments() throws  JsonProcessingException{
        return Department.findDepartmnets();
    }
}
