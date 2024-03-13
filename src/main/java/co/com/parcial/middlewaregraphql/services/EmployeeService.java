package co.com.parcial.middlewaregraphql.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class EmployeeService{
    private final WebClient.Builder webClientBuilder;
}
