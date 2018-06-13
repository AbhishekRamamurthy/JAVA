package com.web.springdemo.crmUser;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CrmUser {
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String user;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String password;

	public CrmUser() {
		
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
