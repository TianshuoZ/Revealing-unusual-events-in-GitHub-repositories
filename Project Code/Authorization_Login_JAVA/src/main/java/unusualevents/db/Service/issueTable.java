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

public class issueTable {
	private String userid;
	private String username;
	private String reposname;
	private String reposid;
	private String issue_url;
	
	public void issueTable(String userId, String userName, String reposName, String reposId){
		
		userid = userId;
		username = userName;
		reposname = reposName;
		reposid = reposId;
		issue_url = "https://api.github.com/search/issues?q=repo:"+username+"/"+reposname+"+type:issue&page=";
		
	}
	public void addIssueTable(){
		
		int page=1;
		urlToJson urlTojson = new urlToJson();
		
		JSONObject issueAll = urlTojson.toJson(issue_url+page);
		JSONArray  issueArray = JSONArray.parseArray(issueAll.getString("items"));
		while(issueArray.size()!=0)
		{
			for(int i=0;i<issueArray.size();i++)
			{
				JSONObject issue = JSONObject.parseObject(issueArray.get(i).toString());
				String issueid = issue.getString("id");   // issue id
				String issuetitle = issue.getString("title");// issue title
				String issuebody = issue.getString("body");// issue body
				String issuecommentNumber = issue.getString("comments");
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
				Timestamp issueDate = null;       // issue Date
				try {
					Date date=dateFormat.parse(issue.getString("created_at"));
					issueDate = new Timestamp(date.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String issueLabe = "";     // issue label
				JSONArray  issueLabeArray = JSONArray.parseArray(issue.getString("labels"));
				for(int j=0;j<issueLabeArray.size();j++)
				{
					JSONObject issueName = JSONObject.parseObject(issueLabeArray.get(j).toString());
					issueLabe = issueLabe + issueName.getString("name")+",";
					
				}
				
				//------------------------add to database
				ConfigDB configDB = new ConfigDB();
				Connection conn = configDB.sqlConnection();
				
				String sql = "insert into issue (issue_id, comment_number, repository_idi, title, body, issue_date, issue_label,user_id) values (?,?,?,?,?,?,?,?)";
				
				try {
					PreparedStatement preparedStmt = conn.prepareStatement(sql);
					preparedStmt.setString (1, issueid);
					preparedStmt.setString (2, issuecommentNumber);
					preparedStmt.setString(3, reposid);
					preparedStmt.setString (4, issuetitle);  //
					preparedStmt.setString (5, issuebody);  //
					preparedStmt.setTimestamp (6, issueDate);
					preparedStmt.setString (7, issueLabe);
					preparedStmt.setString (8, userid);
					preparedStmt.execute();
					System.out.println("The number of "+ i+" issue has been successfully added");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
			}
			
			
			page++;
			issueAll = urlTojson.toJson(issue_url+page);
			issueArray = JSONArray.parseArray(issueAll.getString("items"));
		}
		
		
		
	}
	
	
	
	

}
