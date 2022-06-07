package Factory;

import Dao.memberDao;
import Model.member;

public class spFactory {
	private member m;
	
	private memberDao md;

	public spFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public spFactory(member m, memberDao md) {
		super();
		this.m = m;
		this.md = md;
	}

	public member getM() {
		return m;
	}

	public void setM(member m) {
		this.m = m;
	}

	public memberDao getMd() {
		return md;
	}

	public void setMd(memberDao md) {
		this.md = md;
	}
	
}
