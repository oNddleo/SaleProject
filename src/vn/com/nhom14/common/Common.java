package vn.com.nhom14.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Common {
	/**
	 * Connect Database and Set user password for Database
	 */
	public final static String DRIVE_NAME = "com.mysql.jdbc.Driver";
	public final static String MYSQL_DB = "sale";
	public final static String HOST = "localhost:3306/";
	public final static String CONNECTION_STRING = "jdbc:mysql://"+ HOST + MYSQL_DB + "?useSSL=false";
	public final static String MYSQL_USER = "root";
	public final static String MYSQL_PASSWORD = "12345";
	/**
	 * SQL handle User
	 */
	public final static String GET_ALL_USER = "select * from user";
	public final static String GET_USER_BY_ID = "select iduser from user where username = ?";
	public final static String ADD_USER = "insert into user (username, password, role) value(?,?,?)";
	public final static String MODIFY_USER = "update user set username = ?, password = ?, role = ? where username = ?";
	public final static String DELETE_USER = "delete from user where username = ?";
	public final static String CHECK_USER = "select * from user where username=? and password=? and role=?";
	/**
	 * SQL handle Information
	 */
	public final static String ADD_INFORMATION = "insert into information(iduser, name, gender, dateOfBirth, address, phone, email) value(?, ?, ?, ?, ?, ?, ?)";
	public final static String MODIFY_INFORMATION = "update information set iduser = ?, name = ?, gender = ?, dateOfBirth = ?, address = ?, phone = ?, email = ? where iduser = ?";
	public final static String DELETE_INFORMATION = "delete from information where iduser = ?";
	public final static String GET_INFORMATION = "select * from information where iduser = ?";
	/**
	 * SQL handle Category
	 */
	public final static String GET_CATEGORY = "select * from category";
	public final static String GET_CATEGORY_BY_ID = "select idcategory from category where name= ?";
	public final static String ADD_CATEGORY = "insert into category (name) value(?)";
	public final static String MODIFY_CATEGORY = "update category set name = ? where name = ?";
	public final static String DELETE_CATEGORY = "delete from category where name = ?";
	/**
	 * SQL handle Product
	 */
	public final static String GET_PRODUCT = "select * from product";
	public final static String GET_PRODUCT_BY_ID = "select idproduct from product where name=?";
	public final static String GET_PRODUCT_NAME = "select name from product where company=?";
	public final static String GET_PRODUCT_PRICE = "select name from product where price=?";
	public final static String ADD_PRODUCT = "insert into product where (idcategory, company, name, price, info) value(?,?,?,?,?)";
	public final static String MODIFY_PRODUCT = "update product set idcategory=?, company=?, name=?, price=?, info=? where name = ?";
	public final static String DELETE_PRODUCT = "delete from product where name = ?";
	/**
	 * SQL handle Order
	 */
	public final static String GET_ORDER = "select * from order";
	public final static String GET_ORDER_BY_ID = "select idorder from order where date=?";
	public final static String GET_ORDER_BY_ID_IDUSER = "select idorder from order where iduser=?";
	public final static String ADD_ORDER = "insert into order where (iduser, address, phone, email, date) value(?,?,?,?,?)";
	public final static String MODIFY_ORDER = "update order set address=?, phone=?, email=?, date=? where idorder=?";
	public final static String DELETE_ORDER = "delete from order where iduser=?";
	
	/**
	 * SQL handle OrderDetail
	 */
	public final static String GET_ORDER_DETAIL = "select * from orderdetail";
	public final static String GET_ORDER_PRODUCT_AND_QUANTITY = "select idproduct, quantity from orderdetail where idorder=?";
	public final static String GET_ORDER_PRODUCT_PRICE_AND_QUANTITY = "select idproduct, quantity from orderdetail where idorder=?";
	/**
	 * Change password to MD5
	 * @param password
	 * @return
	 */
	public static String passwordMD5(String password) {
	    MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
		    byte[] digest = md.digest();

		    StringBuffer sb = new StringBuffer();
		    for (int i = 0; i < digest.length; i++)
		        sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
		    return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
