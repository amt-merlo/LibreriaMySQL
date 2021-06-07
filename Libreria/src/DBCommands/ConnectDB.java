/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import libreria.Book;
import libreria.BorrowedBook;
import libreria.Loan;
import libreria.Person;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Allison
 */
public class ConnectDB {
    private static String dbPassword = "merloadmin"; // (merloadmin) -- (HlMnd2320)
    private static String dbUser = "root";
    private static String dbHost = "jdbc:mysql://localhost:3306/LB?zeroDateTimeBehavior=CONVERT_TO_NULL"; // (jdbc:oracle:thin:@localhost:1521:PROYECTOSTEC)-- (jdbc:oracle:thin:@localhost:1521/DBTarea1)
    
    public static void insertPerson(int ID_Number, int ID_PersonType, String Firstname, String Lastname, String Birthdate) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call insertPerson(?, ?, ?, ?, ?)}");
        
        st.setInt(1, ID_Number);
        st.setInt(2, ID_PersonType);
        st.setString(3, Firstname);
        st.setString(4, Lastname);
        st.setString(5, "01,01,2000");
        
        st.execute();
        st.close();
 
        System.out.println("Stored procedure called successfully!");
    }
    
    public static void insertBook(String title, String author, String publishingHouse, int score, int edition, String image, int clasification, int idItem) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{ call InsertBook(?, ?, ?, ?, ?, ?, ?, ?)}");
        System.out.println("en la llamada");
        
        st.setString(1, title);
        st.setInt(2, clasification);
        st.setInt(3, idItem);
        st.setString(4, author);
        st.setString(5, publishingHouse);
        st.setInt(6, score);
        st.setInt(7, edition);
        st.setString(8, image);
        System.out.println("antes del execute");
        st.execute();
        st.close();
        System.out.println("exito");
    }
    
    public static void crearItem(String title) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{ call createItem(?)}");
        System.out.println("en la llamada");
        
        st.setString(1, title);
        System.out.println("antes del execute");
        st.execute();
        st.close();
        System.out.println("exito");
    }
    
    public static int extractItemID(String title) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_ItemID(?)}");
        st.setString(1, title);
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        int ID = 0;
        while(r.next()){
            ID = r.getInt("ID");
        }
        return ID;
    }
    
    public static void insertEmail(int id, String email) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{ call InsertEmail(?, ?)}");
        
        st.setInt(1, id);
        st.setString(2, email);
        st.execute();
        st.close();
    }
    
    public static void insertAddress(int id, String address) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{ call InsertAddress(?, ?)}");
        
        st.setInt(1, id);
        st.setString(2, address);
        st.execute();
        st.close();
    }
    
    public static ArrayList getBooks() throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call getBooks}");
        
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        //Lista para guardar los libros
        ArrayList<Book> libros = new ArrayList<Book>();
        
        //Variables para datos de cada libro
        int ID, ID_Clasification, ID_Item, Edition, Score;
        String Title, Author, PublishingHouse, Clasification, imagePath;
        
        
        while(r.next()){
            
            //Sacamos los datos de cada libro
            ID = Integer.parseInt(r.getString("ID"));
            ID_Clasification = Integer.parseInt(r.getString("ID_Clasification"));
            ID_Item = Integer.parseInt(r.getString("ID_Item"));
            Edition = Integer.parseInt(r.getString("Edition"));
            Score = Integer.parseInt(r.getString("Score"));
            
            Title = r.getString("Title");
            Author = r.getString("Author");
            PublishingHouse = r.getString("PublishingHouse");
            Clasification = extractClasification(ID_Clasification);
            imagePath = r.getString("CoverPage");
            System.out.println(imagePath);
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse, imagePath);
            
            //Se agrega el libro a la lista 
            libros.add(book);
        }
        
        return libros;
    }
    
    public static String extractClasification(int clas_ID) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_Clasification(?)}");
        st.setInt(1, clas_ID);
        
        ResultSet r = (ResultSet) st.executeQuery();
        String clasification = "";
        while (r.next()){
            clasification = r.getString("Clasification");
        }
        
        return clasification;
    }
    
    public static int extractClasificationID(String clasi) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_ClasificationID(?)}");
        st.setString(1, clasi);
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        int ID=0;
        while (r.next()){
            ID = r.getInt("ID");
        }
        
        return ID;
    }
    
    //Consulta por un libro con los tres filtros
    public static ArrayList get_BooksFiltered1(String inTitle, String inAuthor, String inPHouse) throws SQLException{
        ArrayList<Book> libros = new ArrayList<Book>();
      
        
        //Variables para datos de cada libro
        int ID, ID_Clasification, ID_Item, Edition, Score;
        String Title, Author, PublishingHouse, Clasification, CoverPage;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_BooksFiltered1(?,?,?)}");
        
        st.setString(1, inTitle);
        st.setString(2, inAuthor);
        st.setString(3, inPHouse);
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        while(r.next()){
            //Sacamos los datos de cada libro
            ID = Integer.parseInt(r.getString("ID"));
            ID_Clasification = Integer.parseInt(r.getString("ID_Clasification"));
            ID_Item = Integer.parseInt(r.getString("ID_Item"));
            Edition = Integer.parseInt(r.getString("Edition"));
            Score = Integer.parseInt(r.getString("Score"));
            
            Title = r.getString("Title");
            Author = r.getString("Author");
            PublishingHouse = r.getString("PublishingHouse");
            Clasification = extractClasification(ID_Clasification);
            CoverPage = r.getString("CoverPage");
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse, CoverPage);
            
            //Se agrega el libro a la lista 
            libros.add(book);
        }
        
        return libros;
    }
    
     //Consulta por un libro con filtro de Autor y de Titulo
    public static ArrayList get_BooksFiltered2(String inTitle, String inAuthor) throws SQLException{
        ArrayList<Book> libros = new ArrayList<Book>();
      
        
        //Variables para datos de cada libro
        int ID, ID_Clasification, ID_Item, Edition, Score;
        String Title, Author, PublishingHouse, Clasification, CoverPage;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_BooksFiltered2(?,?)}");
        
        st.setString(1, inTitle);
        st.setString(2, inAuthor);
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        while(r.next()){
            
            //Sacamos los datos de cada libro
            ID = Integer.parseInt(r.getString("ID"));
            ID_Clasification = Integer.parseInt(r.getString("ID_Clasification"));
            ID_Item = Integer.parseInt(r.getString("ID_Item"));
            Edition = Integer.parseInt(r.getString("Edition"));
            Score = Integer.parseInt(r.getString("Score"));
            
            Title = r.getString("Title");
            Author = r.getString("Author");
            PublishingHouse = r.getString("PublishingHouse");
            Clasification = extractClasification(ID_Clasification);
            CoverPage = r.getString("CoverPage");
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse, CoverPage);
            
            //Se agrega el libro a la lista 
            libros.add(book);
        }
        
        return libros;
    }
    
      //Consulta por un libro con filtro de Editorial y de Titulo
    public static ArrayList get_BooksFiltered3(String inTitle, String inPHouse) throws SQLException{
        ArrayList<Book> libros = new ArrayList<Book>();
      
        
        //Variables para datos de cada libro
        int ID, ID_Clasification, ID_Item, Edition, Score;
        String Title, Author, PublishingHouse, Clasification, CoverPage;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_BooksFiltered3(?,?)}");
        
        st.setString(1, inTitle);
        st.setString(2, inPHouse);
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        while(r.next()){
            
            //Sacamos los datos de cada libro
            ID = Integer.parseInt(r.getString("ID"));
            ID_Clasification = Integer.parseInt(r.getString("ID_Clasification"));
            ID_Item = Integer.parseInt(r.getString("ID_Item"));
            Edition = Integer.parseInt(r.getString("Edition"));
            Score = Integer.parseInt(r.getString("Score"));
            
            Title = r.getString("Title");
            Author = r.getString("Author");
            PublishingHouse = r.getString("PublishingHouse");
            Clasification = extractClasification(ID_Clasification);
            CoverPage = r.getString("CoverPage");
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse, CoverPage);
            
            //Se agrega el libro a la lista 
            libros.add(book);
        }
        
        return libros;
    }
    
       //Consulta por un libro con filtro de Autor y de Editorial
    public static ArrayList get_BooksFiltered4(String inAuthor, String inPHouse) throws SQLException{
        ArrayList<Book> libros = new ArrayList<Book>();
      
        
        //Variables para datos de cada libro
        int ID, ID_Clasification, ID_Item, Edition, Score;
        String Title, Author, PublishingHouse, Clasification, CoverPage;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_BooksFiltered4(?,?)}");
        
        st.setString(1, inAuthor);
        st.setString(2, inPHouse);
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        while(r.next()){
            
            //Sacamos los datos de cada libro
            ID = Integer.parseInt(r.getString("ID"));
            ID_Clasification = Integer.parseInt(r.getString("ID_Clasification"));
            ID_Item = Integer.parseInt(r.getString("ID_Item"));
            Edition = Integer.parseInt(r.getString("Edition"));
            Score = Integer.parseInt(r.getString("Score"));
            
            Title = r.getString("Title");
            Author = r.getString("Author");
            PublishingHouse = r.getString("PublishingHouse");
            Clasification = extractClasification(ID_Clasification);
            CoverPage = r.getString("CoverPage");
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse, CoverPage);
            
            //Se agrega el libro a la lista 
            libros.add(book);
        }
        
        return libros;
    }
    
    //Cuando se filtra solo por título
    public static ArrayList get_BooksFiltered5(String inTitle) throws SQLException{
        ArrayList<Book> libros = new ArrayList<Book>();
      
        
        //Variables para datos de cada libro
        int ID, ID_Clasification, ID_Item, Edition, Score;
        String Title, Author, PublishingHouse, Clasification, CoverPage;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_BooksFiltered5(?)}");
        
        st.setString(1, inTitle);
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        while(r.next()){
            
            //Sacamos los datos de cada libro
            ID = Integer.parseInt(r.getString("ID"));
            ID_Clasification = Integer.parseInt(r.getString("ID_Clasification"));
            ID_Item = Integer.parseInt(r.getString("ID_Item"));
            Edition = Integer.parseInt(r.getString("Edition"));
            Score = Integer.parseInt(r.getString("Score"));
            
            Title = r.getString("Title");
            Author = r.getString("Author");
            PublishingHouse = r.getString("PublishingHouse");
            Clasification = extractClasification(ID_Clasification);
            CoverPage = r.getString("CoverPage");
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse, CoverPage);
            
            //Se agrega el libro a la lista 
            libros.add(book);
        }
        
        return libros;
    }
    
    //Cuando se filtra solo por Autor
    public static ArrayList get_BooksFiltered6(String inAuthor) throws SQLException{
        ArrayList<Book> libros = new ArrayList<Book>();
      
        
        //Variables para datos de cada libro
        int ID, ID_Clasification, ID_Item, Edition, Score;
        String Title, Author, PublishingHouse, Clasification, CoverPage;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_BooksFiltered6(?)}");
        
        st.setString(1, inAuthor);
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        while(r.next()){
            
            //Sacamos los datos de cada libro
            ID = Integer.parseInt(r.getString("ID"));
            ID_Clasification = Integer.parseInt(r.getString("ID_Clasification"));
            ID_Item = Integer.parseInt(r.getString("ID_Item"));
            Edition = Integer.parseInt(r.getString("Edition"));
            Score = Integer.parseInt(r.getString("Score"));
            
            Title = r.getString("Title");
            Author = r.getString("Author");
            PublishingHouse = r.getString("PublishingHouse");
            Clasification = extractClasification(ID_Clasification);
            CoverPage = r.getString("CoverPage");
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse, CoverPage);
            
            //Se agrega el libro a la lista 
            libros.add(book);
        }
        
        return libros;
    }
    
    //Cuando se filtra solo por Editorial
    public static ArrayList get_BooksFiltered7(String inPHouse) throws SQLException{
        ArrayList<Book> libros = new ArrayList<Book>();
      
        
        //Variables para datos de cada libro
        int ID, ID_Clasification, ID_Item, Edition, Score;
        String Title, Author, PublishingHouse, Clasification, CoverPage;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_BooksFiltered7(?)}");
        
        st.setString(1, inPHouse);
       
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        while(r.next()){
            
            //Sacamos los datos de cada libro
            ID = Integer.parseInt(r.getString("ID"));
            ID_Clasification = Integer.parseInt(r.getString("ID_Clasification"));
            ID_Item = Integer.parseInt(r.getString("ID_Item"));
            Edition = Integer.parseInt(r.getString("Edition"));
            Score = Integer.parseInt(r.getString("Score"));
            
            Title = r.getString("Title");
            Author = r.getString("Author");
            PublishingHouse = r.getString("PublishingHouse");
            Clasification = extractClasification(ID_Clasification);
            CoverPage = r.getString("CoverPage");
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse, CoverPage);
            
            //Se agrega el libro a la lista 
            libros.add(book);
        }
        
        return libros;
    }
    
    public static ArrayList<String>  get_BookClasifications() throws SQLException{
        ArrayList<String> tipos = new ArrayList<String>();
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_BookClasifications}");
        
        ResultSet r = (ResultSet) st.executeQuery();
        String clasificacion;
        while(r.next()){
            
            //Sacamos los datos de cada libro
            clasificacion = r.getString("Clasification");
            System.out.println(clasificacion);
            //Se agrega el libro a la lista 
            tipos.add(clasificacion);
        }
        return tipos;
    }
    
    public static ArrayList<String>  get_PersonType() throws SQLException{
        ArrayList<String> tipos = new ArrayList<String>();
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_PersonType}");
        
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        String tipoPersona;
        while(r.next()){
            
            //Sacamos los datos de cada libro
            tipoPersona = r.getString("Type");
            System.out.println(tipoPersona);
            //Se agrega el libro a la lista 
            tipos.add(tipoPersona);
        }
        return tipos;
    }
    
    
    
    public static int get_PersonTypeID(String Type) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_PersonTypeID(?)}");
        st.setString(1, Type);
        
        int ID=0;
        ResultSet r = (ResultSet) st.executeQuery();
        while(r.next()){
            ID = r.getInt("ID");
        }
        
        return ID;
    }
    
    public static ArrayList get_Loans() throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_Loans}");
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        //Lista para guardar los libros
        ArrayList<Loan> prestamos = new ArrayList<Loan>();
        
        //Variables para datos de cada prestamo
        int ID, ID_Person, ID_Item, Days_Amount;
        String Loan_Date, Return_Date;
        
        while(r.next()){
            ID = r.getInt("ID");
            ID_Person = r.getInt("ID_Person");
            ID_Item = r.getInt("ID_Item");
            Days_Amount = r.getInt("Days_Amount");
            Loan_Date = r.getString("Loan_Date");
            Return_Date = r.getString("Return_Date");
            System.out.println(ID);
            //Creamos el objeto de tipo prestamo
            Loan prestamo = new Loan(ID, ID_Person, ID_Item, Days_Amount,Loan_Date, Return_Date);
            System.out.println(prestamo.getLoan_Date());
            //Insertamos el prestamo dentro de la lista
            prestamos.add(prestamo);
            
        }
        return prestamos;
    }
    
    public static String extractPersonType(int type_ID) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_PersonTypeByID(?)}");
        st.setInt(1, type_ID);
        
        ResultSet r = (ResultSet) st.executeQuery();
        String type = "";
        while(r.next()){
            type = r.getString("Type");
        }
        
        
        return type;
    }
    
    public static ArrayList<Person> get_People() throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        System.out.println("Entra a get_People()");
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call getPeople}");
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        //Lista para guardar los libros
        ArrayList<Person> personas = new ArrayList();
        
        //Variables para datos de cada prestamo
        int ID, ID_PersonType;
        String Firstname, Lastname, Birthdate, personType;
        
        while(r.next()){
            ID = r.getInt("ID_Number");
            ID_PersonType = r.getInt("ID_PersonType");
            Firstname = r.getString("Firstname");
            Lastname = r.getString("Lastname");
            Birthdate = r.getString("Birthdate");
            System.out.println(Firstname);
            
            //Sacamos el tipo de persona
            personType = extractPersonType(ID_PersonType);
            
            //Creamos el objeto de tipo prestamo
            Person persona = new Person(ID, personType, Firstname, Lastname,Birthdate);
            System.out.println(Firstname);
            //Insertamos el prestamo dentro de la lista
            personas.add(persona);
            
        }
        return personas;
    }
    
    public static void update_Person(int ID_Number, int ID_PersonType, String Firstname, String Lastname, String Birthdate) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{ call update_Person(?, ?, ?, ?, ?)}");
        
        st.setInt(1, ID_Number);
        st.setInt(2, ID_PersonType);
        st.setString(3, Firstname);
        st.setString(4, Lastname);
        st.setString(5, Birthdate);
        
        st.execute();
        st.close();
    }
    
    public static ArrayList<BorrowedBook> get_BorrowedBooks() throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_BorrowedBooks}");
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        ArrayList<BorrowedBook> prestados = new ArrayList();
        
        //Variables para datos de cada libro
        int ID, ID_Clasification, ID_Item, Edition, Score, Days_Amount;
        String Title, Author, PublishingHouse, Clasification, Borrower;
        
        
        while(r.next()){
            
            //Sacamos los datos de cada libro
            ID = Integer.parseInt(r.getString("ID"));
            Edition = Integer.parseInt(r.getString("Edition"));
            Score = Integer.parseInt(r.getString("Score"));
            Days_Amount = Integer.parseInt(r.getString("Days_Amount"));
            
            
            Title = r.getString("Title");
            Author = r.getString("Author");
            PublishingHouse = r.getString("PublishingHouse");
            Clasification = r.getString("Clasification");
            Borrower = r.getString("ID_Person");
            
            
            //Creamos un nuevo objeto de tipo libro
            BorrowedBook book = new BorrowedBook(ID, Edition, Score, Days_Amount, Clasification, Title, Author, PublishingHouse, Borrower);
            
            //Se agrega el libro a la lista 
            prestados.add(book);
        }
        return prestados;
    }
    
    public static ArrayList<BorrowedBook> get_BorrowedBooksByID(int ID_Number) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_BorrowedBooksByID(?)}");
        st.setInt(1, ID_Number);
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        ArrayList<BorrowedBook> prestados = new ArrayList();
        
        //Variables para datos de cada libro
        int ID, ID_Clasification, ID_Item, Edition, Score, Days_Amount;
        String Title, Author, PublishingHouse, Clasification, Borrower;
        
        
        while(r.next()){
            
            //Sacamos los datos de cada libro
            ID = Integer.parseInt(r.getString("ID"));
            Edition = Integer.parseInt(r.getString("Edition"));
            Score = Integer.parseInt(r.getString("Score"));
            Days_Amount = Integer.parseInt(r.getString("Days_Amount"));
            
            
            Title = r.getString("Title");
            Author = r.getString("Author");
            PublishingHouse = r.getString("PublishingHouse");
            Clasification = r.getString("Clasification");
            Borrower = r.getString("ID_Person");
            
            
            //Creamos un nuevo objeto de tipo libro
            BorrowedBook book = new BorrowedBook(ID, Edition, Score, Days_Amount, Clasification, Title, Author, PublishingHouse, Borrower);
            
            //Se agrega el libro a la lista 
            prestados.add(book);
        }
        return prestados;
    }
    
    public static ArrayList<Book> get_NotBorrowed() throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_notBorrowed}");
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        ArrayList<Book> libros = new ArrayList();
        
        //Variables para datos de cada libro
        int ID, ID_Clasification, ID_Item, Edition, Score, Days_Amount;
        String Title, Author, PublishingHouse, Clasification, Borrower, CoverPage;
        
        
        while(r.next()){
            
            //Sacamos los datos de cada libro
            ID = Integer.parseInt(r.getString("ID"));
            ID_Clasification = Integer.parseInt(r.getString("ID_Clasification"));
            ID_Item = Integer.parseInt(r.getString("ID_Item"));
            Edition = Integer.parseInt(r.getString("Edition"));
            Score = Integer.parseInt(r.getString("Score"));
            
            Title = r.getString("Title");
            Author = r.getString("Author");
            PublishingHouse = r.getString("PublishingHouse");
            Clasification = extractClasification(ID_Clasification);
            CoverPage = r.getString("CoverPage");
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse, CoverPage);
            
            
            
            libros.add(book);
        }
        return libros;
    }
    
    public static void update_Book(int ID, int ID_Clasification, String Title, String Author, String PHouse, int Edition, int Score) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{ call update_Book(?, ?, ?, ?, ?, ?, ?)}");
        
        st.setInt(1, ID);
        st.setInt(2, ID_Clasification);
        st.setString(3, Title);
        st.setString(4, Author);
        st.setInt(5, Edition);
        st.setString(6, PHouse);
        st.setInt(7, Score);
        
        st.execute();
    }
    
    public static int validateUser(String username, String pass) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{? = call userValidation(?, ?)}");
        
        st.setString(2, username);
        st.setString(3, pass);
        st.registerOutParameter(1,java.sql.Types.INTEGER);
        st.execute();
        
        int result = st.getInt(1);
        System.out.println(username+"|"+pass+"|"+result);
        return result;
    }
    
    public static String get_BookCoverPage(int ID) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_BookCoverPage(?)}");
        st.setInt(1, ID);
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        String coverPage="";
        while(r.next()){
            coverPage = r.getString("CoverPage");
        }
        return coverPage;
    }

}
