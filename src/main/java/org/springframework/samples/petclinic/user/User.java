package org.springframework.samples.petclinic.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.Person;

@Entity
@Table(name = "users")
public class User extends Person {

	@Column(name = "login_id")
	@NotEmpty
	private String loginId;

	@Column(name = "password")
	@NotEmpty
	private String password;

	@Column(name = "middle_initial")
	@NotNull
	private Character middleInitial;

	@Column(name = "email")
	@NotEmpty
	private String email;

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getMiddleInitial() {
		return this.middleInitial;
	}

	public void setMiddleInitial(Character middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
