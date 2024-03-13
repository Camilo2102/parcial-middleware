package co.com.parcial.middlewaregraphql.records;

import java.util.List;

public record DepartmentData(
        String _id,
        String department_name,
        String description,
        List<String> employees,
        int __v
) {
}
