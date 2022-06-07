package Controller;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
	public static void main(String[] args) {
		JavaMail mail = new JavaMail();
		String customer = "chichun518@gmail.com"; // 收件者email
		String subject = "測試信件"; // 信件標題
		String txt = "<h1>信件內容文字</h1><hr>以上為html格式測試內容!!<p>https://tw.bid.yahoo.com/help/new_auc/auth/register.html"; // 信件內容
		mail.SendMail(customer, subject, txt);
	}
	//4位數驗證碼生成
	public static String generateVerification() {
		String verification = "";
		for(int i=0;i<4;i++) {
			int j = (int) ((Math.random()*9)+1);
			verification += j;
		}
		return verification;
	}

	private String userName = "bunny111204@gmail.com"; // 寄件者email
	private String password = "zxlxaaiauttiuoru"; // 帳號密碼
//	private String customer = "chichun518@gmail.com"; // 收件者email
//	private String subject = "測試信件"; // 信件標題
//	private String txt = "<h1>信件內容文字</h1><hr>以上為html格式測試內容!!"; // 信件內容

	// 多型使用
	// 統一由bunny111204@gmail.com傳送信件
	public void SendMail(String customer, String subject, String txt) {
		// ------------ ------------ 連線設定 ------------ ------------
		Properties prop = new Properties();

		prop.setProperty("mail.transport.protocol", "smtp"); // 設定連線方式為smtp
		prop.setProperty("mail.host", "smtp.gmail.com"); // host: smtp.gmail.com
		prop.put("mail.smtp.port", "465"); // host port 465
		prop.put("mail.smtp.auth", "true"); // 寄件者帳號需要驗證:是
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // 需要安全資料傳輸層
		prop.put("mail.smtp.socketFactory.port", "465"); // 安全資料傳輸層(SSL) 通訊port:465

		// ------------ ------------ 帳號驗證 ------------ ------------

		// ------------ Session javamail api 默認設定屬性 ------------
//		Session session = Session.getDefaultInstance(prop, new Authenticator() { // 透過匿名類別
//
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(userName, password);
//			}
//
//		});

		Auth auth = new Auth(userName, password); // 一般class
		Session session = Session.getDefaultInstance(prop, auth);

		// ------------ ------------ Message 放入基本資料 ------------ ------------
		MimeMessage message = new MimeMessage(session);

		try {
			// 匿名類別
//			message.setSender(new InternetAddress(userName)); // 寄件者
			// 一般class
			InternetAddress sender = new InternetAddress(userName); // 寄件者
			message.setSender(sender); // sender是Address類別

			message.setRecipient(RecipientType.TO, new InternetAddress(customer)); // 收件者

			message.setSubject(subject); // 標題

			message.setContent(txt, "text/html;charset=UTF-8"); // 內容/格式

			// ------------ ------------ Transport將Message傳出去 ------------ ------------
			Transport transport = session.getTransport();
			transport.send(message);
			transport.close();

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Auth extends Authenticator {
	private String userName;
	private String password;

	public Auth(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		PasswordAuthentication pa = new PasswordAuthentication(userName, password);
		return pa;
	}

}
