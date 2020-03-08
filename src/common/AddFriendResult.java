package common;

import java.net.URL;

/**
 * 添加好友结果
 *
 * @author Zhizhuo Song
 * @version 2020/3/7
 */
public class AddFriendResult extends Protocol {
    private ResultCode.Code resultCode; //结果
    private String strSrcUserName; // 源用户名
    private String strDstUserName; // 目标用户名
    private int dstIcon; //目标用户头像URL

    /**
     * 构造方法
     * @param resultCode
     * @param strSrcUserName
     * @param strDstUserName
     * @param dstIcon
     */
    public AddFriendResult(ResultCode.Code resultCode, String strSrcUserName,
                           String strDstUserName, int dstIcon) {
        super(Type.AddFriendResult);
        this.resultCode = resultCode;
        this.strSrcUserName = strSrcUserName;
        this.strDstUserName = strDstUserName;
        this.dstIcon = dstIcon;
    }

    /**
     * 获取结果
     * Getter for the resultCode.
     *
     * @return the value of resultCode.
     */
    public ResultCode.Code getResultCode() {
        return resultCode;
    }

    /**
     * 获取源用户名
     * Getter for the strSrcUserName.
     *
     * @return the value of strSrcUserName.
     */
    public String getStrSrcUserName() {
        return strSrcUserName;
    }

    /**
     * 获取目标用户名
     * Getter for the strDstUserName.
     *
     * @return the value of strDstUserName.
     */
    public String getStrDstUserName() {
        return strDstUserName;
    }

    /**
     * Getter for the dstIcon.
     *
     * @return the value of dstIcon.
     */
    public int getDstIcon() {
        return dstIcon;
    }


}
