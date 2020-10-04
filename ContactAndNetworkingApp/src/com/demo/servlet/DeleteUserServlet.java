package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.bean.User;
import com.demo.service.AdminService;
import com.demo.service.AdminServiceImpl;

/**
 * Servlet implementation class DeleteUserServlet
 */
//@WebServlet("/deleteuser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		Integer flag=(Integer)session.getAttribute("disable_flag");
		if(flag==null) {
			session.setAttribute("disable_flag", Integer.parseInt(request.getParameter("disable_flag")));
		}

		String role=(String) session.getAttribute("role");
		//check for valid user
			flag=(Integer)session.getAttribute("disable_flag");

			AdminService adminService=new AdminServiceImpl();

			
			
			// Condition for delete has to be written based on Date 
			
			
			
			/*			List<User> ulist=adminService.getByDisabledUser();
			request.setAttribute("ulist",ulist);
*/			
			RequestDispatcher rd=request.getRequestDispatcher("DeleteUser.jsp");
			rd.forward(request, response);	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
