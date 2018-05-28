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

public class issueHistoryTable {
	private String issue_event_url;
	
	public void issueHistoryTable(String issue_Event_Url){
		
		issue_event_url = issue_Event_Url.replace("{/number}", "?page=");
		
		
	}
	
	public void addissueHistoryTable(){
		
		int page=1;
		urlToJson urlTojson = new urlToJson();
		JSONArray issueEventAll = urlTojson.toJsonArray(issue_event_url+page);
		while(issueEventAll.size()!=0)
		{
			for(int i=0;i<issueEventAll.size();i++)
			{
				JSONObject issueEvent = JSONObject.parseObject(issueEventAll.get(i).toString());
				String issueEventId = issueEvent.getString("id");   // issue_history_id
				JSONObject issue = JSONObject.parseObject(issueEvent.getString("issue"));
				String state = issue.getString("state");            // state
				String issueID = issue.getString("id");               // issue_id_f
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
				Timestamp issueCloseDate = null;       // issue close Date
				if(issue.getString("closed_at")!="null")
				{
					try {
						Date date=dateFormat.parse(issue.getString("closed_at"));
						issueCloseDate = new Timestamp(date.getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				
				//------------------------add to database
				ConfigDB configDB = new ConfigDB();
				Connection conn = configDB.sqlConnection();
				
				String sql = "insert into issue_history (issue_history_id, issue_status, date, issue_id_f) values (?,?,?,?)";
				
				try {
					PreparedStatement preparedStmt = conn.prepareStatement(sql);
					preparedStmt.setString (1, issueEventId);
					preparedStmt.setString (2, state);
					preparedStmt.setTimestamp(3, issueCloseDate);
					preparedStmt.setString (4, issueID);  //
					preparedStmt.execute();
					System.out.println("The number of "+ i+" issue history has been successfully added");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
				
				
			}
			
			
			
			page++;
			issueEventAll = urlTojson.toJsonArray(issue_event_url+page);
		}
		
		
		
		String issue_event_id;
		
		
		
	}

}
