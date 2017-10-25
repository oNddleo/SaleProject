package vn.com.nhom14.DAO.Interface;

import java.util.ArrayList;

import vn.com.nhom14.model.Order;

public interface OrderDAO {
	public ArrayList<Order> getAllOrder();
	public int getOrderByID(String orderDate);
	public int getOrderByID_IDUser(int iduser);
	public void addOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(int iduser);
}
