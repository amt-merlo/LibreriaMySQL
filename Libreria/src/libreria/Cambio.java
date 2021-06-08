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
public class Cambio {
    private int ID;
    private String date;
    private String hour;
    private String type;
    private String object;
    private String description;
    private String username;

    //Constructor
    public Cambio(int ID, String date, String hour, String type, String object, String description, String username) {
        this.ID = ID;
        this.date = date;
        this.hour = hour;
        this.type = type;
        this.object = object;
        this.description = description;
        this.username = username;
    }

    //Gets
    public int getID() {
        return ID;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public String getType() {
        return type;
    }

    public String getObject() {
        return object;
    }

    public String getDescription() {
        return description;
    }

    public String getUsername() {
        return username;
    }

    //Sets
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
}
