package com.example.testspringweb;

import it.unimi.dsi.fastutil.ints.IntArrayList;

public interface TestService {
    Dto<byte[]> getByteDto(int count);

    Dto<IntArrayList> getIntDto(int count);
}
