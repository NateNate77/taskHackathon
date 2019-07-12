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


    @Id
    @GeneratedValue
    @Column (name = "id", nullable = false)
    private int id;

    @Column(name = "Name", length = 64, nullable = false)
    private String name;


    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfBirth", nullable = false)
    private Date dateOfBirth;



    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Car> cars;

    @Column
    private int age;

//    private String dateOfBirtToString;

    public Person(){

    }



    public void addCar(Car car) {

        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

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


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public String getDateOfBirtToString(){
//        SimpleDateFormat df2 = new SimpleDateFormat("dd.MM.yyyy");
//        String dateBirth = df2.format(this.dateOfBirth);
//        return dateBirth;
//    }

}
