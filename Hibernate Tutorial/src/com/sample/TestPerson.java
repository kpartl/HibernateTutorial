package com.sample;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.hibernate.Query;
import org.hibernate.Session;


public class TestPerson {

    static final Logger logger = Logger.getLogger(TestPerson.class);
	public static void main(String[] args) {
        Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        createPerson(session);

        queryPerson(session);

    }

    private static void queryPerson(Session session) {
        Query query = session.createQuery("from Person");                 
        List <Person>list = query.list();
        java.util.Iterator<Person> iter = list.iterator();
        while (iter.hasNext()) {

            Person person = iter.next();
            System.out.println(person);
            
            if(person.getName().equals("Karel")){
            	deletePerson(session, person);            	
            }           
        }

        session.getTransaction().commit();

    }

    public static void createPerson(Session session) {
        Person person = new Person();

        person.setName("Barak");
        person.setSurname("Obhama");       
        person.setAddress("White House");       

        session.save(person);
        
         person = new Person();
        
        person.setName("Karel");
        person.setSurname("Pártl");       
        person.setAddress("Petøíkov"); 
        
        session.save(person);
    }
    
    public static void deletePerson(Session session, Person person) {
    	logger.info("Mazu osobu: " + person);
    	session.delete(person);
    
    }
}