package com.testtask.springmvc.controller;

import com.testtask.springmvc.model.Numbers;
import com.testtask.springmvc.service.NumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class NumbersController {

    @Autowired
    NumbersService numbersService;

    @RequestMapping(value = {"/","/resolvetask"}, method = RequestMethod.GET)
    public String newNumbers(ModelMap model) {
        Numbers numbers = new Numbers();
        model.addAttribute("numbers", numbers);
        model.addAttribute("edit", false);
        return "task";
    }

    @RequestMapping(value = {"/","/resolvetask"}, method = RequestMethod.POST)
    public String saveNumbers(Numbers numbers,
                              ModelMap model) {

        if (numbersService.isRadicandLessThanZero(numbers.getNumbA(),
                                                  numbers.getNumbB(),
                                                  numbers.getNumbC()))
        {/*
            return String.valueOf(ResponseEntity.badRequest()
                    .body("There is no roots"));*/
            model.addAttribute("fail",
                    "Quadratic equation can not be resolved.");
            return "exception";
        } else {
            Double aD = numbersService.aD(numbers.getNumbA(), numbers.getNumbB(), numbers.getNumbC());
            Double x1 = numbersService.root1(numbers.getNumbA(), numbers.getNumbB(), aD);
            Double x2 = numbersService.root2(numbers.getNumbA(), numbers.getNumbB(), aD);

            numbers.setRootX1(x1);
            numbers.setRootX2(x2);

            numbersService.saveNumbers(numbers);

            model.addAttribute("success", "Quadratic equation is resolved. " +
                    "Roots of quadratic equation " +
                    numbers.getNumbA() + "x^2 " +
                    numbers.getNumbB() + "b +" +
                    numbers.getNumbC() + " are: x1 = " +
                    numbers.getRootX1() + " and x2 = " +
                    numbers.getRootX2());
            return "answer";
        }
    }
}
