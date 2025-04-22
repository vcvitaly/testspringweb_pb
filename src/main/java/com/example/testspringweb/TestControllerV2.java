package com.example.testspringweb;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
@RequiredArgsConstructor
public class TestControllerV2 {

    private final TestConsumerService testConsumerService;

    @GetMapping("/hello-ints")
    public Dto<int[]> helloInts() {
        return testConsumerService.getIntArrayDto();
    }
}
