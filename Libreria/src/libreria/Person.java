/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

/**
 *
 * @author Allison
 */
public class Person {
    private int ID;
    private String PersonType;
    private String Firstname;
    private String Lastname;
    private String Birthdate;

    //Constructor
    public Person(int ID, String PersonType, String Firstname, String Lastname, String Birthdate) {
        this.ID = ID;
        this.PersonType = PersonType;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Birthdate = Birthdate;
    }

    //Gets
    public int getID() {
        return ID;
    }

    public String getID_PersonType() {
        return PersonType;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getBirthdate() {
        return Birthdate;
    }
    
    //Sets

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setID_PersonType(String PersonType) {
        this.PersonType = PersonType;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public void setBirthdate(String Birthdate) {
        this.Birthdate = Birthdate;
    }
    
    
}
