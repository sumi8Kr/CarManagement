package com.example.CarManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.CarManagement.domain.Car;
import com.example.CarManagement.service.CarService;

@Controller
public class CarController {
    @Autowired
    private CarService service;

    @GetMapping("/getCars")
    public String getCars(Model model){
        List<Car> listcar =  service.listAll();
        model.addAttribute("listcar",listcar);
        System.out.print("Get / ");
        return "main";
    }
    @GetMapping("/")
    public String viewHomePage(Model model){
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("car", new Car());
        return "new";
    }

    @RequestMapping(value = "/saveCar", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("car") Car car){
        service.save(car);
        return "redirect:/getCars";
    }

    @RequestMapping("/editCar/{carId}")
    public ModelAndView showEditCarPage(@PathVariable(name="carId") Long carId){
        ModelAndView mav = new ModelAndView("new");
        Car car = service.get(carId);
        mav.addObject("car",car);
        return mav;
    }

    @RequestMapping("/deleteCar/{carId}")
    public String deleteCar(@PathVariable(name="carId") Long carId){
        service.delete(carId);
        return "redirect:/getCars";
    }
}
