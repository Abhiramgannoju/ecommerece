package login.trail.model;

import java.util.List;
import java.util.Objects;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="user_table")
public class UserModel {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
//	private String login;
	private String firstname;
	private String lastname;;
	private String password;
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public String getLogin() {
//		return login;
//	}
//	public void setLogin(String login) {
//		this.login = login;
//	}
	public String getPassword() {
		return password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	List<Role>roles;
//	@Override
//	public int hashCode() {
//		return Objects.hash(email, id, login, password);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		UserModel other = (UserModel) obj;
//		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(login, other.login)
//				&& Objects.equals(password, other.password);
//	}
//	@Override
//	public String toString() {
//		return "UserModel [id=" + id + ", login=" + login + ", email=" + email + "]";
//	}
	public UserModel(UserModel user) {

		this.id = user.getId();
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.roles = user.getRoles();
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}