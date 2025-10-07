package com.example.testspringweb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v2")
public class TestControllerV2 {

    private final TestConsumerService testConsumerService;

    public TestControllerV2(TestConsumerService testConsumerService) {
        /*try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        this.testConsumerService = testConsumerService;
        log.info("TestControllerV2 started");
    }

    @GetMapping("/hello-ints")
    public Dto<int[]> helloInts() {
        return testConsumerService.getIntArrayDto();
    }
}
