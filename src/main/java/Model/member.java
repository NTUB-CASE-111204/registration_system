package Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String memberid;
	private String email;
	private String password;
	private String name;
	private String phone;
	private String gender;
	private int age;
	private String livingarea;
	private String adopter;
	private Date lastupdate;
	private Date createdate;

	public member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public member(String memberid, String email, String password, String name, String phone, String gender, int age,
			String livingarea, String adopter) {
		super();
		this.memberid = memberid;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.livingarea = livingarea;
		this.adopter = adopter;
		
		this.createdate = new Date();
	}

	@Override
	public String toString() {
		return "member [memberid=" + memberid + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", phone=" + phone + ", gender=" + gender + ", age=" + age + ", livingarea=" + livingarea + ", adopter="
				+ adopter + ", lastupdate=" + lastupdate + ", createdate=" + createdate + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLivingarea() {
		return livingarea;
	}

	public void setLivingarea(String livingarea) {
		this.livingarea = livingarea;
	}

	public String getAdopter() {
		return adopter;
	}

	public void setAdopter(String adopter) {
		this.adopter = adopter;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
}
