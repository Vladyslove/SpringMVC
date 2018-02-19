package com.testtask.springmvc.dao;

import com.testtask.springmvc.model.Numbers;
import org.springframework.stereotype.Repository;

@Repository
public class NumbersDao extends AbstractDao<Numbers>{

    public void save(Numbers numbers) {
        persist(numbers);
    }
}
