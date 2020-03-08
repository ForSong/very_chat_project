package common;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 登录结果的数据类型
 *
 * @author Zhizhuo Song
 * @version 2020/3/6
 */
public class LoginResult extends Protocol {
    private ResultCode.Code resultCode; //登录结果
    private int myIcon; // 头像索引
    private int myFriendCount; //好友数
    private LinkedList<String> friednsName; // 好友名列表
    private ArrayList<URL> friendIconURL;// 好友头像URL表
    private boolean[] friendsOnline = new boolean[Const.MAX_FRIENDS_COUNT]; //好友在线列表状态
    private ArrayList<String> history; //历史记录

    /**
     * @Title: LoginResult 构造方法
     * @return
     */
    public LoginResult() {
        super(Type.Login);
    }

    /**
     * 获取登录结果
     *
     * @return the value of resultCode.
     */
    public ResultCode.Code getResultCode() {
        return resultCode;
    }

    /**
     * Getter for the myIcon.
     *
     * @return the value of myIcon.
     */
    public int getMyIcon() {
        return myIcon;
    }



    /**
     * 获取好友数
     *
     * @return the value of myFriendCount.
     */
    public int getMyFriendCount() {
        return myFriendCount;
    }

    /**
     * 获取好友列表
     *
     * @return the value of friednsName.
     */
    public LinkedList<String> getFriednsName() {
        return friednsName;
    }

    /**
     * 获取好友头像的URL集合
     *
     * @return the value of friendIconURL.
     */
    public ArrayList<URL> getFriendIconURL() {
        return friendIconURL;
    }

    /**
     * 获取某个好友是否在线
     *
     * @return the value of friendsOnline.
     */
    public boolean getFriendsOnline(int index) {
        return friendsOnline[index];
    }

    /**
     * 获取历史记录集合
     *
     * @return the value of history.
     */
    public ArrayList<String> getHistory() {
        return history;
    }

    /**
     * 设置登录状态
     * The resultCode of LoginResult is updated.
     *
     * <p>You can use getResultCode() to get the value of resultCode</p>
     *
     * @param resultCode resultCode
     */
    public void setResultCode(ResultCode.Code resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * Setter for the myIcon.
     * The myIcon of LoginResult is updated.
     *
     * <p>You can use getMyIcon() to get the value of myIcon</p>
     *
     * @param myIcon myIcon
     */
    public void setMyIcon(int myIcon) {
        this.myIcon = myIcon;
    }



    /**
     * 设置好友数量
     * The myFriendCount of LoginResult is updated.
     *
     * <p>You can use getMyFriendCount() to get the value of myFriendCount</p>
     *
     * @param myFriendCount myFriendCount
     */
    public void setMyFriendCount(int myFriendCount) {
        this.myFriendCount = myFriendCount;
    }

    /**
     * 设置好友集合
     * The friednsName of LoginResult is updated.
     *
     * <p>You can use getFriednsName() to get the value of friednsName</p>
     *
     * @param friednsName friednsName
     */
    public void setFriednsName(LinkedList<String> friednsName) {
        this.friednsName = friednsName;
    }

    /**
     * 设置好友名列表
     * Setter for the friendIconURL.
     * The friendIconURL of LoginResult is updated.
     *
     * <p>You can use getFriendIconURL() to get the value of friendIconURL</p>
     *
     * @param friendIconURL friendIconURL
     */
    public void setFriendIconURL(ArrayList<URL> friendIconURL) {
        this.friendIconURL = friendIconURL;
    }

    /**
     * 设置某个好友是否在线
     * Setter for the friendsOnline.
     * The friendsOnline of LoginResult is updated.
     *
     * <p>You can use getFriendsOnline() to get the value of friendsOnline</p>
     *
     * @param index index of friends
     * @param isOnline status
     */
    public void setFriendsOnline(int index, boolean isOnline) {
        friendsOnline[index] = isOnline;
    }
}
