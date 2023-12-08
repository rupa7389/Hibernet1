package UserA2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserMain {

	public static void main(String[] args) {
		
		User user = new User();
		user.setId(1);
		user.setName("Venkata");
		user.setAddress("Bang");
		
		EntityManagerFactory eMF=Persistence.createEntityManagerFactory("vinod");
		EntityManager eM = 	eMF.createEntityManager();
		EntityTransaction eT= eM.getTransaction();
		eT.begin();
		eM.persist(user);
		eT.commit();
	}

}
