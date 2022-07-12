package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.entity.Person;

public class JPAService {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	public JPAService() {
		if(emf == null)
		{
			emf = Persistence.createEntityManagerFactory("demo");
			
		}
		em =emf.createEntityManager();
	}
	public EntityManager getEntityManager()
	{
		return em;
	}
   public void addPerson(Person person)
   {
	   synchronized (em) {
			 EntityTransaction etx = em.getTransaction();
			 etx.begin(); //開始
			 em.persist(person);//存入person
			 etx.commit();//提交
			}
		  }
   public Person getPersonById(Integer id)
   {
	   return em.find(Person.class,id);
	   
   }
   public List<Person> queryAllPerson()
   {
	   Query query = em.createQuery("from person p", Person.class);
	  // Query query = em.createQuery("select p from Person p");
	   List<Person> list =query.getResultList();
   	return list;
	   
   }
   public List<Person> queryPersonByAge(Integer age)
   {
	   String sql = "select p form Person p where p.age = age";
	   Query query = em.createQuery(sql);
	   query.setParameter("age", age);
	   List<Person> list = query.getResultList();
	   return list;
   }
   public List<Person> findAll()
   {
	   return em.createNamedQuery("Person.findAll").getResultList(); //冠勳說:將所有會電腦的同學名單排列成List回傳
   }
   public List<Person> findByName(String name)
   {
	   return em.createNamedQuery("Person.findByName") 
			   .setParameter("name",name)
			   .getResultList();
   }
   public List<Person> findByAgeBetween(Integer min, Integer max)
   {
	   return em.createNamedQuery("Person.findByAgeBetween")
			   .setParameter("min",min)
			   .setParameter("max",max)
			   .getResultList();
   }
}
