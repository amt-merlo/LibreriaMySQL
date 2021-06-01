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
public class BorrowedBook {
    private int ID;
    private int Edition;
    private int Score;
    private int Days_Amount;
    private String Clasification;
    private String Title;
    private String Author;
    private String PublishingHouse;
    private String Borrower;

    //Constructor
    public BorrowedBook(int ID, int Edition, int Score, int Days_Amount, String Clasification, String Title, String Author, String PublishingHouse, String Borrower) {
        this.ID = ID;
        this.Edition = Edition;
        this.Score = Score;
        this.Days_Amount = Days_Amount;
        this.Clasification = Clasification;
        this.Title = Title;
        this.Author = Author;
        this.PublishingHouse = PublishingHouse;
        this.Borrower = Borrower;
    }
    
    //Sets

    public void setID(int ID) {
        this.ID = ID;
    }


    public void setEdition(int Edition) {
        this.Edition = Edition;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public void setDays_Amount(int Days_Amount) {
        this.Days_Amount = Days_Amount;
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

    public void setBorrower(String Borrower) {
        this.Borrower = Borrower;
    }
    
    //Gets

    public int getID() {
        return ID;
    }


    public int getEdition() {
        return Edition;
    }

    public int getScore() {
        return Score;
    }

    public int getDays_Amount() {
        return Days_Amount;
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

    public String getBorrower() {
        return Borrower;
    }
    
}
