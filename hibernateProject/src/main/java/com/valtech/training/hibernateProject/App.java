package com.valtech.training.hibernateProject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

    	Laptop l1=new Laptop();
    	l1.setId(2);
    	l1.setAname("Asus");
    	l1.setTech("Buisnesses");
    	Student s3=new Student();
    	s3.setRollNo(27);
    	s3.setsAge(22);
    	s3.setsName("Tej");
    	Student s4=new Student();
    	s4.setRollNo(29);
    	s4.setsAge(22);
    	s4.setsName("Nisarg");
    	Set<Student> stud=new HashSet<Student>();
    	Set<Laptop>lap=new HashSet<Laptop>();
    	lap.add(l1);
    	stud.add(s3);
    	stud.add(s4);
    	l1.setStudents(stud);
    	s3.setLaptops(lap);
    	s4.setLaptops(lap);
    	Laptop l2=new Laptop();
    	l2.setId(5);
    	l2.setAname("Dell");
    	l2.setTech("Computer Science");
    	lap.add(l2);
    	s3.setLaptops(lap);
    	s4.setLaptops(lap);
    	l2.setStudents(stud);
    	Configuration cf=new Configuration();
    	cf.addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
    	SessionFactory session=cf.buildSessionFactory();
    	Session ses=session.openSession();
    	Transaction transaction=ses.beginTransaction();
//    	ses.persist(s3);
//    	ses.persist(s4);
    	Laptop l3=new Laptop();
    	l3.setId(11);
    	l3.setAname("MacBookPro");
    	l3.setTech("Commerce");
    	lap.add(l3);
    	ses.persist(l3);
    	s4.setLaptops(lap);
    	ses.merge(s4);
    	transaction.commit();
    	
        ses.close();
    } 
}
