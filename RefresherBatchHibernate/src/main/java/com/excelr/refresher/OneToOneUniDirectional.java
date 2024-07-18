package com.excelr.refresher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.excelr.refresher.entity.ChiefMinister;
import com.excelr.refresher.entity.State;

public class OneToOneUniDirectional {
	
	public static void main(String[] args) {
		
	
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	
	
	Session session1=factory.openSession();
	Transaction tx=session1.beginTransaction();
	State s1=new State();
	s1.setSname("Maharashtra");
	s1.setCapcity("Mumbai");
	
	State s2=new State();
	s2.setSname("Rajasthan");
	s2.setCapcity("Jaipur");
	
	ChiefMinister c1=new ChiefMinister();
	c1.setCmname("Shinde");
	c1.setCmage(50);
	
	ChiefMinister c2=new ChiefMinister();
	c2.setCmname("Sharma");
	c2.setCmage(60);
	
	s1.setChiefMinister(c1);
	s2.setChiefMinister(c2);
	

	
	session1.save(s1);
	session1.save(s2);
	session1.save(c1);
	session1.save(c2);
	tx.commit();
	
	session1.close();
}
}