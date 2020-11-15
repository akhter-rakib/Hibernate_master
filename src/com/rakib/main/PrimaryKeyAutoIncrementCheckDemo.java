package com.rakib.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rakib.entity.Student;

public class PrimaryKeyAutoIncrementCheckDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
				buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		try {
			// Create Student Object
			System.out.print("Create new Student Object");
			Student std = new Student("Rakib", "Hasan", "rakibhasan@gmail.com");
			Student std2 = new Student("Rakib", "Hasan", "rakibhasan@gmail.com");
			Student std3 = new Student("Rakib", "Hasan", "rakibhasan@gmail.com");
			// start a transaction
			session.beginTransaction();
			// save the Student
			session.save(std);
			session.save(std2);
			session.save(std3);
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}

}
