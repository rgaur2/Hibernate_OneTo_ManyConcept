package com.luv2code.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.luv2code.hibernate.demo.entity.Course;

/**
 * @author rishgaur
 *
 */
@Entity
@Table(name="instructor")
public class Instructor {
	//annotate  the class as an entity and map to db  table
	//define the fields 
	//annotate the fields  with db coloumn nams	
	//create constructor 
	//generate getter and setters
    //generate toString(method)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@OneToOne(cascade=CascadeType.ALL)   //save/delete  the  all objects  
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;
	//list is for courses
	//all oneTomany 
	//also fulfill real world problem
	//way to map by using @OneToMany(mappedBy="instructor" 
	@OneToMany(mappedBy="instructor" ,
			cascade= {CascadeType.PERSIST ,CascadeType.MERGE ,CascadeType.DETACH , CascadeType.REFRESH})
	private List<Course> courses;
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	//add convinient method for bi -directional
	public void add (Course tempcourse)
	{
		if(courses == null)
		{
			courses = new ArrayList<>();
		}
		courses.add(tempcourse);
		tempcourse.setInstructor(this);
	}
	public Instructor()
	{
		
	}
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}
	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
}
