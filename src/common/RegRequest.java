package common;

import java.net.URL;

/**
 * 注册请求数据结构
 *
 * @author Zhizhuo Song
 * @version 2020/3/7
 */
public class RegRequest extends Protocol {
    private String strUserName; //用户名
    private String strPassword; // 密码
    private String mySignature; // 个性签名
    private int myIcon; // 头像URL地址

    /**
     * 构造函数
     * @param strUserName 用户名
     * @param strPassword 密码
     * @param mySignature 个性签名
     * @param myIcon 头像
     */

    public RegRequest(String strUserName, String strPassword, String mySignature, int myIcon) {
        super(Type.Reg);
        this.strUserName = strUserName;
        this.strPassword = strPassword;
        this.mySignature = mySignature;
        this.myIcon = myIcon;
    }

    // 下面是成员变量的get方法
    /**
     * Getter for the strUserName.
     *
     * @return the value of strUserName.
     */
    public String getStrUserName() {
        return strUserName;
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
     * Getter for the mySignature.
     *
     * @return the value of mySignature.
     */
    public String getMySignature() {
        return mySignature;
    }

    /**
     * Getter for the myIcon.
     *
     * @return the value of myIcon.
     */
    public int getMyIcon() {
        return myIcon;
    }
}
