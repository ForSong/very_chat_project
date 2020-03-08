package common;

import java.io.FileInputStream;
import java.net.InetAddress;
import java.util.Properties;

public class Config
{
	private static Properties s_settings = new Properties();	// 配置文件读取者	

	/**
	 * 静态构造方法。在这个方法中，加载配置文件。
	 */
	static
	{
		try
		{
			FileInputStream fis = new FileInputStream(Const.CONFIG_FILE_NAME);
			s_settings.load(fis);
			s_settings.get(Const.CONFIG_SERVER_ADDR);
			fis.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 获取服务器 IP 地址。
	 * @return 服务器 IP 地址
	 */
	public static InetAddress getServerAddr()
	{
		InetAddress ip = null;
		try
		{
			ip = InetAddress.getByName("127.0.0.1");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ip;
	}

	/**
	 * 获取服务器端口号。
	 * @return 服务器端口号
	 */
	public static int getServerPort()
	{
		return 5000;
	}


}
