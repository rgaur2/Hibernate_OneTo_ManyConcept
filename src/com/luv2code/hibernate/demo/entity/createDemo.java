package com.luv2code.hibernate.demo.entity;



import org.hibernate.cfg.Configuration;

import com.luv2code.jdbc.Instructor;
import com.luv2code.jdbc.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class createDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //we use hibernate here to create sessions objects 
		// these session objects would create only once when app will run 
		//create session Factory 
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Instructor.class)
				                  .addAnnotatedClass(InstructorDetail.class)
				                  .buildSessionFactory();
		
		//create session
		Session session =  factory.getCurrentSession();
		try {
		//create the object
		Instructor tempInstructor = new Instructor("Madhu", "patel", "Madhu@l@gmail.com");
	    InstructorDetail tempInstructorDetail = new InstructorDetail("http ://www.youtube.com" , "Guitar!!");
		//associate the  object
		tempInstructor.setInstructorDetail(tempInstructorDetail);//mapping 
	    //Start a trasaction
	    session.beginTransaction();
		//save the instructor 
	    //Note: this will also save the detail object 
		//because of cascadeType.all
		System.out.println("saving the instruction :" + tempInstructor );
		session.save(tempInstructor);
		//commit the trasaction 
		session.getTransaction().commit();
		System.out.println("Done");
				}
		finally {
		factory.close();
				}
	}

}
