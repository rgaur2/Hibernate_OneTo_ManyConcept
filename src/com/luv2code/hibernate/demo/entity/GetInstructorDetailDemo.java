 package com.luv2code.hibernate.demo.entity;



import org.hibernate.cfg.Configuration;

import com.luv2code.jdbc.Instructor;
import com.luv2code.jdbc.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //we use hibernate here to create sessions objects 
		// these session objects would create only once when app will run 
		
		
		//ceate session Factory 
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Instructor.class)
				                  .addAnnotatedClass(InstructorDetail.class)
				                  .buildSessionFactory();
		
		//create sessoin
		
		Session session =  factory.getCurrentSession();
		
				try {
					
					
					//Start a trasaction
					
				
					session.beginTransaction(); 
				//get the instructor detail object 
					
					//print the instructor detail 
					int theId =2;
					InstructorDetail  tempInstructorDetail = session.get(InstructorDetail.class, theId);
					System.out.println("tempInstructorDetail" + tempInstructorDetail);
				
					
				
					
					
					
				//print the associated instructor
					
					
					System.out.println("the associate instructor " + tempInstructorDetail.getInstructor());
					
				//commit trasaction n 
						
					session.getTransaction().commit();
					
					System.out.println("done");
					
				}
					
					catch(Exception exc)
					{
						exc.printStackTrace();
					}
				
				
				finally {
					//
					
					session.close();
					factory.close();
				}
	
	
				
	 

	}
}
