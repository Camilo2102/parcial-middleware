package co.com.parcial.middlewaregraphql.records;

import co.com.parcial.middlewaregraphql.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public record Department(String departmentName, String description, Employee[] employees) {

    

    static public Department findByDepartmentId(String id){
        return new Department("", "", null);
    }

}
