//package login.trail.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import login.trail.model.UserModel;
//import login.trail.repo.UsersRepository;
//
//
//@Service
//public class UsersService {
//  
//	@Autowired
//	private UsersRepository userrepo;
//	public UsersService(UsersRepository userrepo)
//	{
//		this.userrepo=userrepo;
//	}
//	
//	public UserModel registerUser(String login, String password,String email)
//	{
//		if(login==null||password==null)
//		{
//			return null;
//		}
//		else
//		{
//			 UserModel existingUser = userrepo.findByLogin(login);
//		        if (existingUser != null) {
//		            return null;
//		        }
//			
//			UserModel usermodel=new UserModel();
//			usermodel.setLogin(login);
//			usermodel.setEmail(email);
//			usermodel.setPassword(password);
//			return userrepo.save(usermodel);
//		}
//	}
//	public UserModel authicate(String login, String password,String email)
//	{
//		UserModel user = userrepo.findByLoginAndPassword(login, password);
////		System.out.println("authicate called");
////		System.out.println(user);
//		if(user!=null)
//		{
//			return userrepo.findByLoginAndPassword(login,password);
//		}
//		else
//		{
//		   return null;
//		}
//	}
//}
