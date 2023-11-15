package proyectofinal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;

public class MySQL{
    String bd ="proyecto_final";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="";
    String driver="com.mysql.jdbc.Driver";
    static Connection cn=null;

    public Connection conectar(){
        try {
            Class.forName(driver);
            cn=DriverManager.getConnection(url+bd,user,password);
            System.out.println("Se conecto a la base de datos");
        } catch (Exception ex) {
            System.out.println("No see conecto a la base de datos: "+bd+ex);
        }
        return cn;
    }
    public static void main (String[]args) throws SQLException{
        MySQL con=new MySQL();
        con.conectar();
    }
    
}


