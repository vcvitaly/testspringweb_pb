package com.example.testspringweb;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Slf4j
@Service
public class TestServiceBase implements TestService {

    public TestServiceBase() {
        log.debug("Created from {}", ExceptionUtils.getStackTrace(new RuntimeException("CONTEXT")));
    }

    @Override
    public Dto<byte[]> getByteDto(int count) {
        return new Dto<>(ArrayEncoder.encodeIntsToBytes(getIntArray(count), false));
    }

    @Override
    public Dto<IntArrayList> getIntDto(int count) {
        int[] encoded = ArrayEncoder.encode(getIntArray(count), false);
        return new Dto<>(new IntArrayList(encoded));
    }

    private int[] getIntArray(int count) {
        return IntStream.range(0, count).toArray();
    }
}
