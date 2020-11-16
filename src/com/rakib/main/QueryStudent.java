package com.rakib.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rakib.entity.Student;

public class QueryStudent {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			// Query Student
			List<Student> list = session.createQuery("from Student").list();
			// display the student
			for (Student std : list) {
				System.out.println(std.toString());
			}

			list = session.createQuery("from Student s where s.lastName = 'Islam'").list();
			// display the student
			for (Student std : list) {
				System.out.println(std.toString());
			}
			session.getTransaction().commit();
		} finally {
			sessionFactory.close();
		}
	}

}
