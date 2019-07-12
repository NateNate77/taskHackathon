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
import testHibernate.exception.ExceptionDate;
import testHibernate.exception.ExceptionEmptyName;
import testHibernate.model.Person;
import testHibernate.model.PersonView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class HelloSpringMVC {

    @Autowired
    private PersonDAO personDAO;

    public static final SimpleDateFormat df2 = new SimpleDateFormat("dd.MM.yyyy");

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {

        try {
            List<PersonView> personViews = new ArrayList<PersonView>();
            List<Person> personList = personDAO.getAllPersons();

            for (int i = 0; i < personList.size(); i++){

                String dateBirth = df2.format(personList.get(i).getDateOfBirth());
                PersonView personView = new PersonView(personList.get(i).getId(), personList.get(i).getName(), dateBirth);
                personViews.add(personView);
            }
//            model.addAttribute("persons", personDAO.getAllPersons());
            model.addAttribute("persons", personViews);
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


    @RequestMapping(value="/add-new-person", method=RequestMethod.POST)
    public String addNewUser(@ModelAttribute("person") Person p, BindingResult bindingResult, Model model) throws Exception {
        for( FieldError fieldError : bindingResult.getFieldErrors() )
            System.out.println(fieldError.getField() +" : "+fieldError.getDefaultMessage());

        try {
            personDAO.addPerson(p);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        catch (ExceptionEmptyName e){
            model.addAttribute("logError", e.getMessage());
            return "addNewPerson";
        }

        catch (ExceptionDate e){

            model.addAttribute("logError2", e.getMessage());
            return "addNewPerson";
        }
        return "redirect:/";
    }


    @RequestMapping(value = "/delete-persons", method = RequestMethod.GET)
    public String delete(){

        ArrayList<Person> personsForDelete = new ArrayList<Person>();
        try {
            personsForDelete = (ArrayList<Person>) personDAO.getAllPersons();
        } catch (Exception e) {
            e.printStackTrace();
        }

        personDAO.deletePersons(personsForDelete);

        return "redirect:/hello";
    }

    @RequestMapping("/showCard/{id}")
    public String showPersonCard(@PathVariable("id") int id, Model model){

        Person person = personDAO.showCard(id);
        String dateBirth = df2.format(person.getDateOfBirth());
        PersonView personView = new PersonView(person.getId(), person.getName(), dateBirth);
        model.addAttribute("personDateBirth", personView.getDateOfBirtToString());
        model.addAttribute("person", personDAO.showCard(id));
        return "personsCard";
    }



}

