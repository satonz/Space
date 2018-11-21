package space.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MyEmail {
	private static String dateFormate = "yyyy-MM-dd HH:mm:ss";
	private static String hostName = "SMTP.qq.com";
	private static int SMTPPort = 587;
	private static String authEmail = "whirlys@qq.com";
	private static String emailCode = "mwmxatuctdtefhaf";

	public MyEmail() {
		super();
	}

	// 发送普通文本邮件
	public static void sendSimpleEmail(String sendTo, String subject, String msgInfo) throws EmailException {
		if (sendTo != null && sendTo != "") {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);// 设置日期格式
			SimpleEmail email = new SimpleEmail();
			email.setHostName(hostName);
			email.setSmtpPort(SMTPPort);
			email.setAuthentication(authEmail, emailCode);// 邮件服务器验证：用户名/密码
			email.setCharset("UTF-8");// 必须放在前面，否则乱码
			email.addTo(sendTo);
			email.setFrom(authEmail, authEmail);
			email.setSubject(subject + " - " + sdf.format(new Date()));

			email.setMsg(msgInfo);
			email.send();
		}

	}

	// 发送HTML格式的邮件
	public static void sendHTMLEmail(String sendTo, String subject, String HtmlMsg)
			throws EmailException, MalformedURLException {
		if (sendTo == null || sendTo == "") {
			return;
		}
		HtmlEmail email = new HtmlEmail();
		email.setHostName(hostName);
		email.setSmtpPort(SMTPPort);
		email.setAuthentication(authEmail, emailCode);
		email.setFrom(authEmail, authEmail);
		email.setCharset("UTF-8");
		email.setSubject(subject);
		email.addTo(sendTo);

		// set the html message
		email.setHtmlMsg(HtmlMsg);

		// send the email
		email.send();
	}

}
