package com.example.testspringweb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class TestConsumerServiceImpl implements TestConsumerService {

    private final RestClient restClient;

    public TestConsumerServiceImpl() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8001/v1")
                .build();
        log.info("TestConsumerServiceImpl started");
    }

    @Override
    public Dto<int[]> getIntArrayDto() {
        byte[] bytes = restClient.get()
                .uri("/just-bytes")
                .accept(MediaType.APPLICATION_OCTET_STREAM)
                .retrieve()
                .body(byte[].class);

        if (bytes == null) {
            throw new NullPointerException("bytes is null");
        }

        return new Dto<>(ArrayEncoder.decodeBytesToInts(bytes, false));
    }
}
