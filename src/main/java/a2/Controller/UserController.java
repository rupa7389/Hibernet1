package a2.Controller;

import a2.dto.User;
import a2.dao.UserDao;
public class UserController {

	public static void main(String[] args) {
		User user = new User();
	//	user.setId(10);      // for update is not required
		user.setName("rahul");
		user.setAddress("mumbai");
		
		UserDao dao= new UserDao();
	//	dao.saveUser(user);

	//	dao.findUser(20);
		
	//	dao.deleteUser(1000);
		
		dao.updateUser(2,user);
	}

}
