package com.example.testspringweb;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class TestControllerV1 {

    private final TestService testService;

    @GetMapping("/hello-bytes")
    public Dto<?> helloBytes() {
        return testService.getByteDto();
    }

    @GetMapping(value = "/just-bytes", produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public byte[] justBytes() {
        return testService.getByteDto().data();
    }

    @GetMapping("/hello-ints")
    public Dto<?> helloInts(@RequestParam("count") int count) {
        return testService.getIntDto(count);
    }
}
