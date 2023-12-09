package a2.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import a2.dto.User;

public class UserDao {
	
	public void saveUser(User user) {
	EntityManagerFactory eMF=Persistence.createEntityManagerFactory("vinod");
	EntityManager eM = 	eMF.createEntityManager();
	EntityTransaction eT= eM.getTransaction();
	eT.begin();
	eM.persist(user);
	eT.commit();
	}
	
	public void findUser(int id)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User user =entityManager.find(User.class, id);
		if(user!=null)      //id is present
			System.out.println(user);
		else               //when id is not present
			System.out.println("Sorry that id is not present");		
		
	}
	
	public void deleteUser(int id)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User user =entityManager.find(User.class, id);
		if(user!=null)      //id is present
		{
			EntityTransaction eTransaction=entityManager.getTransaction();
			eTransaction.begin();
			entityManager.remove(user);
			eTransaction.commit();
		}
		else               //when id is not present
			System.out.println("Sorry that id is not found to delete");		
	}
	
//	public void updateUSer(User user)
//	{
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
//		EntityManager entityManager=entityManagerFactory.createEntityManager();
//		EntityTransaction eTransaction=entityManager.getTransaction();
//		eTransaction.begin();
//		entityManager.merge(user);
//		eTransaction.commit();
//	}
	
	public void updateUser(int id,User user)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		User dbUser=entityManager.find(User.class,id);
		if(dbUser!=null)
		{
			EntityTransaction eTransaction=entityManager.getTransaction();
			eTransaction.begin();
			user.setId(id);  // for update before merge set the id very imp
			entityManager.merge(user);
			eTransaction.commit();
		}
		else
		{
			System.out.println("Sorry data is not present to update");
		}
	}
}
