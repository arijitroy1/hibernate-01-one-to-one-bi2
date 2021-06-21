package com.hibernate.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.model.Instructor;
import com.hibernate.jdbc.model.InstructorDetail;

public class HibernateDelete {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
		
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, "3");
			
			System.out.println("Instructor Detail - "+instructorDetail);
			
			System.out.println("Associated Instructor - "+instructorDetail.getInstructor());
			
			instructorDetail.getInstructor().setInstructorDetail(null);
			//Only InstructorDetail will get deleted, Instructor will remain there
			session.delete(instructorDetail);
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			System.out.print("Error - "+ e.getMessage());
		}finally {
			session.close();//If we get some exception and not able to close the session, here we will do that 
			factory.close();
		}
	}

}
