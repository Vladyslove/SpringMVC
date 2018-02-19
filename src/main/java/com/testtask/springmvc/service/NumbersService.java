package com.testtask.springmvc.service;

import com.testtask.springmvc.model.Numbers;

public interface NumbersService {
    Numbers findById(int id);
    void saveNumbers(Numbers numbers);

    Boolean isRadicandLessThanZero(Integer numbA, Integer numbB, Integer numbC);

    Double aD(Integer a, Integer b, Integer c);

    Double root1(Integer numbA, Integer numbB, Double aD);

    Double root2(Integer numbA, Integer numbB, Double aD);
}
