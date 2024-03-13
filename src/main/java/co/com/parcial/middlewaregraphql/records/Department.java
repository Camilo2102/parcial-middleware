package co.com.parcial.middlewaregraphql.records;

import co.com.parcial.middlewaregraphql.services.DepartmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.reactive.function.client.WebClient;


public record Department(String id, String departmentName, String description, Employee[] employees) {

    static private DepartmentService departmentService = new DepartmentService(WebClient.builder());

    public Department() {
        this(null, null, null, null);
    }

    public Department(String id) {
        this(id,null, null, null);
    }

    static public DepartmentData findByDepartmentId(String id) throws JsonProcessingException {
        return departmentService.getById(id);
    }

}
