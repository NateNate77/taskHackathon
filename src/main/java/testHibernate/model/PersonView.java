package testHibernate.model;

public class PersonView {


    private int id;

    private String name;

    private String dateOfBirtToString;

    public PersonView(){

    }

    public PersonView(int id, String name, String dateOfBirtToString){
        this.id = id;
        this.name = name;
        this.dateOfBirtToString = dateOfBirtToString;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirtToString() {
        return dateOfBirtToString;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirtToString(String dateOfBirtToString) {
        this.dateOfBirtToString = dateOfBirtToString;
    }
}
