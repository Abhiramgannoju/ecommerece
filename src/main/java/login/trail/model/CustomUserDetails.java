package login.trail.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends UserModel implements UserDetails {

	public CustomUserDetails(UserModel user) {
		super(user);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority>authoritylist=new ArrayList<>();
		super.getRoles().forEach(role->{
			authoritylist.add(new SimpleGrantedAuthority(role.getName()));
		});
		return authoritylist;
	}
 public String getUsername()
 {
	 
	 return super.getEmail();
 }
 public String getPassword()
 {
	 return super.getPassword();
 }
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
  
}
