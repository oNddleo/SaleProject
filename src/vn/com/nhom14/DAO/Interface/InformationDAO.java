package vn.com.nhom14.DAO.Interface;

import vn.com.nhom14.model.Information;

public interface InformationDAO {
	public Information getInformation(int iduser);
	public void addInformation(Information info);
	public void updateInformation(int iduser);
	public void deleteInformation(int iduser);
}
