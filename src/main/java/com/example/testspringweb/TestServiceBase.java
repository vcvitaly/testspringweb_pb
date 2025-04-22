package com.example.testspringweb;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class TestServiceBase implements TestService {

    @Override
    public Dto<byte[]> getByteDto() {
        return new Dto<>(ArrayEncoder.encodeIntsToBytes(getIntArray(), false));
    }

    @Override
    public Dto<IntArrayList> getIntDto() {
        int[] encoded = ArrayEncoder.encode(getIntArray(), false);
        return new Dto<>(new IntArrayList(encoded));
    }

    private int[] getIntArray() {
        return IntStream.range(0, 100).toArray();
    }
}
