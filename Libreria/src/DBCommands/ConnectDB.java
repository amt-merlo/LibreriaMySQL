/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;
import java.sql.*;
import java.util.ArrayList;
import libreria.Book;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Allison
 */
public class ConnectDB {
    private static String dbPassword = "merloadmin"; // (merloadmin) -- (HlMnd2320)
    private static String dbUser = "sys as sysdba";
    private static String dbHost = "jdbc:oracle:thin:@localhost:1521:PROYECTOSTEC"; // (jdbc:oracle:thin:@localhost:1521:PROYECTOSTEC)-- (jdbc:oracle:thin:@localhost:1521:DBTarea1)
    
    public static void insertPerson(int ID_Number, String Firstname, String Lastname, String Birthdate) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{ call InsertPerson(?, ?, ?, ?)");
        
        st.setInt(1, ID_Number);
        st.setString(2, Firstname);
        st.setString(3, Lastname);
        st.setString(4, Birthdate);
        st.execute();
    }
    
    public static void insertEmail(int id, String email) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{ call InsertEmail(?, ?)");
        
        st.setInt(1, id);
        st.setString(2, email);
        st.execute();
    }
    
    public static void insertAddress(int id, String address) throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{ call InsertAddress(?, ?)");
        
        st.setInt(1, id);
        st.setString(2, address);
        st.execute();
    }
    
    public static ArrayList getBooks() throws SQLException{
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{?= call get_Books}");
        st.registerOutParameter(1, OracleTypes.CURSOR);
        
        st.executeQuery();
        ResultSet r = (ResultSet) st.getObject(1);
        
        //Lista para guardar los libros
        ArrayList<Book> libros = new ArrayList<Book>();
        
        //Variables para datos de cada libro
        int ID, ID_Clasification, ID_Item, Edition, Score;
        String Title, Author, PublishingHouse, Clasification;
        
        
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
            
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse);
            
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
        CallableStatement st = con.prepareCall("{?= call get_Clasification(?)}");
        st.setInt(2, clas_ID);
        st.registerOutParameter(1, OracleTypes.VARCHAR);
        
        st.executeQuery();
        
        String clasification = st.getString(1);
        return clasification;
    }
    
    //Consulta por un libro con los tres filtros
    public static ArrayList get_BooksFiltered1(String inTitle, String inAuthor, String inPHouse) throws SQLException{
        ArrayList<Book> libros = new ArrayList<Book>();
      
        
        //Variables para datos de cada libro
        int ID, ID_Clasification, ID_Item, Edition, Score;
        String Title, Author, PublishingHouse, Clasification;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{?= call get_BooksFiltered1(?,?,?)}");
        
        st.setString(2, inTitle);
        st.setString(3, inAuthor);
        st.setString(4, inPHouse);
        st.registerOutParameter(1, OracleTypes.CURSOR);
        st.executeQuery();
        
        ResultSet r = (ResultSet) st.getObject(1);
        
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
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse);
            
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
        String Title, Author, PublishingHouse, Clasification;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{?= call get_BooksFiltered2(?,?)}");
        
        st.setString(2, inTitle);
        st.setString(3, inAuthor);
        st.registerOutParameter(1, OracleTypes.CURSOR);
        st.executeQuery();
        
        ResultSet r = (ResultSet) st.getObject(1);
        
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
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse);
            
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
        String Title, Author, PublishingHouse, Clasification;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{?= call get_BooksFiltered3(?,?)}");
        
        st.setString(2, inTitle);
        st.setString(3, inPHouse);
        st.registerOutParameter(1, OracleTypes.CURSOR);
        st.executeQuery();
        
        ResultSet r = (ResultSet) st.getObject(1);
        
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
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse);
            
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
        String Title, Author, PublishingHouse, Clasification;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{?= call get_BooksFiltered4(?,?)}");
        
        st.setString(2, inAuthor);
        st.setString(3, inPHouse);
        st.registerOutParameter(1, OracleTypes.CURSOR);
        st.executeQuery();
        
        ResultSet r = (ResultSet) st.getObject(1);
        
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
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse);
            
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
        String Title, Author, PublishingHouse, Clasification;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{?= call get_BooksFiltered5(?)}");
        
        st.setString(2, inTitle);
        st.registerOutParameter(1, OracleTypes.CURSOR);
        st.executeQuery();
        
        ResultSet r = (ResultSet) st.getObject(1);
        
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
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse);
            
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
        String Title, Author, PublishingHouse, Clasification;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{?= call get_BooksFiltered6(?)}");
        
        st.setString(2, inAuthor);
        st.registerOutParameter(1, OracleTypes.CURSOR);
        st.executeQuery();
        
        ResultSet r = (ResultSet) st.getObject(1);
        
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
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse);
            
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
        String Title, Author, PublishingHouse, Clasification;
        
        //Se conecta con la BD
        String host = dbHost;
        String user = dbUser;
        String password = dbPassword;
        
        
        Connection con = DriverManager.getConnection(host, user, password);
        CallableStatement st = con.prepareCall("{?= call get_BooksFiltered7(?)}");
        
        st.setString(2, inPHouse);
        st.registerOutParameter(1, OracleTypes.CURSOR);
        st.executeQuery();
        
        ResultSet r = (ResultSet) st.getObject(1);
        
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
            //Creamos un nuevo objeto de tipo libro
            Book book = new Book(ID, ID_Item, Edition, Score, Clasification, Title, Author, PublishingHouse);
            
            //Se agrega el libro a la lista 
            libros.add(book);
        }
        
        return libros;
    }
}
