package com.academy.model.service;

import java.io.IOException;

public interface DefaultService<T>{
    T create() throws IOException;

    T update();

    T delete();
    void findAll ();
    void findById() throws IOException;
}

