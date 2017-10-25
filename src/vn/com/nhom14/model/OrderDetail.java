package vn.com.nhom14.model;

import java.util.ArrayList;

public class OrderDetail {
	private int idorder;
	private int idproduct;
	private int price;
	private int quantity;
	
	public OrderDetail(ArrayList<String> props) {
		int i = 0;
		this.idorder= Integer.parseInt(props.get(i++));
		this.idproduct= Integer.parseInt(props.get(i++));
		this.price = Integer.parseInt(props.get(i++));
		this.quantity= Integer.parseInt(props.get(i++));
	}
	public int getIdorder() {
		return idorder;
	}
	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}
	public int getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
