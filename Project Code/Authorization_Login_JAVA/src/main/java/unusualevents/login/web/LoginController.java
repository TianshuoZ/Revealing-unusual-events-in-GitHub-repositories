package unusualevents.login.web;

import com.alibaba.fastjson.JSONObject;
import unusualevents.login.config.Config;
import unusualevents.login.utils.RemoteOauthRequest;
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
        String token= jsonObject.get("access_token").toString();
        String url2 = Config.GITHUB_API_URL + token;
        String userinfo = RemoteOauthRequest.get(url2);
        JSONObject jsonUserI = JSONObject.parseObject(userinfo);
        System.out.println("jsonUserI:" + jsonUserI);
//        for(int i=0;i<jsonUserI.size();i++)
//        {
//        	System.out.println(jsonUserI)
//        	
//        }
//        
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
