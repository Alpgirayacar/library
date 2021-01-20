
package library;
import java.sql.*;


public class DbHelper {
    public String userName="root";
    public String password="123456";
    public String dbUrl="jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC";
    
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(dbUrl,password,userName);
        
        
    }
    public void showErrorMessage(SQLException exception){
        System.out.println("Eror "+exception.getMessage());
        System.out.println("Eror Code "+exception.getErrorCode());
    }
    
    
}
