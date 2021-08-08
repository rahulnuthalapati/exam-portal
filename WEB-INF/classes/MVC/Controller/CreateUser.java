package MVC.Controller;
import MVC.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CreateUser extends HttpServlet //throws IOException,ServletException,Exception
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) //throws IOException //,Exception
	{
		String user_ = request.getParameter("userName");
		String password_ = request.getParameter("password");
		UserCheck uc = new UserCheck();
		try{
		String result = uc.createuser(user_,password_);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(!(result.equals("Already taken")))
		{
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><body><br><br><br><br><br><br><br><br><br><h2></h2>");
			out.println("<p>User created</p></form></body></html>");
		}
		else
		{
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><body><br><br><br><br><br><br><br><br><br>");
			out.println("<h2>Enter Details</h2><p>User id was already taken</p><section class=reg><form action=createuser method=post><label for=name>Name:</label><br>");
  			out.println("<input type=text id=userName name=userName><br><br><br>");
			out.println("<label for=name>Password:</label><br><input type=text id=password name=password><br>");
			out.println("<br><br><br><input type=submit value=Next></form></section></body></html>");
		}
		
		
		}
		catch(Exception E){System.out.println(E);}
	}
}		

