package com.briup.estore.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.service.implement.BaseDaoImpl;
import com.briup.estore.service.implement.RegisterServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String telephone;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	 * @param email 
	 * @param address 
	 * @param service 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RegisterServiceImpl service=new RegisterServiceImpl();
		//1.接收参数
				request.setCharacterEncoding("UTF-8");
				BaseDaoImpl baseDaoImpl=new BaseDaoImpl();
				//long id = baseDaoImpl.getCustomerId();
				String name = request.getParameter("userid");
				String password=request.getParameter("password");
				String password2 = request.getParameter("password2");
				String country = request.getParameter("country");
				String province = request.getParameter("province");
				String city = request.getParameter("city");
				String street1 = request.getParameter("street1");
				String street2 = request.getParameter("street2");
				String zip = request.getParameter("zip");
				String homephone = request.getParameter("homephone");
				String officephone = request.getParameter("officephone");
				String cellphone = request.getParameter("cellphone");
				String email = request.getParameter("email");
				String reset = request.getParameter("reset");
				String address=country+province+"省"+city+"市"+street1;
/*//				2.封装对象
				Customer customer=new Customer();
				customer.setId(id);
				//customer.setId(id);
			    customer.setAddress(country+province+city);
			    customer.setName(name);
			    //customer.setId(userid);
			    customer.setPassword(password);
			    customer.setEmail(email);
			    customer.setZip(zip);
			    customer.setTelephone(cellphone);
			    //System.out.println(customer);
			     * 
*/		
				Customer customer=new Customer(null, name, password, zip, address, cellphone, email,null);
				try {
					service.register(customer);
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				} catch (CustomerException e) {
					// TODO Auto-generated catch block
					request.getRequestDispatcher("register.jsp").forward(request, response);
					e.printStackTrace();
				}
				
			}

	}


