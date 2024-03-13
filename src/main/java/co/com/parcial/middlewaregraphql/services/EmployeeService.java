package co.com.parcial.middlewaregraphql.services;

import co.com.parcial.middlewaregraphql.records.EmployeeData;
import co.com.parcial.middlewaregraphql.records.EmployeeResponse;
import co.com.parcial.middlewaregraphql.records.MultipleEmployeeResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class EmployeeService{
    private final WebClient.Builder webClientBuilder;

    public EmployeeData getById(String id) throws JsonProcessingException {
        String responseBody = this.webClientBuilder.build()
                .get()
                .uri("https://taller-d4cu.onrender.com/employees/" + id)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeResponse response = objectMapper.readValue(responseBody, EmployeeResponse.class);

        return response.data();
    }

    public EmployeeData[] getAll() throws JsonProcessingException {
        String responseBody = this.webClientBuilder.build()
                .get()
                .uri("https://taller-d4cu.onrender.com/employees")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ObjectMapper objectMapper = new ObjectMapper();
        MultipleEmployeeResponse response = objectMapper.readValue(responseBody, MultipleEmployeeResponse.class);

        return response.data();
    }
}
