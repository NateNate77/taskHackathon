package testHibernate.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import testHibernate.exception.ExceptionDate;
import testHibernate.exception.ExceptionEmptyName;
import testHibernate.model.AddCarRequest;
import testHibernate.model.Car;
import testHibernate.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class PersonDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);


    @PersistenceContext(unitName = "testHibernate.person_catalog")
    private EntityManager em;

    @Transactional(value = "txManager")

    public List<Person> getAllPersons() throws SQLException, Exception {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> q = cb.createQuery(Person.class);
        Root<Person> root = q.from(Person.class);
        q.select(root);
        LOGGER.info("SELECT FROM TABLE PERSON!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        return em.createQuery(q).getResultList();
    }

    @Transactional(value = "txManager")
    public List<Person> getAllAdultPerson() throws Exception {

        //List<Person> adultPerson = em.createQuery("select p from Person p where p.age > 17", Person.class).getResultList();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> q = cb.createQuery(Person.class);
        Root<Person> root = q.from(Person.class);
        q.where(cb.greaterThan(root.<Integer>get("age"), 17));
        q.select(root);

        return em.createQuery(q).getResultList();

        //return adultPerson;
    }


    @Transactional(value = "txManager")
    public void addPerson(Person p) throws Exception {

        Date currentDate = new Date();

        if(currentDate.compareTo(p.getDateOfBirth())<1){

            throw new ExceptionDate("Дата рождения не может быть в будущем");
        }

        String namePerson = p.getName().trim();

        if(p.getName()==null || namePerson.equals("") || namePerson==null){

            throw new ExceptionEmptyName("Введите имя");
        }


        long ageInMillis = new Date().getTime() - p.getDateOfBirth().getTime();

        Date ageDate = new Date(ageInMillis);
        int age = ageDate.getYear() - 70;
        p.setAge(age);


        em.persist(p);
        LOGGER.info("ADD PERSON!!!!!!!!!!");

    }

    @Transactional(value = "txManager")
    public void deletePersons(ArrayList<Person> persons){

        for(int i = 0; i < persons.size(); i++){
            Person person = em.find(Person.class, persons.get(i).getId());
            em.remove(person);
        }
    }

    @Transactional(value = "txManager")
    public void setCarToPerson(AddCarRequest carRequest, int personID) throws Exception {

        String carVendor = carRequest.getVendor().replace("-", "").trim();
        String carModel = carRequest.getModel().trim();
        if(carVendor.equals("") || carModel.equals("")){
            throw new ExceptionEmptyName("Введите модель");
        }

        Car car = new Car(carVendor, carModel, carRequest.getHorsePower());

        if(car.getHorsepower()<=0){
            throw new Exception("Значение должно быть больше 0!");
        }
        em.persist(car);
        Person person = em.find(Person.class, personID);
//        car.setPerson(person);
        person.addCar(car);
        //ну такое
        car.setPerson(person);
    }

    @Transactional(value = "txManager")
    public Person showCard(int id){
        Person person = em.find(Person.class, id);
        return person;
    }

}
