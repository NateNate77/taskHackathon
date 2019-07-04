package testHibernate.model;

public class AddCarRequest {

    private String model;

    private int horsePower;

    private int personID;

    public AddCarRequest() {

    }

    public AddCarRequest(String model, int horsePower, int personID) {
        this.model = model;
        this.horsePower = horsePower;
        this.personID = personID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }
}
