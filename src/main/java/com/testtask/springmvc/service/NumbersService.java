package com.testtask.springmvc.service;

import com.testtask.springmvc.model.Numbers;

public interface NumbersService {
    Numbers findById(int id);
    void saveNumbers(Numbers numbers);
}
