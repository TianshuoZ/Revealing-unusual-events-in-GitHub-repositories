package unusualevents.db.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userTable {
	
	public int addUser(String user_id,String user_name,String user_avatar,String repository_number){
		int flag = 0;
		ConfigDB configDB = new ConfigDB();
		Connection conn = configDB.sqlConnection();
		
		
		String sql = "insert into user (user_id,user_name,user_avatar,repository_number) values (?,?,?,?)";
		
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString (1, user_id);
			preparedStmt.setString (2, user_name);
			preparedStmt.setString (3, user_avatar);
			preparedStmt.setString (4, repository_number);
			if(preparedStmt.execute())
				flag =1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return flag;
	}

}
