package testHibernate.dao;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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
import java.util.List;

@Component
public class CarDAO {

    @PersistenceContext(unitName = "testHibernate.person_catalog")
    private EntityManager em;



    @Transactional(value = "txManager")
    public List<Car> getAllCars() throws SQLException, Exception {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Car> q = cb.createQuery(Car.class);
        Root<Car> root = q.from(Car.class);
        q.select(root);

        return em.createQuery(q).getResultList();
    }

    @Transactional(value = "txManager")
    public List<String> getManufacturer(){
//        List<String> manufacturers = em
//                .createQuery(
//                        "select distinct vendor(p.vendor) " +
//                                "from Car p " +
//                                "order by vendor(p.vendor)", String.class)
//                .getResultList();

        List<String> manufacturers = em
                .createQuery(
                        "select distinct p.vendor from Car p order by p.vendor", String.class)
                .getResultList();
        for (int i = 0; i < manufacturers.size(); i++){
            System.out.println(manufacturers.get(i));
        }

        return manufacturers;
    }

//    @Transactional(value = "txManager")
//    public List<String> getCarNames(){
//        List<String> carNames = em.getCriteriaBuilder();
//        return carNames;
//
//    }

//    @Transactional(value = "txManager")
//    public void addCar(Car car) throws ParseException {
//        Person person = em.find(Person.class, car.getPerson().getId());
//        car.setPerson(person);
//        em.persist(car);
//
//    }

}
