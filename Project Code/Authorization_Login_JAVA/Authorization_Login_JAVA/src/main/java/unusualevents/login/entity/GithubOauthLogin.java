package unusualevents.login.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GithubOauthLogin {
	private String client_id;

    private String client_secret;

    private String code;

    private String redirect;

    private String state;

    private String scope;

    private boolean allow_signup;
}
