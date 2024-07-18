package com.excelr.refresher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.excelr.refresher.entity.Actor;

public class ManyToManyDelete {

	public static void main(String[] args) {
		SessionFactory factory=CreateSessionFactory.getSessionFactory();
		Session session1=factory.openSession();
		
		Transaction tx=session1.beginTransaction();
		
		Actor a=session1.get(Actor.class, 3);
		session1.remove(a);
		tx.commit();

	}

}
