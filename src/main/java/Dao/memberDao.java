package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.member;

public class memberDao implements implDao {
	public static void main(String[] args) {
//		member m = new member("EA000005", "jim@gmail.com", "0905", "Jim", "0908", "male", 22, "台北市", "願意");
//		new memberDao().add((member)m);

//		/*int length = new memberDao().queryMemberLength();
//		member m = (member) new memberDao().query(length);
//		String tempid = m.getMemberid().substring(2, 8);
//		String k = String.format("%06d", Integer.parseInt(tempid) + 1);
//		String id = "EA" + k;
//
//		System.out.println("下一個memberid是: " + id);
//
//		// 查詢email有無重複存在
//		String email = "chichun518@gmail.com";
//		boolean b = new memberDao().queryEmail(email);
//		System.out.println(email + "信箱" + b + "存在");
//
//		// 透過email&password查詢帳號資料
//		List<member> l = new memberDao().queryAccount(email, "890905");
//		member[] member = l.toArray(new member[l.size()]);
//		for (member m7 : member) {
//			System.out.println(m7);
//		}*/
		
//		List<Object> m = new memberDao().queryAll();
//		for(Object o :m) {
//			System.out.println(o);
//		}
	}

	// 判斷 email & passowrd-->回傳物件
	public static List<member> queryAccount(String email, String password) {
		Session se = implDao.getDb();
		String hql = "from member as m where m.email = ?1 and m.password = ?2";

		Query q = se.createQuery(hql);
		q.setParameter(1, email);
		q.setParameter(2, password);

		List<member> l = q.list();
//		member[] m = l.toArray(new member[l.size()]);
//		member member = m[0];
		return l;
	}

	// 判斷 email 是否重複
	public static Boolean queryEmail(String email) {
		Session se = implDao.getDb();
		String hql = "from member as m where m.email = ?1";

		Query q = se.createQuery(hql);
		q.setParameter(1, email);
		List<member> l = q.list();

		Boolean x = false;
		if (l.size() != 0) {
			x = true;
		}
		return x;
	}

	// 查詢 memberid
	public static List<member> queryMemberid(String memberid) {
		Session se = implDao.getDb();
		String hql = "from member as o where o.memberid = ?1";

		Query q = se.createQuery(hql);
		q.setParameter(1, memberid);

		List<member> l = q.list();
		return l;
	}

	// 查詢 member 資料庫長度
	public static int queryMemberLength() {
		Session se = implDao.getDb();
		String hql = "from member";

		Query q = se.createQuery(hql);

		List<Object> l = q.list();
		int length = l.size();
		return length;
	}

	@Override
	public void add(Object o) {
		Session se = implDao.getDb();
		Transaction t = se.beginTransaction();
		se.save(o);
		t.commit();
		se.close();
	}

	@Override
	public Object query(int id) {
		Session se = implDao.getDb();
		member m = se.get(member.class, id);
		return m;
	}

	@Override
	public List<Object> queryAll() {
		Session se = implDao.getDb();
		String hql = "from member";

		Query q = se.createQuery(hql);

		List<Object> l = q.list();
		return l;
	}

	@Override
	public void update(Object o) {
		Session se = implDao.getDb();
		Transaction t = se.beginTransaction();
		se.update(o);
		t.commit();
		se.close();
	}

	@Override
	public void delete(Object o) {
		Session se = implDao.getDb();
		Transaction t = se.beginTransaction();
		se.delete(o);
		t.commit();
		se.close();
	}
}
