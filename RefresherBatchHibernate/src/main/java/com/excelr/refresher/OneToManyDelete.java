package com.excelr.refresher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.excelr.refresher.entity.Dept;

public class OneToManyDelete {

	public static void main(String[] args) {
		SessionFactory factory=CreateSessionFactory.getSessionFactory();
		Session session1=factory.openSession();
		
		Transaction tx=session1.beginTransaction();
		
		Dept d=session1.get(Dept.class, 1);
		session1.remove(d);
		tx.commit();

	}

}
