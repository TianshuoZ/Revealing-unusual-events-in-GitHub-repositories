package unusualevents.json.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class urlToJson {
	
	public JSONObject toJson(String url){
		
		StringBuffer buffer = new StringBuffer();
		
		JSONObject jsonData = null;
		try {
			
			URL testUrl;
			testUrl = new URL(url);
			URLConnection conUrl = testUrl.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conUrl.getInputStream(),"utf-8"));
			
			String str = null;  
	           while ((str = in.readLine()) != null) {  
	               buffer.append(str);  
	           }  
	           in.close();  
	           jsonData =  JSONObject.parseObject(buffer.toString());
				
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonData;
	}
	
	
public JSONArray toJsonArray(String url){
		
		StringBuffer buffer = new StringBuffer();
		
		JSONArray jsonData = null;
		try {
			
			URL testUrl;
			testUrl = new URL(url);
			URLConnection conUrl = testUrl.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conUrl.getInputStream(),"utf-8"));
			
			String str = null;  
	           while ((str = in.readLine()) != null) {  
	               buffer.append(str);  
	           }  
	           in.close();  
	           jsonData = (JSONArray) JSONArray.parse(buffer.toString());
				
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonData;
	}
	
	

}
