package com.luv2code.hibernate.demo.entity;



import org.hibernate.cfg.Configuration;

import com.luv2code.jdbc.Instructor;
import com.luv2code.jdbc.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateInstructorDemo {

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
		
		//create session
		Session session =  factory.getCurrentSession();
		try {
		//create the object 
		Instructor tempInstructor = new Instructor("Susan", "Public", "Suan.Public@gmail.com");
	    InstructorDetail tempInstructorDetail = new InstructorDetail("http ://www.youtube.com" , "Video Games!!");
	    //associate the  object
		tempInstructor.setInstructorDetail(tempInstructorDetail);//mapping 
		//Start a transaction  
		session.beginTransaction();
	    //save the instructor 
	    //Note: this will also save the detail object 
		//because of cascadeType.all
		System.out.println("saving the instruction :" + tempInstructor );
	    session.save(tempInstructor);
		//commit the transaction 
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
