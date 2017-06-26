package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperations {
	public static int getSizeResultSet(ResultSet resultSet) throws SQLException{
		int size = 0;
		if (resultSet.last()) {
			size = resultSet.getRow();
			resultSet.beforeFirst();
		}
		return size;
	}
}
