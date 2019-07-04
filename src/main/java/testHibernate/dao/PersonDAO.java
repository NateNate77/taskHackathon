package testHibernate.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import testHibernate.model.Car;
import testHibernate.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
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


//    public void addPerson(String name, String dateOfBirth) throws ParseException {
//
//    Person person = new Person();
//    person.setName(name);
//    person.setDateOfBirth(dateOfBirth);
// 	  em.persist(person);
// 	  LOGGER.info("ADD PERSON!!!!!!!!!!");
//
//      }
    @Transactional(value = "txManager")
    public void addPerson(Person p) throws ParseException {

//        if(p.getId() == 0){
//            p.setId((int) (Math.random()*10000));
//        }

//        Person person = new Person();
//        person.setName(name);
//        person.setDateOfBirth(dateOfBirth);
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
    public void setCar(Car car){
        Person person = em.find(Person.class, car.getPerson().getId());
        person.addCar(car);
    }

}
