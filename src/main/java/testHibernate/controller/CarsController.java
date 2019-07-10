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
import testHibernate.exception.ExceptionEmptyName;
import testHibernate.model.AddCarRequest;
import testHibernate.model.Car;
import testHibernate.model.Person;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
//        model.addAttribute("person", personDAO.getAllPersons());
        model.addAttribute("person", personDAO.getAllAdultPerson());
        return "addNewCar";
    }

    @RequestMapping(value="/add-new-car", method=RequestMethod.POST)
    public String addNewCar(@ModelAttribute("carRequest") AddCarRequest carRequest, BindingResult bindingResult, Model model) throws Exception {
        for( FieldError fieldError : bindingResult.getFieldErrors() )
            System.out.println(fieldError.getField() +" : "+fieldError.getDefaultMessage());

        if(carRequest.getPersonID()==0){
            model.addAttribute("logErrorEmptyOwner", "Нельзя добавить автомобиль, так как в базе данных отсутствуют владельцы");
            return "addNewCar";
        }

        try {
            personDAO.setCarToPerson(carRequest, carRequest.getPersonID());
        }
        catch (ExceptionEmptyName e){
            model.addAttribute("logErrorEmptyName", e.getMessage());
            model.addAttribute("person", personDAO.getAllAdultPerson());
            return "addNewCar";
        }
        catch (Exception e) {
            model.addAttribute("logError", e.getMessage());
//            model.addAttribute("person", personDAO.getAllPersons());
            model.addAttribute("person", personDAO.getAllAdultPerson());
            return "addNewCar";
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String getStatistics(Model model) throws Exception {
//        List<String> manufacturers = carDAO.getManufacturer();
        model.addAttribute("manufacturers", carDAO.getManufacturer());
        model.addAttribute("cars", carDAO.getAllCars());
        model.addAttribute("persons", personDAO.getAllPersons());
    return "statistics";
    }
}
