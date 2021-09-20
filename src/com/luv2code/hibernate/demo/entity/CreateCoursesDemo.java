package com.luv2code.hibernate.demo.entity;



import org.hibernate.cfg.Configuration;

import com.luv2code.jdbc.Instructor;
import com.luv2code.jdbc.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //we use hibernate here to create sessions objects 
		// these session objects would create only once when app will run 
		//ceate session Factory 
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Instructor.class)
				                  .addAnnotatedClass(InstructorDetail.class)
				                  .addAnnotatedClass(Course.class)
				                  .buildSessionFactory();
		//create sessoin
		Session session =  factory.getCurrentSession();
		try {
		    //create the object 
			session.beginTransaction();
			//get the instruction from db
			int theId = 1;
			Instructor tempinstructor = session.get(Instructor.class, theId);
			//create some courses
			Course tempCourse1= new Course("Air-guitar - The Ultimate Guide");
			Course tempCourse2 = new Course("The pinball Masterclass");
			//add courses to instructor 
			tempinstructor.add(tempCourse1);
			tempinstructor.add(tempCourse2);
			//save the couses
		     session.save(tempCourse1);
			 session.save(tempCourse2);
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
