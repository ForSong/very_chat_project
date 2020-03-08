package common;

/**
 * 下线请求类
 *
 * @author Zhizhuo Song
 * @version 2020/3/7
 */
public class LogoffRequest extends Protocol {
    private String strUserName; // 用户名

    /**
     * 构造方法
     * @param strUserName
     */
    public LogoffRequest(String strUserName) {
        super(Type.Logoff);
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
