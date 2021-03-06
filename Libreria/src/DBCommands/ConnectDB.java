/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;
import libreria.TopBook;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import libreria.Book;
import libreria.BorrowedBook;
import libreria.Cambio;
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
    
    public static int insertPerson(int ID_Number, int ID_PersonType, String Firstname, String Lastname, String Birthdate) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{? = call insertPerson(?, ?, ?, ?, ?)}");
        
        st.setInt(2, ID_Number);
        st.setInt(3, ID_PersonType);
        st.setString(4, Firstname);
        st.setString(5, Lastname);
        st.setString(6, "01,01,2000");
        
        st.registerOutParameter(1,java.sql.Types.INTEGER);
        st.execute();
        
        int result = st.getInt(1);
        st.close();
 
        System.out.println("Stored procedure called successfully!");
        return result;
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
    
    //Cuando se filtra solo por t??tulo
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

     public static ArrayList<Cambio> get_LogBook() throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_LogBook}");
        
        ResultSet r = (ResultSet) st.executeQuery();
        
        int ID;
        String date, hour, type, object, description, username;
        ArrayList<Cambio> LogBook = new ArrayList();
        
        while(r.next()){
            ID = r.getInt("ID");
            date = r.getString("ChangeDate");
            hour = r.getString("ChangeHour");
            type = r.getString("ChangeType");
            object = r.getString("Object");
            description = r.getString("ChangeDescription");
            username = r.getString("Username");
            
            Cambio cambio = new Cambio(ID, date, hour, type, object, description, username);
            LogBook.add(cambio);
        }
        return LogBook;
    }
     
     public static ArrayList<Cambio> get_LogBookFiltered(String tipo, String objeto, String usuario, String date1, String date2, String hour1, String hour2) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call LogBookFiltered(?, ?, ?, ?, ?, ?, ?)}");
        st.setString(1, tipo);
        st.setString(2, objeto);
        st.setString(3, usuario);
        st.setString(4, date1);
        st.setString(5, date2);
        st.setString(6, hour1);
        st.setString(7, hour2);
        ResultSet r = (ResultSet) st.executeQuery();
        
        int ID;
        String date, hour, type, object, description, username;
        ArrayList<Cambio> LogBook = new ArrayList();
        
        while(r.next()){
            ID = r.getInt("ID");
            date = r.getString("ChangeDate");
            hour = r.getString("ChangeHour");
            type = r.getString("ChangeType");
            object = r.getString("Object");
            description = r.getString("ChangeDescription");
            username = r.getString("Username");
            
            Cambio cambio = new Cambio(ID, date, hour, type, object, description, username);
            LogBook.add(cambio);
        }
        return LogBook;
    }
     
     public static Map<String, Integer> get_ClasificationCantidades() throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_ClasificationCantidades}");
        CallableStatement st2 = con.prepareCall("{call get_CCFinal}");
        ResultSet r = (ResultSet) st.executeQuery();
        ResultSet r2 = (ResultSet) st2.executeQuery();
        
        int ID, cant;
        String clasification;
        Map<String, Integer> cantidades = new HashMap<String, Integer>();
        
        while(r2.next()){
            ID = r2.getInt("ID");
            cant = r2.getInt("cant");
            clasification = extractClasification(ID);
            System.out.println(Integer.toString(ID)+"  "+ Integer.toString(cant));
            
            cantidades.put(clasification, cant);
        }
        return cantidades;
    }
     
     public static Map<String, Integer> get_ClasificationCantidadesPrestados() throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_ClasificationCantidadesPrestados}");
        CallableStatement st2 = con.prepareCall("{call get_CCFinalPrestados}");
        ResultSet r = (ResultSet) st.executeQuery();
        ResultSet r2 = (ResultSet) st2.executeQuery();
        
        int ID, cant;
        String clasification;
        Map<String, Integer> cantidades = new HashMap<String, Integer>();
        
        while(r2.next()){
            ID = r2.getInt("ID");
            cant = r2.getInt("cant");
            clasification = extractClasification(ID);
            System.out.println(Integer.toString(ID)+"  "+ Integer.toString(cant));
            
            cantidades.put(clasification, cant);
        }
        return cantidades;
    }
     
     public static ArrayList<TopBook> get_Top10() throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call get_Top10}");
        ResultSet r = (ResultSet) st.executeQuery();
        
        int ID, cant;
        String Title;
        ArrayList<TopBook> top10 = new ArrayList();
        
        
        while(r.next()){
            ID = r.getInt("id");
            cant = r.getInt("cant");
            Title = r.getString("Title");
            
            TopBook nuevo = new TopBook(ID, cant, Title);
            top10.add(nuevo);
            
            System.out.println("Top10 "+ID+" "+cant+" "+Title);
        }
        return top10;
    }
     
     public static int insertLoan(int ID_Person, int ID_Item, String loan_date, String return_Date) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call insertloan(?, ?, ?, ?)}");
        
        st.setInt(1, ID_Person);
        st.setInt(2, ID_Item);
        st.setString(3, loan_date);
        st.setString(4, return_Date);
        
        
        ResultSet r = (ResultSet) st.executeQuery();
        int result = 7;
        
        while(r.next()){
        result = r.getInt("resultado");
         
        }
        
        
        System.out.println("Stored procedure called successfully!");
        return result;
    }
     
     public static int returnBook(int ID_Loan, int ID_Item) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{call ReturnBook(?, ?)}");
        
        st.setInt(1, ID_Loan);
        st.setInt(2, ID_Item);
        
        ResultSet r = (ResultSet) st.executeQuery();
        int result = 7;
        
        while(r.next()){
        result = r.getInt("resultado");
         
        }
        
        
        System.out.println("Stored procedure called successfully!");
        return result;
    }
}

