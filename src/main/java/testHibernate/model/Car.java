package testHibernate.model;

import javax.persistence.*;


@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "horsepower")
    private int horsepower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

//    private int ownerId;

//    @Column(name = "ownerId")
//    private int ownerId;

    public Car(){

    }

    public Car(String model, int horsepower){
        this.model = model;
        this.horsepower = horsepower;
//        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower(){
        return horsepower;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

//    public int getPersonId(){
//        return person.getId();
//    }
//
//    public void setPersonId(Person person){
//        this.person.setId(person.getId());
//    }


//    public int getOwnerId() {
//        return ownerId;
//    }
//
//    public void setOwnerId(int ownerId) {
//        this.ownerId = ownerId;
//    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsepower(int horsepower){
        this.horsepower = horsepower;
    }



}
