package sample.models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Person {
    private LongProperty id;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty street;
    private StringProperty city;
    private IntegerProperty postalCode;
    private ObjectProperty<LocalDate> birthday;

    public Person(Long id, String firstName, String lastName, String city, String street, Integer postalCode, LocalDate birthday){
        this.id = new SimpleLongProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.street = new SimpleStringProperty(street);
        this.city = new SimpleStringProperty(city);
        this.postalCode = new SimpleIntegerProperty(postalCode);
        this.birthday = new SimpleObjectProperty<LocalDate>(birthday);

    }

    public Person(){
        this(null, null, null, null, null, null, null);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty getFirstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty getLastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty getStreetProperty() {
        return street;
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty getCityProperty() {
        return city;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public IntegerProperty getPostalCodeProperty() {
        return postalCode;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public ObjectProperty<LocalDate> getBirthdayProperty() {
        return birthday;
    }

    public long getId() {
        return id.get();
    }

    public void setFirstName(String firstName) {
        this.firstName = new SimpleStringProperty(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = new SimpleStringProperty(lastName);
    }

    public void setStreet(String street) {
        this.street = new SimpleStringProperty(street);
    }

    public void setCity(String city) {
        this.city = new SimpleStringProperty(city);
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = new SimpleIntegerProperty(postalCode);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = new SimpleObjectProperty<>(birthday);
    }
}
