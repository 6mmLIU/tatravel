package cn.sixmm.sixsixsix.auth.form;

/**
 * 用户注册对象
 * 
 * @author ruoyi
 */
public class RegisterBody extends LoginBody
{
    private String nickname;

    private String verifyCode;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
