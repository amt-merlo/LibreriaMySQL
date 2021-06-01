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
public class Loan {
    private int ID; 
    private int ID_Person;
    private int ID_Item;
    private int Days_Amount;
    private String Loan_Date;
    private String Return_Date;

    public Loan(int ID, int ID_Perso, int ID_Item, int Days_Amount, String Loan_Date, String Return_Date) {
        this.ID = ID;
        this.ID_Person = ID_Perso;
        this.ID_Item = ID_Item;
        this.Days_Amount = Days_Amount;
        this.Loan_Date = Loan_Date;
        this.Return_Date = Return_Date;
    }
    
    //Gets
    public int getID() {
        return ID;
    }

    public int getID_Person() {
        return ID_Person;
    }

    public int getID_Item() {
        return ID_Item;
    }

    public int getDays_Amount() {
        return Days_Amount;
    }

    public String getLoan_Date() {
        return Loan_Date;
    }

    public String getReturn_Date() {
        return Return_Date;
    }
    
    //Sets

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setID_Person(int ID_Person) {
        this.ID_Person = ID_Person;
    }

    public void setID_Item(int ID_Item) {
        this.ID_Item = ID_Item;
    }

    public void setDays_Amount(int Days_Amount) {
        this.Days_Amount = Days_Amount;
    }

    public void setLoan_Date(String Loan_Date) {
        this.Loan_Date = Loan_Date;
    }

    public void setReturn_Date(String Return_Date) {
        this.Return_Date = Return_Date;
    }
    
}
