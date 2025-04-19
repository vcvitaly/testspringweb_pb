package com.example.testspringweb;

import it.unimi.dsi.fastutil.ints.IntList;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class TestService {

    public Dto<byte[]> getByteDto() {
        return new Dto<>(ArrayEncoder.encodeIntsToBytes(getIntArray(), false));
    }

    public Dto<int[]> getIntDto() {
        return new Dto<>(ArrayEncoder.encode(getIntArray(), false));
    }

    private int[] getIntArray() {
        return IntStream.range(0, 100_000_000).toArray();
    }
}
