package MVC.Controller;
import MVC.Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ExamForm extends HttpServlet 
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
			out.println("</style><body style='font-size:20px'><h1>Exam Registration Form</h1><p>Logged in User:<p>"+u+"<p><br><br><br>");
			List result = uc.returnUserDetails(u);
			Iterator<String> it = result.iterator();
			out.println("<p>Select Courses to register for exam:</p>");
			out.println("<form action=payment method=post>");
			while(it.hasNext()) {
				String[] arr = it.next().split("~", 6);
				out.println("<input type=checkbox name=chkbx" + " value=\'" + arr[2] + " " + arr[3] +"\'>" + arr[2] + " " + arr[3] + "<br>");
			}
			out.print("<input type='hidden' name='uname' value='"+u+"'>");
			out.print("<input type='hidden' name='password' value='"+p+"'>");
			out.println("<input type=submit value=\"Confirm courses\">");
			out.println("</form></body></html>");
			/*uc.delCurrUser(u); */
			return;
		}
		catch(Exception E){System.out.println(E);return;}
	}
}			