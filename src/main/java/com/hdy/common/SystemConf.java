package com.hdy.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 读取配置文件system_conf.properties
 * @author Administrator
 *
 */
public class SystemConf {

	private static String environment;
	private static String saveImgPath;
	private static String imgPath;
	private static String serverIP;

	
	static {
		environment = SystemConf.getValueByKey("environment");
		saveImgPath = SystemConf.getValueByKey("saveImgPath");
		imgPath = SystemConf.getValueByKey("imgPath");
		serverIP = SystemConf.getValueByKey("serverIP");
	}

	public static String getValueByKey(String keyName) {
		try {
			Properties pu = new Properties();
			pu.load(new FileInputStream(SystemConf.class.getResource("/")
					.getPath() + "/system_conf.properties"));
			return pu.getProperty(keyName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String getEnvironment() {
		return environment;
	}
	public static String getServerIP() {
		return serverIP;
	}
	public static String getSaveImgPath() {
		return saveImgPath;
	}
	public static String getImgPath() {
		return imgPath;
	}
}
