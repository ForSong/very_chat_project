package client;

import common.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 * This Class
 *
 * @author Zhizhuo Song
 * @version 2020/3/7
 */
public class Client {

    private Socket tcpClient;
    private InetAddress ServerAddr;
    private int serverPort;
    private ClientEventHandler eventHandler;
    private static String strName; //用户名
    private int myIcon;       // 头像头像索引
    private int	friendCount = 0;		// 好友数
    private ObjectOutputStream sender;				// 数据发送者

    private Thread tcpThread = new Thread()			// tcp 线程
    {
        /**
         * 通信线程方法。在这个方法中，接收网络数据。
         */
        @Override
        public void run()
        {
            Protocol protocol = null;			// 协议
            ObjectInputStream receiver = null;	// 网络数据接收者
            try
            {
                // 创建网络数据接收者
                receiver = new ObjectInputStream(tcpClient.getInputStream());
                while (!tcpClient.isClosed())
                {
                    // 接收服务器发来的数据
                    protocol = (Protocol)receiver.readObject();

                    // 处理数据
                    Client.this.onGetMessageFromServer(protocol);
                }
            }
            catch (Exception e)
            {
                try
                {
                    receiver.close();
                }
                catch (Exception e2)
                {
                    return;
                }
                return;
            }
            try
            {
                receiver.close();
            }
            catch (Exception e2)
            {
                return;
            }
        }
    };

