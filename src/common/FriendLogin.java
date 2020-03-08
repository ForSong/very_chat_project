package common;

/**
 * 好友上线
 *
 * @author Zhizhuo Song
 * @version 2020/3/7
 */
public class FriendLogin extends Protocol {
    private String strUserName; // 用户名

    /**
     * 构造方法
     * @param strUserName
     */
    public FriendLogin(String strUserName) {
        super(Type.FriendLogin);
        this.strUserName = strUserName;
    }

    /**
     * Getter for the strUserName.
     *
     * @return the value of strUserName.
     */
    public String getStrUserName() {
        return strUserName;
    }
}
