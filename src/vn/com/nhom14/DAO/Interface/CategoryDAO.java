package vn.com.nhom14.DAO.Interface;
import java.util.ArrayList;

import vn.com.nhom14.model.*;
public interface CategoryDAO {
	public ArrayList<Category> getAllCategory();
	public int getCategoryByID(String categoryName);
	public void addCategory(String categoryName);
	public void updateCategory(String categoryName);
	public void deleteCategory(String categoryName);
}
