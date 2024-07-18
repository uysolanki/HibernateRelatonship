package com.excelr.refresher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.excelr.refresher.entity.Dept;

public class OneToManyFetching {

	public static void main(String[] args) {
		SessionFactory factory=CreateSessionFactory.getSessionFactory();
		Session session1=factory.openSession();
		
		Transaction tx=session1.beginTransaction();
		
		Dept dept1=session1.get(Dept.class, 1);
		
		System.out.println("hiiiii");
		System.out.println(dept1.getEmployees());
		

	}

}
