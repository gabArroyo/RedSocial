package models;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import utils.DBOperations;
import utils.SessionFunctions;

public class RegisterModel {
	
	public RegisterModel(){}
	
	private boolean usersOrEmailsFound(int numUsersFound, int numEmailsFound){
		return (numUsersFound + numEmailsFound) > 0;
	}
	
	private boolean usersFound(int numUsersFound){
		return numUsersFound > 0;
	}
	
	private boolean emailsFound(int numEmailsFound){
		return numEmailsFound > 0;
	}
	
	private void addInfoErrorsToBeanUser(BeanUser user, int numUsersFound, int numEmailsFound){
		if (usersFound(numUsersFound))
			user.setErrorUser();
		if(emailsFound(numEmailsFound))
			user.setErrorEmail();
	}
	
	private void addUserToDB(DAO database, BeanUser user) throws  SQLException, ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = format.parse(user.getBirth());
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		String query = "INSERT INTO USER(username, password, email, name, surname, gender, birth)" +
		"VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail() +
		"' ,'" + user.getName() + "', '" + user.getSurname() + "', '" + user.getGender() + "', '"+sqlDate+"')";
		database.updateSQL(query);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public boolean doRegister(HttpServletRequest request) throws ServletException, IOException {
		DAO database = new DAO();
		BeanUser user = new BeanUser();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			ResultSet usersWithSameNameFound = database.executeSQL("SELECT username FROM USER WHERE username LIKE '" + user.getUsername() +"'");
			int numUsersFound = DBOperations.getSizeResultSet(usersWithSameNameFound);
			ResultSet equalEmailsFound = database.executeSQL("SELECT email FROM USER WHERE email LIKE '" + user.getEmail() + "'");
			int numEmailsFound = DBOperations.getSizeResultSet(equalEmailsFound);
			
			// Existe alguna query con el mismo nombre de usuario o email.
			if (usersOrEmailsFound(numUsersFound, numEmailsFound)) {
				addInfoErrorsToBeanUser(user, numUsersFound, numEmailsFound); // Insertamos la info del usuario.
				request.setAttribute("user", user);
			}
			else{
				addUserToDB(database, user); // Si todo está correcto insertamos el usuario en la base de datos.
				SessionFunctions.createSession(request, user.getUsername());
				return true;
			}
		}
		catch (IllegalAccessException | SQLException | ParseException | InvocationTargetException e){
			e.printStackTrace();
		}
		return false;
	}
}
