package com.testtask.springmvc.dao;

import com.testtask.springmvc.model.Numbers;
import org.springframework.stereotype.Repository;

@Repository
public class NumbersDao extends AbstractDao<Integer, Numbers>{

    public Numbers findById(int id) {
        return getByKey(id);
    }

    public void save(Numbers numbers) {
        persist(numbers);
    }
}
