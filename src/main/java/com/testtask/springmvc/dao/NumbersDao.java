package com.testtask.springmvc.dao;

import com.testtask.springmvc.model.Numbers;

public interface NumbersDao {
    Numbers findById(int id);

    void save(Numbers numbers);
}
