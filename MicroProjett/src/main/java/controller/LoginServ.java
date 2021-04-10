package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ConnectDB;
import javax.servlet.RequestDispatcher;


/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("email");
		String password = request.getParameter("motdepasse");
		Boolean ver = false;
		ConnectDB con = new ConnectDB();
		try {
			ver = con.verifyLogin(login, password);
			System.out.println(ver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ver == true) {
			System.out.println("login true");
			
		}else {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
			    dispatcher.forward(request, response);
			   
		}
		
		String fullname=null;
		try {
			fullname = con.getUsername(login);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		HttpSession session = request.getSession();
		session.setAttribute("fullname", fullname);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/acceuil1.jsp");
	    dispatcher.forward(request, response);
		con.fermeBase();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
