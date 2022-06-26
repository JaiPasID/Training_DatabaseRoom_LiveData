package fr.jaroddeveloppement.training1.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "data_user")
public class UserEntity {

    @PrimaryKey (autoGenerate = true)
    private long id;

    @ColumnInfo (name = "name")
    private String name;

    @ColumnInfo (name = "firstName")
    private String firstName;

    @ColumnInfo (name = "age")
    private String age;

    @ColumnInfo (name = "adress")
    private String adress;

    @ColumnInfo(name = "zipCode")
    private String zipCode;

    @ColumnInfo(name = "country")
    private String country;

    public UserEntity(){}
    /** Constructor

     * @param pName
     * @param pFirstName
     * @param pAdress
     * @param pZipCode
     * @param pCountry
     */

    public UserEntity( String pName, String pFirstName, String pAge, String pAdress, String pZipCode, String pCountry) {

        name = pName;
        firstName = pFirstName;
        age = pAge;
        adress = pAdress;
        zipCode = pZipCode;
        country = pCountry;
    }


    /** Getter / Setter
     *
     * @return
     */
    public long getId() {
        return id;
    }

    public void setId(long pId) {
        id = pId;
    }

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

    public String getAge() {
        return age;
    }

    public void setAge(String pAge) {
        age = pAge;
    }
}
