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
import testHibernate.model.AddCarRequest;
import testHibernate.model.Car;
import testHibernate.model.Person;

import java.text.ParseException;
import java.util.ArrayList;

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
    public String add(Model model) throws Exception {
        AddCarRequest car = new AddCarRequest();
        model.addAttribute("carRequest", car);
        model.addAttribute("person", personDAO.getAllPersons());
        return "addNewCar";
    }

    @RequestMapping(value="/add-new-car", method=RequestMethod.POST)
    public String addNewCar(@ModelAttribute("carRequest") AddCarRequest carRequest, BindingResult bindingResult) {
        for( FieldError fieldError : bindingResult.getFieldErrors() )
            System.out.println(fieldError.getField() +" : "+fieldError.getDefaultMessage());

        personDAO.setCarToPerson(carRequest, carRequest.getPersonID());

        return "redirect:/";
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String getStatistics(Model model) throws Exception {
        model.addAttribute("cars", carDAO.getAllCars());
        model.addAttribute("persons", personDAO.getAllPersons());
    return "statistics";
    }
}
