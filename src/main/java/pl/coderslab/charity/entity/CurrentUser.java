package pl.coderslab.charity.entity;

import lombok.Getter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
@Getter
public class CurrentUser extends User {

	private final pl.coderslab.charity.entity.User user;

	public CurrentUser(String username, String password,
					   Collection<? extends GrantedAuthority> authorities,
					   pl.coderslab.charity.entity.User user) {
		super(username, password, authorities);
		this.user = user;
	}
}