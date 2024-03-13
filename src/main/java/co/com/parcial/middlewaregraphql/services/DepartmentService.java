package co.com.parcial.middlewaregraphql.services;

import co.com.parcial.middlewaregraphql.records.DepartmentData;
import co.com.parcial.middlewaregraphql.records.DepartmentMultiple;
import co.com.parcial.middlewaregraphql.records.DepartmentResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final WebClient.Builder webClientBuilder;

    public DepartmentData getById(String id) throws JsonProcessingException {

        String responseBody = this.webClientBuilder.build()
                .get()
                .uri("https://taller-d4cu.onrender.com/departments/" + id)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ObjectMapper objectMapper = new ObjectMapper();
        DepartmentResponse response = objectMapper.readValue(responseBody, DepartmentResponse.class);
        return response.data();
    }

    public DepartmentData[] getDepartmnets() throws JsonProcessingException{
        String responseBody = this.webClientBuilder.build()
                .get()
                .uri("https://taller-d4cu.onrender.com/departments")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        ObjectMapper objectMapper = new ObjectMapper();
        DepartmentMultiple response = objectMapper.readValue(responseBody, DepartmentMultiple.class);
        return response.data();
    }

    public DepartmentData deleteDepartmnet(String id) throws JsonProcessingException{
        String responseBody = this.webClientBuilder.build()
                .delete()
                .uri("https://taller-d4cu.onrender.com/departments/" + id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        ObjectMapper objectMapper = new ObjectMapper();
        DepartmentResponse response = objectMapper.readValue(responseBody, DepartmentResponse.class);
        return response.data();
    }

}
