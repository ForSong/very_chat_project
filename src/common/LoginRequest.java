package common;

/**
 * 登录请求数据类型，包含用户名和密码
 *
 * @author Zhizhuo Song
 * @version 2020/3/6
 */
public class LoginRequest extends Protocol {
    private String strUserName; //用户名
    private String strPassword; //密码

    /**
     * 登录请求构造方法
     * @param strUserName 用户名
     * @param strPassword 密码
     */
    public LoginRequest(String strUserName, String strPassword) {
        super(Type.Login);
        this.strUserName = strUserName;
        this.strPassword = strPassword;
    }


    /**
     * Getter for the strUserName.
     *
     * @return the value of strUserName.
     */
    public String getStrUserName() {
        return strUserName;
    }

    /**
     * Setter for the strUserName.
     * The strUserName of LoginRequest is updated.
     *
     * <p>You can use getStrUserName() to get the value of strUserName</p>
     *
     * @param strUserName strUserName
     */
    public void setStrUserName(String strUserName) {
        this.strUserName = strUserName;
    }

    /**
     * Getter for the strPassword.
     *
     * @return the value of strPassword.
     */
    public String getStrPassword() {
        return strPassword;
    }

    /**
     * Setter for the strPassword.
     * The strPassword of LoginRequest is updated.
     *
     * <p>You can use getStrPassword() to get the value of strPassword</p>
     *
     * @param strPassword strPassword
     */
    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }
}
