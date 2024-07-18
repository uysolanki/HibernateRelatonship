package com.excelr.refresher;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.excelr.refresher.entity.Actor;
import com.excelr.refresher.entity.Movie;

public class ManyToMany {

	public static void main(String[] args) {
		SessionFactory factory=CreateSessionFactory.getSessionFactory();
		Session session1=factory.openSession();
		
		Transaction tx=session1.beginTransaction();
		Actor a1=Actor.builder()
				.aname("SRK")
				.age(57)
				.build();
		
		Actor a2=Actor.builder()
				.aname("DP")
				.age(42)
				.build();
		
		Movie m1=Movie.builder()
				.mname("CE")
				.releaseYear(2010)
				.build();
		
		Movie m2=Movie.builder()
				.mname("Don")
				.releaseYear(2007)
				.build();
	
		Movie m3=Movie.builder()
				.mname("kalki")
				.releaseYear(2024)
				.build();
		
		List<Movie> srkMovies=new ArrayList();
		srkMovies.add(m1);
		srkMovies.add(m2);
		
		List<Movie> dpMovies=new ArrayList();
		dpMovies.add(m1);
		dpMovies.add(m3);
		
		List<Actor> ceStarCast=new ArrayList();
		ceStarCast.add(a1);
		ceStarCast.add(a2);
		
		a1.setPortfolio(srkMovies);
		a2.setPortfolio(dpMovies);
		
		m1.setStarcast(ceStarCast);
		
		session1.save(a1);
		session1.save(a2);
		session1.save(m1);
		session1.save(m2);
		session1.save(m3);
		tx.commit();
		
		session1.close();

	}

}
