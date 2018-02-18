package com.testtask.springmvc.service;

import com.testtask.springmvc.dao.NumbersDao;
import com.testtask.springmvc.model.Numbers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NumbersServiceImpl implements NumbersService{

    @Autowired
    NumbersDao dao;

    @Override
    public Numbers findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveNumbers(Numbers numbers) {
        dao.save(numbers);

    }
}
