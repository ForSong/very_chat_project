package common;

/**
 * 固定值的类
 *
 * @author Zhizhuo Song
 * @version 2020/3/6
 */
public class Const {
    // 数据长度
    public static final int MAX_USER_NAME_LEN = 11;				// 最大用户名长度
    public static final int MAX_PASSWORD_LEN = 12;				// 最大密码长度
    public static final int MAX_CONTENT_LEN = 1023;				// 一次发送的最大聊天内容长度
    public static final int MAX_FRIENDS_COUNT = 100;			// 最大好友数
    public static final int MAX_FRIEND_NAMES_LEN =
            MAX_USER_NAME_LEN * MAX_FRIENDS_COUNT;					// 所有图标的名字加在一起的最大长度
    public static final int TIME_LEN = 19;						// 时间长度

    // 可配置内容
    public static final String CONFIG_FILE_NAME =
            "chat_room/src/config/Config.ini";										// 配置文件的文件名
    public static final String CONFIG_SERVER_ADDR = "IP";		// 服务器 IP 地址
    public static final String CONFIG_SERVER_PORT = "Port";		// 服务器端口号
    public static final String CONFIG_IS_TCP = "IsTcp";			// Tcp、Udp 协议标志
}
