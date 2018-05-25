package unusualevents.db.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    public Connection sqlConnection()  
    {          	
        String URL="jdbc:mysql://localhost:3333/unusualevents";//DB name  
        String NAME="root";//login name
        String PASSWORD="0408";//password
        
        try {  

            Class.forName("com.mysql.jdbc.Driver");  
        } catch (ClassNotFoundException e) {  
            System.out.println("Cannot run Driver");  
            e.printStackTrace();  
        }  
        Connection conn = null;
        try {  
        	 conn =DriverManager.getConnection(URL, NAME, PASSWORD);  
            
                System.out.println("Connect to Database successfully！");  
        } catch (SQLException e) {  
            System.out.println("Connect to Database unsuccessfully");  
            e.printStackTrace();  
        }  
        return conn;  
 
    }  
}  
