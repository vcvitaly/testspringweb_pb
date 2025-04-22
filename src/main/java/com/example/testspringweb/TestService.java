package com.example.testspringweb;

import it.unimi.dsi.fastutil.ints.IntArrayList;

public interface TestService {
    Dto<byte[]> getByteDto();

    Dto<IntArrayList> getIntDto();
}
