package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.CustomerService;
import model.Customer;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService service = CustomerService.getInstance();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		

		Customer customer_login = service.login(id,password);

		String page;
		
		if(customer_login==null){
			page="/view/loginFail.jsp";
			request.setAttribute("id", id);
		}
		else{
			page="/view/loginsuccess.jsp";
			request.setAttribute("customer", customer_login);
		}
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
	}

}
