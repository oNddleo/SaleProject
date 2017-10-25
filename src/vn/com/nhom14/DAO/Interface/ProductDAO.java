package vn.com.nhom14.DAO.Interface;

import java.util.ArrayList;
import vn.com.nhom14.model.*;

public interface ProductDAO {
	public ArrayList<Product> getAllProduct();
	public int getProductByID(String prodName);
	public String getProductByCompany(String company);
	public String getProductByPrice(String price);
	public void addProduct(Product prod);
	public void updateProduct(Product prod, String prodName);
	public void deleteProduct(String prodName);
}
