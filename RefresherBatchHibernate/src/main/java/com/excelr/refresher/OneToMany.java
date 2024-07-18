package com.excelr.refresher;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.excelr.refresher.entity.Dept;
import com.excelr.refresher.entity.Employee;

public class OneToMany {
public static void main(String[] args) {
	SessionFactory factory=CreateSessionFactory.getSessionFactory();
	Session session1=factory.openSession();
	
	Transaction tx=session1.beginTransaction();
	
	Dept d1=new Dept();
	d1.setDname("IT");
	d1.setCity("Pune");
	
	Dept d2=new Dept();
	d2.setDname("Prod");
	d2.setCity("Delhi");
	
	Employee e1=Employee.builder()
			.ename("Alice")
			.sal(800.0)
			.dept(d1)
			.build();
	
	Employee e2=Employee.builder()
			.ename("Ben")
			.sal(800.0)
			.dept(d1)
			.build();
	
	Employee e3=Employee.builder()
			.ename("Chris")
			.sal(800.0)
			.dept(d2)
			.build();
	
	Employee e4=Employee.builder()
			.ename("David")
			.sal(800.0)
			.dept(d2)
			.build();
	
	List<Employee> itEmployees=new ArrayList();
	itEmployees.add(e1);
	itEmployees.add(e2);
	
	List<Employee> prodEmployees=new ArrayList();
	prodEmployees.add(e3);
	prodEmployees.add(e4);
	
	d1.setEmployees(itEmployees);
	d2.setEmployees(prodEmployees);
	
	session1.save(d1);
	session1.save(d2);
	
	session1.save(e1);
	session1.save(e2);
	session1.save(e3);
	session1.save(e4);
	
	tx.commit();
	session1.close();
}
}
