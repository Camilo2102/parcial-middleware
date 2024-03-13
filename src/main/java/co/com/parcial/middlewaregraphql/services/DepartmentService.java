package co.com.parcial.middlewaregraphql.services;

import co.com.parcial.middlewaregraphql.records.DepartmentData;
import co.com.parcial.middlewaregraphql.records.DepartmentResponse;
import co.com.parcial.middlewaregraphql.records.Department;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
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
}