    /**
     * 构造方法。
     * @param eventHandler	事件处理者
     */
    public Client(ClientEventHandler eventHandler)
    {

            try
            {
                // 创建 Tcp 客户端
                tcpClient = new Socket();

                // 连接服务器
                InetAddress	serverAddr = Config.getServerAddr();	// 服务器 IP 地址
                int	nServerPort = Config.getServerPort();			// 服务器端口号
                tcpClient.connect(new InetSocketAddress(serverAddr, nServerPort));

                // 初始化成员
                this.eventHandler = eventHandler;
                sender = new ObjectOutputStream(tcpClient.getOutputStream());

                // 开启通信线程
                tcpThread.start();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
    }

    /**
     * 该方法通过页面对象 以及给定的id 选择页面的元素  用法:TextField t = (TextField)$(dialog,"UserName");
     * 这样选出登入框对象的id为UserName的输入框 之后就可以为 t 绑定事件了
     * @param window
     * @param id
     * @return
     */
    private Object $(Window window, String id) {
        return (Object) window.getRoot().lookup("#" + id);
    }

    /**
     * 登录。
     * @return 结果
     */
    public ResultCode.Code login() throws IOException {
        // 显示登录窗口
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.show();
//        String strUserName;
        String[] strInLambda = new String[10];

        ((Button) $(loginWindow,"enter")).setOnAction(event -> {
                    // 获取用户输入的用户名和密码
            strInLambda[0] = ((TextField) $(loginWindow, "UserName")).getText();
            strInLambda[1] = ((PasswordField) $(loginWindow, "Password")).getText();
        });
        String strUserName = strInLambda[0];
        String strPassword = strInLambda[1];
        // 发送登录请求
        LoginRequest request = new LoginRequest(strUserName, strPassword);
        ResultCode.Code result = this.sendData(request);
        if (result != ResultCode.Code.SUCCESS)
        {
            return result;
        }

        strName = strUserName;

        return ResultCode.Code.LOGON_SUCCESS;
    }
    /**
     * 发送数据。
     * @param protocol	数据
     * @return 结果
     */
    private ResultCode.Code sendData(Protocol protocol)
    {
        try
        {
                sender.writeObject(protocol);
        }
        catch (Exception e)
        {
            return ResultCode.Code.NETWORK_WRONG;
        }
        return ResultCode.Code.SUCCESS;
    }


    /**
     * 注册。
     * @return 结果
     */
    public ResultCode.Code reg() throws IOException {
        // 显示注册窗口
        Register register = new Register();
        String[] strs = new String[20];
        int[] icon = new int[2];
        ((Button) $(register,"register")).setOnAction(event -> {
            strs[0] = ((TextField) $(register,"account")).getText();
            strs[1] = ((TextField) $(register,"name")).getText();
            strs[2] = ((PasswordField) $(register,"password")).getText();
            strs[3] = ((TextField) $(register,"age")).getText();
            icon[0] = 1;

                    String accountRegExp = "^[0-9,a-z,A-Z,\\u4e00-\\u9fa5]{1,15}$";  //正则匹配：只能输入汉字，数字，字母，长度1-15
                    String passwordRegExp = "^[a-z,A-Z,0-9]{6,20}$";  //6-20位的数字或者字母
                    if(strs[0].equals("") || strs[2].equals("") || strs[3].equals("") ){
                        if(strs[0].equals("")){
                            register.setErrorTip("accountError","账号不能为空！");
                        }if(strs[2].equals("")){
                            register.setErrorTip("passwordError","密码不能为空！");
                        }if(strs[3].equals("")){
                            register.setErrorTip("rePasswordError","请确认密码！");
                        }
                    }
                    else if(!Pattern.matches(accountRegExp,strs[0]) || !Pattern.matches(passwordRegExp,strs[2])) {
                        if (!Pattern.matches(accountRegExp, strs[0])) {
                            register.setErrorTip("accountError", "只能输入长度1-15的汉字，数字，字母");
                        }
                        if (!Pattern.matches(passwordRegExp, strs[2])) {
                            register.setErrorTip("passwordError", "只能输入长度6-20的数字，字母");
                        }
                    }
        });
      

        // 获取用户名、密码和头像图标文件名
        String strUserName = strs[0];
        String signature = strs[1];
        String strPassword = strs[2];
        // TODO 注册时获取头像
        int nIconIndex = 1;

        // 发送注册请求
        RegRequest request = new RegRequest(strUserName, strPassword, signature,nIconIndex);
        ResultCode.Code result = this.sendData(request);
        if (result != ResultCode.Code.SUCCESS)
        {
            return result;
        }

        // 保存用户名和头像索引
        strName = strUserName;
        myIcon = nIconIndex;

        return ResultCode.Code.REG_SUCCESS;
    }

    /**
     * 聊天。
     * @param chat	聊天信息
     * @return 结果
     */
    public ResultCode.Code chat(Chat chat)
    {
        // 发送聊天信息
        return this.sendData(chat);
    }

    /**
     * 添加好友。
     * @param strFriendName  好友名字
     * @return 结果
     */
    public ResultCode.Code addFriend(String strFriendName)
    {
        // 检查是否超过好友上限
        if (friendCount > Const.MAX_FRIENDS_COUNT)
        {
            return ResultCode.Code.TOO_MANY_FRIENDS;
        }

        // 检查好友名
        if (strFriendName.isEmpty())
        {
            return ResultCode.Code.USER_NAME_EMPTY;
        }
        if (strFriendName.length() > Const.MAX_USER_NAME_LEN)
        {
            return ResultCode.Code.USER_NAME_TOO_LONG;
        }
        if (strFriendName.equals(strName))
        {
            return ResultCode.Code.FRIENDNAME_EQUAL_SELFNAME;
        }

        // 发送添加好友请求
        AddFriendRequest request = new AddFriendRequest(strName, strFriendName, myIcon);
        ResultCode.Code ResultCode = this.sendData(request);
        return ResultCode;
    }

    /**
     * 离线。
     * @return 结果
     */
    public ResultCode.Code logoff()
    {
        LogoffRequest request = new LogoffRequest(strName);
        strName = "";
        ResultCode.Code result = this.sendData(request);
        return result;
    }

    /**
     * 获取自己的名字。
     * @return 自己的名字
     */
    public static String getName()
    {
        return strName;
    }

    /**
     * 获取好友数。
     * @return	好友数
     */
    public int getFriendCount()
    {
        return friendCount;
    }

    /**
     * 服务器消息的响应方法。在这个方法中，将服务器发来的信息交给对应的方法来处理。
     * @param protocol	协议
     */
    private void onGetMessageFromServer(Protocol protocol) throws IOException {
        switch (protocol.getType())
        {
            case Login:
                this.handleLogonResult((LoginResult)protocol);
                break;
            case Reg:
                this.handleRegResult((RegResult)protocol);
                break;
            case Chat:
                this.handleChat((Chat)protocol);
                break;
            case AddFriendRequest:
                this.handleAddFriendRequest((AddFriendRequest)protocol);
                break;
            case AddFriendResult:
                this.handleAddFriendResult((AddFriendResult)protocol);
                break;
            case Logoff:
                this.handleFriendLogoff((LogoffRequest)protocol);
                break;
            case FriendLogin:
                this.handleFriendLogon((FriendLogin)protocol);
                break;
            default:
                break;
        }
    }

    /**
     * 处理登录结果。
     * @param result	登录结果
     */
    private void handleLogonResult(LoginResult result) throws IOException {
        eventHandler.onGetLogonResult(result);
        ResultCode.Code resultCode = result.getResultCode();
        if (resultCode == ResultCode.Code.LOGON_SUCCESS)
        {
            myIcon = result.getMyIcon();
            friendCount = result.getMyFriendCount();
        }
        else
        {
            strName = "";
            this.login();
        }
    }

    /**
     * 处理注册结果。
     * @param result	注册结果
     */
    private void handleRegResult(RegResult result) throws IOException {
        eventHandler.onGetRegResult(result);
        if ( result.getResultCode() != ResultCode.Code.REG_SUCCESS )
        {
            strName = "";
            this.reg();
        }
    }

    /**
     * 处理聊天。
     * @param chat	聊天信息
     */
    private void handleChat(Chat chat)
    {
        eventHandler.onChatS2C(chat);
    }

    /**
     * 处理添加好友请求。
     * @param request	添加好友请求
     */
    private void handleAddFriendRequest(AddFriendRequest request)
    {
        AddFriendResult result = null;
        String strSrcUserName = request.getStrMyUserName();
        String strDstUserName = request.getStrDstUserName();
        String strMessage = strSrcUserName;
        strMessage += "想添加您为好友是否同意";

        int nRet = JOptionPane.showConfirmDialog( null, strMessage,
                "Client", JOptionPane.YES_NO_OPTION );
        if (nRet == JOptionPane.YES_OPTION)	// 同意
        {
            friendCount++;

            // 生成结果
            result = new AddFriendResult(ResultCode.Code.ADD_FRIEND_ALLOW,
                    strSrcUserName, strDstUserName, myIcon);

            // 将对方加为好友
            eventHandler.onGetAddFriendRequest(request);
        }
        else								// 不同意
        {
            // 生成结果
            result = new AddFriendResult(ResultCode.Code.ADD_FRIEND_NOT_ALLOW,
                    strSrcUserName, strDstUserName, 0);
        }

        this.sendData(result);
    }

    /**
     * 处理添加好友结果。
     * @param result	添加好友结果
     */
    private void handleAddFriendResult(AddFriendResult result)
    {
        if ( result.getResultCode() == ResultCode.Code.ADD_FRIEND_ALLOW )
        {
            friendCount++;
        }
        eventHandler.onGetAddFriendResult(result);
    }

    /**
     * 处理其他用户的离线请求。
     * @param request	其他用户的离线请求
     */
    private void handleFriendLogoff(LogoffRequest request)
    {
        eventHandler.onFriendLogoff(request);
    }

    /**
     * 处理其他用户的登录消息。
     * @param friendLogon	其他用户的登录消息
     */
    private void handleFriendLogon(FriendLogin friendLogon)
    {
        eventHandler.onFriendLogon(friendLogon);
    }


    /**
     * 停止接收网络数据。
     */
    public void stop()
    {
        this.logoff();

        if (tcpClient != null)
        {
            try
            {
                tcpClient.shutdownInput();
                tcpClient.shutdownOutput();
                tcpClient.close();
            }
            catch (Exception e)
            {
            }
        }

    }

}
