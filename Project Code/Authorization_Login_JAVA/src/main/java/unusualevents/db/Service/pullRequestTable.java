package unusualevents.db.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import unusualevents.json.service.urlToJson;

public class pullRequestTable {
	private String userid;
	private String reposid;
	private String pull_url;
	JSONArray pullRequesArray;
	
	public void pullRequestTable(String userId, String reposId, String pullUrl){
		userid = userId;
		reposid = reposId;
		pull_url = pullUrl;
		
		urlToJson urlTojson = new urlToJson();
		pullRequesArray = urlTojson.toJsonArray(pull_url);
		
		
	}
	
	public void addPullRequest(){
		for(int i=0;i<pullRequesArray.size();i++)
		{
			JSONObject pullRequest = JSONObject.parseObject(pullRequesArray.get(i).toString());
			String pull_id = pullRequest.getString("id"); // pull request ID
			String title = pullRequest.getString("title"); // pull title
			String body = pullRequest.getString("body");   //  pull body
			String pull_date=pullRequest.getString("created_at");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			Timestamp pullDate = null;       // pull Date
			
			try {
				Date date=dateFormat.parse(pull_date);
				pullDate = new Timestamp(date.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//-------------comment number
			urlToJson urlTojson = new urlToJson();
			JSONObject pullLinke = urlTojson.toJson(pullRequest.getString("_links"));
			JSONObject pullComments = urlTojson.toJson(pullLinke.getString("comments"));
			JSONArray pullComment = urlTojson.toJsonArray(pullComments.getString("href"));
			String comment_number = pullComment.size()+"";
	//------------------------add to database
			ConfigDB configDB = new ConfigDB();
			Connection conn = configDB.sqlConnection();
			
			String sql = "insert into pull_request (pull_request_id, comment_number, repository_idp, title, body, pull_request_date, user_id) values (?,?,?,?,?,?,?)";
			
			try {
				PreparedStatement preparedStmt = conn.prepareStatement(sql);
				preparedStmt.setString (1, pull_id);
				preparedStmt.setString (2, comment_number);
				preparedStmt.setString(3, reposid);
				preparedStmt.setString (4, title);  //
				preparedStmt.setString (5, body);  //
				preparedStmt.setTimestamp (6, pullDate);
				preparedStmt.setString (7, userid);
				preparedStmt.execute();
				System.out.println("The number of "+ i+" pull request has been successfully added");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			
		}
		 
		
		
		
	}
	

}
