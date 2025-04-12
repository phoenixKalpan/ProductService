package org.phoenix13.productservice25.Client.AuthenticationClient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

public class AuthClient {
    private RestTemplateBuilder restTemplateBuilder;
    public AuthClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    /*public AuthClientDTO getAuthClientDTO(String token,String email) {
         RestTemplate restTemplate=restTemplateBuilder.build();
        AuthClientDTO authClientDTO = new AuthClientDTO();
        authClientDTO.setToken(token);
        authClientDTO.setEmail(email);
        restTemplate.postForEntity("https://localhost:5000/auth/Validate", authClientDTO, String.class);

    }*/
}
