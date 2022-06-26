package fr.jaroddeveloppement.training1.model;

public class User {

    private String  name;
    private String firstName;
    private String adress;
    private String zipCode;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String pFirstName) {
        firstName = pFirstName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String pAdress) {
        adress = pAdress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String pZipCode) {
        zipCode = pZipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String pCountry) {
        country = pCountry;
    }

    public User(String pName, String pFirstName, String pAdress, String pZipCode, String pCountry) {
        name = pName;
        firstName = pFirstName;
        adress = pAdress;
        zipCode = pZipCode;
        country = pCountry;
    }
}
