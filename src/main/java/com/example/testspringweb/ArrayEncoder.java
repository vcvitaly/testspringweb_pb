package com.example.testspringweb;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import me.lemire.integercompression.IntCompressor;
import me.lemire.integercompression.differential.IntegratedIntCompressor;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Objects;

@UtilityClass
public class ArrayEncoder {

    @Getter(lazy = true, value = AccessLevel.PRIVATE)
    private static final IntegratedIntCompressor integratedIntCompressor = new IntegratedIntCompressor();
    @Getter(lazy = true, value = AccessLevel.PRIVATE)
    private static final IntCompressor intCompressor = new IntCompressor();

    public static int[] encode(int[] data, boolean incrementalCompression) {
        return incrementalCompression ?
                getIntegratedIntCompressor().compress(data) : getIntCompressor().compress(data);
    }

    public static int[] decode(int[] compressedData, boolean incrementalCompression) {
        return incrementalCompression ?
                getIntegratedIntCompressor().uncompress(compressedData) : getIntCompressor().uncompress(compressedData);
    }

    public static byte[] encodeIntsToBytes(int[] data, boolean incrementalCompression) {
        Objects.requireNonNull(data);

        if (data.length == 0) {
            return new byte[0];
        }

        final int[] compressedData = encode(data, incrementalCompression);

        final ByteBuffer bb = ByteBuffer.allocate(compressedData.length * 4);
        final IntBuffer intBuffer = bb.asIntBuffer();
        intBuffer.put(compressedData);

        return bb.array();
    }

    public static int[] decodeBytesToInts(byte[] data, boolean incrementalCompression) {
        if (data.length == 0) {
            return new int[0];
        }

        final IntBuffer ib = ByteBuffer.wrap(data).asIntBuffer();
        int[] array = new int[ib.remaining()];
        for (int i = 0; i < array.length; i++) {
            array[i] = ib.get();
        }

        return decode(array, incrementalCompression);
    }
}
