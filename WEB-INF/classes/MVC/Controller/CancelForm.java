package MVC.Controller;
import MVC.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CancelForm extends HttpServlet 
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	{
		try{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();		
			String u=request.getParameter("uname");
			String p=request.getParameter("password");
			UserCheck uc = new UserCheck();

			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><head><style>table,th,td {border: 1px solid black;border-collapse:collapse;} table.center {margin-left: auto;margin-right: auto;} * {text-align:center;}</style></head><body><h1>"+u+"<h1><br><br><br><br><br><br><br><br><br><br>");
			out.println("<form action=cancelform method=post>");
			out.println("<input type=submit value=\"Confirm unregister\"");
			out.println("</form></body></html>");
			uc.resetStatus(u);
			/*uc.delCurrUser(u); */
			return;
		}
		catch(Exception E){System.out.println(E);return;}
	}
}			