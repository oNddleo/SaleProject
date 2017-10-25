package vn.com.nhom14.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectDatabase {
	private Connection connect = null;
	private Statement statement = null;
    private ResultSet result;
    
	/**
	 * Get connect to database
	 * @return connect
	 */
	public Connection getConnection() {
		try {
			Class.forName(Common.DRIVE_NAME);
			connect = DriverManager.getConnection(Common.CONNECTION_STRING,Common.MYSQL_USER, Common.MYSQL_PASSWORD);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connect;
	}
	/**
	 * 
	 * @return statement
	 * @throws SQLException 
	 */
	public Statement getStatement() throws SQLException {
		//Return true or statement.isClose()
		if (statement == null ? true : statement.isClosed()) {
			
            statement = getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.println(statement.toString());
            
        }
		return statement;
	}
	/**
	 * Execute insert, update, delete query
	 * @param query
	 * @return
	 * @throws SQLException 
	 */
	public int executeStatementUpdate(String query) throws SQLException {
		int res = Integer.MIN_VALUE;
		try {
			res = getConnection().prepareStatement(query).executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw new SQLException("Error: " + e.getMessage() + " - " + query);
		}
		finally {
            closeConnection();
        }
		return res;
	}
	/**
	 * Execute select query
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet excuteStatementQuery(String query) throws SQLException{
		try {
			result.getStatement().executeQuery(query);
		} catch (Exception e) {
			// TODO: handle exception
			throw new SQLException("Error: "+ e.getMessage());
		}
		return result;
	}
	/**
	 * Close connection
	 * @throws SQLException 
	 */
	public void closeConnection() throws SQLException {
		try {
            if (result != null && result.isClosed()) {
                result.close();
                result = null;
            }
        } catch (SQLException e) {
            throw new SQLException("Error close Resultset!");
        }

        try {
            if (statement != null && statement.isClosed()) {
                statement.close();
                statement = null;
            }
        } catch (SQLException e) {
            throw new SQLException("Error close Statement!");
        }

        try {
            if (connect != null && connect.isClosed()) {
            	connect.close();
            	connect = null;
            }
        } catch (SQLException e) {
            throw new SQLException("Error close Connection!");
        }
    }
}
