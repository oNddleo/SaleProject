package vn.com.nhom14.DAO.Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.com.nhom14.DAO.Interface.UserDAO;
import vn.com.nhom14.common.Common;
import vn.com.nhom14.common.ConnectDatabase;
import vn.com.nhom14.model.User;

public class UserDAOImpl implements UserDAO {
	ConnectDatabase con = null;
	Connection connect = null;
	ArrayList<User> listUser = null;
	PreparedStatement state = null;
	ResultSet result = null;
	public UserDAOImpl() {
		con = new ConnectDatabase();
	}
	@Override
	public ArrayList<User> getAllUser() throws SQLException {
		connect = con.getConnection();
		try {
			listUser = new ArrayList<User>();
			state = connect.prepareStatement(Common.GET_ALL_USER);
			result = state.executeQuery();
			while (result.next()) {
				ArrayList<String> props = new ArrayList<>();
				for (int i = 2; i <= User.numberOfProperties + 1; i++) {
					props.add(result.getString(i).trim());
				}
				User user = new User(props);
				listUser.add(user);
			}
		} catch (Exception e) {
			throw new SQLException("Error: " + e.getMessage());
		} finally {
			con.closeConnection();
		}
		return listUser;
	}

	@Override
	public int getUserByID(String username) throws SQLException {
		int iduser = 0;
		try {
			state = connect.prepareStatement(Common.GET_USER_BY_ID);
			state.setString(1, username.trim());
			result = state.executeQuery();
			while (result.next()) {
				iduser = result.getInt(1);
			}
		} catch (Exception e) {
			throw new SQLException("Error: " + e.getMessage());
		}
		return iduser;
	}

	@Override
	public void addUser(User user) throws SQLException {
		connect = con.getConnection();
		try {
			state = connect.prepareStatement(Common.ADD_USER);
			state.setString(1, user.getUsername().trim());
			state.setString(2, user.getPassword().trim());
			state.setInt(3, user.getRole());
			state.executeUpdate();
		} catch (Exception e) {
			throw new SQLException("Error: " + e.getMessage());
		}
	}

	@Override
	public void updateUser(User user, String username) throws SQLException {
		connect = con.getConnection();
		try {
			state = connect.prepareStatement(Common.MODIFY_USER);
			state.setString(1, user.getUsername().trim());
			state.setString(2, user.getPassword().trim());
			state.setInt(3, user.getRole());
			state.setString(4, username.trim());
			state.executeUpdate();

		} catch (Exception e) {
			throw new SQLException("Error: " + e.getMessage());
		}
	}

	@Override
	public void deleteUser(String username) throws SQLException {
		connect = con.getConnection();
		try {
			state = connect.prepareStatement(Common.DELETE_USER);
			state.setString(1, username.trim());
			state.executeUpdate();

		} catch (Exception e) {
			throw new SQLException("Error: " + e.getMessage());
		}
	}

	@Override
	public boolean checkUser(User user) throws SQLException {
		boolean check = false;
		connect = con.getConnection();
		try {
			state = connect.prepareStatement(Common.CHECK_USER);
			state.setString(1, user.getUsername().trim());
			state.setString(2, user.getPassword().trim());
			state.setInt(3, user.getRole());
			result = state.executeQuery();
			check = result.next();
		} catch (Exception e) {
			throw new SQLException("Error: " + e.getMessage());
		}
		return check;
	}

}
