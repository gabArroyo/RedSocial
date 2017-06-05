package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.LoginModel;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginModel loginModel = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        loginModel = new LoginModel();
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean successfulLogin = loginModel.doLogin(request);
		RequestDispatcher dispatcher = null;
		if(successfulLogin)
			dispatcher = request.getRequestDispatcher("ViewUserHome.jsp");
		else
			dispatcher = request.getRequestDispatcher("ViewLoginForm.jsp");
		dispatcher.forward(request, response);	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
