package jpa.servlet;

import java.io.IOException;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.javafaker.Faker;

import jpa.entity.Person;
import jpa.service.JPAService;

@WebServlet("/jpa/person/update")
public class JPAUpdatePersonServlet extends JPABaseServlet {
	
	private JPAService jpaService;
 
	
 
	@Override
	public void init() throws ServletException {
		 jpaService = new JPAService();
	}

	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
		EntityManager em = jpaService.getEntityManager();
		//Person person = em.find(Person.class,1);
		 
		 Person person = new Person();
		 person.setId(1);
		 person.setName("Hoppe");
		 person.setAge(66);
		 
		person.setAge(100);
		//未託管的狀況下可以使用merge
		EntityTransaction etx = em.getTransaction();
		etx.begin();
//		em.persist(person);
		em.merge(person);
		etx.commit();
		
		resp.getWriter().println(person);
		 
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(req, resp);
	}
	
	
	//merge 可以將斷掉的資料庫再更改在聯
	

}
