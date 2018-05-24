package unusualevents.login.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import unusualevents.db.Service.userTable;
import unusualevents.json.service.urlToJson;
import unusualevents.login.config.Config;
import unusualevents.login.utils.RemoteOauthRequest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("login", "login");
        return "login/login";
    }

    @GetMapping("login/github")
    public String loginGithub(String code, Model model) {
        logger.info(code);
        System.out.println("code: " + code);
        String url = Config.ACCESS_TOKEN_URL;

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", Config.CLIENT_ID);
        map.add("client_secret", Config.CLIENT_SECRET);
        map.add("code", code);
        System.out.println(map.toString());
        
        JSONObject jsonObject = RemoteOauthRequest.post(url, map, JSONObject.class);
        System.out.println("jsonObject:" + jsonObject);
        model.addAttribute("result1", jsonObject);
        
        //-----------------
        String token = jsonObject.get("access_token").toString();
        String url2 = Config.GITHUB_API_URL + token;
        String userinfo = RemoteOauthRequest.get(url2);
        JSONObject jsonUserI = JSONObject.parseObject(userinfo);
        
        //System.out.println(jsonUserI.getString("login"));
        //System.out.println(jsonUserI.getString("id"));
        //System.out.println(jsonUserI.getString("avatar_url"));
        
        String id = jsonUserI.getString("id");
        String username = jsonUserI.getString("login");
        String avatar_url = jsonUserI.getString("avatar_url");
        String repository_number = jsonUserI.getString("public_repos");
        
        String a = "https://api.github.com/repos/XiyuZhang/Revealing-unusual-events-in-GitHub-repositories/commits";
        String b = "59dbf675c23438fddb707d661e79617c7df910f5";
        
        urlToJson reposUrl = new urlToJson();
        
        JSONObject reposJson = reposUrl.toJson(a+"/"+b);
        System.out.println(reposJson.toString());
        JSONObject stats = JSONObject.parseObject(reposJson.get("stats").toString());
        System.out.println(stats.get("total").toString());
        System.out.println(stats.get("additions").toString());
        System.out.println(stats.get("deletions").toString());
   //     JSONArray reposJson = reposUrl.toJsonArray(jsonUserI.getString("repos_url"));
        
       
        /*
        System.out.println("-1-------------------------------"); 
        System.out.println(reposJson.get(0).toString()); 
        
        System.out.println("-2-------------------------------"); 
        JSONObject test = JSONObject.parseObject(reposJson.get(0).toString());
        System.out.println(test.toJSONString());
        System.out.println(test.get("owner").toString());
        System.out.println("-3-------------------------------"); 
        JSONObject owner = JSONObject.parseObject(test.get("owner").toString());
        System.out.println(owner.get("gists_url"));
        */
        
        

 //--------------------add user table     
 /*
        userTable adduser = new userTable();
        if(adduser.addUser(id, username, avatar_url, repository_number)==1)
        {
        	System.out.println("Add user in table successfully"); 
        }else
        	System.out.println("Add user in table unsuccessfully");
//--------------------add user table*/
        
//========================================================================================
        
//        System.out.println("jsonUserI:" + jsonUserI.toString());
        
        model.addAttribute("result2", userinfo);

        DigestUtils.md5DigestAsHex(userinfo.getBytes());
        
        return "login/success";
    }

    

    
    
    
    
    
    
    
    
 //-----------------------------------------------------------------------------------------   
    @GetMapping("user/info")
    public String getGitHubUserInfo(String token, Model model) {
        String url = Config.GITHUB_API_URL + token;
        String result = RemoteOauthRequest.get(url);
        model.addAttribute("result", result);

        DigestUtils.md5DigestAsHex(result.getBytes());

        return "login/success";


    }
}




























