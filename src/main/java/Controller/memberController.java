package Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Dao.memberDao;
import Factory.spFactory;
import Model.member;

@Controller
@RequestMapping("/member")
public class memberController {
	ApplicationContext a = new ClassPathXmlApplicationContext("sp1.xml");
	spFactory sp = a.getBean("sf", spFactory.class);
	/*
	 * emailconfirmation-> verificationcode-> memberprofile
	 */

	@RequestMapping("memberManager")
	public String memberManager() {
		return "member/memberManager";
	}

	@RequestMapping("/addmember")
	public String addmember() {
		return "member/emailconfirmation";
	}

	@RequestMapping("addsuccess")
	public String addsuccess() {
		return "member/addsuccess";
	}

	@RequestMapping("adderror")
	public String adderror() {
		return "member/adderror";
	}

	@RequestMapping("/emailconfirmation")
	public String emailconfirmation(HttpSession se, String email, String password) {
		se.removeAttribute("memberinfo");

		boolean e = sp.getMd().queryEmail(email);
		if (e) {
			return "member/adderror";
		}

		String verification = generateVerification(); // 生成驗證碼
		System.out.println("驗證碼: " + verification);
		String[] memberinfo = { email, password, verification }; // 放入session
		se.setAttribute("memberinfo", memberinfo);

		// 將驗證碼傳送給註冊信箱
		String subject = "註冊驗證碼"; // 信件標題
		String txt = "親愛的用戶您好，以下為您在<u>動物實驗網站</u>註冊的會員驗證碼<hr><h2>" + verification + "</h2><hr>"
				+ "請至註冊頁面輸入驗證碼已完成註冊程序，感謝您!<p>https://tw.bid.yahoo.com/help/new_auc/auth/register.html<p>"
				+ "https://www.roots.com.tw/Member/Register<p>"; // 信件內容
		JavaMail mail = new JavaMail();
		mail.SendMail(email, subject, txt);

		return "member/verificationcode";
	}

	@RequestMapping("verificationcode")
	public String verificationcode() {
		return "member/memberprofile";
	}

	@RequestMapping("memberprofile")
	public String memberprofile(HttpSession se, HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");

		// 生成memberid
		int length = new memberDao().queryMemberLength();
		member m = (member) new memberDao().query(length);
		String tempid = m.getMemberid().substring(2, 8);
		String k = String.format("%06d", Integer.parseInt(tempid) + 1);
		String memberid = "EA" + k;

		// 存取各項資料
		String[] memberinfo = (String[]) se.getAttribute("memberinfo");
		String email = memberinfo[0];
		String password = memberinfo[1];

		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		Integer age = Integer.parseInt(req.getParameter("age"));
		String livingarea = req.getParameter("livingarea");
		String adopter = req.getParameter("adopter");

		member member = new member(memberid, email, password, name, phone, gender, age, livingarea, adopter);
		sp.getMd().add(member);

		return "member/addsuccess";
		//ModelAndView model = new ModelAndView("C:/Users/netru/Desktop/Bunny_web%20-%200528/addsucess.html");
		
	}

	@RequestMapping("/login")
	public String login(HttpSession se, String email, String password) {
		se.removeAttribute("member");

		List<member> l = sp.getMd().queryAccount(email, password);
		if (l.size() != 0) {
			member[] member = l.toArray(new member[l.size()]);
			member m = member[0];
			if (m.getEmail().equals("admin") && m.getPassword().equals("123")) { // 管理者帳號
				System.out.println("admin");
			} else if (m.getEmail().equals("djimage") && m.getPassword().equals("80688332")) { // 基金會帳號
				System.out.println("djimage");
			} else { // 一般使用者帳號
				se.setAttribute("member", m);
				return "/success";
			}
		}
		return "../error";
	}

	// 4位數驗證碼生成
	public static String generateVerification() {
		String verification = "";
		for (int i = 0; i < 4; i++) {
			int j = (int) ((Math.random() * 9) + 1);
			verification += j;
		}
		return verification;
	}

}
