package vn.com.nhom14.model;

import java.util.ArrayList;

public class Order {
	private int iduser;
	private String address;
	private String phone;
	private String email;
	private String date;// Tam thoi de String roi fix sau
	
	public Order(ArrayList<String> props) {
		int i = 0;
		this.iduser = Integer.parseInt(props.get(i++));
		this.address = props.get(i++);
		this.phone = props.get(i++);
		this.email = props.get(i++);
		this.date = props.get(i++);
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
