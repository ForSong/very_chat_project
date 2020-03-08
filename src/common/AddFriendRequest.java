package common;

import java.net.URL;

/**
 * 添加好友请求
 *
 * @author Zhizhuo Song
 * @version 2020/3/7
 */
public class AddFriendRequest extends Protocol {
    private String strMyUserName; // 我的名字
    private String strDstUserName; // 要加的好友的名字
    private int myIcon; //我的头像的URL

    /**
     * 构造方法
     * @param strMyUserName
     * @param strDstUserName
     * @param myIcon
     */
    public AddFriendRequest(String strMyUserName, String strDstUserName, int myIcon) {
        super(Type.AddFriendRequest);
        this.strMyUserName = strMyUserName;
        this.strDstUserName = strDstUserName;
        this.myIcon = myIcon;
    }

    /**
     * 获取我的名字
     * Getter for the strMyUserName.
     *
     * @return the value of strMyUserName.
     */
    public String getStrMyUserName() {
        return strMyUserName;
    }

    /**
     * 获取要加的人的名字
     * Getter for the strHerUserName.
     *
     * @return the value of strHerUserName.
     */
    public String getStrDstUserName() {
        return strDstUserName;
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
