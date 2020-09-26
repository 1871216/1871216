package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Customer;
import service.CustomerService;

@WebServlet("/doRegister")
public class DoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoRegister() {
		super();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 							    throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");

		CustomerService service = (CustomerService) CustomerService.getInstance();
		Customer customer = new Customer(id, password, name, gender, email);

		service.addCustomer(customer);

		String page;

		
		if (customer == null || id.isEmpty() || password.isEmpty() || name.isEmpty() 							    || gender.isEmpty() || email.isEmpty()) {
			request.setAttribute("id", id);
			page = "/view/error.jsp";
		}
		else {
			request.setAttribute("customer", customer);
			page = "/view/RegisterSuccess.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

}