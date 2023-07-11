package login.trail.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import login.trail.model.UserModel;


	public interface UsersRepository extends JpaRepository<UserModel,Integer>{
		
//		   UserModel findByLoginAndPassword(String login ,String password);
//
//		    UserModel findByLogin(String login);
		}


