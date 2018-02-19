package com.testtask.springmvc.service;

import com.testtask.springmvc.dao.NumbersDao;
import com.testtask.springmvc.model.Numbers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NumbersService {

    @Autowired
    NumbersDao dao;

    public Numbers findById(int id) {
        return dao.findById(id);
    }

    public void saveNumbers(Numbers numbers) {
        dao.save(numbers);
    }

    public Boolean isRadicandLessThanZero(Integer a, Integer b, Integer c) {
        return b * b - 4 * a * c < 0;
    }

    public Double aD(Integer a, Integer b, Integer c) {
        return Math.sqrt(b * b - 4 * a * c);
    }

    public Double root1(Integer a, Integer b, Double aD) {
        return (- b + aD) / 2 * a;
    }

    public Double root2(Integer a, Integer b, Double aD) {
        return (- b - aD) / 2 * a;
    }
}
