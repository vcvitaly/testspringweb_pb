package com.example.testspringweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        classes = {TestspringwebApplication.class},
        properties = {
                "spring.main.lazy-initialization=true"
        }
)
public class PartialContextTest {

    @Autowired
    private TestControllerV1 controllerV1;

    @Test
    void test1() {
        Dto<?> dto = controllerV1.helloInts(5);
        System.out.println(dto);
    }
}
