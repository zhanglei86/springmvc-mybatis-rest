package com.zl.common;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;

public class EmailUtil {
	protected static Logger log = Logger.getRootLogger();
	
	/**
	 * 
	 * @param host 服务器
	 * @param post 端口
	 * @param user 用户名
	 * @param psd 密码
	 * @param from 发件人
	 * @param to 收件人
	 * @param subject 主题
	 * @param msg 内容
	 * @throws EmailException
	 */
	public static void SendSimpleEmail(String host, String post, String user, String psd, String from,
			String to, String subject, String msg) throws EmailException {
		SimpleEmail email = new SimpleEmail();// 如果发送普通的邮件，使用这个类就可以了
		email.setHostName(host);// 指定要使用的邮件服务器
		email.setAuthentication(user, psd);
		email.setCharset("UTF-8");
		email.setSmtpPort(Integer.parseInt(post));
		email.setFrom(from);// 设置发件人
		email.addTo(to);// 设置收件人
		email.setSubject(subject);// 设置主题
		email.setMsg(msg);// 设置邮件内容
		email.send();
	}
}
