package testHibernate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import testHibernate.dao.CarDAO;
import testHibernate.dao.PersonDAO;
import testHibernate.model.Car;
import testHibernate.model.Person;

import java.text.ParseException;

@Controller
public class CarsController {

    @Autowired
    CarDAO carDAO;

    @Autowired
    PersonDAO personDAO;

    @RequestMapping(value = "/listCars", method = RequestMethod.GET)
    public String hello(Model model) {

        try {
            model.addAttribute("cars", carDAO.getAllCars());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "carsList";
    }

    @RequestMapping(value = "/add-new-car", method = RequestMethod.GET)
    public String add(Model model){
        Car car = new Car();
        model.addAttribute("car", car);
        return "addNewCar";
    }

    @RequestMapping(value="/add-new-car", method=RequestMethod.POST)
    public String addNewCar(@ModelAttribute("car") Car car, BindingResult bindingResult) {
        for( FieldError fieldError : bindingResult.getFieldErrors() )
            System.out.println(fieldError.getField() +" : "+fieldError.getDefaultMessage());
        personDAO.setCar(car);


        try {
            carDAO.addCar(car);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
