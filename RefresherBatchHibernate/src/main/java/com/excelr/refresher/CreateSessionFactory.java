package com.excelr.refresher;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateSessionFactory {
	public static SessionFactory factory=null;
	
	public static SessionFactory getSessionFactory()
	{
		Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	factory=cfg.buildSessionFactory();
    	return factory;
	}
}
