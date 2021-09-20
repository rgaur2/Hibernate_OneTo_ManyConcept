package com.luv2code.hibernate.demo.entity;



import org.hibernate.cfg.Configuration;

import com.luv2code.jdbc.Instructor;
import com.luv2code.jdbc.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		
        //we use hibernate here to create sessions objects 
		// these session objects would create only once when app will run
		//create session Factory 
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Instructor.class)
				                  .addAnnotatedClass(InstructorDetail.class)
				                  .addAnnotatedClass(Course.class)
				                  .buildSessionFactory();
		//create session
		Session session =  factory.getCurrentSession();
		try {
		//create the object 
		session.beginTransaction();
		//get the instruction from db
	    int theId = 1;
		Instructor tempinstructor = session.get(Instructor.class, theId);
	    System.out.println("Instructor" +tempinstructor);
		//get courses for instructor 
		System.out.println("couirses" +tempinstructor.getCourses());
		//commit transaction 
		session.getTransaction().commit();
		System.out.println("Done");
		}
				
		finally {
	    //add clean code
		session.close();
		factory.close();
			}
	}
}
