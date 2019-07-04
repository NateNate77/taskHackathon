package testHibernate.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PERSON")
public class Person {

//    @Id
//    @Column(name = "Id")
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @GeneratedValue
    @Column (name = "id", nullable = false)
    private int id;

    @Column(name = "Name", length = 64, nullable = false)
    private String name;

//    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfBirth", nullable = false)
    private Date dateOfBirth;
//    private java.util.Date dateOfBirth;


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;

    public Person(){

    }

    public Person(int id, String name, String dateBirth) throws ParseException {
//        Date date = new SimpleDateFormat("dd.MM.yyyy").parse(dateOfBirth);
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        date = format.parse(dateBirth);
        this.id = id;
//        temporalValues.setUtil(new SimpleDateFormat("dd.MM.yyyy").parse(dateOfBirth));
        this.name = name;
        this.dateOfBirth = date;
    }

    public Person(String name, String dateBirth) throws ParseException {
//        Date date = new SimpleDateFormat("dd.MM.yyyy").parse(dateOfBirth);
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        date = format.parse(dateBirth);
//        temporalValues.setUtil(new SimpleDateFormat("dd.MM.yyyy").parse(dateOfBirth));
        this.name = name;
        this.dateOfBirth = date;
        cars = new ArrayList<Car>();
    }

    public void addCar(Car car) {
//        car.setPerson(this);
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }


    public List<Car> getCars() {
        return cars;
    }

//    public Car getCarsOne() {
//        return cars.get(0);
//    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

//    public Person(String name, String dateBirth) throws ParseException {
//
//        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//        Date date = new Date();
//        date = format.parse(dateBirth);
//        this.name = name;
//        this.dateOfBirth = date;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public void setDateOfBirth(String dateOfBirth) {
//        DateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SS");
//        Date date = new Date();
//        dateOfBirth += " 00:00:00.00";
//        try {
//            date = format.parse(dateOfBirth);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        this.dateOfBirth = date;
//    }

}
