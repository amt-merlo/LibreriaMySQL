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
public class Book {
    private int ID;
    private int ID_Item;
    private int Edition;
    private int Score;
    private String Clasification;
    private String Title;
    private String Author;
    private String PublishingHouse;

    public Book(int ID, int ID_Item, int Edition, int Score, String Clasification, String Title, String Author, String PublishingHouse) {
        this.ID = ID;
        this.ID_Item = ID_Item;
        this.Edition = Edition;
        this.Score = Score;
        this.Clasification = Clasification;
        this.Title = Title;
        this.Author = Author;
        this.PublishingHouse = PublishingHouse;
    }

    //Gets
    public int getID() {
        return ID;
    }

    public int getID_Item() {
        return ID_Item;
    }

    public int getEdition() {
        return Edition;
    }

    public int getScore() {
        return Score;
    }

    public String getClasification() {
        return Clasification;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getPublishingHouse() {
        return PublishingHouse;
    }
    
    //Sets

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setID_Item(int ID_Item) {
        this.ID_Item = ID_Item;
    }

    public void setEdition(int Edition) {
        this.Edition = Edition;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public void setClasification(String Clasification) {
        this.Clasification = Clasification;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setPublishingHouse(String PublishingHouse) {
        this.PublishingHouse = PublishingHouse;
    }
    
}
