package MVC.Controller;
import MVC.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class UserValidate extends HttpServlet //throws IOException,ServletException,Exception
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) //throws IOException //,Exception
	{
		HttpSession session = request.getSession(true);

		String user_ = request.getParameter("userName");
		String password_ = request.getParameter("password");
		
		Cookie us = new Cookie("user~session",user_+"~"+session.getId()); 
		us.setMaxAge(60*60*24);

		response.addCookie(us);
		System.out.println("UserValidate "+us.getValue());

		UserCheck uc = new UserCheck();
		try{
		String result = uc.usercheck(user_,password_);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(result.equals("Password Incorrect!"))
		{
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><body><br><br><br><br><br><br><br><br><br>");
			out.println("<h2>Enter Login Details to take Exam:</h2><section class=reg><form action=validate method=post><label for=name>Username:</label>");
  			out.println("<input type=text id=userName name=userName value=" + user_ +"><br>");
			out.println("<label for=name>Password:</label><input type=text id=password name=password>");
			out.println("<p>Incorrect password was entered. Make sure to enter correct password!</p>");
			out.println("<br><input type=submit value=Login></form></section></body></html>");
		}
		else if(result.equals("Invalid login!"))
		{
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><body><br><br><br><br><br><br><br><br><br>");
			out.println("<h2>Enter Login Details to take Exam:</h2><p>Invalid login. Enter valid username and password</p><section class=reg><form action=validate method=post><label for=name>Username:</label>");
  			out.println("<input type=text id=userName name=userName><br>");
			out.println("<label for=name>Password:</label><input type=text id=password name=password>");
			out.println("<br><br><br><input type=submit value=Next></form></section></body></html>");
		}
		else
		{
			//uc.addCurrUser(user_,session.getId());
			out.println("<html><style>");
			RequestDispatcher rd = request.getRequestDispatcher("styles/style.css");
			rd.include(request,response);
			out.println("</style><h1>Dashboard</h1><br><br><br><br><br><br><br><br><br><h2>Logged in Successfully as "+user_+"!</h2>");
			out.println("<div class='element-margin'><form action=dispuser method=post>");
			out.print("<input type='hidden' name='uname' value='"+user_+"'>");
			out.print("<input type='hidden' name='password' value='"+password_+"'>");
			out.println("<input type=submit value=\"Check Account details\"></form></div>");

			out.println("<div class='element-margin'><form action=fillform method=post>");
			out.print("<input type='hidden' name='uname' value='"+user_+"'>");
			out.print("<input type='hidden' name='password' value='"+password_+"'>");
			out.println("<input type=submit value=\"Register for Exam\"></form></div>");

			out.println("<div class='element-margin'><form action=showhalltkt method=post>");
			out.print("<input type='hidden' name='uname' value='"+user_+"'>");
			out.print("<input type='hidden' name='password' value='"+password_+"'>");
			out.println("<input type=submit value=\"Show Hallticket\"></form></div>");

			out.println("<div class='element-margin'><form action=cancelform method=post>");
			out.print("<input type='hidden' name='uname' value='"+user_+"'>");
			out.print("<input type='hidden' name='password' value='"+password_+"'>");
			out.println("<input type=submit value=\"Cancel Registartion\"></form></div></html>");
		}
		}
		catch(Exception E){System.out.println(E);}
	}
}		

