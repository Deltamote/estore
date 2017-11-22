package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.service.implement.BaseDaoImpl;
import com.briup.estore.service.implement.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @param login 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
             LoginServiceImpl service=new LoginServiceImpl();
             request.setCharacterEncoding("UTF-8");
             BaseDaoImpl baseDaoImpl=new BaseDaoImpl();
             
             String name=request.getParameter("userid");
             String password = request.getParameter("password");
             
             Customer customer=new Customer();
             customer.getName();
             customer.getPassword();
         	try {
				
				Customer customer2 = service.login(name, password);
				String name2 = customer2.getName();
				String password2 = customer2.getPassword();
				System.out.println(password2);
				System.out.println(password);
//				4.跳转页面
				if(name2 != null && password2 != null && password.trim().equals(password2)){
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
