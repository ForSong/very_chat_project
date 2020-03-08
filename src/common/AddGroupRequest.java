package common;

import java.net.URL;
import java.util.ArrayList;

/**
 * This Class
 *
 * @author Zhizhuo Song
 * @version 2020/3/7
 */
public class AddGroupRequest extends Protocol {
    private String strMyUserName; // 我的名字
    private ArrayList<String> strDstUserNames; // 要加的好友的名字
    private URL myIconURL; //我的头像的URL
    private ArrayList<URL> friendsIconURL; // 好友头像列表

    public AddGroupRequest(String strMyUserName, ArrayList<String> strDstUserNames,
                           URL myIconURL, ArrayList<URL> friendsIconURL) {
        super(Type.AddGroupRequest);
        this.strMyUserName = strMyUserName;
        this.strDstUserNames = strDstUserNames;
        this.myIconURL = myIconURL;
        this.friendsIconURL = friendsIconURL;
    }
    /**
     * Getter for the strMyUserName.
     *
     * @return the value of strMyUserName.
     */
    public String getStrMyUserName() {
        return strMyUserName;
    }

    /**
     * Getter for the strDstUserNames.
     *
     * @return the value of strDstUserNames.
     */
    public ArrayList<String> getStrDstUserNames() {
        return strDstUserNames;
    }

    /**
     * Getter for the myIconURL.
     *
     * @return the value of myIconURL.
     */
    public URL getMyIconURL() {
        return myIconURL;
    }

    /**
     * Getter for the friendsIconURL.
     *
     * @return the value of friendsIconURL.
     */
    public ArrayList<URL> getFriendsIconURL() {
        return friendsIconURL;
    }
}
