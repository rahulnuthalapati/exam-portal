package MVC.Controller;
import MVC.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Internals extends HttpServlet //throws IOException,ServletException,Exception
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) //throws IOException //,Exception
	{
		String user_ = request.getParameter("userName");
		String password_ = request.getParameter("password");
		String ci = request.getParameter("course");
		String att = request.getParameter("attendance");
		String m = request.getParameter("marks");
		UserCheck uc = new UserCheck();
		try{
		String result = uc.addInternals(user_,ci,att,m);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(result.equals("Not found"))
		{
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><body><br><br><br><br><br><br><br><br><br><h2></h2>");
			out.println("<p>User not found</p></form></body></html>");
		}
		else
		{			
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><body><br><br><br><br><br><br><br><br><br>");
			out.println("<h2></h2><p>Record added</p></body></html>");
		}
		
		}
		catch(Exception E){System.out.println(E);}
	}
}		

