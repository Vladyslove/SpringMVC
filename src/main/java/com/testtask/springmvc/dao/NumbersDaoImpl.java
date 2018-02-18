package com.testtask.springmvc.dao;

import com.testtask.springmvc.model.Numbers;
import org.springframework.stereotype.Repository;

@Repository
public class NumbersDaoImpl extends AbstractDao<Integer, Numbers> implements NumbersDao{

    @Override
    public Numbers findById(int id) {
        return getByKey(id);
    }

    @Override
    public void save(Numbers numbers) {
        persist(numbers);
    }
}
