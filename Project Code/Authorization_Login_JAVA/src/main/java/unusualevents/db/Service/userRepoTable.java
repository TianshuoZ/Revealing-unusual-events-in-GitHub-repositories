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
	private String username="";
	
	public JSONArray userRepoTable(String userID,String userName,String repoUrl){
		userid = userID;
		repourl = repoUrl;
		username = userName;
		
		JSONArray repoArray=null;
		urlToJson repoA= new urlToJson();
		return repoArray = repoA.toJsonArray(repoUrl);
		
	}

	public String[] addUserRepo(JSONObject repos ){
		
		String result[]={"F","",""};   // flag, repoID, repoName
	
		String repo_id= repos.getString("id");
		result[1]= repos.getString("id");
		
		String repo_name=repos.getString("name");
		result[2]= repos.getString("name");
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
		
		String issues_url="https://api.github.com/search/issues?q=repo:"+username+"/"+repo_name+"+type:issue";
		JSONObject issuesNumber =pull_requ.toJson(issues_url);
		int issues_number= issuesNumber.getIntValue("total_count");
		
		
	//============================================================================
	//-----------------------commit number, sum of commitArray's size
		int commit_number=0;    // commit number
		String commit_url="https://api.github.com/repos/"+username+"/"+repo_name+"/commits?status=all&page=";
		int page =1;
		urlToJson urlTojson = new urlToJson();
		int size = urlTojson.toJsonArray(commit_url+page).size();
		while(size!=0)
		{
			commit_number += size;
			page++;
			size = urlTojson.toJsonArray(commit_url+page).size();
		}
		
		
/*		String contributors_url=repos.getString("contributors_url");
		urlToJson contributors = new urlToJson();
		JSONArray contributorsArray =contributors.toJsonArray(contributors_url); 
		
		for(int i = 0; i<contributorsArray.size();i++){
			JSONObject contributor = JSONObject.parseObject(contributorsArray.get(i).toString());
			commit_number += contributor.getIntValue("contributions");
		}
		
		
*/		
		
		
	//=======================================================================
	//------------------------add to database
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
			result[0]="T";
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		System.out.println(result[0]);
		return result;
		
	}
	
	
}
