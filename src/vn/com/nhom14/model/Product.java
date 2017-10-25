package vn.com.nhom14.model;

import java.util.ArrayList;

public class Product {
	private int idcategory;
	private String company;
	private String name;
	private int price;
	private String information;
	public static final int numberOfProperties = 5;
	public Product(ArrayList<String> props) {
		int i = 0;
		this.idcategory = Integer.parseInt(props.get(i++));
		this.company = props.get(i++);
		this.name = props.get(i++);
		this.price = Integer.parseInt(props.get(i++));
		this.information = props.get(i++);
	}
	public int getIdcategory() {
		return idcategory;
	}
	public void setIdcategory(int idcategory) {
		this.idcategory = idcategory;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
}
