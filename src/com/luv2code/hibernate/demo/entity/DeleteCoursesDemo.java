package com.luv2code.hibernate.demo.entity;



import org.hibernate.cfg.Configuration;

import com.luv2code.jdbc.Instructor;
import com.luv2code.jdbc.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteCoursesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		//get a course
	     int theid = 10;
		Course tempcourse = session.get(Course.class, theid);
		//delete the course 
	    System.out.println("deleting the course" + tempcourse);
		session.delete(tempcourse);
		//commit the trasaction
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
