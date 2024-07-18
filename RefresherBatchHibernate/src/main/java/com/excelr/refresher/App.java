package com.excelr.refresher;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.excelr.refresher.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();
    	
    	
    	Session session1=factory.openSession();
    	//Transaction tx=session1.beginTransaction();

//    	Query q1=session1.createQuery("From Student");
//		List<Student> students=q1.list();
//		System.out.println(students);
//		
//		for(Student s:students)
//		{
//			System.out.println(s.getSname());
//		}

//    	Scanner sc=new Scanner(System.in);
//    	System.out.println("enter rno");
//    	int rollno=sc.nextInt();
    	
//    	Query q1=session1.createQuery("select rno,sname from Student");
//	
//    	List<Object[]> students=(List<Object[]>)q1.list();
//		for(Object[] student:students)
//				{
//					System.out.println(student[0] + "" +student[1]);
//				}

		
//		Query q1=session1.createQuery("select avg(per) from Student");
//		System.out.println("Average of Percentage is "+q1.uniqueResult());
//		//System.out.println(ans);
    	
    	SQLQuery query=session1.createSQLQuery("select * from studenttable s where s.percentage>=90");
		query.addEntity(Student.class);
		List<Student> students=query.list();
		for(Student s:students)
			{
				System.out.println(s);
			}

    	
    	
    	
    	session1.close();
    	
    }
}
