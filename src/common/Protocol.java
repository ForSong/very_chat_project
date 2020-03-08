package common;

import java.io.Serializable;

/**
 * 协议类继承序列化类，有一个枚举类型的成员变量和一个构造方法
 *
 * @author Zhizhuo Song
 * @version 2020/3/6
 */
public class Protocol implements Serializable {
    // 枚举类型，里面的每一个都是一个final的变量，类型都是Type
    public enum Type
    {
        Login,				// 登录
        Reg,				// 注册
        Chat,				// 聊天
        AddFriendRequest,	// 添加好友请求
        AddFriendResult,	// 添加好友结果
        Logoff,				// 离线请求
        FriendLogin,			// 好友登录通知
        GroupChat,          //群聊
        AddGroupRequest	// 添加好友请求
    };

    protected Type type;

    // 协议类型构造方法
    public Protocol(Type type) {
        this.type = type;
    }

    /**
     * Getter for the type.
     *
     * @return the value of type.
     */
    public Type getType() {
        return type;
    }
}
