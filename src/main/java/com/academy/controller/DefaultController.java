package com.academy.controller;

import java.io.IOException;
import java.util.List;

public interface DefaultController <T>{
    T create() throws IOException;

    T update();

    T delete();
    void findAll ();
}

