package com.testtask.springmvc.controller;

import com.testtask.springmvc.model.Numbers;
import com.testtask.springmvc.service.NumbersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class NumbersController {
  private final NumbersService numbersService;

  @Autowired
  public NumbersController(NumbersService numbersService) {
    this.numbersService = numbersService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String newNumbers(ModelMap model) {
    Numbers numbers = new Numbers();
    model.addAttribute("numbers", numbers);
    model.addAttribute("edit", false);
    return "task";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String saveNumbers(Numbers numbers,
                            ModelMap model) {

    if (numbersService.isRadicandLessThanZero(numbers.getNumbA(),
        numbers.getNumbB(),
        numbers.getNumbC())) {
      model.addAttribute("fail",
          "Quadratic equation can not be resolved. " +
              "There are no roots for input coefficients");
      return "exception";
    }
    Double discriminant = numbersService.calcDiscriminant(numbers.getNumbA(), numbers.getNumbB(), numbers.getNumbC());
    Double x1 = numbersService.calcRoot1(numbers.getNumbA(), numbers.getNumbB(), discriminant);
    Double x2 = numbersService.calcRoot2(numbers.getNumbA(), numbers.getNumbB(), discriminant);

    numbers.setRootX1(x1);
    numbers.setRootX2(x2);

    numbersService.saveNumbers(numbers);

    model.addAttribute("success", "Quadratic equation is resolved. " +
        "Roots of " +
        numbers.getNumbA() + "x^2 " +
        numbers.getNumbB() + "b +" +
        numbers.getNumbC() + " = 0  are: x1 = " +
        numbers.getRootX1() + " and x2 = " +
        numbers.getRootX2());
    return "answer";
  }
}
