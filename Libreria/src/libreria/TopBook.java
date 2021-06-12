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
public class TopBook {
    private int ID;
    private int cant;
    private String title;
    
    //Constructor

    public TopBook(int ID, int cant, String title) {
        this.ID = ID;
        this.cant = cant;
        this.title = title;
    }
    
    //Sets

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    //Gets

    public int getID() {
        return ID;
    }

    public int getCant() {
        return cant;
    }

    public String getTitle() {
        return title;
    }
    
}
