package MVC.Controller;
import MVC.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class AdminValidate extends HttpServlet //throws IOException,ServletException,Exception
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) //throws IOException //,Exception
	{
		String user_ = request.getParameter("userName");
		String password_ = request.getParameter("password");
		UserCheck uc = new UserCheck();
		try{
		String result = uc.admincheck(user_,password_);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(result.equals("Password Incorrect!"))
		{
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><body><br><br><br><br><br><br><br><br><br>");
			out.println("<h2>Enter Login Details</h2><section class=reg><form action=valadmin method=post><label for=name>Username:</label>");
  			out.println("<input type=text id=userName name=userName value=" + user_ +"><br><br><br>");
			out.println("<label for=name>Password:</label><input type=text id=password name=password>");
			out.println("<p>Incorrect password was entered before. Make sure to enter correct password!</p>");
			out.println("<br><br><br><input type=submit value=Continue></form></section></body></html>");
		}
		else if(result.equals("Invalid login!"))
		{
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><body><br><br><br><br><br><br><br><br><br>");
			out.println("<h2>Enter Login Details</h2><p>Invalid login before.Enter valid username and password</p><section class=reg><form action=valadmin method=post><label for=name>Username:</label><br>");
  			out.println("<input type=text id=userName name=userName><br><br><br>");
			out.println("<label for=name>Password:</label><br><input type=text id=password name=password><br>");
			out.println("<br><br><br><input type=submit value=Next></form></section></body></html>");
		}
		else
		{
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><body><br><br><br><br><br><br><br><br><br><h2>Logged in Successfully as "+user_+"!</h2>");
			out.println("<form action=validate method=post>");
			out.println("Username:");
  			out.println("<input type=text id=userName name=userName><br>");
			out.println("Password:");
  			out.println("<input type=text id=password name=password><br>");
  			out.println("Course id:");
  			out.println("<input type=text id=course name=course><br>");
  			out.println("Attendance:");
  			out.println("<input type=text id=attendance name=attendance><br>");
  			out.println("Marks:");
  			out.println("<input type=text id=marks name=marks><br><br>");
			out.println("<input type=submit value=\"Register new User\" formaction=createuser formmethod=post>");
			out.println("<input type=submit value=\"Add Record\" formaction=internals formmethod=post>");
			out.println("<input type=submit value=\"Display all Users\" formaction=showusers formmethod=post></form></body></html>");
		}
		}
		catch(Exception E){System.out.println(E);}
	}
}		

