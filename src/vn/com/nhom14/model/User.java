package vn.com.nhom14.model;

import java.util.ArrayList;

import vn.com.nhom14.common.Common;

public class User {
	private String username;
	private String password;
	private int role;
	public static final int numberOfProperties = 3;
	public User(ArrayList<String> props) {
		int i = 0;
		this.username = props.get(i++);
		this.password = Common.passwordMD5(props.get(i++));
		this.role = Integer.parseInt(props.get(i++));
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = Common.passwordMD5(password);
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
}
