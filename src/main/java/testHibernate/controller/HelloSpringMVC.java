package testHibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import testHibernate.dao.PersonDAO;
import testHibernate.model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
//@RequestMapping("/hello")
public class HelloSpringMVC {

    @Autowired
    private PersonDAO personDAO;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {

        try {
            model.addAttribute("persons", personDAO.getAllPersons());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "helloworld";
    }

    @RequestMapping(value = "/add-new-person", method = RequestMethod.GET)
    public String add(Model model){
        Person person = new Person();
        model.addAttribute("person", person);
    return "addNewPerson";
    }

//    @RequestMapping(value="/add-new-person", method=RequestMethod.POST)
//    public String addNewUser(@RequestParam(value="name") String name, @RequestParam(value="dayOfBirth") String dayOfBirth) {
//
//        try {
//            dayOfBirth += " 00:00:00.00";
//            personDAO.addPerson(name, dayOfBirth);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return "redirect:/";
//    }

//    @ModelAttribute("person") Person p

//    @RequestMapping(value="/add-new-person", method=RequestMethod.POST)
////    public String addNewUser(@ModelAttribute("person") Person p) {
////
////        try {
////            personDAO.addPerson(p);
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
////        return "redirect:/";
////    }


    @RequestMapping(value="/add-new-person", method=RequestMethod.POST)
    public String addNewUser(@ModelAttribute("person") Person p, BindingResult bindingResult) {
        for( FieldError fieldError : bindingResult.getFieldErrors() )
            System.out.println(fieldError.getField() +" : "+fieldError.getDefaultMessage());


        try {
            personDAO.addPerson(p);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }


    @RequestMapping(value = "/delete-persons", method = RequestMethod.GET)
    public String delete(){
//        Person person = new Person();
//        model.addAttribute("person", person);
        ArrayList<Person> personsForDelete = new ArrayList<Person>();
        try {
            personsForDelete = (ArrayList<Person>) personDAO.getAllPersons();
        } catch (Exception e) {
            e.printStackTrace();
        }

        personDAO.deletePersons(personsForDelete);

        return "redirect:/hello";
    }


}

