package common;

/**
 * 聊天类
 *
 * @author Zhizhuo Song
 * @version 2020/3/7
 */
public class Chat extends Protocol {
    private String strSrcUserName; //源用户名
    private String strDstUserName; // 目标用户名
    private String strContent; // 消息内容
    private String strTime; // 发送时间

    /**
     * 构造方法
     * @param strSrcUserName
     * @param strDstUserName
     * @param strContent
     * @param strTime
     */
    public Chat(String strSrcUserName, String strDstUserName, String strContent, String strTime) {
        super(Type.Chat);
        this.strSrcUserName = strSrcUserName;
        this.strDstUserName = strDstUserName;
        this.strContent = strContent;
        this.strTime = strTime;
    }

    /**
     * Getter for the strSrcUserName.
     *
     * @return the value of strSrcUserName.
     */
    public String getStrSrcUserName() {
        return strSrcUserName;
    }

    /**
     * Getter for the strDstUserName.
     *
     * @return the value of strDstUserName.
     */
    public String getStrDstUserName() {
        return strDstUserName;
    }

    /**
     * Getter for the strContent.
     *
     * @return the value of strContent.
     */
    public String getStrContent() {
        return strContent;
    }

    /**
     * Getter for the strTime.
     *
     * @return the value of strTime.
     */
    public String getStrTime() {
        return strTime;
    }
}
