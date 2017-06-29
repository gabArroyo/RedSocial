package admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private AdminModel adminModel = null;

  public AdminController() {
    super();
    adminModel = new AdminModel();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession(false);
    String content = (String) request.getParameter("controller");
    String actionId = (String) request.getParameter("action");


    if (content == null) {
      content = "";
    }
    RequestDispatcher dispatcher = null;
    switch (content) {
      case "updateUser":
        adminModel.updateUser(request);
        adminModel.getUsers(request);
        dispatcher = request.getRequestDispatcher("ViewAdminPanelUsers.jsp");
        break;
      case "updateTweet":
        adminModel.updateTweet(request);
        adminModel.getLastTweets(request);
        dispatcher = request.getRequestDispatcher("ViewAdminPanelTweets.jsp");
        break;
      case "editUser":
        adminModel.getUser(request, Integer.parseInt(actionId));
        dispatcher = request.getRequestDispatcher("ViewAdminPanelEditUser.jsp");
        break;
      case "removeUser":
        boolean isOk = adminModel.deleteUser(Integer.parseInt(actionId));
        adminModel.getUsers(request);
        dispatcher = request.getRequestDispatcher("ViewAdminPanelUsers.jsp");
        break;
      case "editTweet":
        adminModel.getTweet(request, Integer.parseInt(actionId));
        dispatcher = request.getRequestDispatcher("ViewAdminPanelEditTweet.jsp");
        break;
      case "removeTweet":
        adminModel.deleteTweet(Integer.parseInt(actionId));
        adminModel.getLastTweets(request);
        dispatcher = request.getRequestDispatcher("ViewAdminPanelTweets.jsp");
        break;
      case "users":
        //boolean success = adminModel.getUsers(request);
        adminModel.getUsers(request);
        dispatcher = request.getRequestDispatcher("ViewAdminPanelUsers.jsp");
        break;
      case "tweets":
        adminModel.getLastTweets(request);
        dispatcher = request.getRequestDispatcher("ViewAdminPanelTweets.jsp");
        break;
      default:
        adminModel.getStats(request);
        dispatcher = request.getRequestDispatcher("ViewAdminPanelDashboard.jsp");
    }
    dispatcher.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}


