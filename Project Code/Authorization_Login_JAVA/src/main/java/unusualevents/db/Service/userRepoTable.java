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

public class userRepoTable {
	private String userid="";
	private String repourl="";
	
	public JSONArray userRepoTable(String userID,String repoUrl){
		userid = userID;
		repourl = repoUrl;
		
		JSONArray repoArray=null;
		urlToJson repoA= new urlToJson();
		return repoArray = repoA.toJsonArray(repoUrl);
		
	}

	public int addUserRepo(JSONObject repos ){
	
		String repo_id= repos.getString("id");
		String repo_name=repos.getString("name");
	//----------------date----------
		String repo_date=repos.getString("created_at");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		Timestamp repoDate = null;
		
		try {
			Date date=dateFormat.parse(repo_date);
			repoDate = new Timestamp(date.getTime());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//====================================================================
	//----------------pull request number-------------
		String pull_requNumber_url=repos.getString("pulls_url").replace("{/number}", "");
		
		urlToJson pull_requ = new urlToJson();
		JSONArray pull_requNumber =pull_requ.toJsonArray(pull_requNumber_url);
		int pull_number = pull_requNumber.size();
		
	//====================================================================
	//------------------------issues number------------------------
		String issues_url="https://api.github.com/search/issues?q=repo:XiyuZhang/Revealing-unusual-events-in-GitHub-repositories+type:issue";
		JSONObject issuesNumber =pull_requ.toJson(issues_url);
		int issues_number= issuesNumber.getIntValue("total_count");
		
	
		
	//============================================================================
	//-----------------------commit number, sum of contributors' contributions
		String contributors_url=repos.getString("contributors_url");
		urlToJson contributors = new urlToJson();
		JSONArray contributorsArray =contributors.toJsonArray(contributors_url); 
		int commit_number=0;    // commit number
		for(int i = 0; i<contributorsArray.size();i++){
			JSONObject contributor = JSONObject.parseObject(contributorsArray.get(i).toString());
			commit_number += contributor.getIntValue("contributions");
		}
	//=======================================================================
	//------------------------add to database
		int flag = 0;
		ConfigDB configDB = new ConfigDB();
		Connection conn = configDB.sqlConnection();
		
		
		String sql = "insert into user_repository (repository_id, repository_name, commit_number, pull_request_number, issue_number, user_id, create_date) values (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString (1, repo_id);
			preparedStmt.setString (2, repo_name);
			preparedStmt.setInt(3, commit_number);
			preparedStmt.setInt (4, pull_number);  //
			preparedStmt.setInt (5, issues_number);  //
			preparedStmt.setString (6, userid);
			preparedStmt.setTimestamp (7, repoDate);
			preparedStmt.execute();
			flag=1;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		System.out.println(flag);
		return flag;
		
	}
	
	
}
