package com.example.testspringweb;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@Slf4j
@RestController
@RequestMapping("/v1")
public class TestControllerV1 {

    private final TestService testService;

    public TestControllerV1(TestService testService) {
        this.testService = testService;
        log.info("TestControllerV1 started");
    }

    @GetMapping("/hello-bytes")
    public Dto<?> helloBytes(@RequestParam("limit") int limit) {
        return testService.getByteDto(limit);
    }

    @GetMapping(value = "/just-bytes", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String justBytes(@RequestParam("limit") int limit) {
        return Base64.getEncoder().encodeToString(testService.getByteDto(limit).data());
    }

    @GetMapping("/hello-ints")
    public Dto<?> helloInts(@RequestParam("count") int count) {
        return testService.getIntDto(count);
    }
}
