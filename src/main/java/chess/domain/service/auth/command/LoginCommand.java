package chess.domain.service.auth.command;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by YJH on 2016/4/5.
 */
public class LoginCommand {

    @NotBlank(message = "{login.userName.NotBlank.messages}")
    private String userName;
    @NotBlank(message = "{login.password.NotBlank.messages}")
    private String password;
    @NotBlank(message = "{login.verificationCode.NotBlank.messages}")
    private String verificationCode;
    private boolean rememberMe;

    private String loginIP;
    private String loginPlatform;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public String getLoginPlatform() {
        return loginPlatform;
    }

    public void setLoginPlatform(String loginPlatform) {
        this.loginPlatform = loginPlatform;
    }

}
