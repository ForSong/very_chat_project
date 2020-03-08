package common;

import java.util.ArrayList;

/**
 * This Class
 *
 * @author Zhizhuo Song
 * @version 2020/3/7
 */
public class GroupChat extends Protocol {
    private String strSrcUserName; //源用户名
    private ArrayList<String> strDstUserNames; // 目标用户列表
    private String strContent; // 消息内容
    private String strTime; // 发送时间

    public GroupChat(String strSrcUserName, ArrayList<String> strDstUserNames,
                     String strContent, String strTime) {
        super(Type.GroupChat);
        this.strSrcUserName = strSrcUserName;
        this.strDstUserNames = strDstUserNames;
        this.strContent = strContent;
        this.strTime = strTime;
    }
}
