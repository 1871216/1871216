package controller;

import java.io.IOException;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Customer;
import service.CustomerService;


@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoLogin() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
							    throws ServletException, IOException {

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String page = null;

		if (id.isEmpty() || password.isEmpty())
			page = "/view/error.jsp";
		else {
			
			CustomerService service = (CustomerService)CustomerService.getInstance();
			Customer customer = service.login(id, password);

			
			if (customer == null) {
				request.setAttribute("id", id);
				page = "/view/loginFail.jsp";
			} else {
				customer = service.findCustomer(id);
				request.setAttribute("customer", customer);
				page = "/view/LoginSuccess.jsp";
			}

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}

