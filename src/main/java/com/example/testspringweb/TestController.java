package com.example.testspringweb;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/hello-bytes")
    public Dto<?> helloBytes() {
        return testService.getByteDto();
    }

    @GetMapping(value = "/just-bytes", produces = {"application/json"})
    public byte[] justBytes() {
        return testService.getByteDto().data();
    }

    @GetMapping("/hello-ints")
    public Dto<?> helloInts() {
        return testService.getIntDto();
    }
}
