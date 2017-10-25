package vn.com.nhom14.model;

import java.util.ArrayList;

public class Information {
	private int iduser;
	private String name;
	private String gender;
	private String dateOfBirth;
	private String address;
	private String phone;
	private String email;
	public Information(ArrayList<String> props) {
		int i = 0;
		this.iduser = Integer.parseInt(props.get(i++));
		this.name = props.get(i++);
		this.gender = props.get(i++);
		this.dateOfBirth = props.get(i++);
		this.address = props.get(i++);
		this.phone = props.get(i++);
		this.email = props.get(i++);
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
}
