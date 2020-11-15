package com.rakib.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rakib.entity.Student;

public class MainImplemented {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").
				buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		try {
			// Create Student Object
			System.out.print("Create new Student Object");
			Student student = new Student("Rakib", "Hasan", "rakibhasan@gmail.com");
			// start a transaction
			session.beginTransaction();
			// save the Student
			session.save(student);
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}

}
