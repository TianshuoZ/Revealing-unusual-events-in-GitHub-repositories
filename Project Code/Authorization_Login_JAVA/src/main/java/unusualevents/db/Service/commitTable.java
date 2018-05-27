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

public class commitTable {
	private String userid="";
	private String reponame="";
	private String username="";
	private String commiturl="";
	private String repoid="";
	
	public int commitTable(String userID,String userName,String repoName, String repoId){
		userid = userID;
		reponame = repoName;
		username = userName;
		commiturl = "https://api.github.com/repos/"+username+"/"+reponame+"/commits?status=all&page=";
		repoid = repoId;
		return 0;
	}
	
	public void addCommitTable(){
		urlToJson urlTojson = new urlToJson();
		int page =1;
		
		JSONArray commiteArray =urlTojson.toJsonArray(commiturl+page);
		int size = commiteArray.size();
		int count=1;
		while(size!=0)
		{
			for(int i=0;i<commiteArray.size();i++)
			{
				JSONObject commit= JSONObject.parseObject(commiteArray.get(i).toString());
				String commit_id = commit.getString("sha");     // commit ID
				
				JSONObject commit_=JSONObject.parseObject(commit.getString("commit"));
				JSONObject commit_author=JSONObject.parseObject(commit_.getString("author"));
				String commit_date= commit_author.getString("date");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
				Timestamp commitDate = null;       // commit date
				
				try {
					Date date=dateFormat.parse(commit_date);
					commitDate = new Timestamp(date.getTime());
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String comment_number = commit.getString("comment_count");  // comment number
				
				//----------------file change, added, deleted, modified
				String commit_sha_url = commit.getString("url");
				JSONObject commit_sha = urlTojson.toJson(commit_sha_url);
				JSONObject stats = JSONObject.parseObject(commit_sha.get("stats").toString());
				int added = stats.getIntValue("additions");   // lines added
				int deleted = stats.getIntValue("deletions");   // lines deleted
				int modified = stats.getIntValue("total");		// lines modified
				
				JSONArray filesArry = JSONArray.parseArray(commit_sha.getString("files"));
				int files_changes =0;                           // files changes number
				for(int j=0;j<filesArry.size();j++)
				{
					JSONObject file = JSONObject.parseObject(filesArry.get(j).toString());
					if(file.getInteger("changes")!=0)
						files_changes++;
				}
			//-------------------------insert DB
				ConfigDB configDB = new ConfigDB();
				Connection conn = configDB.sqlConnection();
				
				
				String sql = "insert into commit (commit_id, comment_number, repository_idc, file_change, lines_added, lines_deleted, lines_modified,commit_date,user_id) values (?,?,?,?,?,?,?,?,?)";
				
				try {
					PreparedStatement preparedStmt = conn.prepareStatement(sql);
					preparedStmt.setString (1, commit_id);
					preparedStmt.setString (2, comment_number);
					preparedStmt.setString(3, repoid);
					preparedStmt.setString (4, files_changes+"");  //
					preparedStmt.setInt (5, added);  //
					preparedStmt.setInt (6, deleted);
					preparedStmt.setInt (7, modified);
					preparedStmt.setTimestamp (8, commitDate);
					preparedStmt.setString (9, userid);
					preparedStmt.execute();
					System.out.println("The number of "+ (count++)+" commit has been successfully added");
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
				
			}
			page++;
			commiteArray.clear();
			commiteArray =urlTojson.toJsonArray(commiturl+page);
			size = commiteArray.size();
			
			
		}
		
		
		
	}
	
	

}
