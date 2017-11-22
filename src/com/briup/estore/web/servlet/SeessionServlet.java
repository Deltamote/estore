package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.security.util.Password;

/**
 * Servlet implementation class SeessionServlet
 */
public class SeessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param qq 
	 * @param Password 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, Object qq, Object Password) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		session.setAttribute("name", qq);
		session.setAttribute("444444", Password);
		}

	/**
	 * @param qq 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, Object qq) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
