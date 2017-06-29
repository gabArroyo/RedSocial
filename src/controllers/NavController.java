package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.BeanSession;
import utils.SessionFunctions;

/**
 * Servlet implementation class ContentController
 */
@WebServlet("/NavController")
public class NavController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		RequestDispatcher dispatcher = null;
		
		if (SessionFunctions.sessionDefined(session)){
			String content = (String)request.getParameter("action");
			if(content != null){
				String userType = ((BeanSession)session.getAttribute("user")).getUserType();
				if(userType.compareTo("admin") == 0)
					dispatcher = request.getRequestDispatcher("ViewNavAdminCategories.jsp");
				else
					dispatcher = request.getRequestDispatcher("ViewNavUserCategories.jsp");
			}
			else
				dispatcher = request.getRequestDispatcher("ViewNavLogged.jsp");
		}
		else
			dispatcher = request.getRequestDispatcher("ViewNavNotLogged.jsp");
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
