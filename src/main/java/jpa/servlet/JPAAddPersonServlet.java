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

@WebServlet("/jpa/person/add")
public class JPAAddPersonServlet extends JPABaseServlet {
	
	

 
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String name = new Faker().name().lastName();
		 int age =new Random().nextInt(30)+10;
		 
		 Person person = new Person();
		 person.setName(name);
		 person.setAge(age);
		 
		 //進行資料交易
		 synchronized (em) {
			 EntityTransaction etx = em.getTransaction();
			 etx.begin(); //開始
			 em.persist(person);//存入person
			 etx.commit();//提交
			}
		 
		 
		 resp.getWriter().print("Add ok:"+person);
		 
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
	
	
	
	

}
