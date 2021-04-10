package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Clients;
import model.ConnectDB;

/**
 * Servlet implementation class InscrireServ
 */
@WebServlet("/InscrireServ")
public class InscrireServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscrireServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Clients cl = new Clients(request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("adresse"),request.getParameter("ville"),Integer.parseInt(request.getParameter("codepostal")),request.getParameter("email"),request.getParameter("password"),request.getParameter("tel"));
		ConnectDB con = new ConnectDB();
	
			try {
				con.getConnection();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		try {
			con.addUser(cl);
			System.out.println("User Added Successfuly");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String login = request.getParameter("email");

		String fullname = null;
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
